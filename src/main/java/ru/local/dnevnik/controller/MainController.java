package ru.local.dnevnik.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.local.dnevnik.service.RowService;
import ru.local.dnevnik.model.Excel;
import ru.local.dnevnik.service.ExcelService;

/**
 * Created by root on 28/07/15.
 */
@Controller
@RequestMapping(value="/api/v1/files")
public class MainController {

    @Autowired
    ExcelService excelService;
    @Autowired
    RowService rowService;


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity uploadFile(@PathVariable(value = "id") Integer id){
        return new ResponseEntity(rowService.findByExcel(excelService.findById(id)), HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity uploadFiles(){
        return new ResponseEntity(excelService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {

      Excel excel =  excelService.processFile(file);
        System.out.println(excel);
        return new ResponseEntity("Файл успешно загружен.", HttpStatus.OK);
    }
}
