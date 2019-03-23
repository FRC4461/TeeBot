/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.grippneumaticcommands.OperateGripPneumatics;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pneumatics for the gripper.
 */
public class GripPneumatics extends Subsystem {

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new OperateGripPneumatics());
  }

  // Todo: double check that the forward and reverse are correctly assigned to push vs pull
  public void pushPiston(){
    RobotMap.hatchDoubleSolenoid.set(Value.kForward);
  }

  public void pullPiston(){
    RobotMap.hatchDoubleSolenoid.set(Value.kReverse);
  }
}
