package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ranking valorantChampions = new Ranking();
        Scanner in = new Scanner(System.in);
        int index = 0;
        boolean loopApp = true;

        do {
            System.out.println("\n\n]==================================================================>");
            System.out.println(" Escolha um indice para realizar alguma funcionalidade: " +
                    "\n 1 - Adicionar um jogador para o ranking" +
                    "\n 2 - Quantidade de jogadores no ranking " +
                    "\n 3 - Exibir o jogador de uma certa colocacao " +
                    "\n 4 - Exibir o jogador TOP 1 " +
                    "\n 5 - Exibir o jogador TOP 10 " +
                    "\n 6 - Sair do programa");
            System.out.println("]==================================================================>\n");

            boolean subLoop2 = false;

            do {
                System.out.println("]====================>");
                System.out.print("Digite seu indice: ");
                try {
                    index = in.nextInt();
                    subLoop2 = false;
                } catch (InputMismatchException e1) {
                    System.out.println("Erro: Coloque um numero inteiro.");
                    subLoop2 = true;
                    in.nextLine();
                } catch (Exception e2) {
                    System.out.println("Erro: " + e2);
                    subLoop2 = true;
                    in.nextLine();
                }

                if (index != 1 && index != 2 && index != 3 && index != 4 && index != 5 && index != 6) {
                    if (!subLoop2) {
                        System.out.println("Erro: Selecione um indice valido.");
                        subLoop2 = true;
                        in.nextLine();
                    }
                }
            } while (subLoop2);

            switch (index) {
                case 1 -> {
                    in.nextLine();
                    System.out.print("Digite o nickname do jogador: ");
                    String playerName = in.nextLine();

                    System.out.print("Digite o score desse jogador: ");
                    int playerScore = in.nextInt();

                    boolean result = valorantChampions.add(new Record(playerName, playerScore));

                    System.out.println("--------------------------------------------------------------------------->");
                    if (result) {
                        System.out.println("Parabéns esse jogador está entre os 10 melhores jogadores de Valorant!");
                    } else {
                        System.out.println("Desculpe amigo, mas esse jogador não conseguiu entrar no ranking...");
                    }
                }
                case 2 -> {
                    System.out.println("Quantidade de Jogadores no TOP 10: " + valorantChampions.numRecords());
                }
                case 3 -> {
                    in.nextLine();
                    System.out.print("Digite qual posicao do TOP 10, voce quer descobrir: ");
                    int auxIndex = in.nextInt();

                    Record auxzadaPlayer = valorantChampions.getScore(auxIndex - 1);

                    if (auxzadaPlayer != null) {
                        System.out.println("RESULTADO TOP " + auxIndex + " --> " + auxzadaPlayer.toString());
                    } else {
                        System.out.println("Nao tem ninguem nessa posicao");
                    }
                }
                case 4 -> {
                    if (valorantChampions.numRecords() > 0) {
                        System.out.println("TOP 1: " + valorantChampions.bestScore().toString());
                    } else {
                        System.out.println("Nao tem ninguem no ranking ainda...");
                    }
                }
                case 5 -> {
                    if (valorantChampions.numRecords() > 0) {
                        System.out.println("TOP 10: " + valorantChampions.worstScore().toString());
                    } else {
                        System.out.println("Nao tem ninguem no ranking ainda...");
                    }
                }
                default -> loopApp = false;
            }
        } while (loopApp);

        System.out.println("CABO!");
    }
}
