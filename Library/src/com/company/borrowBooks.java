package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;

public class borrowBooks extends JFrame {

	private JPanel contentPane;
	private JTextField ISBN;
	private JTextField name;
	private JTextField price;
	private JTextField num;
    String numStr="";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					borrowBooks frame = new borrowBooks();
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
	public borrowBooks() {


		setVisible(true);
		setTitle("\u501F\u9605\u56FE\u4E66");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblisbn = new JLabel("\u8F93\u5165ISBN");
		lblisbn.setBounds(82, 54, 77, 15);
		contentPane.add(lblisbn);
		
		ISBN = new JTextField();
		ISBN.setBounds(169, 51, 150, 21);
		contentPane.add(ISBN);
		ISBN.setColumns(10);
		
		JLabel label = new JLabel("\u56FE\u4E66\u4FE1\u606F\u5982\u4E0B\uFF1A");
		label.setBounds(82, 95, 110, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u540D\u79F0");
		label_1.setBounds(92, 120, 54, 15);
		contentPane.add(label_1);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(169, 117, 133, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4EF7\u683C");
		label_2.setBounds(92, 157, 54, 15);
		contentPane.add(label_2);
		
		price = new JTextField();
		price.setEditable(false);
		price.setColumns(10);
		price.setBounds(169, 151, 133, 21);
		contentPane.add(price);
		
		JLabel label_3 = new JLabel("\u5269\u4F59\u6570\u91CF");
		label_3.setBounds(92, 186, 54, 15);
		contentPane.add(label_3);
		
		num = new JTextField();
		num.setEditable(false);
		num.setColumns(10);
		num.setBounds(169, 183, 133, 21);
		contentPane.add(num);
		
		JButton borrowButton = new JButton("\u501F\u9605");
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              int bookNum=Integer.parseInt(numStr);
              if(bookNum>0) {
                  bookNum--;
                  String str = Integer.toString(bookNum);
                  database d = new database();
                  d.updateBookNum(str, ISBN.getText());
                  JOptionPane.showMessageDialog(null, "\u501f\u9605\u6210\u529f");

                  SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                  String datetime = tempDate.format(new java.util.Date());
                  String [] str1=new String[3];
                  str1[0]=login.userName;
                  str1[1]=ISBN.getText();
                  str1[2]=datetime;

                  d.insertBorrow(str1);

                  ISBN.setText("");
                  name.setText("");
                  price.setText("");
                  num.setText("");
              }else{
                  JOptionPane.showMessageDialog(null, "\u6570\u91cf\u4e0d\u8db3\uff0c\u4e0d\u80fd\u501f\u9605");
                  ISBN.setText("");
                  name.setText("");
                  price.setText("");
                  num.setText("");
              }
			}
		});
		borrowButton.setBounds(105, 228, 67, 23);
		contentPane.add(borrowButton);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new readerFun();
				dispose();
			}
		});
		button_1.setBounds(262, 228, 67, 23);
		contentPane.add(button_1);
		
		JButton OKButton = new JButton("\u786E\u5B9A");
		OKButton.addActionListener(new ActionListener() {
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
                    num.setText(str[2]);
                   numStr=str[2];
                }
			}
		});
		OKButton.setBounds(331, 50, 93, 23);
		contentPane.add(OKButton);
	}

}
