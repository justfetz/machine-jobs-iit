package com.example.nmachinemjobs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class MachineJobs {

    //never used the remove method in this way.
    public static int[][] removeElements(int[][] input, int deleteMe) {
        ArrayList<int[]> result = new ArrayList<>();
        for(int i = 0; i < input.length; i++) {
            result.add(input[i]);
        }
        result.remove(deleteMe);
        return result.toArray(input);
    }

    public static boolean checkInterval(ArrayList<int[]> arr) {
        int counter = 0;
        for(int i = 0; i < arr.size(); i ++) {
            if(arr.get(i)[1] !=0) {
                counter =1;
            }
        }
        if(counter != 0) {
            return false;
        }
        return true;
    }

    //check availability and assign schedule.
    public static ArrayList<int[]> checkAvailability(Machine[] machineList, int[][] orderList) {
        int localCounter = 0;

        ArrayList<int[]> x = new ArrayList<>();
        ArrayList<int[]> y = new ArrayList<>();
        int[] arr = new int[2];
        for(int i = 0;i< orderList.length;i++) {
            x.add(orderList[i]);
        }
        for(Machine m : machineList) { //n
            for (int i = 0; i < x.size(); i++) { //n
                if (m.schedule[x.get(i)[0]][0] == 0 && m.schedule[x.get(i)[1]-1][1] == 0) {// && m.schedule[x.get(i)[1]][0] == 0) {// && m.schedule[x.get(i)[1]-1][1] == 0) {
                    for (int j = x.get(i)[0]; j < x.get(i)[1]; j++) {
                        y.add(m.schedule[j]);//setting values
                    }
                        if(checkInterval(y)) { //helper function to check interval schedule
                            for (int j = x.get(i)[0]; j < x.get(i)[1]; j++) {
                                m.setSchedule(j, x.get(i));//setting values

                            }
                            x.remove(i);//remove the element to reduce the list
                        }


                        //log n
                } else {
                    System.out.println("You reached your else statement.");
                    //y.add(x.get(i));

                }
                y.clear();
            }
        }
            System.out.println("--Orders Remaining--");
            for(int i = 0; i < x.size(); i++) {
                System.out.println(Arrays.toString(x.get(i)));
            }

        return x;
    }

    public static void main(String[] args) throws IOException {

        //Shortest Processing Time Optimum
        //Greedy Strategy Just In time

        // take file input
        File fileInput = new File("input.txt");

        //Scanner and input from text file.
        Scanner scan = new Scanner(fileInput);
        int machineCount = scan.nextInt();
        Machine[] machineList = new Machine[machineCount];
        scan.nextLine();
        //create a list of orders as we read in a string.
        ArrayList<String[]> listOfOrders = new ArrayList<>();

        //split each line a the space.
        while (scan.hasNextLine()) {
            listOfOrders.add(scan.nextLine().split(" "));
        }
        scan.close();

        int max = 0;
        //create a new 2d array list to hold our order.
        int[][] listToPass = new int[listOfOrders.size()][2];
        //add the orders to a list to pass to our function.
        for(int j = 0; j < listOfOrders.size(); j++) {
            listToPass[j][0] =  Integer.parseInt(listOfOrders.get(j)[0]);
            listToPass[j][1] =  Integer.parseInt(listOfOrders.get(j)[1]); //-Integer.parseInt(listOfOrders.get(j)[0]);
            if(Integer.parseInt(listOfOrders.get(j)[1]) > max) {
                max = Integer.parseInt(listOfOrders.get(j)[1]);
            }
        }
        //Main Menu
        System.out.println("----------");
        System.out.println("Thanks for using our greedy scheduler.");
        System.out.println("Max duration hour is " + max + ", Array Created.");
        //Instantiate the Machine Object for the number of machines being used.
        for(int i = 0; i < machineList.length; i ++) {
            machineList[i] = new Machine(i, new ArrayList<>(), new int[max][2]);
        }
        //bum function
        ArrayList<int[]> trialAndError = new ArrayList<>();
        for(int i = 0; i < listToPass.length; i++) {
            trialAndError.add(listToPass[i]);
        }
        //sort list by end time.
        Arrays.sort(listToPass, Comparator.comparingDouble(o -> (o[1]-o[0])));
        Arrays.sort(listToPass, Comparator.comparingDouble(o -> (o[1])));
        //Summary data
        System.out.println("     ");
        System.out.println("--Integer Array Of Jobs--");
        System.out.println("Order List has to be processed.");
        for(int l = 0; l < listToPass.length; l++) {
            System.out.print("Duration = ");
            System.out.print(listToPass[l][1]-listToPass[l][0]);
            System.out.print("  ");
            System.out.println(Arrays.toString(listToPass[l]));
        }
        int counter = 0;

        System.out.println("     ");
        System.out.println("--Machine list--");

        for(int k=0;k<machineCount;k++) {
         System.out.println("Machine: " + k);
        }

        //machine count variable
        System.out.println(" ");
        System.out.println("--- Machine Count " + machineCount + "---");



        //function to assign schedule called
        checkAvailability(machineList, listToPass);



        //print the schedules.
        for(int j = 0; j < machineList.length;j++) {
            System.out.println(machineList[j].toString());
        }



    }
}
