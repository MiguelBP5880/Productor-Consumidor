package EJ1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel Bobillo Pérez
 */

//Extendemos a clase Thread

public class Productor extends Thread {
        
        //Objeto de la clase buffer
        private final Buffer buffer;
        
        //String para generar el caracter de forma aleatoria
        private final String letras = "abcdefghijklmnopqrstuvxyz";
        
        //Contador hasta 15 acaracteres
        private int producir;
        
        //Constructor
        public Productor(Buffer buffer){
            this.producir = 0;
            this.buffer = buffer;
    }
        //Metodo run
        public void run(){
            
            //Itera hasta llegar al límite de 15 caracteres
            while(producir < 15){
            
                try {
                    //Genera un carácter aleatorio
                    char c = letras.charAt((int)(Math.random() * letras.length()));
                    //Depositamos el caracter en el metodo put del buffer
                    buffer.put(c);
                    //Sumamos 1  producir(Limite15)
                    producir++;
                    System.out.println("Depositado el caracter " + c + " del buffer");
                    //Uso de retardo para sincronizar Consumidor/Productor
                    Thread.sleep(350);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
          
            
        }
    }

}


