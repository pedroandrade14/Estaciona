package trabalhofinal.carro;

public class ListaLinearCarro {

    private ElementoCarro primeiro;
    private ElementoCarro ultimo;

    public ListaLinearCarro() {
        primeiro = new ElementoCarro();
        ultimo = primeiro;
    }

    public Boolean vazia() {
        if (this.primeiro == this.ultimo)
            return true;
        else
            return false;
    }

    public void inserir(ElementoCarro carroNovo) {
        this.ultimo.prox = carroNovo;
        this.ultimo = carroNovo;
    }

    public ElementoCarro pesquisar(String placa) {
        if (this.vazia())
            return null;
        else {
            ElementoCarro aux = this.primeiro.prox;

            while (aux != null) {
                if (aux.elemento.placa.equals(placa)) {
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
            ElementoCarro aux = this.primeiro.prox;
            while (aux != null) {
                // System.out.println("Nome do produto: " + aux.nome + " - Código de barras do
                // produto: "
                // + aux.codigoBarras + " - Preço unitário do produto: " + aux.precoUnitario);
                aux = aux.prox;
            }
        }
    }
}