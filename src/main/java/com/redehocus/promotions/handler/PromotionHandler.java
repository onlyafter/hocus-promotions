package com.redehocus.promotions.handler;

import com.google.common.collect.Lists;
import com.redehocus.promotions.data.Promotion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
public class PromotionHandler {

    public static final List<Promotion> PROMOTIONS = Lists.newArrayList();
    @Setter public static Promotion PROMOTION_ITEM;

    public static void update() {

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int index = random.nextInt(PROMOTIONS.size());

        PROMOTION_ITEM = PROMOTIONS.get(index);

    }


}
