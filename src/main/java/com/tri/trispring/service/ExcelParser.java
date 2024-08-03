package com.tri.trispring.service;

import com.tri.trispring.entity.Entity;

import com.tri.trispring.repository.EntityRepository;
import jakarta.annotation.PostConstruct;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcelParser {

    @Autowired
    private FilesIterator filesIterator;
    @Autowired
    private EntityService entityService;

    @PostConstruct
    public void parseAndAddToDB() {
        List<String> filestoparse = FilesIterator.filesSearch();

        List<Entity> collect = (List) filestoparse.stream()
                .map(ExcelParser::parseEachFile)
                .flatMap(Collection::stream)
                .peek((x) -> {
                    x.setBankName(findBankName(x.getTravelNumber()));
                })
                .collect(Collectors.toList());
        collect.forEach((entity) -> entityService.addEntity(entity));


    }

    public static String findBankName(String travelNumber) {
        String bankName = null;
        String bankCode = travelNumber.substring(0, 2);
        if (bankCode.equals("99")) {
            bankName = "Центральный Аппарат";
        } else if (bankCode.equals("13")) {
            bankName = "Центрально-Черноземный Банк";
        } else if (bankCode.equals("42")) {
            bankName = "Волго-Вятский Банк";
        } else if (bankCode.equals("52")) {
            bankName = "Юго-Западный Банк";
        } else if (bankCode.equals("54")) {
            bankName = "Поволжский Банк";
        } else if (bankCode.equals("16")) {
            bankName = "Уральский Банк";
        } else if (bankCode.equals("18")) {
            bankName = "Байкальский Банк";
        } else if (bankCode.equals("70")) {
            bankName = "Дальневосточный Банк";
        } else if (bankCode.equals("38")) {
            bankName = "Московский Банк";
        } else if (bankCode.equals("40")) {
            bankName = "Среднерусский Банк";
        } else if (bankCode.equals("55")) {
            bankName = "Северо-Западный Банк";
        } else if (bankCode.equals("44")) {
            bankName = "Сибирский Банк";
        }

        return bankName;
    }

    public static List<Entity> parseEachFile(String path) {
        //       System.out.println("parseEachFile started");
        List<Entity> entities = new ArrayList<>();
        InputStream in = null;
        XSSFWorkbook wb = null;

        try {
            in = new FileInputStream(path);
            wb = new XSSFWorkbook(in);
        } catch (IOException var14) {
            var14.printStackTrace();
        }

        assert wb != null;

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();

        while (it.hasNext()) {
            Row row = (Row) it.next();
            String[] entityAsStrings = new String[15];
            Iterator<Cell> cells = row.iterator();

            for (int i = 0; i < 14; ++i) {
                Cell cell = (Cell) cells.next();
                CellType cellType = cell.getCellTypeEnum();
                switch (cellType) {
                    case NUMERIC:
                        DataFormatter dataFormatter = new DataFormatter();
                        String formattedCellStr = dataFormatter.formatCellValue(cell);
                        entityAsStrings[i] = formattedCellStr;
                        break;
                    case STRING:
                        entityAsStrings[i] = cell.getStringCellValue();
                        break;
                    default:
                        entityAsStrings[i] = " ";
                }

                if (entityAsStrings[0].equals(" ")) {
                    break;
                }

            }
            Entity entity = new Entity();
            entity.setOrderDate(entityAsStrings[0]);
            entity.setOrderNumber(entityAsStrings[1]);
            entity.setOrderName(entityAsStrings[2]);
            entity.setEmplCategory(entityAsStrings[3]);
            entity.setEmplNumber(entityAsStrings[4]);
            entity.setEmplName(entityAsStrings[5]);
            entity.setTravelNumber(entityAsStrings[6]);
            entity.setStartDate(entityAsStrings[7]);
            entity.setEndDate(entityAsStrings[8]);
            entity.setDestination(entityAsStrings[9]);
            entity.setCityURM(entityAsStrings[10]);
            entity.setDeparturePoint(entityAsStrings[11]);
            entity.setClarifyingDepDate(entityAsStrings[12]);
            entity.setClarifyingArrDate(entityAsStrings[13]);
            entity.setHostOrganisation(entityAsStrings[14]);
            entities.add(entity);

        }

        List<Entity> finalentities = (List) entities.stream().filter((entityx) -> {
            return entityx.getOrderNumber() != null;
        }).collect(Collectors.toList());
//        System.out.println("printing finalentiies:" + finalentities);
        return finalentities;
    }

}
