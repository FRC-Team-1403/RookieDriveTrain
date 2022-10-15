// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private final XboxController m_joy = new XboxController(Constants.XBoxControllerPort);

  private final Drivetrain m_drivetrain = new Drivetrain(
  new TalonSRX(Constants.driveTrainFrontLeftID), 
  new TalonSRX(Constants.driveTrainFrontRightID), 
  new TalonSRX(Constants.driveTrainBackLeftID), 
  new TalonSRX(Constants.driveTrainBackRightID));

  private final TankDrive m_driveTank = new TankDrive(m_drivetrain, m_joy);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    m_drivetrain.setDefaultCommand(m_driveTank);
    configureButtonBindings();
  }

  /**
   * Allow access to drivetrain
   * @return drive train initialized within robot container
   */
  public Drivetrain getDrivetrain() {
    return m_drivetrain;
  }

  /**
   * Allow access to drivetank command
   * @return drive tank command initialized within robot container
   */
  public TankDrive getDriveTankCommand() {
    return m_driveTank;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}
}
