package one.digitalinnovation;

public class No<T> {
    private T objeto;
    private No<T> referenciaDoNo;

    public No() {
    }

    public No(T objeto) {
        this.objeto = objeto;
        this.referenciaDoNo = null;
    }

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public No getReferenciaDoNo() {
        return referenciaDoNo;
    }

    public void setReferenciaDoNo(No referenciaDoNo) {
        this.referenciaDoNo = referenciaDoNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "objeto=" + objeto +
                '}';
    }
}
