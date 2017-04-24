package com.jtrent238.playerhunter;

import com.jtrent238.playerhunter.entity.EntityPlayerHunter;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;

public class EntityLoader {


	public static EntityLivingBase EntityPlayerHunter;

	public static void LoadEntitys() {
		
	    EntityRegistry.registerGlobalEntityID(EntityPlayerHunter.class, "EntityPlayerHunter",EntityRegistry.findGlobalUniqueEntityId(), 0xca0605, 0x000000);
	    //EntityRegistry.addSpawn(EntityPlayerHunter.class, 2, 4, 6, EnumCreatureType.creature, BiomeGenBase.getBiomeGenArray());
	    RenderingRegistry.registerEntityRenderingHandler(EntityPlayerHunter.class, new RenderLiving(new ModelBiped(), 0){protected ResourceLocation getEntityTexture(Entity par1Entity){return new ResourceLocation("playerhunter:EntityPlayerHunter.png");}});

	}
}
