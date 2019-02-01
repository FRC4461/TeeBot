/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4461.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4461.robot.commands.cameracommands.CycleCams;
import org.usfirst.frc.team4461.robot.commands.pneumaticcommands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public static Joystick leftJoystick;
	public static Joystick rightJoystick;
	public static JoystickButton one, two, three;

	public static XboxController minecraftPig;

	public OI() {
		leftJoystick = new Joystick(0);
		rightJoystick = new Joystick(1);
        minecraftPig = new XboxController(2);

		one = new JoystickButton(rightJoystick, 1);
		two = new JoystickButton(leftJoystick, 2);
		three = new JoystickButton(leftJoystick, 3);
		one.toggleWhenPressed(new CycleCams());
		two.toggleWhenPressed(new ForwardPiston());
		three.toggleWhenPressed(new ReversePiston());
	}

	public static boolean buttonA() {
		return minecraftPig.getAButton();

	}

	public static boolean buttonB() {
		return minecraftPig.getBButton();
	}

	public static double getLeftY() {
		return leftJoystick.getY();
	}

	public static double getLeftX() {
		return leftJoystick.getX();
	}

	public static double getleftZ() {
		return leftJoystick.getZ();
	}

	public static double getRightX() {
		return rightJoystick.getX();
	}
}