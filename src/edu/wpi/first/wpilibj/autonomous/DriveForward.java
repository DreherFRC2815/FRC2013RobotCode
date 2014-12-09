/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.autonomous;

import edu.wpi.first.wpilibj.ArcadeDrive;
import edu.wpi.first.wpilibj.Drive;
import edu.wpi.first.wpilibj.TankDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author johnw_000
 */
public class DriveForward extends Command {
	private int state = 0;
	private final int BOOTING = 0, DRIVING_FOWARD = 1, FINISHED = 2;
	private final double DRIVE_TIME = 3.4;
	private double startTime = 0;
	private ArcadeDrive drive;
	
	public DriveForward(Drive drive){
		this.drive = (ArcadeDrive) drive;
	}
	protected void initialize() {
		this.setInterruptible(false);
		state = BOOTING;
	}

	protected void execute() {
		switch(state){
			case BOOTING:
				startTime = Timer.getFPGATimestamp();
				state = DRIVING_FOWARD;
				break;
			case DRIVING_FOWARD:
				if(Timer.getFPGATimestamp() >= startTime + DRIVE_TIME){
					drive.drive(0, 0);
					state = FINISHED;
					drive.delete();
					break;
				}
				drive.drive(.3,-.27);
				break;
		}
				
	}

	protected boolean isFinished() {
		return (state == FINISHED); //To change body of generated methods, choose Tools | Templates.
	}

	protected void end() {
		 //To change body of generated methods, choose Tools | Templates.
	}

	protected void interrupted() {
		 //To change body of generated methods, choose Tools | Templates.
	}
	
}
