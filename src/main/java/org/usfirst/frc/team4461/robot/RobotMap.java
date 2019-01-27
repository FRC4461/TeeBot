/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static DoubleSolenoid doubleSolenoid;
    public static Compressor c;

    public static WPI_TalonSRX frontLeft;
    public static WPI_TalonSRX backLeft;
    public static WPI_TalonSRX frontRight;
    public static WPI_TalonSRX backRight;

    public static AnalogInput ai;

    public static void init() {
        backRight = new WPI_TalonSRX(1);
        frontLeft = new WPI_TalonSRX(2);
        frontRight = new WPI_TalonSRX(3);
        backLeft = new WPI_TalonSRX(4);

        c = new Compressor(0);
        doubleSolenoid = new DoubleSolenoid(0, 1);

        ai = new AnalogInput(3);
    }

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
