/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2020 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;


public class Hopper extends SubsystemBase
{

    private CANSparkMax hopperMotor;
    private NetworkTableEntry currentTopEntry;

    /**
     * Creates a new PoofHopper.
     */
    public Hopper()
    {
        hopperMotor = new CANSparkMax(Constants.HOPPER_ONE, CANSparkMaxLowLevel.MotorType.kBrushless);
        hopperMotor.restoreFactoryDefaults();
        hopperMotor.setSmartCurrentLimit(40);
        ShuffleboardTab tab = Shuffleboard.getTab("Hopper");
        // currentTopEntry = getNetworkGraphEntry(tab,"Hopper Current", 4, 0);
    }

    public double getMotor2Speed() {
        return hopperMotor.get();
    }

    public void hopperSpinCounterClockwiseFast() {
        hopperMotor.set(0.35);
    }
    public void hopperSpinCounterClockwiseSlow() {
        hopperMotor.set(0.3);
    }
    public void hopperSpinClockwiseSlow() {
        hopperMotor.set(-0.3);
    }
    public void hopperStop() {
        hopperMotor.set(0.0);
    }

    /**
     * Will always be called periodically whenever the CommandScheduler runs.
     * @see CommandScheduler#run
     */

    @Override
    public void periodic() {
        // if (Robot.isReal()) {
        //     currentTopEntry.setDouble(hopperMotor.getOutputCurrent());
        // }
    }

    // private NetworkTableEntry getNetworkGraphEntry(ShuffleboardTab tab, String name, int colNum, int rowNum) {
    //     return tab.add(name, 0)
    //             .withWidget(BuiltInWidgets.kGraph)
    //             .withSize(2, 2)
    //             .withPosition(colNum, rowNum)
    //             .getEntry();
    // }
}
