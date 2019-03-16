/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.bumpercommands.OperateBumpers;;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Pneumatics for attaching & detaching the bumper to the platform.
 */
public class BumperPneumatics extends Subsystem {

  @Override
  public void initDefaultCommand() {
    // Nicole: There is nothing in DefaultBumper(). But Vince said it was okay?
    setDefaultCommand(new OperateBumpers());
  }

  // Todo: Review this. There are two sets of pneumatics for the bumper. I don't think this is complete.
  public void detachBumper(){
    RobotMap.doubleSolenoid2.set(Value.kForward);
  }
  
  public void attachBumper(){
    RobotMap.doubleSolenoid2.set(Value.kReverse);
  }
}
