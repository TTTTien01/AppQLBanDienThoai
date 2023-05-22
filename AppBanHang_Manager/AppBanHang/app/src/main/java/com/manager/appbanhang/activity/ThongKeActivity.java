package com.manager.appbanhang.activity;

import static android.view.View.GONE;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.manager.appbanhang.R;
import com.manager.appbanhang.retrofit.ApiBanHang;
import com.manager.appbanhang.retrofit.RetrofitClient;
import com.manager.appbanhang.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ThongKeActivity extends AppCompatActivity {
    Toolbar toolbar;
    PieChart pieChart,pieCharttkbanchay ;
    BarChart barChart;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    ApiBanHang apiBanHang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);
        apiBanHang = RetrofitClient.getInstance(Utils.BASE_URL).create(ApiBanHang.class);
        initView();
        ActionTooBar();
        getdataChart();
        settingBarchart();

    }

    private void settingBarchart() {
        barChart.getDescription().setEnabled(false);
        barChart.setDrawValueAboveBar(false);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setAxisMinimum(1);
        xAxis.setAxisMaximum(12);
        YAxis yAxisright = barChart.getAxisRight();
        yAxisright.setAxisMinimum(0);
        YAxis yAxisleft = barChart.getAxisLeft();
        yAxisleft.setAxisMinimum(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_thongke, menu);
        return true;
    }
    //bắt sự kiện onClick onOptionsItemSelected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.tkdoanhthu:
                getTkThang();
                //return true;
                break;

            case R.id.tkmathang:
                getTkMatHangBanChay();
                //return true;
               break;

            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    private void getTkMatHangBanChay() {
        pieCharttkbanchay.setVisibility(View.VISIBLE);
        pieChart.setVisibility(GONE);
        barChart.setVisibility(GONE);
        compositeDisposable.add(apiBanHang.getthongkeBanChay()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        chiTietDonHangModel -> {
                            if(chiTietDonHangModel.isSuccess()){
                                List<PieEntry> listdata = new ArrayList<>();
                                for (int i = 0; i<chiTietDonHangModel.getResult().size(); i++){
                                    String tensp = chiTietDonHangModel.getResult().get(i).getTensanpham();
                                    String tongsl = chiTietDonHangModel.getResult().get(i).getTongsoluong();
                                    listdata.add(new PieEntry(Integer.parseInt(String.valueOf(tongsl)), String.valueOf(tensp)));
                                }
                                PieDataSet pieDataSet = new PieDataSet(listdata,"Thống kê");
                                PieData data = new PieData();
                                data.setDataSet(pieDataSet);
                                data.setValueTextSize(12f);
                                data.setValueFormatter(new PercentFormatter(pieCharttkbanchay));
                                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

                                pieCharttkbanchay.setData(data);
                                pieCharttkbanchay.animateXY(2000,2000);
                                pieCharttkbanchay.setUsePercentValues(true);
                                pieCharttkbanchay.getDescription().setEnabled(false);
                                pieCharttkbanchay.invalidate();

                            }

                        },
                        throwable -> {
                            Log.d("loggg", throwable.getMessage());
                        }
                ));

    }

    private void getTkThang() {
        barChart.setVisibility(View.VISIBLE);
        pieChart.setVisibility(GONE);
        pieCharttkbanchay.setVisibility(GONE);
        compositeDisposable.add(apiBanHang.getthongkeThang()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                   thongKeModel -> {
                       if(thongKeModel.isSuccess()){
                           List<BarEntry> listdata = new ArrayList<>();
                           for(int i = 0; i<thongKeModel.getResult().size(); i++){
                               String tongtien = thongKeModel.getResult().get(i).getTongtienthang();
                               String thang = thongKeModel.getResult().get(i).getThang();
                               listdata.add(new BarEntry(Integer.parseInt(thang), Float.parseFloat(tongtien)));
                           }
                           BarDataSet barDataSet = new BarDataSet(listdata, "Thống kê doanh thu theo tháng");
                           barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
                           barDataSet.setValueTextSize(14f);
                           barDataSet.setValueTextColor(Color.RED);

                           BarData data = new BarData(barDataSet);
                           barChart.animateXY(2000, 2000);
                           barChart.setData(data);
                           barChart.invalidate();


                       }
                   },
                        throwable -> {
                       Log.d("loggg", throwable.getMessage());
                        }
                ));
    }

    private void getdataChart() {
        List<PieEntry> listdata = new ArrayList<>();
        compositeDisposable.add(apiBanHang.getthongke()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        thongKeModel -> {
                            if(thongKeModel.isSuccess()){
                                for (int i = 0; i<thongKeModel.getResult().size(); i++){
                                    String tensp = thongKeModel.getResult().get(i).getTensanpham();
                                    int tong = thongKeModel.getResult().get(i).getTong();
                                    listdata.add(new PieEntry(tong,tensp));
                                }
                                PieDataSet pieDataSet = new PieDataSet(listdata,"Thống kê");
                                PieData data = new PieData();
                                data.setDataSet(pieDataSet);
                                data.setValueTextSize(12f);
                                data.setValueFormatter(new PercentFormatter(pieChart));
                                pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);

                                pieChart.setData(data);
                                pieChart.animateXY(2000,2000);
                                pieChart.setUsePercentValues(true);
                                pieChart.getDescription().setEnabled(false);
                                pieChart.invalidate();
                            }
                        },
                        throwable -> {
                            Log.d("log",throwable.getMessage());
                        }
                ));
    }

    private void initView() {
        toolbar = findViewById(R.id.toobar);
        pieChart = findViewById(R.id.piechart);
        pieCharttkbanchay = findViewById(R.id.piecharttkbanchay);
        barChart = findViewById(R.id.barchart);
    }

    private void ActionTooBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }
}