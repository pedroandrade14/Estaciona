package trabalhofinal;

import trabalhofinal.carro.*;
import trabalhofinal.uso.*;
import trabalhofinal.vaga.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TrabalhoFinal {

    public static HashCarros leituraCarros(String nomeArquivoEntrada, HashCarros hashCarros)
            throws FileNotFoundException {
        File arquivoLeitura = new File(nomeArquivoEntrada);
        Scanner leitor = new Scanner(arquivoLeitura);
        String s;
        String[] dadosCarro;

        if (arquivoLeitura.exists()) {
            while (leitor.hasNextLine()) {
                s = leitor.nextLine();
                dadosCarro = s.split(";");
                Carro carro = new Carro(dadosCarro[0]);
                hashCarros.inserir(carro);
            }
            leitor.close();
        } else {
            System.out.println("O arquivo " + nomeArquivoEntrada + " não existe");
        }
        return hashCarros;
    }

    public static void leituraUso(String nomeArquivoEntrada, HashCarros hashCarros, HashVagas hashVagas)
            throws FileNotFoundException, ParseException {
        File arquivoLeitura = new File(nomeArquivoEntrada);
        Scanner leitor = new Scanner(arquivoLeitura);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");

        if (arquivoLeitura.exists()) {
            int contador = 0;
            String s;
            String[] dadosUso;
            Date entrada;
            Date saida;
            String idVaga;
            String placa;

            while (leitor.hasNextLine()) {
                s = leitor.nextLine();
                dadosUso = s.split(";"); // [0] - Placa , [1] - Vaga, [2] - Data Entrada, [3] - Data Saida

                entrada = dateFormat.parse(dadosUso[2]);
                saida = dateFormat.parse(dadosUso[3]);
                idVaga = dadosUso[1];
                placa = dadosUso[0];

                Carro c = hashCarros.pesquisar(placa);
                c.AdicionarUso(idVaga, entrada, saida);

                Uso uso = new Uso(placa, idVaga, entrada, saida);
                Vaga v = hashVagas.pesquisar(idVaga);
                v.InserirUso(uso);
                
                contador += 1;
            }
            leitor.close();
            System.out.println("Usos inseridos na HashCarros: " + contador);
        } else {
            System.out.println("O arquivo " + nomeArquivoEntrada + " não existe");
        }
    }

    public static HashVagas leituraVagas(String nomeArquivoEntrada) throws FileNotFoundException {
        HashVagas hash = new HashVagas(500);
        File arquivoLeitura = new File(nomeArquivoEntrada);
        Scanner leitor = new Scanner(arquivoLeitura);

        if (arquivoLeitura.exists()) {
            String s;
            String[] dadosVaga;
            String idVaga;
            int idEstacionamento;

            while (leitor.hasNextLine()) {
                s = leitor.nextLine();
                dadosVaga = s.split(";");

                idVaga = dadosVaga[0];
                idEstacionamento = Integer.parseInt(dadosVaga[1]);

                Vaga v1 = new Vaga(idEstacionamento, idVaga);

                hash.inserir(v1);
            }
            leitor.close();
        } else {
            System.out.println("O arquivo " + nomeArquivoEntrada + " não existe");
        }
        return hash;
    }

    public static void main(String[] args) throws Exception {
        HashCarros carros = new HashCarros(1000);
        carros = leituraCarros("/home/usuario/Documents/aed/ti/dados/carros.txt", carros);
        HashVagas vagas = leituraVagas("/home/usuario/Documents/aed/ti/dados/vagas.txt");
        leituraUso("/home/usuario/Documents/aed/ti/dados/usos.txt", carros, vagas);

        String placa = "PUC-2947";
        Carro c1 = carros.pesquisar(placa);
        int qtdUso = c1.qtdUso();
        System.out.println("O carro de placa " + placa + " estacionou " + qtdUso + " vezes");
        c1.imprimirUsos();
        double total = c1.totalUso();
        System.out.println(
                "O valor total do uso do carro de placa " + placa + " foi de R$" + String.format("%.2f", total));


        String vaga = "E120";
        Vaga v1 = vagas.pesquisar(vaga);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dataInicio = dateFormat.parse("12/06/2012");
        Date dataFim = dateFormat.parse("20/08/2015");

        //v1.listarUso(dataInicio, dataFim);

        vagas.listarHistorico();


        

        System.out.println('x');

    }
}
