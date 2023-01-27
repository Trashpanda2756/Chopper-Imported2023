// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LiftActuator;

public class LiftActuationCommand extends CommandBase {

  LiftActuator m_LiftActuator;

  /** Creates a new LiftActuationCommand. */
  public LiftActuationCommand( LiftActuator liftActuator) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_LiftActuator = liftActuator;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_LiftActuator.engage();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_LiftActuator.disengage();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
