package proyectofin;

import java.util.*;

public class ProyectoFin {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        
        Partida p1 =  new Partida();
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
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("------------------------ Banco ---------------------------------------");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("--------------------- 1/ Pedir prestamo ------------------------------");
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("--------------------- 2/ Devolver prestamo ---------------------------");
                    break;
                default:
                    throw new AssertionError();
            }
            
        }while(n!=5);
        
        
        
        /*
        Partida.muestra();
        System.out.println("-------------------------------");
        Partida.contruirComisaria();
        Partida.contruirHospital();
        Partida.avanzar();
        Partida.muestra();
        
        
        
        System.out.println("----- Sim Cytis 69 -----");
        System.out.println(" ");
        
        do{
            Partida.reiniciarSemana();
            
            System.out.println("---- Menú Principal ----");
 
            n=sc.nextInt();
            
            switch(n){
                case 1:{
                    Partida.gastoSalud();
                    Partida.muestra();
                }
            }
        }while(n!=2);
        */
    }
    
}
