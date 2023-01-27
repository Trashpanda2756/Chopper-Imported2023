// package frc.robot.commands;

// import edu.wpi.first.wpilibj.DoubleSolenoid;
// import edu.wpi.first.wpilibj2.command.*;
// import frc.robot.subsystems.ChopperDrive;
// import frc.robot.subsystems.HoodActuator;
// import frc.robot.subsystems.Hopper;
// import frc.robot.subsystems.IntakeMotor;
// import frc.robot.subsystems.LiftActuator;
// import frc.robot.subsystems.LiftMotor;
// import frc.robot.subsystems.HoodFlywheels;

// public class AutonomousDriveAndShootCloseCommandGroup extends SequentialCommandGroup {
//     public AutonomousDriveAndShootCloseCommandGroup(HoodActuator hoodActuator, HoodFlywheels hoodFlywheels, ChopperDrive chopperDrive, Hopper hopper, LiftActuator liftActuator, LiftMotor liftMotor) {
//         super(new InstantCommand(() -> {
//                     hoodActuator.hoodDown();
//                     System.out.println("You're fired!");
//                     hoodFlywheels.flywheelSpeedGreen();
//                     liftMotor.ShooterLiftStart();
//                 }),
//                 new RunCommand(() -> {
//                     System.out.println("Shooter Delay");
//                 }).withTimeout(1.0),
//                 new MecanumCommand(() -> -0.5, () -> 0.0, () -> 0.0, chopperDrive).withTimeout(1.0),
//                 new RunCommand(() -> {
//                             chopperDrive.stop();
//                             hopper.hopperSpinCounterClockwiseFast();
//                             liftActuator.engage();
//                         }).withTimeout(4.0),
//                 new InstantCommand(
//                         // Start Runnable
//                         () -> {
//                             hoodFlywheels.flywheelOff();
//                             hopper.hopperStop();
//                             liftActuator.disengage();
//                             liftMotor.ShooterLiftStop();
//                             hoodActuator.hoodUp();
//                         })
//                 );
//                 System.out.println("starting drive back");

//             }
// }