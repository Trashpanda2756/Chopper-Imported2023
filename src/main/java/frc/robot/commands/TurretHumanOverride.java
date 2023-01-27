// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;
import frc.robot.subsystems.ChopperTurret;



public class TurretHumanOverride extends CommandBase {
  private ChopperTurret chopperTurret;
  private int absPos = 0;
  private DoubleSupplier xJoyStickValue = null;
  private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
  private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);


  public TurretHumanOverride(ChopperTurret chopperTurret, DoubleSupplier xJoystickValue) {
    this.chopperTurret = chopperTurret;
    this.xJoyStickValue = xJoystickValue;
    addRequirements(chopperTurret);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
      // calculate absolute position

      absPos = (int) (xJoyStickValue.getAsDouble() * Constants.kMaxTurretEncoderValue);
      

      //check min and max travel limits

      if (absPos < Constants.kMinTurretEncoderValue) {
          absPos = Constants.kMinTurretEncoderValue;
      }

      if (absPos > Constants.kMaxTurretEncoderValue) {
          absPos = Constants.kMaxTurretEncoderValue;
      }
      //send current absolute position
      chopperTurret.setAbsPos(absPos);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
