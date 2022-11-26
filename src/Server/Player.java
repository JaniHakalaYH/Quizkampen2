package Server;

import java.io.Serializable;
import java.net.Socket;

public class Player{
    Socket socket;
    String name;
    int points;
    boolean currentPlayer;

    public Socket getSocket() {
        return socket;
    }

    public Player(String n, Socket socket, Boolean firstPlayer){
        this.socket = socket;
        this.name = n;
        this.points = 0;
        this.currentPlayer = firstPlayer;
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

    public boolean isCurrentPlayer()
    {
        return currentPlayer;
    }

    public void setCurrentPlayer(boolean cPlayer)
    {
        currentPlayer = cPlayer;
    }
}
