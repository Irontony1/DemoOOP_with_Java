package Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventLogger implements ILogger {
    String path;
    public EventLogger(String path) {
        this.path = path;
    }

    @Override
    public void createEvent(String event) {
        StringBuilder sb = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        Date date = new Date();
        try (FileWriter writer = new FileWriter(path,false)) {
            sb.append(dateFormat.format(date)).append("\t");
            sb.append(event).append("\n");
            writer.append(sb);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

