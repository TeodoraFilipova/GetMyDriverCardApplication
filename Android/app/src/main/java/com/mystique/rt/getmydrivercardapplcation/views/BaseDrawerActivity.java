package com.mystique.rt.getmydrivercardapplcation.views;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mystique.rt.getmydrivercardapplcation.R;

import com.mystique.rt.getmydrivercardapplcation.views.admin.login.LogInActivity;
import com.mystique.rt.getmydrivercardapplcation.views.applications.activities.ApplicationChooseActivity;
import com.mystique.rt.getmydrivercardapplcation.views.contacts.ContactsActivity;
import com.mystique.rt.getmydrivercardapplcation.views.statuscheck.StatusCheckActivity;

import butterknife.BindView;
import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDrawerActivity extends DaggerAppCompatActivity {

    @BindView(R.id.drawer_toolbar)
    Toolbar mToolbar;

    public BaseDrawerActivity() {
    }

    public void setupDrawer() {
        PrimaryDrawerItem mainItem = new PrimaryDrawerItem()
                .withIdentifier(MainActivity.IDENTIFIER)
                .withName("MainPage")
                .withIcon(R.drawable.icon_main_page);
        PrimaryDrawerItem applicationItem = new PrimaryDrawerItem()
                .withIdentifier(ApplicationChooseActivity.IDENTIFIER)
                .withName("Application")
                .withIcon(R.drawable.application);
        PrimaryDrawerItem statusItem = new PrimaryDrawerItem()
                .withIdentifier(StatusCheckActivity.IDENTIFIER)
                .withName("Status Check")
                .withIcon(R.drawable.checkstatus);
        PrimaryDrawerItem adminItem = new PrimaryDrawerItem()
                .withIdentifier(LogInActivity.IDENTIFIER)
                .withName("Admin log-in")
                .withIcon(R.drawable.admin);
        PrimaryDrawerItem contactItem = new PrimaryDrawerItem()
                .withIdentifier(ContactsActivity.IDENTIFIER)
                .withName("Contacts")
                .withIcon(R.drawable.icon_contacts);

        DrawerBuilder drawerBuilder = new DrawerBuilder();
        drawerBuilder.withActivity(this);
        drawerBuilder.withToolbar(mToolbar);
        drawerBuilder.addDrawerItems(
                mainItem,
                new DividerDrawerItem(),
                applicationItem,
                new DividerDrawerItem(),
                statusItem,
                new DividerDrawerItem(),
                adminItem,
                new DividerDrawerItem(),
                contactItem
        );

        drawerBuilder.withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(
                    View view,
                    int position,
                    IDrawerItem drawerItem) {
                long identifier = drawerItem.getIdentifier();
                if (getIdentifier() == identifier) {
                    return false;
                }

                Intent intent = getNextIntent(identifier);
                if (intent == null) {
                    return false;
                }
                startActivity(intent);
                return true;
            }
        });
        Drawer drawer = drawerBuilder.build();
    }

    private Intent getNextIntent(long identifier) {
        if (identifier == MainActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, MainActivity.class
            );
        } else if (identifier == ApplicationChooseActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, ApplicationChooseActivity.class
            );
        } else if (identifier == StatusCheckActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, StatusCheckActivity.class
            );
        }else if (identifier == LogInActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, LogInActivity.class
            );
        }else if (identifier == ContactsActivity.IDENTIFIER) {
            return  new Intent(
                    BaseDrawerActivity.this, ContactsActivity.class
            );
        }
        return null;
    }

    protected abstract long getIdentifier();

    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected void onStart() {
        super.onStart();
        setupDrawer();
    }

}
