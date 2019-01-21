package es.iessaladillo.pedrojoya.pr08;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.preference.PreferenceManager;
import es.iessaladillo.pedrojoya.pr08.ui.settings.SharedPreferencesStringLiveData;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> launchDetailFragment = new MutableLiveData<>();

    private MutableLiveData<Boolean> launchSettingsFragment = new MutableLiveData<>();

    private final LiveData<String> loremType;


    MainActivityViewModel(@NonNull Application application) {
        super(application);
        launchDetailFragment.setValue(false);
        launchSettingsFragment.setValue(false);
        loremType = new SharedPreferencesStringLiveData(
                PreferenceManager.getDefaultSharedPreferences(application),
                application.getString(R.string.listPreferenceKey),
                application.getString(R.string.prefLoremType));
    }

    public LiveData<Boolean> getLaunchDetailFragment() {
        return launchDetailFragment;
    }

    public void setLaunchDetailFragment(boolean bool) {
        launchDetailFragment.setValue(bool);
    }

    public LiveData<Boolean> getLaunchSettingsFragment() {
        return launchSettingsFragment;
    }

    public void setLaunchSettingsFragment(boolean bool) {
        launchSettingsFragment.setValue(bool);
    }

    public LiveData<String> getLoremType() {
        return loremType;
    }
}
