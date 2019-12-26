package alsauza.com.completarcuadrados.ui.main;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import alsauza.com.completarcuadrados.R;
import io.github.kexanie.library.MathView;

public class MainFragment extends Fragment {
    MathView tercer_encabezado;
    private MainViewModel mViewModel;

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
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        tercer_encabezado=(MathView)getView().findViewById(R.id.tercerEncabezado);
        Button explicacionBtn=(Button)getView().findViewById(R.id.button);
        Button ejerciciosBtn=(Button)getView().findViewById(R.id.button2);
        tercer_encabezado.setText(" $$x^2+bx+c=0 $$");
        explicacionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_mainFragment_to_secondFragment);
            }
        });

        ejerciciosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(
                        R.id.action_mainFragment_to_thirdFragment);
            }
        });
    }

}
