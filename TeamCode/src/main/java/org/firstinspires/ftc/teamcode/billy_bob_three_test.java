package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by Celia on 3/19/2018.
 */
@TeleOp
public class billy_bob_three_test extends LinearOpMode {
    private DcMotor arm;
    private DcMotor left_wheel;
    private DcMotor right_wheel;
    private Servo left_claw;
    private Servo right_claw;
    private TouchSensor touch;

    @Override
    public void runOpMode() {
        arm = hardwareMap.get(DcMotor.class, "arm");
        left_wheel = hardwareMap.get(DcMotor.class, "left_wheel");
        right_wheel = hardwareMap.get(DcMotor.class, "right_wheel");
        left_claw = hardwareMap.get(Servo.class, "left_claw");
        right_claw = hardwareMap.get(Servo.class, "right_claw");
        touch = hardwareMap.get(TouchSensor.class, "touch");

        double left_wheel_power;
        double right_wheel_power;
        double left_servo_position;
        double right_servo_position;
        double arm_position;
        double arm_speed;
        double drive_speed;

        waitForStart();

        while (opModeIsActive()) {
            left_wheel_power = 0;
            right_wheel_power = 0;
            arm_position = 0;
            left_servo_position = 0;
            right_servo_position = 0;

            if (this.gamepad1.right_bumper){
                drive_speed = 10;
            } else {
                drive_speed = 1;
            }

            if (this.gamepad2.right_bumper){
                //makes arm slower
                arm_speed = 10;
            } else {
                //makes arm normal speed
                arm_speed = 5;
            }

            left_wheel.setPower(-this.gamepad1.left_stick_y / drive_speed);
            right_wheel.setPower(this.gamepad1.right_stick_y / drive_speed);

            if (this.gamepad2.x){
                left_claw.setPosition(180);
                right_claw.setPosition(0);
            } else {
                left_claw.setPosition(0);
                right_claw.setPosition(180);
            }

            if (touch.isPressed()) {
                if (-this.gamepad2.left_stick_y < 0) {
                    arm.setPower(0);
                } else {
                    arm.setPower(-this.gamepad2.left_stick_y / arm_speed);
                }
            } else {
                arm.setPower(-this.gamepad2.left_stick_y / arm_speed);
            }

        }
    }
}
