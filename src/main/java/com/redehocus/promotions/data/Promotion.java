package com.redehocus.promotions.data;

import io.github.leooowf.customitems.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Promotion {

    private final String identifier;
    private final Item item;
    private final Integer value;
    private final Integer amount;

}
