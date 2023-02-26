import nodes.DrinkPrayerPot;
import nodes.AttackDemon;
import nodes.TurnOnPrayer;
import org.dreambot.api.script.impl.TaskScript;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.script.Category;
@ScriptManifest(author = "Shah", description = "Greater Demon Fighter", name = "Greater Demon Fighterv2", category = Category.COMBAT, version = 1)
public class Main extends TaskScript {
    @Override //Infinite loop
    public void onStart() {

        addNodes(new AttackDemon(), new DrinkPrayerPot(), new TurnOnPrayer());
    }
    }
