package Server;

import java.io.Serializable;
import java.net.Socket;

public class Player{
    Socket socket;
    String name;
    int points;
    String currentPlayer;

    public Socket getSocket() {
        return socket;
    }

    public Player(String n, Socket socket, String currentPlayer){
        this.socket = socket;
        this.name = n;
        this.points = 0;
        this.currentPlayer = currentPlayer;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPoints()
    {
        return points;
    }

    public void setPoints(int points)
    {
        this.points = points;
    }

    public String isCurrentPlayer()
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(String cPlayer)
    {
        currentPlayer = cPlayer;
    }
}
