package com.example.rodneytressler.week3assessmentkey;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by rodneytressler on 12/14/17.
 */

public class AccountFragment extends Fragment {

    private CallbackClass callback;

    @BindView(R.id.name_input)
    protected EditText nameInput;

    @BindView(R.id.class_input)
    protected EditText classInput;

    @OnClick(R.id.button_finish)
    protected void onFinishButtonClicked(View view) {
        String nameString = nameInput.getText().toString();
        String accountRole = classInput.getText().toString();
        if (nameString.length() <= 0 &&
                accountRole.length() <= 0) {

            showAlertDialog(getString(R.string.include_all));

        } else if (!accountRole.equalsIgnoreCase("mage") &&
                !accountRole.equalsIgnoreCase("archer") &&
                !accountRole.equalsIgnoreCase("warrior")) {
            showAlertDialog(getString(R.string.class_incorrect));
        } else {
            Account account = new Account(nameString, accountRole);
            callback.createAccount(account);
        }
    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_creation, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public static AccountFragment newInstance() {

        Bundle args = new Bundle();

        AccountFragment fragment = new AccountFragment();
        fragment.setArguments(args);
        return fragment;
    }



    private void showAlertDialog(String message) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(getContext(), android.R.style.Theme_Material_Light_Dialog);
        } else {
            builder = new AlertDialog.Builder(getContext());
        }
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void setCallback(CallbackClass callback) {
        this.callback = callback;
    }

//    private void createAccount(Account account) {
//        callback.createAccount(account);
//    }

    public interface CallbackClass {
        void createAccount(Account account);
    }
}
