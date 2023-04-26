package proyectofin;

public class ProyectoFin {

    public static void main(String[] args) {
        
        Tesoreria t1 = new Tesoreria();
        
        t1.pedirPrestamo(99999);
        
        System.out.println(t1.toString());
        
    }
    
}
