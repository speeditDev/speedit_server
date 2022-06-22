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
    INVALID_JWT(false,402,"유효하지 않은 JWT입니다.");



    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
