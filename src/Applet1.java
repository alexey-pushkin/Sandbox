import javax.swing.*;

public class Applet1 extends JApplet {
    public void init() {
        getContentPane().add(new JLabel("Applet1!"));
    }

    @Override
    protected String paramString() {
        return super.paramString();
    }
}

