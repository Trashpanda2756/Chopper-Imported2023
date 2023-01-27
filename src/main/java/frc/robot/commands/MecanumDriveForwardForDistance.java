// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;
import frc.robot.subsystems.ChopperDrive;

public class MecanumDriveForwardForDistance extends CommandBase {


  private final ChopperDrive chopperDrive;
  private final DoubleSupplier leftY;
  private final DoubleSupplier leftX;
  private final DoubleSupplier rightZ;
  private final DoubleSupplier gyro;
  private final DoubleSupplier distance;

  private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
  private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);
  

  /** Creates a new MecanumDriveForwardForDistance. */
  public MecanumDriveForwardForDistance(DoubleSupplier leftY,
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
        mLog.debug( this.getClass().getName() + "::" + leftY.getAsDouble() + ":" +leftX.getAsDouble());
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    mLog.debug(this.getClass().getName() + ":starting drive forward, resetting encoder");
    chopperDrive.resetDistance();
    
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


        

        mPLog.debug( this.getClass().getName() + ":turn motors on" );

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    chopperDrive.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double dist = chopperDrive.getDistance();
    if( dist > distance.getAsDouble()){
      mLog.debug( this.getClass().getName() + ":Distance Reached : " + dist + " Target : " + distance.getAsDouble() );
      return true;
    }
    mLog.debug( this.getClass().getName() + ":Distance not reached : " + dist + " Target : " + distance.getAsDouble() );
    return false;
  }
}
