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
public class Loader_3 {
	Joystick xbox;
	Jaguar motor[] = new Jaguar[2];
	//DigitalInput limitSwitch;
	final double MAX = .75;
	final double DEAD_ZONE = .4;
	double mSpeed;
	Loader_3(){
		motor[0] = new Jaguar(5);
		motor[1] = new Jaguar(6);
		xbox = new Joystick(2);
		mSpeed = 0.0;
		//limitSwitch = new DigitalInput(2);
	}
	public void runLoader(){
		if (xbox.getRawAxis(2) <= -1*DEAD_ZONE) {
			mSpeed = -0.2;
		}
		else if (xbox.getRawAxis(2) >= DEAD_ZONE) {
			mSpeed = xbox.getRawAxis(2) * 0.2;
		}
		else mSpeed = 0.0;
		
		runLoader(mSpeed);
		/*
		if(Math.abs(xbox.getRawAxis(2))>=DEAD_ZONE){
			motor[0].set(xbox.getRawAxis(2)*.25);
		}else{
			motor[0].set(0);
		}
		*/
		/*
		if(limitSwitch.get()){
			if(xbox.getRawAxis(2) > 0){
				motor[0].set(xbox.getRawAxis(2)*.25);
			}else if(xbox.getRawAxis(2) <= 0) {
				motor[0].set(0);
			}
		}
		*/
		
	}
	public void runLoader(double speed){
		//while(!limitSwitch.get()){
			motor[0].set(speed);
			motor[1].set(speed);
		//}
		//motor[0].set(0);
	}
	/*
	public boolean getLimitSwitchValue(){
		return limitSwitch.get();
	}
	*/
}
