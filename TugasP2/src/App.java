/**
 * Class Main untuk Sistem Manajemen Perpustakaan
 * Demonstrasi penggunaan class GenreBuku, Buku, dan Member
 */
public class App {
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║     SISTEM MANAJEMEN PERPUSTAKAAN SEDERHANA             ║");
        System.out.println("║  Entitas: GenreBuku, Buku, dan Member                  ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");


        System.out.println(">>> 1. MEMBUAT GENRE BUKU");
        System.out.println("─────────────────────────────────────────────────────────");
        
        GenreBuku genre1 = new GenreBuku(1, "Fiksi", "Buku cerita imajinatif");
        GenreBuku genre2 = new GenreBuku(2, "Non-Fiksi", "Buku berdasarkan fakta");
        GenreBuku genre3 = new GenreBuku(3, "Biografi", "Riwayat hidup tokoh terkenal");
        GenreBuku genre4 = new GenreBuku(4, "Programming", "Buku tentang pemrograman komputer");
        
        System.out.println(genre1);
        System.out.println(genre2);
        System.out.println(genre3);
        System.out.println(genre4);
        
        
        System.out.println("\n>>> 2. MEMBUAT DATA BUKU");
        System.out.println("─────────────────────────────────────────────────────────");
        
        Buku buku1 = new Buku(101, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", 1998, 3, genre1);
        Buku buku2 = new Buku(102, "Sapiens", "Yuval Noah Harari", 2014, 2, genre2);
        Buku buku3 = new Buku(103, "Steve Jobs", "Walter Isaacson", 2011, 2, genre3);
        Buku buku4 = new Buku(104, "Clean Code", "Robert C. Martin", 2008, 4, genre4);
        Buku buku5 = new Buku(105, "The Hobbit", "J.R.R. Tolkien", 1937, 1, genre1);
        
        System.out.println(buku1);
        System.out.println(buku2);
        System.out.println(buku3);
        System.out.println(buku4);
        System.out.println(buku5);
        
       
        System.out.println("\n>>> 3. MEMBUAT MEMBER");
        System.out.println("─────────────────────────────────────────────────────────");
        
        Member member1 = new Member(1001, "Budi Santoso", "budi@email.com", "081234567890", "2024-01-15");
        Member member2 = new Member(1002, "Siti Nurhaliza", "siti@email.com", "082345678901", "2024-02-20");
        Member member3 = new Member(1003, "Ahmad Wijaya", "ahmad@email.com", "083456789012", "2024-03-10");
        
        System.out.println(member1);
        System.out.println(member2);
        System.out.println(member3);
        
        
        System.out.println("\n\n>>> 4. SIMULASI PEMINJAMAN BUKU");
        System.out.println("═════════════════════════════════════════════════════════");
        
        
        System.out.println("\n[MEMBER 1: BUDI SANTOSO]");
        member1.pinjamBuku(buku1);
        member1.pinjamBuku(buku4);
        member1.pinjamBuku(buku5);
        
        
        System.out.println("\n[MEMBER 2: SITI NURHALIZA]");
        member2.pinjamBuku(buku2);
        member2.pinjamBuku(buku3);
        member2.pinjamBuku(buku4);
        
        
        System.out.println("\n[MEMBER 3: AHMAD WIJAYA]");
        member3.pinjamBuku(buku1);
        member3.pinjamBuku(buku2);
        
        System.out.println("\n[PERCOBAAN MEMINJAM BUKU STOK HABIS]");
        member3.pinjamBuku(buku5); // The Hobbit stok tinggal 0 setelah dipinjam Budi
        

        System.out.println("\n>>> 5. STATUS STOK BUKU SETELAH PEMINJAMAN");
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println(buku1);
        System.out.println(buku2);
        System.out.println(buku3);
        System.out.println(buku4);
        System.out.println(buku5);
        

        System.out.println("\n>>> 6. DAFTAR BUKU PINJAMAN SETIAP MEMBER");
        System.out.println("─────────────────────────────────────────────────────────");
        member1.lihatBukuPinjaman();
        member2.lihatBukuPinjaman();
        member3.lihatBukuPinjaman();
        

        System.out.println(">>> 7. SIMULASI PENGEMBALIAN BUKU");
        System.out.println("─────────────────────────────────────────────────────────");
        
        System.out.println("\n[MEMBER 1 MENGEMBALIKAN BUKU]");
        member1.kembaliBuku(buku5);
        member1.kembaliBuku(buku1);
        
        System.out.println("\n[MEMBER 2 MENGEMBALIKAN BUKU]");
        member2.kembaliBuku(buku4);
        member2.kembaliBuku(buku3);
        

        System.out.println("\n>>> 8. STATUS AKHIR BUKU SETELAH PENGEMBALIAN");
        System.out.println("─────────────────────────────────────────────────────────");
        System.out.println(buku1);
        System.out.println(buku4);
        System.out.println(buku5);
        
        System.out.println("\n>>> 9. DAFTAR BUKU PINJAMAN AKHIR");
        System.out.println("─────────────────────────────────────────────────────────");
        member1.lihatBukuPinjaman();
        member2.lihatBukuPinjaman();
        member3.lihatBukuPinjaman();
        
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║              SELESAI - TERIMA KASIH                    ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
    }
}
