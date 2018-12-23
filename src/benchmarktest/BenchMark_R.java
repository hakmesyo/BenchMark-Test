
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_R {

//*****************************************************************************
//    add scalar takes 15 ms, fill random numbers takes 180 ms    
//*****************************************************************************
/*
library(tictoc)

fill.matrix = function(expr, nrow=1, ncol=1) {
    matrix(eval(expr, envir=list(x=nrow*ncol)), nrow=nrow, ncol=ncol)
}

n=1000
m <- matrix(0,n,n)
tic("overall")
for (i in 1:100) {
  tic("elapsed time") 
  #m=m+21;
  #m <- runif(n*n,0,100)
  m <- fill.matrix(rexp(n*n, rate=.1), nrow=n, ncol=n)
  toc()
}
toc()   
*/
    
}
