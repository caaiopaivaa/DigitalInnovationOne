package one.digitalInnovation;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> lista = new ListaCircular<>();

        lista.add("primeiro");
        lista.add("segundo");
        lista.add("terceiro");
        lista.add("quarto");
        lista.add("quinto");

        System.out.println(lista.get(0));
    }
}
