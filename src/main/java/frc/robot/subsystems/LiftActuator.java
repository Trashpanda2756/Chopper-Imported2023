// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;

public class LiftActuator extends SubsystemBase {

  DoubleSolenoid m_LiftActuator = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

  private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
  private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);

  
  /** Creates a new LiftActuator. */
  public LiftActuator() {

    disengage();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void engage() {
    mLog.debug(this.getClass().getName() + ":Lift Actuator Disengage");
    m_LiftActuator.set(DoubleSolenoid.Value.kReverse);
  }

  public void disengage() {
    mLog.debug(this.getClass().getName() + ":Lift Actuator Engage");
    m_LiftActuator.set(DoubleSolenoid.Value.kForward);
  }
}
