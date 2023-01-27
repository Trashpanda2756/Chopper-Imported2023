// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
// import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HoodFlywheels extends SubsystemBase {

  Spark hoodFlywheels;
  private double flywheelSpeed = 0.0;

  /** Creates a new HoodFlywheels. */
  public HoodFlywheels() {
    hoodFlywheels = new Spark(Constants.POOF_BALL_PEWPEWII);
    flywheelSpeedGreen();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void flywheelOn() {
    hoodFlywheels.set(flywheelSpeed);
  }

  public void flywheelSpeedGreen() {
    flywheelSpeed = 0.45;
  }

  public void flywheelSpeedYellow() {
    flywheelSpeed = 0.5;
  }
  

  public void flywheelSpeedBlue() {
    flywheelSpeed = 0.55;
  }

  public void flywheelSpeedRed() {
    flywheelSpeed = 0.6;
  }

  public void flywheelOff() {
    hoodFlywheels.set(0.0);
  }
}
