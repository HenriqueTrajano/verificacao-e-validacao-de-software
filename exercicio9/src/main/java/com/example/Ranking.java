package com.example;

import java.util.ArrayList;
import java.util.Collections;

public class Ranking {

    ArrayList<Record> rankingzada;

    public Ranking() {
        rankingzada = new ArrayList<>();
    }

    // Insere novo registro na lista mantendo a ordenação
    // Retorna true se a inserção foi possível
    public boolean add(Record record) {

        boolean auxResult = false;

        if (rankingzada.isEmpty()) {
            rankingzada.add(record);
            auxResult = true;
        } else {
            this.rankingzada.add(record);
            Collections.sort(this.rankingzada, new RecordComparator());

            if (this.rankingzada.size() > 10) {
                this.rankingzada.remove(10);
            }

            if (this.rankingzada.contains(record)) {
                auxResult = true;
            }
        }

        return auxResult;
    }

    // Retorna à quantidade de registros armazenados
    public int numRecords() {
        return this.rankingzada.size();
    }

    // Retorna o i-ésimo registro armazenado ou
    // null se o valor de i for inválido
    public Record getScore(int index) {
        try {
            return this.rankingzada.get(index);
        } catch (IndexOutOfBoundsException e1) {
            return null;
        }
    }

    // Retorna o pior score armazenado
    // Retorna null se a lista estiver vazia
    public Record worstScore() {
        if (!this.rankingzada.isEmpty())
            return this.rankingzada.get(this.rankingzada.size() - 1);

        return null;
    }

    // Retorna o melhor score armazenado
    // Retorna null se a lista estiver vazia
    public Record bestScore() {
        if (!this.rankingzada.isEmpty())
            return this.rankingzada.get(0);

        return null;
    }

    public void forTheTest(int playerAmount) {
        if (playerAmount > 0 || playerAmount <= 10) {
            for (int i = 0; i < playerAmount; i++) {
                this.rankingzada.add(new Record("name" + i, i + 10));
            }
        }
    }
}
