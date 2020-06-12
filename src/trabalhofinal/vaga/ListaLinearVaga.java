package trabalhofinal.vaga;

public class ListaLinearVaga {
    private ElementoVaga primeiro;
    private ElementoVaga ultimo;

    public ListaLinearVaga() {
        primeiro = new ElementoVaga();
        ultimo = primeiro;
    }

    public Boolean vazia() {
        if (this.primeiro == this.ultimo)
            return true;
        else
            return false;
    }

    public void inserir(ElementoVaga vagaNova) {
        this.ultimo.prox = vagaNova;
        this.ultimo = vagaNova;
    }

    public ElementoVaga pesquisar(String idVaga) {
        if (this.vazia())
            return null;
        else {
            ElementoVaga aux = this.primeiro.prox;

            while (aux != null) {
                if (aux.elemento.idvaga.equals(idVaga)) {
                    return aux;
                } else
                    aux = aux.prox;
            }
            return aux;
        }
    }

    public void imprimir() {
        if (this.vazia())
            System.out.println("A lista está vazia.");
        else {
            ElementoVaga aux = this.primeiro.prox;
            while (aux != null) {
                aux.elemento.listarUsoTotal();
                aux = aux.prox;
            }
        }
    }
}