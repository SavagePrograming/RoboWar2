
public class Robot extends ArenaItem {
    
    /**
     * Constructs the default Robot
     * same as default ArenaItem
     */
    public Robot(){
        super();
    }
    /**
     * Constructs the default Robot
     * @param mass the mass of the Robot
     */
    public Robot(int mass){
        super(mass);
    }

    /**
     * Constructs the default Robot
     * @param mass the mass of the Robot
     * @param radius the radius of the Robot
     */
    public Robot(int mass, int radius){
        super(mass,radius);
    }

    /**
     * Constructs a Robot
     * @param mass the mass of the Robot
     * @param radius the radius of the Robot
     * @param xLocation the x location of the Robot
     * @param yLocation the y location of the Robot
     */
    public Robot(int mass, int radius, int xLocation, int yLocation ){
        super(mass,radius,xLocation, yLocation);
    }

    /**
     * Constructs an Robot
     * @param mass the mass of the Robot
     * @param radius the radius of the Robot
     * @param xLocation the x location of the Robot
     * @param yLocation the y location of the Robot
     * @param xSpeed the x speed of the Robot
     * @param ySpeed the y speed of the Robot
     * the xAcceleration is set to X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to Y_ACCELERATION_DEFAULT;
     */
    public Robot(int mass, int radius, int xLocation, int yLocation, int xSpeed, int ySpeed ){
        super(mass, radius, xLocation, yLocation, xSpeed, ySpeed );
    }

     /*
     
    The Arenas specific constructors
     */

    /**
     * Constucts a default Robot
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
    public Robot(Arena myArena){
        super(myArena);
    }

    /**
     * Constructs an Robot
     * @param mass the mass of the Robot
     * the radius is set to the Arenas's RADIUS_DEFAULT;
     * the xLocation is set to the Arenas's X_DEFAULT;
     * the yLocation is set to the Arenas's Y_DEFAULT;
     * the xSpeed is set to the Arenas's X_SPEED_DEFAULT;
     * the ySpeed is set to the Arenas's Y_SPEED_DEFAULT;
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public Robot(Arena myArena, int mass){
        super(myArena, mass);
    }

    /**
     * Constructs an Robot
     * @param mass the mass of the Robot
     * @param radius the radius of the Robot
     * the xLocation is set to the Arenas's X_DEFAULT;
     * the yLocation is set to the Arenas's Y_DEFAULT;
     * the xSpeed is set to the Arenas's X_SPEED_DEFAULT;
     * the ySpeed is set to the Arenas's Y_SPEED_DEFAULT;
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public Robot(Arena myArena, int mass, int radius){
        super(myArena, mass, radius);
    }

    /**
     * Constructs an Robot
     * @param mass the mass of the Robot
     * @param radius the radius of the Robot
     * @param xLocation the x location of the Robot
     * @param yLocation the y location of the Robot
     * the xSpeed is set to the Arenas's X_SPEED_DEFAULT;
     * the ySpeed is set to the Arenas's Y_SPEED_DEFAULT;
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public Robot(Arena myArena, int mass, int radius, int xLocation, int yLocation){
        super(myArena, mass, radius, xLocation, yLocation);
    }

    /**
     * Constructs an Robot
     * @param mass the mass of the Robot
     * @param radius the radius of the Robot
     * @param xLocation the x location of the Robot
     * @param yLocation the y location of the Robot
     * @param xSpeed the x speed of the Robot
     * @param ySpeed the y speed of the Robot
     * the xAcceleration is set to the Arenas's X_ACCELERATION_DEFAULT;
     * the yAcceleration is set to the Arenas's Y_ACCELERATION_DEFAULT;
     */
    public Robot(Arena myArena, int mass, int radius, int xLocation, int yLocation, double xSpeed, double ySpeed ){
        super(myArena, mass, radius, xLocation, yLocation, xSpeed, ySpeed );
    }

    @Override
    public void run() {
        System.out.print("("+this.getxSpeed() + ", " + this.getySpeed() + ") (" + this.getxLocation() + ", " + this.getyLocation() + ")");
        System.out.println();

    }
}
