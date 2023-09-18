package f4.service.feign.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDto {

  private Long arteUserId;
  private String productName;
  private String username;
  private String auctionPrice;
}
