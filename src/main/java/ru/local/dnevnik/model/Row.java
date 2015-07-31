package ru.local.dnevnik.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by root on 28/07/15.
 */
@Entity
@Table(name = "rows")
public class Row {


    private Integer id;
    private Excel excel;
    private Integer key;
    private String title;
    private Double price;
    private Date date;

    @Id
    @SequenceGenerator(name="rows_seq", sequenceName="rows_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rows_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @ManyToOne
    @JoinColumn(name="excel_id")
    public Excel getExcel() {
        return excel;
    }

    public void setExcel(Excel excel) {
        this.excel = excel;
    }


    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
