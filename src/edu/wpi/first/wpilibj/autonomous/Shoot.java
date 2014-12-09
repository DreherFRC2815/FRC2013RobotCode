/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.autonomous;

import edu.wpi.first.wpilibj.Piston;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Vision;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author johnw_000
 */
public class Shoot extends Command {
	private Piston shot;
	private boolean hasFired = false;
	public Shoot(Piston shot){
		this.shot = (Piston) shot;
	}
	protected void initialize() {
		
		
	}

	protected void execute() {
		//impliment vision later
		
		if(!hasFired){
			shot.shoot(!hasFired);
		
			hasFired = true;			
		}
		if(Timer.getFPGATimestamp() > 9){
			shot.shoot(hasFired);
		}
		
	}

	protected boolean isFinished() {
		
		return hasFired;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
	
}
