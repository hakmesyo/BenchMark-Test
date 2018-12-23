using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Diagnostics;

namespace BenchMarkTestBigMatrix
{

    class Program
    {
        private static int max = 1000;
        private static float[,] d = new float[max,max];
        private static int defa = 100;
        private static Random rnd=new Random();

        static void Main(string[] args)
        {
            //call_for_for_for();
            //addScalar();
            testMatFunction();
            //addRandomNumber();
            
        }

        private static void addRandomNumber()
        {
            double t = 0;
            for (int i = 0; i < defa; i++)
            {
                t += addupRandom();
            }
            t = t / defa;
            Console.WriteLine("average elapsed time=" + t);
            Console.ReadLine();
        }

        private static double addupRandom()
        {
            var stopwatch = new Stopwatch();
            stopwatch.Start();
            for (int i = 0; i < max; i++)
            {
                for (int j = 0; j < max; j++)
                {
                    d[i, j] = (float)(rnd.NextDouble()*101);
                }

            }
            stopwatch.Stop();
            long elapsed_time = stopwatch.ElapsedMilliseconds;
            Console.WriteLine("elapsed time=" + elapsed_time / 1000.0);
            return elapsed_time;
        }

        private static void addScalar()
        {
            double t = 0;
            for (int i = 0; i < defa; i++)
            {
                t += addupScalar();
            }
            t = t / defa;
            Console.WriteLine("average elapsed time=" + t);
            Console.ReadLine();
        }

        private static long addupScalar()
        {
            var stopwatch = new Stopwatch();
            stopwatch.Start();
            for (int i = 0; i < max; i++)
            {
                for (int j = 0; j < max; j++)
                {
                    d[i, j] += 21; 
                }
                
            }
            stopwatch.Stop();
            long elapsed_time = stopwatch.ElapsedMilliseconds;
            Console.WriteLine("elapsed time=" + elapsed_time / 1000.0);
            return elapsed_time;
        }

        private static void testMatFunction()
        {
            double t = 0;
            for (int i = 0; i < defa; i++)
            {
                t+=testMathSinFunction();
            }
            t = t / defa;
            Console.WriteLine("average elapsed time=" + t);
            Console.ReadLine();
        }

        private static long testMathSinFunction()
        {
            var stopwatch = new Stopwatch();
            stopwatch.Start();

            for (int i = 0; i < max; i++)
            {
                for (int j = 0; j < max; j++)
                {
                    d[i, j] += (float)(Math.Sin(i % 360 * Math.PI / 180));
                }
            }
            stopwatch.Stop();
            long elapsed_time = stopwatch.ElapsedMilliseconds;
            Console.WriteLine("elapsed time=" + elapsed_time / 1000.0);
            return elapsed_time;
        }

        private static void call_for_for_for() {
            double t = 0;
            for (int i = 0; i < defa; i++)
            {
                t += call_for_for();
            }
            t = t / defa;
            Console.WriteLine("average elapsed time=" + t);
            Console.ReadLine();
        }

        private static long call_for_for()
        {
            var stopwatch = new Stopwatch();
            stopwatch.Start();
            for (int i = 0; i < max; i++)
            {
                call_for(i);
            }
            stopwatch.Stop();
            long elapsed_time = stopwatch.ElapsedMilliseconds;
            Console.WriteLine("elapsed time=" + elapsed_time / 1000.0);
            return elapsed_time;
        }

        private static void call_for(int i)
        {
            unsafe
            {
                for (int j = 0; j < max; j++)
                {
                    d[i, j] += 21;
                }
            }
        }

    }
}
