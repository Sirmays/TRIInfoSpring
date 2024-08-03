package com.tri.trispring.service;

import com.tri.trispring.DTO.EntityForClipboardDTO;
import com.tri.trispring.entity.Entity;
import com.tri.trispring.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

@Service
public class EntityService {
    @Autowired
    private EntityRepository entityRepository;

    public void addEntity(Entity entity) {
        entityRepository.save(entity);
    }

    public void copyEntityToClipboard(Entity entity) {
        EntityForClipboardDTO entityForClipboardDTO = new EntityForClipboardDTO(entity);
        StringSelection stringSelection = new StringSelection(buildTheTextForClipboard(entityForClipboardDTO));
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

    }

    String buildTheTextForClipboard(EntityForClipboardDTO entityForClipboardDTO) {
        String finalText = entityForClipboardDTO.bankName +
                '\n' +
                entityForClipboardDTO.orderDate +
                '\n' +
                entityForClipboardDTO.orderNumber +
                '\n' +
                entityForClipboardDTO.orderName +
                '\n' +
                entityForClipboardDTO.emplCategory +
                '\n' +
                entityForClipboardDTO.emplNumber +
                '\n' +
                entityForClipboardDTO.emplName +
                '\n' +
                entityForClipboardDTO.travelNumber +
                '\n' +
                entityForClipboardDTO.startDate +
                '\n' +
                entityForClipboardDTO.endDate +
                '\n' +
                entityForClipboardDTO.destination +
                '\n' +
                entityForClipboardDTO.cityURM +
                '\n' +
                entityForClipboardDTO.departurePoint +
                '\n' +
                entityForClipboardDTO.clarifyingDepDate +
                '\n' +
                entityForClipboardDTO.clarifyingArrDate +
                '\n' +
                entityForClipboardDTO.hostOrganisation;

        return finalText;
    }
}
