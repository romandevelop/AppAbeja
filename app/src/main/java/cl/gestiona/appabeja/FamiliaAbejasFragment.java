package cl.gestiona.appabeja;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import cl.gestiona.appabeja.adapter.AdapterAbeja;
import cl.gestiona.appabeja.model.Abeja;


/**
 * A simple {@link Fragment} subclass.
 */
public class FamiliaAbejasFragment extends Fragment {


    public FamiliaAbejasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_familia_abejas, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list_recycler);
        LinearLayoutManager lm = new LinearLayoutManager(getContext());
        lm.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(lm);
        recyclerView.setAdapter(
                new AdapterAbeja(Abeja.familiaList(),
                R.layout.item_abeja,
                getActivity()));


        return view;
    }

}
