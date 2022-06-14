package one.digitalinnovation;

import com.sun.source.tree.BreakTree;

public class Fila<T> {
    private No<T> referenciaDaFila;

    public Fila() {
        this.referenciaDaFila = null;
    }

    public boolean isEmpty() {
        return referenciaDaFila == null;
    }

    public void enqueue(T objeto) {
        No novoNo = new No(objeto);
        novoNo.setReferenciaDoNo(referenciaDaFila);
        referenciaDaFila = novoNo;
    }

    public T first() {
        if (!isEmpty()) {
            No primeiroNo = referenciaDaFila;
            while (true) {
                if (primeiroNo.getReferenciaDoNo() != null) {
                    primeiroNo = primeiroNo.getReferenciaDoNo();
                } else {
                    break;
                }
            }
            return (T) primeiroNo.getObjeto();
        }
        return null;
    }

    public T dequeue() {
        if (!isEmpty()) {
            No primeiroNo = referenciaDaFila;
            No noAuxiliar = referenciaDaFila;
            while (true) {
                if (primeiroNo.getReferenciaDoNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getReferenciaDoNo();
                } else {
                    noAuxiliar.setReferenciaDoNo(null);
                    break;
                }
            }
            return  (T) primeiroNo.getObjeto();
        }
        return null;
    }

    @Override
    public String toString() {
        String stringDeRetorno = "";
        No noAuxiliar = referenciaDaFila;
        if (referenciaDaFila != null) {
            while (true) {
                stringDeRetorno += "[No{objeto=" + noAuxiliar.getObjeto() + "}] ---> ";
                if (noAuxiliar.getReferenciaDoNo() != null) {
                    noAuxiliar = noAuxiliar.getReferenciaDoNo();
                } else {
                    stringDeRetorno += "null";
                    break;
                }
            }
        } else {
            stringDeRetorno += "null";
        }
        return stringDeRetorno;
    }
}
