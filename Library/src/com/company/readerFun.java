package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class readerFun extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					readerFun frame = new readerFun();
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
	public readerFun() {
		setVisible(true);
		setTitle("\u8BFB\u8005\u529F\u80FD\u9009\u62E9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 192, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("\u67E5\u8BE2\u56FE\u4E66");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBooks q=new queryBooks();
				dispose();
			}
		});
		button.setBounds(38, 73, 113, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u501F\u9605");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBooks b=new borrowBooks();
				dispose();
			}
		});
		button_1.setBounds(38, 137, 113, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("\u67E5\u770B\u501F\u9605\u5386\u53F2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowHistory bH=new borrowHistory();
				dispose();
			}
		});
		button_2.setBounds(38, 199, 113, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\u9000\u51FA");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_3.setBounds(38, 249, 113, 23);
		contentPane.add(button_3);
	}

}
