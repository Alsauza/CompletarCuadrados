package alsauza.com.completarcuadrados;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.text.HtmlCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import io.github.kexanie.library.MathView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecondFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2,sal,signo_intermedio;
    private MathView paso_cero,paso_uno,paso_dos,paso_tres,paso_cuatro;
    private int numero_de_pasos,a,b,c,apositivo,bpositivo;
    private TextView explicacion;

    private OnFragmentInteractionListener mListener;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_second, container, false);

        explicacion=(TextView)fragmentView.findViewById(R.id.explica);
        paso_cero=((MathView)fragmentView.findViewById(R.id.textView2));
        paso_uno=((MathView)fragmentView.findViewById(R.id.pasoUno));
        paso_dos=((MathView)fragmentView.findViewById(R.id.pasoDos));
        paso_tres=((MathView)fragmentView.findViewById(R.id.pasoTres));
        paso_cuatro=(MathView)fragmentView.findViewById(R.id.pasoCuatro);
        inicializa();

        final Button siguiente_paso=(Button)fragmentView.findViewById(R.id.sigPaso);
        siguiente_paso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            numero_de_pasos=numero_de_pasos+1;

            switch (numero_de_pasos){

                case 1:
                    paso_uno.setText(" $$"+a+"(........)"+""+c+"=0 $$");
                    if(c>0)paso_uno.setText(" $$"+a+"(........)"+"+"+c+"=0 $$");
                    sal="<p>Abrimos un paréntesis</p>\n"+
                            "<p>Fuera del paréntesis ponemos el coeficiente de</p>\n"+"<p>"+a+"x <sup>2</sup></p>\n";
                    explicacion.setText(HtmlCompat.fromHtml(sal, 0));;
                    break;

                case 2:
                    if((a/b)>0){signo_intermedio="+";}
                    else {signo_intermedio="-";}

                    paso_dos.setText(" $$"+a+"(x^2 "+signo_intermedio+"  \\frac{"+bpositivo+"}{"+apositivo+"}x)"+""+c+"=0 $$");
                    if(c>0)paso_dos.setText(" $$"+a+"(x^2 "+signo_intermedio+" \\frac{"+bpositivo+"}{"+apositivo+"}x)"+"+"+c+"=0 $$");
                    sal="<p>Dentro del paréntesis ponemos:</p>\n"+
                            "<p> x<sup>2</sup> sin el "+a+"</p> " +
                            "<p>y "+b+" dividido entre "+a+"</p>";
                    explicacion.setText(HtmlCompat.fromHtml(sal, 0));;

                    break;

                case 3:
                    paso_tres.setText(" $$"+a+"(x^2 "+signo_intermedio+"  \\frac{"+bpositivo+"}{"+apositivo+
                            "}x + (\\frac{"+bpositivo+"}{2*"+apositivo+"})^2)"+""+c+"=(\\frac{"+bpositivo+"}{2*"+apositivo+"})^2 $$");

                    if(c>0)paso_tres.setText(" $$"+a+"(x^2 "+signo_intermedio+"  \\frac{"+bpositivo+"}{"+apositivo+
                            "}x + (\\frac{"+bpositivo+"}{2*"+apositivo+"})^2)"+"+"+c+"=(\\frac{"+bpositivo+"}{2*"+apositivo+"})^2 $$");

                    break;
                case 4:
                    int b_cuadrada=b*b;
                    int doble_a_cuadrado= (2*a)*(2*a);
                    paso_cuatro.setText(" $$"+a+"(x^2 "+signo_intermedio+"  \\frac{"+bpositivo+"}{"+apositivo+
                            "}x + \\frac{"+b_cuadrada+"}{"+doble_a_cuadrado+"})"+""+c+"=\\frac{"+b_cuadrada+"}{"+doble_a_cuadrado+"} $$");

                    if(c>0)paso_cuatro.setText(" $$"+a+"(x^2 "+signo_intermedio+"  \\frac{"+bpositivo+"}{"+apositivo+
                            "}x + \\frac{"+b_cuadrada+"}{"+doble_a_cuadrado+"})"+"+"+c+"=\\frac{"+b_cuadrada+"}{"+doble_a_cuadrado+"} $$");

                default:
                siguiente_paso.setVisibility(View.INVISIBLE);

            }




                }


        });
        return fragmentView;
    }

    private void inicializa() {
        numero_de_pasos=0;
        generaEcuacion();
    }

    private void generaEcuacion() {
        String stra,strb,strc;
        a=b=c=apositivo=bpositivo=0;

            a=((int)(Math.random()*9+1))*((int)Math.pow(-1,(int)(Math.random()*9+1)));


            stra=""+a+"x^2";

            b=((int)(Math.random()*9+1))*((int)Math.pow(-1,(int)(Math.random()*9+1)));
            if(b>0 ){strb="+"+b+"x";}
            else {strb=""+b+"x";}

            c=((int)(Math.random()*9+1))*((int)Math.pow(-1,(int)(Math.random()*9+1)));
            if(c>0){strc="+"+c;}
            else {strc=""+c;}


            paso_cero.setText(" $$"+stra+""+strb+""+strc+"=0 $$");

        apositivo=a;
        bpositivo=b;
        if(a<0)apositivo=-a;
        if(b<0)bpositivo=-b;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
