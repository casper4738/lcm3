/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm.view;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.Timer;
import lcm.BBS;
import lcm.Ishihara;
import lcm.LCM;
import lcm.Plate;
import swingx.utility.FilterInput;

/**
 *
 * @author casper
 */
public class PanelIshiharaTest extends javax.swing.JPanel {

    /**
     * Creates new form PanelIshiharaTest
     */
    private List<Plate> listPlates;
    private final DecimalFormat format;
    private int number;
    private Object myAnswer = "";
    private FrameMain main;
    private StringBuilder answerLeft;
    private StringBuilder answerRight;
    private Timer timer;
    private int timeCount = 10;
    private boolean finish;

    public void setMain(FrameMain main) {
        this.main = main;
    }

    public PanelIshiharaTest() {
        initComponents();
        finish = false;
        this.main = main;
        number = 0;
        format = new DecimalFormat("#00");
        jTextField2.setDocument(new FilterInput().getOnlyNumber(2));
        timer = new Timer(1000, new ActionListener() {
            private int s = 0;
            private int m = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                timeCount--;
                if (timeCount == 0) {
                    timeCount = 10;
                    myAnswer = "";
                    saveAnswer();
                    number++;
                    nextQuestion();
                }
                jTextField1.setText("00:" + format.format(timeCount));
                s++;
                if (s == 60) {
                    s = 0;
                    m++;
                }
                labelTime.setText("00:" + format.format(m) + ":" + format.format(s));
            }
        });

//        timer.stop();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        iPanelIshihara1 = new lcm.component.IPanelIshihara();
        jLabel1 = new javax.swing.JLabel();
        panelAnswer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        buttonNextQues = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        buttonLines0 = new javax.swing.JButton();
        buttonLines1 = new javax.swing.JButton();
        buttonLines2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        buttonResult = new javax.swing.JButton();
        labelAnswerLeft = new javax.swing.JLabel();
        labelAnswerRight = new javax.swing.JLabel();
        labelTime = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        iPanelIshihara1.setOpaque(false);

