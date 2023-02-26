package nodes;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.methods.input.Camera;
import org.dreambot.api.methods.interactive.NPCs;
import org.dreambot.api.wrappers.interactive.NPC;
public class AttackDemon extends TaskNode {
    Area greatedemonsarea = new Area(new Tile(1681, 10089), new Tile(1686, 10082));
    public int priority() {
        return 2;
    }


    @Override
    public boolean accept() {

        if(greatedemonsarea.contains(Players.getLocal()) && !Players.getLocal().isInCombat()){
            return true;
        }
        else{
            return false;
        }


    }

    @Override
    public int execute(){

        NPC npc;

        npc = NPCs.closest(demon -> demon.getName().contentEquals("Greater demon") && demon != null
                && !demon.isInCombat() && greatedemonsarea.contains(demon));

        if(npc != null){
            if (!npc.isOnScreen()){
                Camera.keyboardRotateToEntity(npc);
                sleep(Calculations.random(500, 1000));
            }

            npc.interact("Attack");
            log("Fighting");
            sleep(Calculations.random(1000, 2000));
        }

        return Calculations.random(300, 500);

    }
}

