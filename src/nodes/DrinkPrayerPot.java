package nodes;

import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.script.TaskNode;
import org.dreambot.api.methods.container.impl.Inventory;
public class DrinkPrayerPot extends TaskNode {

    public int priority() {
        return 3;
    }


    @Override
    public boolean accept() {
        int prayerlevel = Skills.getRealLevel(Skill.PRAYER);
        if (Skills.getBoostedLevel(Skill.PRAYER) < Calculations.random(10, (prayerlevel - 20))) {
            return true;
        }
        else{
            return false;
        }


    }

    @Override
    public int execute(){

        if(Inventory.contains(i -> i.getName().contains("Prayer potion("))){
            log("Prayer potion found");
            Inventory.interact(i -> i.getName().contains("Prayer potion("), "Drink");
            log("Drinking prayer potion");
        }
        else{
            log("Out of prayer potions");
        }

        return Calculations.random(300, 500);

    }
}

