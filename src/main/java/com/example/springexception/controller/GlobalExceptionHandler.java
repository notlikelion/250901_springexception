package com.example.springexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Random;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("message", "잘못된 포맷의 주소입니다. 숫자로 입력해주세요~");
        return "error/custom-error";
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        model.addAttribute("message", "데이터의 수를 넘겼습니다~");
        return "error/custom-error";
    }
    @ExceptionHandler(Exception.class)
    public String handleIllegalArgumentException(Exception ex, Model model) {
        model.addAttribute("message", "이건 나도 잘 모르겠다~~~");
        return "error/custom-error";
    }
}
