package speedit.bookplate.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speedit.bookplate.report.entity.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {

}
