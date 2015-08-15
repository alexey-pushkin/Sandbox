package swing.frame.calculator.guidesigner;

import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MyFormTest {

    JButton a0Button;
    JButton a1Button;
    JButton a2Button;
    JButton a3Button;
    JButton a4Button;
    JButton a5Button;
    JButton a6Button;
    JButton a7Button;
    JButton a8Button;
    JButton a9Button;

    JButton addButton;
    JButton subtractButton;
    JButton multiplyButton;
    JButton divideButton;
    JButton resultButton;

    JButton dotButton;
    JButton cButton;
    JButton ceButton;
    JButton backspaceButton;

    JTextField resultField;

    @Before
    public void init() throws Exception {

        JFrame frame = MyForm.initFrame();

        assertNotNull(frame);

        a0Button = (JButton) getChildNamed(frame, "a0Button");
        a1Button = (JButton) getChildNamed(frame, "a1Button");
        a2Button = (JButton) getChildNamed(frame, "a2Button");
        a3Button = (JButton) getChildNamed(frame, "a3Button");
        a4Button = (JButton) getChildNamed(frame, "a4Button");
        a5Button = (JButton) getChildNamed(frame, "a5Button");
        a6Button = (JButton) getChildNamed(frame, "a6Button");
        a7Button = (JButton) getChildNamed(frame, "a7Button");
        a8Button = (JButton) getChildNamed(frame, "a8Button");
        a9Button = (JButton) getChildNamed(frame, "a9Button");

        addButton = (JButton) getChildNamed(frame, "addButton");
        subtractButton = (JButton) getChildNamed(frame, "subtractButton");
        multiplyButton = (JButton) getChildNamed(frame, "multiplyButton");
        divideButton = (JButton) getChildNamed(frame, "divideButton");
        resultButton = (JButton) getChildNamed(frame, "resultButton");

        dotButton = (JButton) getChildNamed(frame, "dotButton");
        cButton = (JButton) getChildNamed(frame, "cButton");
        ceButton = (JButton) getChildNamed(frame, "ceButton");
        backspaceButton = (JButton) getChildNamed(frame, "backspaceButton");

        resultField = (JTextField) getChildNamed(frame, "resultField");
    }

    @Test
    public void mess() {

        // +=
        c();
        add();
        res();
        assertEquals("", result());

        // +3=3
        c();
        add();
        a3();
        res();
        assertEquals("3", result());

        // -2=-2
        c();
        subtract();
        a2();
        res();
        assertEquals("-2", result());

    }

    @Test
    public void addition() {
        c();

        // 1+2=3
        a1Button.doClick();
        addButton.doClick();
        a2Button.doClick();
        resultButton.doClick();
        assertEquals("3", resultField.getText());

        // 23+11=34
        /*a2Button.doClick();
        a3Button.doClick();
        addButton.doClick();
        a1Button.doClick();
        a1Button.doClick();
        resultButton.doClick();
        assertEquals("34", resultField.getText());*/
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

    private void a0() {a0Button.doClick();}
    private void a1() {a1Button.doClick();}
    private void a2() {a2Button.doClick();}
    private void a3() {a3Button.doClick();}
    private void a4() {a4Button.doClick();}
    private void a5() {a5Button.doClick();}
    private void a6() {a6Button.doClick();}
    private void a7() {a7Button.doClick();}
    private void a8() {a8Button.doClick();}
    private void a9() {a9Button.doClick();}

    private void add() {addButton.doClick();}
    private void subtract() {subtractButton.doClick();}
    private void multiply() {multiplyButton.doClick();}
    private void divide() {divideButton.doClick();}
    private void res() {resultButton.doClick();}

    private void dot() {dotButton.doClick();}
    private void c() {cButton.doClick();}
    private void ce() {ceButton.doClick();}
    private void backspace() {backspaceButton.doClick();}

    private String result() { return resultField.getText();}
}
