package platform.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.persistance.CodeRepository;

import java.util.List;

@Service
public class CodeService {

    private CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code save(Code code) {
        return codeRepository.save(code);
    }

    public Code get(long id) {
        return codeRepository.findById(id).orElse(null);
    }

    public List<Code> getLatest() {
        return codeRepository.findFirst10ByOrderByDateDesc();
    }
}
