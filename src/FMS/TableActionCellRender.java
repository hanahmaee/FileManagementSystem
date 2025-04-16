package FMS;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableActionCellRender extends JPanel implements TableCellRenderer {

    public TableActionCellRender() {
        // You can initialize default layout or components here if needed
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        
            PanelAction action = new PanelAction();
            return (Component) value;

    }
}
