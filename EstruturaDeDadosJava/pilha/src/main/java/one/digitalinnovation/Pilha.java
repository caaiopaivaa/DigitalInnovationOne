package one.digitalinnovation;

public class Pilha {

    private No refNoTopo;

    public Pilha() {
        this.refNoTopo = null;
    }
    public void push(No novoNo){
        No refAuxiliar = refNoTopo;
        refNoTopo=novoNo;
        refNoTopo.setRefNo(refAuxiliar);
    }
    public No pop(){
        if(!isEmpty()){
            No noPoped = refNoTopo;
            refNoTopo = refNoTopo.getRefNo();
            return noPoped;
        }
        return null;
    }
    public No top(){
        return refNoTopo;
    }
    public boolean isEmpty(){
        return refNoTopo == null;
    }

    @Override
    public String toString(){
        String stringRetorno = "---------------\n";
        stringRetorno += "     Pilha\n";
        stringRetorno += "---------------\n";

        No noAuxiliar = refNoTopo;

        while (true){
            if(noAuxiliar != null){
                stringRetorno += noAuxiliar.toString() + "\n";
                noAuxiliar = noAuxiliar.getRefNo();
            }else{
                break;
            }
        }
        stringRetorno += "===============";
        return stringRetorno;
    }
}
