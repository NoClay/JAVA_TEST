package test05;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by NoClay on 2016/11/10.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList myWeekday = new ArrayList();
        myWeekday.add("Sunday");
        myWeekday.add("Monday");
        myWeekday.add("Wednesday");
        myWeekday.add("Friday");
        System.out.println(myWeekday);
        myWeekday.add(2, "Tuesday");
        myWeekday.set(4, "Thursday");
        myWeekday.remove(0);
        Iterator<String> it = myWeekday.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

}
