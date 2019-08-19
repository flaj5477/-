package co.bucketstargram.command.myBucket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.bucketstargram.common.Command;
import co.bucketstargram.dao.ReplyDao;

public class AppendReply implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String userId = (String) session.getAttribute("userid");
		String imageId = (String)request.getParameter("imageId");
		String replyCotent = (String)request.getParameter("replyCotent");
		System.out.println("AppendReply.java | imageId = " + imageId);
		System.out.println("AppendReply.java | content = " + replyCotent); 
		System.out.println("AppendReply.java | usersId = " + userId);
		boolean insertSuccess = false;
		
		response.setContentType("text/html;charset=UTF-8");
		ReplyDao dao = new ReplyDao();
		insertSuccess = dao.insert(userId, imageId, replyCotent);
		if(insertSuccess) {
			System.out.println("AppendReply.java | String.valueOf(insertSuccess) = " + String.valueOf(insertSuccess));
			response.getWriter().write(String.valueOf(insertSuccess));
		}
	}
}
