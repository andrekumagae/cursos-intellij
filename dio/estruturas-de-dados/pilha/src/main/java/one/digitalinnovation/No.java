package one.digitalinnovation;

public class No {
    private int dado;
    private No referenciaDeNo = null;

    public No() {
    }

    public No(int dado) {
        this.dado = dado;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getReferenciaDeNo() {
        return referenciaDeNo;
    }

    public void setReferenciaDeNo(No referenciaDeNo) {
        this.referenciaDeNo = referenciaDeNo;
    }

    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }
}
