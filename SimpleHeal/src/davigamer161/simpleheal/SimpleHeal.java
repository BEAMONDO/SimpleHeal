package davigamer161.simpleheal;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import davigamer161.simpleheal.comandos.ComandoHeal;
import davigamer161.simpleheal.comandos.ComandoPrincipal;

public class SimpleHeal extends JavaPlugin{
    public String rutaConfig;
    PluginDescriptionFile pdffile = getDescription();
    public String version = pdffile.getVersion();
    public String nombre = ChatColor.RED+"["+ChatColor.YELLOW+pdffile.getName()+ChatColor.RED+"] ";


  //---------------------Para cuando se activa el plugin----------------------------------//
    //------------------------------Desde aqui-----------------------------//
    public void onEnable(){
      Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"<------------------------------------>");
	    Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.WHITE+"Ha sido activado ("+ChatColor.GREEN+"version: "+ChatColor.YELLOW+version+ChatColor.WHITE+")");
	    Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.GREEN+"Gracias por utilizar mi plugin :)");
      Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE+"<------------------------------------>");
      registrarComandos();
      registrarConfig();
    }
    //------------------------------Hasta aqui-----------------------------//



    //------------------Para cuando se desactiva el plugin----------------------------------//
    //------------------------------Desde aqui-----------------------------//
    public void onDisable(){
	    Bukkit.getConsoleSender().sendMessage(nombre+ChatColor.WHITE+"Ha sido desactivado ("+ChatColor.GREEN+"version: "+ChatColor.YELLOW+version+ChatColor.WHITE+")");
    }
    //------------------------------Hasta aqui-----------------------------//



    //-----------------------Para registrar comandos----------------------------------------//
    //------------------------------Desde aqui-----------------------------//
    public void registrarComandos(){
        this.getCommand("heal").setExecutor(new ComandoHeal(this));
        this.getCommand("simpleheal").setExecutor(new ComandoPrincipal(this));
      }
      //------------------------------Hasta aqui-----------------------------//


      
      //--------------------------Para crear config.yml--------------------------------------//
    //------------------------------Desde aqui-----------------------------//
    public void registrarConfig(){
        File config = new File(this.getDataFolder(),"config.yml");
        rutaConfig = config.getPath();
        if(!config.exists()){
          this.getConfig().options().copyDefaults(true);
          saveConfig();
        }
      }
      //------------------------------Hasta aqui-----------------------------//
}