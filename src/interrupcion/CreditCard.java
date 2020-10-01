package interrupcion;

public class CreditCard {
    protected String TarjetaCredito; // <---- Tarjeta de credito
    protected Interrupciones[] Inter = new Interrupciones[2]; // <---- Array de interrupciones
    
    public CreditCard(){
        for(int i = 0; i < Inter.length; i++){
            Inter[i] = new Interrupciones(false); //Inicializamos las interrupciones con false
        }
    } 
    
    public String getTarjetaCredito(){
        return TarjetaCredito;
    }

    public void setTarjetaCredito(String TarjetaCredito) {
        this.TarjetaCredito = TarjetaCredito;
    }

    public Interrupciones[] getInter() {
        return Inter;
    }

    public void setInter(Interrupciones[] Inter) {
        this.Inter = Inter;
    }
    
    
}
