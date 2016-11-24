package homework;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by NoClay on 2016/11/3.
 */
public class FindFiveNum {

//    public static boolean isTheNum(BigDecimal n){
//        BigDecimal one =  new BigDecimal(1);
//        BigDecimal zero = new BigDecimal(0);
//        System.out.println(zero.intValue());
//        while(one.compareTo(n) < 0){
//            if(n.remainder(one) == zero){
//                return true;
//            }
//        }
//        return false;
//    }

    public static void main(String []args){
        BigDecimal flag = new BigDecimal(Long.MAX_VALUE);
        BigDecimal flag2 = flag.divide(new BigDecimal(5));
        flag2 = flag2.subtract(new BigDecimal(1));
        flag2 = flag2.setScale(0, BigDecimal.ROUND_HALF_UP);
        BigDecimal first, second;
        HashSet<BigDecimal> array = new HashSet<>();
        for (int i = 0;; i++) {
            first = flag2.multiply(new BigDecimal(5));
            second = flag2.multiply(new BigDecimal(6));
            boolean b1 = first.compareTo(flag) > 0;
            boolean b2 = second.compareTo(flag) > 0;
            if(b1 && b2){
                int c = first.compareTo(second);
                if(c > 0){
                    array.add(first);
                    if(array.size() == 5){
                        break;
                    }
                    array.add(second);
                }else if(c == 0){
                    array.add(first);
                }else{
                    array.add(second);
                    if(array.size() == 5){
                        break;
                    }
                    array.add(first);
                }
                if(array.size() == 5){
                    break;
                }
            }else if(b1 && !b2){
                array.add(first);
            }else if(b2 && !b1){
                array.add(second);
            }
            if(array.size() == 5){
                break;
            }
            flag2 = flag2.add(new BigDecimal(1));
        }
        Iterator<BigDecimal> it = array.iterator();
        while (it.hasNext()){
            System.out.println(it.next().toString() + "");
        }

    }
}
