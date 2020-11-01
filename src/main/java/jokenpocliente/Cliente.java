package jokenpocliente;

import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Socket socket = null;
        Scanner entrada = new Scanner(System.in);

        try {
            String msgDoServer;
            socket = new Socket("localhost", 8081);
            Comunicacao comunicacao = new Comunicacao(socket);
            msgDoServer = comunicacao.ReceberMsg();
            System.out.println(msgDoServer);
            String msgDoCliente;
            while (true) {
                msgDoCliente = entrada.nextLine();
                comunicacao.EnviarMsg(msgDoCliente);           
                System.out.println("Aguarde..");
                System.out.println(comunicacao.ReceberMsg());
            }
        } catch (Exception e) {
            System.out.println("Nao consegui resolver o host...");
        }
    }
}
