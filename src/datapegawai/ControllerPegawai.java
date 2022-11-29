/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datapegawai;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ControllerPegawai {
    ArrayList<ModelPegawai> ArrayData;
    DefaultTableModel tabelModel;
    public ControllerPegawai () {
    ArrayData = new ArrayList<ModelPegawai> ();
    }
    public void InsertData (String nim, String nama,String jabatan, boolean gender) {
    ModelPegawai mhs = new ModelPegawai (nim, nama, jabatan, gender);
    ArrayData.add( mhs);
    }
    
    public DefaultTableModel showData() {
        
        String[] kolom = {"NIM", "Nama", "Jabatan", "Gender"}; 
        Object[][] objData = new Object [ArrayData.size()][4]; 
        int i=0;
        
        for (ModelPegawai n :ArrayData) {
            String[] arrData = {n.getNIM(), n.getNama (), n.getJabatan (), (n.isGender ()) ? "Pria": "Perempuan"}; 
            objData[i] = arrData;
            i++;
        }
        tabelModel = new DefaultTableModel(objData, kolom){
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        return tabelModel;
    }
}
    
    
    
    
    

