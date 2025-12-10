public class Hewan extends MakhlukHidup
{
    public Hewan(String nama)
    {
        super(nama);
    }

    @Override
    public void bernapas()
    {
        System.out.println(nama + " bernapas menggunakan paru-paru/insang/trakea.");
    }

    @Override
    public void bergerak()
    {
        System.out.println(nama + " bergerak dengan 4 kaki atau sayap.");
    }
}
