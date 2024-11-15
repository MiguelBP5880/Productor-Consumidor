
package EJ1;


public class MainProductorConsumidor {

    //Metodo Main
    public static void main(String[] args) {
        //Tamaño del buffer 6 caracteres
        Buffer buffer = new Buffer(6);
        //Instancia con el objeto compartido buffer
        Productor productor = new Productor(buffer);
        Consumidor consumidor = new Consumidor(buffer);
        
        //Lanzamos la ejecución del hilo
        productor.start();
        consumidor.start();
        
    }
    
}
