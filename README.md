# 💸 Aplikasi Investasi Berbasis Konsol

Aplikasi ini adalah simulasi investasi berbasis konsol menggunakan Java. Program mendukung dua jenis pengguna yaitu **Admin** dan **Customer**. Admin dapat menambahkan dan mengelola instrumen investasi seperti **Saham** dan **SBN** (Surat Berharga Negara), sementara *Customer* dapat membeli, melihat, dan menjual portofolio mereka.

---

## 📌 Fitur Utama

### 🔐 Login
- User dibedakan menjadi Admin dan Customer.
- Validasi login dilakukan berdasarkan username dan password.

### 👤 Role-based Access
- *Admin:*
    - Menambah Saham dan SBN.
    - Mengubah harga saham.
    - Melihat daftar instrumen yang tersedia.
- *Customer:*
    - Melihat daftar saham dan SBN.
    - Membeli Saham dan SBN.
    - Menjual saham dari portofolio mereka.
    - Melihat portofolio pribadi.

### 📈 Saham
- Setiap saham memiliki kode, nama, dan harga.
- Customer dapat membeli dalam bentuk jumlah lembar.
- Admin dapat memperbarui harga saham yang telah ditambahkan.

### 🧾 SBN (Surat Berharga Negara)
- Terdapat kuota nasional dan tanggal jatuh tempo.
- Customer hanya bisa membeli jika kuota masih tersedia.
- Sistem menggunakan LocalDate untuk menangani tanggal jatuh tempo.

---

## 🚀 Cara Clone dan Menjalankan Program

### Prasyarat
- Sudah terinstall *Java JDK* (minimal Java 11)
- Optional: IDE seperti *IntelliJ IDEA, **VSCode, atau **NetBeans*

---

### A. Menjalankan Melalui IDE (Direkomendasikan)

1. *Clone repository dari GitHub*
   ```bash
   git clone https://github.com/sena-mashira/pbo-invest-cl.git

2. Buka folder project di IDE:
    - Di IntelliJ IDEA:
      `File > Open > Pilih folder hasil clone`
    - Di VSCode:
      `ZFile > Open Folder > Pilih folder hasil clone`

3. Pastikan struktur folder src/ dikenali sebagai Source Root.

4. Jalankan file Main.java sebagai Java Application.

### B. Menjalankan Melalui Command Line (CMD/Terminal)

1. **Clone repository dari GitHub**
   ```bash
   git clone https://github.com/sena-mashira/pbo-invest-cl.git
   cd pbo-invest-cl

2. Compile semua file Java
   ```bash
   javac -d out src/**/*.java

3. Jalankan program
   ```bash
   java -cp out Main

## 📸 Screenshot Program

Berikut adalah dokumentasi tampilan dari program dalam berbagai skenario:

### 1. Menu Login
Menampilkan antarmuka login untuk pengguna (Admin/Customer).

Gambar kiri adalah proses login yang **berhasil**, sedangkan kanan proses login yang gagal karena kredensial yang **tidak terdaftar**.


> Hardcode akun untuk login

| Username | Password |
|----------|----------|
| admin | admin123 |
| customer | customer123 |

<p>
<img src="doc/login-berhasil.png" alt="Login Berhasil" height="250"/>
<img src="doc/login-gagal.png" alt="Login Gagal" height="250"/>
</p>

---

### 2. Dashboard Admin
Tampilan menu setelah Admin berhasil login.

<img src="doc/dashboard-admin.png" alt="Dashboard Admin" width="300"/>

Kemudian jika input yang dimasukkan tidak sesuai, maka akan tampil pesan sebagai berikut:

<img src="doc/input-invalid-admin.png" alt="Input Invalid Admin" width="300"/>

---

### 3. Saham Admin
Tampilan Saham yang bisa diakses oleh Admin.

> Halaman Utama Saham

<img src="doc/saham-main.png" alt="Halaman Utama Saham" width="300"/>

> List Saham

<img src="doc/lihat-saham.png" alt="List Saham" width="500"/>

> Tambah Saham

Gambar kiri adalah proses  **Tambah Saham** yang **berhasil**, sedangkan kanan proses **Tambah Saham** yang gagal karena saham dengan kode yang sama **telah terdaftar**.

<p>
<img src="doc/tambah-saham-berhasil.png" alt="Tambah Saham Berhasil" height="250"/>
<img src="doc/tambah-saham-gagal.png" alt="Tambah Saham Gagal" height="250"/>
</p>

> Ubah Harga Saham

Gambar kiri adalah proses ubah harga saham yang **berhasil**, sedangkan kanan proses ubah saham yang gagal karena saham dengan kode tersebut **tidak terdaftar**.

<p>
<img src="doc/ubah-saham-berhasil.png" alt="Ubah Saham Berhasil" width="200"/>
<img src="doc/ubah-saham-gagal.png" alt="Ubah Saham Gagal" width="200"/>
</p>

