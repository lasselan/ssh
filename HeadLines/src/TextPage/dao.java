package TextPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mashen.jdbc.ConnectionDao;
import com.mashen.user.ColumnUser;

public class dao {
	private static final Integer size = 3;
	private Integer count = 0;
	private Integer page;
	private String url = "select count(*) as con from colu";

	public Integer getCount() {
		try {
			Connection conn = ConnectionDao.getconnection();
			PreparedStatement stat = conn.prepareStatement(url);
			ResultSet rs = stat.executeQuery();
			if (rs.next()) {
				count = rs.getInt("con");
			}
			this.page = ((count % size) != 0 ? (count / size + 1) : (count / size));
			if (conn != null) {
				conn.close();
			}
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	public Integer getCountPage() {
		return page;
	}

	public List<ColumnUser> selectall(Integer newPage) {
		List<ColumnUser> list = new ArrayList<ColumnUser>();
		try {
			Connection conn = ConnectionDao.getconnection();
			PreparedStatement stat = conn.prepareStatement("select * from colu limit ?,?");
			stat.setObject(1,(newPage-1)*size);
			stat.setObject(2,size);
			ResultSet rs = stat.executeQuery();
			while (rs.next()) {
				ColumnUser column = new ColumnUser();
				column.setPid(rs.getInt("pid"));
				column.setCatname(rs.getString("catname"));
				list.add(column);
			}
			 
			if (conn != null) {
				conn.close();
			}
			stat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) {
		dao imp = new dao();
//		imp.getCount();
//		imp.getCountPage();
		imp.selectall(1);
	}
}
