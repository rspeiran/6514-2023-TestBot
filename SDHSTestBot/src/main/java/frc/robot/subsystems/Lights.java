package frc.robot.subsystems;

//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;


/**
 *
 */
public class Lights extends SubsystemBase {
    private Relay spike1;

    /**
    *
    */
    public Lights() {
        spike1 = new Relay(0);
        addChild("Spike 1", spike1);

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
    public void TurnTheLightsOn() {
        spike1.set(Value.kOn);
    }
    public void TurnTheLightOff() {
        spike1.set(Value.kOff);

    }

}
