/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.autonomous;

import edu.wpi.first.wpilibj.ArcadeDrive;
import edu.wpi.first.wpilibj.TankDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Drive;
import edu.wpi.first.wpilibj.ArcadeDrive;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author johnw_000
 */
public class Turn extends Command {
	private int state = 0;
	private final int BOOTING = 0, DRIVING_FOWARD = 1, FINISHED = 2;
	private final int DRIVE_TIME = 1;
	private double startTime = 0;
	private ArcadeDrive drive;
	
	public Turn(Drive drive){
		
	}
	protected void initialize() {
		
	}

	protected void execute() {
		switch(state){
			case BOOTING:
				startTime = Timer.getFPGATimestamp();
				state = DRIVING_FOWARD;
				break;
			case DRIVING_FOWARD:
				if(Timer.getFPGATimestamp() >= state + DRIVE_TIME){
					drive.move(0, 0);
					state = FINISHED;
					break;
				}
				if(true){//if the left goal is hot
					drive.move(1, 0);
					break;
				}
				drive.move(0, 1);
				break;
		}
	}

	protected boolean isFinished() {
		return FINISHED == state;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
	
}
