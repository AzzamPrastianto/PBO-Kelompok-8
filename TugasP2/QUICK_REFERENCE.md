# 🎯 QUICK REFERENCE - SISTEM MANAJEMEN PERPUSTAKAAN

## 📐 Class Diagram (Sederhana)

```
GenreBuku ◄─────── Buku ◄──────── Member
   (1)      (Many)   (1)   (Many)
          Has-A              Has-Many
```

---

## 📋 Class Summary

### **1. GenreBuku** - Kategori Buku
```java
Buku.getGenre()           // Akses genre dari buku
genre.getNamaGenre()      // Contoh: "Fiksi"
```

**Atribut**: idGenre, namaGenre, deskripsi

### **2. Buku** - Data Buku Perpustakaan
```java
buku.getJudul()           // Contoh: "Harry Potter"
buku.getPengarang()       // Contoh: "J.K. Rowling"
buku.getStok()            // Contoh: 2 (tersisa)
buku.getGenre()           // Relasi ke GenreBuku
```

**Atribut**: idBuku, judul, pengarang, tahunTerbit, stok, genre

### **3. Member** - Anggota Perpustakaan
```java
member.getNama()          // Contoh: "Budi Santoso"
member.getBukuPinjaman()  // Contoh: [Harry Potter, Clean Code, ...]
member.pinjamBuku(buku)   // Member meminjam buku
member.kembaliBuku(buku)  // Member mengembalikan buku
```

**Atribut**: idMember, nama, email, telepon, tanggalDaftar, bukuPinjaman (List)

---

## 🔄 Flow Transaksi

### **PEMINJAMAN BUKU**
```
1. Member.pinjamBuku(buku)
   ↓
2. Validasi: Buku.stok > 0?
   ├─ YES → Buku.pinjamBuku() [stok--]
   │        Member.bukuPinjaman.add(buku)
   │        Tampilkan: "✓ Berhasil meminjam"
   │
   └─ NO  → Tampilkan: "✗ Stok habis!"
```

### **PENGEMBALIAN BUKU**
```
1. Member.kembaliBuku(buku)
   ↓
2. Validasi: Buku ada di Member.bukuPinjaman?
   ├─ YES → Member.bukuPinjaman.remove(buku)
   │        Buku.kembaliBuku() [stok++]
   │        Tampilkan: "✓ Berhasil dikembalikan"
   │
   └─ NO  → Tampilkan: "✗ Buku tidak ada di daftar pinjaman"
```

---

## 💾 Memory Representation

```
┌─────────────────────────────────┐
│        Member: Budi             │
├─────────────────────────────────┤
│ idMember: 1001                  │
│ nama: "Budi Santoso"            │
│ bukuPinjaman: [                 │
│   ├─→ Buku(id=101)              │
│   │   ├─→ genre.namaGenre       │
│   │   └─→ stok: 2               │
│   │                             │
│   └─→ Buku(id=104)              │
│       ├─→ genre.namaGenre       │
│       └─→ stok: 3               │
│ ]                               │
└─────────────────────────────────┘
```

---

## 🎯 Relasi Tabel

| Entitas | Banyak | Relasi | Sedikit |
|---------|--------|--------|---------|
| Member | Many | Meminjam | Buku |
| Buku | Many | Termasuk dalam | Genre |

---

## 📊 Contoh Data

### **Genre (Master Data)**
| ID | Nama | Deskripsi |
|----|------|-----------|
| 1 | Fiksi | Cerita imajinatif |
| 2 | Non-Fiksi | Berdasarkan fakta |

### **Buku (Produk)**
| ID | Judul | Pengarang | Tahun | Stok | Genre |
|---|---|---|---|---|---|
| 101 | Harry Potter | J.K. Rowling | 1998 | 3 | Fiksi |
| 104 | Clean Code | Robert Martin | 2008 | 4 | Programming |

### **Member (User)**
| ID | Nama | Email | Tgl Daftar |
|---|---|---|---|
| 1001 | Budi | budi@email | 2024-01-15 |
| 1002 | Siti | siti@email | 2024-02-20 |

