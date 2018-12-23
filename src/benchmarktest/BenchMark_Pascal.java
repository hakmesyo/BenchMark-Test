
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_Pascal {
    
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
}
