package com.kkwagh.kkw_poly;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import java.util.HashMap;

import static com.kkwagh.kkw_poly.URLenvActivity.register_api;

public class RegistrationActivity extends AppCompatActivity {
    AppCompatRadioButton rbleft, rbright;
    EditText student_name, password_registration, confirm_password, parent_phone_no, email, address, city, taluka, district, state, standard;
    String StudentNameHolder, PasswordHolder, ConfirmPasswordHolder, ParentPhoneNoHolder, EmailHolder, AddressHolder, CityHolder, TalukaHolder, DistrictHolder, StateHolder, StandardHolder, QuestionHolder = "1";
    Button register;
    String PhoneNoHolder;
    String finalResult;
    Boolean CheckEditText;
    String HttpURL = register_api;
    HashMap<String, String> hashMap = new HashMap<>();
    HttpParser httpParse = new HttpParser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        student_name = findViewById(R.id.student_name);
        password_registration = findViewById(R.id.password_registration);
        confirm_password = findViewById(R.id.confirm_password);
        parent_phone_no = findViewById(R.id.parent_phone_no);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        taluka = findViewById(R.id.taluka);
        district = findViewById(R.id.district);
        state = findViewById(R.id.state);
        standard = findViewById(R.id.standard);
        register = findViewById(R.id.register);

        rbleft = findViewById(R.id.rbleft);
        rbright = findViewById(R.id.rbright);

        Intent intent = getIntent();
        PhoneNoHolder = intent.getStringExtra("phone_no");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckEditTextIsEmptyOrNot();
                if (CheckEditText) {
                    UserRegisterFunction(PhoneNoHolder, StudentNameHolder, PasswordHolder, ParentPhoneNoHolder, EmailHolder, AddressHolder, CityHolder, TalukaHolder, DistrictHolder, StateHolder, StandardHolder, QuestionHolder);
                } else {
                    Toast.makeText(RegistrationActivity.this, "Please fill all form fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void CheckEditTextIsEmptyOrNot() {
        StudentNameHolder = student_name.getText().toString();
        PasswordHolder = password_registration.getText().toString();
        ConfirmPasswordHolder = confirm_password.getText().toString();
        ParentPhoneNoHolder = parent_phone_no.getText().toString();
        EmailHolder = email.getText().toString();
        AddressHolder = address.getText().toString();
        CityHolder = city.getText().toString();
        TalukaHolder = taluka.getText().toString();
        DistrictHolder = district.getText().toString();
        StateHolder = state.getText().toString();
        StandardHolder = standard.getText().toString();

        CheckEditText = !TextUtils.isEmpty(StudentNameHolder) && !TextUtils.isEmpty(PasswordHolder) && !TextUtils.isEmpty(ConfirmPasswordHolder) && !TextUtils.isEmpty(ParentPhoneNoHolder) && !TextUtils.isEmpty(EmailHolder) && !TextUtils.isEmpty(AddressHolder) && !TextUtils.isEmpty(CityHolder) && !TextUtils.isEmpty(TalukaHolder) && !TextUtils.isEmpty(DistrictHolder) && !TextUtils.isEmpty(StateHolder) && !TextUtils.isEmpty(StandardHolder);
    }

    public void UserRegisterFunction(final String mobile_no, final String password, final String name, final String parent_mobile, final String email, final String address, final String city, final String taluka, final String district, final String state, final String std, final String question) {
        class UserRegisterFunctionClass extends AsyncTask<String, Void, String> {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String httpResponseMsg) {
                super.onPostExecute(httpResponseMsg);
                Toast.makeText(RegistrationActivity.this, httpResponseMsg, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                hashMap.put("mobile_no", params[0]);
                hashMap.put("name", params[1]);
                hashMap.put("password", params[2]);
                hashMap.put("parent_mobile", params[3]);
                hashMap.put("email", params[4]);
                hashMap.put("address", params[5]);
                hashMap.put("city", params[6]);
                hashMap.put("taluka", params[7]);
                hashMap.put("district", params[8]);
                hashMap.put("state", params[9]);
                hashMap.put("std", params[10]);
                hashMap.put("question", params[11]);
                finalResult = httpParse.postRequest(hashMap, HttpURL);
                return finalResult;
            }
        }
        UserRegisterFunctionClass userRegisterFunctionClass = new UserRegisterFunctionClass();
        userRegisterFunctionClass.execute(mobile_no, password, name, parent_mobile, email, address, city, taluka, district, state, std, question);
    }

    public void onRadioButtonClicked(View view){
        boolean isSelected = ((AppCompatRadioButton)view).isChecked();
        switch (view.getId()){

            case R.id.rbleft:
                if (isSelected){
                    QuestionHolder = "1";
                    rbleft.setTextColor(Color.WHITE);
                    rbright.setTextColor(Color.BLACK);
                }

                break;
            case R.id.rbright:

                if (isSelected){
                    QuestionHolder = "0";
                    rbright.setTextColor(Color.WHITE);
                    rbleft.setTextColor(Color.BLACK);
                }
                break;
        }
    }
}
