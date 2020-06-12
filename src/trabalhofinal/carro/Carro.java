package trabalhofinal.carro;

import trabalhofinal.uso.*;

import java.util.Date;

public class Carro {

    public String placa;
    public ListaUso paradas;

    public Carro(){
        this.placa = "SENTINELA";
        this.paradas = new ListaUso();
    }

    public Carro(String placa) {
        this.placa = placa;
        this.paradas = new ListaUso();
    }

    public Uso AdicionarUso(String idVaga, Date horaEntrada, Date HoraSaida){
        Uso uso = new Uso(this.placa, idVaga, horaEntrada, HoraSaida);
        ElementoUso inserido = this.paradas.adicionaFinal(uso);
        return inserido.elemento;
    }

    public double totalUso() {
        return this.paradas.totalUso();
    }

    public void imprimirUsos(){
        this.paradas.valoresUso();
    }

    public int qtdUso(){
        return this.paradas.contador();
    }

}
