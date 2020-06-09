package trabalhofinal.uso;

import java.util.Random;
import java.util.Date;

public class Uso {
    int idUso;
    String placa;
    String idVaga;
    Date horaEntrada;
    Date horaSaida;
    Double valor;

    public Uso(){
        this.idUso = 0;
        this.placa = "XXXX";
        this.idVaga = "0";
        this.horaEntrada = null;
        this.horaSaida = null;
        this.valor = null;
    }

    public Uso(String p, String v, Date entrada, Date saida) {
        this.idUso = Random.class.hashCode();
        this.placa = p;
        this.idVaga = v;
        this.horaEntrada = entrada;
        this.horaSaida = saida;

        //Gerando valor aleatório para o valor do Uso
        Random random = new Random();
        this.valor = random.nextDouble() * 10;
    }
}
