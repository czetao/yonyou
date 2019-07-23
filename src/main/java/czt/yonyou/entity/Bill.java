package czt.yonyou.entity;


import javax.annotation.Generated;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String code;
    private String name;
    private String department;
    //数据表字段agent_id Bill和Agent为多对一关系。

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private Agent agent;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bill_id")
    private List<BillItem> billItems;


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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id) &&
                Objects.equals(code, bill.code) &&
                Objects.equals(name, bill.name) &&
                Objects.equals(department, bill.department) &&
                Objects.equals(agent, bill.agent) &&
                Objects.equals(billItems, bill.billItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, department, agent, billItems);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", agent=" + agent +
                ", billItems=" + billItems +
                '}';
    }
}
