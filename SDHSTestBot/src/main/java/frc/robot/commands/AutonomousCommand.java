
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import java.util.function.DoubleSupplier;


/**
 *
 */
public class AutonomousCommand extends CommandBase {


    public AutonomousCommand() {


        // m_subsystem = subsystem;
        // addRequirements(m_subsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
