package swing.stringconverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameDemo implements ActionListener {

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

    public FrameDemo() {

        frame = initFrame("Text Converter");

        pane = initPane(new Dimension(760, 530));

        addLabel("Input", new Rectangle(10, 10, 50, 20));
        addLabel("Output", new Rectangle(400, 10, 50, 20));

        inputTextArea = addLabeledTextArea("Input", new Rectangle(10, 35, 350, 400));
        outputTextArea = addLabeledTextArea("Output", new Rectangle(400, 35, 350, 400));

        /*button = new JButton("Convert");
        button.setBounds(340, 460, 80, 30);
        pane.add(button);
        button.addActionListener(this);*/

        bgroup = new ButtonGroup();

        radioUpperCase = addRadio("To upper case", new Rectangle(10, 450, 120, 20));
        radioLowerCase = addRadio("To lower case", new Rectangle(10, 470, 120, 20));
        radioCapitalize = addRadio("Capitalize every word", new Rectangle(10, 490, 150, 20));
        radioKeyboardSwitch = addRadio("Keyboard switch: EN to RU", new Rectangle(180, 450, 180, 20));
        radioKeyboardSwitch = addRadio("Keyboard switch: RU to EN", new Rectangle(180, 470, 180, 20));

        frame.pack(); // required with pane.setPreferredSize()
        frame.setVisible(true);
    }

    private Container initPane(Dimension dimension) {
        Container pane = frame.getContentPane();
        pane.setPreferredSize(dimension);
        return pane;
    }

    private JFrame initFrame(String name) {
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        return frame;
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
            case "Keyboard switch: EN to RU":
                output = StringConverter.KeyboardSwitchENRU(input);
                break;
            case "Keyboard switch: RU to EN":
                output = StringConverter.KeyboardSwitchRUEN(input);
                break;
        }

        outputTextArea.setText(output);
    }

}