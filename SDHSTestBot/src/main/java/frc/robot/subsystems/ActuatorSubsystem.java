package frc.robot.subsystems;

//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;


/**
 *
 */
public class ActuatorSubsystem extends SubsystemBase {
    private Compressor compressor;
    private Solenoid solenoid;
    private Relay solenoidRelay;
    private DoubleSolenoid solenoidDouble;

    /**
    *
    */
    public ActuatorSubsystem() {
        compressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
        addChild("Compressor", compressor);

        solenoid = new Solenoid(0, PneumaticsModuleType.CTREPCM, 0);
        addChild("Solenoid", solenoid);

        solenoidRelay = new Relay(1);
        addChild("SolenoidRelay", solenoidRelay);

        solenoidDouble = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, 2, 3);
        addChild("SolenoidDouble", solenoidDouble);

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
    public void CloseTheHand() {
        solenoid.set(true);
        
    }
    public void OpenTheand() {
        solenoid.set(false);

    }

    public void ToggleTheHand() {
        solenoid.toggle();
    }

}
