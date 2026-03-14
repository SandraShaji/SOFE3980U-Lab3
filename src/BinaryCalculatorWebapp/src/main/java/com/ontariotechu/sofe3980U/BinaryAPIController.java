package com.ontariotechu.sofe3980U;

import org.springframework.web.bind.annotation.*;

@RestController
public class BinaryAPIController {

    @GetMapping("/add")
    public String add(@RequestParam String operand1,
                      @RequestParam String operand2) {

        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);

        return Binary.add(b1, b2).getValue();
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam String operand1,
                           @RequestParam String operand2) {

        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);

        return Binary.multiply(b1, b2).getValue();
    }

    @GetMapping("/and")
    public String and(@RequestParam String operand1,
                      @RequestParam String operand2) {

        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);

        return Binary.and(b1, b2).getValue();
    }

    @GetMapping("/or")
    public String or(@RequestParam String operand1,
                     @RequestParam String operand2) {

        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);

        return Binary.or(b1, b2).getValue();
    }

    @GetMapping("/add_json")
    public BinaryResponse addJson(@RequestParam String operand1,
                                  @RequestParam String operand2) {

        Binary b1 = new Binary(operand1);
        Binary b2 = new Binary(operand2);
        Binary result = Binary.add(b1, b2);

        return new BinaryResponse(operand1, operand2, "add", result.getValue());
    }
}