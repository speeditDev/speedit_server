package speedit.bookplate.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */

@Getter
public enum BaseResponseStatus {
    /**
     * 200: 요청 성공
     */
    SUCCESS(true,200,"요청에 성공하였습니다."),

    /**
     * 400: REQUEST 오류
     */
    EMPTY_JWT(false,401,"JWT를 입력해주세요"),
    INVALID_JWT(false,402,"유효하지 않은 JWT입니다."),
    DATABASE_ERROR(false,403,"데이터베이스 오류입니다."),
    PASSWORD_ENCRYPTION_ERROR(false,404,"비밀번호 암호화에 실패했습니다"),
    PASSWORD_DECRYPTION_ERROR(false,405,"비밀번호 복화화에 실패했습니다"),
    EMPTY_NICKNAME(false,406,"닉네임을 입력해주세요."),
    POST_INVALID_NICKNAME(false,407,"닉네임 형식이 올바르지 않습니다"),
    DUPLICATE_NICKNAME(false,408,"중복된 닉네임입니다"),
    POST_EMPTY_JOB(false,409,"직업을 입력해주세요"),
    POST_EMPTY_OAUTHTOKEN(false,410,"소셜로그인 토큰값을 입력해주세요"),
    JOIN_USER(false,411,"회원가입을 진행해주세요"),

    /**
     * 500: RESPONSE 오류
     */
    RESPONSE_ERROR(false,500,"값을 불러오는데 실패했습니다.");



    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
