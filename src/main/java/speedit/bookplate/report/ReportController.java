package speedit.bookplate.report;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponse;
import speedit.bookplate.report.dto.ReportDto;
import speedit.bookplate.user.entity.User;
import speedit.bookplate.user.repositroy.UserRepository;
import speedit.bookplate.utils.JwtService;

@Controller
@AllArgsConstructor
@RequestMapping("/report")
public class ReportController {

    private ReportService reportService;

    private UserRepository userRepository;

    private JwtService jwtService;

    @PostMapping("")
    @ResponseBody
    public BaseResponse<String> createReport(@RequestBody ReportDto reportDto){
        try{
            long userIdx=jwtService.getUserIdx();
            User memberUser = userRepository.findByUserIdx(userIdx);
            if(reportService.checkReport(memberUser,reportDto.getTargetIdx())){
                return new BaseResponse<>("이미 신고가 된 유저입니다.");
            }else{
                reportService.createReport(userIdx,reportDto.getTargetIdx());
                return new BaseResponse<>("유저 신고하기 성공");
            }
        }catch(BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

}
