package Robots.TiaTurbina.TeleOperated;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import Core.BaseClasses.OperationModes.EctoOpMode;

//@Disabled
@TeleOp(name = "EncoderTester", group = "Testing")
public class EncoderTester extends EctoOpMode {

    DcMotor fL, fR, bL, bR;



    @Override
    public void initRobotClasses() {
        fL = hardwareMap.dcMotor.get("frontLeftMotor");
        fR = hardwareMap.dcMotor.get("frontRightMotor");
        bL = hardwareMap.dcMotor.get("backLeftMotor");
        bR = hardwareMap.dcMotor.get("backRightMotor");



    }

    @Override
    public void initRobot() {
        fL.setDirection(DcMotor.Direction.REVERSE);
        bL.setDirection(DcMotor.Direction.REVERSE);
        fR.setDirection(DcMotor.Direction.FORWARD);
        bR.setDirection(DcMotor.Direction.FORWARD);


    }

    @Override
    public void startRobot() {
    }

    @Override
    public void updateRobot(Double timeStep) {

        telemetry.addData("Front Right", fR.getCurrentPosition());
        telemetry.addData("Back Left ", bL.getCurrentPosition());
        telemetry.addData("Back Right ", bR.getCurrentPosition());
        telemetry.addData("Back Right ", fL.getCurrentPosition());


        telemetry.update();


    }
}
