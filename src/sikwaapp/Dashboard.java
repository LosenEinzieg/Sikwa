/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sikwaapp;

import config.Koneksi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Ade Arif R
 */
public class Dashboard extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    DefaultTableModel tabModel1;
    DefaultTableModel tabModel2;
    DefaultTableModel tabModel3;
    DefaultTableModel tabModelkas;
    ResultSet RsDashboard=null;
    
    protected void kosong(){
        jTextBeritaAcara.setText("");
        jTextKetBerita.setText("");
        jTextIdKas.setText("");     
        jTextDeskripsiKas.setText("");    
        jTextNominalKas.setText("0");      
        jComboBoxJenisKas.setSelectedIndex(0);   
        jTextNamaIuran.setText("");
        jDateIuran.setDate(null);
        jTextIuranB.setText("0");
        jTextIuranT.setText("0");
        jTextIuranTotal.setText("0");
        jComboKetIuran.setSelectedItem("");      
    }

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        tampilDataPndk();
        tampilDataTamu();
        tampilDataBerita();
        tampilDataKas();
        tampilDataIuran();
        Tampil_Jam();
        Tampil_Tanggal();
              
        //Menambahkan Icon Aplikasi
        Image icon = new ImageIcon(this.getClass().getResource("/img/icon.png")).getImage();
        this.setIconImage(icon);
    }
    
    public void tampilDataPndk(){
        try{
            Object[] judul_kolom = {"No", "NIK Penduduk", "Nama Penduduk", "Unit", "Blok", "Tahun Masuk", "Waktu Daftar"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTablePndk.setModel(tabModel);
            jTablePndk.setRowHeight(25);
            jTablePndk.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            jTablePndk.getTableHeader().setForeground(new Color(0,51,51));
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_penduduk ");  
            while(RsDashboard.next()){
                Object[] data={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("nik"),
                    RsDashboard.getString("namapnd"),
                    RsDashboard.getString("unit"),
                    RsDashboard.getString("blok"),
                    RsDashboard.getString("tahunmasuk"),
                    RsDashboard.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    public void tampilDataTamu(){
        try{
            Object[] judul_kolom1 = {"No", "Nama Tamu", "Jenis Kelamin", "Alamat", "No. HP", "Keterangan", "Waktu Masuk"};
            tabModel1=new DefaultTableModel(null,judul_kolom1);
            jTableTamu.setModel(tabModel1);
            jTableTamu.setRowHeight(25);
            jTableTamu.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            jTableTamu.getTableHeader().setForeground(new Color(0,51,51));
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel1.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_tamu ");  
            while(RsDashboard.next()){
                Object[] data1={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("nama"),
                    RsDashboard.getString("jk"),
                    RsDashboard.getString("alamat"),
                    RsDashboard.getString("hp"),
                    RsDashboard.getString("keperluan"),
                    RsDashboard.getString("waktumasuk")
                };
               tabModel1.addRow(data1);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    public void tampilDataBerita(){
        try{
            Object[] judul_kolom2 = {"No", "Berita Acara", "Keterangan"};
            tabModel2=new DefaultTableModel(null,judul_kolom2);
            jTableBerita.setModel(tabModel2);
            jTableBerita.setRowHeight(25);
            jTableBerita.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            jTableBerita.getTableHeader().setForeground(new Color(0,51,51));
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel2.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_berita ");  
            while(RsDashboard.next()){
                Object[] data2={
                    RsDashboard.getString("ID"),
                    RsDashboard.getString("Berita_Acara"),
                    RsDashboard.getString("Keterangan"),
                };
               tabModel2.addRow(data2);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    public void tampilDataKas(){
        try{
            Object[] judul_kolom_kas = {"No", "Deskripsi", "Jenis Kas", "Nominal"};
            tabModelkas=new DefaultTableModel(null,judul_kolom_kas);
            jTableKas.setModel(tabModelkas);
            jTableKas.setRowHeight(25);
            jTableKas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            jTableKas.getTableHeader().setForeground(new Color(0,51,51));
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModelkas.getDataVector().removeAllElements();
            
//            long masuk = 0;
//            long keluar = 0;
            String masuk = ""; 
            String keluar = ""; 
            RsDashboard=stt.executeQuery("SELECT * from dft_kas ");  
            while(RsDashboard.next()){
                Object[] data2={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("deskripsi"),
                    RsDashboard.getString("jenis"),
                    RsDashboard.getString("nominal"),
//                    long = long + Integer.parseInt(RsDashboard.getString("nominal")),
                };
               tabModelkas.addRow(data2);
            }      
            RsDashboard=stt.executeQuery("SELECT sum(nominal) as masuk FROM `dft_kas` WHERE jenis = 'Masuk'");  
            while(RsDashboard.next()){
                Object[] data2={
                    masuk = RsDashboard.getString("masuk"),
//                    long = long + Integer.parseInt(RsDashboard.getString("nominal")),
                };
            }         
            jTextTotalKasMasuk.setText(masuk);
            RsDashboard=stt.executeQuery("SELECT sum(nominal) as keluar FROM `dft_kas` WHERE jenis = 'Keluar'");  
            while(RsDashboard.next()){
                Object[] data2={
                    keluar = RsDashboard.getString("keluar"),
//                    long = long + Integer.parseInt(RsDashboard.getString("nominal")),
                };
            }         
            jTextTotalKasKeluar.setText(keluar);
            int tot_masuk = Integer.parseInt(masuk);
            int tot_keluar = Integer.parseInt(keluar);
            int tot_kas = tot_masuk - tot_keluar;
            String total_kas = Integer.toString(tot_kas);
            jTextTotalKas.setText(total_kas);
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    
    public void tampilDataIuran(){
        try{
            Object[] judul_kolom3 = {"No", "Nama Warga", "Tanggal", "Iuran Bulanan", "Iuran Tahunan", "Total Bayar", "Keterangan"};
            tabModel3=new DefaultTableModel(null,judul_kolom3);
            jTableIuran.setModel(tabModel3);
            jTableIuran.setRowHeight(25);
            jTableIuran.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
            jTableIuran.getTableHeader().setForeground(new Color(0,51,51));
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel3.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_iuran ");  
            while(RsDashboard.next()){
                Object[] data3={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("nama"),
                    RsDashboard.getString("tanggal"),
                    RsDashboard.getString("iuran_bulanan"),
                    RsDashboard.getString("iuran_tahunan"),
                    RsDashboard.getString("total_bayar"),
                    RsDashboard.getString("keterangan")
                };
               tabModel3.addRow(data3);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    public void hitung_total_iuran() {
        String iuranb = jTextIuranB.getText(); 
        String iurant = jTextIuranT.getText();
        int iuran_bulan = Integer.parseInt(iuranb);
        int iuran_tahun = Integer.parseInt(iurant);
        int tot_iuran = iuran_bulan + iuran_tahun;
        String total_iuran = Integer.toString(tot_iuran);
        jTextIuranTotal.setText(total_iuran);
    } 
      
    public void Tampil_Jam(){
        ActionListener taskPerformer = new ActionListener() {
 
        @Override
            public void actionPerformed(ActionEvent evt) {
            String nol_jam = "", nol_menit = "",nol_detik = "";
 
            java.util.Date dateTime = new java.util.Date();
            int nilai_jam = dateTime.getHours();
            int nilai_menit = dateTime.getMinutes();
            int nilai_detik = dateTime.getSeconds();
 
            if(nilai_jam <= 9) nol_jam= "0";
            if(nilai_menit <= 9) nol_menit= "0";
            if(nilai_detik <= 9) nol_detik= "0";
 
            String jam = nol_jam + Integer.toString(nilai_jam);
            String menit = nol_menit + Integer.toString(nilai_menit);
            String detik = nol_detik + Integer.toString(nilai_detik);
 
            Jam.setText(jam+":"+menit+":"+detik+"");
            Jam1.setText(jam+":"+menit+":"+detik+"");
            Jam2.setText(jam+":"+menit+":"+detik+"");
            Jam3.setText(jam+":"+menit+":"+detik+"");
            Jam4.setText(jam+":"+menit+":"+detik+"");
            Jam5.setText(jam+":"+menit+":"+detik+"");
            Jam6.setText(jam+":"+menit+":"+detik+"");
            }
        };
    new Timer(1000, taskPerformer).start();
    }   
 
    public void Tampil_Tanggal() {
        java.util.Date tglsekarang = new java.util.Date();
        SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd MMMMMMMMM yyyy", Locale.getDefault());
        String tanggal = smpdtfmt.format(tglsekarang);
        Tanggal.setText(tanggal);
        Tanggal1.setText(tanggal);
        Tanggal2.setText(tanggal);
        Tanggal3.setText(tanggal);
        Tanggal4.setText(tanggal);
        Tanggal5.setText(tanggal);
        Tanggal6.setText(tanggal);
    }  
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Menu_Panel = new javax.swing.JPanel();
        Logo_Sikwa = new javax.swing.JLabel();
        sikwa = new javax.swing.JLabel();
        sikwa_full = new javax.swing.JLabel();
        List_Menu = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btn_laporan = new javax.swing.JButton();
        btn_home = new javax.swing.JButton();
        btn_berita = new javax.swing.JButton();
        btn_kas = new javax.swing.JButton();
        btn_tamu = new javax.swing.JButton();
        btn_iuran = new javax.swing.JButton();
        btn_penduduk = new javax.swing.JButton();
        Main_Panel = new javax.swing.JPanel();
        panel_dashboard = new javax.swing.JPanel();
        header_dashboard = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Tanggal = new javax.swing.JLabel();
        Jam = new javax.swing.JLabel();
        Label_Role = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panel_penduduk = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        header_penduduk = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        Tanggal1 = new javax.swing.JLabel();
        Jam1 = new javax.swing.JLabel();
        Label_Role1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Filter_Pndk = new javax.swing.JTextField();
        btn_tambahpndk = new javax.swing.JButton();
        btn_editpndk = new javax.swing.JButton();
        btn_hapuspndk = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePndk = new javax.swing.JTable();
        panel_tamu = new javax.swing.JPanel();
        header_tamu = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        Tanggal2 = new javax.swing.JLabel();
        Jam2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        Label_Role2 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Filter_Tamu = new javax.swing.JTextField();
        btn_tambahtamu = new javax.swing.JButton();
        btn_edittamu = new javax.swing.JButton();
        btn_hapustamu = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTamu = new javax.swing.JTable();
        panel_berita = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        header_berita = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        Tanggal3 = new javax.swing.JLabel();
        Jam3 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        Label_Role3 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        Filter_Berita = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableBerita = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btn_tambahberita = new javax.swing.JButton();
        btn_editberita = new javax.swing.JButton();
        btn_hapusberita = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextBeritaAcara = new javax.swing.JTextArea();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextKetBerita = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextIdBerita = new javax.swing.JTextField();
        panel_kas = new javax.swing.JPanel();
        header_kas = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        Tanggal4 = new javax.swing.JLabel();
        Jam4 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Label_Role4 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        btn_tambahkas = new javax.swing.JButton();
        btn_editkas = new javax.swing.JButton();
        btn_hapuskas = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jTextDeskripsiKas = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jTextNominalKas = new javax.swing.JTextField();
        jComboBoxJenisKas = new javax.swing.JComboBox<>();
        jTextIdKas = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        Filter_Berita1 = new javax.swing.JTextField();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTableKas = new javax.swing.JTable();
        jLabel73 = new javax.swing.JLabel();
        jTextTotalKasMasuk = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        jTextTotalKasKeluar = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextTotalKas = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        panel_iuran = new javax.swing.JPanel();
        header_iuran = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        Tanggal5 = new javax.swing.JLabel();
        Jam5 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        Label_Role5 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        btn_tambahiuran = new javax.swing.JButton();
        btn_editiuran = new javax.swing.JButton();
        btn_hapusiuran = new javax.swing.JButton();
        jLabel57 = new javax.swing.JLabel();
        jTextNamaIuran = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextIuranB = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        jTextIuranT = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jTextIuranTotal = new javax.swing.JTextField();
        jLabel63 = new javax.swing.JLabel();
        jComboKetIuran = new javax.swing.JComboBox<>();
        jDateIuran = new com.toedter.calendar.JDateChooser();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableIuran = new javax.swing.JTable();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        Filter_Iuran = new javax.swing.JTextField();
        jTextIdIuran = new javax.swing.JTextField();
        panel_laporan = new javax.swing.JPanel();
        header_laporan = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        Tanggal6 = new javax.swing.JLabel();
        Jam6 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        Label_Role6 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard SIKWA");
        setBackground(new java.awt.Color(51, 51, 53));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        Menu_Panel.setBackground(new java.awt.Color(0, 153, 153));
        Menu_Panel.setPreferredSize(new java.awt.Dimension(250, 804));

        Logo_Sikwa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_neighbour_120px.png"))); // NOI18N

        sikwa.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        sikwa.setForeground(new java.awt.Color(255, 255, 255));
        sikwa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sikwa.setText("SIKWA");

        sikwa_full.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        sikwa_full.setForeground(new java.awt.Color(255, 255, 255));
        sikwa_full.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sikwa_full.setText("Sistem Aplikasi Keamanan Warga");

        List_Menu.setBackground(new java.awt.Color(0, 51, 51));
        List_Menu.setForeground(new java.awt.Color(255, 255, 255));

        jLabel19.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(187, 226, 232));
        jLabel19.setText("Laporan ----------------------------");

        jLabel20.setFont(new java.awt.Font("Palatino Linotype", 1, 15)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(187, 226, 232));
        jLabel20.setText("Data Master ----------------------");

        btn_laporan.setBackground(new java.awt.Color(0, 51, 51));
        btn_laporan.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        btn_laporan.setForeground(new java.awt.Color(255, 255, 255));
        btn_laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_print_30px.png"))); // NOI18N
        btn_laporan.setText("Laporan");
        btn_laporan.setBorderPainted(false);
        btn_laporan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_laporan.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_laporanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_laporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_laporanMouseExited(evt);
            }
        });
        btn_laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laporanActionPerformed(evt);
            }
        });

        btn_home.setBackground(new java.awt.Color(0, 51, 51));
        btn_home.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        btn_home.setForeground(new java.awt.Color(255, 255, 255));
        btn_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_home_30px_1.png"))); // NOI18N
        btn_home.setText("Halaman Utama");
        btn_home.setBorderPainted(false);
        btn_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_home.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_homeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_homeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_homeMouseExited(evt);
            }
        });
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        btn_berita.setBackground(new java.awt.Color(0, 51, 51));
        btn_berita.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        btn_berita.setForeground(new java.awt.Color(255, 255, 255));
        btn_berita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_news_30px.png"))); // NOI18N
        btn_berita.setText("Berita");
        btn_berita.setBorderPainted(false);
        btn_berita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_berita.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_berita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_beritaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_beritaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_beritaMouseExited(evt);
            }
        });
        btn_berita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_beritaActionPerformed(evt);
            }
        });

        btn_kas.setBackground(new java.awt.Color(0, 51, 51));
        btn_kas.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        btn_kas.setForeground(new java.awt.Color(255, 255, 255));
        btn_kas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_info_30px_1.png"))); // NOI18N
        btn_kas.setText("Informasi Kas");
        btn_kas.setBorderPainted(false);
        btn_kas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_kas.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_kas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_kasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_kasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_kasMouseExited(evt);
            }
        });
        btn_kas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_kasActionPerformed(evt);
            }
        });

        btn_tamu.setBackground(new java.awt.Color(0, 51, 51));
        btn_tamu.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        btn_tamu.setForeground(new java.awt.Color(255, 255, 255));
        btn_tamu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_list_30px.png"))); // NOI18N
        btn_tamu.setText("Daftar Tamu");
        btn_tamu.setBorderPainted(false);
        btn_tamu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_tamu.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_tamu.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btn_tamuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                btn_tamuFocusLost(evt);
            }
        });
        btn_tamu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tamuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tamuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tamuMouseExited(evt);
            }
        });
        btn_tamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tamuActionPerformed(evt);
            }
        });

        btn_iuran.setBackground(new java.awt.Color(0, 51, 51));
        btn_iuran.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        btn_iuran.setForeground(new java.awt.Color(255, 255, 255));
        btn_iuran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_info_30px_1.png"))); // NOI18N
        btn_iuran.setText("Informasi Iuran");
        btn_iuran.setBorderPainted(false);
        btn_iuran.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_iuran.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_iuran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_iuranMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_iuranMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_iuranMouseExited(evt);
            }
        });
        btn_iuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iuranActionPerformed(evt);
            }
        });

        btn_penduduk.setBackground(new java.awt.Color(0, 51, 51));
        btn_penduduk.setFont(new java.awt.Font("Palatino Linotype", 0, 14)); // NOI18N
        btn_penduduk.setForeground(new java.awt.Color(255, 255, 255));
        btn_penduduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_list_30px.png"))); // NOI18N
        btn_penduduk.setText("Daftar Penduduk");
        btn_penduduk.setBorderPainted(false);
        btn_penduduk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_penduduk.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_penduduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_pendudukMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_pendudukMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_pendudukMouseExited(evt);
            }
        });
        btn_penduduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pendudukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout List_MenuLayout = new javax.swing.GroupLayout(List_Menu);
        List_Menu.setLayout(List_MenuLayout);
        List_MenuLayout.setHorizontalGroup(
            List_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, List_MenuLayout.createSequentialGroup()
                .addGroup(List_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, List_MenuLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(List_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(List_MenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(List_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_penduduk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_tamu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_berita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_kas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_iuran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_laporan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        List_MenuLayout.setVerticalGroup(
            List_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(List_MenuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_home)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(btn_penduduk)
                .addGap(18, 18, 18)
                .addComponent(btn_tamu)
                .addGap(18, 18, 18)
                .addComponent(btn_berita)
                .addGap(18, 18, 18)
                .addComponent(btn_kas)
                .addGap(18, 18, 18)
                .addComponent(btn_iuran)
                .addGap(21, 21, 21)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(btn_laporan)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Menu_PanelLayout = new javax.swing.GroupLayout(Menu_Panel);
        Menu_Panel.setLayout(Menu_PanelLayout);
        Menu_PanelLayout.setHorizontalGroup(
            Menu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu_PanelLayout.createSequentialGroup()
                .addGroup(Menu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Menu_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(List_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Menu_PanelLayout.createSequentialGroup()
                        .addGroup(Menu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Menu_PanelLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(sikwa))
                            .addGroup(Menu_PanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(Logo_Sikwa)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(sikwa_full, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Menu_PanelLayout.setVerticalGroup(
            Menu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu_PanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(Logo_Sikwa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(sikwa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sikwa_full, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(List_Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Main_Panel.setBackground(new java.awt.Color(0, 153, 153));
        Main_Panel.setLayout(new java.awt.CardLayout());

        panel_dashboard.setBackground(new java.awt.Color(0, 153, 153));
        panel_dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_dashboard.setBackground(new java.awt.Color(187, 226, 232));

        jLabel5.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("Halaman Utama >> ");

        jLabel6.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Info");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Keluar");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_40px.png"))); // NOI18N
        jLabel8.setText(" ");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_about_40px.png"))); // NOI18N
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        Tanggal.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Tanggal.setForeground(new java.awt.Color(0, 153, 153));
        Tanggal.setText(".");

        Jam.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Jam.setForeground(new java.awt.Color(0, 153, 153));
        Jam.setText(".");

        Icon_Daftar_Akun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_account_40px.png"))); // NOI18N
        Icon_Daftar_Akun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Icon_Daftar_Akun.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Icon_Daftar_AkunMouseClicked(evt);
            }
        });

        Label_Daftar_Akun.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Label_Daftar_Akun.setForeground(new java.awt.Color(0, 153, 153));
        Label_Daftar_Akun.setText("Daftar Akun");
        Label_Daftar_Akun.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Label_Role.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        Label_Role.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout header_dashboardLayout = new javax.swing.GroupLayout(header_dashboard);
        header_dashboard.setLayout(header_dashboardLayout);
        header_dashboardLayout.setHorizontalGroup(
            header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_dashboardLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(Tanggal)
                .addGap(18, 18, 18)
                .addComponent(Jam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_dashboardLayout.createSequentialGroup()
                        .addComponent(Icon_Daftar_Akun)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_dashboardLayout.createSequentialGroup()
                        .addComponent(Label_Daftar_Akun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)))
                .addGap(28, 28, 28))
        );
        header_dashboardLayout.setVerticalGroup(
            header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_dashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Icon_Daftar_Akun, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(Label_Daftar_Akun))
                .addGap(42, 42, 42))
            .addGroup(header_dashboardLayout.createSequentialGroup()
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_dashboardLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(Label_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(header_dashboardLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tanggal)
                            .addComponent(Jam))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_dashboard.add(header_dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pngwing.com (5).png"))); // NOI18N
        panel_dashboard.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        Main_Panel.add(panel_dashboard, "card2");

        panel_penduduk.setBackground(new java.awt.Color(0, 153, 153));
        panel_penduduk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Cari / Filter :");
        panel_penduduk.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        header_penduduk.setBackground(new java.awt.Color(187, 226, 232));

        jLabel25.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 153, 153));
        jLabel25.setText("Daftar Penduduk >>");

        Tanggal1.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Tanggal1.setForeground(new java.awt.Color(0, 153, 153));
        Tanggal1.setText(".");

        Jam1.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Jam1.setForeground(new java.awt.Color(0, 153, 153));
        Jam1.setText(".");

        Label_Role1.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        Label_Role1.setForeground(new java.awt.Color(0, 153, 153));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_40px.png"))); // NOI18N
        jLabel12.setText(" ");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Keluar");
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout header_pendudukLayout = new javax.swing.GroupLayout(header_penduduk);
        header_penduduk.setLayout(header_pendudukLayout);
        header_pendudukLayout.setHorizontalGroup(
            header_pendudukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_pendudukLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel25)
                .addGap(6, 6, 6)
                .addComponent(Label_Role1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(Tanggal1)
                .addGap(18, 18, 18)
                .addComponent(Jam1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 372, Short.MAX_VALUE)
                .addGroup(header_pendudukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addGap(37, 37, 37))
        );
        header_pendudukLayout.setVerticalGroup(
            header_pendudukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_pendudukLayout.createSequentialGroup()
                .addGroup(header_pendudukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_pendudukLayout.createSequentialGroup()
                        .addGroup(header_pendudukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(header_pendudukLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel25))
                            .addGroup(header_pendudukLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(Label_Role1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(header_pendudukLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(Tanggal1))
                            .addGroup(header_pendudukLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(Jam1)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_pendudukLayout.createSequentialGroup()
                        .addGap(0, 12, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)))
                .addContainerGap())
        );

        panel_penduduk.add(header_penduduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel28.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_User_Groups_30px_1.png"))); // NOI18N
        jLabel28.setText("Daftar Penduduk");
        panel_penduduk.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px_1.png"))); // NOI18N
        panel_penduduk.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("___________________");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel_penduduk.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        Filter_Pndk.setBackground(new java.awt.Color(0, 153, 153));
        Filter_Pndk.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        Filter_Pndk.setForeground(new java.awt.Color(255, 255, 255));
        Filter_Pndk.setBorder(null);
        Filter_Pndk.setOpaque(false);
        Filter_Pndk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Filter_PndkKeyTyped(evt);
            }
        });
        panel_penduduk.add(Filter_Pndk, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 165, 130, 20));

        btn_tambahpndk.setBackground(new java.awt.Color(0, 153, 0));
        btn_tambahpndk.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_tambahpndk.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambahpndk.setText("Tambah");
        btn_tambahpndk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahpndkActionPerformed(evt);
            }
        });
        panel_penduduk.add(btn_tambahpndk, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, 100, -1));

        btn_editpndk.setBackground(new java.awt.Color(153, 153, 0));
        btn_editpndk.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_editpndk.setForeground(new java.awt.Color(255, 255, 255));
        btn_editpndk.setText("Edit");
        btn_editpndk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editpndkMouseClicked(evt);
            }
        });
        btn_editpndk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editpndkActionPerformed(evt);
            }
        });
        panel_penduduk.add(btn_editpndk, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 100, -1));

        btn_hapuspndk.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapuspndk.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_hapuspndk.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapuspndk.setText("Hapus");
        btn_hapuspndk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapuspndkActionPerformed(evt);
            }
        });
        panel_penduduk.add(btn_hapuspndk, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 630, 100, -1));

        jTablePndk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "NIK Penduduk", "Nama Penduduk", "Unit", "Blok", "Tahun Masuk", "Waktu Daftar"
            }
        ));
        jTablePndk.setFocusable(false);
        jTablePndk.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTablePndk.setRowHeight(25);
        jTablePndk.setSelectionBackground(new java.awt.Color(0, 51, 51));
        jTablePndk.setShowVerticalLines(false);
        jTablePndk.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTablePndk);
        if (jTablePndk.getColumnModel().getColumnCount() > 0) {
            jTablePndk.getColumnModel().getColumn(3).setHeaderValue("No. HP");
            jTablePndk.getColumnModel().getColumn(4).setHeaderValue("Keterangan");
            jTablePndk.getColumnModel().getColumn(5).setHeaderValue("Waktu Masuk");
            jTablePndk.getColumnModel().getColumn(6).setHeaderValue("Waktu Daftar");
        }

        panel_penduduk.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 960, 400));

        Main_Panel.add(panel_penduduk, "card3");

        panel_tamu.setBackground(new java.awt.Color(0, 153, 153));
        panel_tamu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_tamu.setBackground(new java.awt.Color(187, 226, 232));

        jLabel30.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 153));
        jLabel30.setText("Daftar Tamu >>");

        Tanggal2.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Tanggal2.setForeground(new java.awt.Color(0, 153, 153));
        Tanggal2.setText(".");

        Jam2.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Jam2.setForeground(new java.awt.Color(0, 153, 153));
        Jam2.setText(".");

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_40px.png"))); // NOI18N
        jLabel31.setText(" ");
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 153, 153));
        jLabel32.setText("Keluar");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Label_Role2.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        Label_Role2.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout header_tamuLayout = new javax.swing.GroupLayout(header_tamu);
        header_tamu.setLayout(header_tamuLayout);
        header_tamuLayout.setHorizontalGroup(
            header_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_tamuLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Role2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(Tanggal2)
                .addGap(18, 18, 18)
                .addComponent(Jam2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 513, Short.MAX_VALUE)
                .addGroup(header_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31))
                .addGap(33, 33, 33))
        );
        header_tamuLayout.setVerticalGroup(
            header_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_tamuLayout.createSequentialGroup()
                .addGroup(header_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_tamuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel32))
                    .addGroup(header_tamuLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(header_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Role2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(header_tamuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel30)
                                .addComponent(Tanggal2)
                                .addComponent(Jam2)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_tamu.add(header_tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel48.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_User_Groups_30px_1.png"))); // NOI18N
        jLabel48.setText("Daftar Tamu");
        panel_tamu.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel22.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Cari / Filter :");
        panel_tamu.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px_1.png"))); // NOI18N
        panel_tamu.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("___________________");
        jLabel49.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel_tamu.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        Filter_Tamu.setBackground(new java.awt.Color(0, 153, 153));
        Filter_Tamu.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        Filter_Tamu.setForeground(new java.awt.Color(255, 255, 255));
        Filter_Tamu.setBorder(null);
        Filter_Tamu.setOpaque(false);
        Filter_Tamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_TamuActionPerformed(evt);
            }
        });
        Filter_Tamu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Filter_TamuKeyTyped(evt);
            }
        });
        panel_tamu.add(Filter_Tamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 165, 130, 20));

        btn_tambahtamu.setBackground(new java.awt.Color(0, 153, 0));
        btn_tambahtamu.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_tambahtamu.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambahtamu.setText("Tambah");
        btn_tambahtamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahtamuActionPerformed(evt);
            }
        });
        panel_tamu.add(btn_tambahtamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, 100, -1));

        btn_edittamu.setBackground(new java.awt.Color(153, 153, 0));
        btn_edittamu.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_edittamu.setForeground(new java.awt.Color(255, 255, 255));
        btn_edittamu.setText("Edit");
        btn_edittamu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_edittamuMouseClicked(evt);
            }
        });
        btn_edittamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edittamuActionPerformed(evt);
            }
        });
        panel_tamu.add(btn_edittamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 100, -1));

        btn_hapustamu.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapustamu.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_hapustamu.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapustamu.setText("Hapus");
        btn_hapustamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapustamuActionPerformed(evt);
            }
        });
        panel_tamu.add(btn_hapustamu, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 630, 100, -1));

        jTableTamu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Tamu", "Jenis Kelamin", "Alamat", "No. HP", "Keterangan", "Waktu Masuk"
            }
        ));
        jTableTamu.setFocusable(false);
        jTableTamu.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableTamu.setRowHeight(25);
        jTableTamu.setSelectionBackground(new java.awt.Color(0, 51, 51));
        jTableTamu.setShowVerticalLines(false);
        jTableTamu.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableTamu);
        if (jTableTamu.getColumnModel().getColumnCount() > 0) {
            jTableTamu.getColumnModel().getColumn(3).setHeaderValue("Alamat");
            jTableTamu.getColumnModel().getColumn(4).setHeaderValue("No. HP");
            jTableTamu.getColumnModel().getColumn(5).setHeaderValue("Keterangan");
            jTableTamu.getColumnModel().getColumn(6).setHeaderValue("Waktu Masuk");
        }

        panel_tamu.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 960, 400));

        Main_Panel.add(panel_tamu, "card4");

        panel_berita.setBackground(new java.awt.Color(0, 153, 153));
        panel_berita.setForeground(new java.awt.Color(0, 153, 153));
        panel_berita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("BERITA / PENGUMUMAN");
        panel_berita.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        header_berita.setBackground(new java.awt.Color(187, 226, 232));

        jLabel33.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 153, 153));
        jLabel33.setText("Berita >>");

        Tanggal3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Tanggal3.setForeground(new java.awt.Color(0, 153, 153));
        Tanggal3.setText(".");

        Jam3.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Jam3.setForeground(new java.awt.Color(0, 153, 153));
        Jam3.setText(".");

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_40px.png"))); // NOI18N
        jLabel34.setText(" ");
        jLabel34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel34MouseClicked(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 153, 153));
        jLabel35.setText("Keluar");
        jLabel35.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Label_Role3.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        Label_Role3.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout header_beritaLayout = new javax.swing.GroupLayout(header_berita);
        header_berita.setLayout(header_beritaLayout);
        header_beritaLayout.setHorizontalGroup(
            header_beritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_beritaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Role3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(257, 257, 257)
                .addComponent(Tanggal3)
                .addGap(18, 18, 18)
                .addComponent(Jam3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                .addGroup(header_beritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35)
                    .addComponent(jLabel34))
                .addGap(33, 33, 33))
        );
        header_beritaLayout.setVerticalGroup(
            header_beritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_beritaLayout.createSequentialGroup()
                .addGroup(header_beritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_beritaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel35))
                    .addGroup(header_beritaLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(header_beritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Role3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(header_beritaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel33)
                                .addComponent(Tanggal3)
                                .addComponent(Jam3)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_berita.add(header_berita, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel50.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_news_30px.png"))); // NOI18N
        jLabel50.setText("Daftar Berita");
        panel_berita.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel23.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Cari / Filter :");
        panel_berita.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px_1.png"))); // NOI18N
        panel_berita.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("___________________");
        jLabel51.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel_berita.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        Filter_Berita.setBackground(new java.awt.Color(0, 153, 153));
        Filter_Berita.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        Filter_Berita.setForeground(new java.awt.Color(255, 255, 255));
        Filter_Berita.setBorder(null);
        Filter_Berita.setOpaque(false);
        Filter_Berita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_BeritaActionPerformed(evt);
            }
        });
        Filter_Berita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Filter_BeritaKeyTyped(evt);
            }
        });
        panel_berita.add(Filter_Berita, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 165, 130, 20));

        jTableBerita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "No", "Berita Acara", "Keterangan"
            }
        ));
        jTableBerita.setFocusable(false);
        jTableBerita.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableBerita.setRowHeight(25);
        jTableBerita.setSelectionBackground(new java.awt.Color(0, 51, 51));
        jTableBerita.setShowVerticalLines(false);
        jTableBerita.getTableHeader().setReorderingAllowed(false);
        jTableBerita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableBeritaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jTableBerita);

        panel_berita.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 480, 440));

        jSeparator2.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator2.setForeground(new java.awt.Color(0, 51, 51));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setMinimumSize(new java.awt.Dimension(10, 100));
        jSeparator2.setPreferredSize(new java.awt.Dimension(100, 10));
        panel_berita.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 10, 440));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jPanel5.setBackground(new java.awt.Color(187, 226, 232));

        jLabel27.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 153));
        jLabel27.setText("Ubah Data Berita");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(108, 108, 108))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel27)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        btn_tambahberita.setBackground(new java.awt.Color(0, 153, 0));
        btn_tambahberita.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_tambahberita.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambahberita.setText("Tambah");
        btn_tambahberita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahberitaActionPerformed(evt);
            }
        });

        btn_editberita.setBackground(new java.awt.Color(153, 153, 0));
        btn_editberita.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_editberita.setForeground(new java.awt.Color(255, 255, 255));
        btn_editberita.setText("Edit");
        btn_editberita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editberitaMouseClicked(evt);
            }
        });
        btn_editberita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editberitaActionPerformed(evt);
            }
        });

        btn_hapusberita.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapusberita.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_hapusberita.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapusberita.setText("Hapus");
        btn_hapusberita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusberitaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Berita Acara");

        jTextBeritaAcara.setColumns(20);
        jTextBeritaAcara.setLineWrap(true);
        jTextBeritaAcara.setRows(3);
        jScrollPane3.setViewportView(jTextBeritaAcara);

        jLabel16.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Keterangan");

        jTextKetBerita.setColumns(20);
        jTextKetBerita.setLineWrap(true);
        jTextKetBerita.setRows(3);
        jTextKetBerita.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTextKetBerita);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btn_tambahberita, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btn_editberita, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btn_hapusberita, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambahberita)
                    .addComponent(btn_editberita)
                    .addComponent(btn_hapusberita))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_berita.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 440, 440));

        jPanel4.setBackground(new java.awt.Color(187, 226, 232));

        jLabel26.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 153, 153));
        jLabel26.setText("Tambah Data Penduduk");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(101, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(98, 98, 98))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel26)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        panel_berita.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 479, -1));

        jTextIdBerita.setEditable(false);
        jTextIdBerita.setBorder(null);
        panel_berita.add(jTextIdBerita, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, -1, -1));

        Main_Panel.add(panel_berita, "card5");

        panel_kas.setBackground(new java.awt.Color(0, 153, 153));
        panel_kas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_kas.setBackground(new java.awt.Color(187, 226, 232));

        jLabel36.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 153, 153));
        jLabel36.setText("Informasi Kas >>");

        Tanggal4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Tanggal4.setForeground(new java.awt.Color(0, 153, 153));
        Tanggal4.setText(".");

        Jam4.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Jam4.setForeground(new java.awt.Color(0, 153, 153));
        Jam4.setText(".");

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_40px.png"))); // NOI18N
        jLabel37.setText(" ");
        jLabel37.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel37MouseClicked(evt);
            }
        });

        jLabel38.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 153, 153));
        jLabel38.setText("Keluar");
        jLabel38.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Label_Role4.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        Label_Role4.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout header_kasLayout = new javax.swing.GroupLayout(header_kas);
        header_kas.setLayout(header_kasLayout);
        header_kasLayout.setHorizontalGroup(
            header_kasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_kasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Role4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(Tanggal4)
                .addGap(18, 18, 18)
                .addComponent(Jam4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                .addGroup(header_kasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37))
                .addGap(33, 33, 33))
        );
        header_kasLayout.setVerticalGroup(
            header_kasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_kasLayout.createSequentialGroup()
                .addGroup(header_kasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_kasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel38))
                    .addGroup(header_kasLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(header_kasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Role4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(header_kasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel36)
                                .addComponent(Tanggal4)
                                .addComponent(Jam4)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_kas.add(header_kas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel39.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Informasi Kas");
        panel_kas.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

        jLabel67.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_news_30px.png"))); // NOI18N
        jLabel67.setText("Daftar Kas");
        panel_kas.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jPanel10.setBackground(new java.awt.Color(0, 51, 51));

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(187, 226, 232));

        jLabel68.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 153, 153));
        jLabel68.setText("Ubah Data Kas");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel68)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel68)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 416, -1));

        btn_tambahkas.setBackground(new java.awt.Color(0, 153, 0));
        btn_tambahkas.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_tambahkas.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambahkas.setText("Tambah");
        btn_tambahkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahkasActionPerformed(evt);
            }
        });
        jPanel11.add(btn_tambahkas, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 364, 100, -1));

        btn_editkas.setBackground(new java.awt.Color(153, 153, 0));
        btn_editkas.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_editkas.setForeground(new java.awt.Color(255, 255, 255));
        btn_editkas.setText("Edit");
        btn_editkas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editkasMouseClicked(evt);
            }
        });
        btn_editkas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editkasActionPerformed(evt);
            }
        });
        jPanel11.add(btn_editkas, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 364, 100, -1));

        btn_hapuskas.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapuskas.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_hapuskas.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapuskas.setText("Hapus");
        btn_hapuskas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapuskasActionPerformed(evt);
            }
        });
        jPanel11.add(btn_hapuskas, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 364, 100, -1));

        jLabel18.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Deskripsi Kas");
        jPanel11.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 30));

        jTextDeskripsiKas.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jPanel11.add(jTextDeskripsiKas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 140, -1));

        jLabel69.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("Jenis Kas");
        jPanel11.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 30));

        jLabel70.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(255, 255, 255));
        jLabel70.setText("Nominal");
        jPanel11.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, 30));

        jTextNominalKas.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jTextNominalKas.setText("0");
        jTextNominalKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNominalKasActionPerformed(evt);
            }
        });
        jTextNominalKas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextNominalKasKeyReleased(evt);
            }
        });
        jPanel11.add(jTextNominalKas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 140, -1));

        jComboBoxJenisKas.setFont(new java.awt.Font("Palatino Linotype", 0, 20)); // NOI18N
        jComboBoxJenisKas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Masuk", "Keluar" }));
        jPanel11.add(jComboBoxJenisKas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 140, -1));

        jTextIdKas.setEditable(false);
        jTextIdKas.setBackground(new java.awt.Color(0, 153, 153));
        jTextIdKas.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jTextIdKas.setForeground(new java.awt.Color(0, 153, 153));
        jTextIdKas.setBorder(null);
        jTextIdKas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIdKasActionPerformed(evt);
            }
        });
        jTextIdKas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextIdKasKeyReleased(evt);
            }
        });
        jPanel11.add(jTextIdKas, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 298, 140, -1));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_kas.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 440, 440));

        jLabel71.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("Cari / Filter :");
        panel_kas.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px_1.png"))); // NOI18N
        panel_kas.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("___________________");
        jLabel61.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel_kas.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        Filter_Berita1.setBackground(new java.awt.Color(0, 153, 153));
        Filter_Berita1.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        Filter_Berita1.setForeground(new java.awt.Color(255, 255, 255));
        Filter_Berita1.setBorder(null);
        Filter_Berita1.setOpaque(false);
        Filter_Berita1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_Berita1ActionPerformed(evt);
            }
        });
        Filter_Berita1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Filter_Berita1KeyTyped(evt);
            }
        });
        panel_kas.add(Filter_Berita1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 165, 130, 20));

        jTableKas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Deskripsi", "Jenis Kas", "Nominal"
            }
        ));
        jTableKas.setFocusable(false);
        jTableKas.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableKas.setRowHeight(25);
        jTableKas.setSelectionBackground(new java.awt.Color(0, 51, 51));
        jTableKas.setShowVerticalLines(false);
        jTableKas.getTableHeader().setReorderingAllowed(false);
        jTableKas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKasMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(jTableKas);

        panel_kas.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 480, 350));

        jLabel73.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("Kas Masuk");
        panel_kas.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, -1, -1));

        jTextTotalKasMasuk.setEditable(false);
        jTextTotalKasMasuk.setBackground(new java.awt.Color(0, 153, 153));
        jTextTotalKasMasuk.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jTextTotalKasMasuk.setForeground(new java.awt.Color(255, 255, 255));
        jTextTotalKasMasuk.setText("0");
        jTextTotalKasMasuk.setBorder(null);
        jTextTotalKasMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTotalKasMasukActionPerformed(evt);
            }
        });
        panel_kas.add(jTextTotalKasMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 130, -1));

        jLabel74.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("Kas Keluar");
        panel_kas.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, -1, -1));

        jTextTotalKasKeluar.setEditable(false);
        jTextTotalKasKeluar.setBackground(new java.awt.Color(0, 153, 153));
        jTextTotalKasKeluar.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jTextTotalKasKeluar.setForeground(new java.awt.Color(255, 255, 255));
        jTextTotalKasKeluar.setText("0");
        jTextTotalKasKeluar.setBorder(null);
        panel_kas.add(jTextTotalKasKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 610, 130, -1));

        jLabel17.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Total Kas");
        panel_kas.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 570, -1, -1));

        jTextTotalKas.setEditable(false);
        jTextTotalKas.setBackground(new java.awt.Color(0, 153, 153));
        jTextTotalKas.setFont(new java.awt.Font("Monospaced", 0, 20)); // NOI18N
        jTextTotalKas.setForeground(new java.awt.Color(255, 255, 255));
        jTextTotalKas.setText("0");
        jTextTotalKas.setBorder(null);
        panel_kas.add(jTextTotalKas, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 130, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator4.setForeground(new java.awt.Color(0, 51, 51));
        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator4.setMinimumSize(new java.awt.Dimension(10, 100));
        jSeparator4.setPreferredSize(new java.awt.Dimension(100, 10));
        panel_kas.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 10, 440));

        Main_Panel.add(panel_kas, "card6");

        panel_iuran.setBackground(new java.awt.Color(0, 153, 153));
        panel_iuran.setForeground(new java.awt.Color(0, 153, 153));
        panel_iuran.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_iuran.setBackground(new java.awt.Color(187, 226, 232));

        jLabel40.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 153, 153));
        jLabel40.setText("Informasi Iuran >>");

        Tanggal5.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Tanggal5.setForeground(new java.awt.Color(0, 153, 153));
        Tanggal5.setText(".");

        Jam5.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Jam5.setForeground(new java.awt.Color(0, 153, 153));
        Jam5.setText(".");

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_40px.png"))); // NOI18N
        jLabel41.setText(" ");
        jLabel41.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 153, 153));
        jLabel42.setText("Keluar");
        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Label_Role5.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        Label_Role5.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout header_iuranLayout = new javax.swing.GroupLayout(header_iuran);
        header_iuran.setLayout(header_iuranLayout);
        header_iuranLayout.setHorizontalGroup(
            header_iuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_iuranLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Role5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(Tanggal5)
                .addGap(18, 18, 18)
                .addComponent(Jam5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                .addGroup(header_iuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addComponent(jLabel41))
                .addGap(33, 33, 33))
        );
        header_iuranLayout.setVerticalGroup(
            header_iuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_iuranLayout.createSequentialGroup()
                .addGroup(header_iuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_iuranLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel41)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42))
                    .addGroup(header_iuranLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(header_iuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Role5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(header_iuranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel40)
                                .addComponent(Tanggal5)
                                .addComponent(Jam5)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_iuran.add(header_iuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel43.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Informasi Iuran");
        panel_iuran.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));

        jPanel8.setBackground(new java.awt.Color(187, 226, 232));

        jLabel52.setFont(new java.awt.Font("Palatino Linotype", 1, 23)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 153, 153));
        jLabel52.setText("Form Input Iuran");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel52)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        btn_tambahiuran.setBackground(new java.awt.Color(0, 153, 0));
        btn_tambahiuran.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_tambahiuran.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambahiuran.setText("Tambah");
        btn_tambahiuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahiuranActionPerformed(evt);
            }
        });

        btn_editiuran.setBackground(new java.awt.Color(153, 153, 0));
        btn_editiuran.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_editiuran.setForeground(new java.awt.Color(255, 255, 255));
        btn_editiuran.setText("Edit");
        btn_editiuran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editiuranMouseClicked(evt);
            }
        });
        btn_editiuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editiuranActionPerformed(evt);
            }
        });

        btn_hapusiuran.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapusiuran.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_hapusiuran.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapusiuran.setText("Hapus");
        btn_hapusiuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusiuranActionPerformed(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Nama");

        jTextNamaIuran.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jTextNamaIuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNamaIuranActionPerformed(evt);
            }
        });

        jLabel58.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("Tanggal");

        jLabel59.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("Iuran Bulanan");

        jTextIuranB.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jTextIuranB.setText("0");
        jTextIuranB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIuranBActionPerformed(evt);
            }
        });
        jTextIuranB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextIuranBKeyReleased(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Iuran Tahunan");

        jTextIuranT.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jTextIuranT.setText("0");
        jTextIuranT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIuranTActionPerformed(evt);
            }
        });
        jTextIuranT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextIuranTKeyReleased(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("Total Bayar");

        jTextIuranTotal.setEditable(false);
        jTextIuranTotal.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jTextIuranTotal.setText("0");
        jTextIuranTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIuranTotalActionPerformed(evt);
            }
        });

        jLabel63.setFont(new java.awt.Font("Palatino Linotype", 0, 16)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Keterangan");

        jComboKetIuran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Pilih Status-", "Lunas", "Belum Lunas" }));
        jComboKetIuran.setPreferredSize(new java.awt.Dimension(56, 30));

        jDateIuran.setFont(new java.awt.Font("Palatino Linotype", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel57))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextNamaIuran)
                            .addComponent(jDateIuran, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addGap(11, 11, 11)
                        .addComponent(jTextIuranB))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60)
                            .addComponent(jLabel63)
                            .addComponent(jLabel62))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextIuranT)
                            .addComponent(jTextIuranTotal)
                            .addComponent(jComboKetIuran, 0, 138, Short.MAX_VALUE))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tambahiuran)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_editiuran, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapusiuran, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextNamaIuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel58, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jDateIuran, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextIuranB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextIuranT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextIuranTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboKetIuran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambahiuran, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapusiuran)
                    .addComponent(btn_editiuran))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panel_iuran.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 340, 440));

        jSeparator3.setBackground(new java.awt.Color(0, 51, 51));
        jSeparator3.setForeground(new java.awt.Color(0, 51, 51));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setMinimumSize(new java.awt.Dimension(10, 100));
        jSeparator3.setPreferredSize(new java.awt.Dimension(100, 10));
        panel_iuran.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 200, 10, 440));

        jTableIuran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "No", "Nama Warga", "Tanggal", "Iuran Bulanan", "Iuran Tahunan", "Total Bayar", "Keterangan"
            }
        ));
        jTableIuran.setFocusable(false);
        jTableIuran.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTableIuran.setRowHeight(25);
        jTableIuran.setSelectionBackground(new java.awt.Color(0, 51, 51));
        jTableIuran.setShowVerticalLines(false);
        jTableIuran.getTableHeader().setReorderingAllowed(false);
        jTableIuran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableIuranMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTableIuran);

        panel_iuran.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 600, 440));

        jLabel53.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_Money_Transfer_30px.png"))); // NOI18N
        jLabel53.setText("Daftar Iuran Warga");
        panel_iuran.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel54.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("Cari / Filter :");
        panel_iuran.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 160, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("___________________");
        jLabel55.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        panel_iuran.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 170, -1, -1));

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_search_30px_1.png"))); // NOI18N
        panel_iuran.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 150, -1, -1));

        Filter_Iuran.setBackground(new java.awt.Color(0, 153, 153));
        Filter_Iuran.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        Filter_Iuran.setForeground(new java.awt.Color(255, 255, 255));
        Filter_Iuran.setBorder(null);
        Filter_Iuran.setOpaque(false);
        Filter_Iuran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Filter_IuranActionPerformed(evt);
            }
        });
        Filter_Iuran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Filter_IuranKeyTyped(evt);
            }
        });
        panel_iuran.add(Filter_Iuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 165, 130, 20));

        jTextIdIuran.setEditable(false);
        jTextIdIuran.setBackground(new java.awt.Color(0, 153, 153));
        jTextIdIuran.setBorder(null);
        jTextIdIuran.setOpaque(false);
        panel_iuran.add(jTextIdIuran, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 40, -1));

        Main_Panel.add(panel_iuran, "card7");

        panel_laporan.setBackground(new java.awt.Color(0, 153, 153));
        panel_laporan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header_laporan.setBackground(new java.awt.Color(187, 226, 232));

        jLabel44.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 153, 153));
        jLabel44.setText("Cetak Laporan >>");

        Tanggal6.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Tanggal6.setForeground(new java.awt.Color(0, 153, 153));
        Tanggal6.setText(".");

        Jam6.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        Jam6.setForeground(new java.awt.Color(0, 153, 153));
        Jam6.setText(".");

        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_logout_40px.png"))); // NOI18N
        jLabel45.setText(" ");
        jLabel45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Palatino Linotype", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 153, 153));
        jLabel46.setText("Keluar");
        jLabel46.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Label_Role6.setFont(new java.awt.Font("Palatino Linotype", 1, 20)); // NOI18N
        Label_Role6.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout header_laporanLayout = new javax.swing.GroupLayout(header_laporan);
        header_laporan.setLayout(header_laporanLayout);
        header_laporanLayout.setHorizontalGroup(
            header_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_laporanLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Role6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170)
                .addComponent(Tanggal6)
                .addGap(18, 18, 18)
                .addComponent(Jam6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 387, Short.MAX_VALUE)
                .addGroup(header_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46)
                    .addComponent(jLabel45))
                .addGap(33, 33, 33))
        );
        header_laporanLayout.setVerticalGroup(
            header_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_laporanLayout.createSequentialGroup()
                .addGroup(header_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(header_laporanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46))
                    .addGroup(header_laporanLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(header_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_Role6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(header_laporanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel44)
                                .addComponent(Tanggal6)
                                .addComponent(Jam6)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_laporan.add(header_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel47.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Cetak Laporan");
        panel_laporan.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setBackground(new java.awt.Color(187, 226, 232));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Laporan Daftar Penduduk");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(187, 226, 232));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Laporan Daftar Tamu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(187, 226, 232));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Laporan Iuran Warga");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(187, 226, 232));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Laporan Kas Warga");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(187, 226, 232));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Laporan Berita Acara");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(56, 56, 56)
                .addComponent(jButton2)
                .addGap(64, 64, 64)
                .addComponent(jButton3)
                .addGap(62, 62, 62)
                .addComponent(jButton4)
                .addGap(62, 62, 62)
                .addComponent(jButton5)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panel_laporan.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 280, 430));

        Main_Panel.add(panel_laporan, "card8");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(Menu_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(Main_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Menu_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Main_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1269, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Icon_Daftar_AkunMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Icon_Daftar_AkunMouseClicked
        // TODO add your handling code here:
        new RegisUw().setVisible(true);        
    }//GEN-LAST:event_Icon_Daftar_AkunMouseClicked

    private void Filter_PndkKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Filter_PndkKeyTyped
        // TODO add your handling code here:
        try{
            String key = Filter_Pndk.getText();
            Object[] judul_kolom = {"No", "NIK Penduduk", "Nama Penduduk", "Unit", "Blok", "Tahun Masuk", "Waktu Dibuat"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTablePndk.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_penduduk WHERE namapnd LIKE '%"+key+"%'");  
            while(RsDashboard.next()){
                Object[] data={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("nik"),
                    RsDashboard.getString("namapnd"),
                    RsDashboard.getString("unit"),
                    RsDashboard.getString("blok"),
                    RsDashboard.getString("tahunmasuk"),
                    RsDashboard.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }   
    }//GEN-LAST:event_Filter_PndkKeyTyped

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel34MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel34MouseClicked

    private void jLabel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel37MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel45MouseClicked

    private void btn_tambahpndkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahpndkActionPerformed
        // TODO add your handling code here:
        new Input_Data().setVisible(true);
    }//GEN-LAST:event_btn_tambahpndkActionPerformed

    private void btn_editpndkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editpndkActionPerformed
        // TODO add your handling code here:
        Edit_Data jdata = new Edit_Data();
        try{
            int bar = jTablePndk.getSelectedRow();
            String nik = tabModel.getValueAt(bar, 1).toString();
            String namapnd = tabModel.getValueAt(bar, 2).toString();
            String unit = tabModel.getValueAt(bar, 3).toString();
            String blok = tabModel.getValueAt(bar, 4).toString();
            String tahunmasuk = tabModel.getValueAt(bar, 5).toString();
            jdata.setVisible(true);
            jdata.pack();
            jdata.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jdata.jTextNIK.setText(nik);
            jdata.jTextNmPnd.setText(namapnd);
            jdata.jComboUnit.setSelectedItem(unit);
            jdata.jComboBlok.setSelectedItem(blok);
            jdata.jTextThnMsk.setText(tahunmasuk);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_editpndkActionPerformed

    private void btn_hapuspndkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapuspndkActionPerformed
        // TODO add your handling code here:
        int bar = jTablePndk.getSelectedRow();
        String id = tabModel.getValueAt(bar, 0).toString();

        if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM dft_penduduk WHERE id='"+id+"'");
            tampilDataPndk();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_hapuspndkActionPerformed

    private void btn_editpndkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editpndkMouseClicked
        // TODO add your handling code here:      
    }//GEN-LAST:event_btn_editpndkMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        tampilDataPndk();
        tampilDataTamu();
        tampilDataBerita();
        tampilDataIuran();
    }//GEN-LAST:event_formWindowActivated

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btn_laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laporanActionPerformed
        // TODO add your handling code here:
        Main_Panel.removeAll();
        Main_Panel.add(panel_laporan);
        Main_Panel.repaint();
        Main_Panel.revalidate();
    }//GEN-LAST:event_btn_laporanActionPerformed

    private void btn_laporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseEntered
        // TODO add your handling code here:      
        btn_laporan.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btn_laporanMouseEntered

    private void btn_laporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseExited
        // TODO add your handling code here:
        btn_laporan.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btn_laporanMouseExited

    private void btn_homeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseEntered
        // TODO add your handling code here:
        btn_home.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btn_homeMouseEntered

    private void btn_homeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseExited
        // TODO add your handling code here:
        btn_home.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btn_homeMouseExited

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
        Main_Panel.removeAll();
        Main_Panel.add(panel_dashboard);
        Main_Panel.repaint();
        Main_Panel.revalidate();
    }//GEN-LAST:event_btn_homeActionPerformed

    private void btn_beritaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_beritaMouseEntered
        // TODO add your handling code here:
        btn_berita.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btn_beritaMouseEntered

    private void btn_beritaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_beritaMouseExited
        // TODO add your handling code here:
        btn_berita.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btn_beritaMouseExited

    private void btn_beritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_beritaActionPerformed
        // TODO add your handling code here:
        Main_Panel.removeAll();
        Main_Panel.add(panel_berita);
        Main_Panel.repaint();
        Main_Panel.revalidate();
    }//GEN-LAST:event_btn_beritaActionPerformed

    private void btn_kasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kasMouseEntered
        // TODO add your handling code here:
        btn_kas.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btn_kasMouseEntered

    private void btn_kasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kasMouseExited
        // TODO add your handling code here:
        btn_kas.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btn_kasMouseExited

    private void btn_kasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_kasActionPerformed
        // TODO add your handling code here:
        Main_Panel.removeAll();
        Main_Panel.add(panel_kas);
        Main_Panel.repaint();
        Main_Panel.revalidate();
    }//GEN-LAST:event_btn_kasActionPerformed

    private void btn_tamuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tamuMouseEntered
        // TODO add your handling code here:
        btn_tamu.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btn_tamuMouseEntered

    private void btn_tamuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tamuMouseExited
        // TODO add your handling code here:
        btn_tamu.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btn_tamuMouseExited

    private void btn_tamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tamuActionPerformed
        // TODO add your handling code here:
        Main_Panel.removeAll();
        Main_Panel.add(panel_tamu);
        Main_Panel.repaint();
        Main_Panel.revalidate();     
    }//GEN-LAST:event_btn_tamuActionPerformed

    private void btn_iuranMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iuranMouseEntered
        // TODO add your handling code here:
        btn_iuran.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btn_iuranMouseEntered

    private void btn_iuranMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iuranMouseExited
        // TODO add your handling code here:
        btn_iuran.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btn_iuranMouseExited

    private void btn_iuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iuranActionPerformed
        // TODO add your handling code here:
        Main_Panel.removeAll();
        Main_Panel.add(panel_iuran);
        Main_Panel.repaint();
        Main_Panel.revalidate();
    }//GEN-LAST:event_btn_iuranActionPerformed

    private void btn_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_laporanMouseClicked
        // TODO add your handling code here:        
    }//GEN-LAST:event_btn_laporanMouseClicked

    private void btn_pendudukMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pendudukMouseEntered
        // TODO add your handling code here:
        btn_penduduk.setBackground(new Color(0,102,102));
    }//GEN-LAST:event_btn_pendudukMouseEntered

    private void btn_pendudukMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pendudukMouseExited
        // TODO add your handling code here:
        btn_penduduk.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_btn_pendudukMouseExited

    private void btn_pendudukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pendudukActionPerformed
        // TODO add your handling code here:
        Main_Panel.removeAll();
        Main_Panel.add(panel_penduduk);
        Main_Panel.repaint();
        Main_Panel.revalidate();
    }//GEN-LAST:event_btn_pendudukActionPerformed

    private void btn_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_homeMouseClicked
        // TODO add your handling code here:       
    }//GEN-LAST:event_btn_homeMouseClicked

    private void btn_pendudukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pendudukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_pendudukMouseClicked

    private void btn_tamuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tamuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tamuMouseClicked

    private void btn_beritaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_beritaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_beritaMouseClicked

    private void btn_kasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_kasMouseClicked
        // TODO add your handling code here:       
    }//GEN-LAST:event_btn_kasMouseClicked

    private void btn_iuranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_iuranMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iuranMouseClicked

    private void btn_tamuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_tamuFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tamuFocusGained

    private void btn_tamuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btn_tamuFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tamuFocusLost

    private void Filter_TamuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Filter_TamuKeyTyped
        // TODO add your handling code here:
        try{
            String key = Filter_Tamu.getText();
            Object[] judul_kolom1 = {"No", "Nama Tamu", "Jenis Kelamin", "Alamat", "No. HP", "Keterangan", "Waktu Masuk"};
            tabModel1=new DefaultTableModel(null,judul_kolom1);
            jTableTamu.setModel(tabModel1);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel1.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_tamu WHERE nama LIKE '%"+key+"%'");  
            while(RsDashboard.next()){
                Object[] data1={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("nama"),
                    RsDashboard.getString("jk"),
                    RsDashboard.getString("alamat"),
                    RsDashboard.getString("hp"),
                    RsDashboard.getString("keperluan"),
                    RsDashboard.getString("waktumasuk")         
                };
               tabModel1.addRow(data1);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_Filter_TamuKeyTyped

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void btn_tambahtamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahtamuActionPerformed
        // TODO add your handling code here:
        new Input_DataTamu().setVisible(true);
    }//GEN-LAST:event_btn_tambahtamuActionPerformed

    private void Filter_TamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_TamuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Filter_TamuActionPerformed

    private void btn_edittamuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edittamuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edittamuMouseClicked

    private void btn_edittamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edittamuActionPerformed
        // TODO add your handling code here:
            Edit_DataTamu jdata1 = new Edit_DataTamu();
        try{
            int bar1 = jTableTamu.getSelectedRow();
            String nama = tabModel1.getValueAt(bar1, 1).toString();
            String jk = tabModel1.getValueAt(bar1, 2).toString();
            String alamat = tabModel1.getValueAt(bar1, 3).toString();
            String nohp = tabModel1.getValueAt(bar1, 4).toString();
            String keperluan = tabModel1.getValueAt(bar1, 5).toString();
            jdata1.setVisible(true);
            jdata1.pack();
            jdata1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            jdata1.jTextNmTamu.setText(nama);
            jdata1.jComboJkTamu.setSelectedItem(jk);
            jdata1.jTextAlmTamu.setText(alamat);
            jdata1.jTextNoTamu.setText(nohp);
            jdata1.jTextKetTamu.setText(keperluan);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_edittamuActionPerformed

    private void btn_hapustamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapustamuActionPerformed
        // TODO add your handling code here:
        int bar1 = jTableTamu.getSelectedRow();
        String id = tabModel1.getValueAt(bar1, 0).toString();

        if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM dft_tamu WHERE id='"+id+"'");
            tampilDataTamu();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_hapustamuActionPerformed

    private void Filter_BeritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_BeritaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Filter_BeritaActionPerformed

    private void Filter_BeritaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Filter_BeritaKeyTyped
        // TODO add your handling code here:
         try{
            String key = Filter_Berita.getText();
            Object[] judul_kolom2 = {"No", "Berita Acara", "Keterangan"};
            tabModel2=new DefaultTableModel(null,judul_kolom2);
            jTableBerita.setModel(tabModel2);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel2.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_berita WHERE Berita_Acara LIKE '%"+key+"%'");  
            while(RsDashboard.next()){
                Object[] data2={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("Berita_Acara"),
                    RsDashboard.getString("Keterangan"),    
                };
               tabModel2.addRow(data2);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }       
    }//GEN-LAST:event_Filter_BeritaKeyTyped

    private void btn_tambahberitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahberitaActionPerformed
        // TODO add your handling code here:
        String Berita_Acara=jTextBeritaAcara.getText();
        String Keterangan=jTextKetBerita.getText();
        
         try{
                Connection conn=(Connection)Koneksi.koneksiDB();
                Dashboard dashboard = new Dashboard();
                dashboard.tampilDataBerita();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into dft_berita(Berita_Acara,Keterangan)"+
                    "VALUES('"+Berita_Acara+"','"+Keterangan+"')");
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
                kosong();
                dashboard.tampilDataBerita();
                
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_tambahberitaActionPerformed

    private void btn_editberitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editberitaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editberitaMouseClicked

    private void btn_editberitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editberitaActionPerformed
        // TODO add your handling code here:       
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update Data ini?","Confirmation",JOptionPane.YES_NO_OPTION);{
        if (ok==0) {
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            
            String id = jTextIdBerita.getText();
            String Berita_Acara = jTextBeritaAcara.getText();
            String Keterangan =jTextKetBerita.getText();
            stt.executeUpdate("UPDATE dft_berita SET Berita_Acara='"+Berita_Acara+"', Keterangan='"+Keterangan+"' WHERE id='"+id+"'");         
            JOptionPane.showMessageDialog(this,"Data berhasil di ubah","Success",JOptionPane.INFORMATION_MESSAGE);
            kosong();
            tampilDataBerita();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    }//GEN-LAST:event_btn_editberitaActionPerformed

    private void btn_hapusberitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusberitaActionPerformed
        // TODO add your handling code here:
        int bar2 = jTableBerita.getSelectedRow();
        String id = tabModel2.getValueAt(bar2, 0).toString();

        if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM dft_berita WHERE id='"+id+"'");
            tampilDataBerita();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
            kosong();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_hapusberitaActionPerformed

    private void jTableBeritaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableBeritaMouseClicked
        // TODO add your handling code here:
        int bar2 = jTableBerita.getSelectedRow();
        String Berita_Acara = tabModel2.getValueAt(bar2, 1).toString();
        String Keterangan = tabModel2.getValueAt(bar2, 2).toString();     
        jTextBeritaAcara.setText(Berita_Acara);
        jTextKetBerita.setText(Keterangan);
    }//GEN-LAST:event_jTableBeritaMouseClicked

    private void btn_tambahiuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahiuranActionPerformed
        // TODO add your handling code here:
        String tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(tampilan);
        String tanggal = String.valueOf(fm.format(jDateIuran.getDate()));
        
        //String jTextIuranTotal = jTextIuranB + jTextIuranT;
        
        String nama = jTextNamaIuran.getText();
        String iuran_bulanan = jTextIuranB.getText();
        String iuran_tahunan = jTextIuranT.getText();
        String total_bayar = jTextIuranTotal.getText();
        String keterangan = jComboKetIuran.getSelectedItem().toString();
        
         try{
                Connection conn=(Connection)Koneksi.koneksiDB();
                Dashboard dashboard = new Dashboard();
                dashboard.tampilDataIuran();
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into dft_iuran(nama,tanggal,iuran_bulanan,iuran_tahunan,total_bayar,keterangan)"+
                    "VALUES('"+nama+"','"+tanggal+"','"+iuran_bulanan+"','"+iuran_tahunan+"','"+total_bayar+"','"+keterangan+"')");
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
                kosong();
                tampilDataIuran();
                
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_btn_tambahiuranActionPerformed

    private void btn_editiuranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editiuranMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_editiuranMouseClicked

    private void btn_editiuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editiuranActionPerformed
        // TODO add your handling code here:
        
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update Data ini?","Confirmation",JOptionPane.YES_NO_OPTION);{
        if (ok==0) {
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            
            String tampilan ="yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(tampilan);
            String tanggal = String.valueOf(fm.format(jDateIuran.getDate()));
            String id = jTextIdIuran.getText();
            String nama = jTextNamaIuran.getText();
            String iuran_bulanan = jTextIuranB.getText();
            String iuran_tahunan = jTextIuranT.getText();
            String total_bayar = jTextIuranTotal.getText();
            String keterangan = jComboKetIuran.getSelectedItem().toString();         
            
            stt.executeUpdate("UPDATE dft_iuran SET nama='"+nama+"', tanggal='"+tanggal+"', iuran_bulanan='"+iuran_bulanan+"', iuran_tahunan='"+iuran_tahunan+"', total_bayar='"+total_bayar+"', keterangan='"+keterangan+"' WHERE id='"+id+"'");         
            JOptionPane.showMessageDialog(this,"Data berhasil di ubah","Success",JOptionPane.INFORMATION_MESSAGE);
            kosong();
            tampilDataIuran();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }
    }//GEN-LAST:event_btn_editiuranActionPerformed

    private void btn_hapusiuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusiuranActionPerformed
        // TODO add your handling code here:
         int bar3 = jTableIuran.getSelectedRow();
        String id = tabModel3.getValueAt(bar3, 0).toString();

        if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM dft_iuran WHERE id='"+id+"'");
            tampilDataIuran();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
            kosong();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_hapusiuranActionPerformed

    private void jTableIuranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableIuranMouseClicked
        // TODO add your handling code here:
        
        int bar3 = jTableIuran.getSelectedRow();
        String nama = tabModel3.getValueAt(bar3, 1).toString();
        String tanggal = tabModel3.getValueAt(bar3, 2).toString();
        String iuran_bulanan = tabModel3.getValueAt(bar3, 3).toString();
        String iuran_tahunan = tabModel3.getValueAt(bar3, 4).toString();
        String total_bayar = tabModel3.getValueAt(bar3, 5).toString();
        String keterangan = tabModel3.getValueAt(bar3, 6).toString();
        
        jTextNamaIuran.setText(nama);
        //jDateiuran.setDate(tanggal);
        jTextIuranB.setText(iuran_bulanan);
        jTextIuranT.setText(iuran_tahunan);
        jTextIuranTotal.setText(total_bayar);
        jComboKetIuran.setSelectedItem(keterangan);
    }//GEN-LAST:event_jTableIuranMouseClicked

    private void Filter_IuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_IuranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Filter_IuranActionPerformed

    private void Filter_IuranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Filter_IuranKeyTyped
        // TODO add your handling code here:
        try{
            String key = Filter_Iuran.getText();
            Object[] judul_kolom3 = {"No", "Nama Warga", "Tanggal", "Iuran Bulanan", "Iuran Tahunan", "Total Bayar", "Keterangan"};
            tabModel3=new DefaultTableModel(null,judul_kolom3);
            jTableIuran.setModel(tabModel3);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel3.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_iuran WHERE nama LIKE '%"+key+"%'");  
            while(RsDashboard.next()){
                Object[] data3={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("nama"),
                    RsDashboard.getString("tangal"),
                    RsDashboard.getString("iuran_bulanan"),
                    RsDashboard.getString("iuran_tahunan"),
                    RsDashboard.getString("total_bayar"),
                    RsDashboard.getString("keterangan")    
                };
               tabModel3.addRow(data3);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_Filter_IuranKeyTyped

    private void jTextNamaIuranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNamaIuranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNamaIuranActionPerformed

    private void jTextIuranBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIuranBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIuranBActionPerformed

    private void jTextIuranTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIuranTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIuranTActionPerformed

    private void jTextIuranTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIuranTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIuranTotalActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            File reportp = new File ("src/sikwaapp/reportpenduduk.jasper");
            JasperPrint jp = JasperFillManager.fillReport(reportp.getPath(), null, Koneksi.koneksiDB());
            JasperViewer.viewReport(jp,false);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            File reportp = new File ("src/sikwaapp/reporttamu.jasper");
            JasperPrint jp = JasperFillManager.fillReport(reportp.getPath(), null, Koneksi.koneksiDB());
            JasperViewer.viewReport(jp,false);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            File reportp = new File ("src/sikwaapp/reportiuran.jasper");
            JasperPrint jp = JasperFillManager.fillReport(reportp.getPath(), null, Koneksi.koneksiDB());
            JasperViewer.viewReport(jp,false);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try {
            File reportp = new File ("src/sikwaapp/reportkas.jasper");
            JasperPrint jp = JasperFillManager.fillReport(reportp.getPath(), null, Koneksi.koneksiDB());
            JasperViewer.viewReport(jp,false);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        try {
            File reportp = new File ("src/sikwaapp/reportberita.jasper");
            JasperPrint jp = JasperFillManager.fillReport(reportp.getPath(), null, Koneksi.koneksiDB());
            JasperViewer.viewReport(jp,false);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btn_tambahkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahkasActionPerformed
        // TODO add your handling code here:
        String deskripsi =jTextDeskripsiKas.getText();
        String nominal = jTextNominalKas.getText();
        String jenis =jComboBoxJenisKas.getSelectedItem().toString();

        try{
            Connection conn=(Connection)Koneksi.koneksiDB();
            Dashboard dashboard = new Dashboard();
            dashboard.tampilDataBerita();
            Statement stt=conn.createStatement();
            stt.executeUpdate("insert into dft_kas(deskripsi,nominal,jenis)"+
                "VALUES('"+deskripsi+"','"+nominal+"','"+jenis+"')");
            JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            kosong();
            tampilDataKas();

        }catch(SQLException e) {
            JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_tambahkasActionPerformed

    private void btn_editkasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editkasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editkasMouseClicked

    private void btn_editkasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editkasActionPerformed
        // TODO add your handling code here:
        int ok=JOptionPane.showConfirmDialog(null,"Apakah Yakin Untuk Update Data ini?","Confirmation",JOptionPane.YES_NO_OPTION);{
            if (ok==0) {
                try{
                    Connection conn=(Connection)
                    Koneksi.koneksiDB();
                    Statement stt=conn.createStatement();
                    
                    String id = jTextIdKas.getText();
                    String deskripsi =jTextDeskripsiKas.getText();
                    String nominal = jTextNominalKas.getText();
                    String jenis =jComboBoxJenisKas.getSelectedItem().toString();
                    stt.executeUpdate("UPDATE dft_kas SET deskripsi='"+deskripsi+"', nominal='"+nominal+"', jenis='"+jenis+"' WHERE id='"+id+"'");
                    JOptionPane.showMessageDialog(this,"Data berhasil di ubah","Success",JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                    tampilDataKas();
                } catch(SQLException e){
                    JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_editkasActionPerformed

    private void btn_hapuskasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapuskasActionPerformed
        // TODO add your handling code here:
        int bar_kas = jTableKas.getSelectedRow();
        String id = tabModelkas.getValueAt(bar_kas, 0).toString();

        if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM dft_kas WHERE id='"+id+"'");
            tampilDataKas();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
            kosong();

            tampilDataKas();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_hapuskasActionPerformed

    private void jTextNominalKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNominalKasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNominalKasActionPerformed

    private void jTextNominalKasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNominalKasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNominalKasKeyReleased

    private void jTextIdKasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIdKasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdKasActionPerformed

    private void jTextIdKasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextIdKasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIdKasKeyReleased

    private void Filter_Berita1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Filter_Berita1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Filter_Berita1ActionPerformed

    private void Filter_Berita1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Filter_Berita1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_Filter_Berita1KeyTyped

    private void jTableKasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKasMouseClicked
        // TODO add your handling code here:
       
        int bar2 = jTableKas.getSelectedRow();
        String id = tabModelkas.getValueAt(bar2, 0).toString();
        String deskripsi = tabModelkas.getValueAt(bar2, 1).toString();
        String jenis = tabModelkas.getValueAt(bar2, 2).toString();
        String nominal = tabModelkas.getValueAt(bar2, 3).toString();
        jTextIdKas.setText(id);
        jTextDeskripsiKas.setText(deskripsi);
        jTextNominalKas.setText(nominal);
        jComboBoxJenisKas.setSelectedItem(jenis);
    }//GEN-LAST:event_jTableKasMouseClicked

    private void jTextTotalKasMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTotalKasMasukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTotalKasMasukActionPerformed

    private void jTextIuranBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextIuranBKeyReleased
        // TODO add your handling code here:
        hitung_total_iuran();
    }//GEN-LAST:event_jTextIuranBKeyReleased

    private void jTextIuranTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextIuranTKeyReleased
        // TODO add your handling code here:
        hitung_total_iuran();
    }//GEN-LAST:event_jTextIuranTKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Filter_Berita;
    private javax.swing.JTextField Filter_Berita1;
    private javax.swing.JTextField Filter_Iuran;
    private javax.swing.JTextField Filter_Pndk;
    private javax.swing.JTextField Filter_Tamu;
    public static final javax.swing.JLabel Icon_Daftar_Akun = new javax.swing.JLabel();
    private javax.swing.JLabel Jam;
    private javax.swing.JLabel Jam1;
    private javax.swing.JLabel Jam2;
    private javax.swing.JLabel Jam3;
    private javax.swing.JLabel Jam4;
    private javax.swing.JLabel Jam5;
    private javax.swing.JLabel Jam6;
    public static final javax.swing.JLabel Label_Daftar_Akun = new javax.swing.JLabel();
    public static javax.swing.JLabel Label_Role;
    public static javax.swing.JLabel Label_Role1;
    public static javax.swing.JLabel Label_Role2;
    public static javax.swing.JLabel Label_Role3;
    public static javax.swing.JLabel Label_Role4;
    public static javax.swing.JLabel Label_Role5;
    public static javax.swing.JLabel Label_Role6;
    private javax.swing.JPanel List_Menu;
    private javax.swing.JLabel Logo_Sikwa;
    private javax.swing.JPanel Main_Panel;
    private javax.swing.JPanel Menu_Panel;
    private javax.swing.JLabel Tanggal;
    private javax.swing.JLabel Tanggal1;
    private javax.swing.JLabel Tanggal2;
    private javax.swing.JLabel Tanggal3;
    private javax.swing.JLabel Tanggal4;
    private javax.swing.JLabel Tanggal5;
    private javax.swing.JLabel Tanggal6;
    public static javax.swing.JButton btn_berita;
    public static javax.swing.JButton btn_editberita;
    public static javax.swing.JButton btn_editiuran;
    public static javax.swing.JButton btn_editkas;
    public static javax.swing.JButton btn_editpndk;
    public static javax.swing.JButton btn_edittamu;
    public static javax.swing.JButton btn_hapusberita;
    public static javax.swing.JButton btn_hapusiuran;
    public static javax.swing.JButton btn_hapuskas;
    public static javax.swing.JButton btn_hapuspndk;
    public static javax.swing.JButton btn_hapustamu;
    public static javax.swing.JButton btn_home;
    public static javax.swing.JButton btn_iuran;
    public static javax.swing.JButton btn_kas;
    public static javax.swing.JButton btn_laporan;
    public static javax.swing.JButton btn_penduduk;
    public static javax.swing.JButton btn_tambahberita;
    public static javax.swing.JButton btn_tambahiuran;
    public static javax.swing.JButton btn_tambahkas;
    public static javax.swing.JButton btn_tambahpndk;
    public static javax.swing.JButton btn_tambahtamu;
    public static javax.swing.JButton btn_tamu;
    private javax.swing.JPanel header_berita;
    private javax.swing.JPanel header_dashboard;
    private javax.swing.JPanel header_iuran;
    private javax.swing.JPanel header_kas;
    private javax.swing.JPanel header_laporan;
    private javax.swing.JPanel header_penduduk;
    private javax.swing.JPanel header_tamu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxJenisKas;
    private javax.swing.JComboBox<String> jComboKetIuran;
    private com.toedter.calendar.JDateChooser jDateIuran;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTableBerita;
    private javax.swing.JTable jTableIuran;
    private javax.swing.JTable jTableKas;
    private javax.swing.JTable jTablePndk;
    private javax.swing.JTable jTableTamu;
    private javax.swing.JTextArea jTextBeritaAcara;
    private javax.swing.JTextField jTextDeskripsiKas;
    private javax.swing.JTextField jTextIdBerita;
    private javax.swing.JTextField jTextIdIuran;
    private javax.swing.JTextField jTextIdKas;
    public javax.swing.JTextField jTextIuranB;
    public javax.swing.JTextField jTextIuranT;
    public javax.swing.JTextField jTextIuranTotal;
    private javax.swing.JTextArea jTextKetBerita;
    public javax.swing.JTextField jTextNamaIuran;
    private javax.swing.JTextField jTextNominalKas;
    private javax.swing.JTextField jTextTotalKas;
    private javax.swing.JTextField jTextTotalKasKeluar;
    private javax.swing.JTextField jTextTotalKasMasuk;
    private javax.swing.JPanel panel_berita;
    private javax.swing.JPanel panel_dashboard;
    private javax.swing.JPanel panel_iuran;
    private javax.swing.JPanel panel_kas;
    private javax.swing.JPanel panel_laporan;
    private javax.swing.JPanel panel_penduduk;
    private javax.swing.JPanel panel_tamu;
    private javax.swing.JLabel sikwa;
    private javax.swing.JLabel sikwa_full;
    // End of variables declaration//GEN-END:variables
}
