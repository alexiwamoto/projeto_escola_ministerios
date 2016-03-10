package com.escola.ministerios.repository;

import com.escola.ministerios.domain.Worker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alexandre on 09/03/16.
 */

@Repository
public interface WorkerRepository extends CrudRepository<Worker,Long>{
}
