package Exercise.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection implements MyList {
    protected int maxSize;
    protected List<String> items;

    protected Collection() {
        this.items = new ArrayList<>();
        this.maxSize = 100;
    }

    @Override
    public abstract int getUsed();


    @Override
    public abstract String remove();

    @Override
    public abstract int add(String item);

}
