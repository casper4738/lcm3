/*
 *  Author : fa
 *  Email  : casperadam91@gmail.com
 *  Blog   : fandy-alfa.blogspot.com
 *  IDE    : netbeans 7.2.x
 *  NOTEOOK ACER ASPIRE 4738
 */
package lcm.component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import lcm.User;

/**
 *
 * @author fa
 */
public class TableModelUser extends AbstractTableModel {

    private List<User> list = new ArrayList<>();
    private TableRowSorter<TableModelUser> sorter;

    public TableModelUser() {
        sorter = new TableRowSorter<>(this);
        sorter.setComparator(0, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId().compareTo(o2.getId());
            }
        });
    }

    public void setList(List<User> list) {
        this.list = list;
        sorter.setModel(this);
    }

    public User remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public User get(int index) {
        return list.get(index);
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getName();
            case 2:
                return list.get(rowIndex).getAge();
            case 3:
                return list.get(rowIndex).getJobs();
            case 4:
                return list.get(rowIndex).getMethod();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NAMA";
            case 2:
                return "USIA";
            case 3:
                return "PEKERJAAN";
            case 4:
                return "PENGACAKAN";
            default:
                return null;
        }
    }

    public void setFilter(String key, int column) {
        this.sorter.setRowFilter(RowFilter.regexFilter("(?i)" + key.trim(), column));
    }

    public TableRowSorter<TableModelUser> getSorter() {
        return sorter;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 5;
    }

}
