/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.Exhale_2;
import frc.robot.commands.Fire_1;
import frc.robot.commands.Fire_2;
import frc.robot.commands.InhaleCommand;
import frc.robot.commands.InhaleExhale_1;
import frc.robot.commands.Inhale_3;
import frc.robot.commands.IntakeReverseCommandGroup;
import frc.robot.commands.MecanumCommand;
import frc.robot.commands.RotateTurretCommand;

//import java.util.Properties;
import frc.robot.subsystems.ChopperDrive;
import frc.robot.subsystems.ChopperTurret;
import frc.robot.subsystems.HoodActuator;
import frc.robot.subsystems.HoodFlywheels;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.IntakeActuator;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.LiftActuator;
import frc.robot.subsystems.LiftMotor;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
@SuppressWarnings({"FieldCanBeLocal", "unused", "DanglingJavadoc"})
public class RobotContainer
{
    // The robot's subsystems and commands are defined here...
    private final LiftActuator m_liftActuator = new LiftActuator();
    private final LiftMotor m_liftMotor = new LiftMotor();
    private final HoodActuator m_hoodActuator = new HoodActuator();
    private final HoodFlywheels m_hoodFlywheels = new HoodFlywheels();
    public static final ChopperTurret m_headCannon = new ChopperTurret();
    public static final Hopper m_hopper = new Hopper();
    public final IntakeActuator m_intakeActuator = new IntakeActuator();
    public final IntakeMotor m_intakeMotor = new IntakeMotor();
    // private final WheelOfFortune m_vanaWhite = new WheelOfFortune();
    private final ChopperDrive m_driveDrive = new ChopperDrive();
    // private final ElevatorLockingSubsystem elevLockingSubsystem = new ElevatorLockingSubsystem();
    public final Compressor sodaPressing = new Compressor(0, PneumaticsModuleType.CTREPCM);
    // public final DarthElevatorSubsystem m_darthElevator = new DarthElevatorSubsystem();

   private final JMaster m_joySticks = new JMaster(0, 1, "Logitech Gamepad");
   
    // private final Joystick m_rightJoystick = new Joystick(1);
    // private final Joystick m_leftJoystick = new Joystick(0);
//    private final Joystick m_joyStickO = new Joystick(1);

    private static final AHRS m_navSensor = new AHRS();
    

    public AHRS getNavSensor() {
        return m_navSensor;
    }

