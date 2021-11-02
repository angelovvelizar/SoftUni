package Exercise.TrafficLights;

import static Exercise.TrafficLights.LightColor.GREEN;

public class Light {
    private LightColor lightColor;


    public Light(LightColor lightColor) {
        this.lightColor = lightColor;
    }

    public void changeColor(){
        switch (this.lightColor){
            case RED:
                this.lightColor = LightColor.valueOf("GREEN");
                break;
            case GREEN:
                this.lightColor = LightColor.valueOf("YELLOW");
                break;
            case YELLOW:
                this.lightColor = LightColor.valueOf("RED");
                break;
        }
    }

    public LightColor getLightColor() {
        return lightColor;
    }
}
