package swing.frame.calculator.guidesigner;

import swing.frame.stringconverter.StringConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrame implements ActionListener {
    private JFrame frame;
    private JLabel inputLabel;
    private JLabel outputLabel;

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    //private JButton button;

    private JRadioButton radioUpperCase;
    private JRadioButton radioLowerCase;
    private JRadioButton radioCapitalize;
    private JRadioButton radioKeyboardSwitch;

    private ButtonGroup bgroup;

    private Container pane;

    public CalcFrame() {
        // ToDo remove border when radio is selected
        // ToDo JUnit

        frame = initFrame("Calculator");

        pane = initPane(new Dimension(400, 450));

        //addLabel("Input", new Rectangle(10, 10, 50, 20));
        //addLabel("Output", new Rectangle(400, 10, 50, 20));

        //inputTextArea = addLabeledTextArea("Input", new Rectangle(10, 35, 350, 400));
        //outputTextArea = addLabeledTextArea("Output", new Rectangle(400, 35, 350, 400));

        addButton("1");
        addButton("2");
        addButton("3");
        addButton("4");
        addButton("5");
        addButton("6");
        addButton("7");
        addButton("8");
        addButton("9");
        addButton("0");

        /*bgroup = new ButtonGroup();

        radioUpperCase = addRadio("To upper case", new Rectangle(10, 450, 120, 20));
        radioLowerCase = addRadio("To lower case", new Rectangle(10, 470, 120, 20));
        radioCapitalize = addRadio("Capitalize every word", new Rectangle(10, 490, 150, 20));
        radioKeyboardSwitch = addRadio("Keyboard switch: EN <=> RU", new Rectangle(180, 450, 190, 20));*/

        frame.pack(); // required with pane.setPreferredSize()
        frame.setVisible(true);
    }

    private void addButton(String name) {
        JButton button = new JButton(name);
        //button.setBounds(340, 460, 80, 30);
        //pane.set
        pane.add(button);
        button.addActionListener(this);
    }


    private JFrame initFrame(String name) {
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 3, 10, 10));
        return frame;
    }

    private Container initPane(Dimension dimension) {
        Container pane = frame.getContentPane();
        //frame.setContentPane(new MyForm());
        pane.setPreferredSize(dimension);
        return pane;
    }

    private void addLabel(String name, Rectangle position) {
        JLabel label = new JLabel(name);
        label.setBounds(position);
        pane.add(label);
    }

    private JTextArea addLabeledTextArea(String name, Rectangle position) {
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        JScrollPane inputScroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inputScroll.setBounds(position);
        pane.add(inputScroll);
        return textArea;
    }

    private JRadioButton addRadio(String name, Rectangle position) {
        JRadioButton radio = new JRadioButton(name, false);
        radio.setBounds(position);
        radio.addActionListener(this);
        pane.add(radio);
        bgroup.add(radio);
        return radio;
    }

    public void actionPerformed(ActionEvent e) {

        String input = inputTextArea.getText();
        String output = "";

        switch (e.getActionCommand()) {
            case "To upper case":
                output = StringConverter.toUpperCase(input);
                break;
            case "To lower case":
                output = StringConverter.toLowerCase(input);
                break;
            case "Capitalize every word":
                output = StringConverter.capitalizeWords(input);
                break;
            case "Keyboard switch: EN <=> RU":
                output = StringConverter.KeyboardSwitchENRU(input);
                break;
        }

        outputTextArea.setText(output);
    }
}