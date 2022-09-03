package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RankingTest {
    private Ranking valorantChampions;

    @BeforeEach
    void setUp() {
        valorantChampions = new Ranking();
    }


    //Nomes dos testes de acordo com o excel
    
    @Test
    void testaADD1() {
        boolean resultadoVerdadeiro = valorantChampions.add(new Record("Braulio", 50));
        Assertions.assertEquals(true, resultadoVerdadeiro);
    }

    @Test
    void testaADD2() {
        valorantChampions.forTheTest(6);
        boolean resultadoVerdadeiro = valorantChampions.add(new Record("Braulio", 50));
        Assertions.assertEquals(true, resultadoVerdadeiro);
    }

    @Test
    void testaADD3() {
        valorantChampions.forTheTest(10);
        boolean resultadoVerdadeiro = valorantChampions.add(new Record("Braulio", 5));
        Assertions.assertEquals(false, resultadoVerdadeiro);
    }

    @Test
    void testaADD4() {
        valorantChampions.forTheTest(10);
        boolean resultadoVerdadeiro = valorantChampions.add(new Record("Braulio", 10));
        Assertions.assertEquals(false, resultadoVerdadeiro);
    }

    @Test
    void testaADD5() {
        valorantChampions.forTheTest(10);
        boolean resultadoVerdadeiro = valorantChampions.add(new Record("Braulio", 11));
        Assertions.assertEquals(true, resultadoVerdadeiro);
    }

    @Test
    void testaADD6() {
        valorantChampions.forTheTest(10);
        boolean resultadoVerdadeiro = valorantChampions.add(new Record("Braulio", 60));
        Assertions.assertEquals(true, resultadoVerdadeiro);
    }


    @Test
    void testaNumRecordsQR1() {
        int resultadoVerdadeiro = valorantChampions.numRecords();
        Assertions.assertEquals(0, resultadoVerdadeiro);
    }

    @Test
    void testaNumRecordsQR2() {
        valorantChampions.forTheTest(1);
        int resultadoVerdadeiro = valorantChampions.numRecords();
        Assertions.assertEquals(1, resultadoVerdadeiro);
    }

    @Test
    void testaNumRecordsQR3() {
        valorantChampions.forTheTest(6);
        int resultadoVerdadeiro = valorantChampions.numRecords();
        Assertions.assertEquals(6, resultadoVerdadeiro);
    }

    @Test
    void testaWorstScoreQR1() {
        Record resultadoVerdadeiro = valorantChampions.worstScore();
        Assertions.assertEquals(null, resultadoVerdadeiro);
    }

    @Test
    void testaWorstScoreQR2() {
        valorantChampions.forTheTest(1);
        Record resultadoVerdadeiro = valorantChampions.worstScore();
        Assertions.assertEquals(10, resultadoVerdadeiro.getScore());
    }

    @Test
    void testaWorstScoreQR3() {
        valorantChampions.add(new Record("Vraulio", 560));
        valorantChampions.add(new Record("Rammus", 182));
        valorantChampions.add(new Record("Robertinho", 260));
        valorantChampions.add(new Record("Sacy", 1094));
        Record resultadoVerdadeiro = valorantChampions.worstScore();
        Assertions.assertEquals("Rammus", resultadoVerdadeiro.getName());
    }

    @Test
    void testaBestScoreQR1() {
        Record resultadoVerdadeiro = valorantChampions.bestScore();
        Assertions.assertEquals(null, resultadoVerdadeiro);
    }

    @Test
    void testaBestScoreQR2() {
        valorantChampions.forTheTest(1);
        Record resultadoVerdadeiro = valorantChampions.bestScore();
        Assertions.assertEquals(10, resultadoVerdadeiro.getScore());
    }

    @Test
    void testaBestScoreQR3() {
        valorantChampions.add(new Record("Vraulio", 560));
        valorantChampions.add(new Record("Rammus", 182));
        valorantChampions.add(new Record("Robertinho", 260));
        valorantChampions.add(new Record("Sacy", 1094));
        Record resultadoVerdadeiro = valorantChampions.bestScore();
        Assertions.assertEquals("Sacy", resultadoVerdadeiro.getName());
    }

    @Test
    void testaIR1() {
        Record resultadoVerdadeiro = valorantChampions.getScore(41);
        Assertions.assertEquals(null, resultadoVerdadeiro);
    }

    @Test
    void testaIR2() {
        valorantChampions.forTheTest(6);
        Record resultadoVerdadeiro = valorantChampions.getScore(4);
        Assertions.assertEquals(14, resultadoVerdadeiro.getScore());
    }
}
