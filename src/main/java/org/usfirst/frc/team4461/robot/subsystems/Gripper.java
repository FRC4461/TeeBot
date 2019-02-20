/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.grippercommands.OperateGripper;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Gripper wheels subsystem. (the name of the subsystem does not accurately reflect this, I know.
 * Blame Vince.)
 */
public class Gripper extends Subsystem {
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new OperateGripper());
  }

  public static void runGripper(double pigGripSpeed){
    RobotMap.leftGrip.set(ControlMode.PercentOutput, pigGripSpeed);
    RobotMap.rightGrip.set(ControlMode.PercentOutput, -pigGripSpeed);
  }
}
