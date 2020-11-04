/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitwiseradixsort;

import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Sam
 */
public class BitwiseRadixSort {

    /**
     * @param args the command line arguments
     */
    public static void bitwiseRadixSort(char[] c) {

        ArrayDeque<Character>[] radixQueues
                = (ArrayDeque<Character>[]) (new ArrayDeque[2]);
        radixQueues[0] = new ArrayDeque<>();
        radixQueues[1] = new ArrayDeque<>();
        int bitmask = 1;
      
        //convert to bits
        for (int bit = 0; bit < 16; bit++) {
            for (int i = 0; i < c.length; i++) {

                if ((bitmask & c[i]) == 0) {
                    radixQueues[0].addLast(c[i]);
                } else if ((bitmask & c[i]) != 0) {
                    radixQueues[1].addLast(c[i]);
                }

            }
            int nextIndex = 0;
            for (int k = 0; k < 2; k++) {
                while (!radixQueues[k].isEmpty()) {
                    c[nextIndex++] = radixQueues[k].removeFirst();
                }
            }
            bitmask = bitmask << 1;
        }

    }

    public static void main(String[] args) {
        Random rand = new Random();
        int num = 10;
        
        int unicode[] = new int[num];
        char c[] = new char[num];
        for (int i = 0; i < num; i++) {
            unicode[i] = rand.nextInt(65536);
           // unicode[i] = i+100;
            c[i] = (char) (unicode[i]);
        }
        System.out.println(c);
        System.out.println(Arrays.toString(unicode));
        bitwiseRadixSort(c);

        for (int i = 0; i < num; i++) {
            unicode[i] = c[i];

        }
        System.out.println(c);
        System.out.println(Arrays.toString(unicode));
    }
}
