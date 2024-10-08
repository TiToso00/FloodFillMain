public class Pilha<T> {
    private T[] itens;
    private int topo;
    private int limite;

    @SuppressWarnings("unchecked")
    public Pilha(int limite) {
        this.limite = limite;
        this.itens = (T[]) new Object[limite]; 
        this.topo = -1; 
    }

    public boolean estaVazia() {
        return topo == -1;
    }

    public boolean cheia() {
        return topo == limite - 1; 
    }

    public void empilhar(T item) {
        if (cheia()) {
            System.out.println("Pilha cheia!");
            return;
        }
        itens[++topo] = item; 
    }

    public T desempilhar() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return itens[topo--]; 
    }

    public T topo() {
        if (estaVazia()) {
            System.out.println("Pilha vazia!");
            return null;
        }
        return itens[topo]; 
    }

    public int tamanho() {
        return topo + 1; 
    }
}
