package TareaSincronizacion;
import java.util.concurrent.Semaphore;
public class Main {
    public static void main(String[] args) {
        int numFilosofos = 5;
        Semaphore[] cubiertos = new Semaphore[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            cubiertos[i] = new Semaphore(1); // Inicializar todos los cubiertos como disponibles
        }

        Filosofo[] filosofos = new Filosofo[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            filosofos[i] = new Filosofo(i, cubiertos);
            filosofos[i].start(); // Iniciar cada filósofo en un hilo separado
        }
    }
}
