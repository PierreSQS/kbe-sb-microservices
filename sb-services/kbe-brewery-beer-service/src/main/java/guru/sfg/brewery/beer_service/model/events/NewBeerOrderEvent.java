package guru.sfg.brewery.beer_service.model.events;

import guru.sfg.brewery.beer_service.model.BeerOrderDto;
import org.springframework.context.ApplicationEvent;

public class NewBeerOrderEvent extends ApplicationEvent {

    public NewBeerOrderEvent(BeerOrderDto source) {
        super(source);
    }

    public BeerOrderDto getBeerOrder(){
        return (BeerOrderDto) this.source;
    }
}
