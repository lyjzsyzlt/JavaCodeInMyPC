package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

public class returnFun extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN;
	private JTextField ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					returnFun frame = new returnFun();
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
	public returnFun() {
		setVisible(true);
		setTitle("\u56FE\u4E66\u5F52\u8FD8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblisbn = new JLabel("\u5F52\u8FD8\u56FE\u4E66\u7684ISBN");
		lblisbn.setBounds(121, 86, 112, 15);
		contentPane.add(lblisbn);
		
		ISBN = new JTextField();
		ISBN.setBounds(224, 86, 124, 21);
		contentPane.add(ISBN);
		ISBN.setColumns(10);
		
		JLabel lblid = new JLabel("\u5F52\u8FD8\u8005ID");
		lblid.setBounds(121, 117, 54, 15);
		contentPane.add(lblid);
		
		ID = new JTextField();
		ID.setBounds(224, 117, 124, 21);
		contentPane.add(ID);
		ID.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u5F52\u8FD8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String []str=new String[3];
				str[0]=ID.getText();
				str[1]=ISBN.getText();
				SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				str[2] = tempDate.format(new java.util.Date());
				database d=new database();
				d.insertReturn(str);
			}
		});
		button.setBounds(90, 201, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manageFun();
				dispose();
			}
		});
		button_1.setBounds(265, 201, 93, 23);
		contentPane.add(button_1);
	}
}
