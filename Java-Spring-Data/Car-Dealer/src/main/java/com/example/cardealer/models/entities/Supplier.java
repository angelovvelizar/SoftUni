package com.example.cardealer.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier extends BaseEntity{

    @Column
    private String name;

    @Column(name = "is_importer")
    private Boolean isImporter;

    @OneToMany(mappedBy = "supplier",fetch = FetchType.EAGER)
    private Set<Part> parts;

    public Supplier() {
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }
}
