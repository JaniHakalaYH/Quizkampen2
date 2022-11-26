package Server;

import java.io.Serializable;
import java.net.Socket;

public class Player {
    Socket socket;
    String name;
    int points;
    boolean isFirstPlayer;

    public Socket getSocket() {
        return socket;
    }

    public Player(String n, Socket socket, Boolean isFirstPlayer){
        this.socket = socket;
        this.name = n;
        this.points = 0;
        this.isFirstPlayer = isFirstPlayer();
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

    public boolean isFirstPlayer()
    {
        return isFirstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer)
    {
        isFirstPlayer = firstPlayer;
    }
}
