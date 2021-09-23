package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        Fila<Integer> fila = new Fila<>();

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);
        fila.enqueue(4);
        fila.enqueue(5);

        System.out.println(fila.toString());
//        System.out.println(fila.first());
        fila.dequeue();
//        System.out.println(fila.first());
//        fila.enqueue(new No(99));
        System.out.println(fila.toString());

    }
}
