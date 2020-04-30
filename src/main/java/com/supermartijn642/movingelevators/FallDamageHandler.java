package com.supermartijn642.movingelevators;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Created 4/30/2020 by SuperMartijn642
 */
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FallDamageHandler {

    @SubscribeEvent
    public static void onFallDamage(LivingFallEvent e){
        CompoundNBT compound = e.getEntityLiving().getPersistentData();
        if(compound.contains("elevatorTime")){
            if(compound.getLong("elevatorTime") > System.currentTimeMillis() - 5 * 1000)
                e.setCanceled(true);
            else
                compound.remove("elevatorTime");
        }
    }

}
