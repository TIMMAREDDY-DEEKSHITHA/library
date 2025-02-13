//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class LibrarySerializer {
    public LibrarySerializer() {
    }

    public void saveLibrary(List<Book> books, String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));

            try {
                oos.writeObject(books);
            } catch (Throwable var7) {
                try {
                    oos.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            oos.close();
        } catch (IOException var8) {
            IOException e = var8;
            e.printStackTrace();
        }

    }

    public List<Book> loadLibrary(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.length() != 0L) {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));

                List var4;
                try {
                    var4 = (List)ois.readObject();
                } catch (Throwable var7) {
                    try {
                        ois.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }

                    throw var7;
                }

                ois.close();
                return var4;
            } catch (EOFException var8) {
                System.err.println("The file is empty or corrupted: " + fileName);
                return null;
            } catch (ClassNotFoundException | IOException var9) {
                Exception e = var9;
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }
}
