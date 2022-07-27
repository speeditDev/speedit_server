package speedit.bookplate.report;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import speedit.bookplate.report.entity.Report;
import speedit.bookplate.user.repositroy.UserRepository;
import speedit.bookplate.user.entity.User;

import java.util.ArrayList;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final UserRepository userRepository;

    private final ReportRepository reportRepository;

    @Transactional
    public void createReport(long userIdx, long targetIdx){
        User user = userRepository.findByUserIdx(userIdx);
        User targetUser = userRepository.findByUserIdx(targetIdx);

        Report report = Report.createReport(user, targetUser);
        reportRepository.save(report);
    }

    public boolean checkReport(User user,long targetIdx){
        ArrayList<Long> target=new ArrayList<>();
        for(Report report:reportRepository.findByMemberUser(user)){
            target.add(report.getTargetUser().getUserIdx());
        }

        if(target.contains(targetIdx)){
            return true;
        }else{
            return false;
        }
    }

}
