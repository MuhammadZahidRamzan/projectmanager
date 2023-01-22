package com.zahid.projectmanager.activities.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zahid.projectmanager.R
import com.zahid.projectmanager.activities.TaskListActivity
import com.zahid.projectmanager.activities.medel.Card
import com.zahid.projectmanager.activities.medel.SelectedMembers

open class CardListItemsAdapter(
    private val context: Context,
    private var list: ArrayList<Card>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var onClickListener: OnClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_card,
                parent,
                false
            )
        )
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val model = list[position]
        if (holder is MyViewHolder) {
            if (model.labelColor.isNotEmpty()) {
                holder.viewLabelColor.visibility = View.VISIBLE
                holder.viewLabelColor.setBackgroundColor(Color.parseColor(model.labelColor))
            } else {
                holder.viewLabelColor.visibility = View.GONE
            }
            holder.tvCardName.text = model.name
            if ((context as TaskListActivity).mAssignedMemberList.size > 0) {
                // A instance of selected members list.
                val selectedMembersList: ArrayList<SelectedMembers> = ArrayList()
                // Here we got the detail list of members and add it to the selected members list as required.
                for (i in context.mAssignedMemberList.indices) {
                    for (j in model.assignedTo) {
                        if (context.mAssignedMemberList[i].id == j) {
                            val selectedMember = SelectedMembers(
                                context.mAssignedMemberList[i].id,
                                context.mAssignedMemberList[i].image
                            )
                            selectedMembersList.add(selectedMember)
                        }
                    }
                }
                if (selectedMembersList.size > 0) {
                    if (selectedMembersList.size == 1 && selectedMembersList[0].id == model.createdBy) {
                        holder.rvCardSelectedMemberList.visibility = View.GONE
                    } else {
                        holder.rvCardSelectedMemberList.visibility = View.VISIBLE

                        holder.rvCardSelectedMemberList.layoutManager =
                            GridLayoutManager(context, 3)
                        val adapter = CardMemberListItemsAdapter(context, selectedMembersList,false)
                        holder.rvCardSelectedMemberList.adapter = adapter
                        adapter.setOnClickListener(object :
                            CardMemberListItemsAdapter.OnClickListener {
                            override fun onClick() {
                                if (onClickListener != null) {
                                    onClickListener!!.onClick(position)
                                }
                            }
                        })
                    }
                } else {
                    holder.rvCardSelectedMemberList.visibility = View.GONE
                }
            }
            holder.itemView.setOnClickListener{
                if (onClickListener != null) {
                    onClickListener!!.onClick(position)
                }
            }
        }

    }
    override fun getItemCount(): Int {
        return list.size
    }
    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }
    interface OnClickListener {
        fun onClick(position: Int)
    }
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvCardName:TextView = view.findViewById(R.id.tv_card_name)
        val viewLabelColor:View = view.findViewById(R.id.view_label_color)
        val rvCardSelectedMemberList:RecyclerView = view.findViewById(R.id.rv_card_selected_members_list)

    }
}