import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        SistemPeminjaman sistem = new SistemPeminjaman("KCKS");

        sistem.tambahRuangan(new Ruangan("R-01", "Lab KCKS A", 30, "PC, Proyektor, AC"));
        sistem.tambahRuangan(new Ruangan("R-02", "Lab KCKS B", 25, "PC, Layar, AC"));
        sistem.tambahRuangan(new Ruangan("R-03", "Ruangan Server KCKS", 10, "Server rack, AC, Proyektor"));
        sistem.tampilkanRuangan();

        Peminjam Alin = new Peminjam("U-01", "5027251002", "5027251002@student.its.ac.id", "0896111222333", "Ferlin Erdina", "Teknologi Informasi" );
        Peminjam Dian = new Peminjam("U-02", "5025251031", "5025251031@student.its.ac.id", "0896111333444", "Dian Piramidiana", "Sistem Informasi" );
        Peminjam Donna = new Peminjam("U-01", "5027251011", "5027251011@student.its.ac.id", "0896111222444", "Donnavie Putri", "Teknologi Informasi" );
        Peminjam Aura = new Peminjam("U-03", "5024251012", "5024251012@student.its.ac.id", "0896111555777", "Aura Sabila", "Teknik Komputer" );
        Peminjam Arra = new Peminjam("U-02", "5025251044", "5025251044@student.its.ac.id", "0896111333888", "Arrumanta Ekna", "Sistem Informasi" );
        Peminjam Catur = new Peminjam("U-03", "5024251066", "5024251066@student.its.ac.id", "0896111555999", "Catur Setyo", "Teknik Komputer" );
        Admin admin = new Admin ("A-01", "ADM001", "handramanudinata@lab.ac.id", "088641234", "Dr. Hendra Manudinata", "Kepala Lab");

        System.out.println("\n=== PROSES PEMINJAMAN ===");

        Peminjaman pA = sistem.ajukan(Alin, "R-01",
            LocalDateTime.of(2026,1, 6, 9, 0),
            LocalDateTime.of(2026, 1, 6, 11, 0), "Praktikum Struktur Data" );
        Peminjaman pB = sistem.ajukan(Dian, "R-02", 
            LocalDateTime.of(2026, 1, 10, 14, 0),
            LocalDateTime.of(2026, 1, 10, 16, 0), "Praktikum SISOP");

        sistem.ajukan(Donna, "R-01",
            LocalDateTime.of(2026, 1, 11, 10, 0),
            LocalDateTime.of(2026, 1, 11, 12, 0), "Praktikum SBD");
        sistem.ajukan(Aura, "R-03",
            LocalDateTime.of(2026, 1, 6, 7, 0),
            LocalDateTime.of(2026, 1, 6, 9, 0), "Belajar Jaringan Komputer");
        sistem.ajukan(Arra, "R-02",
            LocalDateTime.of(2025, 1, 8,  17, 0),
            LocalDateTime.of(2025, 1, 8,  18, 0), "Belajar Kalkulus");     
        sistem.ajukan(Catur, "R-03",
            LocalDateTime.of(2025, 1, 12, 10, 0),
            LocalDateTime.of(2025, 1, 12, 12, 0), "Persiapan Lomba");  

        Peminjaman pG = sistem.ajukan(Dian, "R-02",
            LocalDateTime.of(2026, 1, 9, 10, 0),
            LocalDateTime.of(2026, 1, 9, 12, 0), "REVISI LAPRES SISOP");

        System.out.println("\n=== Proses ADMIN ===");
        if (pA != null) admin.setujui(pA);
        if (pB != null) admin.tolak(pB, "Ruangan dipakai kegiatan dosen");
        if (pG != null) admin.setujui(pG);
        if (pA != null) admin.selesaikan(pA);

        sistem.tampilkanSemua();
        sistem.tampilkanRuangan();
    }
}
