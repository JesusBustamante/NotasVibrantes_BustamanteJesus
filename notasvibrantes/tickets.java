package notasvibrantes;

import java.time.LocalDate;

public class tickets {
    int ID;
    int idCliente;
    int idConcierto;
    String zona;
    double precioFinal;
    LocalDate fechaCompra;

    public tickets(int ID, int idCliente, int idConcierto, String zona, double precioFinal, LocalDate fechaCompra) {
        this.ID = ID;
        this.idCliente = idCliente;
        this.idConcierto = idConcierto;
        this.zona = zona;
        this.precioFinal = precioFinal;
        this.fechaCompra = fechaCompra;
    }
    
    @Override
    public String toString() {
        return "Ticket{" +
                "id: " + ID +
                ", ID de cliente: '" + idCliente + '\'' +
                ", ID de concierto: '" + idConcierto + '\'' +
                ", Zona: '" + zona + '\'' +
                ", Precio Final: '" + precioFinal + '\'' +
                ", Fecha de compra: '" + fechaCompra + '\'' +'}';
    }
}