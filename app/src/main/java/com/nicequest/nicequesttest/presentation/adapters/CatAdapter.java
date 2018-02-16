package com.nicequest.nicequesttest.presentation.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nicequest.nicequesttest.R;
import com.nicequest.nicequesttest.domain.model.ItemCat;
import com.nicequest.nicequesttest.presentation.display.DisplayUtils;
import com.nicequest.nicequesttest.presentation.display.LoaderImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CatAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ItemCat> itemList;
    private Context context;

    public CatAdapter(List<ItemCat> items, Context context){
        this.itemList = items;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemConsumerGood = inflater.inflate(R.layout.item_cat, parent, false);
        viewHolder = new CatViewHolder(itemConsumerGood);
        return viewHolder;
    }

    private int toPixels(int dp, DisplayMetrics metrics) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, metrics);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemCat itemCat = itemList.get(position);
        CatViewHolder consumerGoodViewHolder = (CatViewHolder) holder;
        consumerGoodViewHolder.bindCat(itemCat);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void addResults(List<ItemCat> lista){
        this.itemList.addAll(lista);
        this.notifyDataSetChanged();
    }

    public void clear(){
        this.itemList.clear();
    }

    class CatViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_cat) ImageView thumbnail;
        @BindView(R.id.text_view_title) TextView title;
        @BindView(R.id.text_view_views) TextView views;

        private CatViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindCat(final ItemCat cat) {
            this.setThumbnailHeight(cat);
            LoaderImage.getInstance().loadCoverMovie(itemView, cat.getUrl(), thumbnail);
            title.setText(cat.getTitle());
            views.setText(String.valueOf(cat.getViews()));
        }

        private void setThumbnailHeight(ItemCat cat) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    toPixels(DisplayUtils.Companion.getDpImageHeight(cat.getHeight()),
                            context.getResources().getDisplayMetrics()));
            thumbnail.setLayoutParams(params);
        }
    }
}