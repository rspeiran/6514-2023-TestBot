package frc.robot.commands;

import frc.robot.subsystems.DriveSubSystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.util.function.DoubleSupplier;

/** Have the robot drive tank style. */
public class DriveTank extends CommandBase {
    private final DriveSubSystem m_driveSubSystem;
    private final DoubleSupplier m_left;
    private final DoubleSupplier m_right;

    /**
     * Creates a new TankDrive command.
     *
     * @param left       The control input for the left side of the drive
     * @param right      The control input for the right sight of the drive
     * @param drivesubsystem  The drivetrain subsystem to drive
     */
    public DriveTank(DoubleSupplier left, DoubleSupplier right, DriveSubSystem driveSubSystem) {
        m_driveSubSystem = driveSubSystem;
        m_left = left;
        m_right = right;
        addRequirements(m_driveSubSystem);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        m_driveSubSystem.drive(m_left.getAsDouble(), m_right.getAsDouble());
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false; // Runs until interrupted
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        m_driveSubSystem.drive(0, 0);
    }
}
