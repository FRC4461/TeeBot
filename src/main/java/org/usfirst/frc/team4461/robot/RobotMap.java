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
import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    //Pneumatics stuff
    public static DoubleSolenoid hatchDoubleSolenoid;
    public static Solenoid lPillarSolenoid, platformSolenoid;
    public static Compressor c;

    //Drivebase motors
    public static WPI_TalonSRX frontLeft;
    public static WPI_TalonSRX backLeft;
    public static WPI_TalonSRX frontRight;
    public static WPI_TalonSRX backRight;

    //Platform motors
    public static WPI_TalonSRX platformFront;
    public static WPI_TalonSRX platformBack;

    //Arm motor
    public static WPI_TalonSRX arm;
    public static WPI_TalonSRX wrist;

    //Gripper motors
    public static WPI_TalonSRX leftGrip, rightGrip;

    //Ultrasound
    public static AnalogInput ai;

    //Arm limit switches
    public static DigitalInput switch1, switch2;

    //Arm counter
    public static Counter counter1, counter2;

    //Platform limit swithces
    public static DigitalInput switch3, switch4;

    //Platform counter
    public static Counter counter3, counter4;

    //Gyro
    public static ADXRS450_Gyro gyro;

    public static void init() {
        backRight = new WPI_TalonSRX(2);
        frontLeft = new WPI_TalonSRX(3);
        frontRight = new WPI_TalonSRX(1);
        backLeft = new WPI_TalonSRX(4);

        platformFront = new WPI_TalonSRX(5);
        platformBack = new WPI_TalonSRX(7);

        arm = new WPI_TalonSRX(6);
        wrist = new WPI_TalonSRX(10);

        leftGrip = new WPI_TalonSRX(8);
        rightGrip = new WPI_TalonSRX(9);

        c = new Compressor(0);
        hatchDoubleSolenoid = new DoubleSolenoid(2, 3);
        lPillarSolenoid = new Solenoid(1);
        platformSolenoid = new Solenoid(0);

        ai = new AnalogInput(3);

        switch1 = new DigitalInput(1);
        switch2 = new DigitalInput(2);
        switch3 = new DigitalInput(3);
        switch4 = new DigitalInput(4);

        counter1 = new Counter(switch1);
        counter2 = new Counter(switch2);
        counter3 = new Counter(switch3);
        counter4 = new Counter(switch4);

        gyro = new ADXRS450_Gyro(SPI.Port.kOnboardCS0);
    }
}
