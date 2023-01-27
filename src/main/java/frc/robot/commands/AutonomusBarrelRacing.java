// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ChopperDrive;

public class AutonomusBarrelRacing extends SequentialCommandGroup {

  

  /** Creates a new AutonomusBarrelRacing. */
  public AutonomusBarrelRacing(ChopperDrive chopperDrive, DoubleSupplier gyro, AHRS navSensor) {

    //start, does first barrel
    super( new InstantCommand(() -> {
      navSensor.reset();
    }),
    new MecanumDriveForwardForDistance(()-> 0.5, ()->0.0, ()->0.0, chopperDrive, ()->100.05, gyro),
    new MecanumStrafeRightForDistance(()-> 0.0, ()-> 0.5, ()->0.0, chopperDrive, ()->60.5, gyro),
    new MecanumDriveBackForDistance(()-> -0.5, ()-> 0.0, ()->0.0, chopperDrive, ()->43.5, gyro),
    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->60.5, gyro),

    //does second barrel
    new MecanumDriveForwardForDistance(()-> 0.5, ()-> 0.0, ()->0.0, chopperDrive, ()->104.4, gyro),
    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->60.5, gyro),
    new MecanumDriveBackForDistance(()-> -0.5, ()-> 0.0, ()->0.0, chopperDrive, ()->52.2, gyro),
    new MecanumStrafeRightForDistance(()-> 0.0, ()-> 0.5, ()->0.0, chopperDrive, ()->60.5, gyro),
    new MecanumDiagonalForwardRightForDistance(()-> 0.4, ()->0.5, ()->0.0, chopperDrive, ()-> 70, gyro),

    //does thrid barrel
    new MecanumDriveForwardForDistance(()-> 0.5, ()-> 0.0, ()->0.0, chopperDrive, ()->51.3, gyro),
    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->60.5, gyro),
    // starts going back to start
    new MecanumDriveBackForDistance(()-> -0.5, ()-> 0.0, ()->0.0, chopperDrive, ()->60.0, gyro),
    new MecanumDriveBackForDistance(()-> -1.0, ()-> 0.0, ()->0.0, chopperDrive, ()->100.0, gyro),
    new MecanumDriveBackForDistance(()-> -0.5, ()-> 0.0, ()->0.0, chopperDrive, ()->61.4, gyro));
    // Use addRequirements() here to declare subsystem dependencies.

    System.out.println("starting drive back");

  }
  
}
