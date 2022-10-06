package Dao;


import Model.student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class implStudent implements studentDao{
//
//    public static void main(String[] args) {
//     // 同測試用
//     // new implStudent().query1();
//     //   System.out.println(new implStudent().query1());
//
//    
//        // 1->先取List物件-->from資料庫
//        // 2->List--->轉陣列[]
//        // List<student> l=new implStudent().query2();
//        // System.out.println(l.size());
//        // student[] s=l.toArray(new student[l.size()] );//s[0]=?
//        
//        //System.out.println(s[1].getId()+"\t"+s[1].getName());
//
//        //System.out.println(new implStudent().querySum1(150, 250));
//        
//        //修改
//        //System.out.println(new implStudent().queryId(7));
//        //System.out.println(new implStudent().queryId(7).getName());
//        // student s=new implStudent().queryId(5);
//        // s.setName("Tina");
//        // s.setChi(3);
//        // new implStudent().update(s);
//        
//        //刪除
//        // new implStudent().delete(4);
//
//        new implStudent().query2(); 
//
//    }

    @Override
    public void add(String name, int chi, int eng, int math) {
       /*
        1.connection
        2.sql
        3.new student(name,chi,eng,math)
        4.PreparedStatement-->set-->????
        5.executeUpte
        */
       Connection conn=DBConnection.getDB();
       String sql="insert into student(name,chi,eng,math,sum) values(?,?,?,?,?)";
       student s=new student(name,chi,eng,math);
       
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2,s.getChi());
            ps.setInt(3,s.getEng());
            ps.setInt(4, s.getMath());
            ps.setInt(5, s.getSum());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void add(student s) {
       /*
        1.connection
        2.sql
        3.new student(name,chi,eng,math)
        4.PreparedStatement-->set-->????
        5.executeUpte
        */
       Connection conn=DBConnection.getDB();
            String sql="insert into student(name,chi,eng,math,sum) values(?,?,?,?,?)";
       //student s=new student(name,chi,eng,math);
       
              try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2,s.getChi());
            ps.setInt(3,s.getEng());
            ps.setInt(4, s.getMath());
            ps.setInt(5, s.getSum());
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String query1() {
        String show="";
        Connection conn=DBConnection.getDB();
        String Sql="select * from student";
        try {
            PreparedStatement ps=conn.prepareStatement(Sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                // 測試用，直接列印在debug區
                // System.out.println("id:"+rs.getInt("id")+
                //         "\tname:"+rs.getString("name")+
                //         "\tchi:"+rs.getInt("chi")+
                //         "\teng:"+rs.getInt("eng")+
                //         "\tmath:"+rs.getInt("math")+
                //         "\tsum:"+rs.getInt("sum"));

                show=show+("id:"+rs.getInt("id")+
                        "\tname:"+rs.getString("name")+
                        "\tchi:"+rs.getInt("chi")+
                        "\teng:"+rs.getInt("eng")+
                        "\tmath:"+rs.getInt("math")+
                        "\tsum:"+rs.getInt("sum")+"\n");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return show;
        
    }

    @Override
    public List<student> query2() {
       List<student> l=new ArrayList();
       Connection conn=DBConnection.getDB();
       String sql="select * from student";
       
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();//database資料,rs--->student
            while(rs.next())//每一筆
            {


                // 測試用，直接列印在debug區
                // System.out.println("id:"+rs.getInt("id")+
                //         "\tname:"+rs.getString("name")+
                //         "\tchi:"+rs.getInt("chi")+
                //         "\teng:"+rs.getInt("eng")+
                //         "\tmath:"+rs.getInt("math")+
                //         "\tsum:"+rs.getInt("sum"));

            //     // 這個方法沒有傳入id,失敗!
            //     l.add(new student(rs.getString("name"),rs.getInt("chi"),rs.getInt("eng"),rs.getInt("math")));
            //     //System.out.println("===="+rs.getString("name"));
            //     ??.setId(rs.getInt("id"));

                student s=new student();  //空白資料的 student
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setChi(rs.getInt("chi"));
                s.setEng(rs.getInt("eng"));
                s.setMath(rs.getInt("math"));
                s.setSum(rs.getInt("sum"));

                l.add(s);//新增student物件
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }

       
       return l;
    }

    @Override
    public String querySum1(int start, int end) {
         String show="";
        Connection conn=DBConnection.getDB();
        String Sql="select * from student where sum>=? and sum<=?";
        try {
            PreparedStatement ps=conn.prepareStatement(Sql);
           ps.setInt(1, start);
           ps.setInt(2, end);
            
            
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                show=show+"id:"+rs.getInt("id")+
                        "\tname:"+rs.getString("name")+
                        "\tchi:"+rs.getInt("chi")+
                        "\teng:"+rs.getInt("eng")+
                        "\tmath:"+rs.getInt("math")+
                        "\tsum:"+rs.getInt("sum")+"\n";
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return show;
    }

    @Override
    public List<student> querySum2(int start, int end) {
          List<student> l=new ArrayList();
       Connection conn=DBConnection.getDB();
       String sql="select * from student where sum>=? and sum<=?";
       
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, start);
            ps.setInt(2, end);
            ResultSet rs=ps.executeQuery();//database資料,rs--->student
            while(rs.next())//每一筆
            {
                student s=new student();//空白資料的 student
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setChi(rs.getInt("chi"));
                s.setEng(rs.getInt("eng"));
                s.setMath(rs.getInt("math"));
                s.setSum(rs.getInt("sum"));

            l.add(s);//新增student物件
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return l;
    }

    @Override
    public student queryId(int id) {
       student s=null;
       Connection conn=DBConnection.getDB();
       String sql="select * from student where id=?";
       
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                s=new student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setChi(rs.getInt("chi"));
                s.setEng(rs.getInt("eng"));
                s.setMath(rs.getInt("math"));
                s.setSum(rs.getInt("sum"));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
       return s;
    }

    @Override
    public void update(student s) {
       Connection conn=DBConnection.getDB();
       String sql="update student set name=?,chi=?,eng=?,math=?,sum=? where id=?";
       
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getChi());
            ps.setInt(3, s.getEng());
            ps.setInt(4, s.getMath());
            ps.setInt(5, s.getSum());
            ps.setInt(6, s.getId());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void delete(int id) {
    Connection conn=DBConnection.getDB();
       String sql="delete from student where id=?";
       
        try {
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(implStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}