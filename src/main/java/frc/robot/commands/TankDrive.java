package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/**
 * Command that drives drive train in tank drive style.
 */
public class TankDrive extends CommandBase {
    
    /**
     * Constructor for TankDrive
     * @param drivetrain drivetrain subsystem
     * @param joy xbox controller
     */
    public TankDrive(Drivetrain drivetrain, XboxController joy) {
        // Setting member variables
        m_drivetrain = drivetrain;
        m_joy = joy;

        // Telling command that it is utilizing this subsystem
        addRequirements(drivetrain);

        // Drivetrain will automatically run this command if no other commands are running for it, a default command
        m_drivetrain.setDefaultCommand(this);
    }

    @Override
    public void execute() {
        // Get values from left and right joystick using their y-axis
        double leftY = setDeadZone(m_joy.getLeftY(), 0.05);
        double rightY = setDeadZone(m_joy.getRightY(), 0.05);

        // Set speed of motors using the two joysticks
        m_drivetrain.setLeftMotors(leftY);
        m_drivetrain.setRightMotors(rightY);
    }

    /**
     * Set deadzone for axis values
     * @param value value from joystick
     * @param deadzone deadzone for value
     * @return value of joystick after applying deadzone
     */
    private double setDeadZone(double value, double deadzone) {
        // If motor is below the deadzone, don't run any motors
        if (Math.abs(value) < deadzone) {
            return 0;
        }
        return value;
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        m_drivetrain.stopMotors();
    }
    private Drivetrain m_drivetrain;
    private XboxController m_joy;
}
