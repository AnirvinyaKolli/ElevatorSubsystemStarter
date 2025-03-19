

package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ElevatorConstants;
import frc.robot.Constants.SubsystemConstants;

import java.beans.Encoder;
import java.security.PrivateKey;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class EndEffector extends SubsystemBase {
    public SparkMax m_endEffector;
    private AbsoluteEncoder m_encoder = m_endEffector.getAbsoluteEncoder();
    
    public double getAngle(){
double angle = m_encoder.getPosition();
    }
public Command rotate(double rotate){

return null;
}
public Command setAngle(double angle)
{
  return /*startRun(()->m_controller.reset(getHeightMeters()),*/
                  run(() -> rotate(angle));
}
public Command setElevatorHeight(double angle)
{
  return setAngle(angle).until(() -> aroundAngle(angle));
}

  public boolean aroundAngle(double height, double allowableError)
  {
  //  System.out.println("Current Height: " + getHeightMeters() + " Desired Height: " + height + " Allowable Error: " +
  //                     (height-getHeightMeters()));
    return MathUtil.isNear(height, getAngle(), allowableError);
  }

}
