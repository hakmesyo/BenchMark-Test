/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchmarktest;

import java.util.SplittableRandom;
/**
 *
 * @author BAP1
 */
public class BenchMarkMathFunctions {
    private static final int n=(int)1e7;
    private static final int defa=100;
    
    public static void main(String[] args) {
        MyMath.sin(1);
        startTest();
    }

    private static void startTest() {
        double mean=0;
        for (int i = 0; i < defa; i++) {
            mean+=testRandomFunction();
        }
        mean=mean/defa;
        System.out.println("\nAverage elapsed time="+mean/1000+" second");
    }
    
    private static double testRandomFunction(){
        long t1 = tic();
        long toplam=0;
        SplittableRandom rnd=new SplittableRandom();
//        ThreadLocalRandom rnd=ThreadLocalRandom.current();
        for (int i = 0; i < n; i++) {
//            toplam+=(int)(Math.random()*101);
            toplam+=rnd.nextInt(0, 100);
        }
        long t2 = toc(t1);
        double  t= (t2 - t1) / (1000000.0d);
        return t;
    }
    
    
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
