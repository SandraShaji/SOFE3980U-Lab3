package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BinaryController {

    @GetMapping("/")
    public String getDefault(Model model) {
        model.addAttribute("operand1", "");
        model.addAttribute("operand2", "");
        model.addAttribute("operand1Focused", false);
        return "calculator";
    }

    @GetMapping(value="/", params={"operand1"})
    public String getParameter(@RequestParam String operand1, Model model) {
        model.addAttribute("operand1", operand1);
        model.addAttribute("operand2", "");
        model.addAttribute("operand1Focused", true);
        return "calculator";
    }

    @PostMapping("/")
    public String post(
            @RequestParam String operand1,
            @RequestParam String operator,
            @RequestParam String operand2,
            Model model) {

        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);
        Binary result = new Binary("0");

        switch(operator) {
            case "+":
                result = Binary.add(b1, b2);
                break;
            case "*":
                result = Binary.multiply(b1, b2);
                break;
            case "&":
                result = Binary.and(b1, b2);
                break;
            case "|":
                result = Binary.or(b1, b2);
                break;
        }

        model.addAttribute("operand1", operand1);
        model.addAttribute("operand2", operand2);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result.getValue());

        return "result";
    }
}