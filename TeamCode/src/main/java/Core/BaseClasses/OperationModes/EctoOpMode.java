package Core.BaseClasses.OperationModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import Core.Managers.MechanismManager;
import Robots.TiaTurbina.Configuration;

public abstract class EctoOpMode extends OpMode {

    ElapsedTime runtime = new ElapsedTime();

    boolean endgameRumbleHasNotHappened = true;
    boolean cappingRumbleHasNotHappened = true;
    boolean wareHouseRumbleHasNotHappened = true;


    Double lastTimeRunned = 0.0;
    int updateRate = 10; // Milliseconds
    public MechanismManager mechanismManager;

    @Override
    public final void init() {
        mechanismManager = new MechanismManager();
        initRobotClasses();
    }

    @Override
    public final void init_loop() {
        initRobot();
        telemetry.setMsTransmissionInterval(updateRate);
        mechanismManager.telemetry = telemetry;
        mechanismManager.hardwareMap = hardwareMap;
        mechanismManager.initMechanisms();
    }

    @Override
    public final void start() {
        runtime.reset();
        runtime.startTime();
        lastTimeRunned = getRuntime();
        mechanismManager.startMechanisms();
        startRobot();
    }

    @Override
    public final void loop() {

        mechanismManager.updateMechanisms();
        double timeStep = getRuntime() - lastTimeRunned;
        lastTimeRunned = getRuntime();
        updateRobot(timeStep);

        if ((runtime.seconds() > 120) && endgameRumbleHasNotHappened) {
            gamepad1.runRumbleEffect(Configuration.Mechanisms.RumbleEffects.endGameRumble);
            endgameRumbleHasNotHappened = false;
        }

        if ((runtime.seconds() > 110) && cappingRumbleHasNotHappened) {
            gamepad1.runRumbleEffect(Configuration.Mechanisms.RumbleEffects.cappingRumble);
            cappingRumbleHasNotHappened = false;
        }

        if ((runtime.seconds() > 144) && wareHouseRumbleHasNotHappened) {
            gamepad1.runRumbleEffect(Configuration.Mechanisms.RumbleEffects.cappingRumble);
            wareHouseRumbleHasNotHappened = false;
        }

    }

    /*
    - Runs Once Press Stop
    - Stops Everything.
    */
    public final void stop() {
        mechanismManager.stopMechanisms();
    }

    /*
    - Runs Once You Select The OP Mode On The Driver Station
    - Used To Create The Objects Used In The Tele-Op Mode
    */
    public abstract void initRobotClasses();

    /*
    - Runs When You Click "Init" On The Driver Station
    - Used To Add Mechanism To The Mechanism Manager
    */
    public abstract void initRobot();

    /*
    - Runs When You click "Start" On The Driver Station
    - Used To Move Certain Mechanims To Their Starting Point
    */
    public abstract void startRobot();

    /*
    - Runs After You Click "Start" On The Driver Station
    - Used To Get The Input From The Controllers and "Control" The Mechanisms
    - Runs Every 10 Miliseconds
    */
    public abstract void updateRobot(Double timeStep);
}
