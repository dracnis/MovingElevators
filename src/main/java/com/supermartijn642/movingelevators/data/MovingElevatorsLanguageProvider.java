package com.supermartijn642.movingelevators.data;

import com.supermartijn642.movingelevators.MovingElevators;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

/**
 * Created 14/02/2022 by SuperMartijn642
 */
public class MovingElevatorsLanguageProvider extends LanguageProvider {

    public MovingElevatorsLanguageProvider(GatherDataEvent e){
        super(e.getGenerator(), "movingelevators", "en_us");
    }

    @Override
    protected void addTranslations(){
        // Moving Elevators' item group
        this.add("itemGroup.movingelevators", "Moving Elevators");

        // Elevator controller
        this.add(MovingElevators.elevator_block, "Elevator Controller");
        this.add("movingelevators.elevator_controller.tooltip", "Place elevator controllers above each other to create floors for an elevator");

        // Elevator display
        this.add(MovingElevators.display_block, "Elevator Display");
        this.add("movingelevators.elevator_display.tooltip", "Shows an elevators' floors when placed on top of an elevator controller or remote elevator panel");

        // Remote elevator panel
        this.add(MovingElevators.button_block, "Remote Elevator Panel");
        this.add("movingelevators.remote_controller.tooltip", "Can be bound to an elevator controller by right-clicking on it");
        this.add("movingelevators.remote_controller.tooltip.bound", "Bound to elevator controller at (%1$d, %2$d, %3$d) in %4$s");
        this.add("movingelevators.remote_controller.bind", "Bound to Elevator Controller!");
        this.add("movingelevators.remote_controller.not_bound", "The block must be bound to an Elevator Controller!");
        this.add("movingelevators.remote_controller.wrong_dimension", "The block must be in the same dimension as the Elevator Controller!");
        this.add("movingelevators.remote_controller.controller_location", "Bound to elevator controller at (%1$d, %2$d, %3$d)");
        this.add("movingelevators.remote_controller.clear", "Cleared stored elevator location!");
        
        // Floor name
        this.add("movingelevators.floor_name", "Floor %d");
        
        // Elevator screen
        this.add("movingelevators.elevator_screen.cabin_width", "Cabin width");
        this.add("movingelevators.elevator_screen.cabin_depth", "Cabin depth");
        this.add("movingelevators.elevator_screen.cabin_height", "Cabin height");
        this.add("movingelevators.elevator_screen.cabin_width.increase_size", "Increase width");
        this.add("movingelevators.elevator_screen.cabin_depth.increase_size", "Increase depth");
        this.add("movingelevators.elevator_screen.cabin_height.increase_size", "Increase height");
        this.add("movingelevators.elevator_screen.cabin_width.decrease_size", "Decrease width");
        this.add("movingelevators.elevator_screen.cabin_depth.decrease_size", "Decrease depth");
        this.add("movingelevators.elevator_screen.cabin_height.decrease_size", "Decrease height");
        this.add("movingelevators.elevator_screen.cabin_width.increase_offset", "Move right");
        this.add("movingelevators.elevator_screen.cabin_depth.increase_offset", "Move forward");
        this.add("movingelevators.elevator_screen.cabin_height.increase_offset", "Move up");
        this.add("movingelevators.elevator_screen.cabin_width.decrease_offset", "Move left");
        this.add("movingelevators.elevator_screen.cabin_depth.decrease_offset", "Move backward");
        this.add("movingelevators.elevator_screen.cabin_height.decrease_offset", "Move down");
        this.add("movingelevators.elevator_screen.current_floor", "Floor");
        this.add("movingelevators.elevator_screen.elevator", "Elevator");
        this.add("movingelevators.elevator_screen.floor_name", "Floor name");
        this.add("movingelevators.elevator_screen.show_buttons", "Show buttons");
        this.add("movingelevators.elevator_screen.cabin_size", "Cabin size");
        this.add("movingelevators.elevator_screen.elevator_speed", "Speed");
        this.add("movingelevators.elevator_screen.current_speed", "%s blocks/tick");
        this.add("movingelevators.elevator_screen.display_buttons", "Show buttons: %s");
        this.add("movingelevators.elevator_screen.display_buttons.on", "True");
        this.add("movingelevators.elevator_screen.display_buttons.off", "False");
    }
}
