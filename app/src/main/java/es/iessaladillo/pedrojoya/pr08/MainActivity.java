package es.iessaladillo.pedrojoya.pr08;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.pr08.ui.detail.DetailFragment;
import es.iessaladillo.pedrojoya.pr08.ui.main.MainFragment;
import es.iessaladillo.pedrojoya.pr08.ui.settings.SettingsFragment;
import utils.FragmentUtils;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        vm = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        if (savedInstanceState == null) {
            FragmentUtils.replaceFragment(getSupportFragmentManager(),R.id.container,MainFragment.newInstance(),MainFragment.class.getSimpleName());
        }


        observeFragmentLaunch();
    }

    private void observeFragmentLaunch() {
        observeDetailLaunch();
        observeSettingsLaunch();
    }

    private void observeSettingsLaunch() {
        vm.getLaunchSettingsFragment().observe(this,settingsSwitch -> {
            if(settingsSwitch){
                replaceWithSettingsFragment();
            }
        });
    }

    private void observeDetailLaunch() {
        vm.getLaunchDetailFragment().observe(this,detailSwitch -> {
            if(detailSwitch){
                replaceWithDetailFragment();
            }
        });
    }

    private void replaceWithDetailFragment() {
        if(getSupportFragmentManager().findFragmentByTag(DetailFragment.class.getSimpleName()) == null){
            FragmentUtils.replaceFragmentAddToBackstack(getSupportFragmentManager(),R.id.container,DetailFragment.newInstance(),DetailFragment.class.getSimpleName(),DetailFragment.class.getSimpleName(),FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        }
    }

    private void replaceWithSettingsFragment() {
        if(getSupportFragmentManager().findFragmentByTag(DetailFragment.class.getSimpleName()) == null){
            FragmentUtils.replaceFragmentAddToBackstack(getSupportFragmentManager(),R.id.container,SettingsFragment.newInstance(),SettingsFragment.class.getSimpleName(),SettingsFragment.class.getSimpleName(),FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
