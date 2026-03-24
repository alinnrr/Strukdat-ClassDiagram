public class Peminjam extends Pengguna{
    private String nama;
    private String prodi;

    public Peminjam(String id, String nrp, String email, String noHp, String nama, String prodi) {
        super(id, nrp, email, noHp);
        this.nama = nama;
        this.prodi = prodi;
    }

    public String getNama() { return nama; }
    public String getProdi() { return prodi; }

    public void setNama(String nama) { this.nama = nama; }
    public void setProdi(String prodi) { this.prodi = prodi; }

    @Override
    public String getRole() {
        return "Mahasiswa - " + prodi;
    } 
}
