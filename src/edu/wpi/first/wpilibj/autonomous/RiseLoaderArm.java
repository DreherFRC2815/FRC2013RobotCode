/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.autonomous;

import edu.wpi.first.wpilibj.Loader_3;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 * @author johnw_000
 */
public class RiseLoaderArm extends Command{
	
	private final Loader_3 load;
	private double loadTime;
	private double startTime;
	private boolean isDown;
	public RiseLoaderArm(Loader_3 load){
		this.load = (Loader_3) load;
	}
	protected void initialize() {
		this.setInterruptible(false);
		startTime = 0;
		loadTime = 3;
		isDown = false;
	}

	protected void execute() {
		
		startTime = Timer.getFPGATimestamp();
		if(Timer.getFPGATimestamp() <=  startTime + loadTime){
			load.runLoader(-.1);
			isDown = true;
		}
	}

	protected boolean isFinished() {
		return isDown;
		
	}
	protected void end() {
		
	}

	protected void interrupted() {
		
	}
	
}
