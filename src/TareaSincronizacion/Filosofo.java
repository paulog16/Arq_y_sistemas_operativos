package TareaSincronizacion;

import java.util.concurrent.Semaphore;
import java.util.Random;

public class Filosofo extends Thread {

    private int id;
    private Semaphore[] cubiertos;
    private Random random = new Random();

    public Filosofo(int id, Semaphore[] cubiertos) {
        this.id = id;
        this.cubiertos = cubiertos;
    }

    private void comer() throws InterruptedException {
        // Adquirir el cubierto izquierdo
        cubiertos[id].acquire();
        // Adquirir el cubierto derecho (el módulo garantiza que el filósofo 0 tenga el cubierto derecho del filósofo 4)
        cubiertos[(id + 1) % cubiertos.length].acquire();

        System.out.println("Filósofo " + id + " comiendo");

        // Simular comer por un tiempo aleatorio entre 1000 y 5000 milisegundos
        Thread.sleep(random.nextInt(4000) + 1000);

        // Soltar los cubiertos
        cubiertos[id].release();
        cubiertos[(id + 1) % cubiertos.length].release();
    }

    private void pensar() throws InterruptedException {
        System.out.println("El filósofo " + id + " está pensando");
        // Simular pensamiento por un tiempo aleatorio entre 1000 y 5000 milisegundos
        Thread.sleep(random.nextInt(4000) + 1000);
    }

    @Override
    public void run() {
        while (true) {
            try {
                pensar();
                comer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
