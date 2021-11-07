package Lab.SayHello;

import Lab.SayHello.BasePerson;

public class Bulgarian extends BasePerson {
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}



