import javafx.beans.InvalidationListener;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Arenas super class,
 * Arenas are places where arena Items interact
 * @author William Savage
 *
 * Arenas will control the physics
 */
public class Arena extends Observable {
    private int MASS_DEFAULT = ArenaItem.MASS_DEFAULT;
    private int RADIUS_DEFAULT = ArenaItem.RADIUS_DEFAULT;
    private int X_DEFAULT = ArenaItem.X_DEFAULT;
    private int Y_DEFAULT = ArenaItem.Y_DEFAULT;
    private double X_SPEED_DEFAULT = ArenaItem.X_SPEED_DEFAULT;
    private double Y_SPEED_DEFAULT = ArenaItem.Y_SPEED_DEFAULT;
    private double X_ACCELERATION_DEFAULT = ArenaItem.X_ACCELERATION_DEFAULT;
    private double Y_ACCELERATION_DEFAULT = ArenaItem.Y_ACCELERATION_DEFAULT;

    static final int WIDTH = 500;
    static final int HEIGHT = 500;
    static final double TIME_CHANGE = 1;

    private int width;
    private int height;



    private double timeChange;

    private ArrayList<ArenaItem> items;

    private ArrayList<InvalidationListener>  listeners = new ArrayList<InvalidationListener>();



    /**
     * Constructs the default Arenas
     */
    public Arena(){
        this.height = HEIGHT;
        this.width = WIDTH;
        this.timeChange = TIME_CHANGE;
        items = new ArrayList<ArenaItem>();

    }

    /**
     * Constructs an Arenas
     * @param width the height of the Arenas
     * @param height the width of the Arenas
     */
    public Arena(int width, int height){
        this.height = height;
        this.width = width;
        this.timeChange = TIME_CHANGE;
    }

    /**
     * Constructs an Arenas
     * @param width the height of the Arenas
     * @param height the width of the Arenas
     * @param items the items in the Arenas
     */
    public Arena(int width, int height, ArrayList<ArenaItem> items){
        this.height = height;
        this.width = width;
        this.items = items;
        this.timeChange = TIME_CHANGE;
    }


    /**
     *  Constructs an Arenas
     * @param height the height of the Arenas
     * @param width the width of the Arenas
     * @param MASS_DEFAULT Mass default for the Arenas
     * @param RADIUS_DEFAULT radius default for the Arenas
     * @param X_DEFAULT x location default for the Arenas
     * @param Y_DEFAULT y location default for the Arenas
     * @param X_SPEED_DEFAULT x speed default for the Arenas
     * @param Y_SPEED_DEFAULT y speed default for the Arenas
     * @param X_ACCELERATION_DEFAULT x acceleration default for the Arenas
     * @param Y_ACCELERATION_DEFAULT y acceleration default for the Arenas
     */
    public Arena(int width, int height, int MASS_DEFAULT, int RADIUS_DEFAULT , int X_DEFAULT,
                 int Y_DEFAULT, double X_SPEED_DEFAULT, double Y_SPEED_DEFAULT, double X_ACCELERATION_DEFAULT,
                 double Y_ACCELERATION_DEFAULT){
        this.height = height;
        this.width = width;
        this.timeChange = TIME_CHANGE;
        this.MASS_DEFAULT = MASS_DEFAULT;
        this.RADIUS_DEFAULT = RADIUS_DEFAULT;
        this.X_DEFAULT = X_DEFAULT;
        this.Y_DEFAULT = Y_DEFAULT;
        this.X_SPEED_DEFAULT = X_SPEED_DEFAULT;
        this.Y_SPEED_DEFAULT = Y_SPEED_DEFAULT;
        this.X_ACCELERATION_DEFAULT = X_ACCELERATION_DEFAULT;
        this.Y_ACCELERATION_DEFAULT = Y_ACCELERATION_DEFAULT;
        items = new ArrayList<ArenaItem>();
    }

