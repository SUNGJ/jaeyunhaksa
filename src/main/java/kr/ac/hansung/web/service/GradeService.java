package kr.ac.hansung.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.web.dao.GradeDAO;
import kr.ac.hansung.web.model.Grade;

@Service
public class GradeService {

	// DAO use
	private GradeDAO gradeDao;

	@Autowired
	public void setGradeDao(GradeDAO gradeDao) {
		this.gradeDao = gradeDao;
	}

	public List<Grade> getApplyGrades() {
		return gradeDao.getApplyGrades();
	}

	public int getSumbydivision(String division) {
		// TODO Auto-generated method stub
		
		return gradeDao.getSumbydivision(division);

	}
	
	public List<Grade> getSumbysemester( ) {
		// TODO Auto-generated method stub
		
		return gradeDao.getSumbysemester();

	}

	public void insert(Grade grade) {

		gradeDao.insert(grade);

	}

	public List<Grade> getGrade(Integer year, Integer semester) {
		// TODO Auto-generated method stub
		return gradeDao.getGrade(year, semester);
	}



}
