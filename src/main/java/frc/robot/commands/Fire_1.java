// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HoodFlywheels;
import frc.robot.subsystems.LiftMotor;

public class Fire_1 extends CommandBase {

  // Alocating Local Instances
  HoodFlywheels m_hoodFlywheels;
  LiftMotor m_liftMotor;

  /** Creates a new Fire_1. */
  public Fire_1(HoodFlywheels hoodFlywheels, LiftMotor liftMotor) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_hoodFlywheels = hoodFlywheels;
    m_liftMotor = liftMotor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // m_hoodFlywheels.flywheelOn();
    m_liftMotor.ShooterLiftStart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // m_hoodFlywheels.flywheelOn();
    // m_liftMotor.ShooterLiftStart();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_hoodFlywheels.flywheelOff();
    m_liftMotor.ShooterLiftStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
