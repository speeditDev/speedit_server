package speedit.bookplate.report;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.report.entity.Report;
import speedit.bookplate.user.UserRepository;
import speedit.bookplate.user.entity.User;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final ReportRepository reportRepository;

    private final UserRepository userRepository;

    @Transactional
    public void createReport(long memberUserIdx, long targetUserIdx){
        User memberUser = userRepository.findByUserIdx(memberUserIdx);
        User targetUser = userRepository.findByUserIdx(targetUserIdx);

        Report report = Report.createReport(memberUser, targetUser);
        reportRepository.save(report);
    }



}
