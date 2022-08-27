package Robots.TiaTurbina;

import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.Gamepad;

import Mechanisms.Chassis.MecanumConfig;

public class Configuration {
    public static class Mechanisms {

        public static class RumbleEffects {

            public static Gamepad.RumbleEffect endGameRumble =
                    new Gamepad.RumbleEffect.Builder()
                            .addStep(0.0, 1.0, 500)
                            .addStep(0.0, 0.0, 300)
                            .addStep(1.0, 0.0, 250)
                            .addStep(0.0, 0.0, 250)
                            .addStep(1.0, 0.0, 250)
                            .addStep(0.0, 0.0, 300)
                            .addStep(1.0, 0.0, 250)
                            .addStep(0.0, 0.0, 250)
                            .addStep(1.0, 0.0, 250)
                            .build();

            public static Gamepad.RumbleEffect cappingRumble =
                    new Gamepad.RumbleEffect.Builder()
                            .addStep(0.0, 1.0, 250)
                            .addStep(0.2, 0.2, 300)
                            .addStep(1.0, 0.0, 250)
                            .addStep(0.0, 1.0, 250)
                            .addStep(0.2, 0.2, 300)
                            .addStep(1.0, 0.0, 250)
                            .build();

            public static Gamepad.RumbleEffect wareHouseRumble =
                    new Gamepad.RumbleEffect.Builder()
                            .addStep(0.0, 1.0, 500)
                            .addStep(0.0, 0.0, 300)
                            .addStep(1.0, 0.0, 250)
                            .addStep(0.0, 0.0, 250)
                            .addStep(1.0, 0.0, 250)
                            .addStep(0.0, 0.0, 300)
                            .addStep(1.0, 0.0, 250)
                            .addStep(0.0, 0.0, 250)
                            .addStep(1.0, 0.0, 250)
                            .build();
        }





        public static MecanumConfig mecanumConfig =
                new MecanumConfig(
                        "frontLeftMotor",
                        "backLeftMotor",
                        "frontRightMotor",
                        "backRightMotor",
                        "imu",
                        Motor.GoBILDA.RPM_223);



    }
    public static class Buttons {

        public static GamepadKeys.Button a = GamepadKeys.Button.A;
        public static GamepadKeys.Button b = GamepadKeys.Button.B;
        public static GamepadKeys.Button x = GamepadKeys.Button.X;
        public static GamepadKeys.Button y = GamepadKeys.Button.Y;

        public static GamepadKeys.Button leftBumper = GamepadKeys.Button.LEFT_BUMPER;
        public static GamepadKeys.Button rightBumper = GamepadKeys.Button.RIGHT_BUMPER;

        public static GamepadKeys.Trigger leftTrigger = GamepadKeys.Trigger.LEFT_TRIGGER;
        public static GamepadKeys.Trigger rightTrigger = GamepadKeys.Trigger.RIGHT_TRIGGER;

        public static GamepadKeys.Button leftStickButton = GamepadKeys.Button.LEFT_STICK_BUTTON;
        public static GamepadKeys.Button rightStickButton = GamepadKeys.Button.RIGHT_STICK_BUTTON;

        public static GamepadKeys.Button dPadDown = GamepadKeys.Button.DPAD_DOWN;
        public static GamepadKeys.Button dPadLeft = GamepadKeys.Button.DPAD_LEFT;
        public static GamepadKeys.Button dPadUp = GamepadKeys.Button.DPAD_UP;
        public static GamepadKeys.Button dPadRight = GamepadKeys.Button.DPAD_RIGHT;

        public static GamepadKeys.Button start = GamepadKeys.Button.START;
        public static GamepadKeys.Button back = GamepadKeys.Button.BACK;
    }
}



