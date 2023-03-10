
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
//import java.util.function.DoubleSupplier;

import frc.robot.subsystems.Lights;


/**
 *
 */
public class LightOn extends CommandBase {

    private final Lights m_lights;

 
    public LightOn(Lights subsystem) {

 
        m_lights = subsystem;
        addRequirements(m_lights);

    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        m_lights.TurnTheLightsOn();
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
