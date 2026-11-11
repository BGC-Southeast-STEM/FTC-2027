package org.firstinspires.ftc.teamcode;

import com.bylazar.telemetry.PanelsTelemetry;
import com.bylazar.telemetry.TelemetryManager;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Shooter {
    private static final double TICKS_PER_REV = 28;
    private VoltageSensor voltageSensor;
    private DcMotorEx ShooterMotor = null;
    private static final double KF = 0.00251;
    private static final double kP = 0.012;

    private double targetSpeed;

    public Shooter(HardwareMap hardware) {
        ShooterMotor = hardware.get(DcMotorEx.class, "shooter");
        voltageSensor = hardware.get(VoltageSensor.class, "Control Hub");
        //gamepad1.

    }
    public void spinShoot(double shoot) {
        targetSpeed = shoot;
        if (targetSpeed > 4500){
            targetSpeed= 4500;
        }
        if (targetSpeed < -500){
            targetSpeed= -500;
        }


    }

    public double getSpeedRPM() {
        double ticksPerSecond = ShooterMotor.getVelocity();
        return (ticksPerSecond / 28) * 60 ;
    }

    public void periodic(TelemetryManager telemetry){

        double error=targetSpeed-getSpeedRPM();

        double targetVolts =
                targetSpeed * KF
                + kP * error;

//        shoot = Math.min(0.61, shoot);
        ShooterMotor.setPower(targetVolts/voltageSensor.getVoltage());


        telemetry.addData("shoter speed",getSpeedRPM());
        telemetry.addData("Target Speed", targetSpeed);
    }

}

