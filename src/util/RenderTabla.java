package util;


import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class RenderTabla extends JCheckBox implements TableCellRenderer
{
   
 /**
     * Constructor por defecto.
     */
    public RenderTabla(){
        setHorizontalAlignment(JLabel.CENTER);        
    }
//    @Override
//    public Component getTableCellRendererComponent(JTable table, Object value,boolean isSelected, boolean hasFocus, int row, int column){
//            if (isSelected) {
//              setForeground(table.getSelectionForeground());
//              //super.setBackground(table.getSelectionBackground());
//              setBackground(table.getSelectionBackground());
//              
//            } else {
//              setForeground(table.getForeground());
//              setBackground(table.getBackground());
//            }
//           if( column == 14)
//        {
//            Boolean bol = Boolean.valueOf(String.valueOf(value));
//            if( value == null  )
//            {             
//                return null;
//            }
//            else // es un boolean
//            {   
//                JCheckBox check = new JCheckBox();                                
//                check.setHorizontalAlignment( JLabel.CENTER );                
//                check.setBackground( (isSelected)? new Color( 50, 153 , 254):new Color(255,255,255) );
//                check.setSelected( bol ); //valor de celda                             
//                return check;
//            }                     
//        }
//        
//        return this;
//                
//    }
    /**
* Just returns the value to assign to the cell at [row, column] cast to a Component - this allows us of JXTable values etc.
*/
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return (Component)value;
    }
}