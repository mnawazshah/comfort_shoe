/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

/**
 *
 * @author mnawa
 */
public class StockFrame extends javax.swing.JFrame {

    Connection conn;
    PreparedStatement st;
    ResultSet rs;

    private TableRowSorter<TableModel> rowSorter;

    public StockFrame() {
        initComponents();
        getContentPane().setBackground(new Color(12, 12, 12));
        productsTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        productsTable.getTableHeader().setOpaque(false);
        productsTable.getTableHeader().setBackground(new Color(187, 134, 252));
        productsTable.getTableHeader().setForeground(new Color(255, 255, 255));
        productsTable.setRowHeight(25);
        conn = DBConnection.getConnection();
        getAllProducts();
        TableFilter();
    }

    void TableFilter() {
        rowSorter = new TableRowSorter<>(productsTable.getModel());
        productsTable.setRowSorter(rowSorter);

        searchTf.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchTf.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchTf.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        searchTf = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsTable = new javax.swing.JTable();
        pdfBtn = new javax.swing.JButton();
        exelBtn = new javax.swing.JButton();
        mailBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 12, 12));
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(29, 29, 29));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Stock");

        jButton8.setBackground(new java.awt.Color(29, 29, 29));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_left_25px.png"))); // NOI18N
        jButton8.setToolTipText("Go back to Home");
        jButton8.setBorderPainted(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        searchTf.setText("Search...");
        searchTf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchTfMouseClicked(evt);
            }
        });
        searchTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTfFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 376, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(303, 303, 303)
                .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(searchTf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(29, 29, 29));

        jScrollPane1.setBorder(null);

        productsTable.setBackground(new java.awt.Color(20, 20, 20));
        productsTable.setForeground(new java.awt.Color(255, 255, 255));
        productsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product code", "Product Name", "Category", "Type", "Supplier Name", "Brand", "Quantity", "Price", "Total Price", "Date", "Time"
            }
        ));
        productsTable.setFocusable(false);
        productsTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        productsTable.setRequestFocusEnabled(false);
        productsTable.setRowHeight(26);
        productsTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        productsTable.setShowVerticalLines(false);
        productsTable.getTableHeader().setReorderingAllowed(false);
        productsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(productsTable);

        pdfBtn.setBackground(new java.awt.Color(187, 134, 252));
        pdfBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pdfBtn.setForeground(new java.awt.Color(255, 255, 255));
        pdfBtn.setText("Create PDF");
        pdfBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pdfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pdfBtnActionPerformed(evt);
            }
        });

        exelBtn.setBackground(new java.awt.Color(187, 134, 252));
        exelBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exelBtn.setForeground(new java.awt.Color(255, 255, 255));
        exelBtn.setText("Create Exel File");
        exelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exelBtnActionPerformed(evt);
            }
        });

        mailBtn.setBackground(new java.awt.Color(187, 134, 252));
        mailBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        mailBtn.setForeground(new java.awt.Color(255, 255, 255));
        mailBtn.setText("Email PDF file");
        mailBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        refreshBtn.setBackground(new java.awt.Color(187, 134, 252));
        refreshBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn.setText("Email Excel file");
        refreshBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pdfBtn)
                .addGap(91, 91, 91)
                .addComponent(exelBtn)
                .addGap(107, 107, 107)
                .addComponent(mailBtn)
                .addGap(113, 113, 113)
                .addComponent(refreshBtn)
                .addGap(135, 135, 135))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pdfBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        new MainMenuFrame().setVisible(true);
        MainMenuFrame.setUsername();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void productsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsTableMouseClicked
        ProductDetailFrame f = new ProductDetailFrame();
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }//GEN-LAST:event_productsTableMouseClicked
    String locationPDF;
    private void pdfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pdfBtnActionPerformed

        try {
            JasperPrint jprint;

            jprint = JasperFillManager.fillReport(locationPDF, null, DBConnection.getConnection());

            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            File f = chooser.getSelectedFile();
            if (f != null) {

                JasperExportManager.exportReportToPdfFile(jprint, f.getAbsolutePath() + ".pdf");
                JOptionPane.showMessageDialog(null, "PDF file generated", "PDF", JOptionPane.INFORMATION_MESSAGE);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_pdfBtnActionPerformed
    String locationCSV;
    private void exelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exelBtnActionPerformed
        try {

            JRCsvExporter exporter = new JRCsvExporter();
            exporter.setExporterInput(new SimpleExporterInput(JasperFillManager.fillReport(locationCSV, null, DBConnection.getConnection())));
            JFileChooser chooser = new JFileChooser();
            chooser.showSaveDialog(null);
            File f = chooser.getSelectedFile();
            if (f != null) {
                exporter.setExporterOutput(new SimpleWriterExporterOutput(new File(f.getAbsolutePath()) + ".csv"));
                SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
                configuration.setWriteBOM(Boolean.TRUE);
                configuration.setRecordDelimiter("\r\n");
                exporter.setConfiguration(configuration);
                exporter.exportReport();

                JOptionPane.showMessageDialog(null, "CSV file generated", "CSV", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_exelBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed

    }//GEN-LAST:event_refreshBtnActionPerformed

    private void searchTfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchTfMouseClicked
        String text = searchTf.getText();
        if (text.equals("Search...")) {
            searchTf.setText("");
        }
    }//GEN-LAST:event_searchTfMouseClicked

    private void searchTfFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTfFocusGained
        String text = searchTf.getText();
        if (text.equals("Search...")) {
            searchTf.setText("");
        }
    }//GEN-LAST:event_searchTfFocusGained

    void getAllProducts() {
        try {
            st = conn.prepareStatement("select * from stock");
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                String category = rs.getString(4);
                String type = rs.getString(5);
                String supplier = rs.getString(6);
                String brand = rs.getString(7);

                int quant = rs.getInt(8);
                int u_price = rs.getInt(9);
                int total = rs.getInt(10);

                Date p_date = rs.getDate(11);
                Time p_time = rs.getTime(12);

                Object[] obj = {id, code, name, category, type, supplier, brand, quant, u_price, total, p_date, p_time};
                DefaultTableModel tb = (DefaultTableModel) productsTable.getModel();
                tb.addRow(obj);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PurchaseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Refresh() {
        DefaultTableModel tb = (DefaultTableModel) productsTable.getModel();
        tb.setRowCount(0);
        getAllProducts();
    }

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
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exelBtn;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mailBtn;
    private javax.swing.JButton pdfBtn;
    private javax.swing.JTable productsTable;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JTextField searchTf;
    // End of variables declaration//GEN-END:variables
}
