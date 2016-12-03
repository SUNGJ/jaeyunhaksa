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

	// 학기별 검색
	@RequestMapping("/semester")
	public String showbyterms(Model model, Grade grade) {

		model.addAttribute("grades", gradeService.getSumbysemester());

		return "bysemester";
	}

	// 학기별 검색
	@RequestMapping("/division")
	public String showbydivisions(Model model) {

		// model.addAttribute(arg0, arg1)
		model.addAttribute("mandatory1", gradeService.getSumbydivision("교필"));
		model.addAttribute("mandatory2", gradeService.getSumbydivision("핵교A") + gradeService.getSumbydivision("핵교B"));
		model.addAttribute("major1", gradeService.getSumbydivision("전지"));
		model.addAttribute("major2", gradeService.getSumbydivision("전기"));
		model.addAttribute("major3", gradeService.getSumbydivision("전선"));

		return "bydivision";
	}

	// 상세보기
	@RequestMapping("/detailview")
	public String gradeDetail(Model model, Integer year, Integer semester) {
		List<Grade> grades = gradeService.getGrade(year, semester);

		// 저장된 모델이 아닌 새로운 모델로 초기화!
		model.addAttribute("grades", grades); // 빼면 null Point Error!!

		return "detailview";
	}

	// 신청 항목 보
	@RequestMapping("/gradesapplied")
	public String showGrades(Model model) {

		List<Grade> grades = gradeService.getApplyGrades();

		// 저장된 모델이 아닌 새로운 모델로 초기화!
		model.addAttribute("grades", grades); // 빼면 null Point Error!!

		return "gradesapplied";
	}

	@RequestMapping("/applygrade")
	public String applyGrades(Model model) {

		// 저장된 모델이 아닌 새로운 모델로 초기화!
		model.addAttribute("grade", new Grade()); // 빼면 null Point Error!!

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
		// service 객체를 이용하여 db에 insert!!
		else {
			gradeService.insert(grade);

			// gradeappied라는 jsp파일 이름 리턴
			return "applysuccess";
		}
	}
}
