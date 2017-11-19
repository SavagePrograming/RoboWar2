
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
    final static double X_SPEED_DEFAULT = 0;
    final static double Y_SPEED_DEFAULT = 0;
    final static double X_ACCELERATION_DEFAULT = 0;
    final static double Y_ACCELERATION_DEFAULT = 0;
    final static int RADIUS_DEFAULT = 10;


    /*
     * Properties of all Items in an arena
     */
    private int mass;

    private int radius;

    private double xAcceleration;
    private double yAcceleration;

    private double xSpeed;
    private double ySpeed;

    private int xLocation;
    private int yLocation;

    private double tempxAcceleration;
    private double tempyAcceleration;

    private double tempxSpeed;
    private double tempySpeed;

    private int tempxLocation;
    private int tempyLocation;

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
        updateTemps();
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
        updateTemps();
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
        updateTemps();
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
        updateTemps();
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
    public ArenaItem(int mass, int radius, int xLocation, int yLocation, double xSpeed, double ySpeed ){
        this.mass = mass;
        this.radius = radius;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xAcceleration = X_ACCELERATION_DEFAULT;
        this.yAcceleration = Y_ACCELERATION_DEFAULT;
        updateTemps();
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
        this.mass = myArena.getMASS_DEFAULT();
        this.radius = myArena.getRADIUS_DEFAULT();
        this.xLocation = myArena.getX_DEFAULT();
        this.yLocation = myArena.getY_DEFAULT();
        this.xSpeed = myArena.getX_SPEED_DEFAULT();
        this.ySpeed = myArena.getY_SPEED_DEFAULT();
        this.xAcceleration = myArena.getX_ACCELERATION_DEFAULT();
        this.yAcceleration = myArena.getY_ACCELERATION_DEFAULT();
        updateTemps();
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
        this.radius = myArena.getRADIUS_DEFAULT();
        this.xLocation = myArena.getX_DEFAULT();
        this.yLocation = myArena.getY_DEFAULT();
        this.xSpeed = myArena.getX_SPEED_DEFAULT();
        this.ySpeed = myArena.getY_SPEED_DEFAULT();
        this.xAcceleration = myArena.getX_ACCELERATION_DEFAULT();
        this.yAcceleration = myArena.getY_ACCELERATION_DEFAULT();
        updateTemps();
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
        this.xLocation = myArena.getX_DEFAULT();
        this.yLocation = myArena.getY_DEFAULT();
        this.xSpeed = myArena.getX_SPEED_DEFAULT();
        this.ySpeed = myArena.getY_SPEED_DEFAULT();
        this.xAcceleration = myArena.getX_ACCELERATION_DEFAULT();
        this.yAcceleration = myArena.getY_ACCELERATION_DEFAULT();
        updateTemps();
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
        this.xAcceleration = myArena.getX_ACCELERATION_DEFAULT();
        this.yAcceleration = myArena.getY_ACCELERATION_DEFAULT();
        updateTemps();
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
    public ArenaItem(Arena myArena, int mass, int radius, int xLocation, int yLocation, double xSpeed, double ySpeed ){
        this.myArena = myArena;
        this.mass = mass;
        this.radius = radius;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.xAcceleration = myArena.getX_ACCELERATION_DEFAULT();
        this.yAcceleration = myArena.getY_ACCELERATION_DEFAULT();
        updateTemps();
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
    public double getxAcceleration() {
        return xAcceleration;
    }

    /**
     * Sets the xAcceleration
     * @param xAcceleration
     */
//    public void setxAcceleration(double xAcceleration) {
//        this.xAcceleration = xAcceleration;
//    }

    /**
     * Gets the yAcceleration
     * @return yAcceleration
     */
    public double getyAcceleration() {
        return yAcceleration;
    }

    /**
     * Sets the yAcceleration
     * @param yAcceleration
     */
//    public void setyAcceleration(double yAcceleration) {
//        this.yAcceleration = yAcceleration;
//    }

    /**
     * Gets the xSpeed
     * @return xSpeed
     */
    public double getxSpeed() {
        return xSpeed;
    }

    /**
     * Sets the xSpeed
     * @param xSpeed
     */
//    public void setxSpeed(double xSpeed) {
//        this.xSpeed = xSpeed;
//    }

    /**
     * Gets the ySpeed
     * @return ySpeed
     */
    public double getySpeed() {
        return ySpeed;
    }

    /**
     * Sets the ySpeed
     * @param ySpeed
     */
//    public void setySpeed(double ySpeed) {
//        this.ySpeed = ySpeed;
//    }

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
//    public void setxLocation(int xLocation) {
//        this.xLocation = xLocation;
//    }

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
//    public void setyLocation(int yLocation) {
//        this.yLocation = yLocation;
//    }

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
//    public void setMyArena(Arena myArena) {
//        this.myArena = myArena;
//    }

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

    private void updateTemps(){
        tempxAcceleration = xAcceleration;
        tempyAcceleration = yAcceleration;

        tempxSpeed = xSpeed;
        tempySpeed = ySpeed;

        tempxLocation = xLocation;
        tempyLocation = yLocation;
    }

    public abstract void run();

    public double getTempxAcceleration() {
        return tempxAcceleration;
    }

    public void setTempxAcceleration(double tempxAcceleration) {
        this.tempxAcceleration = tempxAcceleration;
    }

    public double getTempyAcceleration() {
        return tempyAcceleration;
    }

    public void setTempyAcceleration(double tempyAcceleration) {
        this.tempyAcceleration = tempyAcceleration;
    }

    public double getTempxSpeed() {
        return tempxSpeed;
    }

    public void setTempxSpeed(double tempxSpeed) {
        this.tempxSpeed = tempxSpeed;
    }

    public double getTempySpeed() {
        return tempySpeed;
    }

    public void setTempySpeed(double tempySpeed) {
        this.tempySpeed = tempySpeed;
    }

    public int getTempxLocation() {
        return tempxLocation;
    }

    public void setTempxLocation(int tempxLocation) {
        this.tempxLocation = tempxLocation;
    }

    public int getTempyLocation() {
        return tempyLocation;
    }

    public void setTempyLocation(int tempyLocation) {
        this.tempyLocation = tempyLocation;
    }

    public void update(){
        xAcceleration = tempxAcceleration;
        yAcceleration = tempyAcceleration;

        xSpeed = tempxSpeed;
        ySpeed = tempySpeed;

        xLocation = tempxLocation;
        yLocation = tempyLocation;
    }
}
