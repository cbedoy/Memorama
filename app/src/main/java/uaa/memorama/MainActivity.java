package uaa.memorama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean mStatus;
    private Target mCurrentTarget;
    private List<Target> mTargetList;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        mTargetList = new ArrayList<>();
        mTargetList.add(new Target(R.drawable.colour1));
        mTargetList.add(new Target(R.drawable.colour2));
        mTargetList.add(new Target(R.drawable.colour3));
        mTargetList.add(new Target(R.drawable.colour4));
        mTargetList.add(new Target(R.drawable.colour5));
        mTargetList.add(new Target(R.drawable.colour6));
        mTargetList.add(new Target(R.drawable.colour8));

        mTargetList.add(new Target(R.drawable.colour1));
        mTargetList.add(new Target(R.drawable.colour2));
        mTargetList.add(new Target(R.drawable.colour3));
        mTargetList.add(new Target(R.drawable.colour4));
        mTargetList.add(new Target(R.drawable.colour5));
        mTargetList.add(new Target(R.drawable.colour6));
        mTargetList.add(new Target(R.drawable.colour8));

        Collections.shuffle(mTargetList);

        mAdapter = new Adapter(getLayoutInflater(), mTargetList);

        gridView.setAdapter(mAdapter);


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                processSelectionWithPosition(position);
            }
        });

    }

    private void processSelectionWithPosition(int position) {
        if (!mStatus)
        {
            mCurrentTarget = mTargetList.get(position);
            mCurrentTarget.setSelected(true);

            mAdapter.notifyDataSetChanged();

            mStatus = true;
        }
        else
        {
            Target secondTarget = mTargetList.get(position);

            if (secondTarget.isSelected())
                return;
            else
            {
                mCurrentTarget.setSelected(true);

                mAdapter.notifyDataSetChanged();

                mCurrentTarget.isPair(secondTarget);

                mStatus = false;
            }
        }
    }
}
