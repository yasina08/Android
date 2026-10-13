package com.example.optionmenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    private Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact);

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
                new PopupMenu(ContactActivity.this, homeButton);

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

                            Intent intent = new Intent(
                                    ContactActivity.this,
                                    MainActivity.class
                            );

                            startActivity(intent);

                            finish();

                            return true;
                        }

                        // Contact Us
                        if (id == R.id.menu_contacts) {
                            return true;
                        }

                        // About Us
                        if (id == R.id.menu_about) {

                            Intent intent = new Intent(
                                    ContactActivity.this,
                                    AboutActivity.class
                            );

                            startActivity(intent);

                            finish();

                            return true;
                        }

                        return false;
                    }
                }
        );

        popupMenu.show();
    }
}
