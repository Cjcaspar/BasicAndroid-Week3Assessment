package com.example.rodneytressler.week3assessmentkey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AccountFragment.CallbackClass{

    @BindView(R.id.welcome_text)
    protected TextView welcomeText;

    private AccountFragment accountFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        accountFragment = AccountFragment.newInstance();
        accountFragment.setCallback(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, accountFragment).commit();
    }

    @Override
    public void createAccount(Account account) {
        welcomeText.setText(getResources().getString(R.string.welcome_text, account.getName(), account.getAccountClass()));
        getSupportFragmentManager().beginTransaction().remove(accountFragment).commit();
    }
}
