package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciaLugares barca = new GerenciaLugares();
        Scanner in = new Scanner(System.in);


        System.out.println("Digite o codigo do seu assento para assim entrar na barca: ");
        String assento = in.next();

        int resultado = barca.verificaLugar(assento);

        if (resultado == 0) {
            System.out.println("Amigo voce colocou um identificador invalido");
        } else if (resultado == 1) {
            System.out.println("Amigo esse assento ja esta ocupado, alguem passou a perna em vc!");
        } else if (resultado == 2) {
            System.out.println("O assento que voce comprou nao respeita a regra da distribuicao de peso");
        } else {
            System.out.println("Boa viagem manito!");
        }
    }
}
