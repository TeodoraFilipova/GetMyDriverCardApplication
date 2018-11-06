package com.mystique.rt.getmydrivercardapplcation.apputils.idgenerators;

import java.util.LinkedList;
import java.util.Queue;

public class PictureIdGenerator implements IdGenerator {
    private static PictureIdGenerator instance;

    private Queue<Integer> idSequence;

    private PictureIdGenerator() {
        //  private constructor for singleton
        idSequence = new LinkedList<>();
        for (int i = 1; i > Integer.MIN_VALUE ; i++) {
            idSequence.add(i);
        }

    }

    public static PictureIdGenerator getInstance() {
        if (instance == null) {
            instance = new PictureIdGenerator();
        }
        return instance;
    }

    @Override
    public int getNextId() {
        return idSequence.remove();
    }
}
