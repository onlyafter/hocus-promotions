package com.redehocus.promotions;

import com.redehocus.promotions.command.MerchantCommand;
import com.redehocus.promotions.hook.EconomyHook;
import com.redehocus.promotions.parser.PromotionParser;
import com.redehocus.promotions.thread.PromotionFlushThread;
import com.redehocus.promotions.view.PromotionView;
import lombok.Getter;
import me.lucko.helper.Schedulers;
import me.saiintbrisson.bukkit.command.BukkitFrame;
import me.saiintbrisson.minecraft.ViewFrame;
import me.saiintbrisson.minecraft.command.message.MessageType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.TimeUnit;

public final class PromotionsPlugin extends JavaPlugin {

    @Getter private static PromotionsPlugin instance;
    @Getter private ViewFrame viewFrame;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {

        viewFrame = ViewFrame.of(this, new PromotionView()).register();
        new EconomyHook().hook(this);
        new PromotionParser().parse();

        Schedulers.builder()
                .async()
                .every(1, TimeUnit.HOURS)
                .run(new PromotionFlushThread());

        BukkitFrame frame = new BukkitFrame(this);
        frame.registerCommands(new MerchantCommand());

        frame.getMessageHolder().setMessage(MessageType.NO_PERMISSION, "§cVocê não tem permissão para gerenciar o mercador.");
        frame.getMessageHolder().setMessage(MessageType.ERROR, "§cAlgo deu errado...");

    }
}
