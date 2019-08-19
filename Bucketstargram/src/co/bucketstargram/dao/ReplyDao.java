package co.bucketstargram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import co.bucketstargram.dto.ReplyDto;

public class ReplyDao {

	Connection conn = null; // DB연결된 상태(세션)을 담은 객체
    PreparedStatement psmt = null;  // SQL 문을 나타내는 객체
    ResultSet rs = null;  // 쿼리문을 날린것에 대한 반환값을 담을 객체
    
	public ReplyDao() {
		// TODO Auto-generated constructor stub
		try {
            String user = "lee"; 
            String pw = "1234";
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            
            Class.forName("oracle.jdbc.driver.OracleDriver");        
            conn = DriverManager.getConnection(url, user, pw);
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패 : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
	}
	
	private void close() {
		// TODO Auto-generated method stub
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public HashMap<String, ReplyDto> select(String userid) {
		// TODO Auto-generated method stub
		HashMap<String, ReplyDto> ReplyList = null;
		ReplyDto reply = null;
		String sql = "SELECT * FROM bucket_reply_tb WHERE re_member_id = '" + userid + "'";
		
		try {
			ReplyList = new HashMap<String, ReplyDto>();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				reply = new ReplyDto();
				reply.setReBucketId(rs.getString("re_bucket_id"));
				reply.setReMemberId(rs.getString("re_member_id"));
				reply.setReReplyContents(rs.getString("re_reply_contents"));
				  
				ReplyList.put(reply.getReBucketId(), reply);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return ReplyList;
	}
}
