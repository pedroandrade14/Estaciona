package trabalhofinal.uso;

public class HistoricoMes {
    public ListaUso dias[];

    public HistoricoMes(){
        this.dias = new ListaUso[32];

        for (int i = 0; i < dias.length; i++) {
            this.dias[i] = new ListaUso();
        }
    }  
}