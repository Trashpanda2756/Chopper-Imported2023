package frc.robot.commands;


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;


public class HopperRunnerCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField", "FieldCanBeLocal"})
    private final Hopper m_hopper;

    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public HopperRunnerCommand(Hopper subsystem) {
        m_hopper = subsystem;
        addRequirements(m_hopper);
    }

    @Override
    public void initialize() {
        m_hopper.hopperSpinCounterClockwiseFast();
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        m_hopper.hopperStop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
