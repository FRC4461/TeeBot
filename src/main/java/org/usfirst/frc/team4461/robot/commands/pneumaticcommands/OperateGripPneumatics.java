/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.pneumaticcommands;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class OperateGripPneumatics extends Command {
  public OperateGripPneumatics() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.gripperPneumatics);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    boolean isAPressed  = OI.minecraftPig.getAButton();
    boolean isBPressed  = OI.minecraftPig.getBButton();
    if(isAPressed){
      Robot.gripperPneumatics.pushPiston();
    } else if(isBPressed){
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
