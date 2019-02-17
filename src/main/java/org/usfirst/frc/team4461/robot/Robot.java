/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team4461.robot.commands.chassiscommands.*;
import org.usfirst.frc.team4461.robot.subsystems.Arm;
import org.usfirst.frc.team4461.robot.subsystems.Camera;
import org.usfirst.frc.team4461.robot.subsystems.Chassis;
import org.usfirst.frc.team4461.robot.subsystems.GripPneumatics;
import org.usfirst.frc.team4461.robot.subsystems.Gripper;
import org.usfirst.frc.team4461.robot.subsystems.Platform;
import org.usfirst.frc.team4461.robot.subsystems.Ultrasound;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 * 
 */

public class Robot extends TimedRobot {
	public static Chassis chassis = new Chassis();
	public static Ultrasound ultrasound = new Ultrasound();
	public static Camera camera = new Camera();
	public static Platform platform = new Platform();
	public static Arm arm = new Arm();
	public static Gripper gripper = new Gripper();
	public static GripPneumatics gripperPneumatics = new GripPneumatics();
	public static OI oi;

	public static double[] leftLengths, rightLengths;
	public static double[] leftX1, leftX2, leftY1, leftY2;
	public static double[] rightX1, rightX2, rightY1, rightY2;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	NetworkTable gripTable, leftTable, rightTable;

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		chassis.init();
		oi = new OI();
		RobotMap.c.setClosedLoopControl(true);
		
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		gripTable = inst.getTable("GRIP");
		leftTable = gripTable.getSubTable("leftLineReport");
		rightTable = gripTable.getSubTable("rightLineReport");

		m_chooser.setDefaultOption("Default Auto", new Drive());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		
		System.out.println("Robot initalized");
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		leftX1 = leftTable.getEntry("x1").getDoubleArray(new double[] {});
		leftX2 = leftTable.getEntry("x2").getDoubleArray(new double[] {});

		rightX1 = leftTable.getEntry("x1").getDoubleArray(new double[] {});
		rightX2 = leftTable.getEntry("x2").getDoubleArray(new double[] {});

		leftY1 = leftTable.getEntry("y1").getDoubleArray(new double[] {});
		leftY2 = leftTable.getEntry("y2").getDoubleArray(new double[] {});

		rightY1 = leftTable.getEntry("y1").getDoubleArray(new double[] {});
		rightY2 = leftTable.getEntry("y2").getDoubleArray(new double[] {});

		leftLengths = leftTable.getEntry("length").getDoubleArray(new double[] {});
		rightLengths = rightTable.getEntry("length").getDoubleArray(new double[] {});
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
