package com.ctrl.ctrlproject;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.beanu.arad.utils.MessageUtils;
import com.chanven.lib.cptr.PtrClassicFrameLayout;
import com.chanven.lib.cptr.PtrDefaultHandler;
import com.chanven.lib.cptr.PtrFrameLayout;
import com.chanven.lib.cptr.loadmore.OnLoadMoreListener;
import com.chanven.lib.cptr.recyclerview.RecyclerAdapterWithHF;
import com.ctrl.ctrlproject.adapter.MainAdapter;
import com.ctrl.ctrlproject.base.AppToolBarActivity;
import com.ctrl.ctrlproject.dao.LoginDao;
import com.ctrl.ctrlproject.widget.NoDataTipsWidget;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class MainActivity extends AppToolBarActivity implements View.OnClickListener{
	EditText et_user;
	EditText et_pwd;
	Button btn_login;
	private LoginDao ldao;
	private List<String> mList=new ArrayList<>();
	RecyclerView mRecyclerView;
	MainAdapter myAdapter;//自己定义的适配器
	RecyclerAdapterWithHF mAdapterWithHF;//第三方的适配器，我觉得是进行刷新和加载而设置的
	PtrClassicFrameLayout mFrameLayout;


	protected static final int TASK_COMPLETED = 1; //网络请求成功
	protected static final int TASK_FAILED = -1;  //服务器连接失败
	protected static final int TASK_NONETWORK = -2;//无网络
	private NoDataTipsWidget noDataTipsView;

	Handler handler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case TASK_COMPLETED:  //请求成功后处理
					mAdapterWithHF.notifyDataSetChanged();
					break;
				case TASK_FAILED:  //请求失败后处理
					break;
				case TASK_NONETWORK:  //无网络情况处理
					break;
			}
			//所有状况处理完毕后，调用noDataTipsView.doTipsView（）方法 adapter 或List都可以
			noDataTipsView.doTipsView(msg, mList);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ButterKnife.inject(this);
		setContentView(R.layout.activity_main);
		/*if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.setStatusBarColor(Color.parseColor("#ff0000"));
		}*/
		ldao=new LoginDao(this);
	}

	public void initViews() {
		noDataTipsView = (NoDataTipsWidget)findViewById(R.id.nodata_tipsview);
		et_user=(EditText)findViewById(R.id.et_user);
		et_pwd=(EditText)findViewById(R.id.et_pwd);
		btn_login=(Button)findViewById(R.id.btn_login);
		mRecyclerView= (RecyclerView)findViewById(R.id.recycleView);
		mFrameLayout = (PtrClassicFrameLayout)findViewById(R.id.ptr_class);
		mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
	}
	public void initListeners() {
		noDataTipsView.setTipsClickListener(new NoDataTipsWidget.TipsOnClickListener() {
			@Override
			public void OnClick() {
				for (int i=0;i<10;i++){
					mList.add("数据"+i);
				}
				handler.sendEmptyMessage(1);
			}
		});
		btn_login.setOnClickListener(this);
		mFrameLayout.setLastUpdateTimeRelateObject(this);//设置刷新支持时间
		         mFrameLayout.setResistance(1.7f);
		         mFrameLayout.setDurationToCloseHeader(1000);
		         // 默认为false
		         mFrameLayout.setPullToRefresh(false);
		         // 默认为true
		         mFrameLayout.setKeepHeaderWhenRefresh(true);
		//进入Activity就进行自动下拉刷新
		         mFrameLayout.postDelayed(new Runnable() {
					 @Override
					 public void run() {
						 mFrameLayout.autoRefresh();
					 }
				 }, 100);
		         //下拉刷新
		         mFrameLayout.setPtrHandler(new PtrDefaultHandler() {
			             @Override
			             public void onRefreshBegin(PtrFrameLayout frame) {
				                 mList.clear();
				                 initData();//模拟加载数据
				                 //模拟联网，延迟更新数据
				                 new Handler().postDelayed(new Runnable() {
					                     @Override
					                     public void run() {
						                         mAdapterWithHF.notifyDataSetChanged();//适配器更新数据
						                         mFrameLayout.refreshComplete();//
						                         mFrameLayout.setLoadMoreEnable(true);
						                    }
					                 },1000);
				             }
			         });
		         //上拉加载
		         mFrameLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
					 @Override
					 public void loadMore() {
						 //模拟网络延迟
						 new Handler().postDelayed(new Runnable() {
							 @Override
							 public void run() {
								 initData();//模拟加载数据
								 mAdapterWithHF.notifyDataSetChanged();
								 mFrameLayout.loadMoreComplete(true);
							 }
						 }, 1000);
					 }
				 });
	}
	public void initData() {
		/*for (int i=0;i<10;i++){
			mList.add("数据"+i);
		}*/
		 myAdapter=new MainAdapter(mList,this);
		 mAdapterWithHF=new RecyclerAdapterWithHF(myAdapter);//自带的适配器,带刷新和加载
		 mRecyclerView.setAdapter(mAdapterWithHF);
		handler.sendEmptyMessage(-1);// 测试是请求失败的情况

	}

	@Override
	public void onRequestSuccess(int requestCode) {
		super.onRequestSuccess(requestCode);
		if(requestCode==0){
			MessageUtils.showShortToast(this, "登录成功");
			//et_user.setText(ldao.getMemberInfo().getNickName());

		}
	}

	@Override
	public void onClick(View v) {
		if(v==btn_login){
			/*MessageUtils.showShortToast(this,"登录");
			ldao.requestLogin(et_user.getText().toString().trim(),et_pwd.getText().toString().trim());*/
			startActivity(AppBarLayoutActivity.class,null);
		}
	}

	@Override
	public String setupToolBarTitle() {
		return "填写";
	}
}
