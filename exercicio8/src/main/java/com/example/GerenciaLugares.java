package com.example;

public class GerenciaLugares {

    private boolean assentosBarca[][] = new boolean[20][60];
    private int quantAssentosOcupados; 


    public GerenciaLugares() {
        quantAssentosOcupados = 0;
    }


    // Verificar esse metodo aqui
    public int verificaLugar(String assento) {
        //Parte do Identificador Invalido
        if (assento.length() != 6 || assento.charAt(0) != 'F' || assento.charAt(3) != 'A') {
            return 0;
        }

        int filaAssento = Integer.parseInt(assento.substring(1, 3));
        int numeroAssento = Integer.parseInt(assento.substring(4));

        if (filaAssento > 60 || filaAssento < 1 || numeroAssento > 20 || numeroAssento < 1) {
            return 0;
        }

        //Parte do assento ocupado
        if (assentosBarca[numeroAssento-1][filaAssento-1]) {
            return 1;
        }

        //Parte para verificar a distribuicao de peso
        quantAssentosOcupados++;
        if ((quantAssentosOcupados <= 100 && filaAssento > 20) || (quantAssentosOcupados >= 101 && quantAssentosOcupados <= 200 && filaAssento < 40)) {
            quantAssentosOcupados--;
            return 2;
        }

        //Parte que confirma o assento
        assentosBarca[numeroAssento-1][filaAssento-1] = true;

        return 3;
    }

    public void quantAssentOcupados(int quantidadeAssentos) {
        if (quantidadeAssentos > 0 || quantidadeAssentos <= 1200) {
            int auxQuantidade = 0;

            mainloop:
            for (int i = 0; i < 60; i++) {
                for (int j = 0; j < 20; j++) {
                    if (quantidadeAssentos == auxQuantidade) {
                        break mainloop;
                    }
                    assentosBarca[j][i] = true;
                    auxQuantidade++;
                    quantAssentosOcupados++;
                }
            }
        }
    }

}
