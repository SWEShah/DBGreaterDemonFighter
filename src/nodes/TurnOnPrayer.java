package nodes;
import org.dreambot.api.methods.Calculations;
import org.dreambot.api.methods.prayer.Prayer;
import org.dreambot.api.methods.prayer.Prayers;
import org.dreambot.api.script.TaskNode;

public class TurnOnPrayer extends TaskNode {

    public int priority() {
        return 1;
    }


    @Override
    public boolean accept() {

        if(!Prayers.isActive(Prayer.PROTECT_FROM_MELEE)){
            return true;
        }
        else{
            return false;
        }


    }

    @Override
    public int execute(){

        Prayers.openTab();
        Prayers.toggle(true, Prayer.PROTECT_FROM_MELEE);

        return Calculations.random(300, 500);

    }
}

