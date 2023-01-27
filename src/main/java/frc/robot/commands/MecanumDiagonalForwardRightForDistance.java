// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChopperDrive;

public class MecanumDiagonalForwardRightForDistance extends CommandBase {
  private final ChopperDrive chopperDrive;
  private final DoubleSupplier leftY;
  private final DoubleSupplier leftX;
  private final DoubleSupplier rightZ;
  private final DoubleSupplier gyro;
  private final  DoubleSupplier distance;


  private boolean isFirstRun = true;


  /** Creates a new MecanumDriveForwardForDistance. */
  public MecanumDiagonalForwardRightForDistance(DoubleSupplier leftY,
                         DoubleSupplier leftX, 
                         DoubleSupplier rightZ, 
                         ChopperDrive chopperDrive,
                         DoubleSupplier distance,
                         DoubleSupplier gyro) {
        this.chopperDrive = chopperDrive;
        addRequirements(chopperDrive);
        this.leftY = leftY;
        this.leftX = leftX;
        this.rightZ = rightZ;
        this.gyro = gyro;
        this.distance = distance;
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    System.out.println("starting drive back");
    chopperDrive.resetDistance();
    isFirstRun = true;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    chopperDrive.driveWithGyro(
                leftY.getAsDouble(),
                leftX.getAsDouble(),
                rightZ.getAsDouble(),
                gyro.getAsDouble()
        );

        if( isFirstRun ) {

          System.out.println( "turn motors on" );
        }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    chopperDrive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(chopperDrive.getDistance() > distance.getAsDouble()){
      System.out.println( "Distance Reached" );
      return true;
    }
    return false;
  }
}
