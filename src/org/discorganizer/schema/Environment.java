/**
 * 
 */
package org.discorganizer.schema;

import org.discorganizer.ApplicationState;
import org.discorganizer.Constants;
import org.discorganizer.EnvironmentType;

/**
 * @author Salih.KARAHAN
 *
 */
public class Environment {
	private EnvironmentType _environmentType;
	private final String _pathSeperator;

	/**
	 * 
	 */
	public Environment() {
		// TODO Auto-generated constructor stub
		
	}

	/**
	 * 
	 */
	public ApplicationState CheckInitialDirectoryAndFiles() {
		// TODO Auto-generated method stub
		// return null;

		// TODO #2: Test etme amacıyla şimdilik NotInitialize dönülmüştür! Daha
		// sonra burada bazı kontroller sonucu uygulamanın diskteki durumunu
		// çözümleyecek bir işlemin gerçekleştirilmesi gerekmektedir!
		return ApplicationState.NotInitialize;
	}

	public EnvironmentType GetEnvironmentType() {
		return _environmentType;
	}
	
	private EnvironmentType SetEnvironmentType(){
		
		switch (System.getProperty(Constants.SystemProperty.OS_NAME)) {
		case "Windows 8.1":
			return EnvironmentType.Windows;

		default:
			
			break;
		}
	}

}
