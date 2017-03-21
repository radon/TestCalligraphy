package it.airbag.testcalligraphy;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by giuseppesilvestri on 21/03/17.
 */

public class TestRecyclerViewAdapter extends RecyclerView.Adapter {

    private static final int HEADER_TYPE = 0;
    private static final int ROW_TYPE = 1;

    ArrayList<Integer> mList;

    public TestRecyclerViewAdapter(ArrayList<Integer> list) {
        this.mList = list;
    }

    @Override
    public int getItemCount() {
        return 1 + mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? HEADER_TYPE : ROW_TYPE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder;
        if (viewType == HEADER_TYPE) {
            holder = new HeaderHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.header_row, parent, false));
        } else {
            holder = new RowHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            HeaderHolder headerHolder = (HeaderHolder) holder;
            headerHolder.name.setText("HEADER TEST");
        } else {
            Integer currentInt = mList.get(position - 1);
            RowHolder rowHolder = (RowHolder) holder;
            rowHolder.button.setText(String.valueOf(currentInt));
        }
    }

    class HeaderHolder extends RecyclerView.ViewHolder {
        TextView name;

        public HeaderHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.name);
        }
    }

    class RowHolder extends RecyclerView.ViewHolder {
        Button button;

        public RowHolder(View view) {
            super(view);
            button = (Button) view.findViewById(R.id.button);
        }
    }

}
