package speedit.bookplate.user.email;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class MailController {

    private final MailService mailService;

    @PostMapping("/email")
    public void execMail(EmailDto emailDto){
        mailService.mailSend(emailDto);
    }

}
