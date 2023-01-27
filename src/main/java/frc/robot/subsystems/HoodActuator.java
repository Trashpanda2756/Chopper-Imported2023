// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;

public class HoodActuator extends SubsystemBase {

  private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
  private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);

  Solenoid hood = new Solenoid(PneumaticsModuleType.CTREPCM, 7);
  Boolean hoodPosition = false;

  /** Creates a new HoodActuator. */
  public HoodActuator() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setHood() {
    hood.set(hoodPosition);
  }

  public void hoodUp() {
    mLog.debug(this.getClass().getName() + ":Hood Up");
    hoodPosition = true;
  }

  public void hoodDown() {
    mLog.debug(this.getClass().getName() + ":Hood Down");
    hoodPosition = false;
  }
}
