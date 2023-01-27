package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Hopper;


public class HopperRunBackwardsCommand extends CommandBase {
    private Hopper m_hopper;

    public HopperRunBackwardsCommand(Hopper subsystem) {
        m_hopper = subsystem;
        addRequirements(m_hopper);

    }

    @Override
    public void initialize() {
        m_hopper.hopperSpinClockwiseSlow();
    }

    @Override
    public void execute() { {

    }

    }

    @Override
    public boolean isFinished() { return false; }


    @Override
    public void end(boolean interrupted) { {
        m_hopper.hopperStop();
    }

    }
}
