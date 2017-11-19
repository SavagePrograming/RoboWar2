import java.util.ArrayList;

public class ColisionArena extends BouncingArena{

    @Override
    public void update() {
        double timeRemaining = getTimeChange();
//        System.out.println("Started");
        while (timeRemaining > 0){

            ArrayList<Double> colideTimes = new ArrayList<>();
            ArrayList<ArenaItem> colideFirstItems = new ArrayList<>();
            ArrayList<ArenaItem> colideSecondItems = new ArrayList<>();
            for (ArenaItem item: getItems()){
                addMinColision(item, colideTimes, colideFirstItems, colideSecondItems);
            }
            if (colideTimes.size() > 0){
                double time = getMin(colideTimes);
//                System.out.println(time + " " + timeRemaining);
                ArenaItem item1 = colideFirstItems.get(colideTimes.indexOf(time));
                ArenaItem item2 = colideSecondItems.get(colideTimes.indexOf(time));
                timeRemaining -= time;

                for (ArenaItem i: getItems()){
                    move(i, time);
                }
                colide(item1, item2);
            }else{
                for (ArenaItem i: getItems()){
                    move(i, timeRemaining);

                }
                timeRemaining = 0;
            }



            for (ArenaItem item: getItems()){
                item.update();
            }
        }
//        System.out.println("finished");
        super.setChanged();
        super.notifyObservers();
    }


    private void colide(ArenaItem item1, ArenaItem item2){
        double distance = item1.getRadius() + item2.getRadius();
        double xDistance = item1.getxLocation() - item2.getxLocation();
        double yDistance = item1.getyLocation() - item2.getyLocation();
        double sinTheta = xDistance / distance;
        double cosTheta = yDistance / distance;
        item1.setTempxSpeed(item1.getxSpeed() - item1.getxSpeed() * cosTheta - cosTheta * (sinTheta * item2.getySpeed() + cosTheta * item2.getxSpeed()) );
        item1.setTempySpeed(item1.getySpeed() - item1.getySpeed() * sinTheta - sinTheta * (sinTheta * item2.getySpeed() + cosTheta * item2.getxSpeed()) );
        item2.setTempxSpeed(item2.getxSpeed() + item2.getxSpeed() * cosTheta - cosTheta * (sinTheta * item2.getySpeed() + cosTheta * item2.getxSpeed()) );
        item2.setTempySpeed(item2.getySpeed() + item2.getySpeed() * sinTheta - sinTheta * (sinTheta * item2.getySpeed() + cosTheta * item2.getxSpeed()) );
    }
    /**
     * moves an ArenaItem
     * now with bouncing
     * @param i the item
     * @return
     */
    public double move(ArenaItem i, double time){
        int x = (int)(i.getxLocation() + getDistance(time, i.getxSpeed(), i.getxAcceleration()));
        int y = (int)(i.getyLocation() + getDistance(time, i.getySpeed(), i.getyAcceleration()));

        if (inRange(x, y, i.getRadius())){
            i.setTempxLocation(x);
            i.setTempyLocation(y);
            i.setTempxSpeed(i.getxSpeed()+ time * i.getxAcceleration());
            i.setTempySpeed(i.getySpeed()+ time * i.getyAcceleration());
            return time;
        }else{
            handleOver(x, y,i);
            return time;
        }
    }

    public void addMinColision(ArenaItem item, ArrayList<Double> colideTimes,
                               ArrayList<ArenaItem> colideFirstItems, ArrayList<ArenaItem> colideSecondItems){
        ArrayList<Double> colideTimes2 = new ArrayList<>();
        ArrayList<ArenaItem> colideItems2 = new ArrayList<>();
        for (ArenaItem e: getItems()){
            if (!e.equals(item)) {
                double time = getColisionTime(item, e);
                if (time >= 0){
                    colideTimes2.add(time);
                    colideItems2.add(e);
                }
            }
        }
        if (colideItems2.size() > 0) {
            if (getMin(colideTimes2) <= getTimeChange()) {
                double time = getMin(colideTimes2);
                colideTimes.add(time);
//                System.out.println(colideTimes2);
//                System.out.println(colideItems2);
//                System.out.println(colideTimes2.indexOf(time));
                colideSecondItems.add(colideItems2.get(colideTimes2.indexOf(time)));
                colideFirstItems.add(item);
            }
        }
    }


