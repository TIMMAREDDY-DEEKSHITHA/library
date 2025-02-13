//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserInteractionLogger {
    private static final String LOG_FILE = "resources/data/user_interactions.log";

    public UserInteractionLogger() {
    }

    public void logSearch(String searchTerm) {
        this.log("Search for: " + searchTerm);
    }

    public void logSort(String sortCriteria) {
        this.log("Sorted by: " + sortCriteria);
    }

    public void logViewAllBooks() {
        this.log("Viewed all books");
    }

    private void log(String message) {
        try {
            FileWriter fw = new FileWriter("resources/data/user_interactions.log", true);

            try {
                String var10001 = String.valueOf(LocalDateTime.now());
                fw.write(var10001 + " - " + message + "\n");
            } catch (Throwable var6) {
                try {
                    fw.close();
                } catch (Throwable var5) {
                    var6.addSuppressed(var5);
                }

                throw var6;
            }

            fw.close();
        } catch (IOException var7) {
            IOException e = var7;
            e.printStackTrace();
        }

    }
}
