package diogocavaiar.com.br.injectionofolddependence.di.module;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import diogocavaiar.com.br.injectionofolddependence.di.ActivityContext;

@Module
public class ActivityModule {

    private final Activity mActivity;

    public ActivityModule(final Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
