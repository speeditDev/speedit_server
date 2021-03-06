package speedit.bookplate.report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import speedit.bookplate.report.entity.Report;
import speedit.bookplate.user.entity.User;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {

    List<Report> findByMemberUser(User user);

}
