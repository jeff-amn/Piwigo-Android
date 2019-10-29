/*
 * Piwigo for Android
 * Copyright (C) 2018-2018 Raphael Mack http://www.raphael-mack.de
 * Copyright (C) 2018-2018 Piwigo Team http://piwigo.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.piwigo.ui.settings;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.piwigo.R;
import org.piwigo.ui.shared.BaseActivity;

import androidx.appcompat.app.ActionBar;

public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_settings);

        setSupportActionBar(findViewById(R.id.toolbar));
        ActionBar bar = getSupportActionBar();
        if (bar != null) bar.setDisplayHomeAsUpEnabled(true);


        initializeThumbnailSizeSpinner();


    }

    private void initializeThumbnailSizeSpinner(){
        Spinner spinner = findViewById(R.id.spinner_thumbnail_size_value);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,

                R.array.thumbnails_size_array, R.layout.spinner_item);

        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SettingsPreferences.setSettingPreference(SettingsPreferences.KEY_THUMBNAIL_SIZE, spinner.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
