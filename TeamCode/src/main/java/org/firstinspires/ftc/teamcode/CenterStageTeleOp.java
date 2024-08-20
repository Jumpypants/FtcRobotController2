package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

@TeleOp(name = "OpMode1")

public class CenterStageTeleOp extends LinearOpMode {

    @Override
    public void runOpMode() {
        Motor frontLeft = new Motor(hardwareMap, "frontLeft");
        Motor frontRight = new Motor(hardwareMap, "frontRight");
        Motor backLeft = new Motor(hardwareMap, "backLeft");
        Motor backRight = new Motor(hardwareMap, "backRight");

        Motor armRotation = new Motor(hardwareMap, "armRotate");
        Motor armExtension = new Motor(hardwareMap, "armExtend");

        CRServo intakeLeft = new CRServo(hardwareMap, "intakeLeft");
        CRServo intakeRight = new CRServo(hardwareMap, "intakeRight");

        CRServo launch = new CRServo(hardwareMap, "launcher");

        ArrayList<Motor> driveMotors = new ArrayList<Motor>();
        driveMotors.add(frontLeft);
        driveMotors.add(frontRight);
        driveMotors.add(backLeft);
        driveMotors.add(backRight);

        DriveBase driveBase = new DriveBase(driveMotors, 1);

        Arm arm = new Arm(
                armRotation,
                armExtension, 1,
                1,
                100,
                -100,
                100,
                -100
        );

        Intake intake = new Intake(intakeLeft, intakeRight, 1);

        Launcher launcher = new Launcher(launch, 1);

        Gamepad gamepad1 = new Gamepad();
        Gamepad gamepad2 = new Gamepad();

        while (opModeIsActive()) {
            driveBase.drive(gamepad1);
            arm.drive(gamepad2);
            intake.drive(gamepad2);
            launcher.drive(gamepad2);
        }
    }
}
