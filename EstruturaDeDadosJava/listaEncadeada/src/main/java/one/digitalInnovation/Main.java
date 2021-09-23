package one.digitalInnovation;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> lista = new ListaEncadeada<>();

        lista.add("primeiro");
        lista.add("segundo");
        lista.add("terceiro");
        lista.add("quarto");
        lista.add("quinto");

        System.out.println(lista);
        lista.remove(0);
        System.out.println(lista);
        System.out.println(lista.isEmpty());
        lista.add("Ola mundo");
        System.out.println(lista);


    }
}
