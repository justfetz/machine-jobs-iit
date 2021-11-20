package com.example.nmachinemjobs;

import java.util.ArrayList;
import java.util.Arrays;

public class Machine {


    private Integer name;
    private ArrayList<int[]> scheduler;
    public int[][] schedule;

    public Machine(Integer name, ArrayList<int[]> scheduler, int[][] schedule2) {

        this.name = name;
        this.scheduler = scheduler;
        this.schedule = schedule2;


    }

    @Override
    public String toString() {
        return "Machine {" +

                "  name=" + name +
                ", schedule=" + Arrays.deepToString(schedule) +
                '}';
    }



    public void setSchedule(int location, int[] x) {
        //if(checkAvailability())
        schedule[location] = x;
    }

    public Integer getName() {
        return name;
    }


}
