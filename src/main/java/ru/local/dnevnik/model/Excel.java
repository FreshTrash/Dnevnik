package ru.local.dnevnik.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by root on 28/07/15.
 */
@Entity
@Table(name="excel")
public class Excel {

    private Integer id;
    private String name;
    private String path;

    public Excel() {
    }

    @Id
    @SequenceGenerator(name="excel_seq", sequenceName="excel_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "excel_seq")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public String toString() {
        return "Excel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
