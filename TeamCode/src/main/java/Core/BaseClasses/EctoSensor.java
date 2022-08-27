package Core.BaseClasses;


import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import Core.Module;

public abstract class EctoSensor extends Module {


    public EctoSensor(String moduleName, String moduleType) {
        super(moduleName, moduleType);
    }

    public void initSensor(HardwareMap hardwareMap, Telemetry telemetry){
        this.telemetry = telemetry;
        this.hardwareMap = hardwareMap;
    }

    //Every mechanism should be able to do this functions
    public abstract void initSensor();
    public abstract void startSensor();
    public abstract void updateSensor();
    public abstract void stopSensor();
}
