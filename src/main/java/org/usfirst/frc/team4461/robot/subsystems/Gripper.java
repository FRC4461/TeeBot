/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.cameracommands.DefaultCamCommand;
import org.usfirst.frc.team4461.robot.commands.grippercommands.OperateGripper;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Gripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new OperateGripper());
  }

  public static void runGripper(double pigGripSpeed){
    RobotMap.leftGrip.set(ControlMode.PercentOutput, pigGripSpeed);
    RobotMap.rightGrip.set(ControlMode.PercentOutput, -pigGripSpeed);
  }
}
