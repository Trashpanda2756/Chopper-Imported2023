// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */
public class FeetToTickMath {

    static final double ftToTickFowardBack = 8.7; 
    static final double ftToTickStrafe = 12.1;
    static final double ftToTickStrafeAngle = 10.2;

    public static double forwardBackward( double feet ) {

        return feet * ftToTickFowardBack;
    }

    public static double strafe( double feet ) {

        return feet * ftToTickStrafe;
    }

    public static double strafeAngle( double feet ) {
        return feet * ftToTickStrafeAngle;
    }
}
