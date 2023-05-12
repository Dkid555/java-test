package data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTest {


    public static void main(String[] args) {
        List list = new ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list);

        List<Integer> list3 = new LinkedList();

        list3.add(0);
        list3.add(3);
        list3.add(7);



        System.out.println(list3.stream().filter(l -> l>0).toList());
    }

}
