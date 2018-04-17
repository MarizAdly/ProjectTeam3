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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText password;
    EditText email;
    Button signup;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in );


      password = findViewById ( R.id.pw );
      email = findViewById ( R.id.email );
      signup = findViewById ( R.id.signup );
      signin = findViewById ( R.id.login );

        mAuth = FirebaseAuth.getInstance();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("child");
        myRef.push ().setValue("user");

    }

    public void signUp(View view){
        // ha get l intent fady mn 8er ay user
        Intent mainIntent = new Intent ( this, SignUpActivity.class );
       this.startActivity(mainIntent);
    }



    public void signIn(View view) {
        mAuth.signInWithEmailAndPassword(email.getText ().toString (), password.getText ().toString ())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult> () {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful ()) {

                            FirebaseUser user = mAuth.getCurrentUser ();

                        } else {

                            Toast.makeText ( SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT ).show ();

                        }

                    }
                });
    }
}
