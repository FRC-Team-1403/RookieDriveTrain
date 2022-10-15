package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Drive train subsystem containing all the methods nessecary to control drive train.
 */
public class Drivetrain extends SubsystemBase {
    
    /**
     * Constructor used to create Drivetrain 
     * @param frontLeft Motor controller controlling front left motor
     * @param frontRight Motor controller controlling front right motor
     * @param backLeft Motor controller controlling back left motor
     * @param backRight Motor controller controlling back right motor
     */
    public Drivetrain(TalonSRX frontLeft, TalonSRX frontRight, 
                      TalonSRX backLeft, TalonSRX backRight) {
        // Set member variables here
        m_frontLeft = frontLeft;                  
        m_frontRight = frontRight;
        m_backLeft = backLeft;
        m_backRight = backRight;

        // Make back motors follow the instructions set to the front motors
        m_backRight.follow(frontRight);
        m_backLeft.follow(frontLeft);
    }

    /**
     * Set the speed of right side motors
     * @param speed speed to set right motors (goes from -1 to 1)
     */
    public void setRightMotors(double speed) {
        m_frontRight.set(TalonSRXControlMode.PercentOutput, speed * Constants.scalingFactorDrivetrain);
    }

    /**
     * Set the speed of left side motors
     * @param speed speed to set left motors (goes from -1 to 1)
     */
    public void setLeftMotors(double speed) {
        m_frontLeft.set(TalonSRXControlMode.PercentOutput, speed * Constants.scalingFactorDrivetrain);
    }

    /**
     * Stop both left side and right side motors
     */
    public void stopMotors() {
        m_frontLeft.set(TalonSRXControlMode.PercentOutput, 0);
        m_frontRight.set(TalonSRXControlMode.PercentOutput, 0);
    }

    private final TalonSRX m_frontRight;
    private final TalonSRX m_frontLeft;
    private final TalonSRX m_backRight;
    private final TalonSRX m_backLeft;
}
