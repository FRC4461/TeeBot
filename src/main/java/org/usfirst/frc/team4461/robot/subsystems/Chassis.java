/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.chassiscommands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Chassis extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private static MecanumDrive mDrive;

	public void initDefaultCommand() {
		setDefaultCommand (new Drive());
		// Set the default command for a subsystem here.
	}

	public void init(){
	mDrive = new MecanumDrive(RobotMap.frontLeft, RobotMap.backLeft,
    RobotMap.frontRight, RobotMap.backRight);
	}

	public void Driving (double yVal, double xVal, double zVal) {
		double ySpeed = yVal ;
		double xSpeed = xVal;
		double zRotation = zVal;
		mDrive.driveCartesian(ySpeed, xSpeed, zRotation);
	}
}

