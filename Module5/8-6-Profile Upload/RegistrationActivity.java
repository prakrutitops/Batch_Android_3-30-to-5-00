package com.example.kids.ExtraActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.kids.R;

import net.gotev.uploadservice.MultipartUploadRequest;
import net.gotev.uploadservice.UploadNotificationConfig;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegistrationActivity extends AppCompatActivity {

    EditText edtname,edtemail,edtpass;
    Button btnregi;
    ProgressDialog pd;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String passPattern="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
    String UPLOAD_URL="https://rathod207.000webhostapp.com/db_files/animal/image_upload.php";
    CircleImageView imageView;
    //Image request code
    private int PICK_IMAGE_REQUEST = 1;
    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;
    //Bitmap to get image from gallery
    private Bitmap bitmap;
    //Uri to store the image uri
    private Uri filePath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        requestStoragePermission();

        //Initializing views
        imageView = findViewById(R.id.imageView);
        edtname=findViewById(R.id.reg_name);
        edtemail=findViewById(R.id.reg_email);
        edtpass=findViewById(R.id.reg_pass);
        btnregi=findViewById(R.id.btn_regi);
        pd = new ProgressDialog(this);
        pd.setMessage("Please Wait...");

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        });

        btnregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                uploadMultipart();
            }
        });
    }

    private void uploadMultipart() {
        pd.show();

        final String name= edtname.getText().toString().trim();
        final String email = edtemail.getText().toString().trim();
        final String pass = edtpass.getText().toString().trim();
        String path = getPath(filePath);

        try {
            if (name.equals("")) {
                pd.hide();
                edtname.setError("Enter Name.!");
            } else if (email.equals("")) {
                pd.hide();
                edtemail.setError("Enter Email.!");
            } else if (pass.equals("")) {
                pd.hide();
                edtpass.setError("Enter Password.!");
            } else if (email.matches(emailPattern) == false) {
                pd.hide();
                edtemail.setError("Invalid Email.!");
            } else if (pass.matches(passPattern) == false) {
                pd.hide();
                edtpass.setError("A-Z,a-z,0-9,$*%@");
            } else {
                pd.hide();
                String uploadId = UUID.randomUUID().toString();

                //Creating a multi part request
                new MultipartUploadRequest(this, uploadId,UPLOAD_URL)
                        .addFileToUpload(path, "img") //Adding file
                        .addParameter("name", name) //Adding text parameter to the request
                        .addParameter("email",email)
                        .addParameter("password",pass)
                        .setNotificationConfig(new UploadNotificationConfig())
                        .setMaxRetries(2)
                        .startUpload(); //Starting the upload
                Toast.makeText(this,"Registration successfully", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(i);

            }
        }catch (Exception exc) {
            Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show();

        }
    }

    private String getPath(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
        cursor.close();

        return path;

    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        //And finally ask for the permission
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);

    }
}
