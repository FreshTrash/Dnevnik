package ru.local.dnevnik.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.local.dnevnik.dao.ExcelDAO;
import ru.local.dnevnik.exception.BadFileException;
import ru.local.dnevnik.model.Excel;

import java.io.*;
import java.io.File;
import java.text.ParseException;
import java.util.List;

/**
 * Created by root on 28/07/15.
 */
@Service
public class ExcelService {

    @Value(value = "${dnevnik.file.dir}")
    private String fileDir;

    @Autowired
    private ExcelDAO excelDAO;

    @Autowired
    private ParseService parseService;

    @Transactional
    public Excel processFile(MultipartFile file) throws IOException, BadFileException, ParseException {
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(fileDir+file.getOriginalFilename())));
            stream.write(bytes);
            stream.close();
        } else {
            throw new BadFileException("Файл пустой.");
        }

        Excel excel = new Excel();
        excel.setName(file.getOriginalFilename());
        excel.setPath(fileDir+file.getOriginalFilename());
        excel = excelDAO.save(excel);
        System.out.println(excel);
        parseService.parse(excel);

        return excel;
    }

    public Excel findById(Integer id) {
        return excelDAO.findOne(id);
    }

    public List<Excel> findAll() {
        return excelDAO.findAll();
    }
}
