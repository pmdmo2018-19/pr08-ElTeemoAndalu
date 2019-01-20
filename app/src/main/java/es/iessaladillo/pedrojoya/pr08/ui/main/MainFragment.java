package es.iessaladillo.pedrojoya.pr08.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import es.iessaladillo.pedrojoya.pr08.MainActivityViewModel;
import es.iessaladillo.pedrojoya.pr08.R;

public class MainFragment extends Fragment {

    private MainViewModel vm;
    private Toolbar toolbar;
    FloatingActionButton fabMain;
    private MainActivityViewModel vmMA;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        vm = ViewModelProviders.of(this).get(MainViewModel.class);
        vmMA = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel.class);
        setHasOptionsMenu(true);
        setupViews();
        setupToolbar();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void setupViews() {
        fabMain = ActivityCompat.requireViewById(requireActivity(),R.id.fabMainFrag);
        toolbar = ActivityCompat.requireViewById(requireActivity(),R.id.toolBarMainFrag);

        setupListeners();
    }

    private void setupListeners() {
        fabMain.setOnClickListener(v -> vmMA.goToDetailFragment());
    }

    private void setupToolbar() {
        toolbar.setTitle(getString(R.string.title_MainFrag));
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
    }



}
