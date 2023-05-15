package proyectofin;

public class Seguridad extends Servicios {
    
    static int seguridad;

    public Seguridad() {
        this.seguridad = 80;
    }

    
    @Override
    public void construir() {
        if(Tesoreria.saldoActual-precio>0){
            Tesoreria.perdidasSemanal+=precio;
            comisaria.add(1);
        }else{
            System.out.println("No tienes dinero suficiente");
        }
    }
    
    public void aumentarSeguridad(int n) {
        seguridad += n;
    }

    public void disminuirSeguridad(int n) {
        seguridad -= n;
    }

    public int getSeguridad() {
        return seguridad;
    }

    public void setSeguridad(int seguridad) {
        this.seguridad = seguridad;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }
    
    
    
}
