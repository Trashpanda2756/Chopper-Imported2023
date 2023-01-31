/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.logging.LogManager;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.IterativeRobotBase;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;

public class Robot extends TimedRobot {
    RobotContainer robotContainer;
    CommandBase m_selectedCommand;
    SendableChooser m_autonomousChooser;

    private static LogWrapper mLog;
    private PeriodicLogger mLogPeriodic;
    private final PowerDistribution m_PDP = new PowerDistribution();

    @Override
    public void robotInit() {
        robotContainer = new RobotContainer();
        // robotContainer.sodaPressing.setClosedLoopControl(true);
        // m_autonomousChooser = new SendableChooser();
        // m_autonomousChooser.setDefaultOption("Drive Straight", robotContainer.getAutonomousCommand());
        // m_autonomousChooser.addOption("Drive and Shoot Close", robotContainer.getDriveAndShootCloseCommand());
        // m_autonomousChooser.addOption("BarrelRacing", robotContainer.getBarrelRacingCommand());
        // m_autonomousChooser.addOption("Slalompath", robotContainer.getSlalomCommand());
        // m_autonomousChooser.addOption("Bounce", robotContainer.getBounceCommand());
        // m_autonomousChooser.addOption("Galactic Search", robotContainer.getGalacticSearch());


        SmartDashboard.putData(m_autonomousChooser);


        try {
            File dir = Filesystem.getDeployDirectory();
            String logFile = "NOTFOUND";
            if (dir.isDirectory()) {
                logFile = dir.getAbsolutePath() + "/logging.properties";
            }
            System.out.println("**********  logConfig: " + logFile + "  *********************");
            FileInputStream configFile = new FileInputStream(logFile);
            LogManager.getLogManager().readConfiguration(configFile);
        } catch (IOException ex) {
            System.out.println("WARNING: Could not open configuration file");
            System.out.println("WARNING: Logging not configured (console output only)");
        }
        mLog = new LogWrapper(Robot.class.getName());
        mLogPeriodic = new PeriodicLogger(mLog, 300);
        
        mLog.info("robotInit: -----------------    2021    -----------------------     2021    2021    2021");
        



        // For the simulator we are going to increase the Robot Watchdog timeout and its spamming messages
        // N.B. we can't easily close or disable it because the IterativeRobotBase loopFunc resets it each time it runs.
        if (Robot.isSimulation()) {
            try {
                Field watchDogField = IterativeRobotBase.class.getDeclaredField("m_watchdog");
                watchDogField.setAccessible(true);
                Watchdog watchdog = (Watchdog) watchDogField.get(this);
                // Down, Fido!
                watchdog.setTimeout(1.0);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
     */
    @Override
    public void autonomousInit() {
        Object selectedItem = m_autonomousChooser.getSelected();
        m_selectedCommand = (selectedItem instanceof CommandBase ? (CommandBase) selectedItem : null);
        if (m_selectedCommand != null) {
            m_selectedCommand.schedule();
        }
    }

    @Override
    public void autonomousPeriodic() {
    }

    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }
    
    @Override
    public void teleopInit() {
        if (m_selectedCommand != null) {
            m_selectedCommand.cancel();
        }
        // System.out.println("Shooter motor current draw: " + m_PDP.getCurrent(12));
    }
}