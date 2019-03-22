/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.bumpercommands;
import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultBumper extends Command {
  public DefaultBumper() {
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
    boolean attachBumperToL = Robot.m_oi.setLPillarPneumaticsOn();
    boolean deattachBumperToL = Robot.m_oi.setLPillarPneumaticsOff();

    if(attachBumperToL){
      Robot.bumperPneumatics.attachBumperFromL(true);
    } else if(deattachBumperToL){
      // For HONK HONK OH GEEBUS I SHOULD NOT HAVE PRESSED THAT
      Robot.bumperPneumatics.attachBumperFromL(false);
    }

    boolean attachBumperToPlatform = Robot.m_oi.setPlatformPneumaticsOn();
    boolean deattachBumperToPlatform = Robot.m_oi.setPlatformPneumaticsOff();

    if (attachBumperToPlatform){
      Robot.bumperPneumatics.attachBumperToPlatform(true);
    } else if (deattachBumperToPlatform){
      // For BEEP BEEP OH GOD I DIDN'T MEAN TO DO THAT
      Robot.bumperPneumatics.attachBumperToPlatform(false);
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
