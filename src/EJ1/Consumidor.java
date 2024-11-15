
package EJ1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Bobillo Pérez
 */

//Extendemos a clase Thread

public class Consumidor extends Thread {
    
    // Objeto de la clase Bufffer
    private final Buffer buffer;
    
    //Iniciar contador hasta 15 de caracteres
    private int consumir;
    
    //Constructor
    public Consumidor(Buffer buffer){
        this.consumir = 0;
        this.buffer = buffer;
    }
    //Metodo run
    public void run(){
        //Itera hasta llegar al límite de 15 caracteres
        while (consumir < 15){
            try{
                //Cogemos el carácter del metodo get del buffer    
                char c = buffer.get();
                //Sumamos 1 a consumir(Limite15)
                consumir++;        
                System.out.println("Recogido el caracter " + c + " del buffer");
                //Uso de retardo para sincronizar Consumidor/Productor
                Thread.sleep(350);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
               
            
        }
    }
}