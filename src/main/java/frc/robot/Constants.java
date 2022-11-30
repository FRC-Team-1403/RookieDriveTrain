// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Change ID's to fit your robot
    public static int driveTrainFrontLeftID = 2;
    public static int driveTrainFrontRightID = 6;
    public static int driveTrainBackLeftID = 0;
    public static int driveTrainBackRightID = 5;

    // Whether motors are inverted or not
    public static boolean driveTrainLeftInverted = false;
    public static boolean driveTrainRightInverted = true;

    // Scaling factor for purposes of testing & saftey
    public static double scalingFactorLeftDrivetrain = 0.3;
    public static double scalingFactorRightDrivetrain = 0.5;

    // Change to fit port of Controller
    public static int XBoxControllerPort = 0;
}
