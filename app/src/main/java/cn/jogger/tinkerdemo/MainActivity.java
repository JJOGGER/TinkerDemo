package cn.jogger.tinkerdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnRepair = findViewById(R.id.btn_repair);
        TextView tvBug = findViewById(R.id.tv_bug);
//        tvBug.setText("---------修改了内容");
        btnRepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "修复bug！", Toast.LENGTH_SHORT).show();
                TinkerInstaller.onReceiveUpgradePatch(getApplication().getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch.patch");
            }
        });
    }
}
