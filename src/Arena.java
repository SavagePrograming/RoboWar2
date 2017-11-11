import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

import java.util.ArrayList;

/**
 * The Arenas super class,
 * Arenas are places where arena Items interact
 * @author William Savage
 *
 * Arenas will control the physics
 */
public class Arena extends java.util.Observable {
    int MASS_DEFAULT = ArenaItem.MASS_DEFAULT;
    int RADIUS_DEFAULT = ArenaItem.RADIUS_DEFAULT;
    int X_DEFAULT = ArenaItem.X_DEFAULT;
    int Y_DEFAULT = ArenaItem.Y_DEFAULT;
    int X_SPEED_DEFAULT = ArenaItem.X_SPEED_DEFAULT;
    int Y_SPEED_DEFAULT = ArenaItem.Y_SPEED_DEFAULT;
    int X_ACCELERATION_DEFAULT = ArenaItem.X_ACCELERATION_DEFAULT;
    int Y_ACCELERATION_DEFAULT = ArenaItem.Y_ACCELERATION_DEFAULT;

    static final int WIDTH = 500;
    static final int HEIGHT = 500;
    static final int TIME_CHANGE = 1;

    private int width;
    private int hieght;
    private int timeChange;

    private ArrayList<ArenaItem> items;

    private ArrayList<InvalidationListener>  listeners = new ArrayList<InvalidationListener>();



    /**
     * Constructs the default Arenas
     */
    public Arena(){
        this.hieght = HEIGHT;
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
        this.hieght = height;
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
        this.hieght = height;
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
                 int Y_DEFAULT, int X_SPEED_DEFAULT, int Y_SPEED_DEFAULT, int X_ACCELERATION_DEFAULT,
                 int Y_ACCELERATION_DEFAULT){
        this.hieght = height;
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
                 int Y_DEFAULT, int X_SPEED_DEFAULT, int Y_SPEED_DEFAULT, int X_ACCELERATION_DEFAULT,
                 int Y_ACCELERATION_DEFAULT) {
        this.hieght = height;
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
    public int move(ArenaItem i){
        int x = i.getxLocation() + i.getxSpeed() *  timeChange + ((int) Math.pow((double)timeChange, 2.0)) * i.getxAcceleration();
        int y = i.getyLocation() + i.getySpeed() * timeChange + ((int)Math.pow((double)timeChange, 2.0)) * i.getyAcceleration();

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
        return 0 <= x - radius && x + radius <= this.width && 0  <= y - radius && y + radius<= this.hieght;
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

        if (y + i.getRadius() > hieght) {
            i.setyLocation(hieght - i.getRadius());
            i.setySpeed(0);

        } else if (y < i.getRadius()){
            i.setyLocation(i.getRadius());
            i.setySpeed(0);

        }else{
            i.setyLocation(y);
            i.setySpeed(i.getySpeed()+ timeChange * i.getyAcceleration());
        }

    }

    /**
     * gets the time to travel delta Distance with starting speed and constant acceleration
     * @param deltaDistance the change in distance
     * @param speed the starting speed
     * @param acceleration the constant acceration
     * @return the time taken
     */
    private int getTime(int deltaDistance, int speed, int acceleration){
        int A1 = (speed - (int)Math.sqrt(Math.pow((double)speed, 2.0) + acceleration * deltaDistance)) / acceleration;
        int A2 = (speed + (int)Math.sqrt(Math.pow((double)speed, 2.0) + acceleration * deltaDistance)) / acceleration;
        if (A1 > 0 && A1 < timeChange){
            return A1;
        }else {
            return A2;
        }
    }

    /**
     * updates the locations then changes the gui
     */
    public void update(){
        for (ArenaItem item: this.items){
            this.move(item);
            item.run();
        }
        super.notifyObservers();
    }

    public ArrayList<ArenaItem> getItems() {
        return items;
    }

    public add
}
