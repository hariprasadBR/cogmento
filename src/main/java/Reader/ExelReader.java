package Reader;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelReader {
private XSSFSheet sheet;
	public ExelReader(String filename,int index) throws IOException{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Testdata\\"+filename);
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		this.sheet=workbook.getSheetAt(index);
		
	}
	public Object getSpecificCellData(int row, int column) {
		XSSFCell cells = sheet.getRow(row).getCell(column);
		
		if(cells.getCellType()==XSSFCell.CELL_TYPE_STRING) {
			return cells.getStringCellValue();
		}
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_NUMERIC) {
			return cells.getRawValue();
		}
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_BOOLEAN) {
			return cells.getBooleanCellValue();
		}
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_FORMULA) {
			return cells.getCellFormula();
		}
		else if(cells.getCellType()==XSSFCell.CELL_TYPE_BLANK) {
			return "";
		}
		else {
			return null;
		}
		
		
		
	}
	public Object [][] getAllData(){
		int totalRows= sheet.getLastRowNum()+1;
		
		int totalColumns = sheet.getRow(0).getLastCellNum();
		
		Object [][] data = new Object[totalRows][totalColumns];
		
		for(int i=0; i< totalRows; i++) {
			for(int j=0; j<totalColumns; j++) {
				data[i][j]= getSpecificCellData(i, j);
			}
		}
		
		return data;
	}
}
