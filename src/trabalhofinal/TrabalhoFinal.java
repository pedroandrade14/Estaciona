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

    public static void leituraUso(String nomeArquivoEntrada, HashCarros hashCarros)
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
                contador += 1;
            }
            leitor.close();
            System.out.println("Usos inseridos na HashCarros: " + contador);
        } else {
            System.out.println("O arquivo " + nomeArquivoEntrada + " não existe");
        }
    }

    /*
     * public static HashUso leituraUso(String nomeArquivoEntrada) throws
     * FileNotFoundException{
     * 
     * }
     */

    public static void main(String[] args) throws Exception {
        HashCarros carros = new HashCarros(1000);
        carros = leituraCarros("/home/usuario/Documents/aed/ti/dados/carros.txt", carros);

        leituraUso("/home/usuario/Documents/aed/ti/dados/usos.txt", carros);
    }
}
