package util;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

public class EditorNumero extends JTextField implements TableCellEditor{
    
private ArrayList<CellEditorListener> suscriptores = new ArrayList<CellEditorListener>();

/*************************************CONSTRUCTOR POR DEFECTO******************************/
CellEditorListener aux;
public EditorNumero(){
    System.out.println("entro a editor numero");

//Nos apuntamos a la pérdida de foco, que quiere decir que se ha
// dejado de editar la celda.
    this.addFocusListener(new FocusListener(){
        @Override
        public void focusGained (FocusEvent e){
//        setText("");
        }
        @Override
        public void focusLost (FocusEvent e){
            editado(true);
        }
    });

    //Nos apuntamos a un escuchador de tecla, para detectar si lo
    //digitado es correcto. En nuestro caso es correcto si es número.
    this.addKeyListener(new KeyAdapter(){
        @Override
        public void keyTyped(KeyEvent arg0){
            System.out.println("entro a keytyped");
            char caracter = arg0.getKeyChar();
            if(((caracter < '0') || (caracter > '9')) && (caracter != KeyEvent.VK_BACK_SPACE))
            arg0.consume(); // ignorar el evento de teclado
        }
    });
}

/*******************************METODOS PARA MANEJO DE SUSCRIPTORES************************/
    @Override
    public void addCellEditorListener(CellEditorListener l){
        System.out.println("entro a cell editor");
        suscriptores.add(l);
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l){
        System.out.println("entro a remove cell");
        suscriptores.remove(l);
    }

    /*******************************METODOS PARA CANCELAR Y TERMINAR EDICION************************/

    /**Le dice al editor que cancele la edición y
    * no aceptar ningún valor editado parcialmente*/
    @Override
    public void cancelCellEditing(){
    }

    /**Le dice al editor para detener la edición y aceptar cualquier valor
    * parcialmente editado como el valor del editor. El editor retorna
    * falso si la edición no se detuvo, lo que es útil para los editores
    * que validen y no puede aceptar entradas inválidas.
    *
    * @ return true si la edición fue detenida, false en caso contrario*/
    @Override
    public boolean stopCellEditing(){
    //indica si se puede detener la edición
        System.out.println("entro a stop cell");
        return true;
    }

    /*******************************OTROS METODOS DE EDICION************************/

    /**Retorna el valor contenido en el editor*/
    public Object getCellEditorValue(){
        
        return Short.parseShort(this.getText());
    }

    /**Retorna el componente utilizado como editor*/
    public Component getTableCellEditorComponent(JTable t, Object value,
    boolean isSelected, int fila, int columna){
        if(isSelected)
            this.setBackground(Color.YELLOW);
        else
            this.setBackground(Color.WHITE);
        return this;
    }


    public boolean isCellEditable(EventObject e){
    //la celda es editable ante cualquier evento
        System.out.println("entro a is cell editable");
        return true;
    }

    public boolean shouldSelectCell(EventObject arg0){
    //indica si al editar la celda, debemos seleccionar
    //la fila que la contiene
        System.out.println("entro a should select");
        return true;
    }

    /*******************************MIS METODOS DE EDICION************************/
    /**
    * Si cambiado es true, se avisa a los suscriptores de que se ha terminado
    * la edición. Si es false, se avisa de que se ha cancelado la edición.
    */
    protected void editado(boolean cambiado){
        System.out.println("entro a editado");
        ChangeEvent evento = new ChangeEvent (this);
        int i;
        for (i=0; i<suscriptores.size(); i++){
            aux = (CellEditorListener)suscriptores.get(i);
            if ((cambiado==true)&&(this.getText().isEmpty()==false)){
                aux.editingStopped(evento);
            }else{
                aux.editingCanceled(evento);
            }
        }
    }

}