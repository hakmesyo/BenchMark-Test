
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_C {
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
}
