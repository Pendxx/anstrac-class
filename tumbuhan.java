public class Tumbuhan extends MakhlukHidup
{
    public Tumbuhan(String nama)
    {
        super(nama);
    }

    @Override
    public void bernapas()
    {
        System.out.println(nama + " bernapas melalui stomata dan lentisel.");
    }

    @Override
    public void bergerak()
    {
        System.out.println(nama + " bergerak mengikuti arah cahaya matahari (fototropisme).");
    }
}
