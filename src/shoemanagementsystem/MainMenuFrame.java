/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanagementsystem;

import java.awt.AlphaComposite;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author mnawa
 */
public class MainMenuFrame extends javax.swing.JFrame {

    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    int xMouse;
    int yMouse;

    Font enterFont = new Font("Segoe UI", Font.BOLD, 14);
    Font exitFont = new Font("Segoe UI", Font.PLAIN, 14);

    // defining icons
    ImageIcon dashboardWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_dashboard_80px_1.png");
    ImageIcon dashboardPurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_dashboard_80px.png");

    ImageIcon salePurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_sell_stock_80px.png");
    ImageIcon saleWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_sell_stock_80px_1.png");

    ImageIcon purchaseWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_card_payment_80px_1.png");
    ImageIcon purchasePurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_card_payment_80px.png");

    ImageIcon empPurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_management_80px.png");
    ImageIcon empWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_management_80px_1.png");

    ImageIcon stockWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_warehouse_80px_1.png");
    ImageIcon stockPurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_warehouse_80px.png");

    ImageIcon dealerWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_supplier_80px_1.png");
    ImageIcon dealerPurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_supplier_80px.png");

    ImageIcon reportPurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_account_80px.png");
    ImageIcon reportWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_account_80px_1.png");

    ImageIcon brandsWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_related_companies_80px.png");
    ImageIcon brandsPurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_related_companies_80px_1.png");

    ImageIcon databaseWhite = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_database_administrator_80px.png");
    ImageIcon databasePurple = new ImageIcon("E:\\ShoeManagementSystem\\src\\demeImages\\icons8_database_administrator_80px_2.png");

    JPopupMenu menu = new JPopupMenu();
    JMenuItem item1 = new JMenuItem("Upload Profile Picture");
    JMenuItem item2 = new JMenuItem("Change profile picture");

    String filename;
    Byte[] image;
    

