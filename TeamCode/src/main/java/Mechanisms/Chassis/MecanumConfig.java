package Mechanisms.Chassis;

import com.arcrobotics.ftclib.hardware.motors.Motor;

import Robots.TiaTurbina.Configuration;

public class MecanumConfig extends Configuration {

    public MecanumConfig(String frontLeftId, String backLeftId, String frontRightId, String backRightId, String IMUId, Motor.GoBILDA GobildaMotorType) {

        getfrontLeftId = frontLeftId;
        getfrontRightId = frontRightId;
        getbackLeftId = backLeftId;
        getbackRightId = backRightId;

        getIMUId = IMUId;

        getGobildaType = GobildaMotorType;

    }

    public String getfrontLeftId;
    public String getfrontRightId;
    public String getbackLeftId;
    public String getbackRightId;

    public String getIMUId;

    public Motor.GoBILDA getGobildaType;

    public int positionTolerance = 0;
    public int velocityTolerance = 0;
}
