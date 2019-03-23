/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.grippneumaticcommands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for operating gripper pneumatics during gameplay
 */
public class OperateGripPneumatics extends Command {
  public OperateGripPneumatics() {
    requires(Robot.gripperPneumatics);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean setForward  = Robot.m_oi.getGripperPneumaticsForward();
    boolean setReverse  = Robot.m_oi.getGripperPneumaticsReverse();
    if(setForward){
      Robot.gripperPneumatics.pushPiston();
    } else if(setReverse){
      Robot.gripperPneumatics.pullPiston();
    }
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
