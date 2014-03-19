/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Leo
 */
import javax.swing.text.*;
import java.awt.event.*;

public class StringOnlyDigitField extends PlainDocument{



    @Override
    public void insertString(int arg0, String arg1, AttributeSet arg2) throws     BadLocationException{

	 if(esCifra(arg1))
	     super.insertString(arg0, arg1, arg2);

	 }

	 public boolean esCifra(String text){
	     char caracter = text.charAt(0);
	     if(((caracter < '0') || (caracter > '9')) && caracter!=KeyEvent.VK_BACK_SPACE){
                  return false;
          }

			 else
			    return true;

	 }

}
