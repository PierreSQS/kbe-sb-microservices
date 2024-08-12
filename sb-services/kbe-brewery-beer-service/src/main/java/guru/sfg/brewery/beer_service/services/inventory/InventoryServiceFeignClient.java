package guru.sfg.brewery.beer_service.services.inventory;

import guru.sfg.brewery.beer_service.config.FeignClientConfig;
import guru.sfg.brewery.model.BeerInventoryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

/**
 * Modified by Pierrot on 2024-08-13.
 */
@Profile({"local-discovery", "digitalocean"})
@FeignClient(name = "inventory-service", fallback = InventoryFailoverService.class, configuration = FeignClientConfig.class)
public interface InventoryServiceFeignClient {

    @GetMapping(BeerInventoryServiceRestTemplateImpl.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnhandInventory(@PathVariable UUID beerId);
}
