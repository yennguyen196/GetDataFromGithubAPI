package com.contact.yen.getdatafromgithubapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserItemViewHolder> {
    private List<User> mUsers;
    private Context context;
    public UserAdapter(List<User> mUsers, Context context) {
        this.mUsers = mUsers;
        this.context = context;
    }

    @NonNull
    @Override
    public UserItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent, false);
        return new UserItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserItemViewHolder holder, int position) {
        User user = mUsers.get(position);
         holder.mTextViewID.setText(String.valueOf(user.getmID()));
         holder.mTextViewNodeID.setText(user.getmNodeID());
         holder.mTextViewName.setText(user.getmName());
         holder.mTextViewFullName.setText(user.getmFullName());

    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class UserItemViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextViewID;
        private TextView mTextViewNodeID;
        private TextView mTextViewName;
        private TextView mTextViewFullName;
        public UserItemViewHolder(View itemView) {
            super(itemView);
            mTextViewID = itemView.findViewById(R.id.textview_id);
            mTextViewNodeID = itemView.findViewById(R.id.textview_nodeID);
            mTextViewName = itemView.findViewById(R.id.textview_name);
            mTextViewFullName = itemView.findViewById(R.id.textview_fullname);
        }
    }
}
