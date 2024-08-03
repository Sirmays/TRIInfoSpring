package com.tri.trispring.DTO;

import com.tri.trispring.entity.Entity;
import lombok.ToString;

@ToString
public class EntityForClipboardDTO {
    public String bankName;
    public String orderDate;
    public String orderNumber;
    public String orderName;
    public String emplCategory;
    public String emplNumber;
    public String emplName;
    public String travelNumber;
    public String startDate;
    public String endDate;
    public String destination;
    public String cityURM;
    public String departurePoint;
    public String clarifyingDepDate;
    public String clarifyingArrDate;
    public String hostOrganisation;

    public EntityForClipboardDTO(Entity entity) {
        this.bankName = "Банк: " + entity.getBankName();
        this.orderDate = "Дата Приказа: " + entity.getOrderDate();
        this.orderNumber = "Номер приказа: " + entity.getOrderNumber();
        this.orderName = "Вид документа: " + entity.getOrderName();
        this.emplCategory = "Категория сотрудника: " + entity.getEmplCategory();
        this.emplNumber = "Табельный номер: " + entity.getEmplNumber();
        this.emplName = "ФИО Сотрудника: " + entity.getEmplName();
        this.travelNumber = "Номер командировки: " + entity.getTravelNumber();
        this.startDate = "Дата начала командировки: " + entity.getStartDate();
        this.endDate = "Дата окончания командировки: " + entity.getEndDate();
        this.destination = "Место назначения: " + entity.getDestination();
        this.cityURM = "Город расположения УРМ: " + entity.getCityURM();
        this.departurePoint = "Место отправления: " + entity.getDeparturePoint();
        this.clarifyingDepDate = "Уточ. дата отпр.: " + entity.getClarifyingDepDate();
        this.clarifyingArrDate = "Уточ. дата возвр.: " + entity.getClarifyingArrDate();
        this.hostOrganisation = "Принимающая организация: " + entity.getHostOrganisation();
    }

}
