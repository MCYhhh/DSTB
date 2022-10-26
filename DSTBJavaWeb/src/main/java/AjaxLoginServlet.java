import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/AjaxLoginServlet")
public class AjaxLoginServlet extends HttpServlet {
    //        static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ty_company?&useSSL=false&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "123456";
//    private Object ClassNotFoundException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("uaccount");
        String pwd = request.getParameter("upwd");
        String type = request.getParameter("type");
        System.out.println(type);
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (type.equals("user")) {
            try {
                //1.注册驱动
                Class.forName("com.mysql.cj.jdbc.Driver");
                //2.获取连接
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //3.获取预编译的数据库操作对象
                String sql = "select upwd from user where uaccount=?";// for json auto
                ps = conn.prepareStatement(sql);
                ps.setString(1, account);
                //4.执行语句
                rs = ps.executeQuery();
                //5.处理结果集
                if (rs.next()) {
                    String pwd_1 = rs.getString("upwd");
//                    System.out.println(pwd);
                    if (pwd_1.equals(pwd)) {
                        System.out.println("00000000000000000");
                        out.print("普通用户");
                    } else {
                        out.print("密码错误，请重新输入");
                    }
                } else {
                    out.print("该用户名不存在");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("111111111111111111111111");
                e.printStackTrace();
            } finally {
                //6.释放资源
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        else {
            try {
                //1.注册驱动
                Class.forName("com.mysql.jdbc.Driver");
                //2.获取连接
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                //3.获取预编译的数据库操作对象
                String sql = "select wpwd from worker where waccount=?";// for json auto
                ps = conn.prepareStatement(sql);
                ps.setString(1, account);
                //4.执行语句
                rs = ps.executeQuery();
                //5.处理结果集
                if (rs.next()) {
                    String pwd_1 = rs.getString("wpwd");
//                    System.out.println(pwd);
                    if (pwd_1.equals(pwd)) {
                        System.out.println("00000000000000000");
                        if(type.equals("worker0"))
                            out.print("销售人员");
                        if(type.equals("worker1"))
                            out.print("管理人员");
                    } else {
                        out.print("密码错误，请重新输入");
                    }
                } else {
                    out.print("该用户名不存在");
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("111111111111111111111111");
                e.printStackTrace();
            } finally {
                //6.释放资源
                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (ps != null) {
                    try {
                        ps.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
