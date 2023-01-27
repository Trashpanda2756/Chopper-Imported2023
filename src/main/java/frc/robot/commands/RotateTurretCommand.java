package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ChopperTurret;


public class RotateTurretCommand extends CommandBase {
    private final ChopperTurret chopperTurret;
    private NetworkTableEntry cameraRelPosChange;
    private int absPos = 0;
    private int executeCounter = 0;
    


    public RotateTurretCommand( ChopperTurret chopperTurret) {
        this.chopperTurret = chopperTurret;
        addRequirements(chopperTurret);
    }

    

    @Override
    public void initialize() {
        //set copper turret to zero
    }

    @Override
    public void execute() {
        // calculate absolute position
        executeCounter++;
        
        cameraRelPosChange = NetworkTableInstance.getDefault().getTable("datatable").getEntry("Relative Encoder Value");
        if (executeCounter > 5) {
            absPos = absPos + cameraRelPosChange.getNumber(0).intValue();
            executeCounter = 0;
        }

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

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("RotateTurretCommand: end:");
        chopperTurret.stop();
    }

}
