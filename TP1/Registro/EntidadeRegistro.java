package Registro;

import java.io.IOException;

// Interface que forca a classe ter estas funcoes, para poder ser utilizada 
public interface EntidadeRegistro
{
    public void setID(int i);
    public int getID();
    public byte[] toByteArray() throws IOException;
    public void fromByteArray(byte[] b) throws IOException;
}