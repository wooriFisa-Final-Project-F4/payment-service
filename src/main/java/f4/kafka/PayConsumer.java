package f4.kafka;

import f4.dto.EndedAuctionEvent;
import f4.service.PaymentService;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class PayConsumer {

  @Autowired
  private PaymentService paymentService;

  @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(EndedAuctionEvent event) {
    log.info(
        String.format("[%s] [%s] event received in payment service", LocalDateTime.now(), event));

    log.info("{}(고유번호 {}) 님의 낙찰 상품에 대한 결제 요청 처리", event.getUsername(), event.getUserId());
    paymentService.requestTransfer(event);
  }
}
