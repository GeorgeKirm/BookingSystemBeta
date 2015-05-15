package project2omeros;

import javax.swing.JOptionPane;

/**
 * This class is for the "welcome" interface
 * @author GeorgeKirm
 * @author GT
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUItesting
     */
    public GUI() {
        initComponents();
        setLocationRelativeTo(null); //emfanizei to parathiro sto kentro tis othonhs
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        LogInButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        FirstWindow = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        quitB = new javax.swing.JMenuItem();
        testing = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        HelpB = new javax.swing.JMenuItem();
        About = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(340, 296));

        LogInButton.setText("Log In");
        LogInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInButtonActionPerformed(evt);
            }
        });

        RegisterButton.setText("Register");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Welcome to our cinema/theater Booking System.\n\nPlease Log In or Register.");
        FirstWindow.setViewportView(jTextArea1);

        jMenu1.setText("File");

        quitB.setText("Quit");
        quitB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBActionPerformed(evt);
            }
        });
        jMenu1.add(quitB);

        testing.setText("~Testing");
        testing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingActionPerformed(evt);
            }
        });
        jMenu1.add(testing);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        HelpB.setText("Help");
        HelpB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpBActionPerformed(evt);
            }
        });
        jMenu2.add(HelpB);

        About.setText("About");
        About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutActionPerformed(evt);
            }
        });
        jMenu2.add(About);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FirstWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LogInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FirstWindow, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LogInButton)
                    .addComponent(RegisterButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInButtonActionPerformed
        GUIforLogIn_Register temp = new GUIforLogIn_Register('l'); //kalei to interface logIn/register gia na kanei log in
        temp.setLocationRelativeTo(null);
        temp.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogInButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        GUIforLogIn_Register temp = new GUIforLogIn_Register('r'); //kalei to interface logIn/register gia na kanei register
        temp.setLocationRelativeTo(null);
        temp.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void quitBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitBActionPerformed

    private void testingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingActionPerformed
        Account.cName = "Test"; //sundeete os admin me auta ta stixeia gia grigoro testing
        Account.cPasswordAndRights[0] = "pass";
        Account.cPasswordAndRights[1] = "A";
        GUIforUser temp = new GUIforUser();
        temp.setLocationRelativeTo(null);
        temp.setVisible(true);
        dispose();
    }//GEN-LAST:event_testingActionPerformed

    private void HelpBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpBActionPerformed
        JOptionPane.showMessageDialog(null, "The program has as default English Language.\nPress \"Log in\" "
                + "to Log in the Booking System.\nPress\"Register\" to Register a new account\n\nv.2.4", 
                "Help Box",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_HelpBActionPerformed

    private void AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutActionPerformed
        JOptionPane.showMessageDialog(null, "This program is a project for the class \"Antikimenostrafhs programatismos\""
                + "\nBasically it is a program for a cinema or theater to help the user book an event\nor an admin tou"
                + "add/edit events or halls", 
                "About",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AboutActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
                        
            }
        });
    
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem About;
    private javax.swing.JScrollPane FirstWindow;
    private javax.swing.JMenuItem HelpB;
    private javax.swing.JButton LogInButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem quitB;
    private javax.swing.JMenuItem testing;
    // End of variables declaration//GEN-END:variables


}