---

### 4. SBN Admin
Tampilan SBN (Surat Berharga Negara) yang bisa diakses oleh Admin.

> Halaman Utama SBN

<img src="doc/sbn-main.png" alt="Halaman Utama SBN" width="300"/>

> List SBN

<img src="doc/lihat-sbn.png" alt="List SBN" width="500"/>

> Tambah SBN

Gambar kiri adalah proses **Tambah SBN** yang **berhasil**, sedangkan kanan proses **Tambah SBN** yang gagal karena SBN dengan kode yang sama **telah terdaftar**.

<p>
<img src="doc/tambah-sbn-berhasil.png" alt="Tambah SBN Berhasil" height="300"/>
<img src="doc/tambah-sbn-gagal.png" alt="Tambah SBN Gagal" height="300"/>
</p>

---

### 5. Dashboard Customer
Tampilan menu setelah Customer berhasil login.

<img src="doc/customer-main.png" alt="Halaman Utama Customer" width="300"/>

Kemudian jika input yang dimasukkan tidak sesuai, maka akan tampil pesan sebagai berikut:

<img src="doc/input-invalid-customer.png" alt="Input Invalid Customer" width="300"/>

---

### 6. Beli Saham
Tampilan menu ketika Customer ingin membeli sebuah saham.

Pertama sistem akan menampilkan **List Saham** yang tersedia, kemudian customer bisa membeli sesuai dengan list.

<img src="doc/beli-saham-berhasil.png" alt="Beli Saham Berhasil" width="500"/>

Namun bila jumlah lembar yang dimasukkan bernilai 0 (kiri) atau lebih dari jumlah yang tersedia (kanan), sistem akan menampilkan berikut:

<p>
<img src="doc/beli-saham-kurang.png" alt="Beli Saham Kurang" height="200"/>
<img src="doc/beli-saham-lebih.png" alt="Beli Saham Lebih" height="200"/>
</p>

---

### 7. Jual Saham
Tampilan menu ketika Customer ingin menjual saham yang dimiliki.

Pertama sistem akan menampilkan **List Saham** yang dimiliki, kemudian customer bisa menjual sesuai dengan list.

<img src="doc/jual-saham-berhasil.png" alt="Jual Saham Berhasil" width="600"/>

Namun bila jumlah lembar yang dimasukkan bernilai 0 (kiri) atau lebih dari jumlah yang tersedia (kanan), sistem akan menampilkan berikut:

<p>
<img src="doc/jual-saham-kurang.png" alt="Jual Saham Kurang" height="200"/>
<img src="doc/jual-saham-lebih.png" alt="Jual Saham Lebih" height="200"/>
</p>

Kemudian jika tidak memiliki saham dan memilih menu jual saham, maka akan tampil pesan sebagai berikut:

<img src="doc/jual-saham-kosong.png" alt="Saham Kosong" width="300"/>

---

### 8. Beli SBN
Tampilan menu ketika Customer ingin membeli sebuah SBN (Surat Berharga Negara).

Pertama sistem akan menampilkan **List SBN** yang tersedia, kemudian customer bisa menjual membeli dengan list.

<img src="doc/beli-sbn-berhasil.png" alt="Beli SBN Berhasil" width="600"/>

Namun bila jumlah kuota yang dimasukkan bernilai 0 (kiri) atau lebih dari jumlah yang tersedia (kanan), sistem akan menampilkan berikut:

<p>
<img src="doc/beli-sbn-kurang.png" alt="Beli SBN Kurang" height="200"/>
<img src="doc/beli-sbn-lebih.png" alt="Beli SBN Lebih" height="200"/>
</p>

---

### 9. Simulasi SBN
Tampilan menu ketika Customer ingin mensimulasikan SBN (Surat Berharga Negara) yang dimilki.

<img src="doc/simulasi-sbn.png" alt="Simulasi SBN" width="600"/>

Namun bila tidak memiliki sebuah SBN, maka akan ditampilkan seperti berikut:

<img src="doc/simulasi-kosong.png" alt="SBN Kosong" width="300"/>

---

### 10. Portofolio Saham dan SBN
Tampilan menu Portofolio Saham dan SBN (Surat Berharga Negara) yang dimilki.

<img src="doc/portofolio.png" alt="Portofolio" width="600"/>

Namun bila tidak memiliki Saham maupun SBN, maka akan ditampilkan seperti berikut:

<img src="doc/portofolio-kosong.png" alt="Portofolio Kosong" width="300"/>

---



## 📊 Diagram UML


<img src="doc/uml.png" alt="Portofolio Kosong" width="500"/>

---

## ✍️ Akhir Kata

Proyek ini dibuat dengan penuh semangat oleh **Anand** dan **Mawa**. *README* ini dibuat seperti sebuah buku, pantas ditutup dengan napas terakhir yang berbisik.

> "Kecil di repositori, besar di niat"