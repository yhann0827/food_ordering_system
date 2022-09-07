import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTabbedPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JSlider;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private JTextField txt_sub;
	private JTextField txt_total;
	private JTextField txt_burger;
	private JTextField txt_pizza;
	private JTextField txt_spaghetti;
	private JTextField txt_salad;
	private JTextField txt_fr;
	private JTextField txt_cc;
	private JTextField txt_wj;
	private JTextField txt_aj;
	private JTextField txt_latte;
	private JTextField txt_hc;
	
	DefaultTableModel dtm;

	Double[] pricefood = new Double[6];
	Double[] pricedrink = new Double [4];
	double finalprice = 0;
	double f1, f2, f3, f4, f5, f6, f7, f8, f9;
	double d1, d2, d3, d4;
	int q1, q2, q3, q4, q5, q6;
	int p1, p2, p3, p4;
	private double totalprice = 0;
	
	private JLabel[] foodLabel = new JLabel[6]; 
	private JLabel[] foodImage = new JLabel[6];
	private JLabel[] foodPrice = new JLabel[6];
	
	private JLabel[] drinkLabel = new JLabel[4];
	private JLabel[] drinkImage = new JLabel[4];
	private JLabel[] drinkPrice = new JLabel[6];
	
	double food1, food2, food3, food4, food5, food6;
	double drink1, drink2, drink3, drink4;
	
	double totalfood;
	double totaldrink;

	DecimalFormat fp = new DecimalFormat(".00");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setTitle("MAIN MENU");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 840);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel cus_panel = new JPanel();
		cus_panel.setLayout(null);
		cus_panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		cus_panel.setBackground(Color.WHITE);
		cus_panel.setBounds(0, 0, 576, 141);
		contentPane.add(cus_panel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(99, 87, 124, -33);
		cus_panel.add(scrollPane_1);
		
		JLabel customerInfo = new JLabel("Customer's Information: ");
		customerInfo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		customerInfo.setBounds(10, 11, 213, 26);
		cus_panel.add(customerInfo);
		
		JLabel takeaway = new JLabel("Take Away / Dine in:  ");
		takeaway.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		takeaway.setBounds(10, 53, 148, 23);
		cus_panel.add(takeaway);
		
		JLabel method = new JLabel("Method of Payment: ");
		method.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		method.setBounds(10, 97, 148, 20);
		cus_panel.add(method);
		
		JRadioButton rb_takeaway = new JRadioButton("Take Away");
		rb_takeaway.setBackground(Color.WHITE);
		rb_takeaway.setFocusable(false);
		rb_takeaway.setBounds(146, 53, 109, 23);
		cus_panel.add(rb_takeaway);
		
		JRadioButton rb_dinein = new JRadioButton("Dine in");
		rb_dinein.setBackground(Color.WHITE);
		rb_dinein.setFocusable(false);
		rb_dinein.setBounds(282, 54, 109, 23);
		cus_panel.add(rb_dinein);
		
		ButtonGroup group1 = new ButtonGroup(); 
		group1.add(rb_takeaway);
		group1.add(rb_dinein);

		JRadioButton rb_cash = new JRadioButton("Cash");
		rb_cash.setBackground(Color.WHITE);
		rb_cash.setFocusable(false);
		rb_cash.setBounds(146, 97, 109, 23);
		cus_panel.add(rb_cash);
		
		JRadioButton rb_card = new JRadioButton("Card");
		rb_card.setBackground(Color.WHITE);
		rb_card.setFocusable(false);
		rb_card.setBounds(282, 97, 109, 23);
		cus_panel.add(rb_card);
		
		ButtonGroup group2 = new ButtonGroup(); 
		group2.add(rb_cash);
		group2.add(rb_card);
		
		JLabel foodOrdered = new JLabel("MyOrder");
		foodOrdered.setVerticalAlignment(SwingConstants.TOP);
		foodOrdered.setFont(new Font("Times New Roman", Font.BOLD, 22));
		foodOrdered.setBackground(Color.WHITE);
		foodOrdered.setBounds(709, 171, 99, 31);
		contentPane.add(foodOrdered);
		
		table = new JTable();
		dtm = new DefaultTableModel(0, 0);
		String header[] = new String[] {"Item", "Quantity", "Price"};
		dtm.setColumnIdentifiers(header);
		dtm.addRow(header);
		table = new JTable();
		table.setModel(dtm);
		table.setBounds(599, 212, 352, 385);
		table.setSize(352, 409);
		table.getColumnModel().getColumn(0).setPreferredWidth(129);
		table.getColumnModel().getColumn(1).setPreferredWidth(129);
		table.getColumnModel().getColumn(2).setPreferredWidth(129);
		table.setShowGrid(false);
		table.setFont(UIManager.getFont("Menu.font"));
		this.getContentPane().add(table);
		
		JLabel Subtotal = new JLabel("Subtotal         :");
		Subtotal.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		Subtotal.setBackground(new Color(255, 245, 238));
		Subtotal.setBounds(590, 628, 133, 23);
		contentPane.add(Subtotal);
		txt_sub = new JTextField();
		txt_sub.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt_sub.setColumns(10);
		txt_sub.setBounds(786, 628, 108, 23);
		contentPane.add(txt_sub);
		
		JLabel tax = new JLabel("Service Tax   : ");
		tax.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tax.setBounds(590, 662, 133, 31);
		contentPane.add(tax);
		JLabel tax_percent = new JLabel("10%");
		tax_percent.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		tax_percent.setBounds(784, 664, 49, 23);
		contentPane.add(tax_percent);
		
		JLabel total = new JLabel("Total              : ");
		total.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		total.setBounds(589, 704, 123, 23);
		contentPane.add(total);
		txt_total = new JTextField();
		txt_total.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txt_total.setColumns(10);
		txt_total.setBounds(786, 707, 108, 20);
		contentPane.add(txt_total);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 143, 576, 658);
		contentPane.add(tabbedPane);
		
		JPanel food_panel = new JPanel();
		food_panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Food", null, food_panel, null);
		tabbedPane.setBackgroundAt(0, Color.WHITE);
		food_panel.setLayout(null);
		
		foodImage[0]= new JLabel("");
		foodImage[0].setIcon(new ImageIcon("burger.jpg"));
		foodImage[0].setBounds(28, 52, 126, 107);
		foodImage[1]= new JLabel("");
		foodImage[1].setIcon(new ImageIcon("pizza.jpg"));
		foodImage[1].setBounds(298, 73, 107, 89);
		foodImage[2]= new JLabel("");
		foodImage[2].setIcon(new ImageIcon("spaghetti.jpg"));
		foodImage[2].setBounds(28, 245, 100, 89);
		foodImage[3]= new JLabel("");
		foodImage[3].setIcon(new ImageIcon("salad.jpg"));
		foodImage[3].setBounds(274, 256, 150, 89);
		foodImage[4]= new JLabel("");
		foodImage[4].setIcon(new ImageIcon("friedrice.jpg"));
		foodImage[4].setBounds(28, 439, 114, 89);
		foodImage[5]= new JLabel("");
		foodImage[5].setIcon(new ImageIcon("chickenchop.jpg"));
		foodImage[5].setBounds(298, 439, 120, 74);

		foodLabel[0] = new JLabel("Burger");
		foodLabel[0].setBounds(48, 155, 82, 43);
		foodLabel[1] = new JLabel("Pizza");
		foodLabel[1].setBounds(308, 165, 51, 23);
		foodLabel[2] = new JLabel("Spaghetti");
		foodLabel[2].setBounds(38, 349, 73, 34);
		foodLabel[3] = new JLabel("Salad");
		foodLabel[3].setBounds(312, 362, 46, 30);
		foodLabel[4] = new JLabel("Fried Rice");
		foodLabel[4].setBounds(38, 530, 83, 30);
		foodLabel[5] = new JLabel("Chicken Chop");
		foodLabel[5].setBounds(300, 520, 111, 30);
	
		foodPrice[0] = new JLabel("RM6.00");
		foodPrice[0].setBounds(150, 161, 73, 30);
		foodPrice[1] = new JLabel("RM10.50");
		foodPrice[1].setBounds(396, 165, 83, 23);
		foodPrice[2] = new JLabel("RM8.00");
		foodPrice[2].setBounds(142, 351, 60, 30);
		foodPrice[3] = new JLabel("RM7.50");
		foodPrice[3].setBounds(417, 367, 62, 21);
		foodPrice[4] = new JLabel("RM8.00");
		foodPrice[4].setBounds(149, 530, 73, 30);
		foodPrice[5] = new JLabel("RM14.50");
		foodPrice[5].setBounds(417, 525, 71, 23);

		f1= 6.00;
		f2= 10.50;
		f3= 8.00;
		f4= 7.50;
		f5= 8.00;
	    f6= 14.50;
		
		for(int i = 0; i<6; i++) {
			food_panel.add(foodImage[i]);
			foodLabel[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
			food_panel.add(foodLabel[i]);
			foodPrice[i].setFont(new Font("Times New Roman", Font.PLAIN, 18));
			food_panel.add(foodPrice[i]);
		}	
		
		JLabel quan_burger = new JLabel("Quantity: ");
		quan_burger.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_burger.setBounds(156, 89, 54, 26);
		food_panel.add(quan_burger);
		
		JLabel quan_pizza = new JLabel("Quantity: ");
		quan_pizza.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_pizza.setBounds(418, 89, 54, 26);
		food_panel.add(quan_pizza);
		
		JLabel quan_spaghetti = new JLabel("Quantity: ");
		quan_spaghetti.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_spaghetti.setBounds(132, 267, 54, 14);
		food_panel.add(quan_spaghetti);
		
		JLabel quan_salad = new JLabel("Quantity: ");
		quan_salad.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_salad.setBounds(434, 287, 54, 14);
		food_panel.add(quan_salad);
		
		JLabel quan_fr = new JLabel("Quantity: ");
		quan_fr.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_fr.setBounds(145, 457, 54, 26);
		food_panel.add(quan_fr);
		
		JLabel quan_cc = new JLabel("Quantity: ");
		quan_cc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_cc.setBounds(418, 463, 54, 14);
		food_panel.add(quan_cc);
		
		txt_burger = new JTextField();
		txt_burger.setText("");
		txt_burger.setColumns(10);
		txt_burger.setBounds(206, 92, 54, 20);
		food_panel.add(txt_burger);
		
		txt_pizza = new JTextField();
		txt_pizza.setText("");
		txt_pizza.setColumns(10);
		txt_pizza.setBounds(471, 92, 54, 20);
		food_panel.add(txt_pizza);
		
		txt_spaghetti = new JTextField();
		txt_spaghetti.setText("");
		txt_spaghetti.setColumns(10);
		txt_spaghetti.setBounds(177, 264, 54, 20);
		food_panel.add(txt_spaghetti);
		
		txt_salad = new JTextField();
		txt_salad.setText("");
		txt_salad.setColumns(10);
		txt_salad.setBounds(482, 284, 54, 20);
		food_panel.add(txt_salad);
		
		txt_fr = new JTextField();
		txt_fr.setText("");
		txt_fr.setColumns(10);
		txt_fr.setBounds(193, 460, 54, 20);
		food_panel.add(txt_fr);
		
		txt_cc = new JTextField();
		txt_cc.setText("");
		txt_cc.setColumns(10);
		txt_cc.setBounds(471, 460, 54, 20);
		food_panel.add(txt_cc);
		
		JButton burgerbutton = new JButton("Add to MyOrder");
		burgerbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(e.getSource() == burgerbutton) {
							q1 = Integer.parseInt(txt_burger.getText());
							dtm.addRow(new Object[] {"Burger", q1, "RM6.00"});
							totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
							totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
							totalprice = totalfood+totaldrink;
							txt_sub.setText(String.valueOf(totalprice));
							finalprice = totalprice * 1.1;
							txt_total.setText(String.valueOf(fp.format(finalprice)));
						}
					}
				});
		burgerbutton.setBounds(156, 115, 133, 35);
		burgerbutton.setFocusable(false);
		food_panel.add(burgerbutton);
		
		JButton pizzabutton = new JButton("Add to MyOrder");
		pizzabutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						if(e.getSource() == pizzabutton) {
								q2 = Integer.parseInt(txt_pizza.getText());
								dtm.addRow(new Object[] {"Pizza", q2, "RM10.50"});
								totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
								totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
								totalprice = totalfood+totaldrink;
								txt_sub.setText(String.valueOf(totalprice));
								finalprice = totalprice * 1.1;
								txt_total.setText(String.valueOf(fp.format(finalprice)));
							}
						}
					});
		pizzabutton.setFocusable(false);
		pizzabutton.setBounds(403, 115, 133, 35);
		food_panel.add(pizzabutton);
		
		
		JButton spaghettibutton = new JButton("Add to MyOrder");
		spaghettibutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == spaghettibutton) {
					q3 = Integer.parseInt(txt_spaghetti.getText());
						dtm.addRow(new Object[] {"Spaghetti", q3, "RM8.00"});
						totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
						totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
						totalprice = totalfood+totaldrink;
						txt_sub.setText(String.valueOf(totalprice));
						finalprice = totalprice * 1.1;
						txt_total.setText(String.valueOf(fp.format(finalprice)));
					}
				}
			});
		spaghettibutton.setFocusable(false);
		spaghettibutton.setBounds(132, 287, 128, 35);
		food_panel.add(spaghettibutton);	
		
		JButton saladbutton = new JButton("Add to MyOrder");
		saladbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == saladbutton) {
						q4 = Integer.parseInt(txt_salad.getText());
						dtm.addRow(new Object[] {"Salad", q4, "RM7.50"});
						totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
						totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
						totalprice = totalfood+totaldrink;
						txt_sub.setText(String.valueOf(totalprice));
						finalprice = totalprice * 1.1;
						txt_total.setText(String.valueOf(fp.format(finalprice)));
					}
				}
			});
		saladbutton.setFocusable(false);
		saladbutton.setBounds(434, 307, 126, 35);
		food_panel.add(saladbutton);
		
		JButton frbutton = new JButton("Add to MyOrder");
		frbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(e.getSource() == frbutton) {
						q5 = Integer.parseInt(txt_fr.getText());
						dtm.addRow(new Object[] {"Fried Rice", q5, "RM8.00"});
						totalprice = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
						txt_sub.setText(String.valueOf(totalprice));
						finalprice = totalprice * 1.1;
						txt_total.setText(String.valueOf(fp.format(finalprice)));
					}
				}
				});
		frbutton.setFocusable(false);
		frbutton.setBounds(145, 482, 128, 35);
		food_panel.add(frbutton);
		
		JButton ccbutton = new JButton("Add to MyOrder");
		ccbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == ccbutton) {
					q6 = Integer.parseInt(txt_cc.getText());
					dtm.addRow(new Object[] {"Spaghetti", q6, "RM14.50"});
					totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
					totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
					totalprice = totalfood+totaldrink;
					txt_sub.setText(String.valueOf(totalprice));
					finalprice = totalprice * 1.1;
					txt_total.setText(String.valueOf(fp.format(finalprice)));
				}
			}
		});
		ccbutton.setFocusable(false);
		ccbutton.setBounds(418, 482, 128, 35);
		food_panel.add(ccbutton);
		
		JButton resetfood = new JButton("Reset All");
		resetfood.setFocusable(false);
		resetfood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(e.getSource() == resetfood) {
							
					dtm.setRowCount(1);;
	
					txt_burger.setText("");
					txt_pizza.setText("");
					txt_spaghetti.setText("");
					txt_salad.setText("");
					txt_fr.setText("");
					txt_cc.setText("");
					txt_wj.setText("");
					txt_aj.setText("");
					txt_latte.setText("");
					txt_hc.setText("");
					txt_sub.setText("");
					txt_total.setText("");
					q1 = 0;
					q2 = 0;
					q3 = 0; 
					q4 = 0;
					q5 = 0; 
					q6 = 0;
					p1 = 0;
					p2 = 0;
					p3 = 0; 
					p4 = 0;
					totalprice = 0;
					finalprice = 0;
			}
		}
		});
		resetfood.setBounds(447, 11, 89, 23);
		food_panel.add(resetfood);
		
		JLabel lblPleaseEnterThe = new JLabel("*Please enter the quantiy of food item you wish to order.*");
		lblPleaseEnterThe.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPleaseEnterThe.setBounds(10, 10, 331, 25);
		food_panel.add(lblPleaseEnterThe);
			
		JPanel drink_panel = new JPanel();
		drink_panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Drink", null, drink_panel, null);
		drink_panel.setLayout(null);
		
		drinkImage[0]= new JLabel("");
		drinkImage[0].setIcon(new ImageIcon("watermelonjuice.jpg"));
		drinkImage[0].setBounds(38, 113, 122, 98);
		drinkImage[1]= new JLabel("");
		drinkImage[1].setIcon(new ImageIcon("applejuice.jpg"));
		drinkImage[1].setBounds(299, 107, 135, 111);
		drinkImage[2]= new JLabel("");
		drinkImage[2].setIcon(new ImageIcon("latte.jpg"));
		drinkImage[2].setBounds(38, 367, 129, 111);
		drinkImage[3]= new JLabel("");
		drinkImage[3].setIcon(new ImageIcon("hotchocolate.jpg"));
		drinkImage[3].setBounds(299, 379, 122, 86);
			
		drinkLabel[0] = new JLabel("Watermelon Juice");
		drinkLabel[0].setBounds(48, 234, 114, 20);
		drinkLabel[1] = new JLabel("Apple Juice");
		drinkLabel[1].setBounds(320, 241, 82, 20);
		drinkLabel[2] = new JLabel("Latte");
		drinkLabel[2].setBounds(82, 504, 46, 14);
		drinkLabel[3] = new JLabel("Hot Chocolate");
		drinkLabel[3].setBounds(320, 504, 114, 14);
			
		drinkPrice[0] = new JLabel("RM4.50");
		drinkPrice[0].setBounds(160, 237, 56, 14);
		drinkPrice[1] = new JLabel("RM4.50");
		drinkPrice[1].setBounds(423, 244, 60, 14);
		drinkPrice[2] = new JLabel("RM6.50");
		drinkPrice[2].setBounds(154, 501, 62, 20);
		drinkPrice[3] = new JLabel("RM6.50");
		drinkPrice[3].setBounds(423, 504, 54, 14);
		
		d1 = 4.50;
		d2 = 4.50;
		d3 = 6.50;
		d4 = 6.50;
		
		for(int i = 0; i < 4; i++) {
			drink_panel.add(drinkImage[i]);
			drinkLabel[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
			drink_panel.add(drinkLabel[i]);
			drinkPrice[i].setFont(new Font("Times New Roman", Font.PLAIN, 15));
			drink_panel.add(drinkPrice[i]);
		}
		
		JLabel quan_wj = new JLabel("Quantity: ");
		quan_wj.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_wj.setBounds(161, 152, 54, 26);
		drink_panel.add(quan_wj);
		
		JLabel quan_aj = new JLabel("Quantity: ");
		quan_aj.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_aj.setBounds(426, 158, 54, 26);
		drink_panel.add(quan_aj);
		
		JLabel quan_latte = new JLabel("Quantity: ");
		quan_latte.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_latte.setBounds(161, 403, 54, 26);
		drink_panel.add(quan_latte);
		
		JLabel quan_hc = new JLabel("Quantity: ");
		quan_hc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		quan_hc.setBounds(426, 409, 54, 26);
		drink_panel.add(quan_hc);
		
		txt_wj = new JTextField();
		txt_wj.setText("");
		txt_wj.setColumns(10);
		txt_wj.setBounds(210, 155, 54, 20);
		drink_panel.add(txt_wj);
		
		txt_aj = new JTextField();
		txt_aj.setText("");
		txt_aj.setColumns(10);
		txt_aj.setBounds(471, 161, 54, 20);
		drink_panel.add(txt_aj);
		
		txt_latte = new JTextField();
		txt_latte.setText("");
		txt_latte.setColumns(10);
		txt_latte.setBounds(210, 406, 54, 20);
		drink_panel.add(txt_latte);
		
		txt_hc = new JTextField();
		txt_hc.setText("");
		txt_hc.setColumns(10);
		txt_hc.setBounds(471, 412, 54, 20);
		drink_panel.add(txt_hc);
		
		JButton wjbutton = new JButton("Add to MyOrder");
		wjbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == wjbutton) {
					p1 = Integer.parseInt(txt_wj.getText());
					dtm.addRow(new Object[] {"Watermelon Juice", p1, "RM4.50"});
					totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
					totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
					totalprice = totalfood+totaldrink;
					txt_sub.setText(String.valueOf(totalprice));
					finalprice = totalprice * 1.1;
					txt_total.setText(String.valueOf(fp.format(finalprice)));
				}
			}
		});
		wjbutton.setFocusable(false);
		wjbutton.setBounds(161, 178, 130, 35);
		drink_panel.add(wjbutton);
		
		JButton ajbutton = new JButton("Add to MyOrder");
		ajbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == ajbutton) {
					p2 = Integer.parseInt(txt_aj.getText());
					dtm.addRow(new Object[] {"Apple Juice", p2, "RM4.50"});
					totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
					totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
					totalprice = totalfood+totaldrink;
					txt_sub.setText(String.valueOf(totalprice));
					finalprice = totalprice * 1.1;
					txt_total.setText(String.valueOf(fp.format(finalprice)));
				}
			}
		});
		ajbutton.setFocusable(false);
		ajbutton.setBounds(426, 184, 135, 35);
		drink_panel.add(ajbutton);
		
		
		
		JButton lattebutton = new JButton("Add to MyOrder");
		lattebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == lattebutton) {
					p3 = Integer.parseInt(txt_latte.getText());
					dtm.addRow(new Object[] {"Latte", p3, "RM6.50"});
					totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
					totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
					totalprice = totalfood+totaldrink;
					txt_sub.setText(String.valueOf(totalprice));
					finalprice = totalprice * 1.1;
					txt_total.setText(String.valueOf(fp.format(finalprice)));
				}
			}
		});
		lattebutton.setFocusable(false);
		lattebutton.setBounds(161, 434, 130, 35);
		drink_panel.add(lattebutton);
		
		JButton hcbutton = new JButton("Add to MyOrder");
		hcbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == hcbutton) {
					p4 = Integer.parseInt(txt_hc.getText());
					dtm.addRow(new Object[] {"Hot Chocolate", p4, "RM4.50"});
					totaldrink = p1*d1 + p2*d2 + p3*d3 + p4*d4;
					totalfood = q1*f1 + q2*f2 + q3*f3 + q4*f4 + q5*f5 + q6*f6;
					totalprice = totalfood+totaldrink;
					txt_sub.setText(String.valueOf(totalprice));
					finalprice = totalprice * 1.1;
					txt_total.setText(String.valueOf(fp.format(finalprice)));
			
				}
			}
		});
		hcbutton.setFocusable(false);
		hcbutton.setBounds(426, 434, 135, 35);
		drink_panel.add(hcbutton);
		
		JButton resetdrink = new JButton("Reset All");
		resetdrink.setFocusable(false);
		resetdrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == resetdrink) {
				
					dtm.setRowCount(1);
					
					txt_wj.setText("");
					txt_aj.setText("");
					txt_spaghetti.setText("");
					txt_salad.setText("");
					txt_fr.setText("");
					txt_cc.setText("");
					txt_wj.setText("");
					txt_aj.setText("");
					txt_latte.setText("");
					txt_hc.setText("");
					txt_sub.setText("");
					txt_total.setText("");
					q1 = 0;
					q2 = 0;
					q3 = 0; 
					q4 = 0;
					q5 = 0; 
					q6 = 0;
					p1 = 0;
					p2 = 0;
					p3 = 0; 
					p4 = 0;
					totalprice = 0;
					finalprice = 0;
				}
			}
		});
		resetdrink.setBounds(445, 11, 89, 23);
		drink_panel.add(resetdrink);
		
		JLabel lblNewLabel = new JLabel("*Please enter the quantiy of drink item you wish to order.*");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 9, 342, 25);
		drink_panel.add(lblNewLabel);
		
		

		
		JButton order = new JButton("Order");
		order.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(group1.isSelected(null)|| group2.isSelected(null)) {
					JOptionPane.showMessageDialog(null, "Customer's Information cannot be empty");
				}else if(!group1.isSelected(null) && !group2.isSelected(null)&& totalprice != 0){
					JOptionPane.showMessageDialog(null, "Thank you for ordering! Your food will be delivered soon.");
					dispose();
				}
				else if(!group1.isSelected(null) && !group2.isSelected(null) && totalprice == 0) {
					JOptionPane.showMessageDialog(null, "ERROR_MESSAGE\nPlease select something", "Nothing selected", JOptionPane.ERROR_MESSAGE);
				}
				try {
					File file = new File("Receipt.txt");
					if(!file.exists()){
						file.createNewFile();
					}
					
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
					bw.write("Retrovailles Restaurant\n");
					bw.write("-----------------------\n");
					for(int i = 0; i < table.getRowCount(); i++) {
						for(int j = 0; j < table.getColumnCount(); j++) {
							bw.write(table.getModel().getValueAt(i, j) + " ");
						}
						bw.write("\n_____________\n");
					}
					bw.write("Subtotal: RM" + String.valueOf(totalprice) + "\n");
					bw.write("Tax : 10%\n");
					bw.write("Total: RM" + String.valueOf(fp.format(finalprice)) + "\n\n");
					bw.write("Thank you!");
					bw.close();
					fw.close();

				
				}catch(Exception ex) {
					ex.printStackTrace();
				}	
			}
			
		});
		order.setBounds(786, 754, 89, 23);
		contentPane.add(order);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("restaurant.png"));
		lblNewLabel_1.setBounds(560, 0, 364, 170);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(605, 754, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome welcome = new Welcome();
				welcome.setVisible(true);;
			}
		});

		
		


	}
}



