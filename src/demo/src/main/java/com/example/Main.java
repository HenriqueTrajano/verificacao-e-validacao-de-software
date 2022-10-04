package com.example;

public class Main {
    public static void main(String[] args) {

        CentroDistribuicao test = new CentroDistribuicao(400, 7500, 1000, 1000);

        test.recebeAlcool(-1);

        test.encomendaCombustivel(2000, CentroDistribuicao.TIPOPOSTO.COMUM);
        test.encomendaCombustivel(2000, CentroDistribuicao.TIPOPOSTO.COMUM);
        test.encomendaCombustivel(2000, CentroDistribuicao.TIPOPOSTO.COMUM);

    }
}
