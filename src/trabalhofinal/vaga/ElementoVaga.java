package trabalhofinal.vaga;

public class ElementoVaga {
    public Vaga elemento;
    public ElementoVaga prox;

    public ElementoVaga(){
        this.elemento = new Vaga();
        this.prox = null;
    }

    public ElementoVaga(Vaga elm) {
        this.elemento = elm;
        this.prox = null;
    }
}