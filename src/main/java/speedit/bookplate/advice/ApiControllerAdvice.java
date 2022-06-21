package speedit.bookplate.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import speedit.bookplate.dto.result.ErrorDetail;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import speedit.bookplate.dto.result.ErrorResponse;


/**
 * exception을 처리하는 advice class
 * Global Exception ApiController 에 만약 핸들러가 있을 경우에는 작동하지 않는다.
 */
@RestControllerAdvice(basePackages = "com.withpet.controller")  //해당 패키지 하위에 있는 예외를 잡는다.
//basePackageClasses = ApiController.class 해당 클래스 에서만 작동하게 됨
public class ApiControllerAdvice {

    /**
     * Rest api 이기 때문에 ResponseEntity 을 return 한다.
     * value 를 통해 내가 어떠한 값을 잡을 것인지 설정
     *
     * @param e : 전체 Exception 정보
     */
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getClass().getName());
        System.out.println("----------------------");
        System.out.println(e.getLocalizedMessage());
        System.out.println("----------------------"); // 지금은 모든 예외(error message)가 body에 담긴다.
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    }

    /**
     * 특정 메소드의 예외를 잡고 싶을 경우
     * HttpServletRequest를 통해 현재 request를 가져올 수 있다.
     *
     * @param e : 특정 메소드의 예외
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest httpServletRequest) {

        List<ErrorDetail> errorList = new ArrayList<>();

        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getAllErrors().forEach(error -> {
            FieldError field = (FieldError) error;
            String fileName = field.getField();
            String message = field.getDefaultMessage();
            String value = field.getRejectedValue().toString();

            ErrorDetail errorMessage = new ErrorDetail();
            errorMessage.setField(fileName);
            errorMessage.setMessage(message);
            errorMessage.setInvalidValue(value);

            errorList.add(errorMessage);
        });

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");

        //해당 에러일 경우 해당 메시지를 보여준다.
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * argument 에러를 잡고싶을 경우
     *
     * @param e : Column 제악조건 에러
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity constraintViolationException(ConstraintViolationException e, HttpServletRequest httpServletRequest) {
        //여러가지 에러를 가지고 있음
        List<ErrorDetail> errorList = new ArrayList<>();

        e.getConstraintViolations().forEach(error -> {

            Stream<Path.Node> stream = StreamSupport.stream(error.getPropertyPath().spliterator(), false);
            List<Path.Node> list = stream.collect(Collectors.toList());

            String field = list.get(list.size() - 1).getName();
            String message = error.getMessage();
            String invalidValue = error.getInvalidValue().toString();

            ErrorDetail errorMessage = new ErrorDetail();
            errorMessage.setField(field);
            errorMessage.setMessage(message);
            errorMessage.setInvalidValue(invalidValue);

            errorList.add(errorMessage);

        });

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorList(errorList);
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * validation 에러를 잡고싶을 경우
     *
     * @param e : validation 에러
     */
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity missingServletRequestParameterException(MissingServletRequestParameterException e, HttpServletRequest httpServletRequest) {

        ErrorDetail errorMessage = new ErrorDetail();
        errorMessage.setField(e.getParameterName());
        errorMessage.setMessage(e.getMessage());

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setRequestUrl(httpServletRequest.getRequestURI());
        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.toString());
        errorResponse.setResultCode("FAIL");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
