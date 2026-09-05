# 📚 Sistem Manajemen Perpustakaan

**Aplikasi OOP (Pemrograman Berorientasi Objek) untuk Manajemen Perpustakaan**

## 🎯 Tujuan
Mendemonstrasikan konsep-konsep OOP melalui sistem manajemen perpustakaan dengan 3 entitas utama:
- **GenreBuku**: Kategori/jenis buku
- **Buku**: Data buku di perpustakaan  
- **Member**: Anggota perpustakaan

## 📂 Struktur Folder
```
TugasP2/
├── src/
│   ├── GenreBuku.java    ← Class untuk Genre Buku
│   ├── Buku.java         ← Class untuk Buku
│   ├── Member.java       ← Class untuk Member
│   └── App.java          ← Main Program
├── DOKUMENTASI.md        ← Dokumentasi Lengkap
└── README.md             ← File ini
```

## 🔗 Relasi Antar Class

```
GenreBuku (1) ──────→ Buku (Many)
                      ↑
                      │
                    (Many-to-Many)
                      │
                      ↓
                    Member (Many)
```

**Penjelasan**:
- Satu **Genre** bisa memiliki banyak **Buku** (Many-to-One)
- Satu **Member** bisa meminjam banyak **Buku** (One-to-Many)
- Satu **Buku** bisa dipinjam oleh banyak **Member** (Many-to-Many)

## 🚀 Cara Menjalankan

### **Kompilasi Program**
```bash
javac src/*.java
```

### **Jalankan Program**
```bash
java -cp src App
```

## 📖 Fitur-Fitur Program

✅ **Membuat Genre Buku** - Mendefinisikan kategori buku (Fiksi, Non-Fiksi, dll)  
✅ **Membuat Data Buku** - Input data buku dengan genre tertentu  
✅ **Membuat Member** - Registrasi anggota perpustakaan  
✅ **Peminjaman Buku** - Member dapat meminjam buku (stok berkurang)  
✅ **Pengembalian Buku** - Member mengembalikan buku (stok bertambah)  
✅ **Validasi Stok** - Sistem cek stok sebelum peminjaman  
✅ **Daftar Pinjaman** - Lihat buku yang dipinjam oleh setiap member  
✅ **Status Stok Real-Time** - Update stok otomatis  

## 📊 Contoh Penggunaan

### 1. Membuat Genre Buku
```java
GenreBuku genre1 = new GenreBuku(1, "Fiksi", "Buku cerita imajinatif");
GenreBuku genre2 = new GenreBuku(2, "Non-Fiksi", "Buku berdasarkan fakta");
```

### 2. Membuat Buku
```java
Buku buku1 = new Buku(101, "Harry Potter", "J.K. Rowling", 1998, 3, genre1);
```

### 3. Membuat Member
```java
Member member1 = new Member(1001, "Budi Santoso", "budi@email.com", 
                            "081234567890", "2024-01-15");
```

### 4. Peminjaman Buku
```java
member1.pinjamBuku(buku1);  // Member meminjam buku
```

### 5. Pengembalian Buku
```java
member1.kembaliBuku(buku1); // Member mengembalikan buku
```

### 6. Lihat Daftar Pinjaman
```java
member1.lihatBukuPinjaman(); // Tampilkan buku yang dipinjam
```

## 🎓 Konsep OOP yang Diterapkan

| Konsep | Implementasi |
|--------|--------------|
| **Encapsulation** | Atribut private, akses via getter/setter |
| **Inheritance** | (Bisa diperluas dengan abstract class/interface) |
| **Polymorphism** | Override toString() di setiap class |
| **Abstraction** | Method publik tersembunyi kompleksitas internal |
| **Association** | Relasi antar class (Has-A, Many-to-Many) |
| **Aggregation** | GenreBuku sebagai bagian dari Buku |

## 📋 Class Methods Overview

### GenreBuku
- `getIdGenre()` - Dapatkan ID genre
- `getNamaGenre()` - Dapatkan nama genre
- `getDeskripsi()` - Dapatkan deskripsi
- `setNamaGenre(String)` - Ubah nama genre
- `toString()` - Tampilkan info genre

### Buku
- `getIdBuku()` - Dapatkan ID buku
- `getJudul()` - Dapatkan judul
- `getPengarang()` - Dapatkan nama pengarang
- `getTahunTerbit()` - Dapatkan tahun terbit
- `getStok()` - Dapatkan jumlah stok
- `getGenre()` - Dapatkan genre buku
- `pinjamBuku()` - Pinjam buku (kurangi stok)
- `kembaliBuku()` - Kembalikan buku (tambah stok)
- `toString()` - Tampilkan info buku

### Member
- `getIdMember()` - Dapatkan ID member
- `getNama()` - Dapatkan nama
- `getEmail()` - Dapatkan email
- `getTelepon()` - Dapatkan telepon
- `getTanggalDaftar()` - Dapatkan tanggal daftar
- `getBukuPinjaman()` - Dapatkan list buku pinjaman
- `pinjamBuku(Buku)` - Pinjam buku tertentu
- `kembaliBuku(Buku)` - Kembalikan buku tertentu
- `lihatBukuPinjaman()` - Lihat daftar buku pinjaman
- `toString()` - Tampilkan info member

## 🔍 Validasi & Error Handling

1. **Validasi Stok**: Sistem mengecek stok sebelum peminjaman
   - Jika stok > 0: Peminjaman berhasil
   - Jika stok = 0: Tampilkan pesan "Stok habis"

2. **Pengembalian Buku**: Sistem validasi buku ada di daftar pinjaman
   - Jika ada: Pengembalian berhasil
   - Jika tidak ada: Tampilkan pesan error

## 💡 Pengembangan Lebih Lanjut

Fitur tambahan yang bisa dikembangkan:
- 📅 Daftar tanggal peminjaman/pengembalian
- 💰 Sistem denda untuk keterlambatan
- 🔍 Search buku berdasarkan judul/pengarang
- 👥 Rating buku dari member
- 📊 Statistik peminjaman

## 📝 Penulis
Dibuat untuk Tugas PBO (Pemrograman Berorientasi Objek)

---

**Untuk dokumentasi lengkap, lihat file `DOKUMENTASI.md`**
