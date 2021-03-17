package family.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import family.pojo.FamilyMember;

public class DatabaseDao {
	
	Connection connection;
	
	Logger log = Logger.getRootLogger();
	
	public void createMember(FamilyMember member) throws SQLException{
		String sql = "insert into family_members (fname, lname) values (?, ?);";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, member.getFname());
		stmt.setString(2, member.getLname());
		stmt.executeUpdate();
	}
	
	public void attachParents(FamilyMember child, FamilyMember parent1, FamilyMember parent2) {
		
	}
	public void printImmediateFamilyByName(String fname, String lname) throws SQLException{
		//print Parents
		System.out.println("Parents: ");
		String sql = "select fname, lname "
				+ "from family_members "
				+ "where member_id = (select fm.member_id "
									+ "from family_members fm inner join parent_child pc "
									+ "on fm.member_id = pc.child_id"
									+ "where fname = ? and lname = ?);";
		PreparedStatement stmt = connection.prepareStatement(sql);
	}
}
