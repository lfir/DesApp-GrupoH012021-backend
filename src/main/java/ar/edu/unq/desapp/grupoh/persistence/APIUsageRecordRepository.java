package ar.edu.unq.desapp.grupoh.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoh.model.APIUsageRecord;

@Repository
public interface APIUsageRecordRepository extends JpaRepository<APIUsageRecord, Long> {

}
