package one.digitalInnovation;

public class Main {
    public static void main(String[] args) {
        ListaDuplamenteEncadeada<String> lista = new ListaDuplamenteEncadeada<>();

        lista.add("primeiro");
        lista.add("segundo");
        lista.add("terceiro");
        lista.add("quarto");
        lista.add("quinto");
        lista.add(3, "terceiro1");
        lista.remove(3);

        System.out.println(lista);

    }
}
