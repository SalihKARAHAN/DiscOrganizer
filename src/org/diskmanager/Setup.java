/**
 * 
 */
package org.diskmanager;

/**
 * @author Salih.KARAHAN
 *
 */
public class Setup {
	/**
	 * Bu metot uygulama her �al��t���nda bulundu�u disk �zerinde daha �nce uygulam�n�n �al���p �al��mad���n� kontrol edecek
	 * E�er eski kay�tlar varsa o kay�tlar� okuyorak sistemi a�acak
	 * E�er ilk defa a��l�yorsa sistem i�in gereklilikleri haz�rlayacak ve sistemi ba�latacak
	 */
	void CheckSystem(){
		EnvironmentCollector.GetEnvironment();
		
	}
}
