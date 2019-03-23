/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.bumpercommands.DefaultBumper;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pneumatics for attaching & detaching the bumper to the platform.
 */
public class BumperPneumatics extends Subsystem {

  @Override
  public void initDefaultCommand() {
    // Nicole: There is nothing in DefaultBumper(). But Vince said it was okay?
    setDefaultCommand(new DefaultBumper());
  }

  public void attachBumperToPlatform(boolean isOn){
    RobotMap.platformSolenoid.set(isOn);
  }
  
  public void attachBumperFromL(boolean isOn){
    RobotMap.lPillarSolenoid.set(isOn);
  }
}
