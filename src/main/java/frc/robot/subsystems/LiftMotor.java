// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;



public class LiftMotor extends SubsystemBase {

  private Spark m_liftMotor;

  /** Creates a new ShooterLift. */
  public LiftMotor() {
    m_liftMotor = new Spark(Constants.ShooterLift);
  }


  public void ShooterLiftStart() {
    m_liftMotor.set(1);
  }  


  public void ShooterLiftStop() {
    m_liftMotor.set(0.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
