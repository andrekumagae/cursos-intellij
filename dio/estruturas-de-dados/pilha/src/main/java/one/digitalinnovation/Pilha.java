package one.digitalinnovation;

public class Pilha {
    private No referenciaDaPilha;

    public Pilha() {
        this.referenciaDaPilha = null;
    }

    public boolean isEmpty() {
        return referenciaDaPilha == null;
    }

    public No top() {
        return referenciaDaPilha;
    }

    public void push(No novoNo) {
//        Aqui criamos um Nó auxiliar para guardar o int e a referência de No do topo da nossa pilha
        No noAuxiliar = referenciaDaPilha;
//        Guardamos o valor do parâmetro int a este nó auxiliar e resetamos a referência, pois novoNo tem valor
//        de referência null
        referenciaDaPilha = novoNo;
//        Usamos o setter para aplicarmos a nossa referência de topo que guardamos na primeira linha
        referenciaDaPilha.setReferenciaDeNo(noAuxiliar);
    }

    public No pop() {
        if (!isEmpty()) {
            No noRetirado = referenciaDaPilha;
            referenciaDaPilha = referenciaDaPilha.getReferenciaDeNo();
            return noRetirado;
        }
        return null;
    }

    @Override
    public String toString() {
        String stringRetorno = "--------------\n";
        stringRetorno += "\tPilha\t\n";
        stringRetorno += "--------------\n";
        No noAuxiliar = referenciaDaPilha;
        while (true) {
            if (noAuxiliar != null) {
                stringRetorno += "[No{dado=" + noAuxiliar.getDado() + "}]\n";
                noAuxiliar = noAuxiliar.getReferenciaDeNo();
            } else {
                break;
            }
        }
        stringRetorno += "==============\n";
        return stringRetorno;
    }

}
