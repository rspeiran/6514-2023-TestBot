
package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;

import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import frc.robot.subsystems.*;

import frc.robot.subsystems.DriveSubSystem;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot
 * (including subsystems, commands, and button mappings) should be declared
 * here.
 */
public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();

  // The robot's subsystems
  public final ActuatorSubsystem m_actuatorSubsystem = new ActuatorSubsystem();
  public final Lights m_lights = new Lights();
  public final DriveSubSystem m_driveSubSystem = new DriveSubSystem();

  // Joysticks
  private final PS4Controller pS4Controller = new PS4Controller(0);


  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  private RobotContainer() {
    // Smartdashboard Subsystems

    // SmartDashboard Buttons
    SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    SmartDashboard.putData("LightOn", new LightOn(m_lights));
    SmartDashboard.putData("LightOff", new LightOff(m_lights));
    SmartDashboard.putData("HandOpen", new HandOpen(m_lights));
    SmartDashboard.putData("HandClose", new HandClose(m_lights));
    SmartDashboard.putData("DriveStraight", new DriveStraight());

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // Configure autonomous sendable chooser


    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());


    SmartDashboard.putData("Auto Mode", m_chooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton pS4ButtonSquare = new JoystickButton(pS4Controller, PS4Controller.Button.kSquare.value);
    pS4ButtonSquare.onTrue(new LightOn(m_lights).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

    final JoystickButton pS4ButtonCross = new JoystickButton(pS4Controller, PS4Controller.Button.kCross.value);
    pS4ButtonCross.onTrue(new LightOff(m_lights).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

    final JoystickButton pS4ButtonCircle = new JoystickButton(pS4Controller, PS4Controller.Button.kCircle.value);
    pS4ButtonCircle.onTrue(new HandOpen(m_lights).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

    final JoystickButton pS4ButtonTriangle = new JoystickButton(pS4Controller, PS4Controller.Button.kTriangle.value);
    pS4ButtonTriangle.onTrue(new HandClose(m_lights).withInterruptBehavior(InterruptionBehavior.kCancelSelf));

  }

  public PS4Controller getPS4Controller() {
    return pS4Controller;
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }

}
