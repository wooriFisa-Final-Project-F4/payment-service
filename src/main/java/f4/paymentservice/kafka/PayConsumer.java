package f4.paymentservice.kafka;

import f4.paymentservice.dto.EndedAuctionEvent;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PayConsumer {
  private static final Logger LOGGER = LoggerFactory.getLogger(PayConsumer.class);
  // TODO: 서비스 클래스 호출

  @KafkaListener(topics = "${spring.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
  public void consume(EndedAuctionEvent event) {
    // TODO:consume하여 받아온 event를 처리할 서비스
    LOGGER.info(
        String.format("[%s] [%s] event received in payment service", LocalDateTime.now(), event));
  }
}
