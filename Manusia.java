public class Manusia extends MakhlukHidup
{
    public Manusia(String nama)
    {
        super(nama);
    }

    @Override
    public void bernapas()
    {
        System.out.println(nama + " bernapas menggunakan paru-paru.");
    }

    @Override
    public void bergerak()
    {
        System.out.println(nama + " berjalan dengan dua kaki.");
    }
}
