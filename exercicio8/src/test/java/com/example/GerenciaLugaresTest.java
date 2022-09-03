package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GerenciaLugaresTest {
    
    private GerenciaLugares barca;

    @BeforeEach
    void setUp() {
        barca = new GerenciaLugares();
    }

    //Testes de particoes
    @ParameterizedTest
    @CsvSource({
            "F04A12,23",
            "F03A02,103",
            "F41A02,223",
    })
    void testaAssentoOcupado(String assento, int quantidadePessoas) {

        barca.quantAssentOcupados(quantidadePessoas);
        barca.verificaLugar(assento);

        int respostaVerdadeira = barca.verificaLugar(assento);
        Assertions.assertEquals(1, respostaVerdadeira);
    }

    @ParameterizedTest
    @CsvSource({
            "FF12A21",
            "F60A22",
            "F66G33",
    })
    void testaAssentoInvalido(String assento) {

        int respostaVerdadeira = barca.verificaLugar(assento);
        Assertions.assertEquals(0, respostaVerdadeira);
    }


    @Test
    void testaAssentoInvalidoDistribuicaoPeso1() {
        String assento = "F22A01";
        barca.quantAssentOcupados(17);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaAssentoInvalidoDistribuicaoPeso2() {
        String assento = "F45A04";
        barca.quantAssentOcupados(12);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaAssentoInvalidoDistribuicaoPeso3() {
        String assento = "F12A09";
        barca.quantAssentOcupados(130);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaAssentoInvalidoDistribuicaoPeso4() {
        String assento = "F32A01";
        barca.quantAssentOcupados(120);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaAssentoValido1() {
        String assento = "F11A08";
        barca.quantAssentOcupados(23);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }

    @Test
    void testaAssentoValido2() {
        String assento = "F49A06";
        barca.quantAssentOcupados(178);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }

    @Test
    void testaAssentoValido3() {
        String assento = "F19A05";
        barca.quantAssentOcupados(321);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }

    @Test
    void testaAssentoValido4() {
        String assento = "F37A12";
        barca.quantAssentOcupados(519);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }
    
    @Test
    void testaAssentoValido5() {
        String assento = "F55A10";
        barca.quantAssentOcupados(321);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }



    //Testes para o Valor Limite
    //Os nomes dos limites estao de acordo com o execel passado
    @Test
    void testaLIMITQP1_1() {
        String assento = "F14A15";
        barca.quantAssentOcupados(99);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }

    @Test
    void testaLIMITQP1_2() {
        String assento = "F14A15";
        barca.quantAssentOcupados(100);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaLIMITQP2_1() {
        String assento = "F34A20";
        barca.quantAssentOcupados(199);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaLIMITQP2_2() {
        String assento = "F34A20";
        barca.quantAssentOcupados(200);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }

    @Test
    void testaLIMITASSENT1_1() {
        String assento = "F20A14";
        barca.quantAssentOcupados(87);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }

    @Test
    void testaLIMITASSENT1_2() {
        String assento = "F21A14";
        barca.quantAssentOcupados(87);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaLIMITASSENT2_1() {
        String assento = "F39A19";
        barca.quantAssentOcupados(112);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(2, resultadoVerdadeiro);
    }

    @Test
    void testaLIMITASSENT2_2() {
        String assento = "F40A19";
        barca.quantAssentOcupados(112);
        int resultadoVerdadeiro = barca.verificaLugar(assento);
        Assertions.assertEquals(3, resultadoVerdadeiro);
    }

}
