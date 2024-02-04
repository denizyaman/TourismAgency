package src.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;

public class Layout extends JFrame {
    public void GuiInitilaze (int width,int height){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Turizm Acente");
        this.setSize(width,height);
        this.setVisible(true);
    }
    public void createTable(DefaultTableModel model, JTable table, Object[] columns, ArrayList<Object[]> rows){
        model.setColumnIdentifiers(columns);
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.getColumnModel().getColumn(0).setMaxWidth(75); //ID satırı boyutu ayarlandı
        table.setEnabled(false);

        DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
        clearModel.setRowCount(0);

        if(rows==null){
            rows= new ArrayList<>();
        }
        for(Object[] row: rows){
            model.addRow(row);
        }
    }

    public int getTableSelectedRow(JTable table, int index){
        return Integer.parseInt(table.getValueAt(table.getSelectedRow(),index).toString());// secılen rowun ıdsını aldık
    }
}
