package speedit.bookplate.user.email;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MailService {

    private JavaMailSender javaMailSender;

    public void mailSend(EmailDto emailDto){
        ArrayList<String> toUserList=new ArrayList<>();
        toUserList.add(emailDto.getEmail());

        int toUserSize=toUserList.size();

        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();

        javaMailSender.send(simpleMailMessage);
    }


}
