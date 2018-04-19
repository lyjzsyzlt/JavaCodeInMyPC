package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class updateBooks extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN;
	private JTextField name;
	private JTextField price;
	private JTextField price2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateBooks frame = new updateBooks();
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
	public updateBooks() {
		setVisible(true);
		setTitle("\u4FEE\u6539\u56FE\u4E66\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165ISBN");
		label.setBounds(60, 42, 62, 15);
		contentPane.add(label);
		
		ISBN = new JTextField();
		ISBN.setColumns(10);
		ISBN.setBounds(132, 39, 139, 21);
		contentPane.add(ISBN);
		
		JButton button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String strISBN=ISBN.getText();
				database d=new database();
				String str[]=new String [2];
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
		button.setBounds(295, 38, 66, 23);
		contentPane.add(button);
		
		JLabel label_1 = new JLabel("\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label_1.setBounds(60, 83, 66, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u540D\u79F0");
		label_2.setBounds(60, 108, 54, 15);
		contentPane.add(label_2);
		
		name = new JTextField();
		name.setEditable(false);
		name.setColumns(10);
		name.setBounds(138, 105, 133, 21);
		contentPane.add(name);
		
		JLabel label_3 = new JLabel("\u4EF7\u683C");
		label_3.setBounds(60, 142, 54, 15);
		contentPane.add(label_3);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(138, 139, 133, 21);
		contentPane.add(price);
		
		JLabel label_4 = new JLabel("\u8F93\u5165\u4FEE\u6539\u540E\u7684\u4EF7\u683C");
		label_4.setBounds(60, 185, 109, 15);
		contentPane.add(label_4);
		
		price2 = new JTextField();
		price2.setBounds(190, 182, 118, 21);
		contentPane.add(price2);
		price2.setColumns(10);
		
		JButton updateButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str=price2.getText();
				database d=new database();
				d.updateBook(str,ISBN.getText());
				price2.setText("");
				ISBN.setText("");
				name.setText("");
				price.setText("");
			}
		});
		updateButton.setBounds(63, 228, 93, 23);
		contentPane.add(updateButton);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manageFun();
				dispose();
			}
		});
		button_2.setBounds(254, 228, 93, 23);
		contentPane.add(button_2);
	}

}
