public class OrdenarPorAnoDeNascimentoComQuickSort implements Ordenador {
    public void ordenar(ColecaoConsumidor colecao) {
        quickSort(colecao, 0, colecao.obterTotalDeConsumidores() - 1);
    }

    private void quickSort(ColecaoConsumidor colecao, int inicio, int fim) {
        if (inicio < fim) {
            int pi = particionar(colecao, inicio, fim);
            quickSort(colecao, inicio, pi - 1);
            quickSort(colecao, pi + 1, fim);
        }
    }

    private int particionar(ColecaoConsumidor colecao, int inicio, int fim) {
        int pivo = colecao.obterConsumidor(fim).getAnoNascimento();
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            Consumidor cj = colecao.obterConsumidor(j);
            if (cj != null && cj.getAnoNascimento() <= pivo) {
                i++;
                colecao.trocarPosicaoEntreConsumidores(i, j);
            }
        }
        colecao.trocarPosicaoEntreConsumidores(i + 1, fim);
        return i + 1;
    }
}