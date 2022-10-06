package Dao;

import Model.student;
import java.util.List;

public interface studentDao {
    //Create新增
   void add(String name,int chi,int eng,int math); 
   void add(student s);//inject
   //Read查詢
    String query1();
    List<student> query2();
        //查詢介於start~end之間的資料
    String querySum1(int start,int end);
    List<student> querySum2(int start,int end);
    student queryId(int id);
    //student[] query();
    //Update修改
    void update(student s);
    
    
    
    //Delete刪除
    void delete(int id);
}