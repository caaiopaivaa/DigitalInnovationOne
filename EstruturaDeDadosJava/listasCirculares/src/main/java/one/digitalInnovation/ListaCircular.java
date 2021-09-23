package one.digitalInnovation;

public class ListaCircular<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.tamanhoLista = 0;
        this.cabeca = null;
        this.cauda = null;
    }

    public boolean isEmpty(){
        return tamanhoLista == 0;
    }
    public int size(){
        return this.tamanhoLista;
    }

    public void add(T elemento){
        No<T> novoNo = new No<>(elemento);
        if (this.tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        }else{
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }
    public T get(int index){
        return this.getNo(index).getConteudo();
    }
    private No<T> getNo(int index){
        if (isEmpty()){
            throw new IndexOutOfBoundsException("A lista está vazia");
        }
        if (index == 0) {
            return this.cauda;
        }
        No<T> noAux = this.cauda;
        for (int i=0; i< index; i++){
            noAux = noAux.getNoProximo();
        }
        return noAux;
    }
    public void remove (int index){
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException();
        No<T> noAux = this.cauda;
        if(index == 0){
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        }else if(index == 1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else{
            for (int i=0 ; i< index-1; i++){
                noAux = noAux.getNoProximo();
            }
            noAux.setNoProximo(noAux.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAux = this.cauda;
        for (int i=0 ; i< this.size(); i++){
            strRetorno += noAux.toString() + "->";
            noAux = noAux.getNoProximo();
        }
        strRetorno += !isEmpty() ? this.cauda.toString() : "[]";

        return strRetorno;

    }
}


















