package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.logging.LogWrapper;
import frc.robot.logging.PeriodicLogger;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.IntakeActuator;
import frc.robot.subsystems.IntakeMotor;



public class InhaleCommand extends CommandBase {

    private final Hopper m_hopper;
    private final IntakeMotor m_intakeMotor;

    private final LogWrapper mLog = new LogWrapper(this.getClass().getName());
    private final PeriodicLogger mPLog = new PeriodicLogger(mLog, 50);

    public InhaleCommand(Hopper hopper, IntakeMotor intakeMotor) {
        m_hopper = hopper;
        m_intakeMotor = intakeMotor;
        addRequirements(m_hopper, m_intakeMotor);
    }

    @Override
    public void initialize() {
        mLog.debug(this.getClass().getName() + ":Inhale command starting");
        m_intakeMotor.in();
        m_hopper.hopperSpinCounterClockwiseSlow();
    }

    @Override
    public void execute() {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        mLog.debug(this.getClass().getName() + ":Inhale command ending");
        m_hopper.hopperStop();
        m_intakeMotor.stop();
    }
}
