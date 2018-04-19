package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField name;
	private JTextField sex;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setVisible(true);
		setTitle("\u8BFB\u8005\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel text1 = new JLabel("\u5B66  \u53F7");
		text1.setBounds(115, 45, 54, 15);
		contentPane.add(text1);
		
		JLabel text2 = new JLabel("\u59D3  \u540D");
		text2.setBounds(115, 85, 54, 15);
		contentPane.add(text2);


		JLabel text = new JLabel("\u5BC6   \u7801");
		text.setBounds(115, 122, 54, 15);
		contentPane.add(text);

		JLabel text4 = new JLabel("\u6027   \u522B");
		text4.setBounds(115, 165, 54, 15);
		contentPane.add(text4);
		
		ID = new JTextField();
		ID.setBounds(179, 42, 113, 21);
		contentPane.add(ID);
		ID.setColumns(10);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(179, 82, 113, 21);
		contentPane.add(name);
		
		sex = new JTextField();
		sex.setColumns(10);
		sex.setBounds(178, 162, 113, 21);
		contentPane.add(sex);
		
		JButton registerButton = new JButton("\u6CE8\u518C");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database d=new database();
				String []str=new String[4];
				str[0]=ID.getText();
				str[1]=password.getText();
				str[2]=name.getText();
				str[3]=sex.getText();
				System.out.println(str[0]);
				d.insertReader(str);
				dispose();
				new login();
			}
		});
		registerButton.setBounds(133, 213, 64, 23);
		contentPane.add(registerButton);
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new login();
			}
		});
		cancelButton.setBounds(243, 213, 64, 23);
		contentPane.add(cancelButton);
		
		password = new JPasswordField();
		password.setBounds(179, 119, 113, 21);
		contentPane.add(password);
	}
}
