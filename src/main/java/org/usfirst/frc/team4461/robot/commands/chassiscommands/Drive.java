/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.chassiscommands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4461.robot.Robot;

/**
 * Mecanum drive command
 */
public class Drive extends Command {
    
    public Drive() {
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly  Command is scheduled to run
    @Override
    protected void execute() {

        double xSpeed = Robot.m_oi.getDriveSpeedX();
        double ySpeed = Robot.m_oi.getDriveSpeedY();
        double zRotation = Robot.m_oi.getDriveRotationZ() / 3;

        Robot.chassis.Driving(ySpeed, xSpeed, zRotation);
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