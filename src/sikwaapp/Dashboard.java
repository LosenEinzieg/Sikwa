/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sikwaapp;

import config.Koneksi;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ade Arif R
 */
public class Dashboard extends javax.swing.JFrame {
    DefaultTableModel tabModel;
    ResultSet RsDashboard=null;

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        tampilDataPndk();
        tampilDataTamu();
        Tampil_Jam();
        Tampil_Tanggal();
    }
    
    public void tampilDataPndk(){
        try{
            Object[] judul_kolom = {"NIK Penduduk", "Nama Penduduk", "Unit", "Blok", "Tahun Masuk", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTablePndk.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_penduduk ");  
            while(RsDashboard.next()){
                Object[] data={
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
            tabModel=new DefaultTableModel(null,judul_kolom1);
            jTableTamu.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_tamu ");  
            while(RsDashboard.next()){
                Object[] data={
                    RsDashboard.getString("id"),
                    RsDashboard.getString("nama"),
                    RsDashboard.getString("jk"),
                    RsDashboard.getString("alamat"),
                    RsDashboard.getString("hp"),
                    RsDashboard.getString("keperluan"),
                    RsDashboard.getString("waktumasuk")
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
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

    Edit_Data jdata = new Edit_Data();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
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
        jLabel4 = new javax.swing.JLabel();
        panel_penduduk = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePndk = new javax.swing.JTable();
        header_penduduk = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        Tanggal1 = new javax.swing.JLabel();
        Jam1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Filter = new javax.swing.JTextField();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        panel_tamu = new javax.swing.JPanel();
        header_tamu = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        Tanggal2 = new javax.swing.JLabel();
        Jam2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Filter1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTamu = new javax.swing.JTable();
        panel_berita = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        header_berita = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        Tanggal3 = new javax.swing.JLabel();
        Jam3 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        panel_kas = new javax.swing.JPanel();
        header_kas = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        Tanggal4 = new javax.swing.JLabel();
        Jam4 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        panel_iuran = new javax.swing.JPanel();
        header_iuran = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        Tanggal5 = new javax.swing.JLabel();
        Jam5 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        panel_laporan = new javax.swing.JPanel();
        header_laporan = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        Tanggal6 = new javax.swing.JLabel();
        Jam6 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        Menu_Panel.setBackground(new java.awt.Color(0, 153, 153));
        Menu_Panel.setPreferredSize(new java.awt.Dimension(250, 804));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8_neighbour_120px.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIKWA");

        jLabel3.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sistem Aplikasi Keamanan Warga");

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
                        .addGroup(List_MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(List_MenuLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(List_MenuLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(jLabel1))
                            .addGroup(Menu_PanelLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Menu_PanelLayout.setVerticalGroup(
            Menu_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Menu_PanelLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_dashboardLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Label_Daftar_Akun)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(header_dashboardLayout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(Tanggal)
                        .addGap(18, 18, 18)
                        .addComponent(Jam)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                        .addComponent(Icon_Daftar_Akun)
                        .addGap(35, 35, 35)))
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(header_dashboardLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(33, 33, 33))
        );
        header_dashboardLayout.setVerticalGroup(
            header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(header_dashboardLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Label_Role, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, header_dashboardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(header_dashboardLayout.createSequentialGroup()
                        .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tanggal)
                            .addComponent(Jam))
                        .addGap(26, 26, 26))
                    .addGroup(header_dashboardLayout.createSequentialGroup()
                        .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Icon_Daftar_Akun, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(header_dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(Label_Daftar_Akun))))
                .addGap(42, 42, 42))
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

        jTablePndk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTablePndk);

        panel_penduduk.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 960, 400));

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

        Filter.setBackground(new java.awt.Color(0, 153, 153));
        Filter.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        Filter.setForeground(new java.awt.Color(255, 255, 255));
        Filter.setBorder(null);
        Filter.setOpaque(false);
        Filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FilterKeyTyped(evt);
            }
        });
        panel_penduduk.add(Filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 165, 130, 20));

        btn_tambah.setBackground(new java.awt.Color(0, 153, 0));
        btn_tambah.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_tambah.setForeground(new java.awt.Color(255, 255, 255));
        btn_tambah.setText("Tambah");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });
        panel_penduduk.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 630, 100, -1));

        btn_edit.setBackground(new java.awt.Color(153, 153, 0));
        btn_edit.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_editMouseClicked(evt);
            }
        });
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        panel_penduduk.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 630, 100, -1));

        btn_hapus.setBackground(new java.awt.Color(153, 0, 0));
        btn_hapus.setFont(new java.awt.Font("Palatino Linotype", 1, 16)); // NOI18N
        btn_hapus.setForeground(new java.awt.Color(255, 255, 255));
        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });
        panel_penduduk.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 630, 100, -1));

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

        Filter1.setBackground(new java.awt.Color(0, 153, 153));
        Filter1.setFont(new java.awt.Font("Palatino Linotype", 0, 15)); // NOI18N
        Filter1.setForeground(new java.awt.Color(255, 255, 255));
        Filter1.setBorder(null);
        Filter1.setOpaque(false);
        Filter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Filter1KeyTyped(evt);
            }
        });
        panel_tamu.add(Filter1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 165, 130, 20));

        jTableTamu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableTamu);

        panel_tamu.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 960, 400));

        Main_Panel.add(panel_tamu, "card4");

        panel_berita.setBackground(new java.awt.Color(0, 153, 153));
        panel_berita.setForeground(new java.awt.Color(0, 153, 153));
        panel_berita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Palatino Linotype", 1, 25)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("BERITA / PENGUMUMAN");
        panel_berita.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

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
        panel_iuran.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, -1));

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

    private void FilterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FilterKeyTyped
        // TODO add your handling code here:
        try{
            String key = Filter.getText();
            Object[] judul_kolom = {"NIK Penduduk", "Nama Penduduk", "Unit", "Blok", "Tahun Masuk", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTablePndk.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_penduduk WHERE namapnd LIKE '%"+key+"%'");  
            while(RsDashboard.next()){
                Object[] data={
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
    }//GEN-LAST:event_FilterKeyTyped

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

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        new Input_Data().setVisible(true);
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        try{
            int bar = jTablePndk.getSelectedRow();
            String nik = tabModel.getValueAt(bar, 0).toString();
            String namapnd = tabModel.getValueAt(bar, 1).toString();
            String unit = tabModel.getValueAt(bar, 2).toString();
            String blok = tabModel.getValueAt(bar, 3).toString();
            String tahunmasuk = tabModel.getValueAt(bar, 4).toString();
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
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        int bar = jTablePndk.getSelectedRow();
        String nik = tabModel.getValueAt(bar, 0).toString();

        if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)
            Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM dft_penduduk WHERE nik='"+nik+"'");
            tampilDataPndk();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void btn_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editMouseClicked
        // TODO add your handling code here:      
    }//GEN-LAST:event_btn_editMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        tampilDataPndk();
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

    private void Filter1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Filter1KeyTyped
        // TODO add your handling code here:
        try{
            String key = Filter.getText();
            Object[] judul_kolom = {"NIK Penduduk", "Nama Penduduk", "Unit", "Blok", "Tahun Masuk", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            jTablePndk.setModel(tabModel);
            
            Connection conn=(Connection)Koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsDashboard=stt.executeQuery("SELECT * from dft_penduduk WHERE namapnd LIKE '%"+key+"%'");  
            while(RsDashboard.next()){
                Object[] data={
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
    }//GEN-LAST:event_Filter1KeyTyped

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

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
    private javax.swing.JTextField Filter;
    private javax.swing.JTextField Filter1;
    public static final javax.swing.JLabel Icon_Daftar_Akun = new javax.swing.JLabel();
    private javax.swing.JLabel Jam;
    private javax.swing.JLabel Jam1;
    private javax.swing.JLabel Jam2;
    private javax.swing.JLabel Jam3;
    private javax.swing.JLabel Jam4;
    private javax.swing.JLabel Jam5;
    private javax.swing.JLabel Jam6;
    public static final javax.swing.JLabel Label_Daftar_Akun = new javax.swing.JLabel();
    public static final javax.swing.JLabel Label_Role = new javax.swing.JLabel();
    public static final javax.swing.JLabel Label_Role1 = new javax.swing.JLabel();
    public static final javax.swing.JLabel Label_Role2 = new javax.swing.JLabel();
    public static final javax.swing.JLabel Label_Role3 = new javax.swing.JLabel();
    public static final javax.swing.JLabel Label_Role4 = new javax.swing.JLabel();
    public static final javax.swing.JLabel Label_Role5 = new javax.swing.JLabel();
    public static final javax.swing.JLabel Label_Role6 = new javax.swing.JLabel();
    private javax.swing.JPanel List_Menu;
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
    public static javax.swing.JButton btn_edit;
    public static javax.swing.JButton btn_hapus;
    public static javax.swing.JButton btn_home;
    public static javax.swing.JButton btn_iuran;
    public static javax.swing.JButton btn_kas;
    public static javax.swing.JButton btn_laporan;
    public static javax.swing.JButton btn_penduduk;
    public static javax.swing.JButton btn_tambah;
    public static javax.swing.JButton btn_tamu;
    private javax.swing.JPanel header_berita;
    private javax.swing.JPanel header_dashboard;
    private javax.swing.JPanel header_iuran;
    private javax.swing.JPanel header_kas;
    private javax.swing.JPanel header_laporan;
    private javax.swing.JPanel header_penduduk;
    private javax.swing.JPanel header_tamu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTablePndk;
    private javax.swing.JTable jTableTamu;
    private javax.swing.JPanel panel_berita;
    private javax.swing.JPanel panel_dashboard;
    private javax.swing.JPanel panel_iuran;
    private javax.swing.JPanel panel_kas;
    private javax.swing.JPanel panel_laporan;
    private javax.swing.JPanel panel_penduduk;
    private javax.swing.JPanel panel_tamu;
    // End of variables declaration//GEN-END:variables
}
