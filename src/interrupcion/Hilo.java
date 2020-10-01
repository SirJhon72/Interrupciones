
package interrupcion;
import javax.swing.JTextArea;

public class Hilo extends Thread{
    protected JTextArea area;
    protected CreditCard rc;
    protected boolean bandera = false;
    int cont = 0;
    
    public Hilo(JTextArea area, CreditCard rc){
        this.area = area;
        this.rc = rc;
    }
    
    public void run(){
            System.out.println("Entro con el hilo: " + this.getName());
            //Band == true
            for(int i = 0; i < rc.Inter.length; i++){
                if(rc.Inter[i].isInter() == true){ //Comprobamos que sea true
                    espera(0); //Salimos del programa, el hilo no debe de entrar a su seccion critica
                    ////////////////////////ATENCION///////////////////////////
                }
            }
            //Si ninguna de las interrupciones fallaron
            //Comprobamos que este dentro de la seccion critica
            //Band == true, cambia cuando entra en su seccion critic
            //System.out.println("Estoy en la seccion critica del hilo: " + this.getName());
            for(int i = 0; i < rc.Inter.length; i++){
                if(rc.Inter[i].isInter() == false){
                    SeccionCritica();
                    rc.Inter[i].setInter(true); //////////////////////////////////ATENCION ///////////////////////7777
                    cont++;
                }else{
                    System.out.println("No fue posible escribir en el archivo, hilo: " + this.getName());
                }
                  System.out.println("Salimos de la seccion critica, hilo: " + this.getName());
                }
               
                
                if(cont== 1){
                    System.out.println("Se bloquearon las interrupciones,hilo: " + this.getName() +"\n");
                }
            
            
           
    }
    
    public boolean SeccionCritica(){
        try {
            System.out.println("Escribo en la seccion critica, hilo: " +this.getName()+", <-------");
            rc.setTarjetaCredito(this.getName());
            area.append(rc.getTarjetaCredito()+"\n\n"); //Escribimos en el areas
            return true;
        } catch (Exception e) {
            System.out.println("No escribo");
            return false;
        }
        
    }
    
    public void espera(int i){
        try {
            this.sleep(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}