package aed;

public class Fecha {
    private int dia;
    private int mes;

    public Fecha(int dia, int mes) {
        // Implementar
        this.dia = dia;
        this.mes = mes;
    }
    public Fecha(Fecha fecha) {
        // Implementar
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }

    public Integer dia() {
        int dia = this.dia;
        return dia;
    }

    public Integer mes() {
        int mes = this.mes;
        return mes;
    }
    @Override
    public String toString() {
        return this.dia + "/" + this.mes;
    }

    @Override
    public boolean equals(Object otra) {
        // Implementar
        return true;
    }

    public void incrementarDia() {
        // Implementar
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
