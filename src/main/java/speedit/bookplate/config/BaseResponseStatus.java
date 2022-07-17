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
    DUPLICATE_NICKNAME(false,407,"중복된 닉네임입니다"),
    JOIN_USER(false,408,"회원가입을 진행해주세요");



    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
