package com.redehocus.promotions.view;

import com.redehocus.promotions.data.Promotion;
import com.redehocus.promotions.hook.EconomyHook;
import com.redehocus.promotions.thread.PromotionFlushThread;
import com.redehocus.promotions.util.CustomItemTranslator;
import com.redehocus.promotions.util.ItemBuilder;
import com.redehocus.promotions.util.NumberUtils;
import com.redehocus.promotions.util.TimeUtils;
import me.saiintbrisson.minecraft.View;
import me.saiintbrisson.minecraft.ViewContext;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class PromotionView extends View {

    public PromotionView() {
        super(3* 9, "Mercador");

        setCancelOnClick(true);
        setCancelOnDrag(true);
        setCancelOnClone(true);
        setCancelOnDrop(true);

    }

    @Override
    protected void onRender(@NotNull ViewContext context) {

        Promotion promotion = context.get("promotion");

        slot(13, ItemBuilder.of(promotion.getItem().rawIcon(), true)
                .name("§a" + CustomItemTranslator.translate(promotion.getIdentifier()))
                .amount(promotion.getAmount())
                .lore(
                        "",
                        "§f Preço: §a" + NumberUtils.format(promotion.getValue()),
                        "",
                        "§aClique para comprar."
                )
                .make())
                .onClick(callback -> {

                    Economy economy = EconomyHook.getEconomy();
                    ItemStack itemStack = promotion.getItem().rawIcon();
                    itemStack.setAmount(promotion.getAmount());

                    if(!economy.has(callback.getPlayer().getName(), promotion.getValue())) {
                        callback.getPlayer().sendMessage("§cVocê não tem coins suficientes para comprar este item.");
                        return;

                    }

                    if(callback.getPlayer().getInventory().firstEmpty() == -1) {
                        callback.getPlayer().sendMessage("§cVocê não tem espaço disponível no inventário.");
                        return;
                    }

                    economy.withdrawPlayer(callback.getPlayer().getName(), promotion.getValue());
                    callback.getPlayer().getInventory().addItem(itemStack);
                    callback.getPlayer().sendMessage("§eYAY! Você comprou " + promotion.getAmount() + "x " + CustomItemTranslator.translate(promotion.getIdentifier()) + " com sucesso.");

                });

    }
}
