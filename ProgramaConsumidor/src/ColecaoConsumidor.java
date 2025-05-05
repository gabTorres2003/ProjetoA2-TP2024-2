public interface ColecaoConsumidor {
    void adicionarConsumidor(Consumidor consumidor);
    void excluirConsumidor(String id);
    Consumidor obterConsumidor(int posicao);
    int obterTotalDeConsumidores();
    void trocarPosicaoEntreConsumidores(int i, int j);
    void alterarConsumidor(int posicao, Consumidor novoConsumidor);
}
