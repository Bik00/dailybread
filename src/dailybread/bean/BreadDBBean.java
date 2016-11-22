package dailybread.bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class BreadDBBean {
	private static BreadDBBean instance = new BreadDBBean();
	private BreadDBBean() {}
	
	public static BreadDBBean getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env");
		DataSource ds = (DataSource)envCtx.lookup("jdbc/bread");
		return ds.getConnection();
	}
	
	
	public int addNewBread(BreadDataBean bread) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();
			String sql = "insert into bread(breadName, imageUrl, price, createdCount, ingredient, createdDate) values (?, ?, ?, ?, ?, SYSDATE)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bread.getBreadName());
			pstmt.setString(2, bread.getImageUrl());
			pstmt.setInt(3, bread.getPrice());
			pstmt.setInt(4, bread.getCreatedCount());
			pstmt.setString(5, bread.getIngredient());
			
			result = pstmt.executeUpdate();
			
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(pstmt != null)
				try { pstmt.close(); } catch(SQLException ex) {}
			if(conn != null)
				try { conn.close(); } catch(SQLException ex) {}
		}
		return result;
	}
	
	public BreadDataBean getNewBread() {
		
	}
}