### **Peminjaman (Transactions)**
| Member | Buku | Status |
|--------|------|--------|
| Budi | Harry Potter | ✓ Dipinjam |
| Budi | Clean Code | ✓ Dipinjam |
| Siti | Sapiens | ✓ Dipinjam |

---

## 🔗 Relasi Implementasi

### **Aggregation: Genre di Buku**
```java
public class Buku {
    private GenreBuku genre;  // Pointer ke object GenreBuku
}
```
- Buku "memiliki" genre
- Genre bisa exist tanpa Buku
- Weak relationship

### **Composition: List Buku di Member**
```java
public class Member {
    private List<Buku> bukuPinjaman;  // Koleksi Buku
}
```
- Member "memiliki" koleksi buku pinjaman
- Buku ada dalam konteks Member (peminjaman)
- Strong relationship

---

## 🚀 Constructor Usage

### **Membuat Genre**
```java
GenreBuku genre = new GenreBuku(1, "Fiksi", "Buku cerita");
```

### **Membuat Buku**
```java
Buku buku = new Buku(101, "Harry Potter", "J.K. Rowling", 1998, 3, genre);
```

### **Membuat Member**
```java
Member member = new Member(1001, "Budi", "budi@email.com", "081234567890", "2024-01-15");
```

---

## 🎮 Operasi Dasar

### **Peminjaman**
```java
member.pinjamBuku(buku);  // String output: "✓/✗ Berhasil/Gagal..."
```

### **Pengembalian**
```java
member.kembaliBuku(buku);  // String output: "✓/✗ Berhasil/Gagal..."
```

### **Lihat Pinjaman**
```java
member.lihatBukuPinjaman();  // Tampilkan daftar buku yang dipinjam
```

### **Cek Stok**
```java
int stok = buku.getStok();  // Contoh: 2
```

---

## 📈 Program Flow

```
START
  ↓
[1] CREATE GENRES (4 genre)
  ↓
[2] CREATE BOOKS (5 buku, masing-masing ada genrenya)
  ↓
[3] CREATE MEMBERS (3 member)
  ↓
[4] SIMULATE BORROWING (member pinjam buku)
  ↓
[5] CHECK STOCK (tampilkan stok terkini)
  ↓
[6] SHOW LOAN LIST (tampilkan buku pinjaman per member)
  ↓
[7] SIMULATE RETURNING (member kembalikan buku)
  ↓
[8] FINAL STATUS (tampilkan status akhir)
  ↓
END
```

---

## ✅ Validation Rules

1. **Peminjaman**: stok > 0
2. **Pengembalian**: buku ada di list pinjaman
3. **Genre**: Tidak boleh kosong
4. **Member**: Bisa meminjam unlimited jumlah buku

---

## 🎓 OOP Principles Applied

| Principle | How |
|-----------|-----|
| **Encapsulation** | Private fields, public methods |
| **Abstraction** | Hide implementation, expose interface |
| **Inheritance** | (Dapat ditambahkan dengan superclass) |
| **Polymorphism** | Override toString() |
| **Aggregation** | GenreBuku di Buku |
| **Composition** | List<Buku> di Member |

---

## 📞 Quick Lookup

| Need | Method | Example |
|------|--------|---------|
| Nama buku? | `buku.getJudul()` | "Harry Potter" |
| Genre buku? | `buku.getGenre().getNamaGenre()` | "Fiksi" |
| Stok buku? | `buku.getStok()` | 2 |
| Buku dipinjam member? | `member.getBukuPinjaman()` | [buku1, buku2, ...] |
| Pinjam buku | `member.pinjamBuku(buku)` | Output: "✓ Berhasil" |
| Kembalikan buku | `member.kembaliBuku(buku)` | Output: "✓ Berhasil" |
| Lihat pinjaman | `member.lihatBukuPinjaman()` | List terformat |

---

## 📁 File Structure
```
src/
├── GenreBuku.java     (41 lines)
├── Buku.java          (85 lines)
├── Member.java        (125 lines)
└── App.java           (150+ lines)
```

---

## 🏃 Run Program
```bash
javac src/*.java
java -cp src App
```

---

**Quick Reference v1.0 - Sistem Manajemen Perpustakaan**
