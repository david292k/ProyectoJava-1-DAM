package proyectofin;

public class Ciudadanos {
    
    int felicidad;
    int poblacion;
    int impuestos;

    public Ciudadanos() {
        this.felicidad = 0;
        this.poblacion = 0;
        this.impuestos = 0;
    }

    public void calcularFelicidad(){
        int valor=0;
        
        if(Salud.salud==100){
            valor+=50;
        }else if(Salud.salud>=75&&Salud.salud<100){
            valor+=40;
        }else if(Salud.salud>=50&&Salud.salud<75){
            valor+=30;
        }else if(Salud.salud>=25&&Salud.salud<50){
            valor+=20;
        }else{
            valor+=0;
        }
        
        if(Seguridad.seguridad==100){
            valor+=50;
        }else if(Seguridad.seguridad>=75&&Seguridad.seguridad<100){
            valor+=40;
        }else if(Seguridad.seguridad>=50&&Seguridad.seguridad<75){
            valor+=30;
        }else if(Seguridad.seguridad>=25&&Seguridad.seguridad<50){
            valor+=20;
        }else{
            valor+=0;
        }
        
        setFelicidad(valor);
    }
    
    public void aumentarPoblacion(){
        poblacion+=100;
    }
    
    public void calcularImpuestos(){
        int valor=0;
        
        if(felicidad==100){
            valor+=30;
        }else if(felicidad>50&&felicidad<100){
            valor+=20;
        }else{
            valor+=10;
        }
        
        setImpuestos(valor);
        
        
    }

    public int getFelicidad() {
        return felicidad;
    }

    public void setFelicidad(int felicidad) {
        this.felicidad = felicidad;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    public int getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(int impuestos) {
        this.impuestos = impuestos;
    }
    
    
}
