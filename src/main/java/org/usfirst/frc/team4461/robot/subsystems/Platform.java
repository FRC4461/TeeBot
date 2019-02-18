/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.platformcommands.PlatformDefault;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here. no
 */
public class Platform extends Subsystem {

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new PlatformDefault());
  }

  public void platformUp(double speed){
    RobotMap.platformFront.set(ControlMode.PercentOutput, speed);
    RobotMap.platformBack.set(ControlMode.PercentOutput, speed);
  }

  public void platformDown(double speed){
    RobotMap.platformFront.set(ControlMode.PercentOutput, speed);
    RobotMap.platformBack.set(ControlMode.PercentOutput, speed);
  }

  public void stopPlatform(){
    RobotMap.platformFront.set(0);
    RobotMap.platformBack.set(0);    
  }

}
