// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.FeetToTickMath;
import frc.robot.subsystems.ChopperDrive;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutonomusBouncePath extends SequentialCommandGroup {
  /** Creates a new AutonomusBouncePath. */
  public AutonomusBouncePath( ChopperDrive chopperDrive, DoubleSupplier gyro, AHRS navSensor ) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //start, does first barrel
    super( new InstantCommand(() -> {
      navSensor.reset();
    }),
    /*
    new MecanumDriveForwardForDistance(()-> 0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(3.1), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),
    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafe(4.5), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    new MecanumStrafeRightForDistance(()-> 0.0, ()-> 0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafe(2.6), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),
    new MecanumDiagonalForwardRightForDistance(()-> 0.3, ()-> 0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafeAngle(9), gyro) 
    */


    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafe(4), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),

    new MecanumDriveBackForDistance(()-> -0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(3.1), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),

    new MecanumDriveForwardForDistance(()-> 0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(3.8), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),

    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafe(3.7), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),

    new MecanumDriveForwardForDistance(()-> 0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(4.5), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),

    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafe(6.5), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),

    new MecanumDriveBackForDistance(()-> -0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(8.5), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),

    new MecanumDriveForwardForDistance(()-> 0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(8.5), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),

    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafe(8.7), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175),

    new MecanumDriveBackForDistance(()-> -0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(9.5), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),

    new MecanumDriveForwardForDistance(()-> 0.4, ()->0.0, ()->0.0, chopperDrive, ()->FeetToTickMath.forwardBackward(3.3), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.275),

    new MecanumStrafeLeftForDistance(()-> 0.0, ()-> -0.5, ()->0.0, chopperDrive, ()->FeetToTickMath.strafe(3.7), gyro),
    new RunCommand(() -> {
      System.out.println("Drive Delay");
      chopperDrive.resetDistance();
    }).withTimeout(0.175)


    );
  }
}
