package guru.sfg.brewery.inventory_service.repositories;

import guru.sfg.brewery.inventory_service.domain.BeerInventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * Modified by Pierrot on 2024-08-12.
 */
public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {

    List<BeerInventory> findAllByBeerId(UUID beerId);

    List<BeerInventory> findAllByUpc(String upc);
}
