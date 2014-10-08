/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm.view;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import javax.swing.JLabel;
import lcm.Ishihara;
import lcm.Plate;
import lcm.User;
import lcm.component.TableCellRenderer;
import lcm.component.TableModelResult;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import swingx.component.table.renderer.TableCellAlignmentRenderer;
import swingx.utility.UtilityPrint;

/**
 *
 * @author casper
 */
public class PanelTestResult extends javax.swing.JPanel {

    /**
     * Creates new form PanelTestResult
     */
    private TableModelResult tableModel;
    private Ishihara ishihara;
    private FrameMain main;

    public void setMain(FrameMain main) {
        this.main = main;
    }

    public PanelTestResult() {
        initComponents();

        ishihara = new Ishihara();

        tableModel = new TableModelResult();
        table.setModel(tableModel);

        table.getColumnModel().getColumn(0).setCellRenderer(new TableCellAlignmentRenderer(JLabel.CENTER));
        table.getColumnModel().getColumn(1).setCellRenderer(new TableCellAlignmentRenderer(JLabel.CENTER));
        table.getColumnModel().getColumn(2).setCellRenderer(new TableCellAlignmentRenderer(JLabel.CENTER));
        table.getColumnModel().getColumn(3).setCellRenderer(new TableCellAlignmentRenderer(JLabel.CENTER));
        table.getColumnModel().getColumn(4).setCellRenderer(new TableCellAlignmentRenderer(JLabel.CENTER));
        table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer());

