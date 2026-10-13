package com.example.optionmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        homeButton = findViewById(R.id.homeButton);

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showHomeMenu();
            }
        });
    }

    private void showHomeMenu() {

        PopupMenu popupMenu =
                new PopupMenu(MainActivity.this, homeButton);

        popupMenu.getMenuInflater().inflate(
                R.menu.menu_main,
                popupMenu.getMenu()
        );

        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {

                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id = item.getItemId();

                        // Home
                        if (id == R.id.menu_home) {
                            return true;
                        }

                        // Contact Us
                        if (id == R.id.menu_contacts) {

                            Intent intent = new Intent(
                                    MainActivity.this,
                                    ContactActivity.class
                            );

                            startActivity(intent);

                            return true;
                        }

                        // About Us
                        if (id == R.id.menu_about) {

                            Intent intent = new Intent(
                                    MainActivity.this,
                                    AboutActivity.class
                            );

                            startActivity(intent);

                            return true;
                        }

                        return false;
                    }
                }
        );

        popupMenu.show();
    }
}
