package com.ctrl.ctrlproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ctrl.ctrlproject.R;

import java.util.List;

/**
 * һ�����׵��̳߳ع����࣬�ṩ����̳߳�
 */
public class MainAdapter<ViewHolder> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


	private final List<String> mList;
	private final Context mContext;
	private final LayoutInflater inflater;

	public MainAdapter(List<String> mList,Context context) {
		this.mList=mList;
		this.mContext=context;
		inflater=LayoutInflater.from(mContext);
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		/**
		 * 1.绑定布局
		 *
		 */
		View view=inflater.inflate(R.layout.item_main,parent,false);
		MyViewHolder myViewHolder=new MyViewHolder(view);
		return myViewHolder;
	}

	@Override
	public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
		MyViewHolder myviewHolder= (MyViewHolder) viewHolder;
		myviewHolder.mTextView.setText(mList.get(i));
		myviewHolder.mTextView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(mContext, "a", Toast.LENGTH_SHORT).show();
			}
		});
	}


	@Override
	public int getItemCount() {
		return mList==null ? 0 : mList.size();
	}


	public class MyViewHolder extends RecyclerView.ViewHolder {
		TextView mTextView;
		public MyViewHolder(View itemView) {
			super(itemView);
			mTextView= (TextView) itemView.findViewById(R.id.textView);
		}
	}
}