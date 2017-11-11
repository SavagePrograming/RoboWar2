
/**
 * ArenaItems are items which can exist in an arena
 * Examples include robots, scrap, and projectiles
 */
public abstract class ArenaItem {
    /*
     * Default properties of all items in an arena
     * Distances are in Meters, Masses in Kg
     */
    final static int MASS_DEFAULT = 10;
    final static int X_DEFAULT = 0;
    final static int Y_DEFAULT = 0;
    final static int X_SPEED_DEFAULT = 0;
    final static int Y_SPEED_DEFAULT = 0;
    final static int X_ACCELERATION_DEFAULT = 0;
    final static int Y_ACCELERATION_DEFAULT = 0;
    final static int RADIUS_DEFAULT = 10;


    /*
     * Properties of all Items in an arena
     */
    private int mass;

    private int radius;

    private int xAcceleration;
    private int yAcceleration;

    private int xSpeed;
    private int ySpeed;

    private int xLocation;
    private int yLocation;

    private Arena myArena;

    /*
    The Default constructors
     */

    /**
     * Constructs the default ArenaItem
     * the mass is set to MASS_DEFAULT;
     * the radius is set to RADIUS_DEFAULT;
     * the xLocation is set to X_DEFAULT;
     * the yLocation is set to Y_DEFAULT;
     * the xSpeed is set to X_SPEED_DEFAULT;
     * the ySpeed is set to Y_SPEED_DEFAULT;
     * the xAcceleration is set to X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(){
        this.mass = MASS_DEFAULT;
        this.radius = RADIUS_DEFAULT;
        this.xLocation = X_DEFAULT;

        this.yLocation = Y_DEFAULT;
        this.xSpeed = X_SPEED_DEFAULT;
        this.ySpeed = Y_SPEED_DEFAULT;
        this.xAcceleration = X_ACCELERATION_DEFAULT;
        this.yAcceleration = Y_ACCELERATION_DEFAULT;
    }
    /**
     * Constructs the default ArenaItem
     * @param mass the mass of the item
     * the radius is set to RADIUS_DEFAULT;
     * the xLocation is set to X_DEFAULT;
     * the yLocation is set to Y_DEFAULT;
     * the xSpeed is set to X_SPEED_DEFAULT;
     * the ySpeed is set to Y_SPEED_DEFAULT;
     * the xAcceleration is set to X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(int mass){
        this.mass = mass;
        this.radius = RADIUS_DEFAULT;
        this.xLocation = X_DEFAULT;
        this.yLocation = Y_DEFAULT;
        this.xSpeed = X_SPEED_DEFAULT;
        this.ySpeed = Y_SPEED_DEFAULT;
        this.xAcceleration = X_ACCELERATION_DEFAULT;
        this.yAcceleration = Y_ACCELERATION_DEFAULT;
    }

    /**
     * Constructs the default ArenaItem
     * @param mass the mass of the item
     * @param radius the radius of the item
     * the xLocation is set to X_DEFAULT;
     * the yLocation is set to Y_DEFAULT;
     * the xSpeed is set to X_SPEED_DEFAULT;
     * the ySpeed is set to Y_SPEED_DEFAULT;
     * the xAcceleration is set to X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(int mass, int radius){
        this.mass = mass;
        this.radius = radius;
        this.xLocation = X_DEFAULT;
        this.yLocation = Y_DEFAULT;
        this.xSpeed = X_SPEED_DEFAULT;
        this.ySpeed = Y_SPEED_DEFAULT;
        this.xAcceleration = X_ACCELERATION_DEFAULT;
        this.yAcceleration = Y_ACCELERATION_DEFAULT;
    }

    /**
     * Constructs an ArenaItem
     * @param mass the mass of the item
     * @param radius the radius of the item
     * @param xLocation the x location of the item
     * @param yLocation the y location of the item
     * the xSpeed is set to X_SPEED_DEFAULT;
     * the ySpeed is set to Y_SPEED_DEFAULT;
     * the xAcceleration is set to X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(int mass, int radius, int xLocation, int yLocation ){
        this.mass = mass;
        this.radius = radius;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xAcceleration = X_ACCELERATION_DEFAULT;
        this.yAcceleration = Y_ACCELERATION_DEFAULT;
    }

    /**
     * Constructs an ArenaItem
     * @param mass the mass of the item
     * @param radius the radius of the item
     * @param xLocation the x location of the item
     * @param yLocation the y location of the item
     * @param xSpeed the x speed of the item
     * @param ySpeed the y speed of the item
     * the xAcceleration is set to X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(int mass, int radius, int xLocation, int yLocation, int xSpeed, int ySpeed ){
        this.mass = mass;
        this.radius = radius;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xAcceleration = X_ACCELERATION_DEFAULT;
        this.yAcceleration = Y_ACCELERATION_DEFAULT;
    }

     /*
    The Arenas specific constructors
     */

    /**
     * Constucts a default item
     * the mass is set to the Arenas's MASS_DEFAULT;
     * the radius is set to the Arenas's RADIUS_DEFAULT;
     * the xLocation is set to the Arenas's X_DEFAULT;
     * the yLocation is set to the Arenas's Y_DEFAULT;
     * the xSpeed is set to the Arenas's X_SPEED_DEFAULT;
     * the ySpeed is set to the Arenas's Y_SPEED_DEFAULT;
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     * @param myArena
     */
    public ArenaItem(Arena myArena){
        this.myArena = myArena;
        this.mass = myArena.MASS_DEFAULT;
        this.radius = myArena.RADIUS_DEFAULT;
        this.xLocation = myArena.X_DEFAULT;
        this.yLocation = myArena.Y_DEFAULT;
        this.xSpeed = myArena.X_SPEED_DEFAULT;
        this.ySpeed = myArena.Y_SPEED_DEFAULT;
        this.xAcceleration = myArena.X_ACCELERATION_DEFAULT;
        this.yAcceleration = myArena.Y_ACCELERATION_DEFAULT;
    }

