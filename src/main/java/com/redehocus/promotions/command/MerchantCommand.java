package com.redehocus.promotions.command;

import com.google.common.collect.ImmutableMap;
import com.redehocus.promotions.PromotionsPlugin;
import com.redehocus.promotions.handler.PromotionHandler;
import com.redehocus.promotions.view.PromotionView;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.entity.Player;

public class MerchantCommand {

    @Command(name = "mercador")
    public void handle(Context<Player> context) {
        PromotionsPlugin.getInstance().getViewFrame().open(PromotionView.class, context.getSender(), ImmutableMap.of("promotion", PromotionHandler.PROMOTION_ITEM));

    }

}
