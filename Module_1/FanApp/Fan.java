/*
Write a program with a class titled Fan. This class is to contain:
1. Four constants named STOPPED, SLOW, MEDIUM, and FAST with values 0, 1, 2, and
3 to represent the fans speed.
2. A private int data field named speed that specifies the speed of the fan. Use the constants
and set the default speed to STOPPED.
3. A private boolean data field named on that specifies whether the fan is on or off. The
default is off (i.e., false).
4. A private double data field named radius that specifies the radius of the fan. The default
is 6.
5. A private string data field named color that specifies the color of the fan. The default is
white.
6. Accessor and mutator methods for all four data fields.
7. A no-argument constructor that creates a default fan (set all fields to their default values).
8. An argument constructor that creates a fan using the four fields as arguments.
9. Override the toString method. Return a string description for the fan. If the fan is on, the
method returns the fan speed, color, and radius in a combined string. If the fan is not on,
the method returns the fan color, radius, and a message of “fan is off” in a combined
string.
10. Create a new file named TestFanApp with a main() method to test the Fan class. Create
two instances of the Fan class, one using the default constructor and the other using the
argument constructor. For the second argument constructor, use the classes constants to
set the speed. Display the objects by invoking the classes toString() method

*/
public class Fan {
	final static int SLOW = 1;
	final static int MEDIUM = 2;
	final static int FAST = 3;
	private int speed;
	private boolean on;
	private double radius;
	String color;

	/** Constructor that creates a default fan */
	Fan() {
		speed = SLOW;
		on = false;
		radius = 5;
		color = "blue";
	}

	/** Mutator methods */
	/** Sets speed */
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}

	/** Sets fan on */
	public void turnOn() {
			on = true;
	}

	/** Sets fan off */ 
	public void turnOff() {
			on = false;
	}

	/** Sets color */
	public void setColor(String newColor) {
		color = newColor;
	}

	/** Sets radius */
	public void setRadius(double newRadius) {
		radius = newRadius;
	}

	/** Accessor methods */
	/** Return speed */
	public String getSpeed() {
		String s = "";
		switch (speed) {
			case SLOW: s = "SLOW"; break;
			case MEDIUM: s = "MEDIUM"; break;
			case FAST: s = "FAST";
		}
		return s;
	}

	/** Return on */
	public boolean isOn() {
		return on;
	}

	/** Return radius */
	public double getRadius() {
		return radius;
	}

	/** Return color */
	public String getColor() {
		return color;
	}

	/** Returns a string description for the fan */
	public String toString() {
		if (on == true) {
			return "\nFan speed: " + getSpeed() + ", color: " + color + 
					 ", radius: " + radius + "\n";
		}
		else{
			return "\nFan color: " + color + ", radius: " + radius +
					 "\nfan is off\n";
		}
	}
}