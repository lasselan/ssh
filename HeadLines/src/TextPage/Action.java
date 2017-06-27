package TextPage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.user.ColumnUser;
@WebServlet("/page")
public class Action extends HttpServlet{


	private static final long serialVersionUID = 1L;
	private dao dao = new dao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 String npage = req.getParameter("newPage");
		 List<ColumnUser> page=dao.selectall(new Integer(npage));
		 int count=dao.getCount();
		 int countpage=dao.getCountPage();
		 req.setAttribute("page", page);
		 req.setAttribute("npage", npage);
		 req.setAttribute("count", count);
		 req.setAttribute("countpage", countpage);
		 req.getRequestDispatcher("/page.jsp").forward(req, resp);
	}
}
