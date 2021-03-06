package common.util;

import java.util.ArrayList;

import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import cyclegame.templates.game.Team;

public class ActionBar {
	   
    private PacketPlayOutChat packet;
 
    public ActionBar(String text) {
        PacketPlayOutChat packet = new PacketPlayOutChat(ChatSerializer.a("{\"text\":\"" + text + "\"}"), (byte) 2);
        this.packet = packet;
    }
   
    public void sendToPlayer(Player player) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
    }
   
    public void sendToPlayers(ArrayList<Player> players){
        for(Player player : players){
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);;
        }
    }
    
    public void sendToTeam(Team team){
    	for(Player player : team.players){
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);;
    	}
    }
   
    public void sendToServer() {
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);;
        }
    }
   
}