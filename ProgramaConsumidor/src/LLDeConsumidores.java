public class LLDeConsumidores implements ColecaoConsumidor {

    private class Node {
        Consumidor consumidor;
        Node next;

        Node(Consumidor consumidor) {
            this.consumidor = consumidor;
            this.next = null;
        }
    }

    private Node head;
    private int length;

    public LLDeConsumidores() {
        head = null;
        length = 0;
    }

    public void adicionarConsumidor(Consumidor consumidor) {
        Node newNode = new Node(consumidor);
        if (head == null) {
            head = newNode;
        } else {
            Node atual = head;
            while (atual.next != null) {
                atual = atual.next;
            }
            atual.next = newNode;
        }
        length++;
    }

    public void excluirConsumidor(String id) {
        if (head == null) return;

        if (String.valueOf(head.consumidor.getId()).equals(id)) {
            head = head.next;
            length--;
            return;
        }

        Node atual = head;
        while (atual.next != null && 
               !String.valueOf(atual.next.consumidor.getId()).equals(id)) {
            atual = atual.next;
        }

        if (atual.next != null) {
            atual.next = atual.next.next;
            length--;
        }
    }

    public Consumidor obterConsumidor(int posicao) {
        if (posicao < 0 || posicao >= length) return null;

        Node atual = head;
        for (int i = 0; i < posicao; i++) {
            atual = atual.next;
        }

        return atual.consumidor;
    }

    public int obterTotalDeConsumidores() {
        return length;
    }

    public void trocarPosicaoEntreConsumidores(int i, int j) {
        if (i < 0 || j < 0 || i >= length || j >= length || i == j) return;

        Node NodeI = head, NodeJ = head;
        for (int x = 0; x < i; x++) NodeI = NodeI.next;
        for (int x = 0; x < j; x++) NodeJ = NodeJ.next;

        Consumidor temp = NodeI.consumidor;
        NodeI.consumidor = NodeJ.consumidor;
        NodeJ.consumidor = temp;
    }

    public void alterarConsumidor(int posicao, Consumidor novoConsumidor) {
        if (posicao < 0 || posicao >= length) return;

        Node atual = head;
        for (int i = 0; i < posicao; i++) {
            atual = atual.next;
        }
        atual.consumidor = novoConsumidor;
    }

    public void ordenarConsumidores(Ordenador ordenador) {
        ordenador.ordenar(this);
    }
}
