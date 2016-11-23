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
		BreadDataBean bread = null;
    	Connection conn = null;
        PreparedStatement pstmt = null;
        String sql = null;
        ResultSet rs = null;
        
        try{
        	conn = getConnection();
        	sql = "select * from bread order by breadId desc limit 1";
        	pstmt = conn.prepareStatement(sql);
        	rs = pstmt.executeQuery();
        	if(rs.next()){
        		bread = new BreadDataBean();
        		bread.setBreadId(rs.getInt("breadId"));
        		bread.setBreadName(rs.getString("breadName"));
        		bread.setImageUrl(rs.getString("imageUrl"));
        		bread.setPrice(rs.getInt("price"));
        		bread.setCreatedCount(rs.getInt("createdCount"));
        		bread.setIngredient(rs.getString("ingredient"));
        		bread.setRemains(rs.getInt("remains"));
        		bread.setCreatedDate(rs.getTimestamp("createdDate"));
        	}
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
        	if(rs != null)
        		try { rs.close(); } catch(SQLException ex){}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    	return bread;
    }
	

    public int purchase(int breadId, int count){
    	Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement updatePstmt = null;
        ResultSet rs = null;
        String sql = null;
        int result = 0;
        try{
        	conn = getConnection();
        	sql = "select remains from test.bread where breadId=?";
        	pstmt = conn.prepareStatement(sql);
        	pstmt.setInt(1, breadId);
        	rs = pstmt.executeQuery();
        	if(rs.next()){
        		int remains = rs.getInt("remains");
        		remains -= count;
        		if(remains < 0) remains = 0;
        		
        		sql = "update bread set remains = ? where breadId=?";
        		updatePstmt = conn.prepareStatement(sql);
        		updatePstmt.setInt(1,  remains);
        		updatePstmt.setInt(2,  breadId);
        		result = updatePstmt.executeUpdate();
        	} else {
        		// 蹂???곗씠?곌? ?녿떎...援щℓ???ㅽ뙣?덈떎.
        		result = 0;
        	}
        }catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
        	if (rs != null) 
            	try { rs.close(); } catch(SQLException ex) {}
        	if (updatePstmt != null) 
            	try { updatePstmt.close(); } catch(SQLException ex) {}
            if (pstmt != null) 
            	try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) 
            	try { conn.close(); } catch(SQLException ex) {}
        }
    	return result;
    }

	
}