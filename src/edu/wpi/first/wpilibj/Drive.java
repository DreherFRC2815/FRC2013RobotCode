/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author John
 */
public interface Drive {

	final Joystick drive = new Joystick(1);

	public double getlSpeed();

	public double getrSpeed();

	public void drive();
	public void drive(double rspeed, double lspeed);
	public void move(double turnValue, double yThrottle);
	
	public void delete();
}
