public abstract class MakhlukHidup
{
    protected String nama;

    public MakhlukHidup(String nama)
    {
        this.nama = nama;
    }

    public void tumbuh()
    {
        System.out.println(nama + " sedang mengalami pertumbuhan...");
    }

    public abstract void bernapas();
    
    public abstract void bergerak();
}
