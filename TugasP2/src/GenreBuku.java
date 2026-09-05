/**
 * Class GenreBuku (BookGenre)
 * Merepresentasikan kategori/genre dari buku
 */
public class GenreBuku {
    private int idGenre;
    private String namaGenre;
    private String deskripsi;

    // Constructor
    public GenreBuku(int idGenre, String namaGenre, String deskripsi) {
        this.idGenre = idGenre;
        this.namaGenre = namaGenre;
        this.deskripsi = deskripsi;
    }

    // Getter Methods
    public int getIdGenre() {
        return idGenre;
    }

    public String getNamaGenre() {
        return namaGenre;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    // Setter Methods
    public void setNamaGenre(String namaGenre) {
        this.namaGenre = namaGenre;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // toString method
    @Override
    public String toString() {
        return "GenreBuku{" +
                "idGenre=" + idGenre +
                ", namaGenre='" + namaGenre + '\'' +
                ", deskripsi='" + deskripsi + '\'' +
                '}';
    }
}
