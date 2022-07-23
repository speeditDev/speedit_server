package speedit.bookplate.utils;

import org.springframework.validation.Errors;
import speedit.bookplate.config.BaseException;
import speedit.bookplate.config.BaseResponseStatus;

public class ValidationExceptionProvider {

    public static BaseException throwValidError(Errors errors){
        String errorCode=errors.getFieldError().getCode();
        String errorTarget=errors.getFieldError().getField();
        return new BaseException(ValidationExceptionProvider.getExceptionStatus(errorCode,errorTarget));
    }

    public static BaseResponseStatus getExceptionStatus(String code,String target){
        if(code.equals("NotEmpty")){
            if(target.equals("nickname")) return BaseResponseStatus.EMPTY_NICKNAME;
            else if(target.equals("job")) return BaseResponseStatus.POST_EMPTY_JOB;
            else if(target.equals("o_auth_token")) return BaseResponseStatus.POST_EMPTY_OAUTHTOKEN;
        }else if(code.equals("Pattern")){
            if(target.equals("nickname")) return BaseResponseStatus.POST_INVALID_NICKNAME;
        }
        return BaseResponseStatus.RESPONSE_ERROR;
    }
}
