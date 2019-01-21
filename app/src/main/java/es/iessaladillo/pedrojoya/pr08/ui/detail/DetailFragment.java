package es.iessaladillo.pedrojoya.pr08.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import es.iessaladillo.pedrojoya.pr08.R;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

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
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
        setupToolbar();
    }


    private void setupToolbar() {
        Toolbar toolbar = ActivityCompat.requireViewById(requireActivity(),R.id.toolBarDetailFrag);
        toolbar.setTitle(getString(R.string.mainFrag_title));
        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);
    }

}
