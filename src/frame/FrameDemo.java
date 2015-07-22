package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrameDemo implements ActionListener {

    private JLabel inputLabel;
    private JLabel outputLabel;

    private JTextArea inputTextArea;
    private JTextArea outputTextArea;

    private JButton button;

    private JRadioButton radio1;
    private JRadioButton radio2;
    private JRadioButton radio3;

    private  ButtonGroup bgroup;

    public FrameDemo() {

        JFrame frame = new JFrame("Text Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        Container pane = frame.getContentPane();
        pane.setPreferredSize(new Dimension(760, 530));

        inputLabel = new JLabel("Input");
        inputLabel.setBounds(10, 10, 50, 20);
        pane.add(inputLabel);

        outputLabel = new JLabel("Output");
        outputLabel.setBounds(400, 10, 50, 20);
        pane.add(outputLabel);

        inputTextArea = new JTextArea();
        inputTextArea.setLineWrap(true);
        JScrollPane inputScroll = new JScrollPane(inputTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        inputScroll.setBounds(10, 35, 350, 400);
        pane.add(inputScroll);

        outputTextArea = new JTextArea();
        outputTextArea.setLineWrap(true);
        JScrollPane outputScroll = new JScrollPane(outputTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        outputScroll.setBounds(400, 35, 350, 400);
        pane.add(outputScroll);

        /*button = new JButton("Convert");
        button.setBounds(340, 460, 80, 30);
        pane.add(button);
        button.addActionListener(this);*/

        radio1 = new JRadioButton("To upper case", false);
        radio1.setBounds(10, 450, 120, 20);
        pane.add(radio1);

        radio2 = new JRadioButton("To lower case", false);
        radio2.setBounds(10, 470, 120, 20);
        pane.add(radio2);

        radio3 = new JRadioButton("Capitalize every word", false);
        radio3.setBounds(10, 490, 150, 20);
        pane.add(radio3);

        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);

        bgroup = new ButtonGroup();
        bgroup.add(radio1);
        bgroup.add(radio2);
        bgroup.add(radio3);

        frame.pack(); // required with pane.setPreferredSize()
        frame.setVisible(true);
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
        }

       outputTextArea.setText(output);
    }

}