package benchmarktest;

import cezeri.utils.MersenneTwister;
import java.security.SecureRandom;
import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;


public class BenchMarkTest {
    static int max = 5000;
    static int defa = 20;
    
    static float[][] sd = new float[max][max];

    public static void main(String[] args) {
        nativeJavaTest();
    }

//*************************************************************************************************************
//    JAVA CODE   1000x1000 add scalar takes 1.5 ms, math random takes 32 ms, Splittable random takes 15 ms
//*************************************************************************************************************
    private static void nativeJavaTest() {
        double t = 0;
        for (int i = 0; i < defa; i++) {
//            t += testSplittableRandomFunction();
            t += testMathRandomFunction();
//            t += testAddScalar();
//              t +=testMathFunction();
        }
        t = t / defa;
        System.out.println("Average elapsed time = " + t + " ms");
    }
   
    private static double testMathFunction(){
        long t1 = System.nanoTime();
        for (int i = 0; i < max; i++) {
            sinFunction();
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed+ " ms");
        return elapsed;
    }
    
    private static double testAddScalar() {
        long t1 = System.nanoTime();
        int nr = max;
        int nc = max;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                sd[i][j]+=21;
            }
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed+ " ms");
        return elapsed;
    }
    
    private static double testMathRandomFunction() {
        long t1 = System.nanoTime();
        int nr = max;
        int nc = max;
        Random rnd=new Random();
//        Random rnd=new MersenneTwister();
//        Random rnd=new SecureRandom();
//        Random rnd=ThreadLocalRandom.current();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
//                sd[i][j] = (float)(Math.random() * 101);
                sd[i][j] = rnd.nextFloat()*101f;
            }
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed+ " ms");
        return elapsed;
    }
    
    
    private static double testSplittableRandomFunction() {
        long t1 = System.nanoTime();
        int nr = max;
        int nc = max;
        SplittableRandom rnd = new SplittableRandom();
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                sd[i][j] = rnd.nextInt(0, 100);;
            }
        }
        long t2 = System.nanoTime();
        double elapsed = (t2 - t1) / (1000000.0d);
        System.out.println("elapsed = " + elapsed+ " ms");
        return elapsed;
    }



//*****************************************************************************
//    PYTHON CODE  add scalar 1000x1000 takes 9.45 ms, random takes 154 ms
//*****************************************************************************
/*
import timeit
import numpy as np

n=1000
t=0
defa=100
y=np.zeros((n,n))

for x in range(defa):
    start = timeit.default_timer()    
    y=y+21
    #y=np.random.randn(n,n)
    stop = timeit.default_timer()
    t+=(stop - start)
    print('Time: ', stop - start)  

print('avg time=',t/defa*1000," ms")

*/
    
    
//*****************************************************************************
//    RUBY CODE  1000x1000 random takes 820 ms
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
//    MATLAB CODE  1000x1000 random takes 45 ms
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
//    GNU C CODE  1000x1000 add scalar takes 2.8 ms, random takes 45 ms
//*****************************************************************************
/*
    
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 1000

float d[MAX][MAX];
const int n=1e6;
const int defa=1000;

void test2DPerformance();
void testPerformance();
double testRandomPerformance();
double testMathFunctionPerformance();
double testAddScalarPerformance();

int main()
{
	testPerformance();
	getchar();
	return 0;
}

void testPerformance(){
	double mean=0;
	for (int i = 0; i < defa; i++)
	{
		//mean+=testAddScalarPerformance();
		mean+=testRandomPerformance();
		//mean+=testMathFunctionPerformance();
	}
	mean=mean/defa*1000;
	printf("\naverage elapsed time taken=%f second\n",mean);
}

double testMathFunctionPerformance(){
    double t=0;
	clock_t t1=clock();
	for (int i = 0; i < n; i++)
	{
		t+=sin(i);
	}
	clock_t t2=clock();
	double elapsed=((double) (t2 - t1)) / CLOCKS_PER_SEC;
    printf("elapsed time taken=%f\n",elapsed);
	return elapsed;
}

double testRandomPerformance(){
    double t=0;
	clock_t t1=clock();
	for (int i = 0; i < MAX; i++)
	{
	    for(int j=0;j<MAX;j++)
        {
            d[i][j]=rand()%101;
        }
	}
	clock_t t2=clock();
	double elapsed=((double) (t2 - t1)) / CLOCKS_PER_SEC;
    printf("elapsed time taken=%f\n",elapsed);
	return elapsed;
}

double testAddScalarPerformance(){
    double t=0;
	clock_t t1=clock();
	for (int i = 0; i < MAX; i++)
	{
	    for(int j=0;j<MAX;j++)
        {
            d[i][j]+=21;
        }
	}
	clock_t t2=clock();
	double elapsed=((double) (t2 - t1)) / CLOCKS_PER_SEC;
    printf("elapsed time taken=%f\n",elapsed);
	return elapsed;
}

void test2DPerformance(){
    double t=0;
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
}


    */

//*****************************************************************************
//    Visual Studio C++ CODE  1000x1000 random takes 61 ms
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
//    Visual Studio C# CODE 1000x1000 random takes 128 ms
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
//    Open Cezeri Library DSL CODE  1000x1000 random takes 150 ms
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
    

//******************************************************************************************
//    PASCAL CODE (LAZARUS)  1000x1000 add scalar takes 13.6 ms, random takes 45.64 ms
//******************************************************************************************
/*    
program Project1;
uses crt,Dos,DateUtils, sysutils;

const
  n=1000;
  defa=100;
Type
  TA = Array[0..n,0..n] of Single;
var
  sd : TA;
  i:Integer;
  D1,D2 : TDateTime;
  mean:double;

Function ElapsedTime(ANow,AThen : TDateTime):Int64;
var
  ret:Int64;
begin
     ret:=MilliSecondsBetween(ANow,AThen);
     Writeln('elapsed : ',ret);
     Result:=ret;
end;

procedure PopulateArray;
var
  i,j:Integer;
  t1,t2:TDateTime;
begin
     t1:=Now;
     for i:=0 to n do begin
        for j:=0 to n do begin
            sd[i,j]:=sd[i,j]+21;
            //sd[i,j]:=random(100);
        end;
     end;
     t2:=Now;
     ElapsedTime(t1,t2);
end;


begin
  D1:=Now;
  for i := 0 to defa do
  begin
    PopulateArray;
  end;
  writeln();
  D2:=Now;
  mean:=ElapsedTime(D1,D2)/defa;
  Writeln('average elapsed time ',mean);
  readkey;
end.


*/

    private static void sinFunction() {
        for (int i = 0; i < max; i++) {
            sd[i][i]=(float)Math.sin((i % 360 * Math.PI / 180));
        }
    }

}
