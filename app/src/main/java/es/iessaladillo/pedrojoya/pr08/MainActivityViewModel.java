package es.iessaladillo.pedrojoya.pr08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {

    MutableLiveData<Boolean> launchDetailFragment = new MutableLiveData<>();

    MainActivityViewModel(){
        launchDetailFragment.setValue(false);
    }

    public void goToDetailFragment(){
        launchDetailFragment.setValue(true);
    }

    public LiveData<Boolean> getLaunchDetailFragment() {
        return launchDetailFragment;
    }

    public void setLaunchDetailFragment(boolean bool) {
        launchDetailFragment.setValue(bool);
    }
}
