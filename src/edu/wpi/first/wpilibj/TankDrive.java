package edu.wpi.first.wpilibj;

/**
 * Allows control of Robot with tank drive
 *
 * @author johnw_000
 */
public class TankDrive implements Drive {

	private double lspeed;
	private double rspeed;
	private Jaguar rwheel[];
	private Jaguar lwheel[];
	
	public TankDrive(){
		rwheel = new Jaguar[2];
		lwheel = new Jaguar[2];
		rwheel[0] = new Jaguar(1);
		lwheel[0] = new Jaguar(3);
		rwheel[1] = new Jaguar(2);
		lwheel[1] = new Jaguar(4);
	}

	/**
	 * This function returns left motor speed
	 *
	 * @return speed for left motor
	 */
	public double getlSpeed() {
		return lspeed;
	}

	/**
	 * This function returns right motor speed
	 *
	 * @return speed for right motor
	 */
	public double getrSpeed() {
		return rspeed;
	}

	/**
	 * This function determines the speeds for the motors
	 */
	public void drive() //Sets the right and left motor speeds
	{
		rspeed = drive.getRawAxis(5);
		lspeed = drive.getRawAxis(2) * -1;
		move(rspeed,lspeed);
	}

	public void move(double turnValue, double yThrottle) {
		rspeed = turnValue;
		lspeed = yThrottle;
		
		rwheel[0].set(rspeed);
		lwheel[0].set(lspeed);
		rwheel[1].set(rspeed);
		lwheel[1].set(lspeed);
	}
	public void delete(){
		rwheel[0].disable();
		rwheel[1].disable();
		lwheel[0].disable();
		lwheel[1].disable();
	}
	public void drive(double rspeed, double lspeed){
		
	}
}
