/*
 * Netbeans 8.0 
 * JDK 1.7  
 */
package lcm.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EventObject;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import lcm.Plate;
import lcm.User;
import lcm.component.TableModelUser;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import swingx.component.table.renderer.TableCellColorAlignmentRenderer;
import swingx.component.table.renderer.TableCellColorRenderer;
import swingx.utility.UtilityPrint;

/**
 *
 * @author casper
 */
public class PanelDataUser extends javax.swing.JPanel {

    /**
     * Creates new form PanelDataUser
     */
    private FrameMain frameMain;
    private JTable table;
    private JComboBox comboSearch;
    private JTextField textSearch;

    public PanelDataUser(FrameMain frameMain) {
        initComponents();

        this.frameMain = frameMain;

        table = iTable1.getTable();
        comboSearch = iTable1.getComboSearch();
        textSearch = iTable1.getTextSearch();
    }

    public void setData() {
        File file = new File("./result/");
        String[] listFile = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                String lowercaseName = name.toLowerCase();
                if (lowercaseName.endsWith(".xml")) {
                    return true;
                } else {
                    return false;
                }
            }
        });

        List<User> list = new ArrayList<>();
        for (String string : listFile) {
            Properties properties = new Properties();
            try {
                properties.loadFromXML(new FileInputStream(new File("./result/" + string)));
                User user = new User();
                user.setAddress(properties.getProperty("ADDRESS"));
                user.setAge(new Integer(properties.getProperty("AGE")));
                user.setId(properties.getProperty("ID"));
                user.setJobs(properties.getProperty("JOBS"));
                user.setName(properties.getProperty("NAME"));
                user.setNumberTest(new Integer(properties.getProperty("NUMBER_TEST")));
                user.setParameter1(properties.getProperty("PARAMETER1", ""));
                user.setParameter2(properties.getProperty("PARAMETER2", ""));
                user.setParameter3(properties.getProperty("PARAMETER3", ""));
                user.setParameter4(properties.getProperty("PARAMETER4", ""));
                user.setMethod(properties.getProperty("METHOD", ""));
                user.setTime(properties.getProperty("TIME", ""));
                list.add(user);
            } catch (Exception ex) {
                Logger.getLogger(PanelDataUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        final TableModelUser tableModel = new TableModelUser();
        tableModel.setList(list);
        table.setModel(tableModel);

        comboSearch.removeAllItems();
        for (int i = 0; i < table.getColumnCount() - 1; i++) {
            comboSearch.addItem(table.getColumnName(i));
        }

        textSearch.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                tableModel.setFilter(textSearch.getText(), comboSearch.getSelectedIndex());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                tableModel.setFilter(textSearch.getText(), comboSearch.getSelectedIndex());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                tableModel.setFilter(textSearch.getText(), comboSearch.getSelectedIndex());
            }
        });

        table.setRowHeight(36);
        table.setRowSorter(tableModel.getSorter());

        new swingx.component.table.renderer.TableColumnSizeRenderer().setRenderSizeColumn(table, JTable.AUTO_RESIZE_OFF);

        table.getColumnModel().getColumn(0).setCellRenderer(new TableCellColorAlignmentRenderer(JLabel.CENTER));
        table.getColumnModel().getColumn(1).setCellRenderer(new TableCellColorRenderer());
        table.getColumnModel().getColumn(2).setCellRenderer(new TableCellColorRenderer());
        table.getColumnModel().getColumn(3).setCellRenderer(new TableCellColorAlignmentRenderer(JLabel.CENTER));
        table.getColumnModel().getColumn(4).setCellRenderer(new TableCellColorAlignmentRenderer(JLabel.CENTER));

        table.getColumnModel().getColumn(5).setCellRenderer(new ButtonsRenderer());
        table.getColumnModel().getColumn(5).setCellEditor(new ButtonsEditor(table, tableModel));
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
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
        iTable1 = new lcm.component.ITable();
        jLabel1 = new javax.swing.JLabel();
        iPanelGlass2 = new lcm.component.IPanelGlass();
        jButton1 = new javax.swing.JButton();

        iTable1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA USER");

        javax.swing.GroupLayout iPanelGlass1Layout = new javax.swing.GroupLayout(iPanelGlass1);
        iPanelGlass1.setLayout(iPanelGlass1Layout);
        iPanelGlass1Layout.setHorizontalGroup(
            iPanelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iPanelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addComponent(iTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 594, Short.MAX_VALUE)
        );
        iPanelGlass1Layout.setVerticalGroup(
            iPanelGlass1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iPanelGlass1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );

        jButton1.setText("Kembali");
        jButton1.setPreferredSize(new java.awt.Dimension(85, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        iPanelGlass2.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(iPanelGlass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iPanelGlass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iPanelGlass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iPanelGlass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frameMain.showPanelIdentity();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private lcm.component.IPanelGlass iPanelGlass1;
    private lcm.component.IPanelGlass iPanelGlass2;
    private lcm.component.ITable iTable1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

class ButtonsPanel extends JPanel {

    public final List<JButton> buttons = Arrays.asList(new JButton("Cetak"), new JButton("Hapus"));

    public ButtonsPanel() {
        super();
        setOpaque(true);
        for (JButton b : buttons) {
            b.setFocusable(false);
            b.setRolloverEnabled(false);
            add(b);
        }
    }
//     @Override public void updateUI() {
//         super.updateUI();
//     }
}

class ButtonsRenderer extends ButtonsPanel implements TableCellRenderer {

    public ButtonsRenderer() {
        super();
        setName("Table.cellRenderer");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
        return this;
    }
}

class ViewAction extends AbstractAction {

    private final JTable table;
    private final TableModelUser tableModel;

    public ViewAction(JTable table, TableModelUser tableModel) {
        super("Cetak");
        this.table = table;
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int row = table.convertRowIndexToModel(table.getSelectedRow());
            User user = tableModel.get(row);

            List<User> list = new ArrayList<>();
            list.add(user);

            JRBeanCollectionDataSource dt = new JRBeanCollectionDataSource(list);
            HashMap map = new HashMap();
            map.put("parameter1", user.getParameter1());
            map.put("parameter2", user.getParameter2());
            map.put("parameter3", user.getParameter3());
            map.put("parameter4", user.getParameter4());
            map.put("parameter5", user.getMethod());
            map.put("parameter6", user.getTime());
            UtilityPrint.printReport(dt, "report1", map);
        } catch (Exception ex) {
        }

    }
}

class EditAction extends AbstractAction {

    private final JTable table;
    private final TableModelUser tableModel;

    public EditAction(JTable table, TableModelUser tableModel) {
        super("Hapus");
        this.table = table;
        this.tableModel = tableModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int row = table.convertRowIndexToModel(table.getSelectedRow());
            User user = tableModel.get(row);
            System.out.println(user.getId());
            new File("./result/" +user.getId()+".xml").delete();
            tableModel.remove(row);
        } catch (Exception ex) {
        }
    }
}

class ButtonsEditor extends ButtonsPanel implements TableCellEditor {

    protected transient ChangeEvent changeEvent;
    private final JTable table;
    private final TableModelUser tableModel;

    private class EditingStopHandler extends MouseAdapter implements ActionListener {

        @Override
        public void mousePressed(MouseEvent e) {
            Object o = e.getSource();
            if (o instanceof TableCellEditor) {
                actionPerformed(null);
            } else if (o instanceof JButton) {
                //DEBUG: view button click -> control key down + edit button(same cell) press -> remain selection color
                ButtonModel m = ((JButton) e.getComponent()).getModel();
                if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                    setBackground(table.getBackground());
                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    fireEditingStopped();
                }
            });
        }
    }

    public ButtonsEditor(JTable table, TableModelUser tableModel) {
        super();
        this.table = table;
        this.tableModel = tableModel;
        buttons.get(0).setAction(new ViewAction(table, tableModel));
        buttons.get(1).setAction(new EditAction(table, tableModel));

        EditingStopHandler handler = new EditingStopHandler();
        for (JButton b : buttons) {
            b.addMouseListener(handler);
            b.addActionListener(handler);
        }
        addMouseListener(handler);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.setBackground(table.getSelectionBackground());
        return this;
    }

    @Override
    public Object getCellEditorValue() {
        return "";
    }

    //Copied from AbstractCellEditor
    //protected EventListenerList listenerList = new EventListenerList();
    //protected transient ChangeEvent changeEvent;
    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        fireEditingStopped();
        return true;
    }

    @Override
    public void cancelCellEditing() {
        fireEditingCanceled();
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
        listenerList.add(CellEditorListener.class, l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
        listenerList.remove(CellEditorListener.class, l);
    }

    public CellEditorListener[] getCellEditorListeners() {
        return listenerList.getListeners(CellEditorListener.class);
    }

    protected void fireEditingStopped() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                // Lazily create the event:
                if (changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listeners[i + 1]).editingStopped(changeEvent);
            }
        }
    }

    protected void fireEditingCanceled() {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == CellEditorListener.class) {
                // Lazily create the event:
                if (changeEvent == null) {
                    changeEvent = new ChangeEvent(this);
                }
                ((CellEditorListener) listeners[i + 1]).editingCanceled(changeEvent);
            }
        }
    }
}
