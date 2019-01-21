package es.iessaladillo.pedrojoya.pr08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<Boolean> launchDetailFragment = new MutableLiveData<>();

    MutableLiveData<Boolean> launchSettingsFragment = new MutableLiveData<>();



    MainActivityViewModel(){
        launchDetailFragment.setValue(false);
        launchSettingsFragment.setValue(false);
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
}
