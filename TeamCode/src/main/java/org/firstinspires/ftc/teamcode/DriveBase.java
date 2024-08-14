package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.ArrayList;

public class DriveBase {
    ArrayList<Motor> motors;
    double velocityConst;

    public DriveBase (ArrayList<Motor> motors, double velocityConst) {
        this.motors = motors;
        this.velocityConst = velocityConst;

        for (Motor motor : this.motors) {
            motor.setRunMode(Motor.RunMode.VelocityControl);
            motor.setVeloCoefficients(0.05, 0, 0);
        }
    }

    public void drive (Gamepad gamepad1) {
        Motor leftFrontDrive = motors.get(0);
        Motor rightFrontDrive = motors.get(1);
        Motor leftBackDrive = motors.get(2);
        Motor rightBackDrive = motors.get(3);

        // POV Mode uses left joystick to go forward & strafe, and right joystick to rotate.
        double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  gamepad1.right_stick_x;

        // Combine the joystick requests for each axis-motion to determine each wheel's power.
        // Set up a variable for each drive wheel to save the power level for telemetry.
        double leftFrontPower  = axial + lateral + yaw;
        double rightFrontPower = axial - lateral - yaw;
        double leftBackPower   = axial - lateral + yaw;
        double rightBackPower  = axial + lateral - yaw;

        leftFrontPower  *= velocityConst;
        rightFrontPower *= velocityConst;
        leftBackPower   *= velocityConst;
        rightBackPower  *= velocityConst;

        // Send calculated power to wheels
        leftFrontDrive.set(leftFrontPower);
        rightFrontDrive.set(rightFrontPower);
        leftBackDrive.set(leftBackPower);
        rightBackDrive.set(rightBackPower);
    }
}
