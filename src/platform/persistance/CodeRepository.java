package platform.persistance;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.business.Code;

import java.util.List;
import java.util.UUID;

@Repository
public interface CodeRepository extends CrudRepository<Code, UUID> {

    List<Code> findFirst10ByTimeRestrictedAndViewsRestrictedOrderByDateDesc(boolean timeRestricted, boolean viewsRestricted);
}