    /**
     * Tests if an coordinate pair is in the arena
     * @param x target x location
     * @param y target y location
     * @return true if in. false if out
     */
    public boolean inRange(int x, int y, int radius){
        return 0 <= x - radius && x + radius <= this.getWidth() && 0  <= y - radius && y + radius<= this.getHeight();
    }

//    /**
//     * Handles the Out of range cases
//     * @param x the x location the item is moving to
//     * @param y the y location the item is moving to
//     * @param i the item
//     */
//    private void handleOver(int x, int y, ArenaItem i) {
//        if (x + i.getRadius() > getWidth()) {
////            System.out.println("Case 1");
//            double time = getTime(getWidth() - i.getRadius() - i.getxLocation(), i.getxSpeed(), i.getxAcceleration());
//            double speed2 = i.getxSpeed() + time * i.getxAcceleration();
//
//            i.setTempxLocation((int)(getWidth() - i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getxAcceleration())));
//            i.setTempxSpeed(-speed2 + (getTimeChange() - time) * i.getxAcceleration());
//
//        } else if (x < i.getRadius()) {
////            System.out.println("Case 2");
//
//            double time = getTime( i.getRadius() - i.getxLocation(), i.getxSpeed(), i.getxAcceleration());
//            double speed2 = i.getxSpeed() + time * i.getxAcceleration();
//            i.setTempxLocation((int)(i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getxAcceleration())));
//            i.setTempxSpeed(-speed2 + (getTimeChange() - time) * i.getxAcceleration());
//
//        } else {
//            i.setTempxLocation(x);
//            i.setTempxSpeed(i.getxSpeed() + getTimeChange() * i.getxAcceleration());
//        }
//
//        if (y + i.getRadius() > getHeight()) {
//
////            System.out.println("Case 3");
//            double time = getTime( getHeight() - i.getRadius()  - i.getyLocation(), i.getySpeed(), i.getyAcceleration());
//            double speed2 = i.getySpeed() + time * i.getyAcceleration();
//            i.setTempyLocation((int)(getHeight() - i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getyAcceleration())));
//            i.setTempySpeed(-speed2 + (getTimeChange() - time) * i.getyAcceleration());
//
//        } else if (y < i.getRadius()) {
////            System.out.println("Case 4");
//            double time = getTime( i.getRadius() - i.getyLocation(), i.getySpeed(), i.getyAcceleration());
//            double speed2 = i.getySpeed() + time * i.getyAcceleration();
//            i.setTempyLocation((int)(i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getyAcceleration())));
//            i.setTempySpeed(-speed2 + (getTimeChange() - time) * i.getyAcceleration());
//
//        } else {
//            i.setTempyLocation(y);
//            i.setTempySpeed(i.getySpeed() + getTimeChange() * i.getyAcceleration());
//        }
//    }

//    /**
//     * gets the time to travel delta Distance with starting speed and constant acceleration
//     * @param deltaDistance the change in distance
//     * @param speed the starting speed
//     * @param acceleration the constant acceration
//     * @return the time taken
//     */
//    private double getTime(double deltaDistance, double speed, double acceleration){
//        if (acceleration != 0) {
//            double A1 = (speed - (double) Math.sqrt(Math.pow((double) speed, 2.0) + acceleration * deltaDistance)) / acceleration;
//            double A2 = (speed + (double) Math.sqrt(Math.pow((double) speed, 2.0) + acceleration * deltaDistance)) / acceleration;
//            if (A1 > 0 && A1 < getTimeChange()) {
//                return A1;
//            } else {
//                return A2;
//            }
//        }else {
//            return deltaDistance / speed;
//        }
//
//    }
    
    private double getColisionTime(ArenaItem one, ArenaItem two){
        double xtime = Math.pow((double) one.getxSpeed() - two.getxSpeed(), 2.0) + (one.getxAcceleration() - two.getxAcceleration()) * (one.getxLocation() - two.getxLocation());
        double ytime = Math.pow((double) one.getySpeed() - two.getySpeed(), 2.0) + (one.getyAcceleration() - two.getyAcceleration()) * (one.getyLocation() - two.getyLocation());
        if (ytime >= 0 && xtime >= 0){
            xtime = getTime(one.getxSpeed() - two.getxSpeed(),one.getxAcceleration() - two.getxAcceleration(), one.getxLocation() - two.getxLocation());
            ytime = getTime(one.getySpeed() - two.getySpeed(),one.getyAcceleration() - two.getyAcceleration(), one.getyLocation() - two.getyLocation());
            if (Math.abs(xtime - ytime) < .00001){
                return xtime;
            }
        }
        return -1.0;


    }

//    /**
//     * gets the time to travel delta Distance with starting speed and constant acceleration
//     * @param deltaDistance the change in distance
//     * @param speed the starting speed
//     * @param acceleration the constant acceration
//     * @return the time taken
//     */
//    private double getTime(double deltaDistance, double speed, double acceleration){
//        if (acceleration != 0) {
//            double A1 = (speed - (double) Math.sqrt(Math.pow((double) speed, 2.0) + acceleration * deltaDistance)) / acceleration;
//            double A2 = (speed + (double) Math.sqrt(Math.pow((double) speed, 2.0) + acceleration * deltaDistance)) / acceleration;
//            if (A1 > 0 && A1 < getTimeChange() && A2 > 0 && A2 < getTimeChange()) {
//                return Math.min(A1, A2);
//            } else if (A1 > 0 && A1 < getTimeChange()) {
//                return A1;
//            }else{
//                return A2;
//            }
//        }else {
//            return deltaDistance / speed;
//        }
//
//    }
        
    private double getMin(ArrayList<Double> collection){
        if (collection.size() > 0) {
            Double min = null;
            for (Double i : collection) {
                if (min == null) {
                    min = i;
                } else {
                    min = Math.min(i, min);
                }

            }
            return min;
        }else {
            return 0.0;
            }
        }

}
