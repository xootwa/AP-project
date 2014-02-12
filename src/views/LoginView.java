package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textUserName;
	private JTextField textPassword;
	private JLabel lblUserName;
	private JLabel lblPassword;
	private JButton btnLogin;
	private JLabel lblBackground;
	private JLabel lblBackground_btm;
	private JLabel lblWineBg;
	
	
	public LoginView() {
		setTitle("AP-Project");
		
		initializeComponents();
		setLayout();
		registerListeners();
		addComponentsToWindow();
		setWindowProperties();
	}
	
	
	public void initializeComponents(){
		contentPane = new JPanel();
		lblUserName = new JLabel("User Name:");
		lblPassword = new JLabel("Password:");
		textUserName = new JTextField();
		textPassword = new JTextField();
		btnLogin = new JButton("Login");
		lblBackground = new JLabel("bg");
		lblWineBg = new JLabel("");
		lblBackground_btm = new JLabel("bgBottom");
		
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		
		lblBackground.setBounds(0, 0, 454, 476);
		lblBackground.setIcon(new ImageIcon(LoginView.class.getResource("/resources/shattered.png")));
		
		lblWineBg.setHorizontalAlignment(SwingConstants.CENTER);
		lblWineBg.setIcon(new ImageIcon(LoginView.class.getResource("/resources/login.png")));
		lblWineBg.setBounds(92, 30, 258, 278);
		
		lblUserName.setBounds(102, 332, 63, 14);
		
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(102, 356, 63, 14);
		
		textUserName.setForeground(new Color(169, 169, 169));
		textUserName.setText("User Name");
		textUserName.setBounds(167, 329, 193, 20);
		textUserName.setColumns(10);
		
		textPassword.setForeground(new Color(169, 169, 169));
		textPassword.setText("Password");
		textPassword.setBounds(167, 353, 193, 20);
		textPassword.setColumns(10);
		
		btnLogin.setFocusPainted(false);
		btnLogin.setBackground(new Color(139, 0, 0));
		btnLogin.setBounds(343, 493, 89, 23);
		
		lblBackground_btm.setIcon(new ImageIcon(LoginView.class.getResource("/resources/redwine.png")));
		lblBackground_btm.setBounds(0, 476, 454, 56);
	}
	
	
	public void setLayout(){
		contentPane.setLayout(null);
	}
	
	
	public void registerListeners(){
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ManagerView manager = new ManagerView();
				manager.setVisible(true);;
				dispose();
			}
		});
	}
	
	
	public void addComponentsToWindow(){
		contentPane.add(lblWineBg);
		contentPane.add(lblUserName);
		contentPane.add(lblPassword);
		contentPane.add(textUserName);
		contentPane.add(textPassword);
		contentPane.add(lblBackground);
		contentPane.add(btnLogin);
		contentPane.add(lblBackground_btm);
	}
	
	
	public void setWindowProperties(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/resources/drink.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 560);
	}
}
