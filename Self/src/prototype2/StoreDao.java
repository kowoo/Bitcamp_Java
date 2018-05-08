package prototype2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreDao {
	Connection connect;
	
	public void insertStore(Store store) {
		PreparedStatement pstmt=null;
		try {
			connect = ConnectionProvider.getConnection();
			String sql = "insert into store values(?,?,?,?)";
			pstmt = connect.prepareStatement(sql);
			
			pstmt.setInt(1, store.getNum());
			pstmt.setString(2, store.getName());
			pstmt.setInt(3, store.getPrice());
			pstmt.setInt(4, store.getScore());
			pstmt.executeUpdate();			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connect!=null) connect.close();
				if (pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		selectAll();
		
//		PreparedStatement pstmt2 = null;
//		List<Store> storeList = new ArrayList<Store>();
//		ResultSet rs = null;
//		
//		try {
//			connect = ConnectionProvider.getConnection();
//			String sql = "select * from store";
//			pstmt = connect.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			while(rs.next()) {
//				Store store2 = new Store();
//				store.setNum(rs.getInt("num"));
//				store.setName(rs.getString("name"));
//				store.setPrice(rs.getInt("price"));
//				store.setScore(rs.getInt("score"));
//				storeList.add(store);
//			}
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				if (rs  != null) rs.close();
//				if (pstmt2 != null) pstmt2.close();
//				if (connect != null) connect.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return storeList;
	}
	
	public void updateStore(Store store) {
		PreparedStatement pstmt=null;
		
		try {
			connect = ConnectionProvider.getConnection();
			String sql = "update store"
					+ "      set name = ?,"
					+ "         price = ?,"
					+ "         score = ?"
					+ "     where num = ?";
			pstmt = connect.prepareStatement(sql);
			
			pstmt.setString(1, store.getName());
			pstmt.setInt(2, store.getPrice());
			pstmt.setInt(3, store.getScore());
			pstmt.setInt(4, store.getNum());
			pstmt.executeUpdate();	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (connect != null) connect.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		selectAll();
	}
	
	public void deleteStore(int num) {
		PreparedStatement pstmt = null;
		
		try {
			connect = ConnectionProvider.getConnection();
			String sql = "delete from store where num = ?";
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (connect != null) connect.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		selectAll();
	}
	
	public Store selectOne(int num) {
		PreparedStatement pstmt = null;
		Store store = null;
		ResultSet rs = null;
		
		try {
			// 연결얻어오기
			connect = ConnectionProvider.getConnection();
			String sql = "select * from store where num = ?";
			pstmt = connect.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				store = new Store();
				store.setNum(rs.getInt("num"));
				store.setName(rs.getString("name"));
				store.setPrice(rs.getInt("price"));
				store.setScore(rs.getInt("score"));	
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs  != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (connect != null) connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return store;
	}
	
	public List<Store> selectAll() {
		PreparedStatement pstmt = null;
		List<Store> storeList = new ArrayList<Store>();
		ResultSet rs = null;
		
		try {
			connect = ConnectionProvider.getConnection();
			String sql = "select * from store order by num";
			pstmt = connect.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Store store = new Store();
				store.setNum(rs.getInt("num"));
				store.setName(rs.getString("name"));
				store.setPrice(rs.getInt("price"));
				store.setScore(rs.getInt("score"));
				storeList.add(store);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if (connect!=null) connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return storeList;
	}
	
	
}
