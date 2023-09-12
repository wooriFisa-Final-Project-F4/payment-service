package f4.service.feign;


import f4.service.feign.dto.request.TransferRequestDto;
import f4.service.feign.dto.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient(value = "Mock", url = "${woori.mock}")
public interface MockServiceImpl {

  @PutMapping("/winning/bid-transfer")
  ApiResponse<?> winningBidTransfer(@RequestBody TransferRequestDto transferRequestDto);
}
