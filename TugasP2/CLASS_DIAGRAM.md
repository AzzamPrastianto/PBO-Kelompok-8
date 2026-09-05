# CLASS DIAGRAM - SISTEM MANAJEMEN PERPUSTAKAAN

## 📐 UML CLASS DIAGRAM (Teks)

```
╔════════════════════════════════════════════════════════════════════════════╗
║                      SISTEM MANAJEMEN PERPUSTAKAAN                         ║
║                     Class Diagram Visualization                            ║
╚════════════════════════════════════════════════════════════════════════════╝


                            ┏━━━━━━━━━━━━━━━━━┓
                            ┃   GenreBuku     ┃
                            ┣━━━━━━━━━━━━━━━━━┫
                            ┃ - idGenre: int  ┃
                            ┃ - namaGenre: S  ┃
                            ┃ - deskripsi: S  ┃
                            ┣━━━━━━━━━━━━━━━━━┫
                            ┃ + GenreBuku()   ┃
                            ┃ + getId()       ┃
                            ┃ + getNama()     ┃
                            ┃ + getDeskripsi()┃
                            ┃ + toString()    ┃
                            ┗━━━━━━━━━━━━━━━━━┛
                                      ▲
                                      │
                        ┌─────────────┘
                        │    1
              Many-to-One
                        │
                        │ *
                        ▼
                    ┏━━━━━━━━━━━━━━━━━┓
                    ┃      Buku       ┃
                    ┣━━━━━━━━━━━━━━━━━┫
                    ┃ - idBuku: int   ┃
                    ┃ - judul: String ┃
                    ┃ - pengarang: S  ┃
                    ┃ - tahunTerbit: i┃
                    ┃ - stok: int     ┃
                    ┃ - genre: Genre  ┃ ◄── Relasi ke GenreBuku
                    ┣━━━━━━━━━━━━━━━━━┫
                    ┃ + Buku()        ┃
                    ┃ + getId()       ┃
                    ┃ + getJudul()    ┃
                    ┃ + getStok()     ┃
                    ┃ + pinjamBuku()  ┃
                    ┃ + kembaliBuku() ┃
                    ┃ + toString()    ┃
                    ┗━━━━━━━━━━━━━━━━━┛
                            ▲
                            │
              Many-to-Many ──┤
                            │
                        *   │   1
                            │
                    ┌───────┘
                    ▼
                ┏━━━━━━━━━━━━━━━━━┓
                ┃     Member      ┃
                ┣━━━━━━━━━━━━━━━━━┫
                ┃ - idMember: int ┃
                ┃ - nama: String  ┃
                ┃ - email: String ┃
                ┃ - telepon: S    ┃
                ┃ - tglDaftar: S  ┃
                ┃ - bukuPinjam: L ┃ ◄── List<Buku>
                ┣━━━━━━━━━━━━━━━━━┫
                ┃ + Member()      ┃
                ┃ + getId()       ┃
                ┃ + getNama()     ┃
                ┃ + pinjamBuku()  ┃
                ┃ + kembaliBuku() ┃
                ┃ + lihatBuku()   ┃
                ┃ + toString()    ┃
                ┗━━━━━━━━━━━━━━━━━┛
```

---

## 📊 RELASI ANTAR CLASS

### 1. **GenreBuku → Buku** (Many-to-One / Aggregation)

```
┌─────────────────┐          ┌──────────────────┐
│   GenreBuku     │    1     │      Buku        │
│                 │◄─────────│                  │
│ - idGenre       │    has   │ - idBuku         │
│ - namaGenre     │    many  │ - judul          │
│ - deskripsi     │          │ - pengarang      │
│                 │          │ - tahunTerbit    │
│                 │          │ - stok           │
│                 │          │ - genre: Genre   │◄─── Pointer ke GenreBuku
└─────────────────┘          └──────────────────┘
```

**Penjelasan**:
- Satu GenreBuku dapat memiliki BANYAK Buku
- Satu Buku hanya memiliki SATU GenreBuku
- Contoh: Genre "Fiksi" memiliki buku Harry Potter, The Hobbit, dll
- Type: **Aggregation** (Buku "memiliki" Genre)

---

### 2. **Member → Buku** (Many-to-Many / Composition)

```
┌──────────────────┐                     ┌──────────────────┐
│     Member       │      meminjam       │      Buku        │
│                  │────────────────────►│                  │
│ - idMember       │      banyak         │ - idBuku         │
│ - nama           │                     │ - judul          │
│ - email          │   List<Buku>        │ - pengarang      │
│ - telepon        │   bukuPinjaman      │ - tahunTerbit    │
│ - tglDaftar      │                     │ - stok           │
│                  │                     │ - genre          │
│                  │◄────────────────────│                  │
│ - bukuPinjam:    │   dipinjam oleh     │                  │
│   List<Buku>     │      banyak         │                  │
└──────────────────┘                    └──────────────────┘
```

