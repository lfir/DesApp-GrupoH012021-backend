package ar.edu.unq.desapp.grupoh.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unq.desapp.grupoh.model.APIUsageRecord;

@Repository
public interface APIUsageRecordRepository extends JpaRepository<APIUsageRecord, Long> {
	@Query("SELECT r FROM APIUsageRecord r WHERE r.platformName = :platformName")
	List<APIUsageRecord> findByName(String platformName);
}
