// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;

public class IntakeActuator extends SubsystemBase {

  private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
  private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);
  
  DoubleSolenoid intakeActuatorSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);
  /** Creates a new IntakeActuation. */
  public IntakeActuator() {

    intakeIn();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeOut() {
    mLog.debug(this.getClass().getName() + ":Intake out");
    intakeActuatorSolenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void intakeIn() {
    mLog.debug(this.getClass().getName() + ":Intake in");
    intakeActuatorSolenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