    /**
     * Constructs an ArenaItem
     * @param mass the mass of the item
     * the radius is set to the Arenas's RADIUS_DEFAULT;
     * the xLocation is set to the Arenas's X_DEFAULT;
     * the yLocation is set to the Arenas's Y_DEFAULT;
     * the xSpeed is set to the Arenas's X_SPEED_DEFAULT;
     * the ySpeed is set to the Arenas's Y_SPEED_DEFAULT;
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(Arena myArena, int mass){
        this.myArena = myArena;
        this.mass = mass;
        this.radius = myArena.RADIUS_DEFAULT;
        this.xLocation = myArena.X_DEFAULT;
        this.yLocation = myArena.Y_DEFAULT;
        this.xSpeed = myArena.X_SPEED_DEFAULT;
        this.ySpeed = myArena.Y_SPEED_DEFAULT;
        this.xAcceleration = myArena.X_ACCELERATION_DEFAULT;
        this.yAcceleration = myArena.Y_ACCELERATION_DEFAULT;
    }

    /**
     * Constructs an ArenaItem
     * @param mass the mass of the item
     * @param radius the radius of the item
     * the xLocation is set to the Arenas's X_DEFAULT;
     * the yLocation is set to the Arenas's Y_DEFAULT;
     * the xSpeed is set to the Arenas's X_SPEED_DEFAULT;
     * the ySpeed is set to the Arenas's Y_SPEED_DEFAULT;
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(Arena myArena, int mass, int radius){
        this.myArena = myArena;
        this.mass = mass;
        this.radius = radius;
        this.xLocation = myArena.X_DEFAULT;
        this.yLocation = myArena.Y_DEFAULT;
        this.xSpeed = myArena.X_SPEED_DEFAULT;
        this.ySpeed = myArena.Y_SPEED_DEFAULT;
        this.xAcceleration = myArena.X_ACCELERATION_DEFAULT;
        this.yAcceleration = myArena.Y_ACCELERATION_DEFAULT;
    }

    /**
     * Constructs an ArenaItem
     * @param mass the mass of the item
     * @param radius the radius of the item
     * @param xLocation the x location of the item
     * @param yLocation the y location of the item
     * the xSpeed is set to the Arenas's X_SPEED_DEFAULT;
     * the ySpeed is set to the Arenas's Y_SPEED_DEFAULT;
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(Arena myArena, int mass, int radius, int xLocation, int yLocation){
        this.myArena = myArena;
        this.mass = mass;
        this.radius = radius;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xAcceleration = myArena.X_ACCELERATION_DEFAULT;
        this.yAcceleration = myArena.Y_ACCELERATION_DEFAULT;
    }

    /**
     * Constructs an ArenaItem
     * @param mass the mass of the item
     * @param radius the radius of the item
     * @param xLocation the x location of the item
     * @param yLocation the y location of the item
     * @param xSpeed the x speed of the item
     * @param ySpeed the y speed of the item
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public ArenaItem(Arena myArena, int mass, int radius, int xLocation, int yLocation, int xSpeed, int ySpeed ){
        this.myArena = myArena;
        this.mass = mass;
        this.radius = radius;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xAcceleration = myArena.X_ACCELERATION_DEFAULT;
        this.yAcceleration = myArena.Y_ACCELERATION_DEFAULT;
    }

    /**
     * Gets the Mass
     * @return mass
     */
    public int getMass() {
        return mass;
    }

    /**
     * Sets the mass
     * @param mass
     */
    public void setMass(int mass) {
        this.mass = mass;
    }

    /**
     * Gets the xAcceleration
     * @return xAcceleration
     */
    public int getxAcceleration() {
        return xAcceleration;
    }

    /**
     * Sets the xAcceleration
     * @param xAcceleration
     */
    public void setxAcceleration(int xAcceleration) {
        this.xAcceleration = xAcceleration;
    }

    /**
     * Gets the yAcceleration
     * @return yAcceleration
     */
    public int getyAcceleration() {
        return yAcceleration;
    }

    /**
     * Sets the yAcceleration
     * @param yAcceleration
     */
    public void setyAcceleration(int yAcceleration) {
        this.yAcceleration = yAcceleration;
    }

    /**
     * Gets the xSpeed
     * @return xSpeed
     */
    public int getxSpeed() {
        return xSpeed;
    }

    /**
     * Sets the xSpeed
     * @param xSpeed
     */
    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    /**
     * Gets the ySpeed
     * @return ySpeed
     */
    public int getySpeed() {
        return ySpeed;
    }

    /**
     * Sets the ySpeed
     * @param ySpeed
     */
    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    /**
     * Gets the xLocation
     * @return xLocation
     */
    public int getxLocation() {
        return xLocation;
    }

    /**
     * Sets the xLocation
     * @param xLocation
     */
    public void setxLocation(int xLocation) {
        this.xLocation = xLocation;
    }

    /**
     * Gets the yLocation
     * @return yLocation
     */
    public int getyLocation() {
        return yLocation;
    }

    /**
     * Sets the yLocation
     * @param yLocation
     */
    public void setyLocation(int yLocation) {
        this.yLocation = yLocation;
    }

    /**
     * Gets the Arenas
     * @return myArena
     */
    public Arena getMyArena() {
        return myArena;
    }

    /**
     * Sets the Arenas
     * @param myArena
     */
    public void setMyArena(Arena myArena) {
        this.myArena = myArena;
    }

    /**
     * Gets the radius
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the radius
     * @param radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }


    public abstract void run();

}