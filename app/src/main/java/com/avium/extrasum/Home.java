package com.avium.extrasum;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.avium.extrasum.adapters.PagerAdapter;
import com.avium.extrasum.fragments.HomeFragment;
import com.avium.extrasum.fragments.Investment;
import com.avium.extrasum.fragments.Trade;
import com.avium.extrasum.fragments.Wallet;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button call_nav;
    ViewPager custom_view_pager;
    HomeFragment homeFragment;
    Investment investment;
    Trade trade;
    Wallet wallet;
    PagerAdapter pagerAdapter;
    @BindView(R.id.home_image)
    ImageView homeImage;
    @BindView(R.id.home_text)
    TextView homeText;
    @BindView(R.id.call_homefrag)
    LinearLayout callHomefrag;
    @BindView(R.id.investment_image)
    ImageView investmentImage;
    @BindView(R.id.investment_text)
    TextView investmentText;
    @BindView(R.id.call_investment_frag)
    LinearLayout callInvestmentFrag;
    @BindView(R.id.trade_image)
    ImageView tradeImage;
    @BindView(R.id.trade_text)
    TextView tradeText;
    @BindView(R.id.call_trade_frag)
    LinearLayout callTradeFrag;
    @BindView(R.id.call_wallet_frag)
    LinearLayout callWalletFrag;
    @BindView(R.id.wallet_image)
    ImageView walletImage;
    @BindView(R.id.wallet_text)
    TextView walletText;
    @BindView(R.id.close)
    ImageView close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        custom_view_pager = findViewById(R.id.viewPager);
        setViewPagerIndicators(0);
        call_nav = findViewById(R.id.call_nav);
        call_nav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);

            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());

        homeFragment = new HomeFragment();
        investment = new Investment();
        trade = new Trade();
        wallet = new Wallet();
        pagerAdapter.addFragment(homeFragment);
        pagerAdapter.addFragment(investment);
        pagerAdapter.addFragment(trade);
        pagerAdapter.addFragment(wallet);
        custom_view_pager.setOffscreenPageLimit(3);
        custom_view_pager.setAdapter(pagerAdapter);
        custom_view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("position", "" + position);
                setViewPagerIndicators(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }


        });
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @OnClick({R.id.call_homefrag, R.id.call_investment_frag, R.id.call_trade_frag, R.id.call_wallet_frag})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.call_homefrag:
                custom_view_pager.setCurrentItem(0, true);
                setViewPagerIndicators(0);

                break;
            case R.id.call_investment_frag:
                custom_view_pager.setCurrentItem(1, true);
                setViewPagerIndicators(1);


                break;
            case R.id.call_trade_frag:
                custom_view_pager.setCurrentItem(2, true);
                setViewPagerIndicators(2);


                break;
            case R.id.call_wallet_frag:
                custom_view_pager.setCurrentItem(3, true);
                setViewPagerIndicators(3);


                break;
        }
    }

    private void setViewPagerIndicators(int position) {
        switch (position) {
            case 0:
                homeImage.setBackgroundResource(R.drawable.home_clicked);
                investmentImage.setBackgroundResource(R.drawable.gamm_investment);
                tradeImage.setBackgroundResource(R.drawable.gamm_trade);
                walletImage.setBackgroundResource(R.drawable.gamm_wallet);
                homeText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                investmentText.setTextColor(getResources().getColor(R.color.grey));
                tradeText.setTextColor(getResources().getColor(R.color.grey));
                walletText.setTextColor(getResources().getColor(R.color.grey));
                break;
            case 1:
                investmentImage.setBackgroundResource(R.drawable.investment_clicked);
                homeImage.setBackgroundResource(R.drawable.gamm_home_silver);
                tradeImage.setBackgroundResource(R.drawable.gamm_trade);
                walletImage.setBackgroundResource(R.drawable.gamm_wallet);
                homeText.setTextColor(getResources().getColor(R.color.grey));
                investmentText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                tradeText.setTextColor(getResources().getColor(R.color.grey));
                walletText.setTextColor(getResources().getColor(R.color.grey));
                break;
            case 2:
                investmentImage.setBackgroundResource(R.drawable.gamm_investment);
                homeImage.setBackgroundResource(R.drawable.gamm_home_silver);
                tradeImage.setBackgroundResource(R.drawable.trade_color_clicked);
                walletImage.setBackgroundResource(R.drawable.gamm_wallet);
                homeText.setTextColor(getResources().getColor(R.color.grey));
                investmentText.setTextColor(getResources().getColor(R.color.grey));
                tradeText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                walletText.setTextColor(getResources().getColor(R.color.grey));
                break;
            case 3:
                investmentImage.setBackgroundResource(R.drawable.gamm_investment);
                homeImage.setBackgroundResource(R.drawable.gamm_home_silver);
                tradeImage.setBackgroundResource(R.drawable.gamm_trade);
                walletImage.setBackgroundResource(R.drawable.wallet_clicked);

                homeText.setTextColor(getResources().getColor(R.color.grey));
                investmentText.setTextColor(getResources().getColor(R.color.grey));
                tradeText.setTextColor(getResources().getColor(R.color.grey));
                walletText.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                break;
        }


    }

    @OnClick(R.id.close)
    public void onViewClicked() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }
}
