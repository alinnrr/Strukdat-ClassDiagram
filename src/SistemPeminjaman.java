import java.time.LocalDateTime;
import java.util.ArrayList;

public class SistemPeminjaman {
    private String namaLab;
    private ArrayList<Ruangan> ruanganList = new ArrayList<>();
    private ArrayList<Peminjaman> peminjamanList = new ArrayList<>();
    private int counter = 1;

    public SistemPeminjaman(String namaLab) {
        this.namaLab = namaLab;
    }
    
    public String getNamaLab() { return namaLab; }
    public ArrayList<Ruangan> getRuanganList() { return ruanganList; }
    public ArrayList<Peminjaman> getPeminjamanList() { return peminjamanList; }
    public void setNamaLab(String namalab) { this.namaLab = namalab; }

    public void tambahRuangan (Ruangan r) {
        ruanganList.add(r);
    }

    public Ruangan cariRuangan(String id) {
        for (Ruangan r : ruanganList) {
            if (r.getId().equals(id)) return r;
        }
        return null;
    }

    public Peminjaman ajukan(Peminjam peminjam, String idRuangan, LocalDateTime mulai, LocalDateTime selesai, String keperluan) {
        System.out.println("\n[SISTEM] Pengajuan dari " + peminjam.getNama() + "...");

    if (!JamKerja.cek(mulai)) {
        System.out.println("[GAGAL] "
            + JamKerja.namaHari(mulai.getDayOfWeek())
            + " " + mulai.toLocalTime()
            + " di luar jam kerja (Senin - Jumat 08:00 - 16:00).");
        return null;
    }

    if (!JamKerja.cek(selesai)) {
        System.out.println("[GAGAL] Waktu selesai di luar jam kerja.");
        return null;
    }

    Ruangan r = cariRuangan(idRuangan);
    if (r == null) {
        System.out.println("[GAGAL] Ruangan tidak ditemukan.");
        return null;
    }

    if (!r.isTersedia()) {
        System.out.println("[GAGAL] Ruangan sedang dipinjam.");
        return null;
    }

    String id = String.format("PJM-%03d", counter++);
    Peminjaman p = new Peminjaman(id, peminjam, r, mulai, selesai, keperluan);
    peminjamanList.add(p);
    System.out.println("[OK] Berhasil diajukan dengan ID : " + id);
    return p;
    }

    public void tampilkanSemua() {
        System.out.println("\n=== RIWAYAT PEMINJAMAN LAB " + namaLab + " ===");
        for (Peminjaman p : peminjamanList) {
            p.tampilkan();
            System.out.println(" ===");
        }
    }

    public void tampilkanRuangan() {
        System.out.println("\n=== DAFTAR RUANGAN LAB " + namaLab + " ===");
        for (Ruangan r : ruanganList) {
            r.tampilkan();
        }
    }

 }
