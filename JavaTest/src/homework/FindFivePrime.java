package homework;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by NoClay on 2016/11/3.
 */
public abstract class FindFivePrime{

    int []list = new int[2000];
    int length;

    public FindFivePrime() {
        int flag = 0;
        for (int i = 2; i < 10000; i++) {
            BigInteger big = new BigInteger("" + i);
            if(big.isProbablePrime(100)){
                list[flag] = big.intValue();
                flag ++;
            }
        }
        length = flag;
    }

    public static void main(String[] args){

    }

    public boolean isPrime(BigDecimal n){
        boolean flag = false;
        for (int i = 0; i < this.length; i++) {
            BigDecimal one = new BigDecimal(list[i]);

        }
        if (n == new BigDecimal("2"))
            return true;
        BigDecimal i = new BigDecimal("2");
        int check = i.compareTo(n);
        for ( ;check != 1; i = i.add(BigDecimal.ONE)){
            if (n.remainder(i) == new BigDecimal("0"))
                return false;
        }
        return true;

    }
}