        javax.swing.GroupLayout iPanelIshihara1Layout = new javax.swing.GroupLayout(iPanelIshihara1);
        iPanelIshihara1.setLayout(iPanelIshihara1Layout);
        iPanelIshihara1Layout.setHorizontalGroup(
            iPanelIshihara1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        iPanelIshihara1Layout.setVerticalGroup(
            iPanelIshihara1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Calisto MT", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Plate 01 dari 38");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        panelAnswer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelAnswer.setOpaque(false);
        panelAnswer.setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 65;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(jTextField2, gridBagConstraints);

        buttonNextQues.setText("Next");
        buttonNextQues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextQuesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(buttonNextQues, gridBagConstraints);

        panelAnswer.add(jPanel1, "answer-number");

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Lines : ");
        jPanel2.add(jLabel3);

        buttonLines0.setText("0");
        buttonLines0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLines0ActionPerformed(evt);
            }
        });
        jPanel2.add(buttonLines0);

        buttonLines1.setText("1");
        buttonLines1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLines1ActionPerformed(evt);
            }
        });
        jPanel2.add(buttonLines1);

        buttonLines2.setText("2");
        buttonLines2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLines2ActionPerformed(evt);
            }
        });
        jPanel2.add(buttonLines2);

        jPanel3.add(jPanel2, java.awt.BorderLayout.CENTER);

        panelAnswer.add(jPanel3, "answer-line");

        jPanel4.setOpaque(false);

        buttonResult.setText("Hasil Tes");
        buttonResult.setPreferredSize(new java.awt.Dimension(85, 28));
        buttonResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(buttonResult, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonResult, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
        );

        panelAnswer.add(jPanel4, "answer-result");

        labelAnswerLeft.setText("<html> Plate 01<br> Plate 02<br> Plate 03<br> Plate 04<br> Plate 05<br> Plate 06<br> Plate 07<br> Plate 08<br> Plate 09<br> Plate 10<br> Plate 11<br> Plate 12<br> Plate 13<br> Plate 14<br> Plate 15<br> Plate 16<br> Plate 17<br> Plate 18<br> Plate 19<br> </html>");
        labelAnswerLeft.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelAnswerRight.setText("<html> Plate 01<br> Plate 02<br> Plate 03<br> Plate 04<br> Plate 05<br> Plate 06<br> Plate 07<br> Plate 08<br> Plate 09<br> Plate 10<br> Plate 11<br> Plate 12<br> Plate 13<br> Plate 14<br> Plate 15<br> Plate 16<br> Plate 17<br> Plate 18<br> Plate 19<br> </html>");
        labelAnswerRight.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        labelTime.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        labelTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTime.setText("00:00:00");

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("10");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iPanelIshihara1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(labelAnswerLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAnswerRight, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addComponent(panelAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAnswerRight, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelAnswerLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelAnswer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iPanelIshihara1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNextQuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextQuesActionPerformed
        myAnswer = jTextField2.getText();
        saveAnswer();
        number++;
        nextQuestion();
    }//GEN-LAST:event_buttonNextQuesActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        myAnswer = jTextField2.getText();
        saveAnswer();
        number++;
        nextQuestion();
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void buttonLines0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLines0ActionPerformed
        myAnswer = 0;
        saveAnswer();
        number++;
        nextQuestion();
    }//GEN-LAST:event_buttonLines0ActionPerformed

    private void buttonLines1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLines1ActionPerformed
        myAnswer = 1;
        saveAnswer();
        number++;
        nextQuestion();
    }//GEN-LAST:event_buttonLines1ActionPerformed

    private void buttonLines2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLines2ActionPerformed
        myAnswer = 2;
        saveAnswer();
        number++;
        nextQuestion();
    }//GEN-LAST:event_buttonLines2ActionPerformed

    private void buttonResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResultActionPerformed
        finish = true;
        main.showResult();
    }//GEN-LAST:event_buttonResultActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public boolean isFinish() {
        return finish;
    }

    private void saveAnswer() {
        listPlates.get(number).setType(iPanelIshihara1.getType()[number]);
        listPlates.get(number).setAnswer(myAnswer);

        int plate = listPlates.get(number).getPlate();

        if (number % 2 == 0) {
            answerLeft.append("<br>Plate " + format.format(plate + 1) + " : " + myAnswer);
        } else if (number % 2 == 1) {
            answerRight.append("<br>Plate " + format.format(plate + 1) + " : " + myAnswer);
        }
        labelAnswerLeft.setText("<html> " + answerLeft.toString() + " </html>");
        labelAnswerRight.setText("<html> " + answerRight.toString() + " </html>");
    }

    private void nextQuestion() {
        if (number == 38) {
            finish = true;
            showCard("answer-result");
            stopTimer();
        } else {
            iPanelIshihara1.setPlate(listPlates.get(number).getPlate());
            listPlates.get(number).setType(iPanelIshihara1.getType()[listPlates.get(number).getPlate()]);
            showCard("answer-" + listPlates.get(number).getType());

            jLabel1.setText("Soal " + format.format(number + 1) + " dari 38");
            jTextField2.setText("");
            jTextField2.requestFocus();
            timeCount = 10;
            jTextField1.setText("00:" + timeCount);
        }
    }

    public void stopTimer() {
        timer.stop();
    }

    public void startTimer() {
        timer.restart();
    }

    private long timeDuration;

    public long getTimeDuration() {
        return timeDuration;
    }

    private int number_lcm = 1;

    public void reset(String method) {
        long long1 = System.nanoTime();
        finish = false;
        number = 0;
        listPlates = new ArrayList<>();

        Properties properties = new Properties();
        File file = new File("config.xml");
        try {
            int number_test_p = 1;
            int number_test_q = 1;
            if (file.exists()) {
                properties.loadFromXML(new FileInputStream(file));
                if (number_lcm == 1) {
                    number_lcm = new Integer(properties.getProperty("ID", "1"));
                }
                number_test_p = new Integer(properties.getProperty("NUMBER_TEST_P", "5"));
                number_test_q = new Integer(properties.getProperty("NUMBER_TEST_Q", "5"));
            }

            properties.storeToXML(new FileOutputStream(file), "APLIKASI TES BUTA WARNA MENGGUNAKAN LCM");
            FrameMain.USER.setNumberTest(number_lcm);
            FrameMain.USER.setNumberTestP(number_test_p);
            FrameMain.USER.setNumberTestQ(number_test_q);
        } catch (Exception e) {
        }

        switch (method) {
            case "method1": {
                int z = FrameMain.USER.getNumberTest();
                z = z % 38;
                LCM lcm = new LCM();
                lcm.setA(1);
                lcm.setC(7);
                lcm.setM(38);
                lcm.setZ0(z);
                lcm.run();
                int[] list = lcm.getListRandom();
                Ishihara ishihara = new Ishihara();
                for (int i = 0; i < 38; i++) {
                    Plate plate = new Plate();
                    plate.setPlate(list[i]);
                    plate.setType("");
                    plate.setAnswer("");
                    plate.setResult(0);
                    listPlates.add(plate);
                }
                number_lcm++;
                break;
            }
            case "method2": {
                BBS bbs = new BBS();
                bbs.setP(BigInteger.valueOf(FrameMain.USER.getNumberTestP()));
                bbs.setQ(BigInteger.valueOf(FrameMain.USER.getNumberTestQ()));
                bbs.run();

                int[] list = bbs.getListRandom();
                for (int i = 0; i < 38; i++) {
                    Plate plate = new Plate();
                    plate.setPlate(list[i]);
                    plate.setType("");
                    plate.setAnswer("");
                    plate.setResult(0);
                    listPlates.add(plate);
                }

                int number_test_p = bbs.getP().intValue();
                int number_test_q = bbs.getQ().intValue() + 1;

                if (number_test_p == 90 && number_test_q == 90) {
                    number_test_p = 5;
                    number_test_q = 5;
                } else if (number_test_q > 90) {
                    number_test_p++;
                    number_test_q = 5;
                }
                properties.setProperty("NUMBER_TEST_P", format.format(number_test_p));
                properties.setProperty("NUMBER_TEST_Q", format.format(number_test_q));
                break;
            }
        }

        try {
            properties.storeToXML(new FileOutputStream(file), "APLIKASI TES BUTA WARNA MENGGUNAKAN LCM");
        } catch (Exception e) {
        }
        long long2 = System.nanoTime();
        timeDuration = TimeUnit.MILLISECONDS.convert(long2 - long1, TimeUnit.NANOSECONDS);

//        for (int i = 0; i < 38; i++) {
//            Plate plate = new Plate();
//            plate.setPlate(i);
//            plate.setType("");
//            plate.setAnswer("");
//            plate.setResult(0);
//            listPlates.add(plate);
//        }
        nextQuestion();

        jTextField2.setText("");
        jTextField2.requestFocus();

        answerLeft = new StringBuilder();
        answerRight = new StringBuilder();
        labelAnswerLeft.setText(answerLeft.toString());
        labelAnswerRight.setText(answerRight.toString());
    }

    private void showCard(String card) {
        ((CardLayout) panelAnswer.getLayout()).show(panelAnswer, card);
    }

    public List<Plate> getListPlates() {
        return listPlates;
    }

    public JLabel getLabelTime() {
        return labelTime;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLines0;
    private javax.swing.JButton buttonLines1;
    private javax.swing.JButton buttonLines2;
    private javax.swing.JButton buttonNextQues;
    private javax.swing.JButton buttonResult;
    private lcm.component.IPanelIshihara iPanelIshihara1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel labelAnswerLeft;
    private javax.swing.JLabel labelAnswerRight;
    private javax.swing.JLabel labelTime;
    private javax.swing.JPanel panelAnswer;
    // End of variables declaration//GEN-END:variables

}
