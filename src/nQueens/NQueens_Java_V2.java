/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nQueens;

import cezeri.factory.FactoryUtils;

/**
 *
 * @author elcezerilab
 */
public class NQueens_Java_V2 {

    private static int[] b = new int[13];
    private static int s = 0;

    static boolean unsafe(int y) {
        int x = b[y];
        for (int i = 1; i <= y; i++) {
            int t = b[y - i];
            if (t == x
                    || t == x - i
                    || t == x + i) {
                return true;
            }
        }

        return false;
    }

    public static void putboard() {
        System.out.println("\n\nSolution " + (++s));
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                System.out.print((b[y] == x) ? "|Q" : "|_");
            }
            System.out.println("|");
        }
    }

    public static void main(String[] args) {
        long t = FactoryUtils.tic();
        int y = 0;
        b[0] = -1;
        while (y >= 0) {
            do {
                b[y]++;
            } while ((b[y] < b.length) && unsafe(y));
            if (b[y] < b.length) {
                if (y < b.length - 1) {
                    b[++y] = -1;
                } else {
                    s++;
                    //putboard();
                }
            } else {
                y--;
            }
        }
        t=FactoryUtils.toc(t);
        System.out.println("\n\nSolution " + s);
    }

}
