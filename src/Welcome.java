import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Welcome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		setBackground(new Color(240, 240, 240));
		setTitle("WELCOME");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 474);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcome = new JLabel("WELCOME TO");
		welcome.setFont(new Font("Times New Roman", Font.BOLD, 30));
		welcome.setBounds(100, 11, 238, 113);
		contentPane.add(welcome);
		
		JButton order = new JButton("ORDER NOW!");
		order.setFocusable(false);
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == order) {
					MainMenu menu = new MainMenu();
					menu.setVisible(true);
					dispose();
				}
			}
		});
		order.setFont(new Font("Times New Roman", Font.BOLD, 25));
		order.setBounds(120, 368, 198, 62);
		contentPane.add(order);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("restaurant.png"));
		lblNewLabel.setBounds(22, 66, 443, 364);
		contentPane.add(lblNewLabel);
	}
}
