package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.hardware.motors.CRServo;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import java.util.ArrayList;

@TeleOp(name = "Test")

public class DirectionTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        Motor frontLeft = new Motor(hardwareMap, "frontLeft");
        frontLeft.setInverted(false);

        Motor frontRight = new Motor(hardwareMap, "frontRight");
        frontRight.setInverted(false);
        Motor backLeft = new Motor(hardwareMap, "backLeft");
        backLeft.setInverted(false);
        Motor backRight = new Motor(hardwareMap, "backRight");
        backRight.setInverted(false);

        Motor armRotation = new Motor(hardwareMap, "armRotate");
        armRotation.setInverted(false);
        Motor armExtension = new Motor(hardwareMap, "armExtend");
        armExtension.setInverted(false);

        CRServo intakeLeft = new CRServo(hardwareMap, "intakeLeft");
        intakeLeft.setInverted(false);
        CRServo intakeRight = new CRServo(hardwareMap, "intakeRight");
        intakeRight.setInverted(false);

        CRServo launch = new CRServo(hardwareMap, "launcher");
        launch.setInverted(false);

        ArrayList<Motor> list = new ArrayList<Motor>();
        list.add(frontLeft);
        list.add(frontRight);
        list.add(backLeft);
        list.add(backRight);
        list.add(armRotation);
        list.add(armExtension);
        list.add(intakeRight);
        list.add(intakeLeft);
        list.add(launch);
        for (Motor m : list) {
            m.setRunMode(Motor.RunMode.PositionControl);
            m.set(0.1);
        }
    }
}
