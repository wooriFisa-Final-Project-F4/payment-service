package f4.service.impl;


import static f4.constant.ApiStatus.SUCCESS;

import f4.constant.ApiStatus;
import f4.dto.EndedAuctionEvent;
import f4.global.exception.FeignException;
import f4.service.PaymentService;
import f4.service.feign.MockServiceAPI;
import f4.service.feign.dto.request.TransferRequestDto;
import f4.service.feign.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

  private final MockServiceAPI mockService;

  @Override
  public void requestTransfer(EndedAuctionEvent event) {
    TransferRequestDto requestDto = standByRequest(event);
    ApiResponse<?> response = mockService.winningBidTransfer(requestDto);

    if (SUCCESS != ApiStatus.of(response.getStatus())) {
      throw new FeignException(response.getError());
    }
  }

  private TransferRequestDto standByRequest(EndedAuctionEvent event) {
    return TransferRequestDto.builder()
        .arteUserId(event.getUserId())
        .username(event.getUsername())
        .productName(event.getProductName())
        .auctionPrice(event.getAuctionPrice())
        .build();
  }
}
