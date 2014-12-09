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
public class Loader {
	private double motorSpeed;
	private Joystick drive;
	private Jaguar[] load = new Jaguar[2]; // an array of motors
	
	//constructor for the Loader
	public Loader(){
		//Joystick
		drive = new Joystick(2);
		
		//Pneu  matics
		load[0] = new Jaguar(3);//pwm port 3
		load[1] = new Jaguar(4);//pwm port 4
		
	}
	
	//returns the Loaderspeed
	public double getLoaderSpeed(){
		return motorSpeed;
	}
	//runs the motors for the loader
	public void runLoader(){
		if(drive.getRawButton(3)){
			load[0].set(varriableSpeed()/2);
			load[1].set(varriableSpeed()/2*-1);//inverted direction
		}
		if(drive.getRawButton(2)){
			load[0].set(0);
			load[1].set(0);
		}
		
	}
	//increses speed by incriments of .1 retruns a double 
	private double varriableSpeed(){
		for (double i = .5; i < 1; i += .1) {
			motorSpeed = i;
		}
		return motorSpeed;
	}
	
}
