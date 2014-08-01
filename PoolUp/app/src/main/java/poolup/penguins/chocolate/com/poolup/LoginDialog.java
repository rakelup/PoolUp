package poolup.penguins.chocolate.com.poolup;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

// LOGIN LOGIC
public class LoginDialog extends DialogFragment {

    private EditText mEditText;

    public LoginDialog() {
        // Empty constructor required for DialogFragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        if (CreatePoolActivity.getRegistrationStatus() == true) {
            view = inflater.inflate(R.layout.fragment_login, container);
            mEditText = (EditText) view.findViewById(R.id.login_et_password);
            getDialog().setTitle("Please confirm password!");
        } else {
            view = inflater.inflate(R.layout.fragment_register, container);
            getDialog().setTitle("Please register to use the App!");
        }


        return view;
    }
}