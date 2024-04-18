package EjercicioSincronizacionParaParcial;

public class Main {
    public static void main(String[] args) {
        SynchronizedExample.Contador c1 = new SynchronizedExample.Contador();
        SynchronizedExample.Incrementador h1= new SynchronizedExample.Incrementador(c1,1000);
        SynchronizedExample.Incrementador h2= new SynchronizedExample.Incrementador(c1,1000);
        h1.start();
        h2.start();

        h1.join();
        h2.join();

        System.out.println("valor final del contador: "+ c1.getCount());


    }
}
