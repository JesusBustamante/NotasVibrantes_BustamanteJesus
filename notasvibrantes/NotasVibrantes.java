package notasvibrantes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class NotasVibrantes {

    static Scanner sc = new Scanner(System.in);
    static int contadorId = 1;
    static ArrayList<conciertos> concierto = new ArrayList<>();
    static ArrayList<clientes> cliente = new ArrayList<>();
    static ArrayList<tickets> ticket = new ArrayList<>();
    
    public static void main(String[] args) {
            
        // Inserciones de prueba
        
        // Concierto
        conciertos concierto1 = new conciertos(1, "Residencia - Albúm 25", "Adele", LocalDate.of(2025, 3, 14), "Munich Alemania", 500);
        concierto.add(concierto1);
        conciertos concierto2 = new conciertos(2, "Residencia - Albúm 21", "Adele", LocalDate.of(2025, 5, 27), "Las Vegas USA", 700);
        concierto.add(concierto2);
        
        // Cliente
        clientes cliente1 = new clientes(1, "Jesus", "Bustamante", "jesus@gmail.com", "3156611676");
        cliente.add(cliente1);
        clientes cliente2 = new clientes(2, "Jose", "Perales", "jose@gmail.com", "3217711767");
        cliente.add(cliente2);
        
        // Ticket
        tickets ticket1 = new tickets(1, 1, 1, "Platinum", 1000.0, LocalDate.of(2025, 2, 23));
        ticket.add(ticket1);
        tickets ticket2 = new tickets(2, 1, 2, "VIP", 900.0, LocalDate.of(2025, 3, 2));
        ticket.add(ticket2);
        
        System.out.println("-----BIENVENIDO A NOTAS VIBRANTES-----\n");
        System.out.println("-----------------MENU-----------------\n");
        System.out.println("1. VER CONCIERTOS DISPONIBLES");
        System.out.println("2. REGISTRAR CLIENTE");
        System.out.println("3. COMPRAR TICKET");
        System.out.println("4. VER TICKETS POR CLIENTE");
        System.out.println("5. CANCELAR TICKET");
        System.out.println("6. SALIR\n");
        
        System.out.print("SELECCIONE: ");
        
        int opcion;
        opcion = sc.nextInt();
        
        switch (opcion) {
            case 1: 
                listarConciertos();
                break;
            case 2:
                registrarClientes();
                break;
            case 3:
                comprarTicket();
                break;
            case 4:
                verTickePorCliente();
                break;
            case 5:
                cancelarTicket();
            default:
                System.out.print("default: ");
        }
    }
    
    static void listarConciertos() {
        
        if (concierto.isEmpty()) {
            System.out.println("\nNO HAY CONCIERTOS DISPONIBLES");
        } else {
            
            System.out.println("\nCONCIERTOS DISPONIBLES\n");
            
            for (conciertos c : concierto) {
            System.out.println("ID: " + c.ID);
            System.out.println("Nombre: " + c.nombre);
            System.out.println("Artista: " + c.artista);
            System.out.println("Lugar: " + c.lugar);
            System.out.println("Fecha: " + c.fecha);
            System.out.println("Precio base: $" + c.precioBase + "\n");
            }
        }
    }
    
    static void registrarClientes() {
        
        System.out.println("\nREGISTRO DE CLIENTE\n-----------------------");
        System.out.println("INGRESE LA INFORMACIÓN SOLICITADA\n");
        
        sc.nextLine();
        System.out.print("NOMBRE: ");
        String nombre = sc.nextLine();
        System.out.print("\nAPELLIDO: ");
        String apellido = sc.nextLine();
        System.out.print("\nCORREO: ");
        String correo = sc.nextLine();
        System.out.print("\nTELEFONO: ");
        String telefono = sc.nextLine();
        
        cliente.add(new clientes(contadorId++, nombre, apellido, correo, telefono));
        System.out.println("\nCLIENTE REGISTRADO");
        
    }
    
    static void comprarTicket() {
        System.out.println("\nCOMPRA DE TICKET\n");
        System.out.println("CONCIERTOS DISPONIBLES\n");
        
        for (conciertos c : concierto) {
            System.out.println("ID: " + c.ID);
            System.out.println("Nombre: " + c.nombre);
            System.out.println("Artista: " + c.artista);
            System.out.println("Lugar: " + c.lugar);
            System.out.println("Fecha: " + c.fecha);
            System.out.println("Precio base: $" + c.precioBase + "\n");
        }

        System.out.println("INGRESE LA INFORMACIÓN SOLICITADA\n--------------------------------\n");
        
        // Solicitar ID del concierto
        System.out.print("INGRESE EL ID DEL CONCIERTO: ");
        int idConcierto = sc.nextInt();

        // Solicitar ID del cliente
        System.out.print("INGRESE EL ID DEL CLIENTE: ");
        int idCliente = sc.nextInt();

        // Verificar si el concierto existe
        conciertos conciertoSeleccionado = null;
        for (conciertos c : concierto) {
            if (c.ID == idConcierto) {
                conciertoSeleccionado = c;
                break;
            }
        }

        // Verificar si el cliente existe
        clientes clienteSeleccionado = null;
        for (clientes cl : cliente) {
            if (cl.ID == idCliente) {
                clienteSeleccionado = cl;
                break;
            }
        }

        // Si ambos existen, proceder con la compra
        if (conciertoSeleccionado != null && clienteSeleccionado != null) {
            // Mostrar zonas disponibles y sus precios adicionales
            System.out.println("\nZONAS DISPONIBLES:\n");
            System.out.println("1. General - Precio base: $" + conciertoSeleccionado.precioBase);
            System.out.println("2. VIP - Precio base + $200");
            System.out.println("3. Platinum - Precio base + $500");

            // Solicitar la zona
            System.out.print("Seleccione la zona (1-3): ");
            int opcionZona = sc.nextInt();
            String zonaSeleccionada = "";
            double precioFinal = conciertoSeleccionado.precioBase;

            switch (opcionZona) {
                case 1:
                    zonaSeleccionada = "General";
                    break;
                case 2:
                    zonaSeleccionada = "VIP";
                    precioFinal += 200;
                    break;
                case 3:
                    zonaSeleccionada = "Platinum";
                    precioFinal += 500;
                    break;
                default:
                    System.out.println("Opción de zona no válida.");
                    return;
            }

            // Crear un nuevo ticket
            tickets nuevoTicket = new tickets(contadorId++, idCliente, idConcierto, zonaSeleccionada, precioFinal, LocalDate.now());
            ticket.add(nuevoTicket);

            System.out.println("\nTICKET COMPRADO EXITOSAMENTE");
            System.out.println("ID del Ticket: " + nuevoTicket.ID);
            System.out.println("Concierto: " + conciertoSeleccionado.nombre);
            System.out.println("Cliente: " + clienteSeleccionado.nombre + " " + clienteSeleccionado.apellido);
            System.out.println("Zona: " + nuevoTicket.zona);
            System.out.println("Precio Final: $" + nuevoTicket.precioFinal);
            System.out.println("Fecha de Compra: " + nuevoTicket.fechaCompra);
        } else {
            System.out.println("CONCIERTO O CLIENTE NO ENCONTRADO");
        }
        
    }
    
    static void verTickePorCliente() {
        
        System.out.println("\nTICKETS COMPRADOS POR CLIENTE\n");
        System.out.println("INGRESE lA INFORMACIÓN SOLICITADA\n----------------------------------");
        
        System.out.print("INGRESE EL ID DEL CLIENTE: ");
        int id = sc.nextInt();
        
        clientes clienteEncontrado = null;
        for (clientes cl : cliente) {
            if (cl.ID == id) {
                clienteEncontrado = cl;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("\n" + clienteEncontrado.nombre + " tus tickets son:\n");

            // Buscar los tickets del cliente
            for (tickets t : ticket) {
                if (t.idCliente == clienteEncontrado.ID) {
                    for (conciertos c : concierto) {
                        if (c.ID == t.idConcierto) {
                            System.out.println("ID: " + t.ID + "\n" 
                                + "Concierto: " + c.nombre + "\n" 
                                + "Zona: " + t.zona + "\n" 
                                + "Precio: " + t.precioFinal + "\n" 
                                + "Fecha de compra: " + t.fechaCompra + "\n");
                            
                        }
                    }
                }
            }
        } else {
            System.out.println("CLIENTE NO ENCONTRADO");
        }
    }
    
    static void cancelarTicket() {
        System.out.println("\nCANCELACIÓN DE TICKET\n");

        System.out.print("INGRESE EL ID DEL CLIENTE: ");
        int idCliente = sc.nextInt();

        clientes clienteEncontrado = null;
        for (clientes cl : cliente) {
            if (cl.ID == idCliente) {
                clienteEncontrado = cl;
                break;
            }
        }

        if (clienteEncontrado != null) {
            System.out.println("\n" + clienteEncontrado.nombre + " tus tickets son:\n");

            for (tickets t : ticket) {
                if (t.idCliente == clienteEncontrado.ID) {
                    for (conciertos c : concierto) {
                        if (c.ID == t.idConcierto) {
                            System.out.println("ID: " + t.ID + "\n" 
                                + "Concierto: " + c.nombre + "\n" 
                                + "Zona: " + t.zona + "\n" 
                                + "Precio: " + t.precioFinal + "\n" 
                                + "Fecha de compra: " + t.fechaCompra + "\n");
                        }
                    }
                }
            }

            System.out.print("\nINGRESE EL ID DEL TICKET QUE DESEA CANCELAR: ");
            int idTicket = sc.nextInt();

            boolean ticketEliminado = false;
            for (int i = 0; i < ticket.size(); i++) {
                if (ticket.get(i).ID == idTicket && ticket.get(i).idCliente == idCliente) {
                    ticket.remove(i);
                    ticketEliminado = true;
                    System.out.println("TICKET CANCELADO EXITOSAMENTE");
                    
                    break;
                }
            }

            if (!ticketEliminado) {
                System.out.println("NO SE ENCONTRÓ UN TICKET CON EL ID PROPORCIONADO");
            }

        } else {
            System.out.println("CLIENTE NO ENCONTRADO");
        }
    }
}
