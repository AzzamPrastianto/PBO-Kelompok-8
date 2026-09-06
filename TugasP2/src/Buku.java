public class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private int tahunTerbit;
    private int stok;
    private GenreBuku genre;

    public Buku(int idBuku, String judul, String pengarang, int tahunTerbit, int stok, GenreBuku genre) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
        this.genre = genre;
    }

    public int getIdBuku() {
        return idBuku;
    }

    public String getJudul() {
        return judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public int getStok() {
        return stok;
    }

    public GenreBuku getGenre() {
        return genre;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setGenre(GenreBuku genre) {
        this.genre = genre;
    }

    public boolean pinjamBuku() {
        if (stok > 0) {
            stok--;
            return true;
        }
        return false;
    }

    public void kembaliBuku() {
        stok++;
    }

    public String toString() {
        return "Buku{" +
                "idBuku=" + idBuku +
                ", judul='" + judul + '\'' +
                ", pengarang='" + pengarang + '\'' +
                ", tahunTerbit=" + tahunTerbit +
                ", stok=" + stok +
                ", genre=" + genre.getNamaGenre() +
                '}';
    }
}
