public class LLDeConsumidores implements ColecaoConsumidor {

    private class No {
        Consumidor consumidor;
        No proximo;

        No(Consumidor consumidor) {
            this.consumidor = consumidor;
            this.proximo = null;
        }
    }

    private No inicio;
    private int tamanho;

    public LLDeConsumidores() {
        inicio = null;
        tamanho = 0;
    }

    public void adicionarConsumidor(Consumidor consumidor) {
        No novo = new No(consumidor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    public void excluirConsumidor(String nome) {
        if (inicio == null) return;

        if (inicio.consumidor.getEscolaridade().equalsIgnoreCase(nome)) {
            inicio = inicio.proximo;
            tamanho--;
            return;
        }

        No atual = inicio;
        while (atual.proximo != null && 
               !atual.proximo.consumidor.getEscolaridade().equalsIgnoreCase(nome)) {
            atual = atual.proximo;
        }

        if (atual.proximo != null) {
            atual.proximo = atual.proximo.proximo;
            tamanho--;
        }
    }

    public Consumidor obterConsumidor(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return null;

        No atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }

        return atual.consumidor;
    }

    public int obterTotalDeConsumidores() {
        return tamanho;
    }

    public void trocarPosicaoEntreConsumidores(int i, int j) {
        if (i < 0 || j < 0 || i >= tamanho || j >= tamanho || i == j) return;

        No noI = inicio, noJ = inicio;
        for (int x = 0; x < i; x++) noI = noI.proximo;
        for (int x = 0; x < j; x++) noJ = noJ.proximo;

        Consumidor temp = noI.consumidor;
        noI.consumidor = noJ.consumidor;
        noJ.consumidor = temp;
    }

    public void alterarConsumidor(int posicao, Consumidor novoConsumidor) {
        if (posicao < 0 || posicao >= tamanho) return;

        No atual = inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        atual.consumidor = novoConsumidor;
    }

    public void ordenarConsumidores(Ordenador ordenador) {
        ordenador.ordenar(this);
    }
}
