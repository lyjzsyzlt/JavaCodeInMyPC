package com.company;
import javax.swing.*;
import java.sql.*;

public class database {
    final static String cfn = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    final static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Library";
    public database()
    {
    }

    public boolean queryReader(String [] str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url,"lyj","123");

            String sql = "select * from userInfo ";
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            //
            while(res.next()){
                if(res.getString("ID").equals(str[0])&&res.getString("Upassword").equals(str[1]))
                {
                    return true;
                }
                else
                {
                    continue;
                }
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return false;
    }

    public boolean queryManager(String [] str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url,"lyj","123");
            String sql = "select * from manager ";
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            //
            while(res.next()){
                if(res.getString("MID").equals(str[0])&&res.getString("Mpassword").equals(str[1]))
                {
                    return true;
                }
                else
                {
                    continue;
                }
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return false;
    }

    public void insertReader(String [] str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url, "lyj", "123");

            String sql="insert into userInfo (ID,Upassword,UserName,sex) values (?,?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setString(1,str[0]);
            statement.setString(2,str[1]);
            statement.setString(3,str[2]);
            statement.setString(4,str[3]);

            statement.execute();
            JOptionPane.showMessageDialog(null, "注册成功！");
            System.out.println("insert into userInfo successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertBook(String []str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url, "lyj", "123");

            String sql="insert into books (ISBN,bookName,price,num) values (?,?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setString(1,str[0]);
            statement.setString(2,str[1]);
            statement.setString(3,str[2]);
            statement.setString(4,str[3]);

            statement.execute();
            JOptionPane.showMessageDialog(null, "添加成功！");
            System.out.println("insert into books successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public String[] queryBook(String str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        String s[]=new String[3];
        s[0]="";
        s[1]="";
        s[2]="";
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url,"lyj","123");

            String sql = "select * from books ";
            statement = con.prepareStatement(sql);
            res = statement.executeQuery();
            //
            while(res.next()){
                if(res.getString("ISBN").equals(str))
                {

                    s[0]=res.getString("bookName");
                    s[1]=res.getString("price");
                    s[2]=res.getString("num");
                    return s;
                }
                else
                {
                    continue;
                }
            }
            return s;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                if(res != null) res.close();
                if(statement != null) statement.close();
                if(con != null) con.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return s;
    }

    public void deleteBook(String str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url, "lyj", "123");

            String sql="delete from books where ISBN=?";
            statement = con.prepareStatement(sql);
            statement.setString(1,str);
            statement.execute();
            JOptionPane.showMessageDialog(null, "删除成功！");
            System.out.println("delete the books successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateBook(String str1,String str2)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url, "lyj", "123");

            String sql="update books set price=? where ISBN=?";
            statement = con.prepareStatement(sql);
            statement.setString(1,str1);
            statement.setString(2,str2);

            statement.execute();
            JOptionPane.showMessageDialog(null, "修改成功！");
            System.out.println("update the books successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void updateBookNum(String str1,String str2)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url, "lyj", "123");

            String sql="update books set num=? where ISBN=?";
            statement = con.prepareStatement(sql);
            statement.setString(1,str1);
            statement.setString(2,str2);

            statement.execute();
            //JOptionPane.showMessageDialog(null, "数量修改成功！");
            System.out.println("update the book's number successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertBorrow(String []str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url, "lyj", "123");

            String sql="insert into borrow (ID,ISBN,Btime) values (?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setString(1,str[0]);
            statement.setString(2,str[1]);
            statement.setString(3,str[2]);

            statement.execute();
            System.out.println("insert into borrow successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertReturn(String [] str)
    {
        Connection con = null;
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            Class.forName(cfn);
            con = DriverManager.getConnection(url, "lyj", "123");

            String sql="insert into Return1 (ID,ISBN,Rtime) values (?,?,?)";
            statement = con.prepareStatement(sql);
            statement.setString(1,str[0]);
            statement.setString(2,str[1]);
            statement.setString(3,str[2]);

            statement.execute();
            System.out.println("insert into Return1 successfully!");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

