package piedroid.stp.com.team3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
EditText username;
    EditText password;
    EditText confirmPassword;
    EditText email;
    EditText phone;
    EditText address;
    Button signUp;
    User user;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_sign_up );

   username = findViewById ( R.id.name );
   password = findViewById ( R.id.pw );
   confirmPassword = findViewById (  R.id.confirmPW );
   email = findViewById ( R.id.email );
   phone = findViewById ( R.id.phone );
   address = findViewById ( R.id.address );
   signUp = findViewById ( R.id.signup );

        mAuth = FirebaseAuth.getInstance();

        Intent mainIntent = getIntent ();
        user = new User ();
    }


    public void signUp(View view) {
        mAuth.createUserWithEmailAndPassword(email.getText ().toString (), password.getText ().toString ())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Authentication succeeded.",
                                    Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(SignUpActivity.this, "Authentication failed." + task.getException ().toString (),
                                    Toast.LENGTH_SHORT).show();

                        }

                    }
                });
user.setAddress ( address.getText ().toString () );
user.setEmail (email.getText ().toString () );
user.setPassword ( password.getText ().toString () );
user.setPhone ( phone.getText ().toString () );
user.setUsername ( username.getText ().toString () );
    }
}
