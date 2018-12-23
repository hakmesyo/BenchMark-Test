
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_C {
//*****************************************************************************
//    GNU C CODE  1000x1000 random takes 47.18 ms, add scalar takes 2.81 ms , math sin takes 2.35 ms
//*****************************************************************************
    
   
/*
#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#define MAX 1000

float d[MAX][MAX];
const int defa=100;

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
		//mean+=testRandomPerformance();
		mean+=testMathFunctionPerformance();
	}
	mean=mean/defa*1000;
	printf("\naverage elapsed time taken=%f ms\n",mean);
}

double testMathFunctionPerformance(){
        double t=0;
	clock_t t1=clock();
	for (int i = 0; i < MAX; i++)
	{
	    for(int j=0;j<MAX;j++)
            {
                d[i][j]=sin(i%360*3.14/180);
            }
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

*/    
}
