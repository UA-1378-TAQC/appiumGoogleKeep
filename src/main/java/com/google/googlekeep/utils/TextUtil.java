package com.google.googlekeep.utils;

import io.appium.java_client.android.nativekey.AndroidKey;

public class TextUtil {
    public static AndroidKey getAndroidKey(char c) {
        return switch (Character.toLowerCase(c)) {
            case 'a' -> AndroidKey.A;
            case 'b' -> AndroidKey.B;
            case 'c' -> AndroidKey.C;
            case 'd' -> AndroidKey.D;
            case 'e' -> AndroidKey.E;
            case 'f' -> AndroidKey.F;
            case 'g' -> AndroidKey.G;
            case 'h' -> AndroidKey.H;
            case 'i' -> AndroidKey.I;
            case 'j' -> AndroidKey.J;
            case 'k' -> AndroidKey.K;
            case 'l' -> AndroidKey.L;
            case 'm' -> AndroidKey.M;
            case 'n' -> AndroidKey.N;
            case 'o' -> AndroidKey.O;
            case 'p' -> AndroidKey.P;
            case 'q' -> AndroidKey.Q;
            case 'r' -> AndroidKey.R;
            case 's' -> AndroidKey.S;
            case 't' -> AndroidKey.T;
            case 'u' -> AndroidKey.U;
            case 'v' -> AndroidKey.V;
            case 'w' -> AndroidKey.W;
            case 'x' -> AndroidKey.X;
            case 'y' -> AndroidKey.Y;
            case 'z' -> AndroidKey.Z;
            case '0' -> AndroidKey.DIGIT_0;
            case '1' -> AndroidKey.DIGIT_1;
            case '2' -> AndroidKey.DIGIT_2;
            case '3' -> AndroidKey.DIGIT_3;
            case '4' -> AndroidKey.DIGIT_4;
            case '5' -> AndroidKey.DIGIT_5;
            case '6' -> AndroidKey.DIGIT_6;
            case '7' -> AndroidKey.DIGIT_7;
            case '8' -> AndroidKey.DIGIT_8;
            case '9' -> AndroidKey.DIGIT_9;
            case ' ' -> AndroidKey.SPACE;
            case ',' -> AndroidKey.COMMA;
            case '.' -> AndroidKey.PERIOD;
            case '@' -> AndroidKey.AT;
            case '#' -> AndroidKey.POUND;
            case '!' -> AndroidKey.DIGIT_1;
            case '?' -> AndroidKey.SLASH;
            case ':' -> AndroidKey.SEMICOLON;
            case ';' -> AndroidKey.SEMICOLON;
            case '\'' -> AndroidKey.APOSTROPHE;
            case '"' -> AndroidKey.APOSTROPHE;
            case '-' -> AndroidKey.MINUS;
            case '_' -> AndroidKey.MINUS;
            case '+' -> AndroidKey.EQUALS;
            case '/' -> AndroidKey.SLASH;
            case '\\' -> AndroidKey.BACKSLASH;
            default -> throw new IllegalArgumentException("Unsupported character: " + c);
        };
    }
}
