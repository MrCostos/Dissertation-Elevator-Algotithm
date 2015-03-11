import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame
                  implements ActionListener {
    
            
        String[] timeText = {"1 hour", "2 hours","3 hours","4 hours","5 hours","6 hours","7 hours","8 hours","9 hours","10 hour","11 hours","12 hour"
                ,"13 hours", "14 hours","15 hours","16 hours","17 hours","18 hours","19 hours","20 hours","21 hours","22 hours","23 hours","24 hours"};
    
        JButton SimulateButton = new JButton("Run Simulation");
        JButton quitButton = new JButton("Exit");
        
        JTextField NumberOfFloorsTextField = new JTextField ();
        JTextField NumberOfElevatorsTextField = new JTextField ();
        JTextField AmountOfPeopleField = new JTextField ();
        JComboBox timeField = new JComboBox (timeText);
        JTextField distanceField = new JTextField ();
        JTextArea infoArea = new JTextArea(12,50);

    public static void main(String[] args) {
        new GUI();
    }
    
    public GUI() {
        setLayout(new BorderLayout());
        setSize(450, 100);
        setTitle("Video Player");

        // close application only by clicking the quit button
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        top.add(new JLabel("Select an option by clicking one of the buttons below"));
        add("North", top);

        JPanel bottom = new JPanel();
        bottom.add(SimulateButton); SimulateButton.addActionListener(this);
        bottom.add(quitButton); quitButton.addActionListener(this);
        bottom.add(infoArea); 
        add("South", bottom);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Action performed!");
    }
}