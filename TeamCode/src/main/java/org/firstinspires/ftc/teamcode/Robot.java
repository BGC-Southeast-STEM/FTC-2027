package org.firstinspires.ftc.teamcode;

//https://github.com/BGC-Southeast-STEM/FTC-2027/blob/cb43b5691cfab2318bcf2a0cf06fa640e985a13f/TeamCode/src/main/java/org/firstinspires/ftc/teamcode/DefaultOpMode.java#L99
// The Quick Brown Fox Jumps Over The Lazy Dog
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Robot {

    public static Drivetrain drivetrain;
    public static Intake intake;
    public static Shooter shooter;

    public static Uptake uptake;
    public static Camera camera;
    public static Gamepad driverController;

    private static boolean isInitialized = false;

    public static void init(OpMode op){

        if (!isInitialized) {


            // Create subsystems
            isInitialized = true;
        }

        drivetrain = new Drivetrain(op.hardwareMap);
        intake = new Intake(op.hardwareMap);
        uptake = new Uptake(op.hardwareMap);
        shooter = new Shooter(op.hardwareMap);
        driverController = op.gamepad1;
    }

    public static void periodic(Telemetry telemetry) {
        shooter.periodic(telemetry);
    }



}
