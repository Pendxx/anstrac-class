public class Main
{
    public static void main(String[] args)
    {
        MakhlukHidup manusia = new Manusia("Budi");
        MakhlukHidup hewan = new Hewan("Kucing");
        MakhlukHidup tumbuhan = new Tumbuhan("Bunga Matahari");

        cekMakhluk(manusia);
        System.out.println("----------------");
        cekMakhluk(hewan);
        System.out.println("----------------");
        cekMakhluk(tumbuhan);
    }

    public static void cekMakhluk(MakhlukHidup mh) {
        mh.tumbuh();
        mh.bernapas();
        mh.bergerak();
    }
}
