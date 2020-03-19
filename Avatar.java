package me.TijelaPvP.kits;

import java.util.ArrayList;
import java.util.List;

import me.TijelaPvP.Main;
import me.TijelaPvP.uteis.KitAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

public class Avatar implements Listener {
	
	ArrayList<Snowball> Soltou = new ArrayList();
	  public int id1;
	  ArrayList<Snowball> Soltou1 = new ArrayList();
	  public int id11;
	  public static ArrayList<String> Avatar2 = new ArrayList();
	  public static ArrayList<String> Ferro = new ArrayList();
	  public static ArrayList<String> Red = new ArrayList();
	  public static ArrayList<String> Terras = new ArrayList();
	  public static List<Player> Tempo = new ArrayList();
	  
	  @EventHandler
	  public void Trocar(PlayerInteractEvent e)
	  {
	    Player p = e.getPlayer();
	    
	    ItemStack Terra = new ItemStack(Material.GRASS);
	    ItemMeta terram = Terra.getItemMeta();
	    terram.setDisplayName(ChatColor.DARK_GREEN + "Terra");
	    Terra.setItemMeta(terram);
	    
	    ItemStack Agua = new ItemStack(Material.LAPIS_BLOCK);
	    ItemMeta Aguam = Agua.getItemMeta();
	    Aguam.setDisplayName(ChatColor.DARK_AQUA + "Agua");
	    Agua.setItemMeta(Aguam);
	    
	    ItemStack Aguac = new ItemStack(Material.BEACON);
	    ItemMeta Aguacm = Aguac.getItemMeta();
	    Aguacm.setDisplayName(ChatColor.DARK_AQUA + "B");
	    Aguac.setItemMeta(Aguacm);
	    
	    ItemStack AR = new ItemStack(Material.WOOL);
	    ItemMeta ARm = AR.getItemMeta();
	    ARm.setDisplayName("AR");
	    AR.setItemMeta(ARm);
	    
	    ItemStack Fogo = new ItemStack(Material.REDSTONE_BLOCK);
	    ItemMeta Fogom = Fogo.getItemMeta();
	    Fogom.setDisplayName(ChatColor.RED + "Fogo");
	    Fogo.setItemMeta(Fogom);
	    if (((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().getType() == Material.WOOL))
	    {
	      p.setItemInHand(AR);
	      Ferro.add(p.getName());
	    }
	    else if ((Ferro.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().equals(AR)))
	    {
	      p.setItemInHand(Agua);
	      Ferro.remove(p.getName());
	      Avatar2.add(p.getName());
	    }
	    else if ((Avatar2.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().equals(Agua)))
	    {
	      p.setItemInHand(Terra);
	      Avatar2.remove(p.getName());
	      Terras.add(p.getName());
	    }
	    else if ((Terras.contains(p.getName())) && (Terras.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && (p.getItemInHand().equals(Terra)))
	    {
	      p.setItemInHand(Fogo);
	      Terras.remove(p.getName());
	      Red.add(p.getName());
	    }
	    else if ((Red.contains(p.getName())) && ((e.getAction() == Action.LEFT_CLICK_AIR) || (e.getAction() == Action.LEFT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
	      (p.getItemInHand().equals(Fogo)))
	    {
	      p.setItemInHand(AR);
	      Red.remove(p.getName());
	      Ferro.add(p.getName());
	    }
	  }
	  
	  @EventHandler
	  public void AvatarAr(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((Ferro.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
	      (p.getItemInHand().getType() == Material.WOOL))
	    {
	      event.setCancelled(true);
	      if (!Tempo.contains(p))
	      {
	        Tempo.add(p);
	        
	        Vector Ferro = p.getLocation().getDirection().normalize().multiply(55);
	        Snowball FerroH = (Snowball)p.launchProjectile(Snowball.class);
	        FerroH.setVelocity(Ferro);
	        FerroH.setMetadata("Ar", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
	        
	        Location pegou = p.getEyeLocation();
	        
	        BlockIterator Ferrao = new BlockIterator(pegou, 0.0D, 40);
	        while (Ferrao.hasNext())
	        {
	          Location Ferrao2 = Ferrao.next().getLocation();
	          
	          Effect camelo = Effect.STEP_SOUND;
	          p.playSound(p.getLocation(), Sound.STEP_WOOL, 5.5F, 5.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOL, 1.5F, 1.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOL, 2.5F, 2.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOL, 3.5F, 3.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOL, 4.5F, 4.5F);
	          
	          p.getWorld().playEffect(Ferrao2, camelo, 35);
	        }
	        this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	        {
	          public void run()
	          {
	            if (Avatar.Tempo.contains(p))
	            {
	              Avatar.Tempo.remove(p);
	              p.sendMessage("�aKITPVP:�a�lVoce ja pode usar o kit novamente");
	              p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
	            }
	          }
	        }, 250L);
	      }
	      else
	      {
	        p.sendMessage("�aKITPVP:�c�lKit em Cooldown");
	      }
	    }
	  }
	  
	  @EventHandler
	  public void EntityDamageEvent(EntityDamageByEntityEvent event)
	  {
	    Entity Tomou2 = event.getEntity();
	    if ((event.getDamager() instanceof Snowball))
	    {
	      Snowball Tomou = (Snowball)event.getDamager();
	      if (Tomou.hasMetadata("Ar"))
	      {
	        event.setDamage(8.0D);
	        ((LivingEntity)Tomou2).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0), true);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void AvatarAr1(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((Avatar2.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
	      (p.getItemInHand().getType() == Material.LAPIS_BLOCK))
	    {
	      event.setCancelled(true);
	      if (!Tempo.contains(p))
	      {
	        Tempo.add(p);
	        
	        Vector Agua = p.getLocation().getDirection().normalize().multiply(55);
	        Snowball AguaH = (Snowball)p.launchProjectile(Snowball.class);
	        AguaH.setVelocity(Agua);
	        AguaH.setMetadata("Agua", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
	        
	        Location pegou = p.getEyeLocation();
	        
	        BlockIterator Aguao = new BlockIterator(pegou, 0.0D, 40);
	        while (Aguao.hasNext())
	        {
	          Location Aguao2 = Aguao.next().getLocation();
	          
	          Effect camelo = Effect.STEP_SOUND;
	          p.playSound(p.getLocation(), Sound.STEP_WOOD, 5.5F, 5.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOD, 1.5F, 1.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOD, 2.5F, 2.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOD, 3.5F, 3.5F);
	          p.playSound(p.getLocation(), Sound.STEP_WOOD, 4.5F, 4.5F);
	          
	          p.getWorld().playEffect(Aguao2, camelo, 9);
	        }
	        this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	        {
	          public void run()
	          {
	            if (Avatar.Tempo.contains(p))
	            {
	              Avatar.Tempo.remove(p);
	              p.sendMessage("�aKITPVP:�a�lVoce ja pode usar o kit novamente");
	              p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
	            }
	          }
	        }, 250L);
	      }
	      else
	      {
	        p.sendMessage("�aKITPVP:�c�lKit em Cooldown");
	      }
	    }
	  }
	  
	  @EventHandler
	  public void EntityDamageEvent11(EntityDamageByEntityEvent event)
	  {
	    Entity Tomou2 = event.getEntity();
	    if ((event.getDamager() instanceof Snowball))
	    {
	      Snowball Tomou = (Snowball)event.getDamager();
	      if (Tomou.hasMetadata("Agua"))
	      {
	        event.setDamage(11.0D);
	        ((LivingEntity)Tomou2).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0), true);
	        
	        Vector vector = Tomou2.getLocation().getDirection();
	        vector.multiply(-1.0F);
	        Tomou2.setVelocity(vector);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void AvatarAr11(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((Red.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
	      (p.getItemInHand().getType() == Material.REDSTONE_BLOCK))
	    {
	      event.setCancelled(true);
	      if (!Tempo.contains(p))
	      {
	        Tempo.add(p);
	        
	        Vector Fogo = p.getLocation().getDirection().normalize().multiply(55);
	        Snowball FogoH = (Snowball)p.launchProjectile(Snowball.class);
	        FogoH.setVelocity(Fogo);
	        FogoH.setMetadata("Fogo", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
	        
	        Location pegou = p.getEyeLocation();
	        
	        BlockIterator Fogao = new BlockIterator(pegou, 0.0D, 40);
	        while (Fogao.hasNext())
	        {
	          Location Fogao2 = Fogao.next().getLocation();
	          
	          Effect camelo = Effect.STEP_SOUND;
	          p.playSound(p.getLocation(), Sound.FIRE, 5.5F, 5.5F);
	          p.playSound(p.getLocation(), Sound.FIRE, 1.5F, 1.5F);
	          p.playSound(p.getLocation(), Sound.FIRE, 2.5F, 2.5F);
	          p.playSound(p.getLocation(), Sound.FIRE, 3.5F, 3.5F);
	          p.playSound(p.getLocation(), Sound.FIRE, 4.5F, 4.5F);
	          
	          p.getWorld().playEffect(Fogao2, camelo, 10);
	        }
	        this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	        {
	          public void run()
	          {
	            if (Avatar.Tempo.contains(p))
	            {
	              Avatar.Tempo.remove(p);
	              p.sendMessage("�aKITPVP:�a�lVoce ja pode usar o kit novamente");
	              p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
	            }
	          }
	        }, 250L);
	      }
	      else
	      {
	        p.sendMessage("�aKITPVP:�c�lKit em Cooldown");
	      }
	    }
	  }
	  
	  @EventHandler
	  public void EntityDamageEvent1(EntityDamageByEntityEvent event)
	  {
	    Entity Tomou2 = event.getEntity();
	    if ((event.getDamager() instanceof Snowball))
	    {
	      Snowball Tomou = (Snowball)event.getDamager();
	      if (Tomou.hasMetadata("Fogo"))
	      {
	        event.setDamage(12.0D);
	        Tomou2.setFireTicks(150);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void AvatarTerra(PlayerInteractEvent event)
	  {
	    final Player p = event.getPlayer();
	    if ((Terras.contains(p.getName())) && ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) && (KitAPI.getkit(p) == "Avatar") && 
	      (p.getItemInHand().getType() == Material.GRASS))
	    {
	      event.setCancelled(true);
	      if (!Tempo.contains(p))
	      {
	        Tempo.add(p);
	        Vector Terra = p.getLocation().getDirection().normalize().multiply(55);
	        Snowball TerraH = (Snowball)p.launchProjectile(Snowball.class);
	        TerraH.setVelocity(Terra);
	        TerraH.setMetadata("Terra", new FixedMetadataValue(Main.instance, Boolean.valueOf(true)));
	        
	        Location pegou = p.getEyeLocation();
	        
	        BlockIterator Terrao = new BlockIterator(pegou, 0.0D, 40);
	        while (Terrao.hasNext())
	        {
	          Location Terrao2 = Terrao.next().getLocation();
	          
	          Effect camelo = Effect.STEP_SOUND;
	          
	          p.playSound(p.getLocation(), Sound.STEP_GRASS, 5.5F, 5.5F);
	          p.playSound(p.getLocation(), Sound.STEP_GRASS, 1.5F, 1.5F);
	          p.playSound(p.getLocation(), Sound.STEP_GRASS, 2.5F, 2.5F);
	          p.playSound(p.getLocation(), Sound.STEP_GRASS, 3.5F, 3.5F);
	          p.playSound(p.getLocation(), Sound.STEP_GRASS, 4.5F, 4.5F);
	          
	          p.getWorld().playEffect(Terrao2, camelo, 2);
	        }
	        this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()
	        {
	          public void run()
	          {
	            if (Avatar.Tempo.contains(p))
	            {
	              Avatar.Tempo.remove(p);
	              p.sendMessage("�aKITPVP:�a�lVoce ja pode usar o kit novamente");
	              p.playSound(p.getLocation(), Sound.LEVEL_UP, 15.5F, 15.5F);
	            }
	          }
	        }, 250L);
	      }
	      else
	      {
	        p.sendMessage("�aKITPVP:�c�lKit em Cooldown");
	      }
	    }
	  }
	  
	  @EventHandler
	  public void EntityDamageEvent111(EntityDamageByEntityEvent event)
	  {
	    Entity Tomou2 = event.getEntity();
	    if ((event.getDamager() instanceof Snowball))
	    {
	      Snowball Tomou = (Snowball)event.getDamager();
	      if (Tomou.hasMetadata("Terra"))
	      {
	        event.setDamage(14.0D);
	        
	        Vector vector = Tomou2.getLocation().getDirection();
	        vector.multiply(-3.2F);
	        Tomou2.setVelocity(vector);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void drop(PlayerDropItemEvent e)
	  {
	    Player p = e.getPlayer();
	    ItemStack item = e.getItemDrop().getItemStack();
	    if ((Ferro.contains(p.getName())) && (item.getType() == Material.WOOL)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void drop2(PlayerDropItemEvent e)
	  {
	    Player p = e.getPlayer();
	    ItemStack item = e.getItemDrop().getItemStack();
	    if ((Avatar2.contains(p.getName())) && (item.getType() == Material.LAPIS_BLOCK)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void drop3(PlayerDropItemEvent e)
	  {
	    Player p = e.getPlayer();
	    ItemStack item = e.getItemDrop().getItemStack();
	    if ((Red.contains(p.getName())) && (item.getType() == Material.REDSTONE_BLOCK)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void drop4(PlayerDropItemEvent e)
	  {
	    Player p = e.getPlayer();
	    ItemStack item = e.getItemDrop().getItemStack();
	    if ((Terras.contains(p.getName())) && (item.getType() == Material.GRASS)) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void ColocarBlocos(BlockPlaceEvent e)
	  {
	    Player p = e.getPlayer();
	    if (KitAPI.getkit(p) == "Avatar") {
	      e.setCancelled(true);
	    }
	  }
	}


