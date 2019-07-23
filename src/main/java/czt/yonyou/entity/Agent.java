package czt.yonyou.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * jpa技术
 * @Entity, @Id和@GeneratedValue注解，因此这个类被标记作为JPA实体并且能够被持久化到数据库中
 */
//数据库端，表名
@Entity
@Table(name = "Agent")
public class Agent {

    //主键、自动生成值
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String code;
    private String name;
    private String person;

    //多对一
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "agent_id")
    private List<Bill> bills;

    public Agent(String s3, String s, String s1, String s2) {
    }

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

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public List<Bill> getBills() {
        return bills;
    }

    public void setBills(List<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return Objects.equals(id, agent.id) &&
                Objects.equals(code, agent.code) &&
                Objects.equals(name, agent.name) &&
                Objects.equals(person, agent.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, person);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", person='" + person + '\'' +
                '}';
    }
}
