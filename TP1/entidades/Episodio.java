package entidades;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.time.LocalDate;

public class Episodio{

    protected int IDEpisodio;
    protected int IDserie;
    protected String Nome;
    protected int Temporada;
    protected LocalDate DataLancamento;
    protected int Duracao;



    //construtor FULL
    public Episodio(int i, int is, String n, int t, LocalDate dl, int d)
    {
        IDEpisodio = i;
        IDserie = is;
        Nome = n;
        Temporada = t;
        DataLancamento = dl;
        Duracao = d;
    }

    //construtor Vazio
    public Episodio()
    {
        IDEpisodio = -1;
        IDserie = -1;
        Nome = "";
        Temporada = -1;
        DataLancamento = LocalDate.now();
        Duracao = -1;
    }

    //construtor missing ID
    public Episodio(int is, String n, int t, LocalDate dl, int d)
    {
        IDEpisodio = -1;
        IDserie = is;
        Nome = n;
        Temporada = t;
        DataLancamento = dl;
        Duracao = d;
    }

    public String toString()
    {
        return  "\nID: " + IDEpisodio +
                "\nNome do Episodio: " + Nome +
                "\nTemporada: " + Temporada +
                "\nData de lançamento: " + DataLancamento +
                "\nDuração do Episodio:" + Duracao;

    }


    public byte[] toByteArray() throws Exception{
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        
        dos.writeInt(IDEpisodio);
        dos.writeInt(IDserie);
        dos.writeUTF(Nome);
        dos.writeInt(Temporada);
        dos.writeInt((int) DataLancamento.toEpochDay());
        dos.writeInt(Duracao);
        

        return baos.toByteArray();
    }

    public void fromByteArray(byte[] ba) throws Exception{

        ByteArrayInputStream bais = new ByteArrayInputStream(ba);
        DataInputStream dis = new DataInputStream(bais);

        IDEpisodio = dis.readInt();
        IDserie = dis.readInt();
        Nome = dis.readUTF();
        Temporada = dis.readInt();
        DataLancamento = LocalDate.ofEpochDay(dis.readInt());
        Duracao = dis.readInt();
    }


}