    /**
     *  Constructs an Arenas
     * @param height the height of the Arenas
     * @param width the width of the Arenas
     * @param MASS_DEFAULT Mass default for the Arenas
     * @param RADIUS_DEFAULT radius default for the Arenas
     * @param X_DEFAULT x location default for the Arenas
     * @param Y_DEFAULT y location default for the Arenas
     * @param X_SPEED_DEFAULT x speed default for the Arenas
     * @param Y_SPEED_DEFAULT y speed default for the Arenas
     * @param X_ACCELERATION_DEFAULT x acceleration default for the Arenas
     * @param Y_ACCELERATION_DEFAULT y acceleration default for the Arenas
     * @param items the items in the Arenas
     */
    public Arena(int width, int height, ArrayList<ArenaItem> items, int MASS_DEFAULT, int RADIUS_DEFAULT , int X_DEFAULT,
                 int Y_DEFAULT, double X_SPEED_DEFAULT, double Y_SPEED_DEFAULT, double X_ACCELERATION_DEFAULT,
                 double Y_ACCELERATION_DEFAULT) {
        this.height = height;
        this.width = width;
        this.timeChange = TIME_CHANGE;
        this.MASS_DEFAULT = MASS_DEFAULT;
        this.RADIUS_DEFAULT = RADIUS_DEFAULT;
        this.X_DEFAULT = X_DEFAULT;
        this.Y_DEFAULT = Y_DEFAULT;
        this.X_SPEED_DEFAULT = X_SPEED_DEFAULT;
        this.Y_SPEED_DEFAULT = Y_SPEED_DEFAULT;
        this.X_ACCELERATION_DEFAULT = X_ACCELERATION_DEFAULT;
        this.Y_ACCELERATION_DEFAULT = Y_ACCELERATION_DEFAULT;
        this.items = items;
    }

    /**
     * moves an ArenaItem
     * @param i the item
     * @return
     */
    public double move(ArenaItem i){
        int x = (int)(i.getxLocation() + getDistance(timeChange, i.getxSpeed(), i.getxAcceleration()));
        int y = (int)(i.getxLocation() + getDistance(timeChange, i.getySpeed(), i.getyAcceleration()));

        if (inRange(x, y, i.getRadius())){
            i.setxLocation(x);
            i.setyLocation(y);
            i.setxSpeed(i.getxSpeed()+ timeChange * i.getxAcceleration());
            i.setySpeed(i.getySpeed()+ timeChange * i.getyAcceleration());
            return timeChange;
        }else{
            handleOver(x, y,i);
            return timeChange;
        }
    }

    /**
     * Tests if an coordinate pair is in the arena
     * @param x target x location
     * @param y target y location
     * @return true if in. false if out
     */
    public boolean inRange(int x, int y, int radius){
        return 0 <= x - radius && x + radius <= this.width && 0  <= y - radius && y + radius<= this.height;
    }

    /**
     * Handles the Out of range cases
     * @param x the x location the item is moving to
     * @param y the y location the item is moving to
     * @param i the item
     */
    private void handleOver(int x, int y, ArenaItem i) {
        if (x + i.getRadius() > width) {
            i.setxLocation(width - i.getRadius());
            i.setxSpeed(0);

        } else if (x < i.getRadius()) {
            i.setxLocation(i.getRadius());
            i.setxSpeed(0);

        }else {
            i.setxLocation(x);
            i.setxSpeed(i.getxSpeed()+ timeChange * i.getxAcceleration());
        }

        if (y + i.getRadius() > height) {
            i.setyLocation(height - i.getRadius());
            i.setySpeed(0);

        } else if (y < i.getRadius()){
            i.setyLocation(i.getRadius());
            i.setySpeed(0);

        }else{
            i.setyLocation(y);
            i.setySpeed(i.getySpeed()+ timeChange * i.getyAcceleration());
        }

    }

   public static double getDistance(double time, double speed, double acceleration){
        return speed *  time + ((double) Math.pow((double)time, 2.0)) * acceleration;
   }

    /**
     * updates the locations then changes the gui
     */
    public void update(){
        for (ArenaItem item: this.items){
            this.move(item);
            item.run();
        }
//        System.out.println("Tried");
        super.setChanged();
        super.notifyObservers();
//        System.out.println("Done");
    }

    public int getMASS_DEFAULT() {
        return MASS_DEFAULT;
    }

    public int getRADIUS_DEFAULT() {
        return RADIUS_DEFAULT;
    }

    public int getX_DEFAULT() {
        return X_DEFAULT;
    }

    public int getY_DEFAULT() {
        return Y_DEFAULT;
    }

    public double getX_SPEED_DEFAULT() {
        return X_SPEED_DEFAULT;
    }

    public double getY_SPEED_DEFAULT() {
        return Y_SPEED_DEFAULT;
    }

    public double getX_ACCELERATION_DEFAULT() {
        return X_ACCELERATION_DEFAULT;
    }

    public double getY_ACCELERATION_DEFAULT() {
        return Y_ACCELERATION_DEFAULT;
    }

    public ArrayList<ArenaItem> getItems() {
        return items;
    }

    public void add(ArenaItem item){
        this.items.add(item);
    }

    public void remove(ArenaItem item){
        this.items.remove(item);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double getTimeChange() {
        return timeChange;
    }
}
