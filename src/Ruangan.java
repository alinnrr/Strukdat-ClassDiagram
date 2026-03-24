public class Ruangan {
    private String id;
    private String nama;
    private int kapasitas;
    private String fasilitas;
    private boolean tersedia;

    public Ruangan(String id, String nama, int kapasitas, String fasilitas ) {
        this.id = id;
        this.nama = nama;
        this.kapasitas = kapasitas;
        this.fasilitas = fasilitas;
        this.tersedia = true;
    }
    public String getId() { return id; }
    public String getNama() { return nama; }
    public int  getKapasitas() { return kapasitas; }
    public String getFasilitas() { return fasilitas; }
    public boolean isTersedia() { return tersedia; }

    public void setId(String id) { this.id = id; }
    public void setNama(String nama) { this.nama = nama; }
    public void setKapasitas(int kapasitas) { this.kapasitas = kapasitas; }
    public void setFasilitas(String fasilitas) { this.fasilitas = fasilitas; }
    public void setTersedia(boolean tersedia) { this.tersedia = tersedia; }

    public void tampilkan() {
        System.out.println(" [" + id + "] " + nama
            + " | Kapasitas: " + kapasitas
            + " |Fasilitas: " + fasilitas
            + " |Status: " + (tersedia? "Tersedia" : "Sedang Dalam Peminjaman"));
    }
}
