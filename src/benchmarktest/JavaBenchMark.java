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
public class JavaBenchMark {

    private static final int max = 10000;
    private static float[][] d = new float[max][max];
    private static int defa = 100;

    public static void main(String[] args) {
        System.out.println("size:"+Long.SIZE);
//        call_forforfor();
//        call_for_forfor();
        call_for_for_for();
    }

    private static void call_forfor() {
        for (int j = 0; j < max; j++) {
            for (int k = 0; k < max; k++) {
                d[j][k] += 21;
            }
        }
    }

    private static void call_for_forfor() {
        long t1 = 0;
        double mean = 0;
        for (int i = 0; i < defa; i++) {
            t1 = tic();
            call_forfor();
            long t2 = toc(t1);
            mean += (t2 - t1) / (1000000.0d);
        }
        mean = mean / defa;
        System.out.println("Average Elapsed Time = " + mean);
    }

    private static void call_forforfor() {
        long t1 = 0;
        double mean = 0;
        for (int i = 0; i < defa; i++) {
            t1 = tic();
            for (int j = 0; j < max; j++) {
                for (int k = 0; k < max; k++) {
                    d[j][k] += 21;
                }
            }
            long t2 = toc(t1);
            mean += (t2 - t1) / (1000000.0d);
        }
        mean = mean / defa;
        System.out.println("Average Elapsed Time = " + mean);
    }

    private static void call_for_for_for() {
        long t1 = 0;
        double mean = 0;
        for (int i = 0; i < defa; i++) {
            t1 = tic();
            call_for_for();
            long t2 = toc(t1);
            mean += (t2 - t1) / (1000000.0d);
        }
        mean = mean / defa;
        System.out.println("Average Elapsed Time = " + mean/1000);
    }

    private static void call_for_for() {
        for (int j = 0; j < max; j++) {
            call_for(j);
        }
    }

    private static void call_for(int j) {
        for (int k = 0; k < max; k++) {
            d[j][k] += 21;
        }
    }
//    private static float[] call_for(float[] f) {
//        for (int k = 0; k < max; k++) {
//            f[k] += 21;
//        }
//        return f;
//    }
    
    public static long tic() {
        long currentTime = System.nanoTime();
        return currentTime;
    }

    public static long toc(String msg, long tic) {
        long toc = System.nanoTime();
        double elapsed = (toc - tic) / (1000000.0d);
        System.out.println(msg + elapsed + " miliSecond");
        return toc;
    }

    public static long toc(long tic) {
        long toc = System.nanoTime();
        double elapsed = (toc - tic) / (1000000.0d);
        System.out.println("Elapsed Time:" + elapsed + " miliSecond");
        return toc;
    }

}
