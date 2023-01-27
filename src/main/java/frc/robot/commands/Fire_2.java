// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.LiftActuator;

public class Fire_2 extends CommandBase {

  // Alocating Local Instances
  Hopper m_hopper;
  LiftActuator m_liftActuator;

  /** Creates a new Fire_2. */
  public Fire_2(Hopper hopper, LiftActuator liftActuator) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_hopper = hopper;
    m_liftActuator = liftActuator;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_hopper.hopperSpinCounterClockwiseFast();
    m_liftActuator.engage();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_hopper.hopperStop();
    m_liftActuator.disengage();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
