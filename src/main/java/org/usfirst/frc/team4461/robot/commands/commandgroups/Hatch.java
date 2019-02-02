/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.commands.commandgroups;

import org.usfirst.frc.team4461.robot.commands.chassiscommands.AlignRobot;
import org.usfirst.frc.team4461.robot.commands.chassiscommands.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Hatch extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Hatch() {
    System.out.println("Starting auto routine...");
    addSequential(new AlignRobot());
    addSequential(new DriveForward(0.5));
  }
}
