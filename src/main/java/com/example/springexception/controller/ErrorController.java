package com.example.springexception.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Random;

@Controller
@RequestMapping("/data")
public class ErrorController {
    @GetMapping("/{id}") // {}
    public String detail(@PathVariable Long id) throws Exception {
        // 1 : 숫자가 아닌 거가 오면 문제가 생김
        // http://localhost:8080/data/hello
        // -> MethodArgumentTypeMismatchException
        // 2 : 100번까지만 있다
        // http://localhost:8080/data/101
        // IllegalArgumentException
        if (id > 100) {
            throw new IllegalArgumentException("접속할 수 없는 ID 입니다. " + id);
        }
        // 3: 그냥 랜덤
        // http://localhost:8080/data/1
        // Exception
        Random rd = new Random();
        if (rd.nextBoolean()) throw new Exception("알 수 없는 에러");
        return "redirect:/";
    }

    // Controller 단위로 먼저 붙여줄 수 있음
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
