package com.example;

import com.example.mapper.DomesticWorkerMapper;
import com.example.pojo.POIQueryVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.List;

@SpringBootTest
@Slf4j
public class POITest {

    @Autowired
    private DomesticWorkerMapper domesticWorkerMapper;

    @Test
    public void write() throws Exception {
        String excelPath = "D:\\Java\\house-keeping\\src\\main\\resources\\template\\info.xlsx";
        File file = new File(excelPath);

        // 检查文件是否存在
        if (file.exists()) {
            // 删除文件
            boolean deleted = file.delete();
            if (deleted) {
                System.out.println("文件删除成功");
            } else {
                System.out.println("文件删除失败");
            }
        } else {
            System.out.println("文件不存在，无法删除");
        }

        XSSFWorkbook excel = new XSSFWorkbook();

        XSSFSheet sheet = excel.createSheet("info");

        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("姓名");
        row.createCell(1).setCellValue("服务类别");
        row.createCell(2).setCellValue("简介");
        row.createCell(3).setCellValue("小时价格");
        row.createCell(4).setCellValue("电话号码");
        row.createCell(5).setCellValue("年龄");
        row.createCell(6).setCellValue("性别");
        row.createCell(7).setCellValue("所在地区");

        List<POIQueryVO> list = domesticWorkerMapper.getByPOI();

        for (int i = 0; i < list.size(); i++) {
            POIQueryVO p = list.get(i);
            row = sheet.createRow(1 + i);
            row.createCell(0).setCellValue(p.getName());
            row.createCell(1).setCellValue(p.getCategory());
            row.createCell(2).setCellValue(p.getIntroduction());
            row.createCell(3).setCellValue(p.getHourlyRate());
            row.createCell(4).setCellValue(p.getPhoneNumber());
            row.createCell(5).setCellValue(p.getAge());
            row.createCell(6).setCellValue(p.getGender());
            row.createCell(7).setCellValue(p.getRegion());
        }

        FileOutputStream out = new FileOutputStream(excelPath);
        excel.write(out);

        out.close();
        excel.close();
    }

}