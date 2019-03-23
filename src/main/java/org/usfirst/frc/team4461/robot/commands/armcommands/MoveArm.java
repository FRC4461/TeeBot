/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.armcommands;

import org.usfirst.frc.team4461.robot.OI;
import org.usfirst.frc.team4461.robot.Robot;
import org.usfirst.frc.team4461.robot.subsystems.Arm;
import edu.wpi.first.wpilibj.GenericHID.Hand;

import edu.wpi.first.wpilibj.command.Command;

public class MoveArm extends Command {

  public MoveArm() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.arm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // double speed = -Robot.m_oi.getArmDrive() / 3;

    double speedUp = Robot.m_oi.getArmDriveUp();
		double speedDown = Robot.m_oi.getArmDriveDown();
    double speed = (speedUp - speedDown) / 3;

    double wrist = Robot.m_oi.getWristSpeed();
    Arm.rotateWrist(wrist);
    Arm.move(speed);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return !Arm.getSwitch1() || !Arm.getSwitch2();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Arm.stopArm();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
