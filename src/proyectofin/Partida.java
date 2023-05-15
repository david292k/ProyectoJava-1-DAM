package proyectofin;

import java.util.*;

public class Partida {
    
    static private Tesoreria tesoreria;
    static private Salud salud;
    static private Seguridad seguridad;
    static private Ciudadanos ciudadanos;
    static private Tiempo tiempo;

    public Partida() {
        this.tesoreria = new Tesoreria();
        this.salud = new Salud();
        this.seguridad = new Seguridad();
        this.ciudadanos = new Ciudadanos();
        this.tiempo = new Tiempo();
    }

    static public void muestra(){
        System.out.println("Saldo: "+Tesoreria.saldoActual);
        System.out.println("Prestamo: "+Tesoreria.prestamo);
        System.out.println("Salud: "+Salud.salud);
        System.out.println("Seguridad: "+Seguridad.seguridad);
        System.out.println("Poblacion: "+Ciudadanos.poblacion);
        System.out.println("Felicidad: "+Ciudadanos.felicidad);
    }
    
    static public void reiniciarSemana(){
        Tesoreria.gananciasSemanal=0;
        Tesoreria.perdidasSemanal=0;
    }
    
    static public void avanzar(){
        Tiempo.pasarSemana();
        Ciudadanos.aumentarPoblacion();
        Partida.calcularSanidad();
        Partida.calcularSeguridad();
        ciudadanos.calcularFelicidad();
        ciudadanos.calcularImpuestos();
        ciudadanos.pagarImpuesto();
        Tesoreria.quitarDinero(Tesoreria.perdidasSemanal);
        Tesoreria.añadirDinero(Tesoreria.gananciasSemanal);
    }
    
    static public void gastoSalud(){
        salud.construir();
    }
    
    static public boolean comprobacion(ArrayList<Integer> n){
        boolean proporcion=false;
        
        if(n.size()-1==Math.round(Ciudadanos.poblacion/1000)){
            proporcion=true;
        }
        
        return proporcion;
    }
    
    static public void calcularSeguridad(){
        if(Servicios.comisaria.size()-1>Math.round(Ciudadanos.poblacion/1000)){
            Seguridad.seguridad=100;
        }else if(Servicios.comisaria.size()-1== Math.round(Ciudadanos.poblacion/1000)){
            Seguridad.seguridad=75;
        }else if(Servicios.comisaria.size()-1< Math.round(Ciudadanos.poblacion/1000)&&Servicios.hospital.size()>0){
            Seguridad.seguridad=50;
        }else if(Servicios.comisaria.size()==0){
            Seguridad.seguridad=25;
        }
    }
    
    static public void calcularSanidad(){
        if(Servicios.hospital.size()-1>Math.round(Ciudadanos.poblacion/1000)){
            Salud.salud=100;
        }else if(Servicios.hospital.size()-1== Math.round(Ciudadanos.poblacion/1000)){
            Salud.salud=75;
        }else if(Servicios.hospital.size()-1< Math.round(Ciudadanos.poblacion/1000)&&Servicios.hospital.size()>0){
            Salud.salud=50;
        }else if(Servicios.hospital.size()==0){
            Salud.salud=25;
        }
    }
   
    static public void contruirHospital(){
        salud.construir();
    }
    
    static public void contruirComisaria(){
        seguridad.construir();
    }
    
    
     public void juego(){
        Scanner sc = new Scanner(System.in);

        int n;
        
        System.out.println("----------------------------------------------------------------------");
        System.out.println("-------------------------- Sim Cytis 69 ------------------------------");
        System.out.println("----------------------------------------------------------------------");
        
        
        do{
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 1/ Banco ---------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 2/ Avanzar semana ------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 3/ Construir servicios -------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 4/ Informacion sobre tu ciudad -----------------");
            System.out.println("----------------------------------------------------------------------");
            n=sc.nextInt();
            
            switch (n) {
                case 1:            
                    Partida.banco();
                    break;
                case 2:
                    Partida.avanzar();
                    break;
                case 4:
                    Partida.muestra();
                    break;
                default:
                    throw new AssertionError();
            }
            
        }while(n!=5);
        
         
    }
        static public void banco(){
            Scanner sc = new Scanner(System.in);
            int m;
            int cantidad;
            
            System.out.println("----------------------------------------------------------------------");
            System.out.println("------------------------ Banco ---------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 1/ Pedir prestamo ------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 2/ Devolver prestamo ---------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("Opcion -> ");
            m=sc.nextInt();
            
            switch(m) {
                case 1:
                    System.out.println("¿Cuanto dinero quieres pedir prestado?");
                    cantidad=sc.nextInt();
                    Tesoreria.pedirPrestamo(cantidad);
                    break;
                case 2:
                    System.out.println("¿Cuanto dinero quieres devolver?");
                    cantidad=sc.nextInt();
                    Tesoreria.pagarPrestamo(cantidad);
                    break;
            }
        }
    
}
