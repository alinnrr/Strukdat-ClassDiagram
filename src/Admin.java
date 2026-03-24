public class Admin extends Pengguna {
    private String nama;
    private String jabatan;
    
    public Admin(String id, String nrp, String email, String noHp, String nama, String jabatan) {
        super(id, nrp, email, noHp);
        this.nama = nama;
        this.jabatan = jabatan;
    }

    public String getNama() { return nama; }
    public String getJabatan() { return jabatan; }

    public void setNama(String nama) { this.nama = nama; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    @Override
    public String getRole() {
        return "Admin - " + jabatan;
    }

    public void setujui(Peminjaman p) {
        if (p.getStatus() == StatusPeminjaman.MENUNGGU) {
            p.setStatus(StatusPeminjaman.DISETUJUI);
            p.getRuangan().setTersedia(false);
            System.out.println("[ADMIN] " + p.getId() + " disetujui oleh " + nama);
        }
    }

    public void tolak(Peminjaman p, String alasan) {
        if (p.getStatus() == StatusPeminjaman.MENUNGGU) {
            p.setStatus(StatusPeminjaman.DITOLAK);
            System.out.println("[ADMIN] " + p.getId() + " ditolak. Alasan: " + alasan);
        }
    }

    public void selesaikan(Peminjaman p) {
        if (p.getStatus() == StatusPeminjaman.DISETUJUI) {
            p.setStatus(StatusPeminjaman.SELESAI);
            p.getRuangan().setTersedia(true);
            System.out.println("[ADMIN] " + p.getId() + " selesai. ");
        }
    }
}
