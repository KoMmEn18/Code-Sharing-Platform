package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.business.Code;
import platform.business.CodeService;

@Controller
public class CodeWebController {

    private final CodeService codeService;

    @Autowired
    public CodeWebController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public String getCode(@PathVariable int id, Model model) {
        Code code = codeService.get(id);
        if (code == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code of given id not found");
        }
        model.addAttribute("code", code);

        return "code";
    }

    @GetMapping("/code/latest")
    public String getLatest(Model model) {
        model.addAttribute("codes" , codeService.getLatest());

        return "code-latest";
    }

    @GetMapping("/code/new")
    public String postCode() {
        return "code-new";
    }
}
