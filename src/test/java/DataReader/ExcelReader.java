package DataReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {

    public String[][] readExcel(String filePath, String fileName, String sheetName) throws IOException {
        File file = new File(filePath+"\\"+fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        String[][] excelArray = null;
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        excelArray = new String[rowCount+1][1];
        for (int i=1; i<rowCount+1; i++){
            Row row = sheet.getRow(i);
            for (int j=0; j<row.getLastCellNum(); j++){
                excelArray[i][j] = row.getCell(j).getStringCellValue().toString();
            }
        }
        return excelArray;
    }
}
