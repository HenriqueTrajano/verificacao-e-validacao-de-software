package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CentroDistribuicaoTest {
    private CentroDistribuicao cd;

    @BeforeEach
    void setUp() {
        cd = new CentroDistribuicao(500, 10_000, 1250, 1250);

    }

    @Test
    void defineSituacaoGasolinaNormal() {
        cd.recebeGasolina(50);
        cd.defineSituacao();
        Assertions.assertEquals(CentroDistribuicao.SITUACAO.NORMAL, cd.getSituacao());
    }

    @Test
    void defineSituacaoAlcoolNormal() {
        cd.recebeAlcool(50);
        cd.defineSituacao();
        Assertions.assertEquals(CentroDistribuicao.SITUACAO.NORMAL, cd.getSituacao());
    }

    @Test
    void defineSituacaoAlcoolSobraaviso() {
        cd.encomendaCombustivel(7000, CentroDistribuicao.TIPOPOSTO.COMUM);
        cd.defineSituacao();
        Assertions.assertEquals(CentroDistribuicao.SITUACAO.SOBRAVISO, cd.getSituacao());
    }

    @Test
    void defineSituacaoAlcoolEmergencia() {
        cd.encomendaCombustivel(9000, CentroDistribuicao.TIPOPOSTO.COMUM);
        cd.defineSituacao();
        Assertions.assertEquals(CentroDistribuicao.SITUACAO.EMERGENCIA, cd.getSituacao());
    }

    @Test
    void getSituacao() {
        cd.defineSituacao();
        Assertions.assertEquals(CentroDistribuicao.SITUACAO.NORMAL, cd.getSituacao());
    }

    @Test
    void gettAditivo() {
        cd.encomendaCombustivel(1000, CentroDistribuicao.TIPOPOSTO.COMUM);
        int aditivoAux = cd.gettAditivo();
        cd.recebeAditivo(10);
        Assertions.assertEquals(aditivoAux + 10, cd.gettAditivo());
    }

    @Test
    void gettGasolina() {
        cd.encomendaCombustivel(5000, CentroDistribuicao.TIPOPOSTO.COMUM);
        int gasolinaAux = cd.gettGasolina();
        cd.recebeGasolina(1000);
        Assertions.assertEquals(gasolinaAux + 1000, cd.gettGasolina());

    }

    @Test
    void gettAlcool1() {
        cd.encomendaCombustivel(1000, CentroDistribuicao.TIPOPOSTO.COMUM);
        cd.recebeAlcool(100);
        Assertions.assertEquals(1175, cd.gettAlcool1());
    }

    @Test
    void gettAlcool2() {
        cd.encomendaCombustivel(500, CentroDistribuicao.TIPOPOSTO.COMUM);
        cd.recebeAlcool(100);
        Assertions.assertEquals(1238, cd.gettAlcool2());
    }

    @Test
    void recebeAditivo() {
        cd.encomendaCombustivel(1500, CentroDistribuicao.TIPOPOSTO.COMUM);
        int aditivoAux = cd.gettAditivo();
        cd.recebeAditivo(50);
        Assertions.assertEquals(aditivoAux + 50, cd.gettAditivo());
    }

    @Test
    void recebeGasolina() {
        cd.encomendaCombustivel(1500, CentroDistribuicao.TIPOPOSTO.COMUM);
        int gasolinaAux = cd.gettGasolina();
        cd.recebeGasolina(50);
        Assertions.assertEquals(gasolinaAux + 50, cd.gettGasolina());
    }

    @Test
    void recebeAlcool() {
        cd.encomendaCombustivel(1500, CentroDistribuicao.TIPOPOSTO.COMUM);
        int alcoolAux = cd.gettAlcool1();
        cd.recebeAlcool(50);
        Assertions.assertEquals((alcoolAux * 2) + 50, cd.gettAlcool1() + cd.gettAlcool2());
    }

    @Test
    void encomendaCombustivel() {
        cd.encomendaCombustivel(1500, CentroDistribuicao.TIPOPOSTO.COMUM);
        Assertions.assertEquals(11076, cd.gettGasolina() + cd.gettAlcool1() + cd.gettAlcool2());
    }
}