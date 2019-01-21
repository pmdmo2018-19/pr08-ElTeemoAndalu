package es.iessaladillo.pedrojoya.pr08.ui.settings;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.preference.PreferenceFragmentCompat;
import es.iessaladillo.pedrojoya.pr08.MainActivityViewModel;
import es.iessaladillo.pedrojoya.pr08.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    
    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences,rootKey);
        setHasOptionsMenu(true);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        MainActivityViewModel vmMA = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel.class);
        super.onActivityCreated(savedInstanceState);
        setupToolbar();
        vmMA.setLaunchSettingsFragment(false);
    }

    private void setupToolbar() {
        Toolbar toolbar = ActivityCompat.requireViewById(requireActivity(),R.id.settingsToolbar);
        toolbar.setTitle(getString(R.string.mainFrag_title));
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v -> requireActivity().onBackPressed());
    }

}
