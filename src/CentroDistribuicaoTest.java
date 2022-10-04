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
    void getSituacao() {
    }

    @Test
    void gettAditivo() {
    }

    @Test
    void gettGasolina() {
    }

    @Test
    void gettAlcool1() {
    }

    @Test
    void gettAlcool2() {
    }

    @Test
    void recebeAditivo() {
    }

    @Test
    void recebeGasolina() {
    }

    @Test
    void recebeAlcool() {
    }

    @Test
    void encomendaCombustivel() {
    }
}