package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2DDL {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root","Amine889316");

		Statement st = con.createStatement();
		
//		/*=======================================================================
//		  ORNEK1:isciler adinda bir tablo olusturunuz id int, 
//		  birim VARCHAR(10), maas int
//		========================================================================*/ 
//		String sorgu = "CREATE TABLE isciler"
//				 + " (id int primary key,"
//		         + " birim VARCHAR(10),"
//		         + " maas int)";
//	    
//	   
//	    //1.yöntem 
//	    
//        //boolean s1=st.execute(sorgu); // false veriyor boyle durumda false ve true vermesi dikkate alinmamali
//	    
//	    // execute() metodu DDL komutlarinda hep false deger dondurdugu icin 
//		// donus degerine bakmak gerekli degildir. Zaten komutun calismasi ile 
//		// ilgili bir sorun var ise SQL EXception olusacaktir.    
//        
//	    //System.out.println("isciler tablosu oluşturuldu" +s1);
//	    
//	    //2.yöntem
//	    
//	    st.execute(sorgu);
//	    System.out.println("isciler tablosu oluşturuldu");
//		
//	    /*======================================================================
//		  ORNEK2:isciler tablosunu siliniz 		
// 		========================================================================*/
//		 //st.execute("Drop Table isciler");
//		
//		 //System.out.println("Isciler tablosu silindi");
//		
//		/*=======================================================================
//		  ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar(20)} ekleyiniz.   
//	   	========================================================================*/
//	   	st.execute("alter table isciler ADD isim varchar(20)");
//	   	
//	   	System.out.println("Sutun ekleme islemi tamam");
//	   	
//	   	/*=======================================================================
//		  ORNEK4:isciler tablosuna soyisim VARCHAR(20) ve sehir VARCHAR(10)) 
//		  adinda 2 yeni sutun ekleyiniz.  
//		========================================================================*/
//	   	
//	   	st.execute("alter table isciler ADD (soy_isim varchar(20), sehir varchar(20))");
//	   	
//	   	System.out.println("işlem tamam");
//	   	
//	   	/*=======================================================================
////		  ORNEK5:isciler tablosundaki soyisim sutunu siliniz.
////		========================================================================*/ 
//		String alterQuery3 = "ALTER TABLE isciler DROP COLUMN birim";
//		st.execute(alterQuery3);
//////		
//		System.out.println("isciler tablosundan birim sutunu silindi..");
	
//		/*=======================================================================
//		  ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz.  
////		========================================================================*/
//		String alterQuery4 = "ALTER TABLE isciler RENAME TO calisanlar5";
//		st.execute(alterQuery4);
//		System.out.println("isciler tablosunun adi calisanlar olarak degismistir..");
//		
//		/*=======================================================================
//		  ORNEK7:calisanlar tablosunu siliniz.  
//		========================================================================*/
		String dropQuery2 = "DROP TABLE calisanlar5 ";
		st.execute(dropQuery2);
	
		System.out.println("calisanlar tablosu silindi..");
		
	}

}
