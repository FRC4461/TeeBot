/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.platformcommands;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for bringing the platform up and down.
 */
public class OperatePlatform extends Command {
  double deadZone;

  public OperatePlatform() {
    requires(Robot.platform);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    deadZone = 0.05;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double rightTriggerAxis = OI.pigRightTrigger();
    double leftTriggerAxis = OI.pigLeftTrigger();
    double differenceOfAxis = leftTriggerAxis - rightTriggerAxis;

    if (differenceOfAxis > deadZone || differenceOfAxis < deadZone) {
        Robot.platform.platformMove(differenceOfAxis);
    } else {
        Robot.platform.stopPlatform();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  // If either of the limit switches are activated, tell the robot to stop the platform
  // Todo: double check if the switches were assigned correctly.
  @Override
  protected boolean isFinished() {
    return !RobotMap.switch3.get() || !RobotMap.switch4.get();
  }

  // Called once after isFinished returns true
  // The motors will be set to zero to stop the platform from continuing
  @Override
  protected void end() {
    Robot.platform.stopPlatform();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
