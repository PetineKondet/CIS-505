/*  
    Fan Class -
    
*/
  // -----------------------------------
  public class Fan {
    // -----------------------------------
    // Declaring the constants
    final int STOPPED = 0; // Default speed is 0
    final int SLOW = 1; // Default speed is 1
    final int MEDIUM = 2; // Default speed is 2
    final static int FAST = 3; // speed is 3
    // ----------------------------------- 
    // non-constant variables
    private boolean on = false; // Initialized fan state
    private int speed = STOPPED; // Initialized fan speed
    private double radius = 6.0; //Initialized fan radius
    private String color = "white"; //Initialized fan color
    // -----------------------------------
    //  on/off methods   
    public void turnOn() {
      on = true;
    }
    public void turnOff() {
      on = false;
    }
    // -----------------------------------
    // on/off getter and setter methods
    public boolean getOn() {
      return on;
    }
    public void setOn(boolean newOn) {
      on = newOn;
    }
    // -----------------------------------
    public int getSpeed() {
      return speed;
    }
    public void setSpeed(int newSpeed) {
      speed = newSpeed;
    }
    // -----------------------------------
    // radius getter and setter methods
    public double getRadius() {
      return radius;
    }
    public void setRadius(double newRadius) {
      radius = newRadius;
    }
    // -----------------------------------
    // color getters and setter methods
    public String getColor() {
      return color;
    }
    public void setColor(String newColorLevel) {
      color = newColorLevel;
    }
    // Constructors - are down here so they can use setter methods above 
    public Fan() {
      setOn(false); // By default Fan state is "off"
      setSpeed(STOPPED); // Default speed is STOPPED
      setRadius(10.0); //default fan radius
      setColor("white"); //default fan color
    }//end default constructor
    public Fan(boolean newOn, int newSpeed, double newRadius, String newColor) {
      this.on = newOn;
      this.speed = newSpeed;
      this.radius = newRadius;
      this.color = newColor;
    }//end constructor
    // -----------------------------------
    //toString() - overridden to show fan state
    public String toString(){
      if (getOn() == true) {
        return "The fan is on and the fan speed is " + getSpeed() + ".  The fan color is " + getColor() + " and the fan radius is " + getRadius();
      }
      else {
        return "The fan is off and the fan speed is " + getSpeed() + ".  The fan color is " + getColor() + " and the fan radius is " + getRadius();
      }
    }//end toString () override
}  //end Fan