    public MainMenuFrame() {
        initComponents();
        showDateTime();
        conn = DBConnection.getConnection();
        menu.add(item1);
        menu.add(item2);
        setProfilePicture();

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String desktop = System.getProperty("user.home") + "/Desktop";

                try {
                    menu.setVisible(false);
                    JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.home") + "\\OneDrive\\Desktop"));
//                    chooser.setCurrentDirectory(new File(System.getProperty("user.home") + "\\Desktop\\"));
                    System.out.println(System.getProperty("user.home") + "\\Desktop\\");

                    chooser.showOpenDialog(null);

                    File f = chooser.getSelectedFile();
                    if (f != null) {
                        filename = f.getAbsolutePath();

                        InputStream in = new FileInputStream(filename);
                        PreparedStatement st = conn.prepareStatement("update owner_signup set user_image=? where id=?");
                        st.setBlob(1, in);
                        st.setInt(2, userdetails.userid);
                        st.executeUpdate();
                        System.out.println("Image uploaded");
                        createCircularImage(f);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InputStream in = null;
                try {
                    menu.setVisible(false);
                    JFileChooser chooser = new JFileChooser("C:\\Users\\mnawa\\OneDrive\\Desktop");

                    System.out.println(System.getProperty("user.home") + "\\Desktop\\");
                    chooser.showOpenDialog(null);
                    File f = chooser.getSelectedFile();

                    if (f != null) {
                        filename = f.getAbsolutePath();
                        in = new FileInputStream(filename);
                        PreparedStatement st = conn.prepareStatement("update owner_signup set user_image=? where id=?");
                        st.setBlob(1, in);
                        st.setInt(2, userdetails.userid);
                        st.executeUpdate();

                        System.out.println("imgae changed");
                        createCircularImage(f);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
       
    }

    void showDateTime() {
        SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
        Date time = new Date();
        timeLbl.setText(timeformat.format(time));
        dateLbl.setText(dateformat.format(time));

    }

    public static void applyQualityRenderingHints(Graphics2D g2d) {

        g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);

    }

    //// this method will convert any pic into circular shape
    BufferedImage masked;

    BufferedImage createCircularImage(File f) {
        try {
            BufferedImage master = ImageIO.read(f);

            int diameter = Math.min(master.getWidth(), master.getHeight());
            BufferedImage mask = new BufferedImage(master.getWidth(), master.getHeight(), BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = mask.createGraphics();
            applyQualityRenderingHints(g2d);
            g2d.fillOval(0, 0, diameter - 1, diameter - 1);
            g2d.dispose();

            masked = new BufferedImage(diameter, diameter, BufferedImage.TYPE_INT_ARGB);
            g2d = masked.createGraphics();
            applyQualityRenderingHints(g2d);
            int x = (diameter - master.getWidth()) / 2;
            int y = (diameter - master.getHeight()) / 2;
            g2d.drawImage(master, x, y, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.DST_IN));
            g2d.drawImage(mask, 0, 0, null);
            g2d.dispose();

            ImageIcon image = new ImageIcon(masked.getScaledInstance(imgLabel.getWidth(), imgLabel.getHeight(), Image.SCALE_SMOOTH));
            imgLabel.setIcon(image);

        } catch (IOException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return masked;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tittlePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loggedinUserLbl = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuPanel = new javax.swing.JPanel();
        Dashboard = new javax.swing.JLabel();
        Sales = new javax.swing.JLabel();
        Purchase = new javax.swing.JLabel();
        Employee = new javax.swing.JLabel();
        Stock = new javax.swing.JLabel();
        Dealers = new javax.swing.JLabel();
        Report = new javax.swing.JLabel();
        brands = new javax.swing.JLabel();
        Database = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        timeLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(18, 18, 18));

        tittlePanel.setBackground(new java.awt.Color(29, 29, 29));
        tittlePanel.setForeground(new java.awt.Color(187, 134, 252));
        tittlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Status:");
        tittlePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADMIN");
        tittlePanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        loggedinUserLbl.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        loggedinUserLbl.setForeground(new java.awt.Color(255, 255, 255));
        loggedinUserLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        loggedinUserLbl.setText(" ABDUL REHMAN");
        loggedinUserLbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loggedinUserLbl.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tittlePanel.add(loggedinUserLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 34, 150, 30));

        imgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_user_80px_1.png"))); // NOI18N
        imgLabel.setToolTipText("");
        imgLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgLabelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                imgLabelMouseExited(evt);
            }
        });
        tittlePanel.add(imgLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 70));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(97, 188, 71));
        jLabel5.setText("SHOE");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tittlePanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(326, 34, 110, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(37, 183, 234));
        jLabel8.setText("HUB");
        tittlePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 34, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_sign_out_30px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        tittlePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 50, -1, 31));

        MenuPanel.setBackground(new java.awt.Color(31, 31, 31));

        Dashboard.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(255, 255, 255));
        Dashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_dashboard_80px_1.png"))); // NOI18N
        Dashboard.setText("Dashboard");
        Dashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Dashboard.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMouseExited(evt);
            }
        });

        Sales.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Sales.setForeground(new java.awt.Color(255, 255, 255));
        Sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_sell_stock_80px_1.png"))); // NOI18N
        Sales.setText("Sales");
        Sales.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Sales.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SalesMouseExited(evt);
            }
        });

        Purchase.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Purchase.setForeground(new java.awt.Color(255, 255, 255));
        Purchase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_card_payment_80px_1.png"))); // NOI18N
        Purchase.setText("Purchase");
        Purchase.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Purchase.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Purchase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PurchaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PurchaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PurchaseMouseExited(evt);
            }
        });

        Employee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Employee.setForeground(new java.awt.Color(255, 255, 255));
        Employee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_management_80px_1.png"))); // NOI18N
        Employee.setText("Employees");
        Employee.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Employee.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EmployeeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EmployeeMouseExited(evt);
            }
        });

        Stock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Stock.setForeground(new java.awt.Color(255, 255, 255));
        Stock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_warehouse_80px_1.png"))); // NOI18N
        Stock.setText("Stock");
        Stock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Stock.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StockMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StockMouseExited(evt);
            }
        });

        Dealers.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Dealers.setForeground(new java.awt.Color(255, 255, 255));
        Dealers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_supplier_80px_1.png"))); // NOI18N
        Dealers.setText("Dealers");
        Dealers.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Dealers.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Dealers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DealersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DealersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DealersMouseExited(evt);
            }
        });

        Report.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Report.setForeground(new java.awt.Color(255, 255, 255));
        Report.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_account_80px_1.png"))); // NOI18N
        Report.setText("Reports");
        Report.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Report.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportMouseExited(evt);
            }
        });

        brands.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        brands.setForeground(new java.awt.Color(255, 255, 255));
        brands.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_related_companies_80px.png"))); // NOI18N
        brands.setText("Brands");
        brands.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        brands.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        brands.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brandsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                brandsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                brandsMouseExited(evt);
            }
        });

        Database.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Database.setForeground(new java.awt.Color(255, 255, 255));
        Database.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_database_administrator_80px.png"))); // NOI18N
        Database.setText("Database");
        Database.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Database.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Database.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DatabaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DatabaseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DatabaseMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addComponent(brands)
                                .addGap(230, 230, 230))
                            .addComponent(Report))
                        .addGap(153, 153, 153)
                        .addComponent(Database))
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Dashboard)
                            .addComponent(Employee))
                        .addGap(150, 150, 150)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Sales)
                            .addComponent(Stock))
                        .addGap(153, 153, 153)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Purchase)
                            .addComponent(Dealers))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Purchase)
                    .addComponent(Sales)
                    .addComponent(Dashboard))
                .addGap(18, 18, 18)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Stock)
                    .addComponent(Dealers)
                    .addComponent(Employee))
                .addGap(18, 18, 18)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Report)
                    .addComponent(Database)
                    .addComponent(brands))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(29, 29, 29));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_settings_25px.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        timeLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        timeLbl.setForeground(new java.awt.Color(255, 255, 255));
        timeLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLbl.setText("12:12 PM");
        jPanel1.add(timeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 60, -1));

        dateLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        dateLbl.setForeground(new java.awt.Color(255, 255, 255));
        dateLbl.setText("27/06/2021");
        jPanel1.add(dateLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tittlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();

    }//GEN-LAST:event_formMousePressed

    private void DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseEntered
        Dashboard.setIcon(dashboardPurple);
        Dashboard.setFont(enterFont);
    }//GEN-LAST:event_DashboardMouseEntered

    private void DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseExited
        Dashboard.setIcon(dashboardWhite);
        Dashboard.setFont(exitFont);

    }//GEN-LAST:event_DashboardMouseExited

    private void SalesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesMouseEntered
        Sales.setIcon(salePurple);
        Sales.setFont(enterFont);
    }//GEN-LAST:event_SalesMouseEntered

    private void SalesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesMouseExited
        Sales.setIcon(saleWhite);
        Sales.setFont(exitFont);
    }//GEN-LAST:event_SalesMouseExited

    private void PurchaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchaseMouseEntered
        Purchase.setIcon(purchasePurple);
        Purchase.setFont(enterFont);
    }//GEN-LAST:event_PurchaseMouseEntered

    private void PurchaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchaseMouseExited
        Purchase.setIcon(purchaseWhite);
        Purchase.setFont(exitFont);
    }//GEN-LAST:event_PurchaseMouseExited

    private void EmployeeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMouseEntered
        Employee.setIcon(empPurple);
        Employee.setFont(enterFont);
    }//GEN-LAST:event_EmployeeMouseEntered

    private void EmployeeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMouseExited
        Employee.setIcon(empWhite);
        Employee.setFont(exitFont);
    }//GEN-LAST:event_EmployeeMouseExited

    private void StockMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockMouseEntered
        Stock.setIcon(stockPurple);
        Stock.setFont(enterFont);
    }//GEN-LAST:event_StockMouseEntered

    private void StockMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StockMouseExited
        Stock.setIcon(stockWhite);
        Stock.setFont(exitFont);
    }//GEN-LAST:event_StockMouseExited

    private void DealersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DealersMouseEntered
        Dealers.setIcon(dealerPurple);
        Dealers.setFont(enterFont);
    }//GEN-LAST:event_DealersMouseEntered

    private void DealersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DealersMouseExited
        Dealers.setIcon(dealerWhite);
        Dealers.setFont(exitFont);
    }//GEN-LAST:event_DealersMouseExited

    private void ReportMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportMouseEntered
        Report.setIcon(reportPurple);
        Report.setFont(enterFont);
    }//GEN-LAST:event_ReportMouseEntered

    private void ReportMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportMouseExited
        Report.setIcon(reportWhite);
        Report.setFont(exitFont);
    }//GEN-LAST:event_ReportMouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        logout();
    }//GEN-LAST:event_formWindowClosing

    private void EmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeeMouseClicked
        this.setVisible(false);
        new EmployeeForm().setVisible(true);
        setUsername();
        setUsername();

    }//GEN-LAST:event_EmployeeMouseClicked

    private void DealersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DealersMouseClicked
        this.dispose();
        new DealerForm().setVisible(true);
        setUsername();

    }//GEN-LAST:event_DealersMouseClicked

    private void imgLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgLabelMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {

            menu.setVisible(true);
            menu.setLocation(evt.getXOnScreen(), evt.getYOnScreen());

            System.out.println("wroking");
        }
        if (evt.getButton() == MouseEvent.BUTTON1) {
            menu.setVisible(false);
        }

    }//GEN-LAST:event_imgLabelMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        this.dispose();
        Settings st = new Settings();
        st.setVisible(true);

        setUsername();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        logout();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void imgLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgLabelMouseExited
