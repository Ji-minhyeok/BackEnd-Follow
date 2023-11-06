package gdsc.doorian.repository;

import gdsc.doorian.entity.Create;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CreateRepository extends CrudRepository<Create,Long> {
    @Override
    ArrayList<Create> findAll();
}

