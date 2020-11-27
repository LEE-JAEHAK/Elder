package com.makeus.elder.chat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.makeus.elder.R;
import com.makeus.elder.chat.model.Chat;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Chat> mChatList;
    private OnItemClickListener mListener = null;

    public interface OnItemClickListener {
        void onItemClick(View v, int pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public ChatAdapter(Context context, ArrayList<Chat> marketsList, OnItemClickListener listener) {
        this.mContext = context;
        this.mChatList = marketsList;
        this.mListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNameOther;
        TextView tvCreatedAtOther;
        ImageView ivOther;

        TextView tvNameMine;
        TextView tvCreatedAtMine;
        ImageView ivMine;

        ViewHolder(final View itemView) {
            super(itemView);
            // 뷰 객체에 대한 참조. (hold strong reference)
            tvNameOther = itemView.findViewById(R.id.item_chat_tv_name_other);
            tvCreatedAtOther = itemView.findViewById(R.id.item_chat_tv_created_at_other);
            ivOther = itemView.findViewById(R.id.item_chat_iv_other);

            tvNameMine = itemView.findViewById(R.id.item_chat_tv_name_mine);
            tvCreatedAtMine = itemView.findViewById(R.id.item_chat_tv_created_at_mine);
            ivMine = itemView.findViewById(R.id.item_chat_iv_mine);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_chat, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Chat chat = mChatList.get(position);

        if (chat.isMine()) {

            holder.ivOther.setVisibility(View.INVISIBLE);
            holder.tvCreatedAtOther.setVisibility(View.INVISIBLE);
            holder.tvNameOther.setVisibility(View.INVISIBLE);
            holder.ivMine.setVisibility(View.VISIBLE);
            holder.tvCreatedAtMine.setVisibility(View.VISIBLE);
            holder.tvNameMine.setVisibility(View.VISIBLE);

            holder.tvCreatedAtMine.setText(chat.getCreatedAt());

            if (chat.getStatus().equals("배고파")) {
                holder.ivMine.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.icon_hungry));
            } else if (chat.getStatus().equals("아프다")) {
                holder.ivMine.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.icon_hospital));
            } else if (chat.getStatus().equals("외출한다")) {
                holder.ivMine.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.icon_outdoor));
            } else if (chat.getStatus().equals("졸리다")) {
                holder.ivMine.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ico_sleep));
            } else {
                holder.ivMine.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_mic_mini));
            }


        } else {

            holder.ivMine.setVisibility(View.INVISIBLE);
            holder.tvCreatedAtMine.setVisibility(View.INVISIBLE);
            holder.tvNameMine.setVisibility(View.INVISIBLE);
            holder.ivOther.setVisibility(View.VISIBLE);
            holder.tvCreatedAtOther.setVisibility(View.VISIBLE);
            holder.tvNameOther.setVisibility(View.VISIBLE);

            holder.tvNameOther.setText(chat.getName());
            holder.tvCreatedAtOther.setText(chat.getCreatedAt());

            if (chat.getStatus().equals("배고파")) {
                holder.ivOther.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.icon_hungry));
            } else if (chat.getStatus().equals("아프다")) {
                holder.ivOther.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.icon_hospital));
            } else if (chat.getStatus().equals("외출한다")) {
                holder.ivOther.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.icon_outdoor));
            } else if (chat.getStatus().equals("졸리다")) {
                holder.ivOther.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ico_sleep));
            } else {
                holder.ivOther.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_mic_mini));
            }

        }
    }

    @Override
    public int getItemCount() {
        return mChatList.size();
    }

}
