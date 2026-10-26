package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Robot {

    public static Intake intake;
    public static Shooter shooter;
    public static Camera camera;
    public static Gamepad controller;

    private static boolean isInitialized = false;

    public static void init(OpMode op){

        if (!isInitialized) {


            // Create subsystems
            isInitialized = true;
        }

        intake = new Intake(op.hardwareMap);
        shooter = new Shooter(op.hardwareMap);
        controller = op.hardwareMap.get(Gamepad.class, "gamepad1");


    }

}
