import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUI extends JFrame implements ActionListener{
	public JTextArea textArea;
	private JPanel panel;
	private JLabel label;
	private JTextField textField;
	private JButton button;
	public GUI() {
		buildWindow();
	}
	public void actionPreformed(ActionEvent event) {
		JButton j= (JButton) event.getSource();
		String s = textField.getText();
		game.processCommand(s);	
	}
	private void buildWindow(){
		setTitle("Game");
		setLayout(new BorderLayout());
		textArea = new JTextArea();
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		label = new JLabel("What would you like to do?");
		textField = new JTextField();
		
		button = new JButton("Execute");
		button.addActionListener(this);
		
		panel.add(label);
		panel.add(textField);
		panel.add(button);
		JScrollPane pane = new JScrollPane(textArea);
		add(pane, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		setVisible(true);
	}	
}