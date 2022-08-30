package Robots.TiaTurbina.TeleOperated;


import static Robots.TiaTurbina.Configuration.Mechanisms.mecanumConfig;


import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import Core.BaseClasses.EctoMechanism;
import Core.BaseClasses.OperationModes.EctoOpMode;
import Mechanisms.Chassis.Mecanum;
import Robots.TiaTurbina.Configuration;


@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOperatedTiaTurbina", group = "Working")
public class TeleOpTiaTurbina extends EctoOpMode {

    // Mechanisms
    Mecanum chassis;


    // Controllers
    public static GamepadEx driverGamepad;
    public static GamepadEx manipulatorGamepad;

    ElapsedTime runtime = new ElapsedTime();
    boolean rumbleHasNotHappened = false;

    @Override
    public void initRobotClasses() {

        // Controllers
        manipulatorGamepad = new GamepadEx(gamepad2);
        driverGamepad = new GamepadEx(gamepad1);

        // Mechanisms
        chassis = new Mecanum("ChassisMecanum", "Mechanism", mecanumConfig);

        // State Machines
    }

    @Override
    public void initRobot() {
        mechanismManager.addMechanism(chassis);
    }

    @Override
    public void startRobot() {
    }

    @Override
    public void updateRobot(Double timeStep) {

        chassis.setState(EctoMechanism.State.Off);

        // + ########################## + //
        // + ######## CHASSIS ######### + //
        // + ########################## + //

        // + CHASSIS BUTTON CONFIGURATION
        if (driverGamepad.getButton(Configuration.Buttons.back)) {
            chassis.resetHeading();
        }

        if (driverGamepad.getLeftY() != 0 && driverGamepad.getButton(Configuration.Buttons.rightBumper)
                || driverGamepad.getLeftX() != 0
                && driverGamepad.getButton(Configuration.Buttons.rightBumper)
                || driverGamepad.getRightX() != 0
                && driverGamepad.getButton(Configuration.Buttons.rightBumper)) {

            chassis.setChassisMovement(
                    driverGamepad.getLeftX() * 0.325,
                    driverGamepad.getLeftY() * 0.325,
                    driverGamepad.getRightX() * 0.325,
                    Mecanum.orientation.field);

        } else if (driverGamepad.getLeftY() != 0
                && driverGamepad.getButton(Configuration.Buttons.leftBumper)
                || driverGamepad.getLeftX() != 0
                && driverGamepad.getButton(Configuration.Buttons.leftBumper)
                || driverGamepad.getRightX() != 0
                && driverGamepad.getButton(Configuration.Buttons.leftBumper)) {

            chassis.setChassisMovement(
                    driverGamepad.getLeftX() * 0.5,
                    driverGamepad.getLeftY() * 0.5,
                    driverGamepad.getRightX() * 0.5,
                    Mecanum.orientation.field);

        } else if (driverGamepad.getLeftY() != 0
                || driverGamepad.getLeftX() != 0
                || driverGamepad.getRightX() != 0) {

            chassis.setChassisMovement(
                    driverGamepad.getLeftX() * 1,
                    driverGamepad.getLeftY() * 1,
                    driverGamepad.getRightX() * 1,
                    Mecanum.orientation.field);

        } else {

            chassis.stopChassis();
        }
    }

}