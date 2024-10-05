package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] seq;

    public ArregloRedimensionableDeRecordatorios() {
        this.seq = new Recordatorio[]{};
    }

    public int longitud() {
        return this.seq.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] res = new Recordatorio[this.seq.length+1];
        if (this.seq.length == 0){
            res[0] = i;
        }
        else {
            for (int j = 0;j < this.seq.length; j++){
                res[j] = this.seq[j];
            }
            res[this.seq.length] = i;
            }
        this.seq = res;
    }

    public Recordatorio obtener(int i) {
        return this.seq[i];
    }

    public void quitarAtras() {
        Recordatorio[] res = new Recordatorio[this.seq.length-1];
        for (int j = 0;j < this.seq.length-1; j++){
                res[j] = this.seq[j];
            }
        this.seq = res;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        Recordatorio[] res = new Recordatorio[this.seq.length];
        for (int j = 0;j < this.seq.length; j++){
            if (j != indice) {
            res[j] = this.seq[j];
            }
            else {
            res[j] = valor;
            }
        }
        this.seq = res;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.seq = new Recordatorio[vector.longitud()];
        // Deberia hacer un constructor por copia de Recordatorio? Sino..
        for (int i = 0; i<vector.longitud();i++){
            Recordatorio original = vector.obtener(i);

            Recordatorio copia = new Recordatorio(original.mensaje(),
                                                  original.fecha(), // Ya hicimos que no haya aliasing
                                                  original.horario()); 

            this.seq[i] = copia;
        }

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        return new ArregloRedimensionableDeRecordatorios(this);
    }
}
