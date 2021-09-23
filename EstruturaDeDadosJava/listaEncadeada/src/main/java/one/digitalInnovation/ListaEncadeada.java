package one.digitalInnovation;

public class ListaEncadeada<T> {

    private No<T> referenciaEntrada;

    public ListaEncadeada() {
        referenciaEntrada = null;
    }
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if (isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }
        No<T> noAux = referenciaEntrada;
        for (int i=1; i<this.size(); i++){
            noAux = noAux.getProximoNo();
        }
        noAux.setProximoNo(novoNo);
    }
    private void validaIndice(int index){
        if(index >= size()){
            int ultimoIndice = size()-1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no índice " +
                    index + " desta lista. Índice máximo: " + ultimoIndice);
        }
    }
    public T get(int index){
        return getNo(index).getConteudo();
    }
    private No<T> getNo(int index){
        validaIndice(index);
        No<T> noAux = referenciaEntrada;
        No<T> noRetorno = null;
        for (int i=0; i<=index; i++){
            noRetorno = noAux;
            noAux = noAux.getProximoNo();
        }
        return noRetorno;
    }
    public T remove(int index){
        No<T> noPivo = getNo(index);
        if (index == 0){
            referenciaEntrada = noPivo.getProximoNo();
            return noPivo.getConteudo();
        }
        No<T> noAnterior = getNo(index-1);
        noAnterior.setProximoNo(noPivo.getProximoNo());
        return noPivo.getConteudo();
    }
    public int size(){
        int tamanhoLista = 0;
        No<T> referenciaAux = referenciaEntrada;
        while (referenciaAux != null){
            tamanhoLista++;
            referenciaAux = referenciaAux.getProximoNo();
        }
        return tamanhoLista;
    }
    public boolean isEmpty(){
        return referenciaEntrada == null;
    }

    @Override
    public String toString() {
        return referenciaEntrada.toStringEncadeado();
    }
}
