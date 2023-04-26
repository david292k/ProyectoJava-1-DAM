package proyectofin;

import java.util.*;

public class Tesoreria {
    
    int saldoActual;
    int perdidasSemanal;
    int gananciasSemanal;
    int prestamo;

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
    
    public void pedirPrestamo(int cantidad){
        if(cantidad>0&&cantidad<100000){
            saldoActual+=cantidad;
            prestamo+=cantidad;
        }else{
            System.out.println("Esa cantidad es demasiado grande, el maximo es 99.999€");
        }
    }
    
    public void pagarPrestamo(int cantidad){
        if(cantidad>0&&cantidad<100000){
            saldoActual+=cantidad;
        }
    }
    
    public void añadirDinero(int cantidad){
        if(cantidad>0&&cantidad<100000){
            saldoActual+=cantidad;
        }
    }
    
    public void quitarDinero(int cantidad){
        if(cantidad>0&&saldoActual-cantidad>0){
            saldoActual+=cantidad;
        }
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

    public int getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(int prestamo) {
        this.prestamo = prestamo;
    }
    
    
    
}
