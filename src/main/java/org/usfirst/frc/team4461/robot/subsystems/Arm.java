/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;

import org.usfirst.frc.team4461.robot.RobotMap;
import org.usfirst.frc.team4461.robot.commands.armcommands.DefaultArm;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DefaultArm());
  }

  public static void move(double speed){
    RobotMap.arm.set(ControlMode.PercentOutput, speed);
  }
  
  public static boolean getSwitch1(){
    return RobotMap.switch1.get();
  }

  public static boolean getSwitch2(){
    return RobotMap.switch2.get();
  }

  public static void stopArm(){
    RobotMap.arm.set(0);
  }
  public static void resetCounter(){
    RobotMap.counter1.reset();
    RobotMap.counter2.reset();
  }

  public static int getCounter1(){
    return RobotMap.counter1.get();
  }

  public static int getCounter2(){
    return RobotMap.counter2.get();
  }
}
