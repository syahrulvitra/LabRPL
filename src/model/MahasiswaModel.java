/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "mahasiswa")
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m"),
    @NamedQuery(name = "Mahasiswa.findByNpm", query = "SELECT m FROM Mahasiswa m WHERE m.npm = :npm"),
    @NamedQuery(name = "Mahasiswa.findByNama", query = "SELECT m FROM Mahasiswa m WHERE m.nama = :nama"),
    @NamedQuery(name = "Mahasiswa.findByKelas", query = "SELECT m FROM Mahasiswa m WHERE m.kelas = :kelas"),
    @NamedQuery(name = "Mahasiswa.findByAlamat", query = "SELECT m FROM Mahasiswa m WHERE m.alamat = :alamat")})
public class MahasiswaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "npm")
    private String npm;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Column(name = "kelas")
    private String kelas;
    @Basic(optional = false)
    @Column(name = "alamat")
    private String alamat;

    public MahasiswaModel() {
    }

    public MahasiswaModel(String npm) {
        this.npm = npm;
    }

    public MahasiswaModel(String npm, String nama, String kelas, String alamat) {
        this.npm = npm;
        this.nama = nama;
        this.kelas = kelas;
        this.alamat = alamat;
    }

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (npm != null ? npm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MahasiswaModel)) {
            return false;
        }
        MahasiswaModel other = (MahasiswaModel) object;
        if ((this.npm == null && other.npm != null) || (this.npm != null && !this.npm.equals(other.npm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Mahasiswa[ npm=" + npm + " ]";
    }
    
}
