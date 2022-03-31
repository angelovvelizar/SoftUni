package com.example.xmlprocessing.models.dtos;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsInRangeRootDto {

    @XmlElement(name = "product")
    private List<ProductInRangeInfoDto> products;

    public List<ProductInRangeInfoDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInRangeInfoDto> products) {
        this.products = products;
    }
}
