package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField password;
	private String flag;
	public static String userName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		flag="-1";
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u56FE\u4E66\u9986\u7BA1\u7406\u7CFB\u7EDF");
		label.setFont(new Font("»ªÎÄÐÐ¿¬", Font.PLAIN, 17));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(105, 29, 204, 52);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u767B\u5F55");
		label_1.setBounds(275, 76, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u540D");
		label_2.setBounds(117, 121, 54, 15);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5BC6  \u7801");
		label_3.setBounds(117, 157, 54, 15);
		contentPane.add(label_3);
		
		user = new JTextField();
		user.setBounds(193, 118, 124, 21);
		contentPane.add(user);
		user.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(193, 154, 124, 21);
		contentPane.add(password);
		
		JButton loginButton = new JButton("\u767B  \u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database d = new database();
				String str[] = new String[3];
				str[0] = user.getText();
				str[1] = password.getText();
				if (flag.equals("1")) {
					if (d.queryReader(str)){
						new readerFun();
						userName=str[0];
						dispose();
						System.out.println("reader login success");
					}else{
						System.out.println("reader login failed");
					}
				}
				if (flag.equals("0")) {
					if(d.queryManager(str)){
						new manageFun();
						dispose();
						System.out.println("manager login success");
					}else{
						System.out.println("manager login failed");
					}
				}
			}
		});
		loginButton.setBounds(115, 228, 93, 23);
		contentPane.add(loginButton);
		
		JButton register = new JButton("\u8BFB\u8005\u6CE8\u518C");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register();
				dispose();
			}
		});
		register.setBounds(250, 228, 93, 23);
		contentPane.add(register);
		
		JRadioButton reader = new JRadioButton("\u8BFB\u8005");
		reader.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(reader.isSelected())
					flag="1";
			}
		});
		
		reader.setSelected(true);
		reader.setBounds(173, 181, 54, 23);
		contentPane.add(reader);
		
		JRadioButton manager = new JRadioButton("\u7BA1\u7406\u5458");
		manager.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(manager.isSelected())
					flag="0";
			}
		});
		manager.setBounds(250, 180, 79, 23);
		contentPane.add(manager);
		ButtonGroup bg=new ButtonGroup();
		bg.add(reader);
		bg.add(manager);
	}
}
