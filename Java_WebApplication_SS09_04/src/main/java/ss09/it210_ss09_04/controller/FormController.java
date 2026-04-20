package ss09.it210_ss09_04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import ss09.it210_ss09_04.model.Form;

@Controller
@RequestMapping("form")
@SessionAttributes("form")
public class FormController {
    @ModelAttribute("form")
    public Form initForm() {
        return new Form();
    }

    @GetMapping("/form1")
    public String step1() {
        return "form1";
    }

    @PostMapping("/form1")
    public String handleStep1(@ModelAttribute("form") Form form) {
        return "redirect:/form/form2";
    }

    @GetMapping("/form2")
    public String form2() {
        return "form2";
    }

    @PostMapping("/form2")
    public String handleStep2(@ModelAttribute("form") Form form) {
        return "redirect:/form/form3";
    }

    @GetMapping("/form3")
    public String form3() {
        return "form3";
    }

    @PostMapping("/complete")
    public String complete(
            @ModelAttribute("form") Form form,
            SessionStatus status
    ) {
        System.out.println("Saved form:");
        System.out.println(form.getFullName());
        System.out.println(form.getEmail());
        System.out.println(form.getPhone());
        System.out.println(form.getShopName());
        System.out.println(form.getAddress());

        status.setComplete();

        return "success";
    }
}