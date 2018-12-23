import timeit
import numpy as np

n=1000
t=0
defa=100
y=np.zeros((n,n))


for x in range(defa):
    start = timeit.default_timer()    
    #y=y+21
    y=np.random.randn(n,n)
    
    #very slow so we ignore this part
	#for i in range(n):
    #    for j in range(n):
    #        y[i][j]==np.random.randint(1,101)
    
    stop = timeit.default_timer()
    t+=(stop - start)
    print('Time: ', stop - start)  

print('avg time=',t/defa*1000," ms")
