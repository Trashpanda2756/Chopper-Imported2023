// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.InstantCommand;
// import edu.wpi.first.wpilibj2.command.RunCommand;
// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.logging.LogWrapper;
// import frc.robot.logging.PeriodicLogger;
// import frc.robot.subsystems.ChopperDrive;
// import frc.robot.subsystems.Hopper;
// import frc.robot.subsystems.IntakeActuator;
// import frc.robot.subsystems.IntakeMotor;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// import java.util.Set;
// import java.util.WeakHashMap;
// import java.util.function.DoubleSupplier;

// import com.kauailabs.navx.frc.AHRS;

// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;


// // NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// // information, see:
// // https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
// public class GalacticSearch extends SequentialCommandGroup {


//   private final List<Command> m_commands = new ArrayList<>();
//   private int m_currentCommandIndex = -1;
//   private boolean m_runWhenDisabled = true;

  
//   private AHRS navSensor;
//   private DoubleSupplier gyro;
//   private Hopper m_hopper;
//   private IntakeMotor m_intakeMotor;
//   private IntakeActuator m_intakeActuator;
//   private ChopperDrive m_chopperDrive;
//   private NetworkTableEntry PowercellLocation;

//   private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
//   private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);


//   private static final Set<Command> m_groupedCommands =
//       Collections.newSetFromMap(new WeakHashMap<>());

//   static void registerGroupedCommands(Command... commands) {
//     m_groupedCommands.addAll(Set.of(commands));
//   }

//   /** Creates a new GalacticSearch. */
//   public GalacticSearch(ChopperDrive m_chopperDrive, IntakeActuator m_intakeActuator, IntakeMotor m_intakeMotor, Hopper m_hopper, AHRS navSensor) {
//     // Add your commands in the addCommands() call, e.g.
//     // addCommands(new FooCommand(), new BarCommand());
//     // addCommands();
//     this.navSensor = navSensor;
//     this.gyro = gyro;
//     this.m_hopper = m_hopper;
//     this.m_intakeMotor = m_intakeMotor;
//     this.m_intakeActuator = m_intakeActuator;
//     this.m_chopperDrive = m_chopperDrive;
//   }

  
//   public void myAddCommands(Command... commands) {
//     requireUngrouped(commands);

//     /*if (m_currentCommandIndex != -1) {
//       throw new IllegalStateException(
//           "Commands cannot be added to a CommandGroup while the group is running");
//     }*/

//     registerGroupedCommands(commands);

//     for (Command command : commands) {
//       m_commands.add(command);
//       m_requirements.addAll(command.getRequirements());
//       m_runWhenDisabled &= command.runsWhenDisabled();
//     }
//   }

//   @Override
//   public void initialize() {
    
//     mLog.debug(this.getClass().getName() + ": initialize " );


//     myAddCommands( new InstantCommand(() -> {
//         navSensor.reset();
//       }),

//       new MecanumDriveForwardForDistance(()->0.3, ()->0.0, ()->0.0, m_chopperDrive, ()-> 20.0, () -> navSensor.getAngle() * -1 ),
//       new RunCommand(() -> {
//         System.out.println("Shooter Delay");
//       }).withTimeout(.25),
//       new MecanumStrafeLeftForDistance(()->0.0, ()->-0.5, ()->0.0, m_chopperDrive, ()-> 20.0, () -> navSensor.getAngle() * -1 ),
//       new RunCommand(() -> {
//         System.out.println("Shooter Delay");
//       }).withTimeout(2.0),
//       new GalacticSearchCheck(this, m_chopperDrive, m_intakeActuator, m_intakeMotor, m_hopper, navSensor)
//     );

//     m_currentCommandIndex = 0;

//     if (!m_commands.isEmpty()) {
//       m_commands.get(0).initialize();
//     }

//   }

//   @Override
//   public void execute() {
//     if (m_commands.isEmpty()) {
//       return;
//     }

//     mLog.debug(this.getClass().getName() + ": execute current index : " + m_currentCommandIndex + " command size : " + m_commands.size() );

//     Command currentCommand = m_commands.get(m_currentCommandIndex);

//     currentCommand.execute();
//     if (currentCommand.isFinished()) {
//       currentCommand.end(false);
//       m_currentCommandIndex++;
//       if (m_currentCommandIndex < m_commands.size()) {
//         m_commands.get(m_currentCommandIndex).initialize();
//       }
//     }
//   }

//   @Override
//   public void end(boolean interrupted) {
//     if (interrupted
//         && !m_commands.isEmpty()
//         && m_currentCommandIndex > -1
//         && m_currentCommandIndex < m_commands.size()) {
//       m_commands.get(m_currentCommandIndex).end(true);
//     }
//     m_currentCommandIndex = -1;
//   }

//   @Override
//   public boolean isFinished() {
//     return m_currentCommandIndex == m_commands.size();
//   }

//   @Override
//   public boolean runsWhenDisabled() {
//     return m_runWhenDisabled;
//   }

// }
