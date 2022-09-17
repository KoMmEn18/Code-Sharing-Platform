package platform.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.business.Code;

import java.util.List;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

    List<Code> findFirst10ByOrderByDateDesc();
}

