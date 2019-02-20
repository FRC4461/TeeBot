/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static Joystick leftJoystick;
	public static Joystick rightJoystick;
	public static JoystickButton left1, left2, left3;
	public static JoystickButton right1, right2, right3;

	public static XboxController minecraftPig;

	public OI() {
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
        minecraftPig = new XboxController(2);

		left1 = new JoystickButton(leftJoystick, 1);
		left2 = new JoystickButton(leftJoystick, 2);
		left3 = new JoystickButton(leftJoystick, 3);
	}

	public static double pigRightStickY(){
		return minecraftPig.getY(Hand.kRight);
	}

	public static double pigLeftStickY(){
		return minecraftPig.getY(Hand.kLeft);
	}

	public static boolean pigBButton() {
		return minecraftPig.getBButton();
	}	

	public static boolean pigAButton() {
		return minecraftPig.getAButton();
	}

	public static double pigLeftTrigger(){
		return minecraftPig.getTriggerAxis(Hand.kLeft);
	}

	public static double pigRightTrigger(){
		return minecraftPig.getTriggerAxis(Hand.kRight);
	}

	public static boolean pigLeftBumper(){
		return minecraftPig.getBumper(Hand.kLeft);
	}

	public static boolean pigRightBumper(){
		return minecraftPig.getBumper(Hand.kRight);
	}

	public static double getLeftY() {
		return leftJoystick.getY();
	}

	public static double getLeftX() {
		return leftJoystick.getX();
	}

	public static double getRightX() {
		return rightJoystick.getX();
	}
}