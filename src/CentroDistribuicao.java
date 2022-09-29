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

            if (tAditivo < 0 || tGasolina < 0 || tAlcool1 < 0 || tAlcool1 != tAlcool2) {
                throw new IllegalArgumentException("Nao foi possivel instanciar corretamente o centro de distribuicao...");
            }

            this.defineSituacao();

        } catch (IllegalArgumentException e1) {
            tAditivo = tGasolina = tAlcool1 = tAlcool2 = 0;
            System.err.println(e1.getMessage());
        }
    }

    public void defineSituacao() {
        if (tAditivo < 125 || tGasolina < 2500 || tAlcool1 < 625) {
            this.status = SITUACAO.EMERGENCIA;
        } else if (tAditivo < 250 || tGasolina < 5000 || tAlcool1 < 1250) {
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
        //Como vai dividir precisa ser mais de 1 (Tudo eh int)
        if (qtdade > 1) {
            int auxQuantAntiga = this.tAlcool1;

            int quantColocada = qtdade / 2;

            this.tAlcool1 += quantColocada;
            this.tAlcool2 += quantColocada;

            if (this.tAlcool1 > MAX_ALCOOL) {
                this.tAlcool1 = this.tAlcool2 = MAX_ALCOOL;
            }

            this.defineSituacao();

            return (this.tAlcool1 - auxQuantAntiga) * 2;

        } else {
            return -1;
        }
    }

//    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
//
//    }
}
