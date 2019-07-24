package czt.yonyou.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

/**
 * bill 和 billItem为一对多
 */
@Entity
@Table(name = "bill_item")
public class BillItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String code;
    private String name;
    private String material;


    @ManyToOne()
    @JoinColumn(name = "bill_id")
    @JsonIgnore
    private Bill bill;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", material='" + material + '\'' +
                ", bill=" + bill +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillItem billItem = (BillItem) o;
        return Objects.equals(id, billItem.id) &&
                Objects.equals(code, billItem.code) &&
                Objects.equals(name, billItem.name) &&
                Objects.equals(material, billItem.material) &&
                Objects.equals(bill, billItem.bill);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, material, bill);
    }

    public BillItem() {

    }

}
