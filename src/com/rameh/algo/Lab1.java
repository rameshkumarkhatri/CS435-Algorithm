package com.rameh.algo;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Random;
import java.util.stream.Collectors;

public class Lab1 {

    int max = 100000, min = 10;
    int size1 = 1000, size2 = 2000, size3 = 3000, size4 = 4000;
    ArrayList<Integer> list1, list2, list3, list4;

    // Find the largest distance between any two even integers in an integer array.
    public static void main(String[] arg) {
        Lab1 lab1 = new Lab1();
        lab1.createList();
        System.out.println("ALGO 1 ");
        lab1.algo1(lab1.list1);
        lab1.algo1(lab1.list2);
        lab1.algo1(lab1.list3);
        lab1.algo1(lab1.list4);
        System.out.println("ALGO 2");
        lab1.algo2(lab1.list1);
        lab1.algo2(lab1.list2);
        lab1.algo2(lab1.list3);
        lab1.algo2(lab1.list4);

        System.out.println("ALGO 3");
        lab1.algo3(lab1.list1);
        lab1.algo3(lab1.list2);
        lab1.algo3(lab1.list3);
        lab1.algo3(lab1.list4);


        System.out.println("ALGO 4");
        lab1.algo4(lab1.list1);
        lab1.algo4(lab1.list2);
        lab1.algo4(lab1.list3);
        lab1.algo4(lab1.list4);

    }

    /**
     * Use Streams to find the max and min. Compute max – min.
     * @param list
     */
    private void algo4(ArrayList<Integer> list) {
        long time = System.currentTimeMillis();
        IntSummaryStatistics intSummaryStatistics = list.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Min = "+intSummaryStatistics.getMin()+"; Max =  " + intSummaryStatistics.getMax() + "; Time to calculate = "+ (System.currentTimeMillis() - time)
                + "; List Size = " +list.size());
    }
    /**
     * Use one loop. Find max and min of even integers. Compute max – min.
     * @param list
     */
    private void algo3(ArrayList<Integer> list) {

        int min = list.get(0), max = list.get(0);
        long time = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0){
                if(list.get(i) > max) max = list.get(i);
                else if(list.get(i) < min) min = list.get(i);
            }
        }
        System.out.println("Min = "+min+"; Max =  " + max + "; Time to calculate = "+ (System.currentTimeMillis() - time)
                + "; List Size = " +list.size());
    }

    /**
     * Use a nested loop to solve the problem without creating an extra array.
     * @param list
     */
    private void algo2(ArrayList<Integer> list) {

        int distance = 0;
        long time = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            if (i % 2 == 0) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (j % 2 == 0) {
                        int diff = Math.abs(list.get(i) - list.get(j));
                        if (diff > distance)
                            distance = diff;
                    }
                }
            }
        }
        System.out.println("Max distance =  " + distance + "; Time to calculate = "+ (System.currentTimeMillis() - time)
                + "; List Size = " +list.size() );
    }
    /**
     * Create a new array consisting of even numbers only.
     * Then use nested loops to solve the problem using the newly created array of even numbers only.
     */
    private void algo1(ArrayList<Integer> list) {

        int distance = 0;
        long time = System.currentTimeMillis();
        ArrayList<Integer> listEven = new ArrayList<>();
        for (int i : list)
            if (i % 2 == 0) listEven.add(i);

        for (int i = 0; i < listEven.size(); i++) {
            for (int j = i + 1; j < listEven.size(); j++) {
                int diff = Math.abs(listEven.get(i) - listEven.get(j));
                if (diff > distance)
                    distance = diff;
            }
        }
        System.out.println("Max distance =  " + distance + "; Time to calculate = "+ (System.currentTimeMillis() - time)
                + "; List Size = " +list.size());


    }

    private void createList() {

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list4 = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < size1; i++)
            list1.add(r.nextInt());

        for (int i = 0; i < size2; i++)
            list2.add(r.nextInt());

        for (int i = 0; i < size3; i++)
            list3.add(r.nextInt());

        for (int i = 0; i < size4; i++)
            list4.add(r.nextInt());

    }
}
