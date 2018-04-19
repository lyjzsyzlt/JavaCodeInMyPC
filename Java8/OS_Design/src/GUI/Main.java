package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Main extends JFrame{
    JPanel mainJP=null;
    JButton instruct=null;
    JTextArea jta1=null;
    JTextArea jta2=null;
    JButton selectAlg=null;
    JTextField jtf=null;
    JLabel jl1=null;
    JLabel jl2=null;
    JLabel jl3=null;
    JLabel jl4=null;
    JLabel jl5=null;
    JLabel jl6=null;
    JLabel jl7=null;
    JLabel jl8=null;

    JProgressBar processBar1;
    JProgressBar processBar2;
    JProgressBar processBar3;
    JProgressBar processBar4;

    public Main(){

        instruct=new JButton("生成随机指令");
        jl1=new JLabel("指令如下：");
        //jl2=new JLabel("页表如下");
        jta1=new JTextArea();//指令显示区
        jta1.setSize(2,100);
        jta2=new JTextArea();//页表显示区

        jl3=new JLabel("内存块数");
        jtf=new JTextField(2);
        selectAlg=new JButton("确定");

        jl4=new JLabel("各个算法的命中率如下：");
        jl5=new JLabel("FIFO");
        jl6=new JLabel("LRU");
        jl7=new JLabel("OPT");
        jl8=new JLabel("LFU");

        processBar1=new JProgressBar();
        processBar2=new JProgressBar();
        processBar3=new JProgressBar();
        processBar4=new JProgressBar();


        //测试
        processBar1.setString("12.22%");
        processBar1.setStringPainted(true);
        processBar1.setBorderPainted(true);
        processBar1.setSize(5,20);
        processBar1.setForeground(Color.red);

        processBar2.setSize(5,20);
        processBar2.setStringPainted(true);
        processBar2.setBorderPainted(true);
        processBar3.setSize(5,20);
        processBar3.setStringPainted(true);
        processBar3.setBorderPainted(true);
        processBar4.setSize(5,20);
        processBar4.setStringPainted(true);
        processBar4.setBorderPainted(true);

        JPanel jp1,jp2,jp3,jp4,jp5,jp6,jp7,jp8,jp9,jp10,jp11;

        jp1=new JPanel();
        jp1.add(instruct);

        jp2=new JPanel();
        jp2.setLayout(new BorderLayout());
        jp2.add(jl1, BorderLayout.NORTH);
        jp2.add(jta1,BorderLayout.CENTER);



        jp4=new JPanel();
        jp4.add(jl3);
        jp4.add(jtf);
        jp4.add(selectAlg);

        jp5=new JPanel();
        jp5.add(jl4);

        jp6=new JPanel();
        jp6.add(jl5);
        jp6.add(processBar1);

        jp7=new JPanel();
        jp7.add(jl6);
        jp7.add(processBar2);

        jp8=new JPanel();
        jp8.add(jl7);
        jp8.add(processBar3);

        jp9=new JPanel();
        jp9.add(jl8);
        jp9.add(processBar4);

        jp10=new JPanel();
        jp10.setLayout(new BorderLayout());
        jp10.add(jp1,BorderLayout.NORTH);
        jp10.add(jp2,BorderLayout.CENTER);



        jp11=new JPanel();
        jp11.add(jp4);
        jp11.add(jp5);
        jp11.add(jp6);
        jp11.add(jp7);
        jp11.add(jp8);
        jp11.add(jp9);
        jp11.setLayout(new GridLayout(6,1));

        this.add(jp10);
        this.add(jp11);
        this.setLayout(new GridLayout(1,2));

        this.setTitle("LRU算法课程设计");
        this.setVisible(true);
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        Main M=new Main();
    }
}
