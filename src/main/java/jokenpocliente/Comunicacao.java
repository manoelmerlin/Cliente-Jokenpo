package jokenpocliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Comunicacao {

    Socket socket;
    BufferedReader out;
    PrintWriter in;

    public Comunicacao(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.in = new PrintWriter(socket.getOutputStream(), true);
    }

    public String ReceberMsg() throws IOException {
        return out.readLine();
    }

    public void EnviarMsg(String msg) {
        in.println(msg);
    }
}