**Penjelasan**:
- Satu Member dapat meminjam BANYAK Buku (sekali waktu)
- Satu Buku dapat dipinjam oleh BANYAK Member (di waktu berbeda)
- Relationship: **Composition** (Member "memiliki" koleksi Buku)
- Implementasi: `List<Buku> bukuPinjaman` di class Member

---

## 🔄 SIKLUS HIDUP TRANSAKSI

```
┌──────────────────┐
│  BUKU TERSEDIA   │  (stok > 0)
│  stok = N        │
└────────┬─────────┘
         │
         │ Member.pinjamBuku(buku)
         │ buku.pinjamBuku()
         ▼
┌──────────────────┐
│  BUKU DIPINJAM   │  (stok -= 1)
│  stok = N-1      │
│  Member.bukuPin  │
│  jaman += buku   │
└────────┬─────────┘
         │
         │ Member.kembaliBuku(buku)
         │ buku.kembaliBuku()
         ▼
┌──────────────────┐
│  BUKU KEMBALI    │  (stok += 1)
│  stok = N        │  Member.bukuPin
│                  │  jaman.remove()
└──────────────────┘
```

---

## 💾 STRUKTUR DATA DALAM MEMORI

### Ketika Member Meminjam Buku:

```
Member: Budi Santoso
├── bukuPinjaman: List<Buku>
│   ├── [0] → Buku { 
│   │         id=101, 
│   │         judul="Harry Potter",
│   │         genre → GenreBuku {id=1, nama="Fiksi"}
│   │         stok=2  (dari 3)
│   │       }
│   ├── [1] → Buku {
│   │         id=104,
│   │         judul="Clean Code",
│   │         genre → GenreBuku {id=4, nama="Programming"}
│   │         stok=3  (dari 4)
│   │       }
│   └── [2] → Buku {
│             id=105,
│             judul="The Hobbit",
│             genre → GenreBuku {id=1, nama="Fiksi"}
│             stok=0  (dari 1)
│           }
└── Total: 3 buku dipinjam
```

---

## 📋 TABEL RELASI

| Class | Atribut Relasi | Tipe Relasi | Target Class | Multiplicity |
|-------|---|---|---|---|
| Buku | `genre: GenreBuku` | Aggregation | GenreBuku | Many-to-One |
| Member | `bukuPinjaman: List<Buku>` | Composition | Buku | One-to-Many |

---

## 🎯 CARDINALITY DAN MULTIPLICITY

```
GenreBuku ── 1 ──►─ * ── Buku
           (One)  (Many)
           
Member ─── * ─────► * ─── Buku
        (Many)   (Many)
        (Through bukuPinjaman List)
```

- **GenreBuku → Buku**: **1:Many** (Satu genre banyak buku)
- **Member → Buku**: **Many:Many** (Many-to-Many relationship)

---

## ✨ IMPLEMENTASI RELASI

### Aggregation (GenreBuku di Buku):
```java
public class Buku {
    private GenreBuku genre;  // Pointer/Reference
    
    public Buku(..., GenreBuku genre) {
        this.genre = genre;  // Menunjuk ke object GenreBuku
    }
}
```

### Composition (List Buku di Member):
```java
public class Member {
    private List<Buku> bukuPinjaman; 
    
    public Member(...) {
        this.bukuPinjaman = new ArrayList<>();  
    }
    
    public void pinjamBuku(Buku buku) {
        if (buku.pinjamBuku()) {
            bukuPinjaman.add(buku);  
        }
    }
}
```

---

## 📐 SUMMARY DIAGRAM

```
┌─────────────────────────────────────────────────────────────┐
│                  PERPUSTAKAAN SYSTEM                         │
├─────────────────────────────────────────────────────────────┤
│                                                               │
│  GenreBuku (Master Data)                                    │
│      │                                                       │
│      │ 1:Many Aggregation                                   │
│      │                                                       │
│      └──► Buku (Products)                                   │
│               │                                              │
│               │ Many:Many Composition (via List)            │
│               │                                              │
│               └──► Member (Users/Transactions)              │
│                                                               │
└─────────────────────────────────────────────────────────────┘

Alur Data:
GenreBuku (1) ──contains──►  Buku (*)  ◄──borrowed by──  Member (*)
```

---

**Dokumentasi Class Diagram - Sistem Manajemen Perpustakaan**
*Dibuat untuk Tugas PBO*
