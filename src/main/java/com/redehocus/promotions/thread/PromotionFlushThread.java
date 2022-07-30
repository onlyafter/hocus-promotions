package com.redehocus.promotions.thread;

import com.redehocus.promotions.handler.PromotionHandler;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.github.paperspigot.Title;

import java.util.concurrent.TimeUnit;

    public class PromotionFlushThread implements Runnable {
        public static long LAST_UPDATE = 0L;

        @Override
        public void run() {

            PromotionHandler.update();

            Bukkit.getOnlinePlayers().forEach(player -> {

                Title title = Title.builder()
                        .fadeOut(20)
                        .fadeIn(20)
                        .stay(40)
                        .title("§e§lMercador atualizado!")
                        .subtitle("§f1 novo produto chegou na loja!")
                        .build();


                player.sendTitle(title);
                player.playSound(player.getLocation(), Sound.CHEST_OPEN, 1, 1);
                player.sendMessage(new String[] {
                        "",
                        "§e§l Mercador atualizado!",
                        "§f Um novo produto chegou na loja",
                        "§f corra para conferir o item.",
                        ""
                });

            });

            LAST_UPDATE = System.currentTimeMillis();

        }
    }
