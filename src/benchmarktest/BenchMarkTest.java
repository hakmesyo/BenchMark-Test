/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package benchmarktest;

import cezeri.matrix.CMatrix;
import cezeri.utils.FactoryUtils;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BAP1
 */
public class BenchMarkTest {

    /**
     * @param args the command line arguments
     */
    static int max = 10000;
    static int defa = 50;
    
    static byte[][] sd = new byte[max][max];

    public static void main(String[] args) {
//        warmupJVM();
        nativeJavaTest();
//        oclTest();
    }

    private static void oclTest() {
//        double t=0;
//        for (int i = 0; i < defa; i++) {
//            long t1 = FactoryUtils.tic();
//            CMatrix.getInstance()
//                    .tic()   
//                    //.setArray(sd)
//                    .toc()                
//                    .addScalar(21)
//                    .toc()
////                    .tic()
//                    //.rand(max, max, 0, 100)
////                    .toc()
//                    ;
//            long t2=FactoryUtils.tic();
//            double et= (t2-t1)/1000000.0;
//            System.out.println("elapsed time = " + et);
//            t+=et;
//        }
//        t=t/defa;
//        System.out.println("average elapsed time = " + t);

    }

//*****************************************************************************
//    JAVA CODE  random 1000x1000 takes 0.11 sec
//*****************************************************************************

    private static void nativeJavaTest() {
        double t = 0;
        for (int i = 0; i < defa; i++) {
//            t += generateArray(max);
            t += populateArray();
        }
        t = t / defa;
        System.out.println("ortalama süre = " + t / 1000 + " sn");
    }

    private static void warmupJVM() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(BenchMarkTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static double generateArray(int max) {
        long t1 = FactoryUtils.tic();
        double[][] d = new double[max][max];
        int nr = d.length;
        int nc = d[0].length;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
//                d[i][j] = (int) (Math.random() * 101);
                d[i][j]= d[i][j]+21;
            }
        }
        long t2 = FactoryUtils.toc(t1);
        double elapsed = (t2 - t1) / (1000000.0d);
        return elapsed;
    }
    
    private static double populateArray() {
        long t1 = FactoryUtils.tic();
        int nr = max;
        int nc = max;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
//                sd[i][j] = (float)(Math.random() * 101);
                sd[i][j]+=21;
            }
        }
        long t2 = FactoryUtils.toc(t1);
        double elapsed = (t2 - t1) / (1000000.0d);
        return elapsed;
    }



//*****************************************************************************
//    PYTHON CODE  random 1000x1000 takes 0.154 sec
//*****************************************************************************
/*
import timeit
import numpy as np

a=1
b=1
print("a=",a," b=",b)
a,b=b,a
print("a=",a," b=",b)

for t in range(10):
   a,b=b+a,a
   print("a=",a);

n=1000
t=0

for x in range(10):
    start = timeit.default_timer()
    y=np.random.randn(n,n)
    stop = timeit.default_timer()
    t+=(stop - start)
    print('Time: ', stop - start)  

print('avg time=',t/10," sn")

*/
    
    
//*****************************************************************************
//    RUBY CODE  random 1000x1000 takes 0.82 sec
//*****************************************************************************
/*
max=1000
for i in 1..10
  t1=Time.now
  x=Array.new(max) { Array.new(max){rand(1..100)}}
  t2=Time.now
  elapsed=(t2-t1)
  puts("elapsed time="+elapsed.to_s)
end
*/
    
//*****************************************************************************
//    MATLAB CODE random 1000x1000 takes 0.045 sec
//*****************************************************************************
/*
clc;
clear;
n=1000;
for i=1:10
    tic;
    a=rand(n);
    toc;
end
*/
    
//*****************************************************************************
//    GNU C CODE random 1000x1000 takes 0.047 sec
//*****************************************************************************
/*
    
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 1000

float d[MAX][MAX];


int main()
{
    for(int i=0;i<10;i++){
        clock_t t1=clock();

        for(int j=0;j<MAX;j++){
            for(int k=0;k<MAX;k++){
                d[j][k]=rand()%100;
            }
        }

        clock_t t2=clock();
        double elapsed=((double) (t2 - t1)) / CLOCKS_PER_SEC;
        printf("elapsed time taken=%f\n",elapsed);
    }
    return 0;
}
*/

//*****************************************************************************
//    Visual Studio C++ CODE random 1000x1000 takes 0.061 sec
//*****************************************************************************
/*
    
#include "stdafx.h"
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#define MAX 10000

float d[MAX][MAX];


int _tmain(int argc, _TCHAR* argv[])
{
    double t=0;
	int defa=50;
	for(int i=0;i<defa;i++){
        clock_t t1=clock();

        for(int j=0;j<MAX;j++){
            for(int k=0;k<MAX;k++){
                //d[j][k]=rand()%100;
				d[j][k]+=21;
            }
        }

        clock_t t2=clock();
        double elapsed=((double) (t2 - t1)) / CLOCKS_PER_SEC;
        printf("elapsed time taken=%f\n",elapsed);
		t+=elapsed;
    }
	t=t/defa;
	printf("average elapsed time taken=%f\n",t);
	getchar();
	return 0;
}
*/

//*****************************************************************************
//    Visual Studio C# CODE random 1000x1000 takes 0.128 sec
//*****************************************************************************
/*
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace ConsoleApplication3
{
    class Program
    {
        static int max = 10000;
        static float[,] d = new float[max, max];
        static int defa = 50;

        static void Main(string[] args)
        {

            double t = 0;
            for (int i = 0; i < defa; i++)
            {
                t += generateRandomMatrix();
            }
            t = t / defa;
            Console.WriteLine("average elapsed time=" + t / 1000);
            Console.ReadLine();

        }

        private static long generateRandomMatrix()
        {
            Random rnd = new Random();
            var stopwatch = new Stopwatch();
            stopwatch.Start();
            for (int i = 0; i < max; i++)
            {
                for (int j = 0; j < max; j++)
                {
                    //d[i, j] = rnd.Next(1, 100);
                    d[i,j]+= 21;
                }
            }
            stopwatch.Stop();
            long elapsed_time = stopwatch.ElapsedMilliseconds;
            Console.WriteLine("elapsed time=" + elapsed_time / 1000.0);
            return elapsed_time;
        }
    }
}
*/
    
//*****************************************************************************
//    Open Cezeri Library DSL CODE random 1000x1000 takes 0.15 sec
//*****************************************************************************
/*
        for (int i = 0; i < 10; i++) {
            CMatrix.getInstance()
                    .tic()
                    .rand(max, max, 0, 100)
                    .toc()
                    ;

        }
*/
    
//*****************************************************************************
//    PYTHON CODE  random 1000x1000 takes 0.154 sec
//*****************************************************************************
/*
import timeit
import numpy as np

a=1
b=1
print("a=",a," b=",b)
a,b=b,a
print("a=",a," b=",b)

for t in range(10):
   a,b=b+a,a
   print("a=",a);

n=10000
t=0
defa=50
y=np.zeros((n,n))
for x in range(defa):
    start = timeit.default_timer()    
    y=y+21
    #y=np.random.randn(n,n)
    stop = timeit.default_timer()
    t+=(stop - start)
    print('Time: ', stop - start)  

print('avg time=',t/defa," sn")

*/
}
