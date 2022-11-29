/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datapegawai;

public class ModelPegawai{
    private String nim;
    private String nama;
    private String jabatan;
    private boolean gender;
    
    public ModelPegawai (String nim, String nama, String jabatan, boolean gender) {
        this.nim = nim;
        this.nama = nama;
        this.jabatan = jabatan;
        this.gender = gender;
    }

   
    public String getNIM () {
        return nim;
    }
    public String getNama () {
        return nama;
    }
    public void setNama (String nama) {
        this.nama = nama;
    }
    public String getJabatan () {
        return jabatan;
    }
    public void setJabatan () {
        this.jabatan = jabatan;
    }
    public boolean isGender () {
        return gender;
    }
    public void setGender (boolean gender) {
        this.gender = gender;
    }
}
