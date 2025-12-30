package model;

public class Petugas {
    private String id;
    private String nama;
    private boolean sedangMelayani;
    private Pelanggan pelangganSaatIni;

    public Petugas(String nama) {
        this.id = java.util.UUID.randomUUID().toString();
        this.nama = nama;
        this.sedangMelayani = false;
        this.pelangganSaatIni = null;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public boolean isSedangMelayani() {
        return sedangMelayani;
    }

    public Pelanggan getPelangganSaatIni() {
        return pelangganSaatIni;
    }

    public void mulaiLayanan(Pelanggan pelanggan) {
        this.pelangganSaatIni = pelanggan;
        this.sedangMelayani = true;
        pelanggan.setStatus("Dilayani");
    }

    public void selesaiLayanan() {
        if (this.pelangganSaatIni != null) {
            this.pelangganSaatIni.setStatus("Selesai");
        }
        this.pelangganSaatIni = null;
        this.sedangMelayani = false;
    }

    public String getStatusInfo() {
        if (sedangMelayani && pelangganSaatIni != null) {
            return "Melayani: " + pelangganSaatIni.toString();
        } else {
            return "Tersedia";
        }
    }
}
