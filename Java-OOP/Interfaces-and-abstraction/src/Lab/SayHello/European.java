package Lab.SayHello;

import Lab.SayHello.BasePerson;

public class European extends BasePerson {
    public European(String name) {
        super(name);
    }


    @Override
    public String sayHello() {
        return "Hello";
    }
}
