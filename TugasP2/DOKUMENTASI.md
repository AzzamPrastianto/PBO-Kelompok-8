# 📚 Sistem Manajemen Perpustakaan - Dokumentasi

## 📋 Daftar Isi
1. [Class Diagram](#class-diagram)
2. [Analisis Relasi Entitas](#analisis-relasi-entitas)
3. [Penjelasan Setiap Class](#penjelasan-setiap-class)
4. [Cara Menjalankan Program](#cara-menjalankan-program)

---

## 🎯 Class Diagram

```
┌─────────────────────────────────────────────────────────────────┐
│                        PERPUSTAKAAN SYSTEM                      │
└─────────────────────────────────────────────────────────────────┘

                           GenreBuku
                        ┌───────────────┐
                        │ - idGenre: int│
                        │ - namaGenre   │
                        │ - deskripsi   │
                        ├───────────────┤
                        │ + getIdGenre()│
                        │ + getNamaGenre
                        │ + getDeskripsi
                        │ + toString()  │
                        └───────────────┘
                              ▲
                              │ 1
                              │
                    ┌─ Has Many (Many-to-One)
                    │
                    │ 1
                  ┌─┴──────────┐
                  │    Buku    │
                  ├────────────┤
                  │-idBuku: int│
                  │-judul      │
                  │-pengarang  │
                  │-tahunTerbit│
                  │-stok: int  │
                  │-genre      │
                  ├────────────┤
                  │+getIdBuku()│
                  │+pinjamBuku()
                  │+kembaliBuku
                  │+toString() │
                  └────────────┘
                        ▲
                        │ *
                        │
              ┌─ Borrowed By (Many-to-Many)
              │
              │ *
         ┌────┴───────┐
         │   Member   │
         ├────────────┤
         │-idMember   │
         │-nama       │
         │-email      │
         │-telepon    │
         │-tgl Daftar │
         │-bukuPinjam │
         ├────────────┤
         │+pinjamBuku()
         │+kembaliBuku
         │+lihatBuku..
         │+toString() │
         └────────────┘
```

---

## 🔗 Analisis Relasi Entitas

### 1. **Relasi GenreBuku ← Buku**
- **Tipe**: Many-to-One (Aggregation)
- **Penjelasan**: 
  - Satu `GenreBuku` dapat memiliki banyak `Buku`
  - Satu `Buku` hanya memiliki satu `GenreBuku`
  - Contoh: Genre "Fiksi" memiliki buku Harry Potter, The Hobbit, dll
- **Implementasi**: `Buku` memiliki atribut `GenreBuku genre`

### 2. **Relasi Member ← Buku**
- **Tipe**: Many-to-Many (Composition)
- **Penjelasan**:
  - Satu `Member` dapat meminjam banyak `Buku`
  - Satu `Buku` dapat dipinjam oleh banyak `Member` (di waktu berbeda)
  - Terjadi melalui aksi peminjaman dan pengembalian
- **Implementasi**: `Member` memiliki `List<Buku> bukuPinjaman`

### 3. **Karakteristik Relasi**
| Aspek | Deskripsi |
|-------|-----------|
| **GenreBuku → Buku** | Aggregation (Has-A), Mandatory |
| **Member → Buku** | Composition (Collection), Optional |
| **Multiplicity** | GenreBuku(1) : Buku(N), Member(N) : Buku(N) |
| **Cardinality** | Satu genre bisa punya >1 buku; Satu member bisa pinjam >1 buku |

---

## 📖 Penjelasan Setiap Class

### **1. Class GenreBuku**
```java
public class GenreBuku {
    private int idGenre;        // ID unik genre
    private String namaGenre;   // Nama kategori (Fiksi, Non-Fiksi, dll)
    private String deskripsi;   // Deskripsi singkat genre
    
    // Method: Constructor, Getter, Setter, toString()
}
```
**Fungsi**: Menyimpan kategori/tipe buku di perpustakaan

---

### **2. Class Buku**
```java
public class Buku {
    private int idBuku;         // ID unik buku
    private String judul;       // Judul buku
    private String pengarang;   // Nama pengarang
    private int tahunTerbit;    // Tahun terbit buku
    private int stok;           // Jumlah stok tersedia
    private GenreBuku genre;    // **Relasi ke GenreBuku**
    
    // Method penting:
    // + pinjamBuku(): Mengurangi stok dan return true/false
    // + kembaliBuku(): Menambah stok buku
}
```
**Fungsi**: Menyimpan data buku dengan hubungan ke genre

---

### **3. Class Member**
```java
public class Member {
    private int idMember;           // ID unik member
    private String nama;            // Nama member
    private String email;           // Email member
    private String telepon;         // Nomor telepon
    private String tanggalDaftar;   // Kapan mendaftar
    private List<Buku> bukuPinjaman; // **Relasi ke Buku (List)**
    
    // Method penting:
    // + pinjamBuku(Buku): Member meminjam buku
    // + kembaliBuku(Buku): Member mengembalikan buku
    // + lihatBukuPinjaman(): Menampilkan daftar buku yang dipinjam
}
```
**Fungsi**: Menyimpan data anggota perpustakaan dan daftar buku pinjaman mereka

---

## 🚀 Cara Menjalankan Program

### **Struktur File**
```
src/
├── GenreBuku.java    (Class untuk genre buku)
├── Buku.java         (Class untuk data buku)
├── Member.java       (Class untuk member perpustakaan)
└── App.java          (Class Main dengan demonstrasi)
```

### **Langkah Menjalankan**
1. **Buka Terminal di VS Code** (Ctrl + `)
2. **Compile Program**:
   ```bash
   javac src/*.java
   ```
3. **Jalankan Program**:
   ```bash
   java -cp src App
   ```

### **Output Program**
Program akan menampilkan:
1. ✅ Pembuatan 4 genre buku
2. ✅ Pembuatan 5 data buku dengan genre masing-masing
3. ✅ Pembuatan 3 member
4. ✅ Simulasi peminjaman buku
5. ✅ Pengecekan stok buku
6. ✅ Daftar buku pinjaman setiap member
7. ✅ Simulasi pengembalian buku
8. ✅ Status akhir stok dan pinjaman

---

## 📊 Contoh Output Program

```
╔════════════════════════════════════════════════════════╗
║     SISTEM MANAJEMEN PERPUSTAKAAN SEDERHANA             ║
║  Entitas: GenreBuku, Buku, dan Member                  ║
╚════════════════════════════════════════════════════════╝

>>> 1. MEMBUAT GENRE BUKU
───────────────────────────────────────────────────────────
GenreBuku{idGenre=1, namaGenre='Fiksi', deskripsi='Buku cerita imajinatif'}
GenreBuku{idGenre=2, namaGenre='Non-Fiksi', deskripsi='Buku berdasarkan fakta'}
...

>>> 2. MEMBUAT DATA BUKU
───────────────────────────────────────────────────────────
Buku{idBuku=101, judul='Harry Potter and the Philosopher's Stone', 
     pengarang='J.K. Rowling', tahunTerbit=1998, stok=3, genre=Fiksi}
...

>>> 3. MEMBUAT MEMBER
───────────────────────────────────────────────────────────
Member{idMember=1001, nama='Budi Santoso', email='budi@email.com', 
       telepon='081234567890', tanggalDaftar='2024-01-15', jumlahBukuPinjaman=0}
...

>>> 4. SIMULASI PEMINJAMAN BUKU
═════════════════════════════════════════════════════════
[MEMBER 1: BUDI SANTOSO]
✓ Budi Santoso berhasil meminjam: Harry Potter and the Philosopher's Stone
✓ Budi Santoso berhasil meminjam: Clean Code
✓ Budi Santoso berhasil meminjam: The Hobbit

[MEMBER 2: SITI NURHALIZA]
✓ Siti Nurhaliza berhasil meminjam: Sapiens
✓ Siti Nurhaliza berhasil meminjam: Steve Jobs
✓ Siti Nurhaliza berhasil meminjam: Clean Code

[MEMBER 3: AHMAD WIJAYA]
✓ Ahmad Wijaya berhasil meminjam: Harry Potter and the Philosopher's Stone
✓ Ahmad Wijaya berhasil meminjam: Sapiens

[PERCOBAAN MEMINJAM BUKU STOK HABIS]
✗ Maaf, stok The Hobbit sedang habis!

>>> 6. DAFTAR BUKU PINJAMAN SETIAP MEMBER
───────────────────────────────────────────────────────────
>>> Daftar Buku Pinjaman Budi Santoso:
   1. Harry Potter and the Philosopher's Stone - J.K. Rowling (Fiksi)
   2. Clean Code - Robert C. Martin (Programming)
   3. The Hobbit - J.R.R. Tolkien (Fiksi)
   Total: 3 buku
```

---

## 🎓 Poin-Poin Penting

✅ **Encapsulation**: Semua atribut private, akses via public methods  
✅ **Aggregation**: GenreBuku adalah bagian dari Buku  
✅ **Composition**: List bukuPinjaman di Member  
✅ **Polymorphism**: Override toString() di setiap class  
✅ **Real-World Logic**: Simulasi peminjaman dengan validasi stok  
✅ **Error Handling**: Pengecekan stok sebelum peminjaman  

---

## 📝 Catatan Tambahan

- Member dapat meminjam **maksimal banyak buku** (sesuai stok)
- Buku hanya dapat diisi **satu genre**
- Sistem menampilkan pesan sukses/gagal untuk setiap transaksi
- Stok buku otomatis berkurang saat dipinjam dan bertambah saat dikembalikan

**Dibuat untuk Tugas PBO (Pemrograman Berorientasi Objek)**
