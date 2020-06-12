package trabalhofinal.vaga;

import java.util.Date;
import java.util.Calendar;

import trabalhofinal.uso.HistoricoMes;
import trabalhofinal.uso.Uso;

public class Vaga {

    public int idEstacionamento;
    public String idvaga;
    public HistoricoMes historicoMeses[];

    public Vaga() {
        this.idEstacionamento = 0;
        this.idvaga = "";
    }

    public Vaga(int estacionamento, String vaga) {
        this.idEstacionamento = estacionamento;
        this.idvaga = vaga;
        this.historicoMeses = new HistoricoMes[12];

        for (int i = 0; i < historicoMeses.length; i++) {
            historicoMeses[i] = new HistoricoMes();
        }
    }

    public void InserirUso(Uso uso) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(uso.horaEntrada);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);

        this.historicoMeses[month].dias[day].adicionaFinal(uso);
    }

    public void listarUsoTotal() {
        System.out.println("Histórico de Entrada e Saídas");
        for (int i = 0; i < historicoMeses.length; i++) {
            for (int j = 0; j < historicoMeses[i].dias.length; j++) {
                System.out.println(historicoMeses[i].dias[j].listaFormatada());
            }
        }
    }
}
