package f4.service.feign.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransferRequestDto {

  private Long arteUserId;
  private String productName;
  private String username;
  private String auctionPrice;
}
