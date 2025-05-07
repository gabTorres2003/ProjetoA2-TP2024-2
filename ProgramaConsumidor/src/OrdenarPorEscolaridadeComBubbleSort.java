public class OrdenarPorEscolaridadeComBubbleSort implements Ordenador {
    public void ordenar(ColecaoConsumidor colecao) {
        int n = colecao.obterTotalDeConsumidores();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                Consumidor c1 = colecao.obterConsumidor(j);
                Consumidor c2 = colecao.obterConsumidor(j + 1);
                if (c1 != null && c2 != null && c1.getEscolaridade().compareTo(c2.getEscolaridade()) > 0) {
                    colecao.trocarPosicaoEntreConsumidores(j, j + 1);
                }
            }
        }
    }
}