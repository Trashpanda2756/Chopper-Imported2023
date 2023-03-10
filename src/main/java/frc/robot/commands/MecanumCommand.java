package frc.robot.commands;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ChopperDrive;

import java.util.function.DoubleSupplier;


public class MecanumCommand extends CommandBase {
    private final ChopperDrive chopperDrive;
    private final DoubleSupplier leftY;
    private final DoubleSupplier leftX;
    private final DoubleSupplier rightZ;
    private DoubleSupplier rightY = null;
    private final Rotation2d gyro;
    private boolean driveNormalMech = true;

    public MecanumCommand(DoubleSupplier leftY, DoubleSupplier leftX, DoubleSupplier rightZ, ChopperDrive chopperDrive) {
        this.chopperDrive = chopperDrive;
        addRequirements(chopperDrive);
        this.leftY = leftY;
        this.leftX = leftX;
        this.rightZ = rightZ;
        this.gyro = new Rotation2d();
    }
    public MecanumCommand( ChopperDrive chopperDrive, DoubleSupplier leftY, DoubleSupplier leftX, DoubleSupplier rightX, DoubleSupplier rightY) {
        this.chopperDrive = chopperDrive;
        addRequirements(chopperDrive);
        this.leftY = leftY;
        this.leftX = leftX;
        this.rightZ = rightX;
        this.rightY = rightY;
        this.gyro = new Rotation2d();
        driveNormalMech = false;
    }

    public MecanumCommand(DoubleSupplier leftY, DoubleSupplier leftX, DoubleSupplier rightZ, Rotation2d gyro, ChopperDrive chopperDrive) {
        this.chopperDrive = chopperDrive;
        addRequirements(chopperDrive);
        this.leftY = leftY;
        this.leftX = leftX;
        this.rightZ = rightZ;
        this.gyro = gyro;
    }

    /**
     * The initial subroutine of a command.  Called once when the command is initially scheduled.
     */
    @Override
    public void initialize() {
        System.out.println("***********Initializing Mecanum Command");
        System.out.println("leftY: " + leftY.getAsDouble() + " leftX: " + leftX.getAsDouble() + " rightZ: " + rightZ.getAsDouble());
    }

    /**
     * The main body of a command.  Called repeatedly while the command is scheduled.
     * (That is, it is called repeatedly until {@link #isFinished()}) returns true.)
     */
    @Override
    public void execute() {
        // System.out.println("Command: " + this.getClass());
//        System.out.println("leftY: " + leftY.getAsDouble() + " leftX: " + leftX.getAsDouble() + " rightZ: " + rightZ.getAsDouble());
        //chopperDrive.testDriveMotors(leftX.getAsDouble());
        
        
        if( driveNormalMech ) {
                    
            chopperDrive.driveWithJoy(
                leftY.getAsDouble(),
                leftX.getAsDouble(),
                rightZ.getAsDouble(),
                gyro);
        }
        else {

            chopperDrive.driveMonCal( leftY.getAsDouble(),  leftX.getAsDouble(),  rightZ.getAsDouble(),  rightY.getAsDouble());
        }
    }

    /**
     * <p>
     * Returns whether this command has finished. Once a command finishes -- indicated by
     * this method returning true -- the scheduler will call its {@link #end(boolean)} method.
     * </p><p>
     * Returning false will result in the command never ending automatically. It may still be
     * cancelled manually or interrupted by another command. Hard coding this command to always
     * return true will result in the command executing once and finishing immediately. It is
     * recommended to use * {@link edu.wpi.first.wpilibj2.command.InstantCommand InstantCommand}
     * for such an operation.
     * </p>
     *
     * @return whether this command has finished.
     */
    @Override
    public boolean isFinished() {
        return false;
    }

    /**
     * The action to take when the command ends. Called when either the command
     * finishes normally -- that is it is called when {@link #isFinished()} returns
     * true -- or when  it is interrupted/canceled. This is where you may want to
     * wrap up loose ends, like shutting off a motor that was being used in the command.
     *
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted) {
    }
}
