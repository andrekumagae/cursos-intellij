package one.dio;

import com.sun.source.tree.BreakTree;

public class ListaCircular<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cauda = null;
        this.cabeca = null;
        this.tamanhoLista = 0;
    }

    public boolean isEmpty() {
        return this.tamanhoLista == 0;
    }

    public int size() {
        return this.tamanhoLista;
    }

    private No<T> getNo(int indice) {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("A lista está vazia");
        } else if (indice == 0) {
            return this.cauda;
        } else {
            No<T> noAuxiliar = this.cauda;
            for (int i = 0; i < indice; i++) {
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            return noAuxiliar;
        }
    }

    public T get(int indice) {
        return this.getNo(indice).getConteudo();
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<>(conteudo);
        if (isEmpty()) {
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        } else {
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    public void remove(int indice) {
        if (indice >= this.tamanhoLista) {
            throw new IndexOutOfBoundsException("O indice é maior que a lista");
        }
        No<T> noAuxiliar = this.cauda;
        if (indice == 0) {
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        } else if (indice == 1) {
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        } else {
            for (int i = 0; i < indice - 1; i++) {
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;
    }

    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for (int i = 0; i < this.size(); i++) {
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return strRetorno += this.size() != 0 ? "(Retorna ao início)" : "[]";
    }
}
