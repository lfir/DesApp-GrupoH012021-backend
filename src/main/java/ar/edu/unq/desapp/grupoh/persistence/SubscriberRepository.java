package ar.edu.unq.desapp.grupoh.persistence;

import ar.edu.unq.desapp.grupoh.model.AppContent.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{
}
