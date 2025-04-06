
import java.io.RandomAccessFile;

import entidades.Serie;


public class Main {

    public static void main(String args[]) {

        Serie s1 = new Serie(0, "Senhor dos Aneis", "11/9/2004", "hahaha", "Amazon Prime");
        Serie s2 = new Serie(1, "Hellsing", "13/11/2024", "pepopapa", "Netflix");

        //System.out.println(s1);
        //System.out.println(s2);

        RandomAccessFile arq;


        byte[] ba;

        try {
            arq = new RandomAccessFile("dados/series.db", "rw");

            long p1 = arq.getFilePointer();
            ba = s1.toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);

            long p2 = arq.getFilePointer();
            ba = s2.toByteArray();
            arq.writeInt(ba.length);
            arq.write(ba);

            //------------------------------------------

            Serie s3 = new Serie();
            Serie s4 = new Serie();
            int tam;

            arq.seek(p1);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            s3.fromByteArray(ba);

            arq.seek(p2);
            tam = arq.readInt();
            ba = new byte[tam];
            arq.read(ba);
            s4.fromByteArray(ba);

            System.out.println(s3);
            System.out.println(s4);

            arq.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
