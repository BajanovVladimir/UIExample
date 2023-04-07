package forms.main_form;

import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

    @Override
    public int getRowCount() {
        return 10;
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }
}
