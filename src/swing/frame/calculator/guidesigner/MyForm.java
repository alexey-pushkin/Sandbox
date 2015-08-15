package swing.frame.calculator.guidesigner;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * Created by alpu1014 on 27.07.2015.
 */
public class MyForm {
    private JPanel panel1;
    private JTextField resultField;
    private JButton a7Button;
    private JButton a4Button;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a9Button;
    private JButton a6Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a0Button;
    private JButton commaButton;
    private JButton divideButton;
    private JButton multiplyButton;
    private JButton subtractButton;
    private JButton addButton;
    private JButton resultButton;
    private JButton backspaceButton;
    private JButton CEButton;
    private JButton cButton;
    private JButton squareRoot;

    private Calculator calculator;

    public MyForm() {
        calculator = new Calculator();

        a0Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("0");
            }
        });
        a1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("1");
            }
        });
        a2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("2");
            }
        });
        a3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("3");
            }
        });
        a4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("4");
            }
        });
        a5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("5");
            }
        });
        a6Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("6");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("7");
            }
        });
        a8Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("8");
            }
        });
        a9Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonClicked("9");
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculator.setOperation(Calculator.Operation.ADD);
            }
        });
        subtractButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculator.setOperation(Calculator.Operation.SUBTRACT);
            }
        });
        divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculator.setOperation(Calculator.Operation.DIVIDE);
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculator.setOperation(Calculator.Operation.MULTIPLY);
            }
        });

        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText(format(calculator.getResult()));
            }
        });


        CEButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculator.clearEntry();
                resultField.setText("");
            }
        });
        cButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculator.clearAll();
                resultField.setText("");
            }
        });
    }

    private void buttonClicked(String s) {
        resultField.setText(s);
        calculator.addValue(Double.valueOf(s));
    }

    private String format(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);

    }

   /* private static JFrame frame;

    public static JFrame getFrame() {
        return frame;
    }*/

    public static JFrame initFrame() {
        final JFrame frame = new JFrame("Calculator");
        frame.setResizable(false);
        try {
            Image image = ImageIO.read(MyForm.class.getResource("images/icon.png"));
            frame.setIconImage(image);
        } catch (IOException exc) {
            exc.printStackTrace();
        }

        frame.setLocation(700, 300);
        final MyForm form = new MyForm();
        frame.setContentPane(form.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        System.out.println("VK_ADD=" + KeyEvent.VK_ADD);
        System.out.println("VK_PLUS=" + KeyEvent.VK_PLUS);
        System.out.println("VK_EQUALS=" + KeyEvent.VK_EQUALS);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("e.getKeyChar()=" + e.getKeyChar() + " " + e.getKeyCode());
                switch (e.getKeyChar()) {
                    case KeyEvent.VK_0:
                        form.a0Button.doClick();
                        break;
                    case KeyEvent.VK_1:
                        form.a1Button.doClick();
                        break;
                    case KeyEvent.VK_2:
                        form.a2Button.doClick();
                        break;
                    case KeyEvent.VK_3:
                        form.a3Button.doClick();
                        break;
                    case KeyEvent.VK_4:
                        form.a4Button.doClick();
                        break;
                    case KeyEvent.VK_5:
                        form.a5Button.doClick();
                        break;
                    case KeyEvent.VK_6:
                        form.a6Button.doClick();
                        break;
                    case KeyEvent.VK_7:
                        form.a7Button.doClick();
                        break;
                    case KeyEvent.VK_8:
                        form.a8Button.doClick();
                        break;
                    case KeyEvent.VK_9:
                        form.a9Button.doClick();
                        break;

                    case KeyEvent.VK_BACK_SPACE:
                        form.backspaceButton.doClick();
                        System.out.println("VK_BACK_SPACE");
                        break;
                    case KeyEvent.VK_ENTER:
                        System.out.println("VK_ENTER");
                        form.resultButton.doClick();
                        break;
                    case KeyEvent.VK_ADD:
                        System.out.println("VK_ADD=" + KeyEvent.VK_ADD);
                        form.addButton.doClick();
                        break;
                    case KeyEvent.VK_MINUS:
                        System.out.println("VK_MINUS");
                        form.subtractButton.doClick();
                        break;
                    case KeyEvent.VK_MULTIPLY:
                        System.out.println("VK_MULTIPLY");
                        form.multiplyButton.doClick();
                        break;
                    case KeyEvent.VK_DIVIDE:
                        System.out.println("VK_DIVIDE");
                        form.divideButton.doClick();
                        break;


                    case KeyEvent.VK_PLUS:
                        System.out.println("VK_PLUS=" + KeyEvent.VK_PLUS);
                        form.addButton.doClick();
                        break;
                    case KeyEvent.VK_EQUALS:
                        System.out.println("VK_EQUALS=" + KeyEvent.VK_EQUALS);
                        form.addButton.doClick();
                        break;
                }
            }

            public void keyPressed(KeyEvent e) {
            }

            public void keyReleased(KeyEvent e) {
            }
        });

        return frame;
    }

    public static void main(String[] args) {
        initFrame();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(6, 4, new Insets(5, 5, 5, 5), -1, -1));
        resultField = new JTextField();
        resultField.setFocusable(false);
        resultField.setFont(new Font(resultField.getFont().getName(), resultField.getFont().getStyle(), 28));
        resultField.setHorizontalAlignment(4);
        resultField.setName("resultField");
        panel1.add(resultField, new GridConstraints(0, 0, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        a7Button = new JButton();
        a7Button.setFocusable(false);
        a7Button.setText("7");
        panel1.add(a7Button, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a4Button = new JButton();
        a4Button.setFocusable(false);
        a4Button.setText("4");
        panel1.add(a4Button, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a5Button = new JButton();
        a5Button.setFocusable(false);
        a5Button.setText("5");
        panel1.add(a5Button, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a6Button = new JButton();
        a6Button.setFocusable(false);
        a6Button.setText("6");
        panel1.add(a6Button, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a2Button = new JButton();
        a2Button.setFocusable(false);
        a2Button.setText("2");
        panel1.add(a2Button, new GridConstraints(4, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a3Button = new JButton();
        a3Button.setFocusable(false);
        a3Button.setText("3");
        panel1.add(a3Button, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a0Button = new JButton();
        a0Button.setFocusable(false);
        a0Button.setText("0");
        panel1.add(a0Button, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        commaButton = new JButton();
        commaButton.setFocusable(false);
        commaButton.setText(",");
        panel1.add(commaButton, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        multiplyButton = new JButton();
        multiplyButton.setFocusable(false);
        multiplyButton.setText("*");
        panel1.add(multiplyButton, new GridConstraints(3, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        subtractButton = new JButton();
        subtractButton.setFocusable(false);
        subtractButton.setText("-");
        panel1.add(subtractButton, new GridConstraints(4, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        addButton = new JButton();
        addButton.setFocusable(false);
        addButton.setText("+");
        panel1.add(addButton, new GridConstraints(5, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a1Button = new JButton();
        a1Button.setFocusable(false);
        a1Button.setName("");
        a1Button.setText("1");
        panel1.add(a1Button, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        resultButton = new JButton();
        resultButton.setFocusable(false);
        resultButton.setText("=");
        panel1.add(resultButton, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        backspaceButton = new JButton();
        backspaceButton.setFocusable(false);
        backspaceButton.setFont(new Font(backspaceButton.getFont().getName(), backspaceButton.getFont().getStyle(), backspaceButton.getFont().getSize()));
        backspaceButton.setText("←");
        panel1.add(backspaceButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a8Button = new JButton();
        a8Button.setFocusable(false);
        a8Button.setText("8");
        panel1.add(a8Button, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        a9Button = new JButton();
        a9Button.setFocusable(false);
        a9Button.setText("9");
        panel1.add(a9Button, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        divideButton = new JButton();
        divideButton.setFocusable(false);
        divideButton.setText("/");
        panel1.add(divideButton, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        CEButton = new JButton();
        CEButton.setFocusable(false);
        CEButton.setText("CE");
        panel1.add(CEButton, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        cButton = new JButton();
        cButton.setFocusable(false);
        cButton.setSelected(true);
        cButton.setText("C");
        panel1.add(cButton, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
        squareRoot = new JButton();
        squareRoot.setFocusable(false);
        squareRoot.setText("√");
        panel1.add(squareRoot, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, new Dimension(50, 30), new Dimension(50, 30), new Dimension(50, 30), 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
