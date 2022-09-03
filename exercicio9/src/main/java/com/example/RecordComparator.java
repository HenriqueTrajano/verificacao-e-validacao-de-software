package com.example;

import java.util.Comparator;

public class RecordComparator implements Comparator<Record>{
    
    public int compare(Record player1, Record player2)
    {
        if (player1.getScore() == player2.getScore())
            return 0;
        else if (player1.getScore() > player2.getScore())
            return -1;
        else
            return 1;
    }
}
