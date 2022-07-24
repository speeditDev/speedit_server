package speedit.bookplate.scrap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speedit.bookplate.jobcategory.entity.JobCategory;
import speedit.bookplate.scrap.entity.Scrap;

public interface ScrapRepository extends JpaRepository<Scrap, Long> {
//    Optional<JobCategory> findById(Long id);
}
