package id.sch.smktelkom_mlg.tugas01.xiirpl2026.psb_ssb_online;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNamaLengkap, etTahunLahir, etAlamat;
    TextView tvHasil;
    Button bDaftar;
    RadioButton rbLK,rbPR;
    RadioGroup rgStatus;
    CheckBox cbGK, cbDef, cbMid, cbSt;
    Spinner spClub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNamaLengkap = (EditText) findViewById(R.id.editTextNama);
        etTahunLahir = (EditText) findViewById(R.id.editTextTahunLahir);
        etAlamat = (EditText) findViewById(R.id.editTextAlamat);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        rbLK = (RadioButton) findViewById(R.id.radioButtonLK);
        rbPR = (RadioButton) findViewById(R.id.radioButtonPR);
        rgStatus = (RadioGroup) findViewById(R.id.RadioGroupStatus);
        cbGK = (CheckBox) findViewById(R.id.checkBoxGK);
        cbDef = (CheckBox) findViewById(R.id.checkBoxDef);
        cbMid = (CheckBox) findViewById(R.id.checkBoxMid);
        cbSt = (CheckBox) findViewById(R.id.checkBoxSt);
        spClub = (Spinner) findViewById(R.id.spinnerClub);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick();
            }
        });
    }

    private void doClick() {
        if (isValid()) {

            String nama = etNamaLengkap.getText().toString();
            int tahun = Integer.parseInt(etTahunLahir.getText().toString());
            String alamat = etAlamat.getText().toString();

            String genderresult = null;
            if(rgStatus.getCheckedRadioButtonId()!=-1)
            {
                RadioButton rb = (RadioButton)
                        findViewById(rgStatus.getCheckedRadioButtonId());
                genderresult = rb.getText().toString();
            }
            /*if(rbLK.isChecked())
            {
                genderresult = rbLK.getText().toString();
            }
            else if (rbPR.isChecked()) {
                genderresult = rbPR.getText().toString();
            }*/

            String hasil = "Posisi : \n";
            int startlen = hasil.length();
            if(cbGK.isChecked())  hasil+=cbGK.getText()+"\n";
            if(cbDef.isChecked()) hasil+=cbDef.getText()+"\n";
            if(cbMid.isChecked()) hasil+=cbMid.getText()+"\n";
            if(cbSt.isChecked())  hasil+=cbSt.getText()+"\n";

            if(hasil.length()==startlen) hasil+= "Tidak ada Pilihan";


            tvHasil.setText("Nama Lengkap "+" : "+ nama + "\n" +"Tahun Kelahiran "+" : "+ tahun + "\n" +"Jenis Kelamin "+" : "+ genderresult +"\n" +"Alamat "+" : "+ alamat+"\n" + hasil +"Club Yang Dipilih "+" : "+ spClub.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNamaLengkap.getText().toString();
        String tahun = etTahunLahir.getText().toString();
        String alamat = etAlamat.getText().toString();

        if(nama.isEmpty())
        {
            etNamaLengkap.setError("Nama Mohon Diisi");
            valid = false;
        }
        else if(nama.length()<3)
        {
            etNamaLengkap.setError("Nama Minimal 3 karakter");
            valid = false;
        }
        else
        {
            etNamaLengkap.setError(null);
        }
        if(tahun.isEmpty())
        {
            etTahunLahir.setError("Tahun Mohon Diisi");
            valid = false;
        }
        else if(tahun.length()!=4)
        {
            etTahunLahir.setError("Format Tahun Kelahiran Bukan yyyy");
            valid = false;
        }
        else
        {
            etNamaLengkap.setError(null);
        }
        if(alamat.isEmpty())
        {
            etAlamat.setError("Alamat Mohon Diisi");
            valid = false;
        }
        else if(alamat.length()<5)
        {
            etTahunLahir.setError("Alamat belum valid");
            valid = false;
        }
        else
        {
            etNamaLengkap.setError(null);
        }

        return valid;
    }
}