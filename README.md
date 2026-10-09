# Latihan Pewarisan (Inheritance) di Java: Bentuk, Bujur Sangkar, Lingkaran, dan Silinder

Proyek ini adalah latihan mata kuliah **Pemrograman Berorientasi Objek (PBO)** pertemuan 5 & 6. Tujuannya mempraktikkan konsep **pewarisan (inheritance)**
**Nama:** Naira Almira
**NIM:** F1D02510085
**Kelas:** B

---

## Struktur Pewarisan

```
Bentuk
 ├── BujurSangkar
 └── Lingkaran
       └── Silinder
```

- `BujurSangkar` dan `Lingkaran` sama-sama anak langsung dari `Bentuk`.
- `Silinder` adalah anak dari `Lingkaran`, sehingga secara tidak langsung juga turunan dari `Bentuk` (pewarisan bertingkat / *multilevel*).

---

## Daftar File

| File | Keterangan |
|---|---|
| `Bentuk.java` | Kelas induk paling atas. Menyimpan atribut `warna`. |
| `BujurSangkar.java` | Turunan `Bentuk`. Menambah atribut `sisi` dan perhitungan luas bujur sangkar. |
| `Lingkaran.java` | Turunan `Bentuk`. Menambah atribut `radius` dan perhitungan luas lingkaran. |
| `Silinder.java` | Turunan `Lingkaran`. Menambah atribut `tinggi` dan perhitungan volume silinder. |
| `Main.java` | Program utama untuk membuat objek dan menguji semua kelas. |

---

## Penjelasan Kelas

### `Bentuk`

| Anggota | Keterangan |
|---|---|
| `protected String warna` | Warna bentuk |
| `Bentuk(String warna)` | Konstruktor, mengisi `warna` |
| `getWarna()` | Mengembalikan nilai `warna` |
| `setWarna(String warna)` | Mengubah nilai `warna` |
| `printInfo()` | Mencetak `Bentuk berwarna [warna]` |

### `BujurSangkar` (extends `Bentuk`)

| Anggota | Keterangan |
|---|---|
| `double sisi` | Panjang sisi (`private`) |
| `BujurSangkar(double sisi, String warna)` | Konstruktor, memanggil `super(warna)` lalu mengisi `sisi` |
| `getSisi()` / `setSisi(double sisi)` | Membaca / mengubah `sisi` |
| `hitungLuas()` | Mengembalikan `sisi * sisi` |
| `printInfo()` | Mencetak `Bujur sangkar berwarna [warna], luas [luas]` |

### `Lingkaran` (extends `Bentuk`)

| Anggota | Keterangan |
|---|---|
| `double radius` | Jari-jari (`protected`) |
| `static final double PI` | Konstanta kelas untuk pi, nilainya `3.1428` |
| `Lingkaran(double radius, String warna)` | Konstruktor, memanggil `super(warna)` lalu mengisi `radius` |
| `getRadius()` / `setRadius(double r)` | Membaca / mengubah `radius` |
| `hitungLuas()` | Mengembalikan `PI * radius * radius` |
| `printInfo()` | Mencetak `Lingkaran [warna], luas = [luas]` |

### `Silinder` (extends `Lingkaran`)

| Anggota | Keterangan |
|---|---|
| `double tinggi` | Tinggi silinder (`private`) |
| `Silinder(double tinggi, double radius, String warna)` | Konstruktor, memanggil `super(radius, warna)` lalu mengisi `tinggi` |
| `getTinggi()` / `setTinggi(double t)` | Membaca / mengubah `tinggi` |
| `hitungVolume()` | Mengembalikan `hitungLuas() * tinggi` (memakai ulang rumus luas dari `Lingkaran`) |
| `printInfo()` | Mencetak `Silinder [warna], volume = [volume]` |

---

## Konsep OOP yang Diterapkan

1. **Pewarisan (`extends`)**: `BujurSangkar`, `Lingkaran`, dan `Silinder` tidak menulis ulang atribut `warna`; mereka mewarisinya dari `Bentuk`.
2. **Pemanggilan konstruktor induk (`super(...)`)**: setiap konstruktor anak memanggil `super(...)` pada **baris pertama** untuk meneruskan data ke kelas induknya. Urutan penyelesaian objek `Silinder` adalah `Bentuk` → `Lingkaran` → `Silinder`.
3. **Overriding**: method `printInfo()` didefinisikan ulang di setiap kelas anak sehingga tiap objek mencetak kalimatnya sendiri.
4. **Penggunaan ulang kode (*reusability*)**: `Silinder.hitungVolume()` memanggil `hitungLuas()` milik `Lingkaran`, tanpa menulis ulang rumus luas.
5. **Enkapsulasi**: atribut khusus tiap kelas (`sisi`, `tinggi`) dibuat `private` dan diakses lewat *getter* dan *setter*. Atribut `warna` dibuat `protected` agar hanya kelas turunan yang dapat memakainya langsung.

---

## Cara Menjalankan

Pastikan **JDK** (Java Development Kit) sudah terpasang, lalu buka terminal pada folder yang berisi kelima file `.java`.

**1. Kompilasi semua file:**

```bash
javac *.java
```

**2. Jalankan program utama:**

```bash
java Main
```

> Semua file harus berada di **folder yang sama**, dan nama setiap file harus sama persis dengan nama kelas `public` di dalamnya.

---

## Contoh Keluaran

Objek yang dibuat di `Main.java`:

| Objek | Parameter |
|---|---|
| `BujurSangkar` | sisi = 2, warna = Merah |
| `Lingkaran` | radius = 7, warna = Biru |
| `Silinder` | tinggi = 2, radius = 7, warna = Hijau |

Keluaran program:

```
Sisi bujur sangkar: 2.0
Bujur sangkar berwarna Merah, luas 4.0
Radius lingkaran: 7.0
Lingkaran Biru, luas = 153.9972
Tinggi silinder: 2.0
Silinder Hijau, volume = 307.9944
```

Cara menghitungnya:

- Luas bujur sangkar = 2 × 2 = **4.0**
- Luas lingkaran = 3.1428 × 7 × 7 = **153.9972**
- Volume silinder = luas lingkaran × tinggi = 153.9972 × 2 = **307.9944**
