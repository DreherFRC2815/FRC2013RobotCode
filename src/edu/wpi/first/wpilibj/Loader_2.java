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
public class Loader_2 {
	Joystick xbox;
	Jaguar motor[] = new Jaguar[3];
	final double MAX = .75;
	
	Loader_2(){
		xbox = new Joystick(2);
		motor[0] = new Jaguar(3);
		motor[1] = new Jaguar(4);
		motor[2] = new Jaguar(5);
		
	}
	public void runLoader(){
		if(xbox.getRawButton(3)){
			motor[0].set(.5*-1);
			motor[1].set(.5);
		}
		if(xbox.getRawButton(4)){
			motor[0].set(.5);
			motor[1].set(.5*-1);
		}
	
		motor[2].set(xbox.getRawAxis(2)/2);
		if(xbox.getRawButton(5)){
			motor[0].set(MAX);
			motor[1].set(MAX);
			
		}
		if(xbox.getRawButton(4)){
			motor[0].set(0);
			motor[1].set(0);
		
		}
	}
}
