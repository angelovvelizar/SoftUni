package Exercise.CollectionHierarchy;

import Exercise.CollectionHierarchy.Addable;

public class AddCollection extends Collection implements Addable {

    public AddCollection() {
        super();
    }

    @Override
    public int getUsed() {
        return 0;
    }

    @Override
    public String remove() {
        return null;
    }
    @Override
    public int add(String item) {
        this.items.add(item);
        return this.items.lastIndexOf(item);
    }
}
