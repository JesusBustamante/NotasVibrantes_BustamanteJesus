package notasvibrantes;

import java.time.LocalDate;

public class conciertos {
    int ID;
    String nombre;
    String artista;
    LocalDate fecha;
    String lugar;
    double precioBase;

    public conciertos(int ID, String nombre, String artista, LocalDate fecha, String lugar, double precioBase) {
        this.ID = ID;
        this.nombre = nombre;
        this.artista = artista;
        this.fecha = fecha;
        this.lugar = lugar;
        this.precioBase = precioBase;
    }
    
    @Override
    public String toString() {
        return "Concierto{" +
                "id: " + ID +
                ", Nombre: '" + nombre + '\'' +
                ", Artista: '" + artista + '\'' +
                ", Fecha: '" + fecha + '\'' +
                ", Lugar: '" + lugar + '\'' +
                ", Precio base: '" + precioBase + '\'' +'}';
    }
}
