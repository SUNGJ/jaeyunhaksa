package kr.ac.hansung.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.web.model.Grade;

@Repository
public class GradeDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	public void setDataSource(DataSource dateSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dateSource);
	}

	// DB call method
	// 현재 레코드 수 카운트
	public int getRowCount() {
		String sqlStatement = "select count(*) from grade";

		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class);

	}

	public List<Grade> getSumbysemester() {

		String sqlStatement = "select year, semester, sum(point) from grade group by year, semester";
		List<Grade> grades = jdbcTemplateObject.query(sqlStatement, new RowMapper<Grade>() {
			@Override
			public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
				Grade grade = new Grade();

				grade.setYear(rs.getInt("year"));
				grade.setSemester(rs.getInt("semester"));
				grade.setPoint(rs.getInt("SUM(point)"));

				return grade;
			}
		});

		return grades;
	}

	public int getSumbydivision(String division) {

		String sqlStatement = "select sum(point) from grade where division=?";

		return jdbcTemplateObject.queryForObject(sqlStatement, Integer.class, division);
	}

	public List<Grade> getGrade(Integer year, Integer semester) {

		String sqlStatement = "select * from grade where year=? and semester=?";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Offer객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.query(sqlStatement, new Object[] { year, semester }, new GradeMapper());

	}

	// querying and returning a single object
	public Grade getGrade(String name) {
		String sqlStatement = "select * from grade where name=?";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Offer객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new GradeMapper());
	}

	// querying and returning a multiple object
	public List<Grade> getGrade() { // Offer의 list를 넘겨줌
		String sqlStatement = "select * from grade";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Offer객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.query(sqlStatement, new GradeMapper());
	}

	// querying and returning a single object
	public Grade getApplyGrades(String name) {
		String sqlStatement = "select * from application where name=?";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Offer객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.queryForObject(sqlStatement, new Object[] { name }, new GradeMapper());
	}

	public List<Grade> getApplyGrades() { // Offer의 list를 넘겨줌
		String sqlStatement = "select * from application";
		// ? : place holder 인자로 받은 값을 넣음 (name)

		// Object로 넘겨주기 의해 place holder(?)로 저장한 name을 Object배열에 저장하여 초기화
		// 레코드를 DB에서 select할 때 Offer객체와 결과를 맵핑해줘야 함 (RowMapperd을 통해)
		return jdbcTemplateObject.query(sqlStatement, new GradeMapper());
	}

	public boolean insert(Grade grade) {

		Integer year = grade.getYear();
		Integer semester = grade.getSemester();
		String code = grade.getCode();
		String name = grade.getName();
		String division = grade.getDivision();
		Integer point = grade.getPoint();

		String sqlStatement = "insert into application (year, semester, code, name, division, point) values (?,?,?,?,?,?)";

		// 몇개가 update됐는지 갯수가 return
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, division, point }) == 1);

	}

	public boolean update(Grade grade) {

		int year = grade.getYear();
		int semester = grade.getSemester();
		String code = grade.getCode();
		String name = grade.getName();
		String division = grade.getDivision();
		int point = grade.getPoint();

		String sqlStatement = "update grades set name=?, email=?, text=? where id=?";

		// 몇개가 update됐는지 갯수가 return
		return (jdbcTemplateObject.update(sqlStatement,
				new Object[] { year, semester, code, name, division, point }) == 1);

	}

	public boolean delete(Integer id) {

		String sqlStatement = "delete from grade where id=?";

		// 몇개가 update됐는지 갯수가 return
		return (jdbcTemplateObject.update(sqlStatement, new Object[] { id }) == 1);

	}
}
