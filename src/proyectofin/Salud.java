package proyectofin;

public class Salud extends Servicios {

    static int salud;

    public Salud() {
        this.salud = 80;
    }

    
    @Override
    void construir() {
        if(Tesoreria.saldoActual-precio>0){
            Tesoreria.saldoActual-=precio;
            salud+=15;
        }else{
            System.out.println("No tienes dinero suficiente");
        }
    }

    public void aumentarSalud(int n) {
        salud += n;
    }

    public void disminuirSalud(int n) {
        salud -= n;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getGasto() {
        return gasto;
    }

    public void setGasto(int gasto) {
        this.gasto = gasto;
    }

    
}
