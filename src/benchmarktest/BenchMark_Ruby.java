
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_Ruby {
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
}
