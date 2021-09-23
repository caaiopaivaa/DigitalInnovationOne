package one.digitalinnovation;

public class Fila<T> {

    private No<T> refNoFimFila;

    public Fila() {
        this.refNoFimFila = null;
    }

    public boolean isEmpty(){
        return refNoFimFila == null;
    }

    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoFimFila);
        refNoFimFila = novoNo;
    }

    public T first(){
        if(!isEmpty()){
            No primeiroNo = refNoFimFila;
            while(true){
                if (primeiroNo.getRefNo() != null){
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }
            }
            return (T) primeiroNo.getObject();
        }
        return null;
    }
    public T dequeue(){
        if(!isEmpty()){
            No primeiroNo = refNoFimFila;
            No noAux = refNoFimFila;
            while(true){
                if (primeiroNo.getRefNo() != null){
                    noAux = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAux.setRefNo(null);
                    break;
                }
            }
            return (T)primeiroNo.getObject();
        }
        return null;
    }

    @Override
    public String toString() {
        String stringRetorno = "";

        No noAux = refNoFimFila;
        while(noAux != null){
            stringRetorno += noAux.toString() + "\n";
            noAux = noAux.getRefNo();
        }
        return stringRetorno == "" ? "null" : stringRetorno;
    }
}
