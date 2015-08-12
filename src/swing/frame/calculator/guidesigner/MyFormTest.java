package swing.frame.calculator.guidesigner;


import junit.framework.TestCase;

import javax.swing.*;
import java.awt.*;

public class MyFormTest extends TestCase {

    //static MyForm myForm;

    public void testTypeIn() throws Exception {

        JFrame frame = MyForm.initFrame();

        String testString = "message1";

        assertNotNull(frame);  // Instantiated?

        JTextField input = (JTextField) getChildNamed(frame, "resultField");
        assertNotNull(input); // Component found?

        input.setText(testString);
        input.postActionEvent();  // Type in a test message + ENTER

        assertEquals(testString, input.getText());
    }

    public static Component getChildNamed(Component parent, String name) {

        // Debug line
        //System.out.println("Class: " + parent.getClass() +
        //    " Name: " + parent.getName());

        if (name.equals(parent.getName())) {
            return parent;
        }

        if (parent instanceof Container) {
            Component[] children = ((Container) parent).getComponents();

            for (int i = 0; i < children.length; ++i) {
                Component child = getChildNamed(children[i], name);
                if (child != null) {
                    return child;
                }
            }
        }

        return null;
    }
}
