package dustyne.myapplication;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private EditText user, pass;
    private TextView textView, textView2;
    private Button logIn;

    public MainActivityFragment() {
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
                    logIn.setText("ADVANCE!");
                    //user.setVisibility(View.GONE);
                    //pass.setVisibility(View.GONE);
                    //textView.setVisibility(View.GONE);
                    //textView2.setVisibility(View.GONE);
                    //logIn.setVisibility(View.GONE);
                    //FragmentManager fM = getFragmentManager();
                    //FragmentTransaction fT = fM.beginTransaction();

                } else {
                    logIn.setText("Stay...");
                }
            }
        });

        return v;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
}