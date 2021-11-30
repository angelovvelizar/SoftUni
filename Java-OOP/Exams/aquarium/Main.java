package aquarium;

import aquarium.core.Engine;
import aquarium.core.EngineImpl;
import aquarium.entities.decorations.BaseDecoration;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;


public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
