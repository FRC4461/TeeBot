/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.chassiscommands.Drive;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The chassis (part that drives) subsystem.
 */
public class Chassis extends Subsystem {
	private static MecanumDrive mDrive;

	public Chassis(){
	}

	public void initDefaultCommand() {
		setDefaultCommand(new Drive());
	}

	public void init(){
		mDrive = new MecanumDrive(RobotMap.frontLeft, RobotMap.backLeft, RobotMap.frontRight, RobotMap.backRight);
	}
	
	public void Driving(double ySpeed, double xSpeed, double zRotation) {
		mDrive.driveCartesian(ySpeed, xSpeed, zRotation, RobotMap.gyro.getAngle());
	}
}
