package kr.ac.hansung.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.hansung.web.model.Grade;
import kr.ac.hansung.web.service.GradeService;

@Controller
public class GradeController {

	GradeService gradeService = new GradeService();

	@Autowired
	public void setGradeService(GradeService gradeService) {
		this.gradeService = gradeService;
	}

	public GradeService getGradeService() {
		return gradeService;
	}

	// �б⺰ �˻�
	@RequestMapping("/semester")
	public String showbyterms(Model model, Grade grade) {

		model.addAttribute("grades", gradeService.getSumbysemester());

		return "bysemester";
	}

	// �б⺰ �˻�
	@RequestMapping("/division")
	public String showbydivisions(Model model) {

		// model.addAttribute(arg0, arg1)
		model.addAttribute("mandatory1", gradeService.getSumbydivision("����"));
		model.addAttribute("mandatory2", gradeService.getSumbydivision("�ٱ�A") + gradeService.getSumbydivision("�ٱ�B"));
		model.addAttribute("major1", gradeService.getSumbydivision("����"));
		model.addAttribute("major2", gradeService.getSumbydivision("����"));
		model.addAttribute("major3", gradeService.getSumbydivision("����"));

		return "bydivision";
	}

	// �󼼺���
	@RequestMapping("/detailview")
	public String gradeDetail(Model model, Integer year, Integer semester) {
		List<Grade> grades = gradeService.getGrade(year, semester);

		// ����� ���� �ƴ� ���ο� �𵨷� �ʱ�ȭ!
		model.addAttribute("grades", grades); // ���� null Point Error!!

		return "detailview";
	}

	// ��û �׸� ��
	@RequestMapping("/gradesapplied")
	public String showGrades(Model model) {

		List<Grade> grades = gradeService.getApplyGrades();

		// ����� ���� �ƴ� ���ο� �𵨷� �ʱ�ȭ!
		model.addAttribute("grades", grades); // ���� null Point Error!!

		return "gradesapplied";
	}

	@RequestMapping("/applygrade")
	public String applyGrades(Model model) {

		// ����� ���� �ƴ� ���ο� �𵨷� �ʱ�ȭ!
		model.addAttribute("grade", new Grade()); // ���� null Point Error!!

		return "applygrade";
	}

	@RequestMapping("/doapply")
	public String Gradeapplied(Model model, @Valid Grade grade, BindingResult result) {

		// if(model==null) model.addAttribute("grade", new Grade());

		if (result.hasErrors()) {
			System.out.println("From data does validate.");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());

			}
			return "applygrade";
		}
		// service ��ü�� �̿��Ͽ� db�� insert!!
		else {
			gradeService.insert(grade);

			// gradeappied��� jsp���� �̸� ����
			return "applysuccess";
		}
	}
}
