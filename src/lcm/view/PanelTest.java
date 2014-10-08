/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm.view;

/**
 *
 * @author casper
 */
public class PanelTest extends javax.swing.JPanel {

    /**
     * Creates new form PanelTest
     */
    public PanelTest(FrameMain main) {
        initComponents();

        panelIshiharaTest1.setMain(main);
        panelIshiharaTest2.setMain(main);
    }

    public void start() {
        panelIshiharaTest1.reset("method1");
        panelIshiharaTest1.startTimer();
        panelIshiharaTest2.reset("method2");
        panelIshiharaTest2.startTimer();

        jLabel2.setText("KECEPATAN PENGACAKAN : " + panelIshiharaTest1.getTimeDuration() + " MS");
        jLabel3.setText("KECEPATAN PENGACAKAN : " + panelIshiharaTest2.getTimeDuration() + " MS");
    }

    public void restart() {
        panelIshiharaTest1.stopTimer();
        panelIshiharaTest2.stopTimer();
    }

    public PanelIshiharaTest getPanelIshiharaTest1() {
        return panelIshiharaTest1;
    }

    public PanelIshiharaTest getPanelIshiharaTest2() {
        return panelIshiharaTest2;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelIshiharaTest1 = new lcm.view.PanelIshiharaTest();
        panelIshiharaTest2 = new lcm.view.PanelIshiharaTest();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LINEAR CONGRUENCT METHOD (LCM)");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("KECEPATAN PENGACAKAN : 0 MS");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("KECEPATAN PENGACAKAN : 0 MS");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("BLUM - BLUM SHUB (BBS)");

        panelIshiharaTest1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelIshiharaTest1.setOpaque(false);

        panelIshiharaTest2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelIshiharaTest2.setOpaque(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIshiharaTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(panelIshiharaTest2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelIshiharaTest1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(panelIshiharaTest2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private lcm.view.PanelIshiharaTest panelIshiharaTest1;
    private lcm.view.PanelIshiharaTest panelIshiharaTest2;
    // End of variables declaration//GEN-END:variables
}
