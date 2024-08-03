package com.tri.trispring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@jakarta.persistence.Entity
@Table(name = "ENTITY")
@Data
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "bankName")
    public String bankName;
    @Column(name = "orderDate")
    public String orderDate;
    @Column(name = "orderNumber")
    public String orderNumber;
    @Column(name = "orderName")
    public String orderName;
    @Column(name = "emplCategory")
    public String emplCategory;
    @Column(name = "emplNumber")
    public String emplNumber;
    @Column(name = "emplName")
    public String emplName;
    @Column(name = "travelNumber")
    public String travelNumber;
    @Column(name = "startDate")
    public String startDate;
    @Column(name = "endDate")
    public String endDate;
    @Column(name = "destination")
    public String destination;
    @Column(name = "cityURM")
    public String cityURM;
    @Column(name = "departurePoint")
    public String departurePoint;
    @Column(name = "clarifyingDepDate")
    public String clarifyingDepDate;
    @Column(name = "clarifyingArrDate")
    public String clarifyingArrDate;
    @Column(name = "hostOrganisation")
    public String hostOrganisation;

    public Entity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(orderNumber, entity.orderNumber) && Objects.equals(travelNumber, entity.travelNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, travelNumber);
    }
}
