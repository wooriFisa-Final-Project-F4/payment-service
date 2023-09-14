package f4.service.impl;


import static f4.constant.ApiStatus.SUCCESS;

import f4.constant.ApiStatus;
import f4.dto.EndedAuctionEvent;
import f4.global.exception.FeignException;
import f4.service.PaymentService;
import f4.service.feign.WooriMockServiceAPI;
import f4.service.feign.dto.request.TransferRequestDto;
import f4.service.feign.dto.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

  private final WooriMockServiceAPI wooriMockServiceAPI;

  @Override
  public void requestTransfer(EndedAuctionEvent event) {
    TransferRequestDto transferRequest = standByRequest(event);

    log.info("결제 요청 OpenFeign 통신을 시작합니다. {}", transferRequest.toString());
    ApiResponse<?> response = wooriMockServiceAPI.winningBidTransfer(transferRequest);

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
