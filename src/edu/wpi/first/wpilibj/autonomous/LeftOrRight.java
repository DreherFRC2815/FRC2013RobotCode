/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.autonomous;

import edu.wpi.first.wpilibj.Drive;
import edu.wpi.first.wpilibj.Loader_3;
import edu.wpi.first.wpilibj.Piston;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Vision;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.image.NIVisionException;

/**
 * @author johnw_000
 */
public class LeftOrRight extends CommandGroup {

	//private final double switchTime = 5;
	//private final double calTime = 1.5;
	//private final double startTime;
	//private boolean isHot = false;
	//Vision vision;

	public LeftOrRight(Drive drive, Piston piston, Loader_3 load) {
		boolean completed = false;
		//startTime = Timer.getFPGATimestamp();

		
			while (!completed) {

				
				//addParallel(new RiseLoaderArm(load));
				//addParallel(new DropLoaderArm(load));
				//addSequential(new DropLoaderArm(load));
				addSequential(new DriveForward(drive)); 
				//addSequential(new Shoot(piston)); new
				
				completed = true;

			}
		
		}
	}

