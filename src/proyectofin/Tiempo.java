package proyectofin;

public class Tiempo {
    
    static int semana;
    static int mes;
    static int anyo;

    public Tiempo() {
        this.semana = 1;
        this.mes = 1;
        this.anyo = 2023;
    }
    
    static public void pasarSemana(){
        if(semana+1>4&&mes+1>12){
            semana=1;
            mes=1;
            anyo+=1;
        }else if(semana+1>4){
            semana=1;
            mes+=1;
        }else{
            semana+=1;
        }
    }

    @Override
    public String toString() {
        return "Tiempo{" + "semana=" + semana + ", mes=" + mes + ", año=" + anyo + '}';
    }
    
    
}
