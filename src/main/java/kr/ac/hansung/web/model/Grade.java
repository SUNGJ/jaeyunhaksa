package kr.ac.hansung.web.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Grade {
	private int id;

	@NotNull(message = "�����⵵�� �Է����ּ���.")
	private int year;
	@Max(value = 10, message = "�����б⸦ Ȯ���� �ּ���.")
	@Min(value = 1, message = "�����б⸦ Ȯ���� �ּ���.")
	@NotNull(message = "�����б⸦ �Է����ּ���.")
	private int semester;
	@Size(min = 7, max = 7, message = "�����ڵ�� 7���Դϴ�.")
	@NotEmpty(message = "���� �ڵ带 �Է����ּ���.")
	private String code;
	@NotEmpty(message = "����� �Է����ּ���.")
	private String name;
	@NotEmpty(message = "���� �������ּ���.")
	private String division;
	@Max(value = 10, message = "������ Ȯ���� �ּ���.")
	@Min(value = 1, message = "������ Ȯ���� �ּ���.")
	@NotNull(message = "���� �Է����ּ���.")
	private int point;

	public Grade() {

	}

	public Grade(int year, int semester, String code, String name, String division, int point) {
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.division = division;
		this.point = point;
	}

	public Grade(int id, int year, int semester, String code, String name, String division, int point) {
		this.id = id;
		this.year = year;
		this.semester = semester;
		this.code = code;
		this.name = name;
		this.division = division;
		this.point = point;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String toString() {
		return "grade [id=" + id + ", year=" + year + ", semester=" + semester + ", code=" + code + ", name=" + name
				+ ", division=" + division + ", point=" + point + "]";
	}
}
