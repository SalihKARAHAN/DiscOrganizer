/**
 * 
 */
package org.diskmanager;

import org.diskmanager.library.ioc.Container;
import org.diskmanager.manager.EnvironmentManager;
import org.diskmanager.manager.LinuxIOManager;
import org.diskmanager.manager.MacIOManager;
import org.diskmanager.manager.WindowsIOManager;
import org.diskmanager.provider.contract.IEnvironmentProvider;
import org.diskmanager.provider.contract.IIOManager;
import org.diskmanager.schema.Directory;
import org.diskmanager.schema.Environment;
import org.diskmanager.schema.File;

/**
 * @author Salih.KARAHAN
 *
 */
public final class Setup {

	/**
	 * 
	 */
	private ApplicationState _state;

	/**
	 * Bu metot uygulama her �al��t���nda bulundu�u disk �zerinde daha �nce
	 * uygulam�n�n �al���p �al��mad���n� kontrol edecek E�er eski kay�tlar varsa
	 * o kay�tlar� okuyorak sistemi a�acak E�er ilk defa a��l�yorsa sistem i�in
	 * gereklilikleri haz�rlayacak ve sistemi ba�latacak
	 */
	public void CheckSystem() {
		Environment environment = EnvironmentManager.GetEnvironment();

		RegisterSystemComponents(environment.GetEnvironmentType());

		_state = environment.CheckInitialDirectoryAndFiles();
	}

	/**
	 * @param getEnvironmentType
	 */
	private void RegisterSystemComponents(EnvironmentType environmentType) {
		// TODO Auto-generated method stub
		switch (environmentType) {
		case Windows: {
			Container.Register(IIOManager.class, WindowsIOManager.class);
		}
			break;
		case Mac: {
			Container.Register(IIOManager.class, MacIOManager.class);
		}
			break;
		case Linux: {
			Container.Register(IIOManager.class, LinuxIOManager.class);
		}
			break;

		default: {

		}
			break;
		}
	}

	/**
	 * Second Method
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 * @throws Exception
	 */
	public void Bootstrap() throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub

		switch (_state) {
		case NotInitialize: {
			Initialize();
		}
			break;
		case Broken: {

		}
			break;
		case Initialized: {
			Load();
		}
			break;

		default: {

		}
			break;
		}

	}

	/**
	 * 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private void Initialize() throws InstantiationException, IllegalAccessException {
		IEnvironmentProvider environmentProvider = Container.Resolve(IEnvironmentProvider.class);
		IIOManager io = Container.Resolve(IIOManager.class);
		Directory systemDirectory = io.CreateDirectory(".Disk", environmentProvider.GetDiskRootPath());
		File settingsFile = io.CreateFile(".settings.json", Constants.DEFAULT_SETTINGS, systemDirectory.GetPath());
		// CategoryManager manager = Container.Resolve();
		// manager.CreateCategory(name);
	}

	/**
	 * For Load data
	 */
	private void Load() {

	}
}
