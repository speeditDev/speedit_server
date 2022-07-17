package speedit.bookplate.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import speedit.bookplate.report.entity.Report;
import speedit.bookplate.user.UserRepository;
import speedit.bookplate.user.entity.User;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    private final UserRepository userRepository;

    public void createReport(long memberUserIdx, long targetUserIdx){
        User memberUser = userRepository.findByUserIdx(memberUserIdx);
        User targetUser = userRepository.findByUserIdx(targetUserIdx);

        Report report = Report.createReport(memberUser, targetUser);
        reportRepository.save(report);
    }



}
