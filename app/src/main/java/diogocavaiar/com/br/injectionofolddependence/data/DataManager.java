package diogocavaiar.com.br.injectionofolddependence.data;

import android.content.Context;
import android.content.res.Resources;

import javax.inject.Inject;
import javax.inject.Singleton;

import diogocavaiar.com.br.injectionofolddependence.data.db.DbHelper;
import diogocavaiar.com.br.injectionofolddependence.data.db.model.User;
import diogocavaiar.com.br.injectionofolddependence.data.prefs.SharedPrefsHelper;
import diogocavaiar.com.br.injectionofolddependence.di.ApplicationContext;

@Singleton
public class DataManager {

    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        mContext = context;
        mDbHelper = dbHelper;
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void saveAccessToken(final String accessToken) {
        mSharedPrefsHelper.put(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, accessToken);
    }

    public String getAccessToken(){
        return mSharedPrefsHelper.get(SharedPrefsHelper.PREF_KEY_ACCESS_TOKEN, null);
    }

    public Long createUser(final User user) throws Exception {
        return mDbHelper.insertUser(user);
    }

    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return mDbHelper.getUser(userId);
    }

}
