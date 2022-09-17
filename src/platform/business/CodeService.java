package platform.business;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
public class CodeService {

    private ConcurrentMap<Long, Code> codes = new ConcurrentHashMap<>();

    public long save(Code code) {
        code.setDate(LocalDateTime.now());
        long id = codes.size() + 1;
        codes.put(id, code);

        return id;
    }

    public Code get(long id) {
        return codes.getOrDefault(id, null);
    }

    public List<Code> getLatest() {
        return codes.values().stream()
                .sorted(Comparator.comparing(Code::getDate).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
