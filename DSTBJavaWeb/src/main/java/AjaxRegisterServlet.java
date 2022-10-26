import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AjaxRegisterServlet")

public class AjaxRegisterServlet extends HttpServlet {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/ty_company?&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    static final String USER = "root";
    static final String PASS = "123456";
//    private Object ClassNotFoundException;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("uaccount");
        String pwd = request.getParameter("upwd");
        String name = request.getParameter("uname");
        String sex = request.getParameter("usex");
        String phone = request.getParameter("utel");
        String site = request.getParameter("usite");
        System.out.println(site);
        PreparedStatement ps = null;
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //3.获取预编译的数据库操作对象
            String sql = "select uaccount from user where uaccount=?";// for json auto
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);//?????
            //4.执行语句
            rs = ps.executeQuery();
            //5.处理结果集
            if (rs.next()) {
                //用户名已存在
                out.print("账户名已存在");
            } else {
//                sql="INSERT INTO `ty_company`.`user` ( `Uaccount`, `Uname`, `Upwd`, `Usex`, `Utel`, `Usite`) VALUES (?,?,?,?,?,?)" ;
//                ps = conn.prepareStatement(sql);
//                ps.setString(1, account);
//                ps.setString(2, name);
//                ps.setString(3, pwd);
//                ps.setString(4, sex);
//                ps.setString(5, phone);
//                ps.setString(6, site);
                sql = "INSERT INTO `ty_company`.`user` ( `Uaccount`, `Uname`, `Upwd`, `Usex`, `Utel`, `Usite`) VALUES ('" + account + "' ,'" + name + "','" + pwd + "','" + sex + "','" + phone + "','" + site + "')";
                System.out.println(sql);
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                out.print("注册成功");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
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