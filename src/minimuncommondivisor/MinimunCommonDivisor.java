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
        int a = 48;
        int b = 60;
        getMcd(a, exponentsA);
        getMcd(b, exponentsB);

        System.out.println("exponentsA " + exponentsA.toString());
        System.out.println("exponentsB " + exponentsB.toString());

        Iterator it = exponentsA.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            validateExponents(pair);
            it.remove();
        }

        int minimunCommonDivisor = 1;
        Iterator iteratorResult = result.entrySet().iterator();
        while (iteratorResult.hasNext()) {
            Map.Entry pair = (Map.Entry) iteratorResult.next();
            minimunCommonDivisor *= (Math.pow((Integer) pair.getKey(), (Integer) pair.getValue()));
            iteratorResult.remove();
        }
    }

    public static void getMcd(int number, HashMap<Integer, Integer> exponents) {
        int divisionResult = number;
        while (divisionResult > 1) {
            int primeFactor = getPrimeFactor(divisionResult);
            divisionResult = divisionResult / primeFactor;
            exponents.merge(primeFactor, 1, Integer::sum);
        }
    }

    public static int getPrimeFactor(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int primeFactor = 0;
        for (int i = 2; i <= n; i++) {
            int counter = 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    counter++;
                }
            }
            if (counter == 0) {
                if (n % i == 0) {
                    primeFactor = i;
                    break;
                }
            }
        }

        return primeFactor;
    }

    public static void validateExponents(Map.Entry pair) {
        if (exponentsB.containsKey(pair.getKey())) {
            if (exponentsB.get(pair.getKey()) < exponentsA.get(pair.getKey())) {
                result.put((Integer) pair.getKey(), exponentsB.get(pair.getKey()));
            } else {
                result.put((Integer) pair.getKey(), exponentsA.get(pair.getKey()));
            }
        }
    }

}
