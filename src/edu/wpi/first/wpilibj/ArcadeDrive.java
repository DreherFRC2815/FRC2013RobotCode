/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj;

/**
 * Allows control of the robot with arcade drive
 *
 * @author johnw_000
 */
public class ArcadeDrive implements Drive{

	/*
	 Channel 1 - Left X
	 Channel 2 - Left Y (inverted)
	 Channel 4 - Right X
	 Channel 5 - Right Y (inverted)
	 */
	private final double ACCEL;

	private double lspeed;
	private double rspeed;
	private double lTarget;
	private double rTarget;
	private Jaguar rwheel[];
	private Jaguar lwheel[];
	private Joystick drive;

	public ArcadeDrive() {
		ACCEL = 0.1;
		lspeed = 0.0;
		rspeed = 0.0;
		rwheel = new Jaguar[2];
		lwheel = new Jaguar[2];
		rwheel[0] = new Jaguar(1);
		lwheel[0] = new Jaguar(3);
		rwheel[1] = new Jaguar(2);
		lwheel[1] = new Jaguar(4);
		drive = new Joystick(1);
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
	 * This function finds the values of the axes on the joystick, then calls
	 * the move method This separation was done to utilize the move method in
	 * autonomous mode, if it is so desired
	 */
	public void drive() {
		double yThrottle = drive.getRawAxis(4);
		double turnValue = drive.getRawAxis(2) * -1;
		if (Math.abs(yThrottle) < .01) {
			yThrottle = 0;
		}
		move(turnValue, yThrottle);
		rwheel[0].set(rspeed);
		lwheel[0].set(lspeed);
		rwheel[1].set(rspeed);
		lwheel[1].set(lspeed);
		
	}
	public void drive(double rspeed, double lspeed){
		rwheel[0].set(rspeed);
		lwheel[0].set(lspeed);
		rwheel[1].set(rspeed);
		lwheel[1].set(lspeed);
	}
	/**
	 * This function determines the speeds for the motors
	 *
	 * @param turnValue Value of right joystick axis
	 * @param yThrottle Value of left joystick axis
	 */
	public void move(double turnValue, double yThrottle) {

		lTarget = yThrottle * Math.abs(yThrottle) + turnValue * Math.abs(turnValue) * Math.abs(turnValue);
		rTarget = yThrottle * Math.abs(yThrottle) - turnValue * Math.abs(turnValue) * Math.abs(turnValue);

		if (lspeed != lTarget) {
			if (lspeed < lTarget) {
				lspeed += ACCEL;
				if (lspeed > lTarget) {
					lspeed = lTarget;
				}
			} else {
				lspeed -= ACCEL;
				if (lspeed < lTarget) {
					lspeed = lTarget;
				}
			}
		}

		if (rspeed != rTarget) {
			if (rspeed < rTarget) {
				rspeed += ACCEL;
				if (rspeed > rTarget) {
					rspeed = rTarget;
				}
			} else {
				rspeed -= ACCEL;
				if (rspeed < rTarget) {
					rspeed = rTarget;
				}
			}
		}

		if (rspeed != 0) {
			rspeed += 0.03;
		}
		
		
		
	}
	public void delete(){
		rwheel[0].disable();
		rwheel[1].disable();
		lwheel[0].disable();
		lwheel[1].disable();
	}
}
