
package benchmarktest;

/**
 * @author Dr.Musa ATAŞ, cezerilab.com
 */
public class BenchMark_CSharp {
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
}
