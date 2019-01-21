package es.iessaladillo.pedrojoya.pr08.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import es.iessaladillo.pedrojoya.pr08.MainActivityViewModel;
import es.iessaladillo.pedrojoya.pr08.R;
import utils.ToastUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailFragment extends Fragment {


    public static DetailFragment newInstance() {
        return new DetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        MainActivityViewModel vmMA = ViewModelProviders.of(requireActivity()).get(MainActivityViewModel.class);
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        setupToolbar();
        setupListeners();
        vmMA.setLaunchDetailFragment(false);
    }

    private void setupListeners() {
        FloatingActionButton fab = ActivityCompat.requireViewById(requireActivity(), R.id.fabDetailfrag);
        fab.setOnClickListener(v -> ToastUtils.toast(getContext(),"Details have been saved"));
    }


    private void setupToolbar() {
        Toolbar toolbar = ActivityCompat.requireViewById(requireActivity(),R.id.toolBarDetailFrag);
        toolbar.setTitle(getString(R.string.mainFrag_title));
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setNavigationOnClickListener(v -> requireActivity().onBackPressed());
    }


}
