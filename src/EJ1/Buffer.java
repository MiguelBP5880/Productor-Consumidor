
package EJ1;

/**
 *
 * @author Miguel Bobillo Pérez
 */

class Buffer {
    // Array de valores tipo char 
    private char[] buffer; 
    // Cuenta elementos Buffer para verificar el tamaño
    private int contar; 
    // Tamaño del búfer
    private final int talla; 

    public Buffer(int size) {
        this.talla = size;
        this.buffer = new char[size];
        this.contar = 0;
    }

    // Se introduce el synchronized. Monitores
    
    // Metodo para Insertar  , Producir
    public synchronized void put(char c) throws InterruptedException {
        while (contar == talla) {
            // Mientras esté lleno esperar
            wait(); 
        }
        // De no estar lleno sumamos al buffer y notificamos al consumidor.
        buffer[contar++] = c;
        notifyAll(); 
    }

    // Método para obtener, Consumir
    public synchronized char get() throws InterruptedException {
        while (contar == 0) {
            // Espera si el búfer está vacío
            wait(); 
        }
        // Se accede a la posicion del buffer anterior y  se coge el caracter.
        char c = buffer[--contar];
        notifyAll(); 
        return c;
    }

    public int getContar() {
        return contar;
    }
}