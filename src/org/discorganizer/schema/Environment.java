/**
 * 
 */
package org.discorganizer.schema;

import org.discorganizer.ApplicationState;
import org.discorganizer.EnvironmentType;

/**
 * @author Salih.KARAHAN
 *
 */
public class Environment {
	private EnvironmentType _environmentType;
	// private String

	/**
	 * 
	 */
	public Environment() {
		// TODO Auto-generated constructor stub
		this._environmentType = EnvironmentType.Windows;
	}

	/**
	 * 
	 */
	public ApplicationState CheckInitialDirectoryAndFiles() {
		// TODO Auto-generated method stub
		// return null;

		// TODO #2: Test etme amac�yla �imdilik NotInitialize d�n�lm��t�r! Daha
		// sonra burada baz� kontroller sonucu uygulaman�n diskteki durumunu
		// ��z�mleyecek bir i�lemin ger�ekle�tirilmesi gerekmektedir!
		return ApplicationState.NotInitialize;
	}

	public EnvironmentType GetEnvironmentType() {
		return _environmentType;
	}

}
