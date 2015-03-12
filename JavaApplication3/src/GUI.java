import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Constructor;
import javax.swing.*;

public class GUI extends JFrame
                  implements ActionListener {
    
            
        String[] timeText = {"1 hour", "2 hours","3 hours","4 hours","5 hours","6 hours","7 hours","8 hours","9 hours","10 hour","11 hours","12 hour"
                ,"13 hours", "14 hours","15 hours","16 hours","17 hours","18 hours","19 hours","20 hours","21 hours","22 hours","23 hours","24 hours"};
    
        JButton SimulateButton = new JButton("Run Simulation");
        JButton quitButton = new JButton("Exit");
        
        JTextField NumberOfFloorsTextField = new JTextField (5);
        JTextField NumberOfElevatorsTextField = new JTextField (5);
        JTextField AmountOfPeopleField = new JTextField (5);
        JComboBox timeField = new JComboBox (timeText);
        JTextField distanceField = new JTextField (5);
        JTextArea infoArea = new JTextArea(25,25);

        //testing
        int[] valuesSim = new int [5];
        
        String EndStats;
        
    public void setEndStats (String stats){
        this.EndStats = stats;
    }
    
    public String getEndStats(){
        return EndStats;
    }
    information info = new information ();
    public static void main(String[] args) {
    
        
        new GUI();
    }
    
    public GUI() {
        setLayout(new BorderLayout());
        setSize(1000, 500);
        setTitle("Elevator Simulator");

        // close application only by clicking the quit button
        //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel top = new JPanel();
        top.add(new JLabel("Pleae enter all the data"));
        add("North", top);

        JPanel bottom = new JPanel();
        JLabel NumberOfFloorsLabel = new JLabel ("Floors");
        bottom.add(NumberOfFloorsLabel);
        bottom.add(NumberOfFloorsTextField); 
        JLabel NumberOfElevatorsLabel = new JLabel ("Elevators");
        bottom.add(NumberOfElevatorsLabel);
        bottom.add(NumberOfElevatorsTextField); 
        JLabel NumberOfPeoplesLabel = new JLabel ("People");
        bottom.add(NumberOfPeoplesLabel);
        bottom.add(AmountOfPeopleField); 
        JLabel NumberOfTimesLabel = new JLabel ("Time in hours");
        bottom.add(NumberOfTimesLabel);
        bottom.add(timeField);
        JLabel NumberODissLabel = new JLabel ("Distance between floors (m)");
        bottom.add(NumberODissLabel);
        bottom.add(distanceField); 
        
        bottom.add(SimulateButton); SimulateButton.addActionListener(this);
        bottom.add(quitButton); quitButton.addActionListener(this);
        bottom.add(infoArea); 
        add("South", bottom);

        setResizable(true);
        setVisible(true);
    }

    //time conversion from hours to seconds
    private int TimeConversion(int Hours){
        int time = (Hours +1) *60*60;
        return time;
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SimulateButton) {
	
            int time = TimeConversion(timeField.getSelectedIndex());
        
                //will be used for different scenrios
                int peopleTraffic = 1;
                		
		Simulation simulation = new Simulation(Integer.parseInt(NumberOfFloorsTextField.getText()),Integer.parseInt(NumberOfElevatorsTextField.getText()),time, Integer.parseInt(AmountOfPeopleField.getText()), peopleTraffic, Integer.parseInt(distanceField.getText()));
                
                //using to test poisson distribution
                //simulation.peopleToUseElevator();
                
                //using to test kinematics Equation
                //System.out.println("This is how long the lift will take" + simulation.calcTime(floorDistscanner));
                
                //If the line below is commented it will be for tetsing purposes
		simulation.simulate();
                AppendText();
            
        }        
    }
    
    public void AppendText(){
       // infoArea.setText("hello");
        System.out.println("" + info.getFinalStats());
        
        
    }
}
