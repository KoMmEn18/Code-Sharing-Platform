package platform.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import platform.persistance.CodeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CodeService {

    private CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public Code save(Code code) {
        code.setTimeRestricted(code.getTime() != 0);
        code.setViewsRestricted(code.getViews() != 0);
        return codeRepository.save(code);
    }

    public Code get(UUID id) {
        Code code = codeRepository.findById(id).orElse(null);
        if (code != null) {
            if (code.isViewsRestricted()) {
                int newViews = code.getViews() - 1;
                code.setViews(newViews);
                if (newViews == 0) {
                    codeRepository.delete(code);
                } else {
                    codeRepository.save(code);
                }
            }
            if (code.isTimeRestricted()) {
                long secondsLeft = code.getTimeLeft();
                if (secondsLeft <= 0) {
                    codeRepository.delete(code);
                    code = null;
                }
            }
        }
        return code;
    }

    public List<Code> getLatest() {
        return codeRepository.findFirst10ByTimeRestrictedAndViewsRestrictedOrderByDateDesc(false, false);
    }
}
