/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchmarktest;

/**
 *
 * @author BAP1
 */
public class MyMath {

    static final int precision = 100; // gradations per degree, adjust to suit

    static final int modulus = 360 * precision;
    static final float[] sin = new float[modulus]; // lookup table

    static {
        // a static initializer fills the table
        // in this implementation, units are in degrees
        for (int i = 0; i < sin.length; i++) {
            sin[i] = (float) Math.sin((i * Math.PI) / (precision * 180));
        }
    }
// Private function for table lookup

    private static float sinLookup(int a) {
        return a >= 0 ? sin[a % (modulus)] : -sin[-a % (modulus)];
    }

// These are your working functions:
    public static float sin(float a) {
        return sinLookup((int) (a * precision + 0.5f));
    }

    public static float cos(float a) {
        return sinLookup((int) ((a + 90f) * precision + 0.5f));
    }
}
