package com.redsea.community.controller;

import com.redsea.community.dto.CommentCreateDTO;
import com.redsea.community.dto.CommentDTO;
import com.redsea.community.dto.QuestionDTO;
import com.redsea.community.exception.CustomizeErrorCode;
import com.redsea.community.exception.CustomizeException;
import com.redsea.community.service.CommentService;
import com.redsea.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") String id, Model model) {
        Long questionId = null;
        try {
            questionId = Long.parseLong(id);
        }catch (NumberFormatException e) {
            throw new CustomizeException(CustomizeErrorCode.INVALID_INPUT);
        }
        QuestionDTO questionDTO = questionService.getById(questionId);
        List<CommentDTO> comments = commentService.listByQuestionId(questionId);
        // 累加阅读数
        questionService.incView(questionId);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        return "question";
    }
}
