package trabalhofinal.uso;

public class ListaUso {
    ElementoUso primeiro;
    ElementoUso ultimo;

    public ListaUso() {
        primeiro = new ElementoUso();
        ultimo = primeiro;
    }

    public ElementoUso adicionaFinal(Uso novo) {
        ElementoUso elm = new ElementoUso(novo);
        ultimo.prox = elm;
        ultimo = elm;
        return ultimo;
    }

    public Boolean vazia() {
        if (this.primeiro == this.ultimo)
            return true;
        else
            return false;
    }

    public double totalUso() {
        double total = 0;

        if (this.vazia())
            return 0.0;
        else {
            ElementoUso aux = this.primeiro.prox;

            while (aux != null) {
                total += aux.elemento.valor;
                aux = aux.prox;
            }
            return total;
        }
    }

    public void valoresUso() {

        if (this.vazia())
            System.out.println("Lista de Usos vazia!");
        else {
            ElementoUso aux = this.primeiro.prox;
            String out = "";

            while (aux != null) {
                out = out + "R$ " + String.format("%.2f", aux.elemento.valor)+ '\n';
                System.out.println("Valores de uso do carro: "+ aux.elemento.placa +'\n' + out);
                aux = aux.prox;
            }
        }
    }

    public int contador(){
        if (this.vazia())
            return 0;
        else {
            int contador = 0;
            ElementoUso aux = this.primeiro.prox;

            while (aux != null) {
                contador++;
                aux = aux.prox;
            }
            return contador;
        }
    }
}
