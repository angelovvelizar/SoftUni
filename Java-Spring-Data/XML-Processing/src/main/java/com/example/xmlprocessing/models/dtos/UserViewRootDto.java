package com.example.xmlprocessing.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    List<UserWithProductDto> products;

    public List<UserWithProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<UserWithProductDto> products) {
        this.products = products;
    }
}
