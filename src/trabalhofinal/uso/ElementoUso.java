package trabalhofinal.uso;

public class ElementoUso {
    public Uso elemento;
    public ElementoUso prox;

    public ElementoUso(){
        this.elemento = new Uso();
        this.prox = null;
    }

    public ElementoUso(Uso elm) {
        this.elemento = elm;
        this.prox = null;
    }
}