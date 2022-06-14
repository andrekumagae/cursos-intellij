package one.dio;

public class ListaEncadeada<T> {
    private No<T> referenciaDeEntrada;

    public ListaEncadeada() {
        this.referenciaDeEntrada = null;
    }

    public boolean isEmpty() {
        return referenciaDeEntrada == null;
    }

    public void add(T conteudo) {
        No novoNo = new No(conteudo);
        if (isEmpty()) {
            referenciaDeEntrada = novoNo;
            return;
        }
        No<T> noAuxiliar = referenciaDeEntrada;
        for (int i = 0; i < size() - 1; i++) {
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        noAuxiliar.setProximoNo(novoNo);
    }

    private void validaIndice(int indice) {
        if (indice >= size()) {
            int ultimoIndice = size() - 1;
            throw new IndexOutOfBoundsException("Não existe conteúdo no indíce " + indice + " desta lista. Esta lista só" +
                    " vai até o índice " + ultimoIndice + ".");
        }
    }

    private No<T> getNo(int indice) {
        validaIndice(indice);
        No<T> noAuxiliar = referenciaDeEntrada;
        No<T> noRetorno = null;
        for (int i = 0; i <= indice; i++) {
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        return noRetorno;
    }

    public T get(int indice) {
        return getNo(indice).getConteudo();
    }

    public T remove(int indice) {
        No<T> noPivot = getNo(indice);
        if (indice == 0) {
            referenciaDeEntrada = noPivot.getProximoNo();
            return noPivot.getConteudo();
        }
        No<T> noAnterior = getNo(indice - 1);
        noAnterior.setProximoNo(noPivot.getProximoNo());
        return noPivot.getConteudo();
    }


    public int size() {
        int tamanhoLista = 0;
        No<T> referenciaAuxiliar = referenciaDeEntrada;
        while (true) {
            if (referenciaAuxiliar != null) {
                tamanhoLista++;
                if (referenciaAuxiliar.getProximoNo() != null) {
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo();
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return tamanhoLista;
    }

    @Override
    public String toString() {
        String stringDeRetorno = "";
        No<T> noAuxiliar = referenciaDeEntrada;
        for (int i = 0; i < size(); i++) {
            stringDeRetorno += "[No{conteúdo=" + noAuxiliar.getConteudo() + "}-->";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        stringDeRetorno += "null";
        return stringDeRetorno;
    }

}
