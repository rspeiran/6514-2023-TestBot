package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import java.util.function.DoubleSupplier;

import frc.robot.subsystems.ActuatorSubsystem;


/**
 *
 */
public class HandClose extends CommandBase {

    private final ActuatorSubsystem m_actuatorSubsystem;


    public HandClose(ActuatorSubsystem subsystem) {


        m_actuatorSubsystem = subsystem;
        addRequirements(m_actuatorSubsystem);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_actuatorSubsystem.CloseTheHand();
    }

    // Called once the command ends or is interrupted.
    @Override
    public void end(boolean interrupted) {
    }

    // Returns true when the command should end.
    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;

    }
}
