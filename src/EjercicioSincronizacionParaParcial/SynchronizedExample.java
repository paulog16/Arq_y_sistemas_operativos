package EjercicioSincronizacionParaParcial;

public class SynchronizedExample {
    static class Contador {
        private int count = 0;

        public synchronized void increment() {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

    static class Incrementador extends Thread {
        private Contador contador;
        private int veces;

        public Incrementador() {
        }

        public Incrementador(Contador contador, int veces) {
            this.contador = contador;
            this.veces = veces;
        }

        @Override
        public void run() {
            // Incrementamos el contador varias veces de forma segura
            for (int i = 0; i < veces; i++) {
                contador.increment();
            }
        }
    }
}
