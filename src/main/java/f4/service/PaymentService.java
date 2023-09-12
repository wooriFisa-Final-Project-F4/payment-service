package f4.service;

import f4.dto.EndedAuctionEvent;

public interface PaymentService {

  void requestTransfer(EndedAuctionEvent event);
}
