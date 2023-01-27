package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.IntakeActuator;
import frc.robot.subsystems.IntakeMotor;

public class IntakeSequenceCommandGroup extends SequentialCommandGroup {

    private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
    private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);
    
    public IntakeSequenceCommandGroup(IntakeMotor intakeMotor, Hopper hopper, IntakeActuator intakeActuator) {
        super(
            new InstantCommand(() -> {
                    intakeActuator.intakeOut();
                }),
                new InhaleCommand(hopper, intakeMotor, intakeActuator)
            );
    }
}