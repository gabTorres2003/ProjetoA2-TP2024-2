public class VetorDeConsumidores implements ColecaoConsumidor {
    private Consumidor[] consumidores;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 100;

    public VetorDeConsumidores() {
        consumidores = new Consumidor[CAPACIDADE_INICIAL];
        tamanho = 0;
    }

    public void adicionarConsumidor(Consumidor consumidor) {
        if (tamanho == consumidores.length) {
            redimensionar();
        }
        consumidores[tamanho++] = consumidor;
    }

    public void excluirConsumidor(String id) {
        for (int i = 0; i < tamanho; i++) {
            if (String.valueOf(consumidores[i].getId()).equals(id)) {
                for (int j = i; j < tamanho - 1; j++) {
                    consumidores[j] = consumidores[j + 1];
                }
                consumidores[--tamanho] = null;
                return;
            }
        }
    }

    public Consumidor obterConsumidor(int posicao) {
        if (posicao < 0 || posicao >= tamanho) return null;
        return consumidores[posicao];
    }

    public int obterTotalDeConsumidores() {
        return tamanho;
    }

    public void trocarPosicaoEntreConsumidores(int i, int j) {
        if (i < 0 || j < 0 || i >= tamanho || j >= tamanho || i == j) return;
        Consumidor temp = consumidores[i];
        consumidores[i] = consumidores[j];
        consumidores[j] = temp;
    }

    public void alterarConsumidor(int posicao, Consumidor novoConsumidor) {
        if (posicao < 0 || posicao >= tamanho) return;
        consumidores[posicao] = novoConsumidor;
    }

    public void ordenarConsumidores(Ordenador ordenador) {
        if (tamanho > 0) {
            ordenador.ordenar(this);
        }
    }

    private void redimensionar() {
        Consumidor[] novoArray = new Consumidor[consumidores.length * 2];
        System.arraycopy(consumidores, 0, novoArray, 0, tamanho);
        consumidores = novoArray;
    }
}