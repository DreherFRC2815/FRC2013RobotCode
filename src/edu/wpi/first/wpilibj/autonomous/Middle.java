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
 *
 * @author johnw_000
 */
public class Middle extends CommandGroup{
	private final double switchTime = 5;
	private final double calTime = 1.5;
	private boolean isHot = false;
	Vision vision = new Vision();
	public Middle(Drive drive, Piston piston, Loader_3 load) {
		vision = new Vision();
		addSequential(new DropLoaderArm(load));
		while(Timer.getFPGATimestamp()< calTime){
			try{
				vision.doVisionCalc();
				isHot = vision.isHot();
			}catch(NIVisionException e){
				
			}catch(AxisCameraException e){
				
			}
 		}
		
		if(isHot){
			 addSequential(new DriveForward(drive));
			 addSequential(new Turn(drive));
			 addSequential(new Shoot(piston));
		}else{
			if(Timer.getFPGATimestamp() > switchTime){
				 addSequential(new DriveForward(drive));
				 addSequential(new Turn(drive));
				 addSequential(new Shoot(piston));
			}
		}
	}
}
