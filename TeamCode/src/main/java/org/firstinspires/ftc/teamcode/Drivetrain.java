package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.Range;

public class Drivetrain {
    private final DcMotor leftMotor;
    private final DcMotor rightMotor;
    public boolean isTankDrive = true;

    public Drivetrain(HardwareMap hw) {
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        leftMotor  = hw.get(DcMotor.class, "left_drive");
        rightMotor = hw.get(DcMotor.class, "right_drive");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
    }

    public void tankDrive(double left, double right) {
        // Send calculated power to wheels
        // finn and sara were here
        leftMotor.setPower(left);
        rightMotor.setPower(right);
    }

    public void arcadeDrive(double drive, double turn) {
        double leftPower  = Range.clip(drive - turn * .5, -1.0, 1.0) ;
        double rightPower = Range.clip(drive + turn * .5, -1.0, 1.0) ;
        tankDrive(leftPower, rightPower);
    }

}
