package guru.sfg.brewery.beer_service.services.inventory;

import guru.sfg.brewery.model.BeerInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Modified by Pierrot on 2024-08-13.
 */
@FeignClient(name = "inventory-failover")
public interface InventoryFailoverFeignClient {
    @GetMapping("/inventory-failover")
    ResponseEntity<List<BeerInventoryDto>> getOnhandInventory();
}
