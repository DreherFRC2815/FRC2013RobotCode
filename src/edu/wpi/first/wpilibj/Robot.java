package edu.wpi.first.wpilibj;

import edu.wpi.first.wpilibj.command.Scheduler;
//import edu.wpi.first.wpilibj.autonomous.LeftOrRight;
//import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	/**
	 * Variable declaration
	 */
	//Drive control
	Drive robotDrive;

	final int TANK_DRIVE = 0;
	final int ARCADE_DRIVE = 1;

	//Joysticks
	//Joystick driveControl;
	//Joystick shootControl;

	//Pneumatics
	Piston fire;
	
	//Compressor
	AirCompressor compressor;
	
	
	//Loader
	//Loader load;
	//Loader_2 loadX;
	//Loader_3 load3;
	//Analog Channel
	//AnalogChannel voltage;
	//Shooter_old shoot;
	//Timer
	//double startTime;
	//boolean isHot;
	//boolean hasShot;
	Timer time;
	//Preferences pref;
	//SendableChooser auto;
	//Command autonomousCommand;
	
	//Vision vision;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 *
	 * @Override
	 */
	public void robotInit() {

		//Joysticks(int port)
		//driveControl = new Joystick(1);
		//shootControl = new Joystick(2);
		robotDrive = new ArcadeDrive();

		//Pneumtics
		fire = new Piston();
		
		//compressor
		compressor = new AirCompressor();
		//Loader
		//load = new Loader();
		//loadX = new Loader_2();
		//load3 = new Loader_3();	
        //Watchdog, must be enabled before each match
		//watchdog.setEnabled(true);
		//shoot = new Shooter_old();
		//smart dashboard
		//SmartDashboard.putNumber("Data Type", 10);
		//System.out.println("Data Type on Network Table");
		//auto = new SendableChooser();
		
		//auto.addDefault("Left Or Right", new DriveForward());
		//auto.addObject("Drive Foward", new DriveForward());
		//SmartDashboard.putData("Auto Chooser",auto);
		
		//pref = Preferences.getInstance();
		
		//Time, see automonus
		time = new Timer();
		
		//auto = new SendableChooser();
		//auto.addObject("Left or Right", new LeftOrRight());
		//auto.addObject("Middle", new Middle());
		//SmartDashboard.putData("Autonomous Chooser", auto);
		
		//int drivetype = pref.getInt("driveType", TANK_DRIVE);
		//if(drivetype == TANK_DRIVE)
		//{
		//	robotDrive = new TankDrive();
		//}
		//else {
		
		//}
		//vision = new Vision();
	}

	
	public void autonomousInit() {
	
		//autonomousCommand = new LeftOrRight(robotDrive, fire, load3);
		//autonomousCommand.start();
	}
	/**
	 * This function is called periodically during autonomous
	 *
	 * @Override
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		/*
		double currentTime = Timer.getFPGATimestamp() - startTime;
		Watchdog.getInstance().feed();
		//if(currentTime < 1)
		//	robotDrive.drive(.5, -.5);
		//else if(currentTime > 1 && currentTime < 2)
		//	robotDrive.drive(0, 0);
		if(!isHot)
		{
			try {
				//robotDrive.drive(.5,-.5);
				vision.doVisionCalc();
				System.out.println(vision.isHot());
				isHot = vision.isHot();
			} catch (NIVisionException ex) {
				ex.printStackTrace();
			} catch (AxisCameraException ex) {
				ex.printStackTrace();
			}
		}
		else if(currentTime > 3 && !hasShot)
		{
			fire.shoot(true);
			hasShot = true;
		}
		*/
	}

	/**
	 * This function is called once on entry to operator control
	 * 
	 * @Override
	 */
	public void teleopInit()
	{
		//int drivetype = pref.getInt("driveType", TANK_DRIVE);
		//if(drivetype == TANK_DRIVE)
		//{
		//	robotDrive = new TankDrive();
		//} else {
			
		//}
		
		
	}
	
	/**
	 * This function is called periodically during operator control
	 *
	 * @Override
	 */
	public void teleopPeriodic() {
		Watchdog.getInstance().feed();
		//try {
			//Driving
			robotDrive.drive();
			
			//Loader
			//load.runLoader();
			//loadX.runLoader();
			//load3.runLoader();
			//System.out.println(load3.getLimitSwitchValue());
			//shoot.runMotors();
			//Pneumatics
			fire.shoot();
			fire.pistonValue();
			//compressor
			compressor.compress();
			SmartDashboard.putBoolean("Comressor State ", compressor.getPressureValue());
			
			//System.out.println(compressor.getPressureValue());
		/*
			vision.doVisionCalc();
			System.out.println(vision.isHot());
		} catch (NIVisionException ex) {
			ex.printStackTrace();
		} catch (AxisCameraException ex) {
			ex.printStackTrace();
		}
		*/
	}


	/**
	 * This function is called periodically during test mode
	 *
	 * @Override
	 */
	public void testPeriodic() {
		
	}

}
