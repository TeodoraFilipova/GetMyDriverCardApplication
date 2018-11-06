package com.mystique.rt.getmydrivercardapplcation.apputils.idgenerators;

import java.util.LinkedList;
import java.util.Queue;

public class DriverIdGenerator implements IdGenerator {
    private static DriverIdGenerator instance;

    private Queue<Integer> idSequence;

    private DriverIdGenerator() {
        //  private constructor for singleton
        idSequence = new LinkedList<>();
        for (int i = 1; i > Integer.MIN_VALUE ; i++) {
            idSequence.add(i);
        }

    }

    public static DriverIdGenerator getInstance() {
        if (instance == null) {
            instance = new DriverIdGenerator();
        }
        return instance;
    }

    @Override
    public int getNextId() {
        return idSequence.remove();
    }
}
