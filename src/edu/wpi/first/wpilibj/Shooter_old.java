/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj;

/**
 *
 * @author johnw_000
 */
public class Shooter_old {
	private Jaguar[] shooterMotors = new Jaguar[4];
	private Joystick run;
	private double speed;
	private double iterCount = 0;
	private boolean ignition;
	public Shooter_old(){
		run = new Joystick(2);
		shooterMotors[0] = new Jaguar(5);
		shooterMotors[1] = new Jaguar(6);
		shooterMotors[2] = new Jaguar(7);
		shooterMotors[3] = new Jaguar(8);
	}
	public void runMotors(){
		if(run.getRawButton(3)){
			ignition = true;
		}else if(run.getRawButton(2)){
			speed = 0;
			ignition = false;
		}
		if (ignition) {
			iterCount++;
			if (iterCount % 100 == 0 && speed < 1.0) speed += .2;
		}
		shooterMotors[0].set(speed*-1);
		shooterMotors[1].set(speed*-1);
		shooterMotors[2].set(speed*-1);
		shooterMotors[3].set(speed*-1);
	}
	
}