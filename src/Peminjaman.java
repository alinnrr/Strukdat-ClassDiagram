import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Peminjaman {
    private String id;
    private Peminjam peminjam;
    private Ruangan ruangan;
    private LocalDateTime mulai;
    private LocalDateTime selesai;
    private String keperluan;
    private StatusPeminjaman status;

    static final DateTimeFormatter FMT = 
        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

    public Peminjaman(String id, Peminjam peminjam, Ruangan ruangan, LocalDateTime mulai, LocalDateTime selesai, String keperluan) {
        this.id = id;
        this.peminjam = peminjam;
        this.ruangan = ruangan;
        this.mulai = mulai;
        this.selesai = selesai;
        this.keperluan = keperluan;
        this.status = StatusPeminjaman.MENUNGGU;
    }

    public String getId() { return id; }
    public Peminjam getPeminjam() { return peminjam; }
    public Ruangan getRuangan() { return ruangan; }
    public LocalDateTime getMulai() { return mulai; }
    public LocalDateTime getSelesai() { return selesai; }
    public String getKeperluan() { return keperluan; }
    public StatusPeminjaman getStatus() { return status; }

    public void setId(String id) { this.id = id; }
    public void setPeminjam(Peminjam peminjam) { this.peminjam = peminjam; }
    public void setRuangan(Ruangan ruangan) { this.ruangan = ruangan; }
    public void setMulai(LocalDateTime mulai) { this.mulai = mulai; }
    public void setSelesai (LocalDateTime selesai) { this.selesai = selesai; }
    public void setKeperluan(String keperluan) { this.keperluan = keperluan; }
    public void setStatus(StatusPeminjaman status) { this.status = status; }

    public void tampilkan() {
        System.out.println(" ID            : " + id);
        System.out.println(" Peminjam      : " + peminjam.getNama()
                                             + " (" + peminjam.getNrp() + ")");
        System.out.println(" Ruangan       :  " + ruangan.getNama());
        System.out.println(" Mulai         : " + mulai.format(FMT));
        System.out.println(" Selesai       : " + selesai.format(FMT));
        System.out.println(" Keperluan     : " + keperluan);
        System.out.println(" Status        : " + status);
    }
}
