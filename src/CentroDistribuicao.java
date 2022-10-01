public class CentroDistribuicao {
    public enum SITUACAO {NORMAL, SOBRAVISO, EMERGENCIA}

    public enum TIPOPOSTO {COMUM, ESTRATEGICO}

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_GASOLINA = 10000;
    public static final int MAX_ALCOOL = 2500;

    private int tAditivo;
    private int tGasolina;
    private int tAlcool1;
    private int tAlcool2;

    private SITUACAO status;

    public CentroDistribuicao(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {
        try {
            this.tAditivo = tAditivo;
            this.tGasolina = tGasolina;
            this.tAlcool1 = tAlcool1;
            this.tAlcool2 = tAlcool2;

            if (tAditivo < 0 || tGasolina < 0 || tAlcool1 < 0 || tAlcool1 != tAlcool2 || tAditivo > MAX_ADITIVO ||
                    tGasolina > MAX_GASOLINA || (tAlcool1 * 2) > MAX_ALCOOL) {
                throw new IllegalArgumentException("Nao foi possivel instanciar corretamente o centro de distribuicao...");
            }

            this.defineSituacao();

        } catch (IllegalArgumentException e1) {
            tAditivo = tGasolina = tAlcool1 = tAlcool2 = 0;
            System.err.println(e1.getMessage());
        }
    }

    public void defineSituacao() {
        if (tAditivo < (MAX_ADITIVO * 0.25) || tGasolina < (MAX_GASOLINA * 0.25) ||
                (tAlcool1 * 2) < (MAX_ALCOOL * 0.25)) {
            this.status = SITUACAO.EMERGENCIA;
        } else if (tAditivo < (MAX_ADITIVO * 0.50) || tGasolina < (MAX_GASOLINA * 0.50) ||
                (tAlcool1 * 2) < (MAX_ALCOOL * 0.50)) {
            this.status = SITUACAO.SOBRAVISO;
        } else {
            this.status = SITUACAO.NORMAL;
        }
    }

    public SITUACAO getSituacao() {
        return this.status;
    }

    public int gettAditivo() {
        return this.tAditivo;
    }

    public int gettGasolina() {
        return this.tGasolina;
    }

    public int gettAlcool1() {
        return this.tAlcool1;
    }

    public int gettAlcool2() {
        return this.tAlcool2;
    }

    public int recebeAditivo(int qtdade) {
        if (qtdade > 0) {
            int auxQuantAntiga = this.tAditivo;

            this.tAditivo += qtdade;

            if (this.tAditivo > MAX_ADITIVO) {
                this.tAditivo = MAX_ADITIVO;
            }

            this.defineSituacao();

            return this.tAditivo - auxQuantAntiga;

        } else {
            return -1;
        }
    }

    public int recebeGasolina(int qtdade) {
        if (qtdade > 0) {
            int auxQuantAntiga = this.tGasolina;

            this.tGasolina += qtdade;

            if (this.tGasolina > MAX_GASOLINA) {
                this.tGasolina = MAX_GASOLINA;
            }

            this.defineSituacao();

            return this.tGasolina - auxQuantAntiga;

        } else {
            return -1;
        }
    }

    public int recebeAlcool(int qtdade) {
        if (qtdade > 0) {
            int auxQuantAntiga = this.tAlcool1;

            int quantColocada = qtdade / 2;

            this.tAlcool1 += quantColocada;
            this.tAlcool2 += quantColocada;

            if ((this.tAlcool1 * 2) > MAX_ALCOOL) {
                this.tAlcool1 = this.tAlcool2 = MAX_ALCOOL;
            }

            this.defineSituacao();

            return (this.tAlcool1 - auxQuantAntiga) * 2;

        } else {
            return -1;
        }
    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {

        int[] resultado = new int[4];
        int auxAditivo, auxGasolina, auxAlcoolGeral;

        if (this.status == SITUACAO.EMERGENCIA && tipoPosto == TIPOPOSTO.COMUM) {
            resultado[0] = -14;
        } else if (qtdade <= 0) {
            resultado[0] = -7;
        } else {

            if ((this.status == SITUACAO.SOBRAVISO && tipoPosto == TIPOPOSTO.COMUM) ||
                    (this.status == SITUACAO.EMERGENCIA)) {
                qtdade = (int) (qtdade * 0.5);
            }

            auxAditivo = (int) (qtdade * 0.05);
            auxGasolina = (int) (qtdade * 0.70);
            auxAlcoolGeral = (int) (qtdade * 0.25) / 2;

            if ((this.tAditivo - auxAditivo) < 0 || (this.tGasolina - auxGasolina) < 0 ||
                    (this.tAlcool1 - auxAlcoolGeral) < 0) {
                resultado[0] = -21;
                return resultado;
            }

            this.tAditivo -= auxAditivo;
            this.tGasolina -= auxGasolina;
            this.tAlcool1 -= auxAlcoolGeral;
            this.tAlcool2 -= auxAlcoolGeral;

            this.defineSituacao();

            resultado[0] = this.tAditivo;
            resultado[1] = this.tGasolina;
            resultado[2] = this.tAlcool1;
            resultado[3] = this.tAlcool2;
        }

        return resultado;
    }
}