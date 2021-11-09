package Exercise.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements AddRemovable {

    public AddRemoveCollection() {
        super();
    }

    @Override
    public int getUsed() {
        return 0;
    }

    @Override
    public String remove() {
        return this.items.remove(this.items.size() - 1);
    }

    @Override
    public int add(String item) {
        this.items.add(0, item);
        return this.items.lastIndexOf(item);
    }
}
