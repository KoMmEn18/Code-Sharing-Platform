package platform.business;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CodeService {

    private Code code = new Code("", LocalDateTime.now());

    public void save(Code code) {
        code.setDate(LocalDateTime.now());
        this.code = code;
    }

    public Code get() {
        return code;
    }
}
