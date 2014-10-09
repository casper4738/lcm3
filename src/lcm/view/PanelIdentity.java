/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lcm.User;
import swingx.utility.FilterInput;

/**
 *
 * @author casper
 */
public class PanelIdentity extends javax.swing.JPanel {

    /**
     * Creates new form PanelRegister
     */
    private DecimalFormat format;
    private FrameMain frameMain;

    public PanelIdentity(FrameMain frameMain) {
        initComponents();

        this.frameMain = frameMain;

        format = new DecimalFormat("#00000");

        Properties properties = new Properties();
        File file = new File("config.xml");
        try {
            int id = 1;
            if (file.exists()) {
                properties.loadFromXML(new FileInputStream(file));
                id = new Integer(properties.getProperty("ID", "0")) + 1;
            }
            properties.setProperty("ID", format.format(id));
            properties.storeToXML(new FileOutputStream(file), "APLIKASI TES BUTA WARNA MENGGUNAKAN LCM");
            textID.setText(format.format(id));
        } catch (Exception ex) {
            Logger.getLogger(PanelIdentity.class.getName()).log(Level.SEVERE, null, ex);
            textID.setText(format.format(1));
        }

        textName.setDocument(new FilterInput().getTextLimit(50, true));
        textJobs.setDocument(new FilterInput().getTextLimit(100, true));
        textAddress.setDocument(new FilterInput().getTextLimit(300, true));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        iPanelGlass1 = new lcm.component.IPanelGlass();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAddress = new javax.swing.JTextArea();
        textAge = new javax.swing.JSpinner();
        textName = new lcm.component.ITextField();
        textJobs = new lcm.component.ITextField();
        textID = new lcm.component.ITextField();
        iPanelGlass4 = new lcm.component.IPanelGlass();
        iPa19 = new lcm.component.IPa();
        iPa20 = new lcm.component.IPa();
        iPa21 = new lcm.component.IPa();
        iPa22 = new lcm.component.IPa();
        iPa23 = new lcm.component.IPa();
        iPa14 = new lcm.component.IPa();
        iPa15 = new lcm.component.IPa();
        iPa16 = new lcm.component.IPa();
        iPa17 = new lcm.component.IPa();
        iPa18 = new lcm.component.IPa();
        iPa5 = new lcm.component.IPa();
        iPa9 = new lcm.component.IPa();
        iPa10 = new lcm.component.IPa();
        iPa11 = new lcm.component.IPa();
        iPa12 = new lcm.component.IPa();
        iPa13 = new lcm.component.IPa();
        iPa2 = new lcm.component.IPa();
        iPa3 = new lcm.component.IPa();
        iPa4 = new lcm.component.IPa();
        iPa6 = new lcm.component.IPa();
        iPa7 = new lcm.component.IPa();
        iPa8 = new lcm.component.IPa();
        iPa1 = new lcm.component.IPa();
        iPanelGlass3 = new lcm.component.IPanelGlass();
        iPanelGlass2 = new lcm.component.IPanelGlass();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(547, 436));

