package ru.local.dnevnik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.local.dnevnik.model.Excel;

/**
 * Created by root on 28/07/15.
 */
public interface ExcelDAO extends JpaRepository<Excel, Integer> {
}