        table.getColumnModel().getColumn(0).setPreferredWidth(7);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(5);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(5);
        table.getColumnModel().getColumn(5).setPreferredWidth(5);
        table.setRowHeight(23);
    }

    private String method;
    private String time;

    public void set(List<Plate> lists, String method, String time) {
        try {
            this.method = method;
            this.time = time;
            ishihara.reset();
            Object[] answer = new Object[38];
            for (Plate plate : lists) {
                plate.setResult(ishihara.check(plate));
                plate.setCorrect(ishihara.getCorrect(plate));
                plate.setWeak(ishihara.getWeak(plate));
                answer[plate.getPlate()] = plate.getAnswer();
            }

            tableModel.setList(lists);
            table.setModel(tableModel);
            table.revalidate();

            ishihara.setAnswer(answer);
            ishihara.reset();
            String strings = ishihara.getResult();
            labelResult.setText("<html>" + strings + "</html>".toUpperCase());
        } catch (Exception ex) {
        }

        try {
            List<User> list = new ArrayList<>();
            list.add(FrameMain.USER);

            int par2 = 0;
            int par3 = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Plate p = tableModel.get(i);
                if (p.getResult() != 0) {
                    par2++;
                }
            }

            ishihara.reset();
            int wrong = ishihara.wrong();
            int protan = ishihara.protan();
            int deutan = ishihara.deutan();
            int total = wrong - protan - deutan;

            String hasil = "";
            String ket = "";
            if (wrong <= 4) {
                hasil = hasil + "Anda memiliki penglihatan normal";
            } else if (protan >= 3 && total <= 5) {
                hasil = hasil + "Anda terindikasi mengalami penglihatan lemah terhadap warna merah (PROTAN)";
                ket = "Pelinghatan lemah terhadap lemah terhadap warna merah (PROTAN) terjadinya karena sel "
                        + "kerucut warna merah tidak berfungsi dengan baik, sehingga penderita kurang sensitif "
                        + "atau kesulitan mengenali warna merah dan perpaduannya.";
            } else if (deutan >= 3 && total <= 5) {
                hasil = hasil + "Anda terindikasi mengalami penglihatan lemah terhadao warna hijau (DEUTRAN)";
                ket = "Pelinghatan lemah terhadap lemah terhadap warna hijau (DEUTRAN) terjadinya karena sel "
                        + "kerucut warna hijau tidak berfungsi dengan baik, sehingga penderita kurang sensitif "
                        + "atau kesulitan mengenali warna merah dan perpaduannya.";
            } else if (total < 38) {
                hasil = hasil + "Anda terindikasi mengalami penglihatan Buta Warna Parsial";
                ket = "Penglihatan Buta Warna Parsial terjadi karena satu dari tiga sel kerucut tidak ada.";
            } else {
                hasil = hasil + "Anda terindikasi mengalami penglihatan Buta Warna Total";
                ket = "Penglihatan Buta Warna Total terjadi karena kondisi retina mata "
                        + "yang mengalami kerusakan total dalam merespon warna sehingga yang "
                        + "terlihat hanya putih dan hitam yang mapmpu diterima retina.";
            }

            Properties properties = new Properties();
            properties.setProperty("ID", FrameMain.USER.getId());
            properties.setProperty("NAME", FrameMain.USER.getName());
            properties.setProperty("AGE", FrameMain.USER.getAge() + "");
            properties.setProperty("JOBS", FrameMain.USER.getJobs() + "");
            properties.setProperty("ADDRESS", FrameMain.USER.getAddress());
            properties.setProperty("NUMBER_TEST", FrameMain.USER.getNumberTest() + "");
            properties.setProperty("PARAMETER1", hasil);
            properties.setProperty("PARAMETER2", par2 + "");
            properties.setProperty("PARAMETER3", (38 - par2) + "");
            properties.setProperty("PARAMETER4", ket);
            properties.setProperty("METHOD", method);
            properties.setProperty("TIME", time);
            properties.storeToXML(new FileOutputStream(new File("./result/" + FrameMain.USER.getId() + "-" + method + ".xml")), "LCM | BBS - ISHIHARA");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        labelResult = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        labelResult.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jButton1.setText("CETAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addComponent(labelResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelResult, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            List<User> list = new ArrayList<>();
            list.add(FrameMain.USER);

            int par2 = 0;
            int par3 = 0;
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                Plate p = tableModel.get(i);
                if (p.getResult() != 0) {
                    par2++;
                }
            }

            ishihara.reset();
            int wrong = ishihara.wrong();
            int protan = ishihara.protan();
            int deutan = ishihara.deutan();
            int total = wrong - protan - deutan;

            String hasil = "";
            String ket = "";
            if (wrong <= 4) {
                hasil = hasil + "Anda memiliki penglihatan normal";
            } else if (protan >= 3 && total <= 5) {
                hasil = hasil + "Anda terindikasi mengalami penglihatan lemah terhadap warna merah (PROTAN)";
                ket = "Pelinghatan lemah terhadap warna merah (PROTAN) terjadinya karena sel "
                        + "kerucut warna merah tidak berfungsi dengan baik, sehingga penderita kurang sensitif "
                        + "atau kesulitan mengenali warna merah dan perpaduannya.";
            } else if (deutan >= 3 && total <= 5) {
                hasil = hasil + "Anda terindikasi mengalami penglihatan lemah terhadao warna hijau (DEUTRAN)";
                ket = "Pelinghatan lemah terhadap warna hijau (DEUTRAN) terjadinya karena sel "
                        + "kerucut warna hijau tidak berfungsi dengan baik, sehingga penderita kurang sensitif "
                        + "atau kesulitan mengenali warna merah dan perpaduannya.";
            } else if (total < 38) {
                hasil = hasil + "Anda terindikasi mengalami penglihatan Buta Warna Parsial";
                ket = "Penglihatan Buta Warna Parsial terjadi karena satu dari tiga sel kerucut tidak ada.";
            } else {
                hasil = hasil + "Anda terindikasi mengalami penglihatan Buta Warna Total";
                ket = "Penglihatan Buta Warna Total terjadi karena kondisi retina mata "
                        + "yang mengalami kerusakan total dalam merespon warna sehingga yang "
                        + "terlihat hanya putih dan hitam yang mapmpu diterima retina.";
            }

            JRBeanCollectionDataSource dt = new JRBeanCollectionDataSource(list);
            HashMap map = new HashMap();
            map.put("parameter1", hasil);
            map.put("parameter2", par2 + "");
            map.put("parameter3", (38 - par2) + "");
            map.put("parameter4", ket);
            map.put("parameter5", method);
            map.put("parameter6", time);
            UtilityPrint.printReport(dt, "report1", map);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelResult;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
