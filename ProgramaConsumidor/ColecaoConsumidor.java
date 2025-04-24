public interface ColecaoConsumidor {
    void adicionarConsumidor(Consumidor consumidor);
    void excluirConsumidor(String nomeDoConsumidor);
    Consumidor obterConsumidor(int posicao);
    int obterTotalDeConsumidores();
    void trocarPosicaoEntreConsumidores(int posicao1, int posicao2);
    void alterarConsumidor(int posicao, Consumidor novoConsumidor);
    void ordenarConsumidores(Ordenador ordenador);
}
