package com.redehocus.promotions.command;

import com.google.common.collect.ImmutableMap;
import com.redehocus.promotions.PromotionsPlugin;
import com.redehocus.promotions.handler.PromotionHandler;
import com.redehocus.promotions.thread.PromotionFlushThread;
import com.redehocus.promotions.view.PromotionView;
import me.lucko.helper.Schedulers;
import me.saiintbrisson.minecraft.command.annotation.Command;
import me.saiintbrisson.minecraft.command.command.Context;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class MerchantCommand {

    @Command(name = "mercador", aliases = "merchant")
    public void handle(Context<Player> context) {
        PromotionsPlugin.getInstance().getViewFrame().open(PromotionView.class, context.getSender(), ImmutableMap.of("promotion", PromotionHandler.PROMOTION_ITEM));

    }

    @Command(
            name = "mercador.forceupdate",
            aliases = { "merchant.forceupdate" },
            permission = "merchant.admin"
    )
    public void handleUpdate(Context<Player> context) {
        Schedulers.async().runLater(new PromotionFlushThread(), 1, TimeUnit.SECONDS);
        context.sendMessage("§eAtualização forçada realizada com êxito.");

    }

}
