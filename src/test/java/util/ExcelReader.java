package util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public static List<Map<String, Object>> getRecords(String sheetName) {
        List<Map<String, Object>> records = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(new FileInputStream(getFilePath(sheetName,"xlsx")));
            Sheet firstSheet = workbook.getSheetAt(0);
            List<String> headers = new ArrayList<>();
            Row firstRow = firstSheet.getRow(0);
            for (int i = 0; i < firstRow.getLastCellNum(); i++) {
                headers.add(firstRow.getCell(i).getStringCellValue());
            }

            for (int i = 1; i < firstSheet.getLastRowNum(); i++) {
                Row row = firstSheet.getRow(i);
                HashMap<String, Object> record = new HashMap<>();
                for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
                    switch (row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getCellType()) {
                        case NUMERIC:
                            record.put(headers.get(j), row.getCell(j).getNumericCellValue());
                            break;
                        case STRING:
                            record.put(headers.get(j), row.getCell(j).getStringCellValue());
                            break;
                        case BLANK:
                            record.put(headers.get(j), null);
                            break;
                    }
                }
                records.add(record);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;

    }

    public static String getFilePath(String fileName, String fileType){
        return System.getProperty("user.dir")+"/src/test/resources/download/"+fileName+"."+fileType;
    }
}


