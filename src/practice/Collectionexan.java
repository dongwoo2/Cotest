package practice;

import java.util.ArrayList;
import java.util.Iterator;

public class Collectionexan {

    public static void main(String[] args) {
        ArrayList<Integer> integers1 = new ArrayList<>();
        integers1.add(123);
        integers1.add(213);
        integers1.add(321);
        Iterator<Integer> iterator = integers1.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }

    }


}
