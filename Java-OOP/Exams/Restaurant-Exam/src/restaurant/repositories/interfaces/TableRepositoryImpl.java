package restaurant.repositories.interfaces;


import restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<Table> {
    private Collection<Table> tables;

    public TableRepositoryImpl(){
        this.tables = new ArrayList<>();

    }
    @Override
    public Table byNumber(int number) {
        return this.tables.stream().filter(t -> t.getTableNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<Table> getAllEntities() {
        return Collections.unmodifiableCollection(tables);
    }

    @Override
    public void add(Table entity) {
        this.tables.add(entity);
    }
}
