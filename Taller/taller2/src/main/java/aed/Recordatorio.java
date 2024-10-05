package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        Fecha copiaFecha = new Fecha(this.fecha);
        return copiaFecha;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        
        return this.mensaje + " @ " + this.fecha.toString() + " " + this.horario.toString();
    }

    @Override
    public boolean equals(Object otro) {
        
        boolean otraesNull = (otro == null);

        boolean claseDistinta = otro.getClass() != this.getClass();

        if (otraesNull || claseDistinta){
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;
        boolean mismaFecha = this.fecha.equals(otroRecordatorio.fecha);
        boolean mismoHorario = this.horario.equals(otroRecordatorio.horario);
        boolean mismoMensaje = otroRecordatorio.mensaje == this.mensaje;
        return mismaFecha && mismoHorario && mismoMensaje;
    }

}
