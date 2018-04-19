package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class deleteBooks extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN;
	private JTextField name;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteBooks frame = new deleteBooks();
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
	public deleteBooks() {
		setVisible(true);
		setTitle("\u5220\u9664\u56FE\u4E66");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblisbn = new JLabel("\u8F93\u5165ISBN");
		lblisbn.setBounds(96, 60, 62, 15);
		contentPane.add(lblisbn);
		
		ISBN = new JTextField();
		ISBN.setBounds(168, 57, 139, 21);
		contentPane.add(ISBN);
		ISBN.setColumns(10);
		
		JLabel label = new JLabel("\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label.setBounds(96, 99, 66, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u540D\u79F0");
		label_1.setBounds(101, 124, 54, 15);
		contentPane.add(label_1);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(178, 124, 133, 21);
		contentPane.add(name);
		
		JLabel label_2 = new JLabel("\u4EF7\u683C");
		label_2.setBounds(97, 160, 54, 15);
		contentPane.add(label_2);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(174, 154, 133, 21);
		contentPane.add(price);
		
		JButton button = new JButton("\u5220\u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ISBN.getText().equals("")){
					JOptionPane.showMessageDialog(null, "\u8f93\u5165\u6b63\u786e\u7684ISBN");
				}else{
					database d=new database();
					d.deleteBook(ISBN.getText());
				}
			}
		});
		button.setBounds(92, 206, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manageFun();
				dispose();
			}
		});
		button_1.setBounds(247, 206, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u786E\u5B9A");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strISBN=ISBN.getText();
				database d=new database();
				String str[]=new String [3];
				str=d.queryBook(strISBN);
				if(str[0].equals("")){
					JOptionPane.showMessageDialog(null, "\u56fe\u4e66\u4e0d\u5b58\u5728\uff01");
					ISBN.setText("");
					name.setText("");
					price.setText("");
				}else{
					name.setText(str[0]);
					price.setText(str[1]);
				}
			}
		});
		button_2.setBounds(331, 56, 66, 23);
		contentPane.add(button_2);
	}

}
