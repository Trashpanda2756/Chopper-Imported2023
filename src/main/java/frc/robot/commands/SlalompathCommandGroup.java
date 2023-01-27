// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ChopperDrive;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class SlalompathCommandGroup extends SequentialCommandGroup {
  /** Creates a new SlalompathCommandGroup. */
  public SlalompathCommandGroup(ChopperDrive chopperDrive, DoubleSupplier gyro, AHRS navSensor) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    super( new InstantCommand(() -> {
      navSensor.reset();
    }),
    
    //start
    new MecanumDriveForwardForDistance(()->0.3, ()->0.0, ()->0.0, chopperDrive, ()->40.85, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    //first hole
    new MecanumStrafeLeftForDistance(()->0.0, ()->-0.4, ()->0.0, chopperDrive, ()->60.5, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    //far forward
    new MecanumDriveForwardForDistance(()->0.4, ()->0.0, ()->0.0, chopperDrive, ()->117.725, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    //loop
    new MecanumStrafeRightForDistance(()->0.0, ()->0.4, ()->0.0, chopperDrive, ()->66.55, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    
    new MecanumDriveForwardForDistance(()->0.4, ()->0.0, ()->0.0, chopperDrive, ()->46.0, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    //fin loop
    new MecanumStrafeLeftForDistance(()->0.0, ()->-0.4, ()->0.0, chopperDrive, ()->66.55, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    new MecanumDriveBackForDistance(()->-0.4, ()->0.0, ()->0.0, chopperDrive, ()->46.0, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    // go in third hole
    new MecanumStrafeRightForDistance(()->0.0, ()->0.4, ()->0.0, chopperDrive, ()->72.6, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    //go far back
    new MecanumDriveBackForDistance(()->-0.4, ()->0.0, ()->0.0, chopperDrive, ()-> 114.8, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    //go in forth hole
    new MecanumStrafeLeftForDistance(()->0.0, ()->-0.4, ()->0.0, chopperDrive, ()->66.55, gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    //fini
    new MecanumDriveBackForDistance(()->-0.4, ()->0.0, ()->0.0, chopperDrive, ()->34.8, gyro));
    //warning a joke battleship Braxton is approching  
  }
}
