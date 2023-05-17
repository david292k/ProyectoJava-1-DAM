package proyectofin;

import java.util.*;

public class Tesoreria {
    
    static int saldoActual;
    static int perdidasSemanal;
    static int gananciasSemanal;
    static int prestamo;

    public Tesoreria() {
        this.saldoActual = 10000;
        this.perdidasSemanal = 0;
        this.gananciasSemanal = 0;
        this.prestamo = 0;
    }

    @Override
    public String toString() {
        return "Tesoreria{" + "saldoActual=" + saldoActual + ", perdidasSemanal=" + perdidasSemanal + ", gananciasSemanal=" + gananciasSemanal + ", prestamo=" + prestamo + '}';
    }
    
    static public void pedirPrestamo(int cantidad){
        if(cantidad>0&&cantidad<100000){
            saldoActual+=cantidad;
            prestamo+=cantidad;
        }else{
            System.out.println("Esa cantidad es demasiado grande, el maximo es 99.999€");
        }
    }
    
    static public void pagarPrestamo(int cantidad){
        if(cantidad>0&&cantidad<100000){
            saldoActual-=cantidad;
            prestamo-=cantidad;
        }else{
            System.out.println("No tienes tanto dinero para devolver");
        }
    }
    
    
    static public void devolverPrestamo(){
        int porcentaje;
        
        porcentaje = prestamo * 10 / 100;
        
        perdidasSemanal+=porcentaje;
        
        if(prestamo-porcentaje>=0){
            prestamo-=porcentaje;
        }else{
            prestamo=0;
        }
        
    }
        
    static public void añadirDinero(int cantidad){
            saldoActual+=cantidad;
    }
    
    static public void quitarDinero(int cantidad){
            saldoActual-=cantidad;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }

    public int getPerdidasSemanal() {
        return perdidasSemanal;
    }

    public void setPerdidasSemanal(int perdidasSemanal) {
        this.perdidasSemanal = perdidasSemanal;
    }

    public int getGananciasSemanal() {
        return gananciasSemanal;
    }

    public void setGananciasSemanal(int gananciasSemanal) {
        this.gananciasSemanal = gananciasSemanal;
    }
    

    
}
