package dustyne.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private EditText user, pass;
    private TextView textView, textView2;
    private Button logIn;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFrag newInstance(String param1, String param2) {
        MainFrag fragment = new MainFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MainFrag() {
        // Required empty public constructor
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
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        user = (EditText) v.findViewById(R.id.username);
        pass = (EditText) v.findViewById(R.id.password);
        textView = (TextView) v.findViewById(R.id.textView);
        textView2 = (TextView) v.findViewById(R.id.textView2);

        logIn = (Button) v.findViewById(R.id.login);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
                int x = 0;
                if (username.length() > 0) {
                    textView.setText("");
                    x++;
                } else {
                    textView.setText("Please enter username");
                }
                if (password.length() > 0) {
                    textView2.setText("");
                    x++;

                } else {
                    textView2.setText("Please enter password");
                }
                if (x == 2) {
                    //logIn.setText("ADVANCE!");
                    //user.setVisibility(View.GONE);
                    //pass.setVisibility(View.GONE);
                    //textView.setVisibility(View.GONE);
                    //textView2.setVisibility(View.GONE);
                    //logIn.setVisibility(View.GONE);

                    MainActivity main = (MainActivity) getActivity();
                    main.saveData(user.getText().toString());

                    Log.v("Test", main.getData());

                    Fragment frag = new BlankFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.main_layout, frag);
                    ft.commit();


                } else {
                    //logIn.setText("Stay...");
                }
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
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
        public void onFragmentInteraction(Uri uri);
    }

}