// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeMotor;

public class Inhale_3 extends CommandBase {

  private final IntakeMotor m_IntakeMotor;

  /** Creates a new Inhale_3. */
  public Inhale_3(IntakeMotor motor) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_IntakeMotor = motor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_IntakeMotor.in();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_IntakeMotor.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
