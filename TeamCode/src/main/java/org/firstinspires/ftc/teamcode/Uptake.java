
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;


public class Uptake {
    private DcMotor UptakeMotor = null;

    public Uptake(HardwareMap hardware) {
        UptakeMotor = hardware.get(DcMotor.class, "uptake");


    }
    public void spin(double power) {



    }
}




