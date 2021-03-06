package mamtalwtrial.vitalpakistan.com.mamtalwtrial.fragments.crf2_fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import mamtalwtrial.vitalpakistan.com.mamtalwtrial.R;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.activities.CRF2Activity;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.activities.CRF2DashboargActivity;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.models.Constants;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.models.crf2.FormCrf2DTO;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.retrofit.APIService;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.retrofit.ApiUtils;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.utils.ContantsValues;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.utils.SaveAndReadInternalData;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.utils.WifiConnectOrNot;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CRF2GetBabyBirthDateAndTimeFragment extends Fragment {

    int getDay = -1;
    int getHour =-1;
    int getMin = -1;
    int getMonth = -1;
    int getYear = -1;
    Context context;

    ProgressDialog progressDialog;
    String selectedDate ="";
    String selectedTime ="";

    boolean b = false;

    CheckBox cb_DOB_1, cb_DOB_2;
    Button btn_DOB_next;

    TextView tv_DOBGetDate, tv_DOB_timeepicker;

    Calendar calendar;
    int year,month,day,currentHour,currentMin;


    SimpleDateFormat sdf;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crf2_get_baby_birth_date_and_time, container, false);

        initializingView(view, getContext());

        calendar = Calendar.getInstance();

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        btn_DOB_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validation()){

                    currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                    currentMin = calendar.get(Calendar.MINUTE);

                    String currentDate = day+"-"+month+"-"+year+" "+currentHour+":"+currentMin;

                    try {

                        Date d1 = sdf.parse(currentDate);
                        Date d2 = sdf.parse(getDay+"-"+getMonth+"-"+getYear+" "+getHour+":"+getMin);

                        long diffInMiliSec = d1.getTime() - d2.getTime();

                        long diffHour = TimeUnit.MILLISECONDS.toHours(diffInMiliSec);

                        Log.d("Difference in minutes",diffHour+"  07777");

                        CRF2Activity.babyHour = (int) diffHour;
                        CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().setQ26(diffHour+"");
                        CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().setQ21(selectedDate);
                        CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().setQ22(selectedTime);

                        try{

                            Date lmpDate =  new SimpleDateFormat(ContantsValues.DATEFORMAT).parse(CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getLmp());
                            Date dobDate =  new SimpleDateFormat(ContantsValues.DATEFORMAT).parse(CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getQ21());

                            long diffInMillies = Math.abs(dobDate.getTime() - lmpDate.getTime());
                            float diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                            int  remaingDays = (int) (diff%7);
                            int  weeks = (int) (diff/7);

                            CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().setQ32(weeks+"."+remaingDays);


                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }


                if(cb_DOB_1.isChecked()){

                    CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().setQ23(ContantsValues.YES);
                    Crf2Q26Fragment crf2Q26Fragment = new Crf2Q26Fragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout_crf2, crf2Q26Fragment);
                    fragmentTransaction.commit();


                }
                 else if(cb_DOB_2.isChecked()){

                    CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().setQ23(ContantsValues.NO);
                    Crf2Q24_25Fragment crf2Q24_25Fragment = new Crf2Q24_25Fragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_layout_crf2, crf2Q24_25Fragment);
                    fragmentTransaction.commit();


                }else {

                    Toast.makeText(getContext(),"Please Choose One Field",Toast.LENGTH_SHORT).show();

                }


            }
        });

        cb_DOB_1 = (CheckBox) view.findViewById(R.id.cb_DOB_1);
        cb_DOB_2 = (CheckBox) view.findViewById(R.id.cb_DOB_2);

        cb_DOB_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    cb_DOB_2.setChecked(false);
                }

            }
        });


        cb_DOB_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    cb_DOB_1.setChecked(false);
                }

            }
        });


        tv_DOBGetDate = (TextView) view.findViewById(R.id.tv_DOBGetDate);
        tv_DOBGetDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog mdiDialog =new DatePickerDialog(getContext(),new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        getDay = dayOfMonth;
                        getMonth = monthOfYear;
                        getYear = year;

                        tv_DOBGetDate.setText("   "+dayOfMonth+"-"+(monthOfYear+1)+"-"+year);
                        selectedDate = dayOfMonth+"-"+(monthOfYear+1)+"-"+year;

                        b = true;
                    }
                }, year, month, day);


                Calendar calendar1 = Calendar.getInstance();
                calendar1.add(Calendar.DAY_OF_MONTH, -1);
                mdiDialog.getDatePicker().setMaxDate(calendar1.getTimeInMillis());
                mdiDialog.show();


            }
        });

        tv_DOB_timeepicker = (TextView) view.findViewById(R.id.tv_DOB_timeepicker);
        tv_DOB_timeepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        tv_DOB_timeepicker.setText(hourOfDay+" : "+minute);

                        selectedTime = hourOfDay+":"+minute;
                         getHour = hourOfDay;
                        getMin = minute;

                    }
                },12,00,true);
                timePickerDialog.show();
            }
        });

        return view;
    }

    public boolean validation(){
        boolean b = true;

        if(selectedDate.isEmpty() || selectedTime.isEmpty()){

            b = false;
            Toast.makeText(getContext(),"Please Enter Time And Date",Toast.LENGTH_LONG).show();

        }

        return b;
    }

    public void initializingView(View view, Context context){

        progressDialog = new ProgressDialog(context);
        sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        btn_DOB_next = (Button) view.findViewById(R.id.btn_DOB_next);
        this.context = context;

    }


    /*public void sendDataToServer(){

        progressDialog.show();
        APIService mAPIService = ApiUtils.getAPIService();

        if(WifiConnectOrNot.haveNetworkConnection(getContext())){

            mAPIService.postCrf2(CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO()).enqueue(new Callback<FormCrf2DTO>() {
                @Override
                public void onResponse(Call<FormCrf2DTO> call, Response<FormCrf2DTO> response) {

                    progressDialog.dismiss();

                    if(response.code()==200){

                        singleBtnDialog(getContext(),CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() + "Form submited...:)",CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() +" Ka Form Send Hogaya h..:)");

                    }else {

                        singleBtnDialog(getContext(),"Internet Connection is not Working properly "+ CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() +" form save Internel Storage","Internet Sahi nahi chal raha islia "+ CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() +" Ka Form Internal Storage m Save Kardia h");
                        SaveAndReadInternalData.saveCrf2And3AllForms(context,CRF2Activity.formsCrf2AndCrf3All);

                    }

                }

                @Override
                public void onFailure(Call<FormCrf2DTO> call, Throwable t) {

                    singleBtnDialog(getContext(),"Internet Connection is not Working properly "+ CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() +" form save Internel Storage","Internet Sahi nahi chal raha islia "+ CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() +" Ka Form Internal Storage m Save Kardia h");
                    SaveAndReadInternalData.saveCrf2And3AllForms(context,CRF2Activity.formsCrf2AndCrf3All);

                }
            });

        }else{

            singleBtnDialog(getContext(),"Internet Connection is not Working properly "+ CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() +" form save Internel Storage","Internet Sahi nahi chal raha islia "+ CRF2Activity.formsCrf2AndCrf3All.getFormCrf2DTO().getPregnantWoman().getName() +" Ka Form Internal Storage m Save Kardia h");
            SaveAndReadInternalData.saveCrf2And3AllForms(context,CRF2Activity.formsCrf2AndCrf3All);
        }

    }


    public  void singleBtnDialog(Context context, String engMessage, String romanEng){

        Button btnConform;
        TextView tv_engText, tv_RomanEngText;

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.single_btn_dialog);
        dialog.setCancelable(false);

        btnConform = (Button) dialog.findViewById(R.id.btnok);

        tv_engText = (TextView) dialog.findViewById(R.id.tv_engText);
        tv_RomanEngText = (TextView) dialog.findViewById(R.id.tv_RomanEngText);

        tv_engText.setText(engMessage);
        tv_RomanEngText.setText(romanEng);

        btnConform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CRF2DashboargActivity.class));
                getActivity().finish();
            }
        });

        dialog.show();
    }
*/


}
