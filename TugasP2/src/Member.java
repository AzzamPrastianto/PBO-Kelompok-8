import java.util.ArrayList;
import java.util.List;

/**
 * Class Member
 * Merepresentasikan anggota/member perpustakaan
 * Memiliki relasi dengan Buku (One-to-Many untuk peminjaman)
 */
public class Member {
    private int idMember;
    private String nama;
    private String email;
    private String telepon;
    private String tanggalDaftar;
    private List<Buku> bukuPinjaman;

    public Member(int idMember, String nama, String email, String telepon, String tanggalDaftar) {
        this.idMember = idMember;
        this.nama = nama;
        this.email = email;
        this.telepon = telepon;
        this.tanggalDaftar = tanggalDaftar;
        this.bukuPinjaman = new ArrayList<>();
    }

    public int getIdMember() {
        return idMember;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getTanggalDaftar() {
        return tanggalDaftar;
    }

    public List<Buku> getBukuPinjaman() {
        return bukuPinjaman;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    /**
     * Method untuk meminjam buku
     * @param buku - buku yang akan dipinjam
     */
    public void pinjamBuku(Buku buku) {
        if (buku.pinjamBuku()) {
            bukuPinjaman.add(buku);
            System.out.println("✓ " + nama + " berhasil meminjam: " + buku.getJudul());
        } else {
            System.out.println("✗ Maaf, stok " + buku.getJudul() + " sedang habis!");
        }
    }

    /**
     * Method untuk mengembalikan buku
     * @param buku - buku yang akan dikembalikan
     */
    public void kembaliBuku(Buku buku) {
        if (bukuPinjaman.remove(buku)) {
            buku.kembaliBuku();
            System.out.println("✓ " + nama + " berhasil mengembalikan: " + buku.getJudul());
        } else {
            System.out.println("✗ Buku ini tidak ada di daftar pinjaman " + nama);
        }
    }

    /**
     * Method untuk melihat daftar buku yang dipinjam
     */
    public void lihatBukuPinjaman() {
        System.out.println("\n>>> Daftar Buku Pinjaman " + nama + ":");
        if (bukuPinjaman.isEmpty()) {
            System.out.println("   Tidak ada buku yang dipinjam");
        } else {
            for (int i = 0; i < bukuPinjaman.size(); i++) {
                Buku buku = bukuPinjaman.get(i);
                System.out.println((i + 1) + ". " + buku.getJudul() + " - " + buku.getPengarang() 
                    + " (" + buku.getGenre().getNamaGenre() + ")");
            }
        }
        System.out.println("   Total: " + bukuPinjaman.size() + " buku\n");
    }

    @Override
    public String toString() {
        return "Member{" +
                "idMember=" + idMember +
                ", nama='" + nama + '\'' +
                ", email='" + email + '\'' +
                ", telepon='" + telepon + '\'' +
                ", tanggalDaftar='" + tanggalDaftar + '\'' +
                ", jumlahBukuPinjaman=" + bukuPinjaman.size() +
                '}';
    }
}
