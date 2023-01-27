/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;


public class ChopperTurret extends SubsystemBase {
    private WPI_TalonSRX motor;
    private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
    private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);

    /**
     * Constructor for ChopperTurret.
     */
    public ChopperTurret() {
        // motor = new WPI_TalonSRX(Constants.CHOPPER_TURRET);
        // motor.configFactoryDefault();
        // motor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
        // motor.setSensorPhase(Constants.kSensorPhase);
        // motor.configNominalOutputForward(0, Constants.kTimeoutMs);
        // motor.configNominalOutputReverse(0, Constants.kTimeoutMs);
        // motor.configPeakOutputForward(1, Constants.kTimeoutMs);
        // motor.configPeakOutputReverse(-1, Constants.kTimeoutMs);
        // motor.configAllowableClosedloopError(0, Constants.kPIDLoopIdx, Constants.kTimeoutMs);
        // motor.config_kF(Constants.kPIDLoopIdx, Constants.kGains.kF, Constants.kTimeoutMs);
        // motor.config_kP(Constants.kPIDLoopIdx, Constants.kGains.kP, Constants.kTimeoutMs);
        // motor.config_kI(Constants.kPIDLoopIdx, Constants.kGains.kI, Constants.kTimeoutMs);
        // motor.config_kD(Constants.kPIDLoopIdx, Constants.kGains.kD, Constants.kTimeoutMs);
    }

    double last_target = 0;

    public void set(double position) {

        if( last_target != position ) {
            last_target = position;
            mLog.debug(this.getClass().getName() + " Position: " + position);
            motor.set(ControlMode.Position, position);
        }
        

    }



    public void stop() {
        // motor.set(ControlMode.PercentOutput, 0.0);
    
    }


    @Override
    public void periodic() {
        
    }

	public void setAbsPos(int absPos) {
        
        set( absPos );
	}
}
