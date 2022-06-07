package SingletonDesignPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCSingleton {
  private static JDBCSingleton jdbc;
  
  private JDBCSingleton() {}
  
  static JDBCSingleton getInstance() {
    if(jdbc==null) {
      jdbc = new JDBCSingleton();
    }
    return jdbc;
  }
  
  private static Connection getConnection() throws ClassNotFoundException, SQLException {
    Connection con = null;
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amitdb1", "root", "password");
    return con;
  }
  
  public int insert(int empId, String empName, int age, String empDepartment) throws SQLException {
    Connection c =null;
    PreparedStatement ps = null;
    int recordCounter = 0;
    try {
      c = this.getConnection();
      ps = c.prepareStatement("insert into employee(EmpID, EmpName, EmpAge, EmpDept) values(?,?,?,?)");
      ps.setInt(1, empId);
      ps.setString(2, empName);
      ps.setInt(3, age);
      ps.setString(4, empDepartment);
      recordCounter= ps.executeUpdate();
    } catch(Exception e) {
      e.printStackTrace();
    } finally {
      if(ps!=null) {
        ps.close();
      }
      if(c!=null) {
        c.close();
      }
    }
    
    return recordCounter;
  }
  
  public void view(String name) throws SQLException{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      con=this.getConnection();
      ps=con.prepareStatement("select * from employee where EmpName=?");
      ps.setString(1, name);
      rs=ps.executeQuery();
      while (rs.next()) {
        System.out.println("Name= "+rs.getString(2)+" "+"ID= "+rs.getString(1));
        }
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      if(rs!=null) {
        rs.close();
      }
      if (ps!=null) {
        ps.close();
      }
      if(con!=null){
        con.close();
      }
    }
  }
  
  public int update(int id, String name) throws SQLException {
    Connection c=null;
    PreparedStatement ps=null;
    int recordCounter=0;
    try {
      c=this.getConnection();
      ps=c.prepareStatement(" update employee set EmpName=? where EmpID='"+id+"' ");
      ps.setString(1, name);
      recordCounter=ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (ps!=null) {
        ps.close();
      }
      if(c!=null) {
        c.close();
      }
    }
    return recordCounter;
  }
  
  public int delete(int userid) throws SQLException{
    Connection c=null;
    PreparedStatement ps=null;
    int recordCounter=0;
    try {
      c = this.getConnection();
      ps=c.prepareStatement(" delete from employee where EmpID='"+userid+"' ");
      recordCounter=ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (ps!=null) {
        ps.close();
      }
      if(c!=null) {
        c.close();
      }
    }
    return recordCounter;
  }

}
