
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_Python {
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
}
