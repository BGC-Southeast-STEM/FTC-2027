
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.configuration.annotations.ServoType;
import com.qualcomm.robotcore.hardware.configuration.annotations.ServoTypes;


public class Uptake {
    private Servo UptakeMotor = null;

    public Uptake(HardwareMap hardware) {
        UptakeMotor = hardware.get(Servo.class, "uptake");


    }

    public void spin(boolean uptake) {
        double power;
        if(uptake){
            power = 1;
        }else{
            power = 0;
        }
        double liesAndTrickery = (power + 1) / 2;
        UptakeMotor.setPosition(liesAndTrickery);
    }
}




