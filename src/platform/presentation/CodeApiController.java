package platform.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import platform.business.Code;
import platform.business.CodeService;
import platform.business.EmptyJsonBody;

@RestController
@RequestMapping("/api/")
public class CodeApiController {

    private final CodeService codeService;

    @Autowired
    public CodeApiController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping("/code")
    public Code getCode() {
        return codeService.get();
    }

    @PostMapping("/code/new")
    public ResponseEntity<EmptyJsonBody> postCode(@Validated @RequestBody Code code) {
        codeService.save(code);

        return new ResponseEntity<>(new EmptyJsonBody(), HttpStatus.OK);
    }
}
