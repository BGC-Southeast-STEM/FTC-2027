
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Default OpMode", group="Iterative OpMode")
public class DefaultOpMode extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;



    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        Robot.init(this);

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit START
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits START
     */
    @Override
    public void start() {
        runtime.reset();
    }

    private int RPM = 0;

    /*
     * Code to run REPEATEDLY after the driver hits START but before they hit STOP
     */
    @Override
    public void loop() {
        // Set up a variable for each drive wheel to save power level for telemetry
        double leftPower;
        double rightPower;

        // Choose to drive using either Tank Mode, or POV Mode
        // Comment out the method that's not used.  The default below is POV.

        // POV Mode uses left stick to go forward, and right stick to turn.
        // - This uses basic math to combine motions and is easier to drive straight.
        double drive = -Robot.driverController.left_stick_y;
        double turn  =  -Robot.driverController.left_stick_x;
        double intakePower = Robot.driverController.left_trigger;
        double shoot = Robot.driverController.right_trigger;
        boolean uptakeOn = Robot.driverController.y;
        // Tank Mode uses one stick to control each wheel.
        // - This requires no math, but it is hard to drive forward slowly and keep straight.
        leftPower  = -gamepad1.left_stick_y ;
        rightPower = -gamepad1.right_stick_y ;

        if (gamepad1.xWasPressed()){
            Robot.drivetrain.isTankDrive = !Robot.drivetrain.isTankDrive;
        }
        telemetry.addData("Tank", Robot.drivetrain.isTankDrive);
        if (Robot.drivetrain.isTankDrive){
            Robot.drivetrain.tankDrive(leftPower, rightPower);
        }else{
            Robot.drivetrain.arcadeDrive(drive, turn);
        }

        if(gamepad1.dpadDownWasPressed()){
            RPM -= 500;
        } else if (gamepad1.dpadUpWasPressed()) {
            RPM += 500;
        }


        Robot.shooter.spinShoot(RPM);
        Robot.intake.spin(intakePower);
        Robot.uptake.spin(uptakeOn);


        Robot.periodic(telemetry);

        // Show the elapsed game time and wheel power.
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.addData("target RPM", RPM); //:3
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
