//*************************************************************************************************************
//    JAVA CODE   1000x1000 add scalar takes 1.5 ms, math random takes 100 ms, Splittable random takes 14 ms, 
//                fast sin function takes 38 ms, math sin function takes 240 ms
//*************************************************************************************************************
package benchmarktest;

import java.util.SplittableRandom;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_Java {

    private static final int MAX = 1000;
    private static final int DEFA = 100;

    static float[][] d = new float[MAX][MAX];

    public static void main(String[] args) {
        double t = 0;
        for (int i = 0; i < DEFA; i++) {
//            t += testOJLMathSinFunction();
//            t += testMathSinFunction();
            t += testSplittableRandomFunction();
//            t += testMathRandomFunction();
//            t += testAddScalar();
        }
        t = t / DEFA;
        System.out.println("Average elapsed time = " + t + " ms");
    }
    
    private static double testOJLMathSinFunction(){
        long t1 = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            ojlMathSinFunction(i);
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed + " ms");
        return elapsed;
    }

    private static void ojlMathSinFunction(int i){
        for (int j = 0; j < MAX; j++) {
            d[i][j] += OJLMath.sin((float)(j%360*Math.PI/180));
        }
    }
    
    private static double testMathSinFunction(){
        long t1 = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            mathSinFunction(i);
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed + " ms");
        return elapsed;
    }

    private static void mathSinFunction(int i){
        for (int j = 0; j < MAX; j++) {
            d[i][j] += Math.sin(j%360*Math.PI/180);
        }
    }
    private static double testAddScalar() {
        long t1 = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            addScalar(i);
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed + " ms");
        return elapsed;
    }

    private static void addScalar(int i) {
        for (int j = 0; j < MAX; j++) {
            d[i][j] += 21;
        }
    }

    private static double testMathRandomFunction() {
        long t1 = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            mathRandomFunction(i);
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed + " ms");
        return elapsed;
    }

    private static void mathRandomFunction(int i) {
        for (int j = 0; j < MAX; j++) {
            d[i][j] = (float) (Math.random() * 101);
        }
    }

    private static double testSplittableRandomFunction() {
        long t1 = System.nanoTime();
        for (int i = 0; i < MAX; i++) {
            splittableRandomFunction(i);
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed + " ms");
        return elapsed;
    }

    private static void splittableRandomFunction(int i) {
        SplittableRandom rnd = new SplittableRandom();
        for (int j = 0; j < MAX; j++) {
            d[i][j] = rnd.nextInt(0, 100);;
        }
    }

}
