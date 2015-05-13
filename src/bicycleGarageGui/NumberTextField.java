package bicycleGarageGui;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class NumberTextField extends JTextField {

	private boolean intOnly = true;

	public NumberTextField() {
		super();
	}

	public NumberTextField(int columns) {
		super(columns);
	}

	public NumberTextField(String text) {
		super(text);
		if (getValue() == null) {
			setColumns(5);
		}
	}

	public NumberTextField(String text, int columns) {
		super(text, columns);
	}

	public void setIntOnly(boolean intOnly) {
		this.intOnly = intOnly;
	}

	public Number getValue() {
        try {
        	if (intOnly) {
        		return Long.valueOf(getText());
        	}
        	return Double.valueOf(getText());
    	} catch (NumberFormatException e) {
            return null;
        } catch (NullPointerException e) {
        	return null;
        }
    }

    @Override
	protected Document createDefaultModel() {
    	return new NumberTextDocument();
    }

    @Override
	public boolean isValid() {
    	try {   	 
    		if (intOnly) {
    			Long.parseLong(getText());
    		} else {
    			Double.parseDouble(getText());
    		}
    		return true;
    	} catch (NumberFormatException e) {
    	    return false;
    	} catch (NullPointerException e) {
    		return false;
    	}
    }

    class NumberTextDocument extends PlainDocument {   	

		@Override
		public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        	if (str == null) {
        		return;
        	}
        	String oldString = getText(0, getLength());
        	String newString = oldString.substring(0, offs) + str + oldString.substring(offs);
        	try {
        		if (intOnly) {
        			Long.parseLong(newString + "0");
        		} else {
        			Double.parseDouble(newString + "0");
        		}
        		super.insertString(offs, str, a);
        	} catch (NumberFormatException e) {
        	}
        }
    }
    
}