package org.shuaibu.collaboration_java;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.Objects;

@Entity
public class ProductsModel {

    @Id
    @SequenceGenerator(
            name = "products_id_sequence",
            sequenceName = "products_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "products_id_sequence"
    )


    private Integer id;
    @NotEmpty
    private String name;

    public ProductsModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    public ProductsModel() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductsModel that = (ProductsModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "ProductsModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
