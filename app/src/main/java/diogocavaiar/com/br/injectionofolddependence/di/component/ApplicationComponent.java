package diogocavaiar.com.br.injectionofolddependence.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import diogocavaiar.com.br.injectionofolddependence.App;
import diogocavaiar.com.br.injectionofolddependence.data.DataManager;
import diogocavaiar.com.br.injectionofolddependence.data.db.DbHelper;
import diogocavaiar.com.br.injectionofolddependence.data.prefs.SharedPrefsHelper;
import diogocavaiar.com.br.injectionofolddependence.di.ApplicationContext;
import diogocavaiar.com.br.injectionofolddependence.di.module.ApplicationModule;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(App app);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}
