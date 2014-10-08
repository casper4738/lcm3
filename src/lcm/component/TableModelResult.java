/*
 *  Author : fa
 *  Email  : casperadam91@gmail.com
 *  Blog   : fandy-alfa.blogspot.com
 *  IDE    : netbeans 7.2.x
 *  NOTEOOK ACER ASPIRE 4738
 */
package lcm.component;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import lcm.Plate;

/**
 *
 * @author fa
 */
public class TableModelResult extends AbstractTableModel {

    private List<Plate> list = new ArrayList<>();

    public TableModelResult() {
    }

    public void setList(List<Plate> list) {
        this.list = list;
    }

    public boolean add(Plate e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Plate update(int index, Plate e) {
        try {
            return list.set(index, e);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Plate remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
    }

    public Plate get(int index) {
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
                return rowIndex+1;
            case 1:
                return list.get(list.get(rowIndex).getPlate()).getType().toUpperCase();
            case 2:
                return (list.get(rowIndex).getAnswer()+"").toUpperCase();
            case 3:
                return list.get(rowIndex).getCorrect();
            case 4:
                return list.get(rowIndex).getWeak();
            case 5:
                return list.get(rowIndex).getResult();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "PLATE";
            case 1:
                return "TIPE";
            case 2:
                return "JAWAB";
            case 3:
                return "JWB. BENAR";
            case 4:
                return "JWB. LAIN";
            case 5:
                return "HASIL";
            default:
                return null;
        }
    }

}
