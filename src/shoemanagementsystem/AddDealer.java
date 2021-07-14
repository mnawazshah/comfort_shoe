/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.id;
import static sun.rmi.registry.RegistryImpl.getID;

/**
 *
 * @author mnawa
 */
public class AddDealer extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement st = null;
    ResultSet rs = null;

    public AddDealer() {
        initComponents();
        conn = DBConnection.getConnection();
        dealersTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        dealersTable.getTableHeader().setOpaque(false);
        dealersTable.getTableHeader().setBackground(new Color(187,134,252));
        dealersTable.getTableHeader().setForeground(new Color(255, 255, 255));
        dealersTable.setRowHeight(25);

        getID();
        getAllDealers();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        idTf = new javax.swing.JTextField();
        nameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        empNameTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTf = new javax.swing.JTextField();
        contactTf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        addressTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cnicTf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        accountTf = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        dealersTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(12, 12, 12));

        jPanel2.setBackground(new java.awt.Color(29, 29, 29));

        jPanel4.setBackground(new java.awt.Color(29, 29, 29));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Dealer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.white));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID");

        idTf.setBackground(new java.awt.Color(29, 29, 29));
        idTf.setForeground(new java.awt.Color(255, 255, 255));
        idTf.setCaretColor(new java.awt.Color(255, 255, 255));

        nameTf.setBackground(new java.awt.Color(29, 29, 29));
        nameTf.setForeground(new java.awt.Color(255, 255, 255));
        nameTf.setCaretColor(new java.awt.Color(255, 255, 255));
        nameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTfKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Company");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Employee Name");

        empNameTf.setBackground(new java.awt.Color(29, 29, 29));
        empNameTf.setForeground(new java.awt.Color(255, 255, 255));
        empNameTf.setCaretColor(new java.awt.Color(255, 255, 255));
        empNameTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                empNameTfKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email");

        emailTf.setBackground(new java.awt.Color(29, 29, 29));
        emailTf.setForeground(new java.awt.Color(255, 255, 255));
        emailTf.setCaretColor(new java.awt.Color(255, 255, 255));
        emailTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTfKeyPressed(evt);
            }
        });

        contactTf.setBackground(new java.awt.Color(29, 29, 29));
        contactTf.setForeground(new java.awt.Color(255, 255, 255));
        contactTf.setCaretColor(new java.awt.Color(255, 255, 255));
        contactTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactTfKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contact#");

        addressTf.setBackground(new java.awt.Color(29, 29, 29));
        addressTf.setForeground(new java.awt.Color(255, 255, 255));
        addressTf.setCaretColor(new java.awt.Color(255, 255, 255));
        addressTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressTfKeyPressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Address");

        cnicTf.setBackground(new java.awt.Color(29, 29, 29));
        cnicTf.setForeground(new java.awt.Color(255, 255, 255));
        cnicTf.setCaretColor(new java.awt.Color(255, 255, 255));
        cnicTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cnicTfKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CNIC");

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Account#");

        accountTf.setBackground(new java.awt.Color(29, 29, 29));
        accountTf.setForeground(new java.awt.Color(255, 255, 255));
        accountTf.setCaretColor(new java.awt.Color(255, 255, 255));
        accountTf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                accountTfKeyPressed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(187, 134, 252));
        addBtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(19, 19, 19)
                        .addComponent(cnicTf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(accountTf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contactTf, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(empNameTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(idTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(contactTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cnicTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accountTf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(32, 32, 32)
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);

        dealersTable.setBackground(new java.awt.Color(20, 20, 20));
        dealersTable.setForeground(new java.awt.Color(255, 255, 255));
        dealersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Employee Name", "Email", "Contact#", "Address", "CNIC", "Account#"
            }
        ));
        dealersTable.setFocusable(false);
        dealersTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        dealersTable.setRequestFocusEnabled(false);
        dealersTable.setRowHeight(26);
        dealersTable.setSelectionBackground(new java.awt.Color(153, 153, 153));
        dealersTable.setShowVerticalLines(false);
        dealersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(dealersTable);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(29, 29, 29));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Dealers");

        jButton8.setBackground(new java.awt.Color(29, 29, 29));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/demeImages/icons8_left_25px.png"))); // NOI18N
        jButton8.setBorderPainted(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton8)
                .addGap(379, 379, 379)
                .addComponent(jLabel1)
                .addContainerGap(471, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.dispose();
        new DealerForm().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed
    int id = 0;
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        try {

            String name = nameTf.getText();
            String empname = empNameTf.getText();
            String email = emailTf.getText();
            String contact = contactTf.getText();
            String address = addressTf.getText();
            String cnic = cnicTf.getText();
            String accountNo = accountTf.getText();

            if (name.isEmpty() || email.isEmpty() || contact.isEmpty() || empname.isEmpty() || address.isEmpty() || cnic.isEmpty() || accountNo.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please Enter data in all fields", "Empty Fields", JOptionPane.ERROR_MESSAGE);

            }
            if (!contact.matches("[0-9]+") && contact.length() > 2) {
                JOptionPane.showMessageDialog(null, "Contact can not have Alphabets", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            }

            if (!email.contains("@gmail.com")) {

                JOptionPane.showMessageDialog(null, "Please Enter a valid email i.e (abc@gmail.com)", "Invalid email", JOptionPane.ERROR_MESSAGE);

            } else {

                st = conn.prepareStatement("insert into supplier_contact_details values(?,?,?,?,?,?,?,?,curdate(),curtime())");
                st.setInt(1, id);
                st.setString(2, name);
                st.setString(3, empname);
                st.setString(4, email);
                st.setString(5, contact);
                st.setString(6, address);
                st.setString(7, cnic);
                st.setString(8, accountNo);

                st.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data inserted successfuly", "Success", JOptionPane.INFORMATION_MESSAGE);
                Refresh();
                dealersTable.setRowSelectionInterval(id - 1, id - 1);
                dealersTable.scrollRectToVisible(dealersTable.getCellRect(id - 1, 0, true));
                getID();
                
                this.dispose();
                new AddBrand().setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void nameTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String name = nameTf.getText().toLowerCase();
            try {
                st = conn.prepareStatement("select name from supplier_contact_details where name=?");
                st.setString(1, name);
                rs = st.executeQuery();

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Must enter a name", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Supplier name already exsist", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else if (!name.matches("^[a-z A-Z]*$")) {
                    JOptionPane.showMessageDialog(null, "Name can not have digits or special characters", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else {
                    empNameTf.grabFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_nameTfKeyPressed

    private void empNameTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_empNameTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String name = empNameTf.getText().toLowerCase();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Must enter a name", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (!name.matches("^[a-z A-Z]*$")) {
                JOptionPane.showMessageDialog(null, "Name can not have digits or special characters", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else {
                emailTf.grabFocus();
            }

        }
    }//GEN-LAST:event_empNameTfKeyPressed

    private void emailTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String email = emailTf.getText();

            if (email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Must enter email address", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (!email.contains("@gmail.com")) {

                JOptionPane.showMessageDialog(null, "Please Enter a valid email i.e (abc@gmail.com)", "Invalid email", JOptionPane.ERROR_MESSAGE);

            } else {
                contactTf.grabFocus();
            }

        }
    }//GEN-LAST:event_emailTfKeyPressed

    private void contactTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String contact = contactTf.getText();

            if (contact.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Contact # can not be empty", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (!contact.matches("[0-9]+")) {

                JOptionPane.showMessageDialog(null, "Please Enter a proper number (03121212125)", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (contact.length() < 11) {
                JOptionPane.showMessageDialog(null, "Contact# Too short, Enter properly", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (contact.length() > 11) {
                JOptionPane.showMessageDialog(null, "Contact# Too long it can contain only 12 digits", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else {

                addressTf.grabFocus();
            }

        }
    }//GEN-LAST:event_contactTfKeyPressed

    private void addressTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressTfKeyPressed

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            String address = addressTf.getText();
            if (address.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Addresss can not be empty", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else {
                cnicTf.grabFocus();
            }
        }
    }//GEN-LAST:event_addressTfKeyPressed

    private void cnicTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cnicTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                String cnic = cnicTf.getText();

                st = conn.prepareStatement("select cnic_no from supplier_contact_details where cnic_no=?");
                st.setString(1, cnic);
                rs = st.executeQuery();

                if (cnic.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "CNIC can not be empty", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "CNIC number already exist", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else if (!cnic.matches("[0-9]+")) {

                    JOptionPane.showMessageDialog(null, "CNIC can not have alphabtes or special symobls", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else if (cnic.length() < 13) {
                    JOptionPane.showMessageDialog(null, "CNIC must contain 13 digits", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else if (cnic.length() > 13) {
                    JOptionPane.showMessageDialog(null, "CNIC can not be greater than 13 digits", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

                } else {

                    accountTf.grabFocus();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddDealer.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_cnicTfKeyPressed

    private void accountTfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_accountTfKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String account = accountTf.getText();

            if (account.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Account # can not be empty", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (!account.matches("[0-9]+")) {

                JOptionPane.showMessageDialog(null, "Accoun Number can not have alphabtes or special symobls", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (account.length() < 10) {
                JOptionPane.showMessageDialog(null, "Account# must contain 10 digits", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else if (account.length() > 10) {
                JOptionPane.showMessageDialog(null, "Account# can not be greater than 10 digits", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            } else {
                addDealer();

            }

        }
    }//GEN-LAST:event_accountTfKeyPressed
    int xMouse;
    int yMouse;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_formMousePressed

    void addDealer() {

        try {

            String name = nameTf.getText();
            String empname = empNameTf.getText();
            String email = emailTf.getText();
            String contact = contactTf.getText();
            String address = addressTf.getText();
            String cnic = cnicTf.getText();
            String accountNo = accountTf.getText();

            if (name.isEmpty() || email.isEmpty() || contact.isEmpty() || empname.isEmpty() || address.isEmpty() || cnic.isEmpty() || accountNo.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Please Enter data in all fields", "Empty Fields", JOptionPane.ERROR_MESSAGE);

            }
            if (!contact.matches("[0-9]+") && contact.length() > 2) {
                JOptionPane.showMessageDialog(null, "Contact can not have Alphabets", "Invalid Entry", JOptionPane.ERROR_MESSAGE);

            }

            if (!email.contains("@gmail.com")) {

                JOptionPane.showMessageDialog(null, "Please Enter a valid email i.e (abc@gmail.com)", "Invalid email", JOptionPane.ERROR_MESSAGE);

            } else {

                st = conn.prepareStatement("insert into supplier_contact_details values(?,?,?,?,?,?,?,?,curdate(),curtime())");
                st.setInt(1, id);
                st.setString(2, name);
                st.setString(3, empname);
                st.setString(4, email);
                st.setString(5, contact);
                st.setString(6, address);
                st.setString(7, cnic);
                st.setString(8, accountNo);

                st.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data inserted successfuly", "Success", JOptionPane.INFORMATION_MESSAGE);
                Refresh();
                getID();
                this.dispose();
                new AddBrand().setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getAllDealers() {
        try {
            conn = DBConnection.getConnection();
            String view = "select * from supplier_contact_details";
            st = conn.prepareStatement(view);
            rs = st.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String employee = rs.getString(3);
                String email = rs.getString(4);
                String contact = rs.getString(5);
                String address = rs.getString(6);
                String cnic = rs.getString(7);
                String account = rs.getString(8);

                Object[] obj = {id, name, employee, email, contact, address, cnic, account};
                DefaultTableModel tb = (DefaultTableModel) dealersTable.getModel();
                tb.addRow(obj);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeForm.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    void Refresh() {
        DefaultTableModel tb = (DefaultTableModel) dealersTable.getModel();
        tb.setRowCount(0);
        getAllDealers();
    }

    void getID() {

        try {
            st = conn.prepareStatement("select max(id) from supplier_contact_details");
            rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
                idTf.setText(id + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDealer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDealer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountTf;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextField addressTf;
    private javax.swing.JTextField cnicTf;
    private javax.swing.JTextField contactTf;
    private javax.swing.JTable dealersTable;
    private javax.swing.JTextField emailTf;
    private javax.swing.JTextField empNameTf;
    private javax.swing.JTextField idTf;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTf;
    // End of variables declaration//GEN-END:variables
}
