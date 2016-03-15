package uaa.memorama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;


public class Adapter extends BaseAdapter
{
    private List<Target> mTargetList;
    private LayoutInflater mLayoutInflater;

    public Adapter(LayoutInflater layoutInflater, List<Target> targetList){
        mLayoutInflater = layoutInflater;
        mTargetList = targetList;
    }

    @Override
    public int getCount() {
        return mTargetList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTargetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTargetList.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.target_view, null);

            viewHolder = new ViewHolder();

            viewHolder.resource = (ImageView) convertView.findViewById(R.id.card_view);

            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();

        viewHolder.resource.setImageResource(mTargetList.get(position).getResource());

        return convertView;
    }

    private class ViewHolder{
        ImageView resource;
    }
}
