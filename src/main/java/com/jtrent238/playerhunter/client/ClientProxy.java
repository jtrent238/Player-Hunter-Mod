package com.jtrent238.playerhunter.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.model.ModelIronGolem;
import net.minecraft.client.model.ModelSheep1;
import net.minecraft.client.model.ModelVillager;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.event.ClickEvent;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatStyle;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jtrent238.playerhunter.common.CommonProxy;
import com.jtrent238.playerhunter.entity.EntityPlayerHunter;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.SideOnly;


public class ClientProxy extends CommonProxy {
  

	
 	
	public void init(FMLInitializationEvent e) {
    super.init (e);

		RenderingRegistry.registerEntityRenderingHandler(EntityPlayerHunter.class, new RenderLiving(new ModelBiped(), 0){protected ResourceLocation getEntityTexture(Entity par1Entity){return new ResourceLocation("playerhunter:EntityPlayerHunter.png");}});

  }
  

  public void postInit(FMLPostInitializationEvent e) {
	 
	  
  }
  
  
  @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
  public void onEvent(PlayerTickEvent event)
  {
    
 
}
}
