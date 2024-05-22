package Laboratorio;

public class experimento {
    private int dias;
    private double temperatura;
    private Comida comida;

    public experimento(int dias, double temperatura) throws Exception {
        if (dias < 0) {
            throw new Exception("El número de días no puede ser negativo");
        }
        this.dias = dias;
        this.temperatura = temperatura;
    }

    public int getDias() {
        return dias;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }
}