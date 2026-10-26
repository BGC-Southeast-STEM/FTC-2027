package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Shooter {
    private DcMotor ShooterMotor = null;

    public Shooter(HardwareMap hardware) {
        ShooterMotor = hardware.get(DcMotor.class, "shooter");
        //gamepad1.

    }
    public void SpinShoot(double shoot) {

        ShooterMotor.setPower(shoot);

    }
}

