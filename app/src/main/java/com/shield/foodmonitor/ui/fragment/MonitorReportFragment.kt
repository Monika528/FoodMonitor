package com.shield.foodmonitor.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shield.foodmonitor.R
import com.shield.foodmonitor.utils.Constants
import com.shield.foodmonitor.utils.Utility
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.food_item_layout.view.*
import kotlinx.android.synthetic.main.monitor_report.*

class MonitorReportFragment: Fragment(), View.OnClickListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.monitor_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        crossIcon.setOnClickListener(this)
        bottomAction.setOnClickListener(this)
        Picasso.with(context).load(arguments?.getString(Constants.Notification.IMAGE_URL)).resize(480, 260).centerCrop().into(foodImage);
        Picasso.with(context).load(arguments?.getString(Constants.Notification.IMAGE_URL)).resize(80, 80).into(foodPic);
        Utility.clearPreferences(context!!)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.crossIcon, R.id.bottomAction -> {
               activity?.finish()
            }
        }
    }
}