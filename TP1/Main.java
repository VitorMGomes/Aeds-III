
import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Main {

    public static void main(String args[]) {
        Serie s1 = new Serie(0, "Senhor dos Aneis", "11/9/2004", "hahaha", "Amazon Prime");

        Serie s2 = new Serie(1, "Hellsing", "13/11/2024", "pepopapa", "Netflix");

        System.out.println(s1);
        System.out.println(s2);

        FileOutputStream arq;
        DataOutputStream dos;

        try {
            arq = new FileOutputStream("dados/livros.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
