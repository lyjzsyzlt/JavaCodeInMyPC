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

public class addBooks extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN;
	private JTextField bookName;
	private JTextField price;
	private JTextField number;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addBooks frame = new addBooks();
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
	public addBooks() {
		setVisible(true);
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(106, 54, 54, 15);
		contentPane.add(lblIsbn);
		
		JLabel label = new JLabel("\u56FE\u4E66\u540D\u79F0");
		label.setBounds(106, 93, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u4EF7\u683C");
		label_1.setBounds(106, 135, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5F53\u524D\u6570\u91CF");
		label_2.setBounds(106, 176, 54, 15);
		contentPane.add(label_2);
		
		ISBN = new JTextField();
		ISBN.setBounds(192, 51, 132, 21);
		contentPane.add(ISBN);
		ISBN.setColumns(10);
		
		bookName = new JTextField();
		bookName.setColumns(10);
		bookName.setBounds(192, 90, 132, 21);
		contentPane.add(bookName);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(192, 135, 132, 21);
		contentPane.add(price);
		
		number = new JTextField();
		number.setColumns(10);
		number.setBounds(192, 173, 132, 21);
		contentPane.add(number);
		
		JButton button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str[]=new String[4];
				str[0]=ISBN.getText();
				str[1]=bookName.getText();
				str[2]=price.getText();
				str[3]=number.getText();

				database d=new database();
				d.insertBook(str);
			}
		});
		button.setBounds(106, 228, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manageFun();
				dispose();
			}
		});
		button_1.setBounds(257, 228, 93, 23);
		contentPane.add(button_1);
	}
}
