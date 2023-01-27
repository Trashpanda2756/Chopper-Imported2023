// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.IntakeMotor;

public class Exhale_2 extends CommandBase {

  // Alocating Local Instances
  IntakeMotor m_intakeMotor;
  Hopper m_hopper;

  /** Creates a new Exhale_2. */
  public Exhale_2(IntakeMotor intakeMotor, Hopper hopper) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_hopper = hopper;
    m_intakeMotor = intakeMotor;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_hopper.hopperSpinClockwiseSlow();
    m_intakeMotor.out();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_hopper.hopperStop();
    m_intakeMotor.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
