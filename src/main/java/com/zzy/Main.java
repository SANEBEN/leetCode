//package com.zzy;
//
//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//public class Main {
//
//    public static void main(String[] args) {
//        XSSFWorkbook xssfWorkbook = null;
//        try {
//            InputStream stream = Main.class.getResourceAsStream("/Dashboard-download-template.xlsx");
//            xssfWorkbook = new XSSFWorkbook(stream);
//            SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(xssfWorkbook);
//            XSSFSheet workRatio = sxssfWorkbook.getXSSFWorkbook().getSheetAt(0);
//            XSSFSheet machineRegisterCount = sxssfWorkbook.getXSSFWorkbook().getSheetAt(1);
//            XSSFSheet faultStatistics = sxssfWorkbook.getXSSFWorkbook().getSheetAt(2);
//            //设置第一个Sheet（24h各地开工率情况（Top10））的内容
//            XSSFCell sum_actice_device_num = workRatio.getRow(1).createCell(1);
//            XSSFCell sum_work_device_num = workRatio.getRow(1).createCell(2);
//            XSSFCell sum_work_ratio = workRatio.getRow(1).createCell(3);
//            for (int i = 4; i < 10; i++) {
//                XSSFCell region = workRatio.createRow(i).createCell(0);
//                XSSFCell actice_device_num = workRatio.getRow(i).createCell(1);
//                XSSFCell work_device_num = workRatio.getRow(i).createCell(2);
//                XSSFCell work_ratio = workRatio.getRow(i).createCell(3);
//            }
//            //设置第二个sheet（各地设备注册总量情况（Top10））的内容
//            XSSFCell sum_register_device_num = machineRegisterCount.getRow(1).createCell(1);
//            sum_register_device_num.setCellValue("10248");
//            for (int i = 4; i < 10; i++) {
//                XSSFCell region = machineRegisterCount.createRow(i).createCell(0);
//                XSSFCell register_device_num = machineRegisterCount.getRow(i).createCell(1);
//            }
//
//            //设置第三个sheet（故障统计表（Top10））的内容
//            for (int i = 1; i < 10; i++) {
//                XSSFCell name = faultStatistics.createRow(i).createCell(0);
//                XSSFCell num = faultStatistics.getRow(i).createCell(1);
//                XSSFCell ratio = faultStatistics.getRow(i).createCell(2);
//                XSSFCell device_type = faultStatistics.getRow(i).createCell(3);
//                XSSFCell description = faultStatistics.getRow(i).createCell(4);
//            }
//
//            OutputStream outputStream = new FileOutputStream("/test.xlsx");
//            xssfWorkbook.write(outputStream);
//            outputStream.flush();
//            outputStream.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//
