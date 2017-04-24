package com.jtrent238.playerhunter.entity;

import java.util.EnumSet;
import java.util.concurrent.ThreadLocalRandom;

import cpw.mods.fml.common.Loader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.DungeonHooks;

public class EntityPlayerHunter extends EntityGolem implements IBossDisplayData
{
	private static EntityCreature EntityPlayer;
	private static final EntityCreature theEntity = EntityPlayer;
	private static final double speed = 1.2F;
	private static final float maxTargetDistance = 999999999F;
	
	World world = null;
	private int attackTimer;
	public static boolean Halloweenloaded;
    public EntityPlayerHunter(World var1)
    {
        super(var1);
        world = var1;
        experienceValue = 5;
        this.isImmuneToFire = true;
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(theEntity, speed, maxTargetDistance));
        this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.6D, true));
        this.tasks.addTask(4, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(9, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, false, true, IMob.mobSelector));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
        
        this.setCurrentItemOrArmor(0, Items.diamond_sword);
        this.setCurrentItemOrArmor(1, Items.diamond_helmet);
        this.setCurrentItemOrArmor(2, Items.diamond_chestplate);
        this.setCurrentItemOrArmor(3, Items.diamond_leggings);
        this.setCurrentItemOrArmor(4, Items.diamond_boots);
    }
        

   
    private void setCurrentItemOrArmor(int p_70062_1_, Item item) {
		
	}



	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        int randomHealth = ThreadLocalRandom.current().nextInt(10, 1000 + 1);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(randomHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

	
	
    public boolean attackEntityAsMob(Entity p_70652_1_)
    {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));

        if (flag)
        {
            p_70652_1_.motionY += 0.4000000059604645D;
        }

        //this.playSound("", 1.0F, 1.0F);
        this.heal(16);
        return flag;
    }
protected void addRandomArmor(){

}
/*
protected void dropRareDrop(int par1){
this.dropItem(ItemLoader.itemCaptainCookieCookie, 1);
}
*/

/**
 * Drop 0-2 items of this living's type. @param par1 - Whether this entity has recently been hit by a player. @param
 * par2 - Level of Looting used to kill this mob.
 */
protected void dropFewItems(boolean p_70628_1_, int p_70628_2_)
{
	
	
}

	public boolean isAIEnabled()
	{
		   return true;
	}
	   
	/**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }
    
    /**
     * Drop items of this living's type
     */
   /*
    protected void dropFewItems(boolean var1, int var2)
    {
    	this.entityDropItem(new ItemStack(item, 16), 4F);
    }
*/
    

    public void onStruckByLightning(EntityLightningBolt entityLightningBolt){
		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;
		Entity entity = this;
		
	}

	protected void fall(float l){
		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;
		super.fall(l);
		Entity entity = this;
		
	}

	public void onCriticalHit(Entity entity2) {
		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;
		Entity entity = this;
		
	}

	public void onKillEntity(EntityLiving entityLiving){
		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;
		Entity entity = this;
		
	}

	public boolean interact(EntityPlayer entity2){
		int i = (int)this.posX;
		int j = (int)this.posY;
		int k = (int)this.posZ;
		Entity entity = this;
		
		return true;
	}

	public String getEntityName(){
		return "Player Hunter";
	}


/**
* Will return how many at most can spawn in a chunk at once.
*/
public int getMaxSpawnedInChunk()
{
   return 4;
}


}
