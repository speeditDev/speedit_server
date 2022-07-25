package speedit.bookplate.jobcategory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import speedit.bookplate.jobcategory.entity.JobCategory;
import speedit.bookplate.user.entity.User;

public interface JobCategoryRepository extends JpaRepository<JobCategory, Long> {
//    Optional<JobCategory> findById(Long id);
}
