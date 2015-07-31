package ru.local.dnevnik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.local.dnevnik.model.Row;
import ru.local.dnevnik.model.Excel;

import java.util.List;

/**
 * Created by root on 30/07/15.
 */
public interface RowDAO extends JpaRepository<Row, Integer> {
    List<Row> findByExcel(Excel excel);
}
