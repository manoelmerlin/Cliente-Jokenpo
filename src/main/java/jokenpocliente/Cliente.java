package jokenpocliente;

import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Socket socket = null;
        Scanner entrada = new Scanner(System.in);

        try {
            String msgDoServer;
            String msgDoCliente;
            Boolean pvp = false;
            socket = new Socket("localhost", 8081);
            System.out.println("Bem vindo para sair a qualquer momento digite 10");
            Comunicacao comunicacao = new Comunicacao(socket);
            msgDoServer = comunicacao.ReceberMsg();
    
            System.out.println(msgDoServer);
            while (true) {
                msgDoCliente = entrada.nextLine();
                comunicacao.EnviarMsg(msgDoCliente);

                if (msgDoCliente.equals("10")) {
                    System.out.println("Saindo.....");
                    socket.close();
                }

                if (pvp) {
                    System.out.println("Aguarde o outro jogador");
                } else {
                    System.out.println("Aguarde..");
                }     

                System.out.println(comunicacao.ReceberMsg());
            }
        } catch (Exception e) {
            System.out.println("Desconectado do jogo...");
        }
    }
}
