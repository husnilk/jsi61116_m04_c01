package id.ac.unand.fti.si.pbo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

public class AppTest {
    
    @Test
    public void testClassBarangIsExists() {
        try{
            Class<?> barangClass = Class.forName("id.ac.unand.fti.si.pbo.Barang");
        }catch(ClassNotFoundException e){
            assertTrue(false, "Class Barang tidak ditemukan");
        }
    }
    
    @Test
    public void testConstructorIsExists(){
        try{
            Class<Barang> barangClass = Barang.class;
            Constructor<Barang> constr;
            constr = barangClass.getConstructor();
            constr = barangClass.getConstructor(String.class, String.class);
            constr = barangClass.getConstructor(String.class, String.class, Integer.class, Integer.class);
        }catch( NoSuchMethodException | SecurityException e){
            assertTrue(false, "Constructor kelas barang tidak sesuai dengan yang diminta");
        }
    }
    
    @Test
    public void testGetSetHargaJual(){
        try{
            Class<?> barangClass = Class.forName("id.ac.unand.fti.si.pbo.Barang");
            Class<?>[] params = {Integer.class};
            
            barangClass.getMethod("getHargaJual");
            barangClass.getMethod("setHargaJual", params);
            
            Barang barang = new Barang();
            barang.setHargaJual(10000);
            assertEquals(10000, barang.getHargaJual());
            
            barang.setHargaJual(-100);
            assertEquals(10000, barang.getHargaJual());
            
            barang.setHargaBeli(8000);
            barang.setHargaJual(6000);
            assertEquals(10000, barang.getHargaJual());
            
        }catch(ClassNotFoundException e){
            assertTrue(false, "Class Barang tidak ditemukan");
        } catch (NoSuchMethodException e) {
            assertTrue(false, "Method getHargaJual atau setHargaJual tidak ditemukan");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetSetHargaBeli(){
        
        try{
            Class<?> barangClass = Class.forName("id.ac.unand.fti.si.pbo.Barang");
            Class<?>[] params = {Integer.class};
            
            barangClass.getMethod("getHargaBeli");
            barangClass.getMethod("setHargaBeli", params);
            
            Barang barang = new Barang();
            barang.setHargaBeli(10000);
            assertEquals(10000, barang.getHargaBeli());
            
            barang.setHargaBeli(-100);
            assertEquals(10000, barang.getHargaBeli());
            
            
        }catch(ClassNotFoundException e){
            assertTrue(false, "Class Barang tidak ditemukan");
        } catch (NoSuchMethodException e) {
            assertTrue(false, "Method getHargaBeli atau setHargaBeli tidak ditemukan");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testGetSetDiskon(){
        try{
            Class<?> barangClass = Class.forName("id.ac.unand.fti.si.pbo.Barang");
            Class<?>[] params = {Double.class};
            
            barangClass.getMethod("getDiskon");
            barangClass.getMethod("setDiskon", params);
            
            Barang barang = new Barang();
            barang.setDiskon(0.2);
            assertEquals(0.2, barang.getDiskon());
            
            barang.setDiskon(-0.2);
            assertEquals(0.2, barang.getDiskon());
            
            
        }catch(ClassNotFoundException e){
            assertTrue(false, "Class Barang tidak ditemukan");
        } catch (NoSuchMethodException e) {
            assertTrue(false, "Method getDiskon atau setDiskon tidak ditemukan");
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testMethodTampilInfo(){
        try{
            String sku = "SKU111";
            String nama = "Indoheat Wave";
            Integer jumlah = 117;
            Double diskon = 0.111;
            Integer hargaBeli = 1001;
            Integer hargaJual = 1002;

            Class<?> barangClass = Class.forName("id.ac.unand.fti.si.pbo.Barang");
            barangClass.getMethod("tampilInfo");
            Barang barang = new Barang();
            barang.sku = sku;
            barang.nama = nama;
            barang.jumlah = jumlah;
            barang.setDiskon(diskon);
            barang.setHargaBeli(hargaBeli);
            barang.setHargaJual(hargaJual);
            
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            PrintStream stdout = System.out;
            System.setOut(ps);
            
            barang.tampilInfo();
            System.setOut(stdout);
            String outputText = byteArrayOutputStream.toString().trim();
            String[] sentences = outputText.split("\n");
            assertEquals("Kode : " + sku, sentences[0].trim());            
            assertEquals("Nama : "+ nama, sentences[1].trim());
            assertEquals("Harga Jual : " + hargaJual, sentences[2].trim());
            assertEquals("Harga Beli : " + hargaBeli, sentences[3].trim());
            assertEquals("Jumlah : " + jumlah, sentences[4].trim());
            assertEquals("Diskon : " + diskon, sentences[5].trim());
            
        }catch(ClassNotFoundException e){
            assertTrue(false, "Class Barang tidak ditemukan");
        } catch (NoSuchMethodException e) {
            assertTrue(false, "Method tampilInfo() tidak ditemukan");
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
