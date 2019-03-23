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
 * Add your docs here.
 */
public class DriverProfileMalakai extends OI{
    public DriverProfileMalakai(){
        
    }

    @Override
	public double getDriveSpeedX(){
		return minecraftPig.getX(Hand.kLeft);
	}

    @Override
    public double getDriveSpeedY(){
		return minecraftPig.getY(Hand.kLeft);
	}

    @Override
	public double getDriveRotationZ(){
		return minecraftPig.getX(Hand.kRight);
	}

    @Override
	public boolean getGripperPneumaticsForward(){
		return minecraftPig.getBumper(Hand.kRight);
	}

    @Override
	public boolean getGripperPneumaticsReverse(){
		return minecraftPig.getBumper(Hand.kLeft);
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
		return leftJoystick.getY();
	}

	@Override
	public double getArmDriveUp(){
		return minecraftPig.getTriggerAxis(Hand.kLeft);
	}

	@Override
	public double getArmDriveDown(){
		return minecraftPig.getTriggerAxis(Hand.kRight);
	}

	@Override
	public double getGripperWheelIntakeSpeed(){
		return minecraftPig.getY(Hand.kRight);
	}

	@Override
	public double getGripperWheelOuttakeSpeed(){
		return minecraftPig.getY(Hand.kRight);
	}
}
