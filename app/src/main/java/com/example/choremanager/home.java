package com.example.choremanager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import static android.media.CamcorderProfile.get;

public class home extends Fragment {
    ArrayList<DataModel> dataModels;
    MainAdapter mainAdapter;
    Calendar calendar = Calendar.getInstance();
    LocalDate localDate = LocalDate.now();
    DayOfWeek todayDOW = localDate.getDayOfWeek();

    ListView listView;
    TextView dayTitle;
    CustomAdapter adapter;
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;

    public home() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        listView = view.findViewById(R.id.listView);
        dayTitle = view.findViewById(R.id.dayTitle);
        recyclerView = view.findViewById(R.id.horizontalRecyclerView);
        dataModels = new ArrayList<>();

        setTextToDayOfTheWeek(2);
        String[] DOTW = {getDOTWAbreviated(0) ,getDOTWAbreviated(1), getDOTWAbreviated(2), getDOTWAbreviated(3), getDOTWAbreviated(4), getDOTWAbreviated(5), getDOTWAbreviated(6)};
        String[] dates = {getDate(0), getDate(1), getDate(2), getDate(3), getDate(4), getDate(5), getDate(6)};

        dataModels.add(new DataModel("Eat Apple Pie", false));
        dataModels.add(new DataModel("Eat Banana Bread", false));
        dataModels.add(new DataModel("Eat Cupcake", false));
        dataModels.add(new DataModel("Eat Donut", false));
        dataModels.add(new DataModel("Lick Honeycomb", false));
        dataModels.add(new DataModel("Consume Ice Cream Sandwich", false));
        dataModels.add(new DataModel("Pop a Jelly Bean", false));

        generateListView(listView);
        generateWeekView(mainModels, dates, DOTW);

        return view;
    }

    private String getDate(int addDates){
        int currentDate = calendar.get(Calendar.DAY_OF_MONTH);
        int unformattedNextDate = currentDate+addDates;
        String todayDate = localDate.getMonthValue()+"/"+localDate.getDayOfMonth()+"/"+localDate.getYear();
        LocalDate lastDayOfMonth = LocalDate.parse(todayDate, DateTimeFormatter.ofPattern("M/dd/yyyy")).with(TemporalAdjusters.lastDayOfMonth());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
            int formattedLastDayOfMonth = Integer.parseInt(lastDayOfMonth.format(formatter));
        int finalDate;

        if(unformattedNextDate>formattedLastDayOfMonth){
            finalDate=(unformattedNextDate-formattedLastDayOfMonth);
        }else{
            finalDate = unformattedNextDate;
        }

        return finalDate+"";
    }
    private String getDOTWAbreviated(int addDays){
        int currentDate = calendar.get(Calendar.DAY_OF_MONTH);
        int nextDate = currentDate+addDays;
        //Find Last day of month
        String todaysDateFormatted = localDate.getMonthValue()+"/"+localDate.getDayOfMonth()+"/"+localDate.getYear();
        LocalDate lastDayOfThisMonth = LocalDate.parse(todaysDateFormatted, DateTimeFormatter.ofPattern("M/dd/yyyy")).with(TemporalAdjusters.lastDayOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        int formattedLastDayOfMonth = Integer.parseInt(lastDayOfThisMonth.format(formatter));
        String returnDate;

        if(nextDate>formattedLastDayOfMonth){
            if(localDate.getMonthValue()==12) {
                returnDate = (1) + "/" + (nextDate - formattedLastDayOfMonth) + "/" + (localDate.getYear()+1);
                //Toast.makeText(getActivity(),"1ReturnDate = "+ returnDate, Toast.LENGTH_LONG).show();
            }else{
                returnDate = (localDate.getMonthValue()+1) + "/" + (nextDate - formattedLastDayOfMonth) + "/" + (localDate.getYear());
                //Toast.makeText(getActivity(),"2ReturnDate = "+ returnDate, Toast.LENGTH_LONG).show();

            }
        }else{
            returnDate = (localDate.getMonthValue()) + "/" + (nextDate) + "/" + (localDate.getYear());
            //Toast.makeText(getActivity(),"1ReturnDate = "+ returnDate, Toast.LENGTH_LONG).show();

        }
        LocalDate retDOW = LocalDate.parse(returnDate, DateTimeFormatter.ofPattern("M/dd/yyyy"));
        DayOfWeek retDayOfTheWeek = retDOW.getDayOfWeek();
        String returnString = (retDayOfTheWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)).toUpperCase();
        return returnString;
    }
    private String getDOTW(int addDays){
        int currentDate = calendar.get(Calendar.DAY_OF_MONTH);
        int nextDate = currentDate+addDays;
        //Find Last day of month
        String todaysDateFormatted = localDate.getMonthValue()+"/"+localDate.getDayOfMonth()+"/"+localDate.getYear();
        LocalDate lastDayOfThisMonth = LocalDate.parse(todaysDateFormatted, DateTimeFormatter.ofPattern("M/dd/yyyy")).with(TemporalAdjusters.lastDayOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        int formattedLastDayOfMonth = Integer.parseInt(lastDayOfThisMonth.format(formatter));
        String returnDate;

        if(nextDate>formattedLastDayOfMonth){
            if(localDate.getMonthValue()==12) {
                returnDate = (1) + "/" + (nextDate - formattedLastDayOfMonth) + "/" + (localDate.getYear()+1);
                //Toast.makeText(getActivity(),"1ReturnDate = "+ returnDate, Toast.LENGTH_LONG).show();
            }else{
                returnDate = (localDate.getMonthValue()+1) + "/" + (nextDate - formattedLastDayOfMonth) + "/" + (localDate.getYear());
                //Toast.makeText(getActivity(),"2ReturnDate = "+ returnDate, Toast.LENGTH_LONG).show();

            }
        }else{
            returnDate = (localDate.getMonthValue()) + "/" + (nextDate) + "/" + (localDate.getYear());
            //Toast.makeText(getActivity(),"1ReturnDate = "+ returnDate, Toast.LENGTH_LONG).show();

        }
        LocalDate retDOW = LocalDate.parse(returnDate, DateTimeFormatter.ofPattern("M/dd/yyyy"));
        DayOfWeek retDayOfTheWeek = retDOW.getDayOfWeek();
        String returnString = (retDayOfTheWeek.getDisplayName(TextStyle.FULL_STANDALONE, Locale.ENGLISH));
        return returnString;
    }

    private void generateListView(ListView funcListView){
        adapter = new CustomAdapter(dataModels, getContext());
        funcListView.setAdapter(adapter);
        funcListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                DataModel dataModel= dataModels.get(position);
                dataModel.checked = !dataModel.checked;
                adapter.notifyDataSetChanged();
            }
        });
    }
    private void generateWeekView(ArrayList<MainModel> mainModels, String[] date, String[] DOTW) {
        mainModels = new ArrayList<>();
        for (int i = 0; i<DOTW.length; i++) {
            MainModel model = new MainModel(DOTW[i], date[i]);
            mainModels.add(model);
        }

        //Design HorizontalScrollView
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //INIT MainAdapter
        mainAdapter = new MainAdapter(getContext(), mainModels);
        //Set Main adapter to RecyclerView
        recyclerView.setAdapter(mainAdapter);
    }

    public void setTextToToday(){
        dayTitle.setText(R.string.Today);
    }
    public void setTextToTommorow() { dayTitle.setText(R.string.Tomorrow);
    }
    public void setTextToDayOfTheWeek(int numDaysPastTommorow){
        dayTitle.setText(getDOTW(numDaysPastTommorow));
    }

}