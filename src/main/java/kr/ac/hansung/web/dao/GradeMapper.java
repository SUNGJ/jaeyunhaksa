package kr.ac.hansung.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import kr.ac.hansung.web.model.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

		Grade grade = new Grade();

		grade.setYear(rs.getInt("year"));
		grade.setSemester(rs.getInt("semester"));
		grade.setCode(rs.getString("code"));
		grade.setName(rs.getString("name"));
		grade.setDivision(rs.getString("division"));
		grade.setPoint(rs.getInt("point"));

		return grade;
	}
}