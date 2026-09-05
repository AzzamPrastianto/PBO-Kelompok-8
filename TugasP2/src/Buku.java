/**
 * Class Buku (Book)
 * Merepresentasikan data buku di perpustakaan
 * Memiliki relasi dengan GenreBuku (Many-to-One)
 */
public class Buku {
    private int idBuku;
    private String judul;
    private String pengarang;
    private int tahunTerbit;
    private int stok;
    private GenreBuku genre;

    // Constructor
    public Buku(int idBuku, String judul, String pengarang, int tahunTerbit, int stok, GenreBuku genre) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.pengarang = pengarang;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
        this.genre = genre;
    }

    // Getter Methods
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

    // Setter Methods
    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setGenre(GenreBuku genre) {
        this.genre = genre;
    }

    /**
     * Method untuk meminjam buku (mengurangi stok)
     * @return true jika peminjaman berhasil, false jika stok habis
     */
    public boolean pinjamBuku() {
        if (stok > 0) {
            stok--;
            return true;
        }
        return false;
    }

    /**
     * Method untuk mengembalikan buku (menambah stok)
     */
    public void kembaliBuku() {
        stok++;
    }

    // toString method
    @Override
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
