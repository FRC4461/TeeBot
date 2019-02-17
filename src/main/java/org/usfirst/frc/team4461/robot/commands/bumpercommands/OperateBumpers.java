/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.bumpercommands;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OperateBumpers extends Command {
  public OperateBumpers() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.bumperPneumatics);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean leftBumperPress = OI.pigLeftBumper();
    boolean rightBumperPress = OI.pigRightBumper();
    if(leftBumperPress){
      Robot.bumperPneumatics.detachBumper();
    } else if(rightBumperPress){
      Robot.bumperPneumatics.attachBumper();
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
