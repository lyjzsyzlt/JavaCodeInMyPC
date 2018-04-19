package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class borrowHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					borrowHistory frame = new borrowHistory();
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
	public borrowHistory() {
		setVisible(true);
		setTitle("\u501F\u9605\u5386\u53F2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("ee");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u501F\u9605\u65F6\u95F4");
		label.setBounds(56, 60, 54, 15);
		contentPane.add(label);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setBounds(139, 60, 54, 15);
		contentPane.add(lblIsbn);
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u540D\u79F0");
		label_1.setBounds(211, 60, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5F52\u8FD8\u65F6\u95F4");
		label_2.setBounds(303, 60, 54, 15);
		contentPane.add(label_2);
		
		table = new JTable();
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
				"New column", "New column", "New column", "New column"
			}
		));
		table.setToolTipText("");
		table.setSurrendersFocusOnKeystroke(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setBounds(42, 97, 328, 96);
		contentPane.add(table);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new readerFun();
				dispose();
			}
		});
		button.setBounds(277, 217, 93, 23);
		contentPane.add(button);
	}
}
