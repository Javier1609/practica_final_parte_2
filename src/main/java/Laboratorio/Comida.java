package Laboratorio;

public class Comida {
    public enum TipoPatron {
        INCREMENTO_DECREMENTO,
        DECREMENTO_INCREMENTO,
        CONSTANTE,
        INCREMENTO_LINEAL,
        DIA_SI_DIA_NO
    }

    private double cantidadInicial;
    private double cantidadFinal;
    private int diaInicioIncremento;
    private int diaInicioDecremento;
    private TipoPatron tipoPatron;

    public Comida(double cantidadInicial, double cantidadFinal, int diaInicioIncremento, int diaInicioDecremento, TipoPatron tipoPatron) {
        this.cantidadInicial = cantidadInicial;
        this.cantidadFinal = cantidadFinal;
        this.diaInicioIncremento = diaInicioIncremento;
        this.diaInicioDecremento = diaInicioDecremento;
        this.tipoPatron = tipoPatron;
    }

    public double getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(double cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public double getCantidadFinal() {
        return cantidadFinal;
    }

    public void setCantidadFinal(double cantidadFinal) {
        this.cantidadFinal = cantidadFinal;
    }

    public int getDiaInicioIncremento() {
        return diaInicioIncremento;
    }

    public void setDiaInicioIncremento(int diaInicioIncremento) {
        this.diaInicioIncremento = diaInicioIncremento;
    }

    public int getDiaInicioDecremento() {
        return diaInicioDecremento;
    }

    public void setDiaInicioDecremento(int diaInicioDecremento) {
        this.diaInicioDecremento = diaInicioDecremento;
    }

    public TipoPatron getTipoPatron() {
        return tipoPatron;
    }

    public void setTipoPatron(TipoPatron tipoPatron) {
        this.tipoPatron = tipoPatron;
    }

    public double dispensarComida(int dia) {
        switch (tipoPatron) {
            case INCREMENTO_DECREMENTO:
                if (dia < diaInicioIncremento) {
                    return cantidadInicial;
                } else if (dia < diaInicioDecremento) {
                    return cantidadInicial + (cantidadFinal - cantidadInicial) * (dia - diaInicioIncremento) / (diaInicioDecremento - diaInicioIncremento);
                } else {
                    return cantidadFinal - (cantidadFinal - cantidadInicial) * (dia - diaInicioDecremento) / (diaInicioDecremento - diaInicioIncremento);
                }
            case DECREMENTO_INCREMENTO:
                if (dia < diaInicioDecremento) {
                    return cantidadFinal - (cantidadFinal - cantidadInicial) * dia / diaInicioDecremento;
                } else if (dia < diaInicioIncremento) {
                    return cantidadInicial;
                } else {
                    return cantidadInicial + (cantidadFinal - cantidadInicial) * (dia - diaInicioIncremento) / (diaInicioDecremento - diaInicioIncremento);
                }
            case CONSTANTE:
                return cantidadInicial;
            case INCREMENTO_LINEAL:
                return cantidadInicial + (cantidadFinal - cantidadInicial) * dia / diaInicioIncremento;
            case DIA_SI_DIA_NO:
                return dia % 2 == 0 ? cantidadInicial : 0;
            default:
                return 0;
        }
    }
}