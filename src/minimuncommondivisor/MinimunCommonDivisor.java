/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimuncommondivisor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author wilsoncastiblanco
 */
public class MinimunCommonDivisor {

    static HashMap<Integer, Integer> exponentsA = new HashMap<>();
    static HashMap<Integer, Integer> exponentsB = new HashMap<>();
    static HashMap<Integer, Integer> result = new HashMap<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        returnResult();
    }

    private static int returnResult() {
        int a = 48;
        int b = 60;

        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        int number = MCD(a, b);
        System.out.println("MCD " + number);
        return number;
    }

    private static int MCD(int a, int b) {
        int resto;
        int numDiv1 = a;
        int numDiv2 = b;

        do {
            resto = numDiv1 % numDiv2;
            numDiv1 = numDiv2;
            if (resto != 0) {
                numDiv2 = resto;
            }
        } while (resto != 0);

        return numDiv2;
    }

}
