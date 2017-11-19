public class BouncingArena extends Arena {

    @Override
    /**
     * moves an ArenaItem
     * now with bouncing
     * @param i the item
     * @return
     */
    public double move(ArenaItem i){
        int x = (int)( i.getxLocation() + getDistance(getTimeChange(), i.getxSpeed(), i.getxAcceleration()));
        int y = (int)(i.getyLocation() + getDistance(getTimeChange(), i.getySpeed(), i.getyAcceleration()));

        if (inRange(x, y, i.getRadius())){
            i.setTempxLocation(x);
            i.setTempyLocation(y);
            i.setTempxSpeed(i.getxSpeed()+ getTimeChange() * i.getxAcceleration());
            i.setTempySpeed(i.getySpeed()+ getTimeChange() * i.getyAcceleration());
            return getTimeChange();
        }else{
            handleOver(x, y,i);
            return getTimeChange();
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

    /**
     * Handles the Out of range cases
     * @param x the x location the item is moving to
     * @param y the y location the item is moving to
     * @param i the item
     */
    void handleOver(int x, int y, ArenaItem i) {
        if (x + i.getRadius() > getWidth()) {
//            System.out.println("Case 1");
            double time = getTime(getWidth() - i.getRadius() - i.getxLocation(), i.getxSpeed(), i.getxAcceleration());
            double speed2 = i.getxSpeed() + time * i.getxAcceleration();

            i.setTempxLocation((int)(getWidth() - i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getxAcceleration())));
            i.setTempxSpeed(-speed2 + (getTimeChange() - time) * i.getxAcceleration());

        } else if (x < i.getRadius()) {
//            System.out.println("Case 2");

            double time = getTime( i.getRadius() - i.getxLocation(), i.getxSpeed(), i.getxAcceleration());
            double speed2 = i.getxSpeed() + time * i.getxAcceleration();
            i.setTempxLocation((int)(i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getxAcceleration())));
            i.setTempxSpeed(-speed2 + (getTimeChange() - time) * i.getxAcceleration());

        } else {
            i.setTempxLocation(x);
            i.setTempxSpeed(i.getxSpeed() + getTimeChange() * i.getxAcceleration());
        }

        if (y + i.getRadius() > getHeight()) {

//            System.out.println("Case 3");
            double time = getTime( getHeight() - i.getRadius()  - i.getyLocation(), i.getySpeed(), i.getyAcceleration());
            double speed2 = i.getySpeed() + time * i.getyAcceleration();
            i.setTempyLocation((int)(getHeight() - i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getyAcceleration())));
            i.setTempySpeed(-speed2 + (getTimeChange() - time) * i.getyAcceleration());

        } else if (y < i.getRadius()) {
//            System.out.println("Case 4");
            double time = getTime( i.getRadius() - i.getyLocation(), i.getySpeed(), i.getyAcceleration());
            double speed2 = i.getySpeed() + time * i.getyAcceleration();
            i.setTempyLocation((int)(i.getRadius() + Arena.getDistance((getTimeChange() - time), -speed2, i.getyAcceleration())));
            i.setTempySpeed(-speed2 + (getTimeChange() - time) * i.getyAcceleration());

        } else {
            i.setTempyLocation(y);
            i.setTempySpeed(i.getySpeed() + getTimeChange() * i.getyAcceleration());
        }
    }

    /**
     * gets the time to travel delta Distance with starting speed and constant acceleration
     * @param deltaDistance the change in distance
     * @param speed the starting speed
     * @param acceleration the constant acceration
     * @return the time taken
     */
    double getTime(double deltaDistance, double speed, double acceleration){
        if (acceleration != 0) {
            double A1 = (speed - (double) Math.sqrt(Math.pow((double) speed, 2.0) +  2 * acceleration * deltaDistance)) / acceleration;
            double A2 = (speed + (double) Math.sqrt(Math.pow((double) speed, 2.0) + 2 * acceleration * deltaDistance)) / acceleration;
            if (A1 > 0 && A1 < getTimeChange() && A2 > 0 && A2 < getTimeChange()) {
                return Math.min(A1, A2);
            } else if (A1 > 0 && A1 < getTimeChange()) {
                return A1;
            }else{
                return A2;
            }
        }else {
            return deltaDistance / speed;
        }

    }
}
