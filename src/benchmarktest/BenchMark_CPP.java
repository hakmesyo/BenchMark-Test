
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_CPP {
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
}
