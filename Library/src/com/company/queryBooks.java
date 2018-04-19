package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class queryBooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblIsbn;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queryBooks frame = new queryBooks();
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
	public queryBooks() {
		setVisible(true);
		setTitle("\u56FE\u4E66\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u8F93\u5165\u56FE\u4E66\u540D\u79F0");
		label.setBounds(80, 50, 93, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(166, 47, 145, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		table = new JTable();
		table.setToolTipText("ee");
		contentPane.add(table);
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ISBN", "\u540D\u79F0", "\u4EF7\u683C", "\u53EF\u501F\u6570\u91CF"
			}
		));
		table.setColumnSelectionAllowed(true);
		table.setBounds(58, 120, 328, 96);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 226, 347, -126);
		contentPane.add(scrollPane);
		
		lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(67, 99, 54, 15);
		contentPane.add(lblIsbn);
		
		label_1 = new JLabel("\u540D\u79F0");
		label_1.setBounds(148, 99, 54, 15);
		contentPane.add(label_1);
		
		label_2 = new JLabel("\u4EF7\u683C");
		label_2.setBounds(230, 99, 54, 15);
		contentPane.add(label_2);
		
		label_3 = new JLabel("\u53EF\u501F\u6570\u91CF");
		label_3.setBounds(318, 99, 54, 15);
		contentPane.add(label_3);
		
		button = new JButton("\u67E5\u8BE2");
		button.setBounds(341, 46, 73, 23);
		contentPane.add(button);
		
		button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new readerFun();
				dispose();
			}
		});
		button_1.setBounds(318, 226, 93, 23);
		contentPane.add(button_1);
	}
}
