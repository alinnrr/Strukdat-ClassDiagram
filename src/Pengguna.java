public abstract class Pengguna {
    private String id;
    private String nrp;
    private String email;
    private String noHp;

    public Pengguna(String id, String nrp, String email, String noHp) {
        this.id = id;
        this.nrp = nrp;
        this.email = email;
        this.noHp = noHp;
    }
    public String getId () { return id; }
    public String getNrp() { return nrp; }
    public String getEmail() { return email; }
    public String getNoHp() { return noHp; }

    public void setId(String id) { this.id = id; }
    public void setNrp(String nrp) { this.nrp = nrp; }
    public void setEmail(String email) { this.email = email; }
    public void setNoHp(String noHp) {this.noHp = noHp; }

    public abstract String getRole();
}
