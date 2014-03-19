package util;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class CellRenderer extends DefaultTableCellRenderer  {
    
    private JCheckBox check = new JCheckBox();  
    
    /** Constructor de clase*/
    public CellRenderer(){}        
    
    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {
        //color de celda seleccionada
        this.setBackground( (selected)? new Color( 50, 153 , 254):new Color(102,102,0) );             
        //
        if( column == 15)
        {
            Boolean bol = Boolean.valueOf(String.valueOf(value));
            if( value != null  )
            {   
//                check = new JCheckBox();                                
                check.setHorizontalAlignment( JLabel.CENTER );                
                check.setBackground( (selected)? new Color( 50, 153 , 254):new Color(255,255,255) );
                check.setSelected( bol ); //valor de celda                             
                return check;
            }
            else // es un boolean
            {             
                return null;
            }                     
        }
        
        return this;
    }    
     
}//--> fin clase
