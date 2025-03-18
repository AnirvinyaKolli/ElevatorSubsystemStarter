package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.SubsystemConstants;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class Elevator extends SubsystemBase {

    private SparkMax m_elevatorMotorRight;
    private SparkMax m_elevatorMotorLeft;
    private ProfiledPIDController m_elevatorRightController = new ProfiledPIDController(Constants.ElevatorConstants.kElevatorKp, Constants.ElevatorConstants.kElevatorKi, Constants.ElevatorConstants.kElevatorKd, new TrapezoidProfile.Constraints(0, 0));
    private ProfiledPIDController m_elevatorLeftController = new ProfiledPIDController(0, 0, 0, null);

    public Elevator(){
        m_elevatorMotorRight =  new SparkMax(Constants.SubsystemConstants.kElevatorRightId, MotorType.kBrushless);
        m_elevatorMotorLeft =  new SparkMax(Constants.SubsystemConstants.kElevatorLeftId, MotorType.kBrushless);
    }
    


}