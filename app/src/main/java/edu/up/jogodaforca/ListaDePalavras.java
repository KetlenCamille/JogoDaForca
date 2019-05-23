package edu.up.jogodaforca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Avell G1511 FIRE on 20/10/2016.
 */

public class ListaDePalavras {

    private static List<String> listaDePalavras = new ArrayList<String>() {
        {
            add("PARECER");
            add("FALAR");
            add("FICAR");
            add("OUVIR");
            add("ACHAR");
            add("DEIXAR");
            add("SAIR");
            add("CHEGAR");
            add("PASSAR");
            add("PEDIR");
            add("LER");
            add("ACABAR");
            add("SER");
            add("DIZER");
            add("TER");
            add("IR");
            add("ESTAR");
            add("FAZER");
            add("HAVER");
            add("PODER");
            add("VER");
            add("DAR");
            add("SABER");
            add("VIR");
            add("QUERER");
            add("COISA");
            add("CASA");
            add("TEMPO");
            add("VEZ");
            add("OLHO");
            add("DIA");
            add("HOMEM");
            add("MOCO");
            add("SENHOR");
            add("ANO");
            add("MAO");
            add("PALAVRA");
            add("FILHO");
            add("NOITE");
            add("CARTA");
            add("AMIGO");
            add("BEM");
            add("RUA");
            add("VIDA");
            add("HORA");
            add("CORACAO");
            add("PAI");
            add("PESSOA");
            add("MULHER");
            add("AMOR");
            add("VERDADE");
            add("IDEIA");
            add("MAE");
            add("MARIDO");
            add("ESPIRITO");
            add("VIUVO");
            add("ALMA");
            add("FIM");
            add("CABECA");
            add("NOME");
            add("PORTA");
            add("PE");
            add("RAZAO");
            add("PARTE");
            add("MODO");
            add("BOM");
            add("GRANDE");
            add("MELHOR");
            add("PROPRIO");
            add("VELHO");
            add("CERTO");
            add("ULTIMO");
            add("LONGO");
            add("NOVO");
            add("UNICO");
            add("ANTIGO");
            add("BELO");
            add("SEGUINTE");
            add("PRECISO");
            add("MEIO");
            add("NATURAL");
            add("MAIOR");
            add("TRISTE");
            add("BONITO");
            add("ABACATE");
            add("SIMPLES");
            add("MAU");
            add("verdadeiro");
            add("alegre");
            add("político");
            add("alto");
            add("PUBLICO");
            add("GRAVE");
            add("VIVO");
            add("CHEIO");
            add("FELIZ");
            add("POSSIVEL");
            add("RARO");
            add("CLARO");
            add("NECESSARIO");
            add("PEQUENO");
            add("IGUAL");
            add("FINO");
            add("IMPOSSIVEL");
            add("POBRE");
        }
    };

    public static String retornarPalavra() {
        Random r = new Random();
        int index = r.nextInt(104);
        return listaDePalavras.get(index);
    }

}
