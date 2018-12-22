#include "stdafx.h"
#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <windows.h>
#include <iostream>
using namespace std;

#define MAX 10000
long long d[MAX][MAX];
const unsigned long long n=(unsigned long long)1e7;
const int defa=100;
double PCFreq = 0.0;
__int64 CounterStart = 0;

void StartCounter()
{
    LARGE_INTEGER li;
    if(!QueryPerformanceFrequency(&li))
    cout << "QueryPerformanceFrequency failed!\n";

    PCFreq = double(li.QuadPart)/1000.0;

    QueryPerformanceCounter(&li);
    CounterStart = li.QuadPart;
}
double GetCounter()
{
    LARGE_INTEGER li;
    QueryPerformanceCounter(&li);
    return double(li.QuadPart-CounterStart)/PCFreq;
}
void forforfor();
void for_forfor();
double testRandomFunction();
double testMathFunction();
void test();

int _tmain(int argc, _TCHAR* argv[])
{
	test();
	getchar();
	return 0;
}

void test(){
	printf("Benchmark is starting\n");
	double mean=0;
	for (int i = 0; i < defa; i++)
	{
		//mean+=testRandomFunction();
		mean+=testMathFunction();
	}
	mean=mean/defa;
	printf("\nAverage elapsed time taken=%f second\n",mean);
}

double testMathFunction(){
	unsigned long long t=0;
	StartCounter();
	for (unsigned long long i = 0; i < n; i++)
	{
		t+=(unsigned long long)sin(i%360*3.14/180);
	}
	double elapsed=GetCounter()/1000.0;
    printf("elapsed time taken=%f second\n",elapsed);
	return elapsed;
}


double testRandomFunction(){
	unsigned long long t=0;
	StartCounter();
	//clock_t t1=clock();
	for (unsigned long long i = 0; i < n; i++)
	{
		t+=rand()%101;
	}
	double elapsed=GetCounter()/1000.0;
    //clock_t t2=clock();
    //double elapsed=((double) (t2 - t1)) / CLOCKS_PER_SEC;
    printf("elapsed time taken=%f\n",elapsed);
	return elapsed;
}

void forforfor(){
	double t=0;
	int defa=100;
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

void call_forfor(){
        for(int j=0;j<MAX;j++){
            for(int k=0;k<MAX;k++){
				d[j][k]+=21;
            }
        }
}

void for_forfor(){
	double t=0;
	int defa=50;
	for(int i=0;i<defa;i++){
        clock_t t1=clock();
		call_forfor();
        clock_t t2=clock();
        double elapsed=((double) (t2 - t1)) / CLOCKS_PER_SEC;
        printf("elapsed time taken=%f\n",elapsed);
		t+=elapsed;
    }
	t=t/defa;
	printf("average elapsed time taken=%f\n",t);
}

