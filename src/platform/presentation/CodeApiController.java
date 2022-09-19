package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.business.Code;
import platform.business.CodeService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class CodeApiController {

    private final CodeService codeService;

    @Autowired
    public CodeApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code/{uuid}")
    public Code getCode(@PathVariable UUID uuid) {
        Code code = codeService.get(uuid);
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
        code = codeService.save(code);

        return Collections.singletonMap("id", String.valueOf(code.getId()));
    }
}
