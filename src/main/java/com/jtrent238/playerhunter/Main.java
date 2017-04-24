package com.jtrent238.playerhunter;

import com.jtrent238.playerhunter.common.CommonProxy;
import com.jtrent238.playerhunter.entity.EntityPlayerHunter;
import com.jtrent238.playerhunter.client.ClientProxy;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import net.minecraft.command.ICommandManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

@Mod(modid=Main.MODID, name=Main.MODNAME, version=(Main.MODVERSION))
//@MeddleMod(id=Main.MODID, name=Main.MODNAME, version=(Main.MODVERSION), author=Main.MODAUTHOR)
public class Main
{

	
	@SidedProxy(clientSide="com.jtrent238.playerhunter.client.ClientProxy", serverSide="com.jtrent238.playerhunter.common.CommonProxy")
	public static CommonProxy proxy;
	
	
	public static final String MODID = "playerhunter";

	@Instance(MODID)
    public static Main instance;
	public static final String MODVERSION = "pre-1.0.0.0";
	public static final String MODNAME = "jtrent238's Player Hunter Mod";
	public static final String MODAUTHOR = "jtrent238";
	public static final String MC = "1.7.10";


	private boolean HCloaded;


	@ForgeSubscribe(priority = EventPriority.NORMAL)
    public void eventHandler(RenderGameOverlayEvent event) {

	}
	
	
@Mod.EventHandler
public void preInit(FMLPreInitializationEvent event)
{
	
}



@Mod.EventHandler
public void init(FMLInitializationEvent event)
{
	proxy.init(event);
	
	
	//ItemLoader.LoadItems();
	//BlockLoader.loadBlocks();
	//Recipes.registerRecpies();
	EntityLoader.LoadEntitys();
	//OreDict.addores();
	//Achievements.loadAchievements();
	//Stats.RegisterStats();
}


public static CreativeTabs PlayerHunter = new CreativeTabs("PlayerHunter")

{
	public Item getTabIconItem() {

		return new ItemStack(Items.diamond_sword).getItem();
	}
	public boolean hasSearchBar(){
		return false;
	}
	/*
	@SideOnly(Side.CLIENT)
	public String getBackgroundImageName() 
	{
		return "EpicProportionsMod_Halloween.png";
	}
	
	@SideOnly(Side.CLIENT)
	public boolean drawInForegroundOfTab() 
	{
		return false;
	}
	*/
	}
	
;









@Mod.EventHandler
public void postInit(FMLPostInitializationEvent event) {
	{
		
	    //Recipes.registerRecpies();

		HCloaded = Loader.isModLoaded("headcrumbs");
		
		if (HCloaded){
			
		//ganymedes01.headcrumbs.utils.HeadUtils.getHeadfromEntity(EntityLoader.EntityPlayerHunter);
		ganymedes01.headcrumbs.utils.HeadUtils.createHeadFor(MODAUTHOR);
	
		}
	}
}


@EventHandler
public void serverStart(FMLServerStartingEvent event)
{
     MinecraftServer server = MinecraftServer.getServer();
     // Get's the current server instance
     
     ICommandManager command = server.getCommandManager();
     //ServerCommandManager manager = (ServerCommandManager) command;
     
     //manager.registerCommand(new CommandModInfo());
     //manager.registerCommand(new CommandChangelog());
}

					
}
