/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.grippercommands;

import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.subsystems.GripperWheels;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for operating the gripper wheels (not pneumatics)
 */
public class OperateGripper extends Command {
  public OperateGripper() {
    requires(Robot.gripper);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double intakeSpeed = Robot.m_oi.getGripperWheelIntakeSpeed();
    double outtakeSpeed = Robot.m_oi.getGripperWheelOuttakeSpeed();
    double diffAxis = intakeSpeed - outtakeSpeed;
    GripperWheels.runGripper(diffAxis);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
