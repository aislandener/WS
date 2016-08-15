package Testes;

import java.util.Date;

public class TesteDeData {

    public static void main(String[] args) {
        Date dataAtual = new Date();
        dataAtual.setDate(dataAtual.getDate() - 7);
        System.out.println(dataAtual);

    }
}
