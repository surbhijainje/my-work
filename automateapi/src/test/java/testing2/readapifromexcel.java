package testing2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.restassured.RestAssured;

public class readapifromexcel {

	public static void main(String[] args) throws IOException {
		String fileName = "C:\\Users\\surbh\\Desktop\\listapis.xlsx";
		FileInputStream fis = new FileInputStream(new File(fileName));
		XSSFWorkbook ws = new XSSFWorkbook(fis);
		XSSFSheet sheet = ws.getSheet("apis");
		XSSFRow row = sheet.getRow(1);
		for (int i = 0; i < 2; i++) {
			row = sheet.getRow(i);
			String value = row.getCell(0).getStringCellValue();
		RestAssured.given().baseUri(value).log().all()
		.get()
		
		.then().log().all();

	}

}
}
