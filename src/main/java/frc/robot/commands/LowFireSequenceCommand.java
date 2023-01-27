// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.InstantCommand;
// import edu.wpi.first.wpilibj2.command.RunCommand;
// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.subsystems.HoodActuator;
// import frc.robot.subsystems.HoodFlywheels;
// import frc.robot.subsystems.Hopper;
// import frc.robot.subsystems.LiftActuator;
// import frc.robot.subsystems.LiftMotor;


// // NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// // information, see:
// // https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
// public class LowFireSequenceCommand extends SequentialCommandGroup {

//   HoodActuator m_hoodActuator;
//   HoodFlywheels m_hoodFlywheels;
//   Hopper m_hopper;
//   LiftActuator m_liftActuator;
//   LiftMotor m_liftMotor;

//   /** Creates a new LowFireSequenceCommand. */
//   public LowFireSequenceCommand(HoodActuator hoodActuator, HoodFlywheels hoodFlywheels, Hopper hopper, LiftActuator liftActuator, LiftMotor liftMotor) {
//     super(new InstantCommand(() -> {
//       hoodActuator.hoodDown();;
//       System.out.println("You're fired!");
//       hoodFlywheels.flywheelSpeedGreen();
//       liftMotor.ShooterLiftStart();
//   }),
//   new RunCommand(() -> {
//       // System.out.println("Shooter Delay");
//   }).withTimeout(1.0),
//   new RunCommand(() -> {
//               hopper.hopperSpinCounterClockwiseFast();
//               liftActuator.engage();
//           }).withTimeout(4.0),
//   new InstantCommand(
//           // Start Runnable
//           () -> {
//               hoodFlywheels.flywheelOff();
//               hopper.hopperStop();
//               liftActuator.disengage();
//               liftMotor.ShooterLiftStop();
//               hoodActuator.hoodDown();
//           })
//   );
//   System.out.println("starting drive back");

//   m_hoodFlywheels = hoodFlywheels;
//   m_hopper = hopper;
//   m_liftActuator = liftActuator;
//   m_liftMotor = liftMotor;
//   m_hoodActuator = hoodActuator;

//   }

//   @Override
//     public void end(boolean interrupted) {
//       m_hoodFlywheels.flywheelOff();
//       m_hopper.hopperStop();
//       m_liftActuator.disengage();
//       m_liftMotor.ShooterLiftStop();
//       m_hoodActuator.hoodDown();
//     }
// }
