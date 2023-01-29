
package frc.robot.subsystems;

//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;


/**
 *
 */
public class DriveSubSystem extends SubsystemBase {
    private Spark motorControllerLeftDrive;
    private Spark motorControllerRightDrive;
    private DifferentialDrive differentialDrive;

    /**
    *
    */
    public DriveSubSystem() {
        motorControllerLeftDrive = new Spark(8);
        addChild("MotorControllerLeftDrive", motorControllerLeftDrive);
        motorControllerLeftDrive.setInverted(false);

        motorControllerRightDrive = new Spark(9);
        addChild("MotorControllerRightDrive", motorControllerRightDrive);
        motorControllerRightDrive.setInverted(false);

        differentialDrive = new DifferentialDrive(motorControllerLeftDrive, motorControllerRightDrive);
        addChild("DifferentialDrive", differentialDrive);
        differentialDrive.setSafetyEnabled(true);
        differentialDrive.setExpiration(0.1);
        differentialDrive.setMaxOutput(1.0);

    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
