package one.dio;

public class ListaDuplamenteEncadeada<T> {
    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public int size() {
        return tamanhoLista;
    }

    private NoDuplo<T> getNo(int indice) {
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; (i < indice) && (noAuxiliar != null); i++) {
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    public T get(int indice) {
        return this.getNo(indice).getConteudo();
    }

    public void add(T elemento) {
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
//        novoNo.setNoProximo(null);
        novoNo.setNoAnterior(ultimoNo);
        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }
        if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    public void add(int indice, T elemento) {
        NoDuplo<T> noAuxiliar = getNo(indice);
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        novoNo.setNoProximo(noAuxiliar);
        if (novoNo.getNoProximo() != null) {
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getNoProximo().setNoProximo(novoNo);
        }else{
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }
        if (indice == 0) {
            primeiroNo = novoNo;
        }else{
            novoNo.getNoAnterior().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }

    public void remove(int indice) {
        if (indice == 0) {
            primeiroNo = primeiroNo.getNoProximo();
            if (primeiroNo != null) {
                primeiroNo.setNoProximo(null);
            }
        }else{
            NoDuplo<T> noAuxiliar = getNo(indice);
            noAuxiliar.getNoAnterior().setNoProximo(noAuxiliar.getNoProximo());
            if (noAuxiliar != ultimoNo) {
                noAuxiliar.getNoProximo().setNoAnterior(noAuxiliar.getNoAnterior());
            }else{
                ultimoNo = noAuxiliar.getNoAnterior();
            }
        }
        tamanhoLista--;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() +"}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += "null";
        return strRetorno;
    }


}
