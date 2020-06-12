package trabalhofinal.vaga;

public class HashVagas {

    private int M;
    private ListaLinearVaga[] tabelaVagas;

    public HashVagas(int tamanho) {
        this.M = tamanho;
        this.tabelaVagas = new ListaLinearVaga[this.M];
        for (int i = 0; i < tabelaVagas.length; i++) {
            tabelaVagas[i] = new ListaLinearVaga();
        }
    }

    private int funcaoHash(String idvaga) {
        String numero = idvaga.substring(1);
        int chave = Integer.parseInt(numero);
        return chave % this.M;
    }

    public void inserir(Vaga vaga) {
        int idHash = this.funcaoHash(vaga.idvaga);
        ElementoVaga elm = new ElementoVaga(vaga);
        this.tabelaVagas[idHash].inserir(elm);
    }

    public Vaga pesquisar(String idVaga) {
        int idHash = this.funcaoHash(idVaga);
        ElementoVaga pesquisado = this.tabelaVagas[idHash].pesquisar(idVaga);
        if (pesquisado != null) {
            return pesquisado.elemento;
        }
        return null;
    }

    public void listarHistorico(){
        for (int i = 0; i < tabelaVagas.length; i++) {
            tabelaVagas[i].imprimir();
        }
    }
}