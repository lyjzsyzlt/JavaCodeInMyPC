package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageFun extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageFun frame = new manageFun();
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
	public manageFun() {
		setVisible(true);
		setTitle("\u7BA1\u7406\u5458\u529F\u80FD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 188, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u6DFB\u52A0\u56FE\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new addBooks();
				dispose();
			}
		});
		button.setBounds(39, 38, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664\u56FE\u4E66");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new deleteBooks();
				dispose();
			}
		});
		button_1.setBounds(39, 85, 93, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u56FE\u4E66");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new updateBooks();
				dispose();
			}
		});
		button_2.setBounds(39, 132, 93, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u5F52\u8FD8\u56FE\u4E66");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new returnFun();
				dispose();
			}
		});
		button_3.setBounds(39, 176, 93, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\u9000\u51FA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
				dispose();
			}
		});
		button_4.setBounds(39, 214, 93, 23);
		contentPane.add(button_4);
	}

}
