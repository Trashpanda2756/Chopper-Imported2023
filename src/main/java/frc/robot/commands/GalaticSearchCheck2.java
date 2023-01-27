// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import java.util.function.DoubleSupplier;

// import com.kauailabs.navx.frc.AHRS;

// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// import edu.wpi.first.wpilibj2.command.RunCommand;
// import frc.robot.FeetToTickMath;
// import frc.robot.logging.LogWrapper;
// import frc.robot.logging.PeriodicLogger;
// import frc.robot.subsystems.ChopperDrive;
// import frc.robot.subsystems.Hopper;
// import frc.robot.subsystems.IntakeActuator;
// import frc.robot.subsystems.IntakeMotor;

// public class GalaticSearchCheck2 extends CommandBase {

//   private AHRS navSensor;
//   private DoubleSupplier gyro;
//   private Hopper m_hopper;
//   private IntakeMotor m_intakeMotor;
//   private IntakeActuator m_intakeActuator;
//   private ChopperDrive m_chopperDrive;
//   private GalacticSearch galacticSearch;
//   private NetworkTableEntry PowercellLocation;

//   private boolean firstRun = true;

//   private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
//   private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);

//   /** Creates a new GalaticSearchCheck. */
//   public GalaticSearchCheck2(GalacticSearch galacticSearch, ChopperDrive m_chopperDrive, IntakeActuator m_intakeActuator, IntakeMotor m_intakeMotor, Hopper m_hopper, AHRS navSensor) {
//     // Use addRequirements() here to declare subsystem dependencies.
//     this.navSensor = navSensor;
//     this.m_hopper = m_hopper;
//     this.m_intakeMotor = m_intakeMotor;
//     this.m_intakeActuator = m_intakeActuator;
//     this.m_chopperDrive = m_chopperDrive;
//     this.galacticSearch = galacticSearch;
//   }


//   // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//     firstRun = true;
//     mLog.debug(this.getClass().getName() + ": initialize " );
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//     PowercellLocation = NetworkTableInstance.getDefault().getTable("datatable").getEntry("Galactic Search Value");

//     if ( PowercellLocation.getDouble(0.0) != 0){
//       if ( firstRun ) {
//         mLog.debug(this.getClass().getName() + ":" + PowercellLocation.getDouble(0.0) + " adding command");
//         galacticSearch.myAddCommands(
        
//           new RunCommand(() -> {
//             System.out.println("Drive Delay");
//             m_chopperDrive.resetDistance();
//           }).withTimeout(0.275),

//           // new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.strafe(1.0), ()-> navSensor.getAngle() * -1 ),
//           // new RunCommand(() -> {
//             // System.out.println("Drive Delay");
//             // m_chopperDrive.resetDistance();
//           // }).withTimeout(0.275),

//           new RunCommand(() -> {
//             m_intakeMotor.in();
//             m_chopperDrive.resetDistance();
//           }).withTimeout(0.175),
//           new RunCommand( () -> {
//             m_intakeActuator.intakeOut();
//           }).withTimeout(0.175),      
          
//           new MecanumDriveForwardForDistance(()->0.5, ()->0.0, ()->0.0, m_chopperDrive, ()->FeetToTickMath.forwardBackward(1.0), () -> navSensor.getAngle() * -1 ),
//           new RunCommand(() -> {
//             System.out.println("Drive Delay");
//             m_chopperDrive.resetDistance();
//           }).withTimeout(0.275),

//           new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.strafe(5.0), ()-> navSensor.getAngle() * -1 ),
//           new RunCommand(() -> {
//             System.out.println("Drive Delay");
//             m_chopperDrive.resetDistance();
//           }).withTimeout(0.275),

//           new MecanumDriveForwardForDistance(()->0.5, ()->0.0, ()->0.0, m_chopperDrive, ()->FeetToTickMath.forwardBackward(5.0), () -> navSensor.getAngle() * -1 ),
//           new RunCommand(() -> {
//             System.out.println("Drive Delay");
//             m_chopperDrive.resetDistance();
//           }).withTimeout(0.275),

//           new MecanumStrafeRightForDistance(()-> 0.0, ()-> 0.5, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.strafe(5.0), ()-> navSensor.getAngle() * -1 ),
//           new RunCommand(() -> {
//             System.out.println("Drive Delay");
//             m_chopperDrive.resetDistance();
//           }).withTimeout(0.275),

//           new MecanumDriveForwardForDistance(()->0.5, ()->0.0, ()->0.0, m_chopperDrive, ()->FeetToTickMath.forwardBackward(7.0), () -> navSensor.getAngle() * -1 ),
//           new RunCommand(() -> {
//             System.out.println("Drive Delay");
//             m_chopperDrive.resetDistance();
//           }).withTimeout(0.275)
        
//         );
//         firstRun = false;
//       }
//     } else {
//       if( firstRun ) {
//         mLog.debug(this.getClass().getName() + ":" + PowercellLocation.getDouble(0.0) + " adding command");
//         galacticSearch.myAddCommands(new MecanumStrafeRightForDistance(()->0.0, ()->0.5, ()->0.0, m_chopperDrive, ()-> FeetToTickMath.strafe(2.0), () -> navSensor.getAngle() * -1 ),
//         new RunCommand(() -> {
//           m_intakeMotor.in();
//           m_chopperDrive.resetDistance();
//         }).withTimeout(0.175),
//         new RunCommand( () -> {
//           m_intakeActuator.intakeOut();
//         }).withTimeout(0.175),      
//         new MecanumDriveForwardForDistance(()-> 0.5, ()-> 0.0, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.forwardBackward(1.0), ()-> navSensor.getAngle() * -1 ),
//         new RunCommand(() -> {
//           System.out.println("Drive Delay");
//           m_chopperDrive.resetDistance();
//         }).withTimeout(0.275),
//         new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.strafe(8.5), ()-> navSensor.getAngle() * -1 ),
//         new RunCommand(() -> {
//           System.out.println("Drive Delay");
//           m_chopperDrive.resetDistance();
//         }).withTimeout(0.275),
//         new MecanumDriveForwardForDistance(()-> 0.5, ()-> 0.0, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.forwardBackward(3.0), ()-> navSensor.getAngle() * -1 ),
//         new RunCommand(() -> {
//           System.out.println("Drive Delay");
//           m_chopperDrive.resetDistance();
//         }).withTimeout(0.275),new MecanumStrafeRightForDistance(()-> 0.0, ()-> 0.5, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.strafe(3.5), ()-> navSensor.getAngle() * -1 ),
//         new RunCommand(() -> {
//           System.out.println("Drive Delay");
//           m_chopperDrive.resetDistance();
//         }).withTimeout(0.275),
//         new MecanumDriveForwardForDistance(()-> 0.5, ()-> 0.0, ()-> 0.0, m_chopperDrive, ()-> FeetToTickMath.forwardBackward(7.0), ()-> navSensor.getAngle() * -1 )
//         );
//         firstRun = false;
//       }
//     }
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {}

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     if( firstRun ) {
//       return false;
//     }
//     else {
//       return true;
//     }
//   }
// }
