package homework;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by NoClay on 2016/11/16.
 */
public class FindPrime {

    private static Set<BigDecimal> primeList = new HashSet<>();
    public static void getPrime(BigDecimal m, int n){
        getPrimeList(m);
        while (n > 0){
            if (checkIsPrime(m)){
                n --;
                System.out.println("" + m);
            }
            m.add(BigDecimal.ONE);
        }
    }

    private static void getPrimeList(BigDecimal m) {
        BigDecimal i = new BigDecimal(2);
        while (i.compareTo(m) < 0){
            if (checkIsPrime(m)){
                primeList.add(i);
            }
            i.add(BigDecimal.ONE);
        }
    }

    private static boolean checkIsPrime(BigDecimal m) {
        Iterator<BigDecimal> it = primeList.iterator();
        while (it.hasNext()){
            if (m.remainder(it.next()).compareTo(BigDecimal.ZERO) == 0){
                return false;
            }
        }
        primeList.add(m);
        return true;
    }

    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        BigDecimal m = scanner.nextBigDecimal();
        int n = scanner.nextInt();
        FindPrime.getPrime(m, n);
    }
}