        iPanelGlass1.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/lcm/resources/eye_1572775c.jpg"))); // NOI18N
        iPanelGlass1.setOpaqueImage(false);
        iPanelGlass1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Usia :");
        iPanelGlass1.add(jLabel3);
        jLabel3.setBounds(10, 97, 52, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Nama :");
        iPanelGlass1.add(jLabel2);
        jLabel2.setBounds(10, 57, 52, 14);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("ID :");
        iPanelGlass1.add(jLabel1);
        jLabel1.setBounds(10, 22, 52, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Pekerjaan :");
        iPanelGlass1.add(jLabel4);
        jLabel4.setBounds(10, 130, 80, 14);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Alamat :");
        iPanelGlass1.add(jLabel5);
        jLabel5.setBounds(10, 167, 70, 20);

        jScrollPane1.setOpaque(false);

        textAddress.setColumns(20);
        textAddress.setRows(5);
        jScrollPane1.setViewportView(textAddress);

        iPanelGlass1.add(jScrollPane1);
        jScrollPane1.setBounds(98, 167, 410, 96);

        textAge.setModel(new javax.swing.SpinnerNumberModel(5, 5, 100, 1));
        iPanelGlass1.add(textAge);
        textAge.setBounds(98, 94, 60, 20);

        textName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iPanelGlass1.add(textName);
        textName.setBounds(98, 52, 410, 25);

        textJobs.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iPanelGlass1.add(textJobs);
        textJobs.setBounds(98, 125, 410, 25);

        textID.setEditable(false);
        textID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        iPanelGlass1.add(textID);
        textID.setBounds(98, 17, 109, 25);

        iPanelGlass4.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/lcm/resources/eye_1572775c.jpg"))); // NOI18N

        javax.swing.GroupLayout iPanelGlass4Layout = new javax.swing.GroupLayout(iPanelGlass4);
        iPanelGlass4.setLayout(iPanelGlass4Layout);
        iPanelGlass4Layout.setHorizontalGroup(
            iPanelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        iPanelGlass4Layout.setVerticalGroup(
            iPanelGlass4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        iPanelGlass1.add(iPanelGlass4);
        iPanelGlass4.setBounds(10, 190, 520, 250);

        iPa19.setRound(false);
        iPa19.setLayout(new java.awt.BorderLayout());

        iPa20.setRound(false);
        iPa20.setLayout(new java.awt.BorderLayout());

        iPa21.setRound(false);
        iPa21.setLayout(new java.awt.BorderLayout());

        iPa22.setRound(false);
        iPa22.setLayout(new java.awt.BorderLayout());

        iPa23.setRound(false);
        iPa23.setLayout(new java.awt.BorderLayout());
        iPa22.add(iPa23, java.awt.BorderLayout.CENTER);

        iPa21.add(iPa22, java.awt.BorderLayout.CENTER);

        iPa20.add(iPa21, java.awt.BorderLayout.CENTER);

        iPa19.add(iPa20, java.awt.BorderLayout.CENTER);

        iPanelGlass1.add(iPa19);
        iPa19.setBounds(110, 20, 90, 20);

        iPa14.setRound(false);
        iPa14.setLayout(new java.awt.BorderLayout());

        iPa15.setRound(false);
        iPa15.setLayout(new java.awt.BorderLayout());

        iPa16.setRound(false);
        iPa16.setLayout(new java.awt.BorderLayout());

        iPa17.setRound(false);
        iPa17.setLayout(new java.awt.BorderLayout());

        iPa18.setRound(false);
        iPa18.setLayout(new java.awt.BorderLayout());
        iPa17.add(iPa18, java.awt.BorderLayout.CENTER);

        iPa16.add(iPa17, java.awt.BorderLayout.CENTER);

        iPa15.add(iPa16, java.awt.BorderLayout.CENTER);

        iPa14.add(iPa15, java.awt.BorderLayout.CENTER);

        iPanelGlass1.add(iPa14);
        iPa14.setBounds(70, 120, 430, 40);

        iPa5.setRound(false);
        iPa5.setLayout(new java.awt.BorderLayout());

        iPa9.setRound(false);
        iPa9.setLayout(new java.awt.BorderLayout());

        iPa10.setRound(false);
        iPa10.setLayout(new java.awt.BorderLayout());

        iPa11.setRound(false);
        iPa11.setLayout(new java.awt.BorderLayout());

        iPa12.setRound(false);
        iPa12.setLayout(new java.awt.BorderLayout());

        iPa13.setRound(false);

        javax.swing.GroupLayout iPa13Layout = new javax.swing.GroupLayout(iPa13);
        iPa13.setLayout(iPa13Layout);
        iPa13Layout.setHorizontalGroup(
            iPa13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        iPa13Layout.setVerticalGroup(
            iPa13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        iPa12.add(iPa13, java.awt.BorderLayout.CENTER);

        iPa11.add(iPa12, java.awt.BorderLayout.CENTER);

        iPa10.add(iPa11, java.awt.BorderLayout.CENTER);

        iPa9.add(iPa10, java.awt.BorderLayout.CENTER);

        iPa5.add(iPa9, java.awt.BorderLayout.CENTER);

        iPanelGlass1.add(iPa5);
        iPa5.setBounds(180, 30, 210, 60);

        iPa2.setRound(false);
        iPa2.setLayout(new java.awt.BorderLayout());

        iPa3.setRound(false);
        iPa3.setLayout(new java.awt.BorderLayout());

        iPa4.setRound(false);
        iPa4.setLayout(new java.awt.BorderLayout());

        iPa6.setRound(false);
        iPa6.setLayout(new java.awt.BorderLayout());

        iPa7.setRound(false);
        iPa7.setLayout(new java.awt.BorderLayout());

        iPa8.setRound(false);

        javax.swing.GroupLayout iPa8Layout = new javax.swing.GroupLayout(iPa8);
        iPa8.setLayout(iPa8Layout);
        iPa8Layout.setHorizontalGroup(
            iPa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        iPa8Layout.setVerticalGroup(
            iPa8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        iPa7.add(iPa8, java.awt.BorderLayout.CENTER);

        iPa6.add(iPa7, java.awt.BorderLayout.CENTER);

        iPa4.add(iPa6, java.awt.BorderLayout.CENTER);

        iPa3.add(iPa4, java.awt.BorderLayout.CENTER);

        iPa2.add(iPa3, java.awt.BorderLayout.CENTER);

        iPanelGlass1.add(iPa2);
        iPa2.setBounds(360, 30, 100, 60);

        iPa1.setRound(false);

        javax.swing.GroupLayout iPa1Layout = new javax.swing.GroupLayout(iPa1);
        iPa1.setLayout(iPa1Layout);
        iPa1Layout.setHorizontalGroup(
            iPa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        iPa1Layout.setVerticalGroup(
            iPa1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        iPanelGlass1.add(iPa1);
        iPa1.setBounds(10, 10, 510, 200);

        iPanelGlass3.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/lcm/resources/eye-exam.jpg"))); // NOI18N

        javax.swing.GroupLayout iPanelGlass3Layout = new javax.swing.GroupLayout(iPanelGlass3);
        iPanelGlass3.setLayout(iPanelGlass3Layout);
        iPanelGlass3Layout.setHorizontalGroup(
            iPanelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );
        iPanelGlass3Layout.setVerticalGroup(
            iPanelGlass3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        iPanelGlass1.add(iPanelGlass3);
        iPanelGlass3.setBounds(10, 10, 520, 260);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lcm/resources/Startup-Refresh.PNG"))); // NOI18N
        jButton1.setText("Simpan Dan Lanjutkan");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/lcm/resources/Startup-Save.PNG"))); // NOI18N
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        iPanelGlass2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lcm/resources/login.png"))); // NOI18N
        jButton2.setText("Data User");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setPreferredSize(new java.awt.Dimension(125, 59));
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        iPanelGlass2.add(jButton2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iPanelGlass2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                    .addComponent(iPanelGlass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iPanelGlass1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iPanelGlass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (textID.getText().equals("")) {
            JOptionPane.showMessageDialog(frameMain, "id masih kosong", "APLIKASI TER BUTA WARNA", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (textName.getText().equals("")) {
            JOptionPane.showMessageDialog(frameMain, "nama masih kosong", "APLIKASI TER BUTA WARNA", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (textJobs.getText().equals("")) {
            JOptionPane.showMessageDialog(frameMain, "pekerjaan masih kosong", "APLIKASI TER BUTA WARNA", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else if (textAddress.getText().equals("")) {
            JOptionPane.showMessageDialog(frameMain, "alamat masih kosong", "APLIKASI TER BUTA WARNA", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        FrameMain.USER = new User();
        FrameMain.USER.setId(textID.getText());
        FrameMain.USER.setName(textName.getText());
        FrameMain.USER.setAge(new Integer(textAge.getValue() + ""));
        FrameMain.USER.setAddress(textAddress.getText());
        FrameMain.USER.setJobs(textJobs.getText());
        FrameMain.USER.setNumberTest(new Integer(textID.getText()) % 32);
        frameMain.showPanelTest();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        frameMain.showPanelUser();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lcm.component.IPa iPa1;
    private lcm.component.IPa iPa10;
    private lcm.component.IPa iPa11;
    private lcm.component.IPa iPa12;
    private lcm.component.IPa iPa13;
    private lcm.component.IPa iPa14;
    private lcm.component.IPa iPa15;
    private lcm.component.IPa iPa16;
    private lcm.component.IPa iPa17;
    private lcm.component.IPa iPa18;
    private lcm.component.IPa iPa19;
    private lcm.component.IPa iPa2;
    private lcm.component.IPa iPa20;
    private lcm.component.IPa iPa21;
    private lcm.component.IPa iPa22;
    private lcm.component.IPa iPa23;
    private lcm.component.IPa iPa3;
    private lcm.component.IPa iPa4;
    private lcm.component.IPa iPa5;
    private lcm.component.IPa iPa6;
    private lcm.component.IPa iPa7;
    private lcm.component.IPa iPa8;
    private lcm.component.IPa iPa9;
    private lcm.component.IPanelGlass iPanelGlass1;
    private lcm.component.IPanelGlass iPanelGlass2;
    private lcm.component.IPanelGlass iPanelGlass3;
    private lcm.component.IPanelGlass iPanelGlass4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAddress;
    private javax.swing.JSpinner textAge;
    private lcm.component.ITextField textID;
    private lcm.component.ITextField textJobs;
    private lcm.component.ITextField textName;
    // End of variables declaration//GEN-END:variables
}
