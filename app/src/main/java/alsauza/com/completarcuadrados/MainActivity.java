package alsauza.com.completarcuadrados;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import alsauza.com.completarcuadrados.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity implements SecondFragment.OnFragmentInteractionListener,thirdFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
