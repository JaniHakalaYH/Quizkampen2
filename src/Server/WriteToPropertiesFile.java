package Server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteToPropertiesFile {

    public static void main(String[] args) {

        try (OutputStream output = new FileOutputStream("src/main/resources/Game.properties")) {
            Properties properties = new Properties();
            properties.setProperty("numberOfRounds", "2");
            properties.setProperty("numberOfQuestionsPerRound", "1");

            properties.store(output, null);

            System.out.println(properties);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}

