
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class Kopi {
    String namapembeli;
    Integer kode;

    public Kopi(String namapembeli, Integer kode, String namabrg, Integer jumlah) {
        this.namapembeli = namapembeli;
        this.kode = kode;
        this.namabrg = namabrg;
        this.jumlah = jumlah;
    }
    String namabrg;
    Integer jumlah;

   

    public Integer getKode() {
        return kode;
    }

    public void setKode(Integer kode) {
        this.kode = kode;
    }

    public String getNamabrg() {
        return namabrg;
    }

    public void setNamabrg(String namabrg) {
        this.namabrg = namabrg;
    }

    public String getNamapembeli() {
        return namapembeli;
    }

    public void setNamapembeli(String namapembeli) {
        this.namapembeli = namapembeli;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "Kopi{" + "kode=" + kode + ", namabrg=" + namabrg + ", namapembeli=" + namapembeli + ", jumlah=" + jumlah + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.kode);
        hash = 89 * hash + Objects.hashCode(this.namabrg);
        hash = 89 * hash + Objects.hashCode(this.namapembeli);
        hash = 89 * hash + Objects.hashCode(this.jumlah);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Kopi other = (Kopi) obj;
        if (!Objects.equals(this.namabrg, other.namabrg)) {
            return false;
        }
        if (!Objects.equals(this.namapembeli, other.namapembeli)) {
            return false;
        }
        if (!Objects.equals(this.kode, other.kode)) {
            return false;
        }
        if (!Objects.equals(this.jumlah, other.jumlah)) {
            return false;
        }
        return true;
    }




}
