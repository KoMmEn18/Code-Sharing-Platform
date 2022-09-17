package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.business.Code;
import platform.business.CodeService;
import platform.business.EmptyJsonBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class CodeApiController {

    private final CodeService codeService;

    @Autowired
    public CodeApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{id}")
    public Code getCode(@PathVariable int id) {
        Code code = codeService.get(id);
        if (code == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Code of given id not found");
        }

        return code;
    }

    @GetMapping("/code/latest")
    public List<Code> getLatest() {
        return codeService.getLatest();
    }

    @PostMapping("/code/new")
    public Map<String, String> postCode(@Validated @RequestBody Code code) {
        long id = codeService.save(code);

        return Collections.singletonMap("id", String.valueOf(id));
    }
}
