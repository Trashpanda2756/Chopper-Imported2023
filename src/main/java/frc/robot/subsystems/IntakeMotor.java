// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeMotor extends SubsystemBase {

  WPI_TalonSRX intakeMotor;
  /** Creates a new IntakeMotor. */
  public IntakeMotor() {
    intakeMotor = new WPI_TalonSRX(Constants.INTAKER_ONE);
    intakeMotor.configFactoryDefault();
    intakeMotor.configOpenloopRamp(0.5, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void stop() {
    intakeMotor.set(0.0);
  }

  public void in() {
    intakeMotor.set(1.0);
  }

  public void out() {
    intakeMotor.set(-1.0);
  }
}
