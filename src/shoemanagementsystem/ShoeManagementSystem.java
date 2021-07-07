/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoemanagementsystem;


import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;


/**
 *
 * @author mnawa
 */
public class ShoeManagementSystem {

    static RandomAccessFile file;
    static String theme2;

 
    
    
    
    

    public static void main(String[] args) {

        try {
            file = new RandomAccessFile("theme.txt", "rw");
            theme2 = file.readUTF();
            
            if (theme2.contains("metal")) {
                setLookandFeel(UIManager.getCrossPlatformLookAndFeelClassName());

            } else if (theme2.contains("nimbus")) {

                setLookandFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            } else if (theme2.contains("windows")) {
                setLookandFeel(UIManager.getSystemLookAndFeelClassName());

            } else if (theme2.contains("motif")) {

                setLookandFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");

            }
            file.close();

        } catch (Exception ex) {
            // when fiel not found.....
            ex.printStackTrace();
        }

        new LoginPage().setVisible(true);
    }

    public static void setLookandFeel(String theme) {
        try {
            UIManager.setLookAndFeel(theme);
            file = new RandomAccessFile("theme.txt", "rw");

            // save the theme2 state
            file.writeUTF(theme);
            file.close();
        } catch (Exception ex) {
            Logger.getLogger(ShoeManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
