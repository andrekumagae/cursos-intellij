package one.digitalinnovation;

public class Main {
    public static void main(String[] args) {
        Pilha minhaPilha = new Pilha();
        for (int i = 1; i <= 6; i++) {
        minhaPilha.push(new No(i));
        }
        System.out.println(minhaPilha);
        System.out.println(minhaPilha.top());
        System.out.println(minhaPilha.pop());
        System.out.println(minhaPilha);
    }
}
