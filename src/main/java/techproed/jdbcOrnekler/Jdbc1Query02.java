package techproed.jdbcOrnekler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// import java.sql.*; => Java mySQL den gelen tum import lari icerir

public class Jdbc1Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root","Amine889316");

		Statement st = con.createStatement();
		
		/*=======================================================================
		 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
		========================================================================*/ 
		// select * from bolumler; => Normalde mySQL de bu kod blogu ile sonuc aliniyordu.
		
		ResultSet tablo = st.executeQuery("SELECT*from bolumler");
		
		while(tablo.next()) {
			
			System.out.println(tablo.getInt(1) + " " + tablo.getString("bolum_isim") + " " +tablo.getString(3) );
		}
		
		System.out.println("===============================================");
		
		/*=======================================================================
		 ORNEK2: SATIS ve MUHASEBE bolumlerinde calisan personelin isimlerini ve 
/		 maaslarini, maas ters sirali olarak listeleyiniz
	    ========================================================================*/ 
		
		ResultSet tablo1= st.executeQuery("Select isim, maas from personel "
														+ "	where bolum_id in(10,30) "
														+ " order by maas desc");
		
		while(tablo1.next()) {
			
			System.out.println(tablo1.getString(1)+" "+tablo1.getInt(2));
			
		}
		/* HOCANIN COZUMU  (ORNEK 2)
		 * ResultSet tablo2=st.executeQuery("SELECT isim, maas "
				+ " FROM personel "
				+ " WHERE bolum_id in(10,30)"
				+ " ORDER BY maas DESC" );
		
		while(tablo2.next()) {
			
			System.out.println(tablo2.getString("isim") + "\t"+   tablo2.getInt(2));
		}
		 */
		
		System.out.println("=====================================");
		
		/*=======================================================================
		  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
		  ve maaslarini, bolum ve maas sirali listeleyiniz. 
		  NOT: calisani olmasa bile bolum ismi gosterilmelidir.
		========================================================================*/
		
		
		ResultSet tablo2= st.executeQuery("Select b.bolum_isim, p.isim, p.maas from bolumler b left join personel p "
										+ "on p.bolum_id=b.bolum_id "
										+ " order by p.isim, p.maas");

		while(tablo2.next()) {
			System.out.println(tablo2.getString("bolum_isim")+"\t"+tablo2.getString("isim")+"\t"+tablo2.getInt(3));
			
		}
		
		
		System.out.println("=====================================");
		
		/*=======================================================================
 		  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
 		========================================================================*/ 
		// Istedigimiz veriler daha cok personel de oldugu icin left join dememiz gerekir
		
		ResultSet tablo3= st.executeQuery("Select b.bolum_isim, p.isim, p.maas from personel p left join bolumler b "
				                        + " on p.bolum_id=b.bolum_id "
				                        + " order by maas desc "
				                        + " limit 10 ");
		
		while(tablo3.next()) {
			System.out.println(tablo3.getString(1)+" "+tablo3.getString("isim")+" "+tablo3.getInt(3));
		}
		
		
		
		
		
		
		con.close();
		st.close();
		tablo.close();
		tablo1.close();
		tablo2.close();
		tablo3.close();
		

	}

}