    // private final CommandBase m_autonomousCommand = new MecanumCommand(() -> -0.5, () -> 0.0, () -> 0.0, m_driveDrive).withTimeout(2.0);
    // private final CommandGroupBase m_driveAndShootCloseCommand = new AutonomousDriveAndShootCloseCommandGroup(m_hoodActuator, m_hoodFlywheels, m_driveDrive, m_hopper, m_liftActuator, m_liftMotor);
    // private final CommandGroupBase m_barrelRacingCommand = new AutonomusBarrelRacing( m_driveDrive, ()-> m_navSensor.getAngle() * -1, m_navSensor);
    // private final CommandGroupBase m_slalomCommand = new SlalompathCommandGroup( m_driveDrive, ()-> m_navSensor.getAngle() * -1, m_navSensor);
    // private final CommandGroupBase m_bounceCommand = new AutonomusBouncePath( m_driveDrive, ()-> m_navSensor.getAngle() * -1, m_navSensor);
    // private final CommandGroupBase m_galacticSearch = new GalacticSearch(m_driveDrive, m_intakeActuator, m_intakeMotor, m_hopper, m_navSensor);

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer()
    {
        m_joySticks.init();
        if (Robot.isReal()) {


            // normal mech
            if( true ) {
                m_driveDrive.setDefaultCommand(new MecanumCommand(
                    () -> Math.signum(m_joySticks.getLY()) * Math.pow(m_joySticks.getLY(), 2), // leftX -> driveCartesian.ySpeed: Right is positive.
                    () -> Math.signum(m_joySticks.getLX()) * Math.pow(m_joySticks.getLX(), 2), // leftY -> driveCartesian.xSpeed: Forward is positive.
                    () -> -1 * Math.signum(m_joySticks.getRX()) * Math.pow(m_joySticks.getRX() , 2), // rightZ -> driveCartesian.zRotation: Clockwise is positive.
                    // () -> getAngle() * -1, //uncomment this line for field oriented
                    m_driveDrive
                ));
            }
            else {
            
                m_driveDrive.setDefaultCommand(new MecanumCommand(m_driveDrive,
                    () -> -1 * Math.signum(m_joySticks.getRY()) * Math.pow(m_joySticks.getRY(), 2), // leftY -> driveCartesian.xSpeed: Forward is positive.
                    () -> Math.signum(m_joySticks.getRX()) * Math.pow(m_joySticks.getRX(), 2), // leftX -> driveCartesian.ySpeed: Right is positive.
                    () -> Math.signum(m_joySticks.getLX()) * Math.pow(m_joySticks.getLX() , 2), // rightZ -> driveCartesian.zRotation: Clockwise is positive.
                    () -> Math.signum(m_joySticks.getLY()) * Math.pow(m_joySticks.getLY() , 2)
                    // () -> getAngle() * -1, //uncomment this line for field oriented
                    
                ));

            }
            m_headCannon.setDefaultCommand(new RotateTurretCommand( m_headCannon ));
        } else {
            // Play with these values to see how the motors respond.
            m_driveDrive.setDefaultCommand(new MecanumCommand(
                    () -> 1.0, // leftY: All wheels are driving straight forward.
                    () -> 0.0, // leftX
                    () -> 0.0, // rightZ
                    m_driveDrive
            ));
        }

        // Configure the button bindings
        configureButtonBindings();
        

        m_navSensor.reset();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
     */
    private void configureButtonBindings() {

        //   final JoystickButton lowFire = new ComboButton(m_leftJoystick, 1, 2);

    //   For Joysticks
        
          final JoystickButton fire = new JoystickButton(m_joySticks.lStick, 5);
          final JoystickButton hoodDown = new JoystickButton(m_joySticks.lStick, 7);
          final JoystickButton hoodUp = new JoystickButton(m_joySticks.lStick, 8);
        //   final JoystickButton leftTurretFire = new JoystickButton(m_leftJoystick, 4);
        //   final JoystickButton rightTurretFire = new JoystickButton(m_leftJoystick, 5);
          
          final JoystickButton redFlywheelSpeed = new JoystickButton(m_joySticks.lStick, 2);
          final JoystickButton blueFlywheelSpeed = new JoystickButton(m_joySticks.lStick, 4);
          final JoystickButton yellowFlywheelSpeed = new JoystickButton(m_joySticks.lStick, 3);
          final JoystickButton greenFlywheelSpeed = new JoystickButton(m_joySticks.lStick, 1);
 
          final JoystickButton inhale = new JoystickButton(m_joySticks.lStick, 6);
          final POVButton exhale = new POVButton(m_joySticks.lStick, 0);
        //   final JoystickButton intakeInButton = new JoystickButton(m_rightJoystick, 3);
        //   final JoystickButton intakeOutButton = new JoystickButton(m_rightJoystick, 4);

        //   final JoystickButton turretOverrideButton = new JoystickButton(m_rightJoystick, 6);

        //   final JoystickButton halfSpeed = new JoystickButton(m_rightJoystick, 10);
        //   final JoystickButton fullSpeed = new JoystickButton(m_rightJoystick, 11);

        // ADDING NESSICARY COMMANDS
        final Fire_1 m_Fire_1 = new Fire_1(m_hoodFlywheels, m_liftMotor);
        final Fire_2 m_Fire_2 = new Fire_2(m_hopper, m_liftActuator);
        final InhaleExhale_1 m_Inhale_1 = new InhaleExhale_1(m_intakeActuator);
        final InhaleCommand m_Inhale_2 = new InhaleCommand(m_hopper, m_intakeMotor);
        final InhaleExhale_1 m_Exhale_1 = new InhaleExhale_1(m_intakeActuator);
        final Exhale_2 m_Exhale_2 = new Exhale_2(m_intakeMotor, m_hopper);
        final Inhale_3 m_Inhale_3 = new Inhale_3(m_intakeMotor);
        
          
    // For Gamepad in XInput mode
        /*
        // speed buttons
          final JMaster blueFlywheelSpeed = new JMaster(m_joySticks.getRightYButton());
          final JMaster redFlywheelSpeed = new JMaster(m_joySticks.getRightBButton());
          final JMaster yellowFlywheelSpeed = new JMaster(m_joySticks.getRightXButton());
          final JMaster greenFlywheelSpeed = new JMaster(m_joySticks.getRightAButton());

        // shooting controls
          final JMaster fire = new JMaster(m_joySticks.getLeftTrigger());
          final JMaster hoodUp = new JMaster(m_joySticks.getStartButton());
          final JMaster hoodDown = new JMaster(m_joySticks.getBackButton());

        // hopper function
          final JMaster inhale = new JMaster(m_joySticks.getRightTrigger());
          final JMaster exhale = new JMaster(m_joySticks.getLeftBumper());

        */
          //   turning off climber for now
          //final JoystickButton upWeGoes = new JoystickButton(m_leftJoystick, 6);
          //final JoystickButton downWeGoes = new JoystickButton(m_leftJoystick, 7);
          //final JoystickButton lockElevator = new JoystickButton(m_rightJoystick, 11);
          //final JoystickButton unlockElevator = new JoystickButton(m_rightJoystick, 10);


//        final JoystickButton colorSense = new JoystickButton(m_joyStick, 4);
//        final JoystickButton colorReadIR = new JoystickButton(m_joyStick, 3);
//        final JoystickButton colorReadProximity = new JoystickButton(m_joyStick, 2);
//        final JoystickButton colorMatch = new JoystickButton(m_joyStick, 1);
//        final JoystickButton colorUp = new JoystickButton(m_joyStick, 2);
//        final JoystickButton colorDown = new JoystickButton(m_joyStick, 1);
//        final JoystickButton colorFullRotate = new JoystickButton(m_joyStick, 3);
//        final JoystickButton colorEighthRotate = new JoystickButton(m_joyStick, 4);
//        final JoystickButton HopperRunBackwards = new JoystickButton(m_joyStickO, 6);






          



          

/////// Connect the buttons to commands

          /*
          upWeGoes.whileHeld(new UpWeGoesCommand(m_darthElevator, m_driveDrive));

          downWeGoes.whileHeld(new StartEndCommand(() -> {
              System.out.println("weGoesDown");
              m_darthElevator.MotorPower(-0.8);
          }, () -> {
              System.out.println("weGoesStopAgain");
              m_darthElevator.MotorPower(0.0);
          }, m_darthElevator));

          lockElevator.whenPressed(new InstantCommand(() -> {
            System.out.println("Locking elevator");
            elevLockingSubsystem.stopServo();
          }, elevLockingSubsystem));

          unlockElevator.whenPressed(new InstantCommand(() -> {
            System.out.println("Unlocking elevator");
            elevLockingSubsystem.releaseServo();
          }, elevLockingSubsystem));
        */


//        colorSense.whenPressed(new ReadColorCommand(m_vanaWhite));
//        colorReadIR.whenPressed(new ReadIRCommand(m_vanaWhite));
//        colorReadProximity.whenPressed(new ReadProximityCommand(m_vanaWhite));
//        colorMatch.whenPressed(new MatchColorCommand(m_vanaWhite));


        inhale.whileTrue(Commands.parallel(m_Inhale_1, /* Sends intake out */
        new RunCommand( () -> {}).withTimeout(0.5) /* 1/2 sec wait for intake to go out */
        .andThen(m_Inhale_2))); /* Starts intake rollers and hopper */

        inhale.whileFalse(m_Inhale_3.withTimeout(0.75));


        // intakeInButton.whenPressed(new InstantCommand(() -> m_intakeActuator.intakeIn()));
        // intakeOutButton.whenPressed(new InstantCommand(() -> m_intakeActuator.intakeOut()));


        // highFire.whileHeld(new HighFireSequenceCommand(m_hoodActuator, m_hoodFlywheels, m_hopper, m_liftActuator, m_liftMotor));
        // highFire.whileHeld(new RaiseAndShootCommandGroup(m_pewPewII, m_hopper));
        // lowFire.whileHeld(new LowFireSequenceCommand(m_hoodActuator, m_hoodFlywheels, m_hopper, m_liftActuator, m_liftMotor));
        // lowFire.whileHeld(new StartEndCommand(
                // Start Runnable
                // () -> {
                    // System.out.println("You're fired low!");
                    // m_pewPewII.setMotor(0.26);
                // },
                // End Runnable
                // () -> {
                    // System.out.println("No. I quit low!");
                    // m_pewPewII.setMotor(0.0);
                // }));


        exhale.whileTrue(Commands.parallel(m_Exhale_1, /* Sends intake out */
        new RunCommand( () -> {}).withTimeout(0.5) /* 1/2 sec wait for intake to go out */
        .andThen(m_Exhale_2))); /* Starts intake rollers and hopper */


        // turretOverrideButton.whileHeld(new TurretHumanOverride(m_headCannon, () -> m_rightJoystick.getRawAxis(2) ));


        // fullSpeed.whenPressed(new InstantCommand(() -> {
        //     System.out.println("Full Speed");
        //     m_driveDrive.setFullSpeed();
        // }) {
        //     @Override
        //     public boolean runsWhenDisabled() {
        //         return true;
        //     }
        // });


        // halfSpeed.whenPressed(new InstantCommand(() -> {
        //     System.out.println("Half Speed");
        //     m_driveDrive.setHalfSpeed();
        // }) {
        //     @Override
        //     public boolean runsWhenDisabled() {
        //         return true;
        //     }
        // });


        fire.whileTrue(Commands.parallel(m_Fire_1, /* Starts Flywheels and Lift Motors */
            new RunCommand( () -> {}).withTimeout(2.0) /* 2 sec delay for spin up */
            .andThen(m_Fire_2))); /* Actuates lift and starts hopper motor */


        greenFlywheelSpeed.whileTrue(new InstantCommand(() -> {
            System.out.println("speed set green");
            m_hoodFlywheels.flywheelSpeedGreen();
        }));
        
        yellowFlywheelSpeed.whileTrue(new InstantCommand(() -> {
            System.out.println("speed set yellow");
            m_hoodFlywheels.flywheelSpeedYellow();
        }));
        
        blueFlywheelSpeed.whileTrue(new InstantCommand(() -> {
            System.out.println("speed set blue");
            m_hoodFlywheels.flywheelSpeedBlue();
        }));
        
        redFlywheelSpeed.whileTrue(new InstantCommand(() -> {
            System.out.println("speed set red");
            m_hoodFlywheels.flywheelSpeedRed();
        }));
        


        hoodUp.whileTrue(new InstantCommand(() -> {
            m_hoodActuator.hoodUp();
            m_hoodActuator.setHood();
        }));

        hoodDown.whileTrue(new InstantCommand(() -> {
            m_hoodActuator.hoodDown();
            m_hoodActuator.setHood();
        }));

        // shooterLiftButton.whileHeld(new ShooterLiftControl(m_liftMotor));

        // liftActuator.whileHeld(new LiftActuationCommand(m_liftActuator));
   }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    // public CommandBase getAutonomousCommand()
    // {
    //     return m_autonomousCommand;
    // }

    // public CommandGroupBase getDriveAndShootCloseCommand() {
    //     return m_driveAndShootCloseCommand;
    // }

    // public CommandGroupBase getBarrelRacingCommand() {
    //     return m_barrelRacingCommand;
    // }

    // public CommandGroupBase getSlalomCommand() {
    //     return m_slalomCommand;
    // }


    // public CommandGroupBase getBounceCommand() {
    //     return m_bounceCommand;
    // }

    // public CommandGroupBase getGalacticSearch() {
    //     return m_galacticSearch;
    // }

    public static double getAngle() {
        return m_navSensor.getAngle();
    }
}
