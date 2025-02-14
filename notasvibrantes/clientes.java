package notasvibrantes;

public class clientes {
    int ID;
    String nombre;
    String apellido;
    String correo;
    String telefono;

    public clientes(int ID, String nombre, String apellido, String correo, String telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return "Concierto{" +
                "id: " + ID +
                ", Nombre: '" + nombre + '\'' +
                ", Apellido: '" + apellido + '\'' +
                ", Correo: '" + correo + '\'' +
                ", Telefono: '" + telefono + '\'' +'}';
    }
}
