

class Serie {
    
    protected int IdSerie;
    protected String Nome;
    protected String AnoLancamento;
    //protected Date AnoLancamento;
    protected String Sinopse;
    protected String Streaming;



    public Serie(int i, String n, String a, String si, String st)
    {
        IdSerie = i;
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


}
