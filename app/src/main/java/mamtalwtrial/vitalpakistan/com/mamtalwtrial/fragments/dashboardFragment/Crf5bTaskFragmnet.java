package mamtalwtrial.vitalpakistan.com.mamtalwtrial.fragments.dashboardFragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;

import mamtalwtrial.vitalpakistan.com.mamtalwtrial.R;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.activities.CRF4And5Dashboard;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.activities.CRF5bActivity;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.adapter.TaskListAdapter;
import mamtalwtrial.vitalpakistan.com.mamtalwtrial.models.FollowupDetails;

public class Crf5bTaskFragmnet extends Fragment {

    ListView listView;
    ArrayList<FollowupDetails> listfollowUpDetails;
    TaskListAdapter taskListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crf5b_task_fragmnet, container, false);


        listfollowUpDetails = new ArrayList<FollowupDetails>();
        listView = (ListView) view.findViewById(R.id.list_view);


        if(CRF4And5Dashboard.listOf5bFollowUps!=null && !CRF4And5Dashboard.listOf5bFollowUps.isEmpty()){


            taskListAdapter = new TaskListAdapter(getContext(), CRF4And5Dashboard.listOf5bFollowUps);
            listView.setAdapter(taskListAdapter);

        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String[] data = new String[2];
                data[0] = getPosition(position)+"";
                data[1] = new Gson().toJson(CRF4And5Dashboard.listOf5bFollowUps.get(position));

                startActivity(new Intent(getContext(), CRF5bActivity.class).putExtra("data", data));

            }
        });


        return view;
    }

    public int getPosition(int posi){

        int posit = -1;

        for (int i =0; i<CRF4And5Dashboard.listOfFollowUps.size(); i++){

            if (CRF4And5Dashboard.listOfFollowUps.get(i).getFollowupDetails().
                    getAssistId().equalsIgnoreCase(CRF4And5Dashboard.listOf5bFollowUps.get(posi).getFollowupDetails()
                    .getAssistId())){

                posit = i;

                break;
            }
        }

        return posit;
    }


}
