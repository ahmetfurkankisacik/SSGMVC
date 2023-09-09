package com.tpe.controller;

import com.tpe.domain.Teacher;
import com.tpe.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/form")
    public String showTeacherForm(@ModelAttribute("teacher")Teacher teacher){
        return "teacherForm";
    }

    @PostMapping("/saveTeacher")
    public String createTeacher(@Valid @ModelAttribute Teacher teacher, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "teacherForm";
        }
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }

    @GetMapping
    public ModelAndView getTeachers(){
        List<Teacher>teacherList=teacherService.getAllTeachers();
        ModelAndView mav=new ModelAndView();
        mav.addObject("teachers",teacherList);
        mav.setViewName("teachers");
        return mav;
    }

    @GetMapping("/update")
    public String showUptadeForm(@RequestParam("id")Long id, Model model){
        Teacher teacher= teacherService.findTeacherById(id);
        model.addAttribute("teacher",teacher);
        return "teacherForm";
    }
    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable("id")Long id){
        teacherService.deleteTeacher(id);
        return "redirect:/teachers";
    }




}
