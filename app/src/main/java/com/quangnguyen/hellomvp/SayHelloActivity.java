package com.quangnguyen.hellomvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Quang Nguyen on 3/26/17.
 *
 * An implementation of the View
 */

public class SayHelloActivity extends AppCompatActivity implements SayHelloContract.View, View.OnClickListener {

    private SayHelloContract.Presenter mPresenter;

    //UI properties
    private TextView mMessageView;
    private EditText mFirstNameView;
    private EditText mLastNameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_screen);
        initViews();

        // Creates presenter
        mPresenter = new SayHelloPresenter(this);
    }

    private void initViews() {
        mMessageView = (TextView) findViewById(R.id.message);
        mFirstNameView = (EditText) findViewById(R.id.firstName);
        mLastNameView = (EditText) findViewById(R.id.lastName);

        findViewById(R.id.update).setOnClickListener(this);
        findViewById(R.id.showMessage).setOnClickListener(this);
    }

    @Override
    public void showMessage(String message) {
        mMessageView.setText(message);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    /**
     * The View only receives user's action and leaves all remaining tasks for the Presenter
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.update:
                mPresenter.saveName(mFirstNameView.getText().toString(),
                        mLastNameView.getText().toString());
                break;
            case R.id.showMessage:
                mPresenter.loadMessage();
                break;
        }
    }
}
