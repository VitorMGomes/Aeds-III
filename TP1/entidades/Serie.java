package entidades;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.time.LocalDate;

public class Serie {
    
    protected int IdSerie;
    protected String Nome;
    protected LocalDate AnoLancamento;
    protected String Sinopse;
    protected String Streaming;


    //construtor FULL
    public Serie(int i, String n, LocalDate a, String si, String st)
    {
        IdSerie = i;
        Nome = n;
        AnoLancamento = a;
        Sinopse = si;
        Streaming = st;
    }

    //construtor Vazio
    public Serie()
    {
        IdSerie = -1;
        Nome = "";
        AnoLancamento = LocalDate.now();
        Sinopse = "";
        Streaming = "";
    }

    //construtor missing ID
    public Serie(String n, LocalDate a, String si, String st)
    {
        IdSerie = -1;
        Nome = n;
        AnoLancamento = a;
        Sinopse = si;
        Streaming = st;

    }

    public String toString()
    {
        return  "\nID: " + IdSerie +
                "\nNome: " + Nome +
                "\nAno de Lançamento: " + AnoLancamento +
                "\nSinopse: " + Sinopse +
                "\nStreaming: " + Streaming;

    }

    public byte[] toByteArray() throws Exception{

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        
        dos.writeInt(IdSerie);
        dos.writeUTF(Nome);
        dos.writeInt( (int) this.AnoLancamento.toEpochDay());
        dos.writeUTF(Sinopse);
        dos.writeUTF(Streaming);

        return baos.toByteArray();
    }

    public void fromByteArray(byte[] ba) throws Exception{

        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        IdSerie = dis.readInt();
        Nome = dis.readUTF();
        AnoLancamento = LocalDate.ofEpochDay(dis.readInt());
        Sinopse = dis.readUTF();
        Streaming = dis.readUTF();
    }


}
