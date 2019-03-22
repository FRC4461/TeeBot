/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot;

import org.usfirst.frc.team4461.robot.OI;

import edu.wpi.first.wpilibj.GenericHID.Hand;

/**
 * drivebase
 * Malakai -- xbox controller
 * tyler -- joysticks

 */
public class DriverProfileTyler extends OI{
    public DriverProfileTyler(){
        
    }

    @Override
	public double getDriveSpeedX(){
		return leftJoystick.getX();
	}

    @Override
    public double getDriveSpeedY(){
		return leftJoystick.getY();
	}

    @Override
	public double getDriveRotationZ(){
		return rightJoystick.getX();
	}

    @Override
	public boolean getGripperPneumaticsForward(){
		return minecraftPig.getBumper(Hand.kRight);
	}
	
	@Override
	public boolean setLPillarPneumaticsOn(){
		return minecraftPig.getAButton();
	}

	@Override
	public boolean setLPillarPneumaticsOff(){
		return minecraftPig.getBButton();
	}

	@Override
	public boolean setPlatformPneumaticsOn(){
		return minecraftPig.getYButton();
	}

	@Override
	public boolean setPlatformPneumaticsOff(){
		return minecraftPig.getXButton();
	}

    @Override
	public double getPlatformDrive(){
		return minecraftPig.getY(Hand.kLeft);
	}

    @Override
	public double getArmDrive(){
		return minecraftPig.getY(Hand.kRight);
	}

    @Override
	public double getGripperWheelIntakeSpeed(){
		return minecraftPig.getTriggerAxis(Hand.kRight);
	}

    @Override
	public double getGripperWheelOuttakeSpeed(){
		return minecraftPig.getTriggerAxis(Hand.kLeft);
	}
}
