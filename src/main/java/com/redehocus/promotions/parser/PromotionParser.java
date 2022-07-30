package com.redehocus.promotions.parser;

import com.redehocus.promotions.data.Promotion;
import com.redehocus.promotions.handler.PromotionHandler;
import io.github.leooowf.customitems.items.registry.ItemRegistry;
import io.github.leooowf.customitems.model.Item;

public class PromotionParser {

    public void parse() {

        Item launcher = ItemRegistry.getItem("customitem_launcher");
        Item blackHole = ItemRegistry.getItem("customitem_blackhole");
        Item divineBonus = ItemRegistry.getItem("customitem_divinebonus");
        Item grapplingHook = ItemRegistry.getItem("customitem_grapplinghook");
        Item trap = ItemRegistry.getItem("customitem_trap");

        PromotionHandler.PROMOTIONS.add(new Promotion(launcher.identifier(), launcher, 375000, 8));
        PromotionHandler.PROMOTIONS.add(new Promotion(blackHole.identifier(), blackHole, 750000, 1));
        PromotionHandler.PROMOTIONS.add(new Promotion(divineBonus.identifier(), divineBonus, 178500, 3));
        PromotionHandler.PROMOTIONS.add(new Promotion(grapplingHook.identifier(), grapplingHook, 975000, 1));
        PromotionHandler.PROMOTIONS.add(new Promotion(trap.identifier(), trap, 375000, 3));

    }

}
