package proyectofin;

import java.util.*;

public class Partida {
    
    static private Tesoreria tesoreria;
    static private Salud salud;
    static private Seguridad seguridad;
    static private Ciudadanos ciudadanos;
    static private Tiempo tiempo;
    
    static Random numAleatorio = new Random();

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
        System.out.println("Comisarias: "+Servicios.comisaria.size());
        System.out.println("Hospitales: "+Servicios.hospital.size());
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
        Partida.reiniciarSemana();
        Tesoreria.devolverPrestamo();
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
    
    static public void construir(){
        Scanner sc = new Scanner(System.in);
        int n;
        
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------------- (Cuestan las 2 10.000€) ------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------------- 1/ Construir comisaria -------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------------- 2/ Construir hospital --------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("--------------------- 3/ Salir ---------------------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Opcion -> ");      
        n=sc.nextInt();
        
        switch (n) {
            case 1:
                Partida.contruirComisaria();
                Partida.avanzar();
                break;
            case 2:
                Partida.contruirHospital();
                Partida.avanzar();
                break;
            case 3:
                break;
        }
    }
    
    
     public void juego(){
        Scanner sc = new Scanner(System.in);

        int n;
        
        System.out.println("----------------------------------------------------------------------");
        System.out.println("-------------------------- Sim Cytis 69 ------------------------------");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------");      
        Partida.reglas();
        System.out.println("-------------------------- Let's Goooo!! -----------------------------");
        System.out.println("----------------------------------------------------------------------");      
        
        do{
            
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- Semana: "+Tiempo.semana+", Mes: "+Tiempo.mes+", Año: "+Tiempo.anyo+" -------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 1/ Banco ---------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 2/ Avanzar semana ------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 3/ Construir servicios -------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 4/ Informacion sobre tu ciudad -----------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 5/ Salir del juego -----------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("Opcion -> ");
            n=sc.nextInt();
            
            switch (n) {
                case 1:            
                    Partida.banco();
                    break;
                case 2:
                    Partida.avanzar();
                    Partida.eventosSeguridad();
                    Partida.eventosSalud();
                    break;
                case 3:
                    Partida.construir();
                    break;
                case 4:
                    Partida.muestra();
                    break;
                default:
                    if(n!=5){
                        System.out.println("Numero incorrecto. Ponga una opción válida");
                    }
                    
            }
            
            if(Partida.derrota()){
                System.out.println("Has perdido :(");
                n=5;
            }
            
            if(Partida.ganar()){
                System.out.println("Has ganadooo!!! :)");
                n=5;
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
            System.out.println("--------------------- 3/ Salir ---------------------------------------");
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
                case 3:
                    break;
            }
        }
    
        static public void reglas(){
            
            System.out.println("--------------------- Reglas del juego: ------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 1) El objetivo es superar la  ------------------");
            System.out.println("------------------------ población de 10,000 con ---------------------");
            System.out.println("------------------------ 100 de felicidad y superar ------------------");
            System.out.println("------------------------ población de 1.000.000€. --------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 2) Si obtienes un saldo negativo  --------------");
            System.out.println("------------------------ habrás perdido. -----------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("--------------------- 3) Si tienes un bajo nivel en  -----------------");
            System.out.println("------------------------ tus servicios pueden haber ------------------");
            System.out.println("------------------------ diferentes catastrofes. ---------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
        }
        
        static public boolean derrota(){
            boolean comprobador=false;
            
            if(Tesoreria.saldoActual<0){
                comprobador=true;
            }
            return comprobador;
        }
        
        static public void eventosSeguridad(){
            
            int probabilidad=numAleatorio.nextInt(100-1);
            
            if(Seguridad.seguridad==75){
                if(probabilidad<10&&probabilidad>0){
                    System.out.println("Han sucedido actos bandalicos, las reparaciones han costado a la banca 4000€");
                    Tesoreria.quitarDinero(4000);
                }
            }else if(Seguridad.seguridad==50){
                if(probabilidad<50&&probabilidad>30){
                    System.out.println("Una banda organizada ha atracado la tesoreria. Han robado 6000€");
                    Tesoreria.quitarDinero(6000);
                }
            }else if(Seguridad.seguridad==25){
                if(probabilidad<100&&probabilidad>70){
                    System.out.println("La nueva casa de papel. Un grupo de enmascarados han robado 8000€");
                    Tesoreria.quitarDinero(8000);
                }
            }

        }
        
        static public void eventosSalud(){
            
            int probabilidad=numAleatorio.nextInt(100-1);
            
            if(Salud.salud==75){
                if(probabilidad<10&&probabilidad>0){
                    System.out.println("Hay una epidemia de gripe. Ha muerto el 30% de la población");
                    Ciudadanos.poblacion*=0.70;
                }
            }else if(Salud.salud==50){
                if(probabilidad<50&&probabilidad>30){
                    System.out.println("Por culpa de un residuo radiactivo ha muerto un 50% de la poblacion");
                    Ciudadanos.poblacion*=0.50;
                }
            }else if(Salud.salud==25){
                if(probabilidad<100&&probabilidad>70){
                    System.out.println("Ha llegado el Covid-19. Solo ha sobrevivido el 20% de la población");
                    Ciudadanos.poblacion*=0.20;
                }
            }

        }
        
        static public boolean ganar(){
            boolean victoria=false;
            
            if(Ciudadanos.felicidad==100&&Ciudadanos.poblacion>=10000&&Tesoreria.saldoActual>1000000){
                victoria=true;
            }
            
            return victoria;
        }
}
