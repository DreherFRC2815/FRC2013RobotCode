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
public class Piston {
	private Solenoid[] piston = new Solenoid[3];// new solenoid array
	private Joystick fire;
	private boolean value;
	//constructor
	public Piston(){
		//Pnewmatics
		piston[0] = new Solenoid(1);
		piston[1] = new Solenoid(2);
		piston[2] = new Solenoid(3);
		
		//Joysticks
		fire = new Joystick(2);
			
	}
	//shoots the piston
	public void shoot(){
		if(fire.getRawButton(1))latch(true);
		else latch(false);
	}
	public void shoot(boolean value){
		if(value) latch(true);
		else latch(false);
	}
	//sets the values for both pistons
	private void latch(boolean value){
		this.value = value;
		piston[0].set(!value);
		piston[1].set(value);// one chanel is always oppisate from the other
	}
	public void shootPiston(boolean value){
		piston[2].set(value);//on port 3 of the flight sim controller
		
	}
	public void pistonValue(){
		if(fire.getRawButton(2))shootPiston(true);
		else shootPiston(false);
	}
	//returns the value of the piston boolean
	public boolean getValue(){
		return value;
	}
}