//        menu.setVisible(false);
    }//GEN-LAST:event_imgLabelMouseExited

    private void PurchaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PurchaseMouseClicked
        this.dispose();
        new PurchaseForm().setVisible(true);
        setUsername();
    }//GEN-LAST:event_PurchaseMouseClicked

    private void brandsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandsMouseClicked
        this.dispose();
        new BrandsForm().setVisible(true);
        setUsername();
    }//GEN-LAST:event_brandsMouseClicked

    private void brandsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandsMouseEntered
        brands.setIcon(brandsPurple);
        brands.setFont(enterFont);
    }//GEN-LAST:event_brandsMouseEntered

    private void brandsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brandsMouseExited
        brands.setIcon(brandsWhite);
        brands.setFont(exitFont);
    }//GEN-LAST:event_brandsMouseExited

    private void DatabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatabaseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_DatabaseMouseClicked

    private void DatabaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatabaseMouseEntered
        Database.setIcon(databasePurple);
        Database.setFont(enterFont);
    }//GEN-LAST:event_DatabaseMouseEntered

    private void DatabaseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatabaseMouseExited
        Database.setIcon(databaseWhite);
        Database.setFont(exitFont);
    }//GEN-LAST:event_DatabaseMouseExited

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked
      this.dispose();
      new Dashboard().setVisible(true);
    }//GEN-LAST:event_DashboardMouseClicked

    // this method is called inside EmployeeForm class to again set the username to the logged in user
    static void setUsername() {
        loggedinUserLbl.setText(userdetails.username);
    }

    void setProfilePicture() {
        try {
            File theDir = new File(System.getProperty("user.dir") + "\\user");
            if (!theDir.exists()) {
                theDir.mkdirs();
            }

            File file = new File(System.getProperty("user.dir") + "\\user\\user.jpg");
            FileOutputStream fos = new FileOutputStream(file);
            byte b[];
            Blob blob;

            st = conn.createStatement();
            rs = st.executeQuery("select user_image from owner_signup where id=" + userdetails.userid);

            int i = 0;
            while (rs.next()) {

                blob = rs.getBlob("user_image");
                b = blob.getBytes(1, (int) blob.length());
                fos.write(b);

            }
            fos.close();
            createCircularImage(file);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Darcula".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenuFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
//       String theme= Settings.getFeelAndLook();

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenuFrame().setVisible(true);
            }
        });

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dashboard;
    private javax.swing.JLabel Database;
    private javax.swing.JLabel Dealers;
    private javax.swing.JLabel Employee;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JLabel Purchase;
    private javax.swing.JLabel Report;
    private javax.swing.JLabel Sales;
    private javax.swing.JLabel Stock;
    private javax.swing.JLabel brands;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private static javax.swing.JLabel loggedinUserLbl;
    private javax.swing.JLabel timeLbl;
    private javax.swing.JPanel tittlePanel;
    // End of variables declaration//GEN-END:variables

    Time time;

    public void logout() {
        try {
            int id = 0;

            if (JOptionPane.showConfirmDialog(this, "Are you sure?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION) == 0) {
                conn = DBConnection.getConnection();
                st = conn.createStatement();
                rs = st.executeQuery("select max(id),curtime() from owner_login"); // query for geting logout time

                if (rs.next()) {
                    id = rs.getInt(1);
                    time = rs.getTime(2);
                }

                st.executeUpdate("update owner_login set logout_time='" + time + "' where id=" + id);
                this.dispose();
                new LoginPage().setVisible(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainMenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
