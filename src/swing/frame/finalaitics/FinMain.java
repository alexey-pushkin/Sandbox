package swing.frame.finalaitics;


public class FinMain {
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        // For thread safety
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FinForm frame = new FinForm();
            }
        });
    }
}