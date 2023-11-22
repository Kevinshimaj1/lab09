package it.unibo.mvc;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private static final String TITLE = "Simple gui";
    private final static JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 5;
    private final Controller controller = new SimpleController();

    public SimpleGUI(){
        final JPanel canvas = new JPanel();
        canvas.setLayout(new BorderLayout());
        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        canvas.add(textField,BorderLayout.NORTH);
        
        JTextArea textArea = new JTextArea();
        canvas.add(textArea,BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        canvas.add(bottomPanel,BorderLayout.SOUTH);

        JButton print = new JButton("Print");
        bottomPanel.add(print,BorderLayout.EAST);

        JButton showHistory = new JButton("Show History");
        bottomPanel.add(showHistory,BorderLayout.WEST);

        print.addActionListener(e -> {
            controller.setNextString(textField.getText());
            controller.printCurrentString();
        });

        showHistory.addActionListener(e->{
            List<String> history = controller.getPrintedStrings();
            history.forEach(element -> {
                textArea.append(element + "\n");
            });
        });
    }

    public void display(){
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
         new SimpleGUI().display();
    }
}
