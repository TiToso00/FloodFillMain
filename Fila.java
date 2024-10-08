public class Fila<T> {
    private T[] elementos;
    private int capacidade;
    private int frente;
    private int tras;
    private int quantidade;

    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.elementos = (T[]) new Object[capacidade];
        this.frente = 0; 
        this.tras = -1;  
        this.quantidade = 0; 
    }

    public boolean estaVazia() {  // Renomeado para corresponder ao erro
        return quantidade == 0; 
    }

    public boolean cheia() {
        return quantidade == capacidade;
    }

    public void enfileirar(T item) {  // Renomeado para corresponder ao erro
        if (cheia()) {
            System.out.println("Fila está cheia!");
            return;
        }
        tras = (tras + 1) % capacidade; 
        elementos[tras] = item;
        quantidade++;
    }

    public T desenfileirar() {  // Renomeado para corresponder ao erro
        if (estaVazia()) {
            System.out.println("Fila está vazia!");
            return null;
        }
        T item = elementos[frente];
        frente = (frente + 1) % capacidade;
        quantidade--;
        return item;
    }

    public T primeiro() {
        if (estaVazia()) {
            System.out.println("Fila está vazia!");
            return null;
        }
        return elementos[frente]; 
    }

    public int tamanho() {
        return quantidade; 
    }
}
