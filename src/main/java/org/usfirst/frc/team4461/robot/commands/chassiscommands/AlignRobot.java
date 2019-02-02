/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.chassiscommands;

import org.usfirst.frc.team4461.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AlignRobot extends Command {

  private double cameraHalf;
  private double deadZone;
  private double cameraDeadleft, cameraDeadRight;
  private double lSpeed, rSpeed;
  private double leftCenter, rightCenter;
  private double trueCenter;

  boolean commandDone = false;

  public AlignRobot() {
    requires(Robot.chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    deadZone = 50;
    cameraHalf = 640 / 2;
    cameraDeadleft = cameraHalf - deadZone;
    cameraDeadRight = cameraHalf + deadZone;
    lSpeed = -0.3;
    rSpeed = 0.3;
    System.out.println("Aligning...");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Do alignment calcs
    if (Robot.leftX1.length >= 1 && Robot.leftX2.length >= 1 && Robot.rightX1.length >= 1
        && Robot.rightX2.length >= 1) {
      leftCenter = (Robot.leftX1[0] + Robot.leftX2[0]) / 2;
      rightCenter = (Robot.rightX1[0] + Robot.rightX2[0]) / 2;
      trueCenter = (leftCenter + rightCenter) / 2;
      if (trueCenter < cameraDeadRight && trueCenter > cameraDeadleft) {
        commandDone = true;
      } else if (trueCenter > cameraDeadRight) {
        double xVal = rSpeed;
        Robot.chassis.Driving(0, xVal, 0);
      } else if (trueCenter < cameraDeadleft) {
        double xVal = lSpeed;
        Robot.chassis.Driving(0, xVal, 0);
      }
    } else if (Robot.leftX1.length > 0 ) {
      double xVal = rSpeed;
      Robot.chassis.Driving(0, xVal, 0);
    } else if (Robot.rightX1.length > 0) {
      double xVal = lSpeed;
      Robot.chassis.Driving(0, xVal, 0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return commandDone;
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
