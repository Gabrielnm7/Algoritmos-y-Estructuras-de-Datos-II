package aed;

public class Agenda {
    private Fecha fecha_actual;
    private ArregloRedimensionableDeRecordatorios arreglo;

    public Agenda(Fecha fechaActual) {
        this.fecha_actual = new Fecha(fechaActual);
        this.arreglo = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.arreglo.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String mensaje = this.fecha_actual + "\n=====\n";
        for (int i = 0; i < this.arreglo.longitud();i++){
            Fecha fecha_rec = this.arreglo.obtener(i).fecha();
            if (fecha_actual.equals(fecha_rec)){
            mensaje = mensaje + this.arreglo.obtener(i).toString() + "\n";
            }

        }
        return mensaje;
    }

    public void incrementarDia() {
        this.fecha_actual.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(this.fecha_actual);
    }

}
