// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeActuator;

public class InhaleExhale_1 extends CommandBase {

  // Alocating Local Instances
  IntakeActuator m_intakeActuator;

  /** Creates a new inhale_1. */
  public InhaleExhale_1(IntakeActuator intakeActuator) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intakeActuator = intakeActuator;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_intakeActuator.intakeOut();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeActuator.intakeIn();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
