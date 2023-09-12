package f4.global.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Slf4j
@EnableWebMvc
@RestControllerAdvice
public class GlobalExceptionHandler {

  // Custom Error Exception
  @ExceptionHandler(CustomException.class)
  protected ResponseEntity<?> handleCustomErrorException(CustomException e) {
    log.error("API 요청 중 에러가 발생했습니다. ErrorCode : {}, ErrorMessage : {}",
        e.getCustomErrorCode().getCode(), e.getCustomErrorCode().getMessage());
    return ResponseEntity.badRequest()
        .body(
            ErrorDetails.builder()
                .code(e.getCustomErrorCode().getCode())
                .message(e.getCustomErrorCode().getMessage())
                .build());
  }

  @ExceptionHandler(FeignException.class)
  public ResponseEntity<?> feignExceptionHandler(FeignException e) {
    log.error("ErrorCode : {}, ErrorMessage : {}, detail : {}", 500, e.getMessage(), e.getObject());

    return new ResponseEntity<>(
        ErrorDetails.builder()
            .code(500)
            .message((String) e.getObject())
            .build()
        , HttpStatus.BAD_REQUEST);
  }
}
