package ru.local.dnevnik.service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import ru.local.dnevnik.model.Excel;

import javax.transaction.Transactional;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

/**
 * Created by root on 30/07/15.
 */
@Service
public class ParseService {

    @Autowired
    private RowService rowService;

    @Transactional
    public  String parse(Excel excel) throws ParseException {

        String result = "";
        InputStream in = null;
        HSSFWorkbook wb = null;
        HSSFRow row = null;
        HSSFCell cell = null;

        try {
            in = new FileInputStream(excel.getPath());
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HSSFSheet sheet = wb.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();

        for(int i=0; i<rows; i++) {
            ru.local.dnevnik.model.Row r = new ru.local.dnevnik.model.Row();
            r.setExcel(excel);
            row = sheet.getRow(i);
            if(row != null) {
                for(int j=0; j<row.getPhysicalNumberOfCells(); j++) {
                    cell = row.getCell(j);

                    switch(j) {
                        case 0:
                            r.setKey((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            r.setTitle(cell.getStringCellValue());
                            break;
                        case 2:
                            r.setPrice(cell.getNumericCellValue());
                            break;
                        case 3:
                            r.setDate(cell.getDateCellValue());
                            break;
                        default:
                            break;
                    }
                }
                rowService.save(r);
            }
        }
        return result;
    }}
