package f4.global.exception.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CustomErrorCode {

  // Not Found 404
  INVALID_STATUS_CODE(404, "해당 상태 코드는 존재하지 않습니다."),

  // Server Error
  FEIGN_FAILED_ERROR(500, "외부 Feign 통신 중 에러가 발생했습니다.")
  ;

  private final int code;
  private final String message;
}
