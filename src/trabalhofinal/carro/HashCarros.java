package trabalhofinal.carro;

public class HashCarros {
    private int M;
    private ListaLinearCarro[] tabelaCarros;

    public HashCarros(int tamanho) {
        this.M = tamanho;
        this.tabelaCarros = new ListaLinearCarro[this.M];
        for (int i = 0; i < tabelaCarros.length; i++) {
            tabelaCarros[i] = new ListaLinearCarro();
        }
    }

    private int funcaoHash(String placa) {
        String[] dadosPlaca = placa.split("-");
        int numero = Integer.parseInt(dadosPlaca[1]);
        return numero % this.M;
    }

    public void inserir(Carro carro) {
        int idHash = this.funcaoHash(carro.placa);
        ElementoCarro elm = new ElementoCarro(carro);
        this.tabelaCarros[idHash].inserir(elm);
    }

    public Carro pesquisar(String placa) {
        int idHash = this.funcaoHash(placa);
        ElementoCarro pesquisado = this.tabelaCarros[idHash].pesquisar(placa);
        if (pesquisado != null) {
            return pesquisado.elemento;
        }
        return null;
    }

    /*
    public void imprimir() {
        for (int i = 0; i < tabelaProdutos.length; i++) {
            System.out.println("Posição da Hash : " + i);
            this.tabelaProdutos[i].imprimir();
        }
    }
    */
}