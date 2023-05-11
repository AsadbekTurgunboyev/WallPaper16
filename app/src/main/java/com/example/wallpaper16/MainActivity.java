package com.example.wallpaper16;

import android.app.Dialog;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickInterface {

    ViewPager2 viewPager2;
    ViewAdapter adapter;
    List<String> list;
    Dialog dialog;
    MaterialButton btnHome, btnLock, btnBoth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);
        initViews();
        setDialog();
        setList();
        adapter = new ViewAdapter(list, this);
        viewPager2.setAdapter(adapter);
    }

    private void setDialog() {
        dialog = new BottomSheetDialog(this);
        dialog.setContentView(R.layout.bottom_dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        btnHome = dialog.findViewById(R.id.btnHome);
        btnLock = dialog.findViewById(R.id.btnLock);
        btnBoth = dialog.findViewById(R.id.btnBoth);

    }

    private void setList() {
        list = new ArrayList<>();
        list.add("https://images.unsplash.com/photo-1536098561742-ca998e48cbcc?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=836&q=80");
        list.add("https://images.pexels.com/photos/1416367/pexels-photo-1416367.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/1366913/pexels-photo-1366913.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/2911521/pexels-photo-2911521.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/1097456/pexels-photo-1097456.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/1274260/pexels-photo-1274260.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/3052361/pexels-photo-3052361.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/4976482/pexels-photo-4976482.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/733745/pexels-photo-733745.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/1535162/pexels-photo-1535162.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/1906879/pexels-photo-1906879.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/5435267/pexels-photo-5435267.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/1032650/pexels-photo-1032650.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/3593922/pexels-photo-3593922.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/320014/pexels-photo-320014.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/1848471/pexels-photo-1848471.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.pexels.com/photos/2901913/pexels-photo-2901913.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1");
        list.add("https://images.unsplash.com/photo-1627672360124-4ed09583e14c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80");


    }

    private void initViews() {
        viewPager2 = findViewById(R.id.viewpager);
    }

    @Override
    public void click(Bitmap bitmap) {

        dialog.show();
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(MainActivity.this);
                try{
                    wallpaperManager.setBitmap(bitmap);
                    Toast.makeText(MainActivity.this, "O'rnatildi!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnLock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(MainActivity.this);
                try{
                    wallpaperManager.setBitmap(bitmap,null, false,WallpaperManager.FLAG_LOCK);
                    Toast.makeText(MainActivity.this, "O'rnatildi!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnBoth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WallpaperManager wallpaperManager = WallpaperManager.getInstance(MainActivity.this);
                try{
                    wallpaperManager.setBitmap(bitmap,null, false,WallpaperManager.FLAG_LOCK);
                    wallpaperManager.setBitmap(bitmap,null, false,WallpaperManager.FLAG_SYSTEM);
                    Toast.makeText(MainActivity.this, "O'rnatildi!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });



    }
}