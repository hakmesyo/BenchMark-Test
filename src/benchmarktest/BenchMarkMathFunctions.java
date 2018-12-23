/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchmarktest;

import java.util.SplittableRandom;
public class BenchMarkMathFunctions {

    private static final int n = (int) 1e6;
    private static final int defa = 100;

    public static void main(String[] args) {
        startTest();
    }

    private static void startTest() {
        double mean = 0;
        for (int i = 0; i < defa; i++) {
//            mean += testMathFunction();
            mean+=testRandomFunction();
//            mean += testNestedForLoop();
        }
        mean = mean / defa;
        System.out.println("\nAverage elapsed time=" + mean / 1000 + " second");
    }

    private static double testNestedForLoop() {
        long t1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                callFor();
            }
        }
        long t2 = System.nanoTime();
        double t = (t2 - t1) / 1e6;
        return t;
    }

    private static void callFor() {
        long toplam = 0;
        for (int k = 0; k < n; k++) {
            callFor2();
        }
    }

    private static void callFor2() {
        long toplam = 0;
        for (int k = 0; k < n; k++) {
            callFor3();
        }
    }

    private static void callFor3() {
        long toplam = 0;
        for (int k = 0; k < n; k++) {
            toplam++;
        }
    }

    private static double testMathFunction() {
        long t1 = System.nanoTime();
        long t = 0;
        for (int i = 0; i < n; i++) {
            t+=MyMath.sin(i%360*3.14f/180);
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / 1e6;
        System.out.println("elapsed time = " + elapsed+" ms");
        return elapsed;
    }

    private static double testRandomFunction() {
        long t1 = System.nanoTime();
        long toplam = 0;
        SplittableRandom rnd = new SplittableRandom();
//        ThreadLocalRandom rnd=ThreadLocalRandom.current();
        for (int i = 0; i < n; i++) {
//            toplam+=(int)(Math.random()*101);
            toplam += rnd.nextInt(0, 100);
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / 1e6;
        System.out.println("elapsed time = " + elapsed+" ms");
        return elapsed;
    }
}
