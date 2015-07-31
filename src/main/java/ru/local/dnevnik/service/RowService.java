package ru.local.dnevnik.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.local.dnevnik.dao.RowDAO;
import ru.local.dnevnik.model.Excel;
import ru.local.dnevnik.model.Row;

import java.util.List;

/**
 * Created by root on 30/07/15.
 */
@Service
public class RowService {

    @Autowired
    private RowDAO rowDAO;

    public List<Row> findByExcel(Excel excel) {
        return rowDAO.findByExcel(excel);
    }

    public Row save(Row row) {
        return rowDAO.save(row);
    }
}
