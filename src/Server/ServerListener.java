package Server;

import Server.ServerQuestionLogic.Match;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerListener {
    public ServerListener() throws ClassNotFoundException {
        int port = 55553;
        try (ServerSocket serverSocket = new ServerSocket(port)){
            while(true) {
                Player player1 = new Player("Player 1", serverSocket.accept(), "yes");
                Player player2 = new Player("Player 2", serverSocket.accept(), "no");
                new Match(player1, player2);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws ClassNotFoundException {
        ServerListener sl = new ServerListener();
    }
}

