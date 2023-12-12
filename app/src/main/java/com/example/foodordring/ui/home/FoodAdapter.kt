package com.example.foodordring.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.foodordring.R
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.fooditem.view.*

class FoodAdapter(var items:List<Food>,private val listener:OnItemClickListener):RecyclerView.Adapter<FoodAdapter.FoodsViewHolder> (),Filterable{
    var foodsFiltredList: List<Food> = ArrayList()
    init{
        foodsFiltredList=items
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                var charSearch = constraint.toString()
                if(charSearch.isEmpty()){
                    foodsFiltredList=items
                } else {
                    var resultList = ArrayList<Food>()
                    for(food in items){
                        if(food.title.lowercase().contains(charSearch.lowercase())){
                            resultList.add(food)
                        }
                    }
                    foodsFiltredList=resultList
                }
                val filterResults = FilterResults()
                filterResults.values=foodsFiltredList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                foodsFiltredList=results?.values as ArrayList<Food>
                notifyDataSetChanged()
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fooditem,parent,false)

        return FoodsViewHolder(itemView)
    }



    override fun onBindViewHolder(holder: FoodsViewHolder, position: Int) {


        val food = foodsFiltredList[position]
        holder.bind(food)

    }



    override fun getItemCount(): Int {
        return foodsFiltredList.size
    }



    inner class FoodsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),OnClickListener {

        var foodimg : ImageView
        var foodtitle : TextView
        var foodprice:TextView
        var ratingbar : RatingBar



        init {
            foodimg=itemView.foodimg
            foodtitle=itemView.foodtitle
            foodprice=itemView.foodprice
            ratingbar=itemView.ratingbar
            itemView.setOnClickListener(this)
        }

        fun bind(food:Food){
            foodtitle.text=food.title
            foodprice.text=food.price
            foodimg.setBackgroundResource(food.img)
            ratingbar.rating= food.rating.toFloat()
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        override fun onClick(v: View?) {
            val position : Int = adapterPosition
            if(position!= RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }
interface OnItemClickListener{
    fun onItemClick(position: Int)
}
}


