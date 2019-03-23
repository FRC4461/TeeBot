/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	protected static Joystick leftJoystick = new Joystick(0);
	protected static Joystick rightJoystick = new Joystick(1);

	public static XboxController minecraftPig = new XboxController(2);

	public OI() {
	}

	// Default left driving control
	public double getDriveSpeedX(){
		return leftJoystick.getX();
	}

	// Default right driving control
	public double getDriveSpeedY(){
		return leftJoystick.getY();
	}

	public double getDriveRotationZ(){
		return rightJoystick.getX();
	}

	public boolean getGripperPneumaticsForward(){
		return minecraftPig.getBumper(Hand.kRight);
	}

	public boolean getGripperPneumaticsReverse(){
		return minecraftPig.getBumper(Hand.kLeft);
	}

	public boolean setLPillarPneumaticsOn(){
		return minecraftPig.getAButton();
	}

	public boolean setLPillarPneumaticsOff(){
		return minecraftPig.getBButton();
	}

	public boolean setPlatformPneumaticsOn(){
		return minecraftPig.getYButton();
	}

	public boolean setPlatformPneumaticsOff(){
		return minecraftPig.getXButton();
	}

	public double getPlatformDrive(){
		return minecraftPig.getY(Hand.kLeft);
	}

	public double getArmDriveUp(){
		return minecraftPig.getTriggerAxis(Hand.kLeft);
	}

	public double getArmDriveDown(){
		return minecraftPig.getTriggerAxis(Hand.kRight);
	}

	public double getGripperWheelIntakeSpeed(){
		return minecraftPig.getY(Hand.kRight);
	}

	public double getGripperWheelOuttakeSpeed(){
		return minecraftPig.getY(Hand.kRight);
	}

	// uhh actually put a control here
	public double getWristSpeed() {
		return 0.1;
	}
}