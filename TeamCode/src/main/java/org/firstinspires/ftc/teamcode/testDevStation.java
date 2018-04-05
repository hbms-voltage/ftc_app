package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by dmarino on 3/15/18.
 */

@TeleOp

public class testDevStation extends LinearOpMode {
    private DcMotor Motor_C;
    private DcMotor Motor_D;
    private Servo Servo_A;
    private Servo Servo_B;

    @Override
    public void runOpMode() {
        Motor_C = hardwareMap.get(DcMotor.class, "Motor_C");
        Motor_D = hardwareMap.get(DcMotor.class, "Motor_D");
        Servo_A = hardwareMap.get(Servo.class, "Servo_A");
        Servo_B = hardwareMap.get(Servo.class, "Servo_B");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        double motorCPower = 0;
        double motorDPower = 0;

        waitForStart();

        while (opModeIsActive()) {
            motorCPower = this.gamepad1.left_stick_y;
            motorDPower = this.gamepad1.right_stick_y;

            // If left bumper is pressed, change power to 10%
            if (this.gamepad1.left_bumper) {
                motorCPower = motorCPower * 0.1;
                motorDPower = motorDPower * 0.1;
            }

            Motor_C.setPower(motorCPower);
            Motor_D.setPower(motorDPower);

            if (this.gamepad1.a) {
                Servo_A.setPosition(1);
                Servo_B.setPosition(1);
            } else {
                Servo_A.setPosition(0);
                Servo_B.setPosition(0);
            }

            telemetry.addData("Motor C", motorCPower);
            telemetry.addData("Motor D", motorDPower);
            telemetry.update();
        }
    }
}
