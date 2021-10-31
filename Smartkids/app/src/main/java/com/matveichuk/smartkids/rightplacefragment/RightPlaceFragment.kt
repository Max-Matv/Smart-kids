package com.matveichuk.smartkids.rightplacefragment

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.os.Binder
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.matveichuk.smartkids.R

import com.matveichuk.smartkids.databinding.FragmentRightPlaceBinding

class RightPlaceFragment : Fragment() {

    private var binding: FragmentRightPlaceBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentRightPlaceBinding.inflate(inflater, container, false)
        this.binding = binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.triangleBottom?.setOnLongClickListener(longClickListener)
        binding?.circleBottom?.setOnLongClickListener(longClickListener)
        binding?.rectangleBottom?.setOnLongClickListener(longClickListener)
        binding?.triangleTop?.setOnDragListener(dragListener)
        binding?.rectangleTop?.setOnDragListener(dragListener)
        binding?.circleTop?.setOnDragListener(dragListener)
    }


    @SuppressLint("ObsoleteSdkInt")
    private val longClickListener = View.OnLongClickListener { v ->
        val item = ClipData.Item(v.tag as? CharSequence)

        val dragData =
            ClipData(v.tag as CharSequence, arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN), item)
        val myShadow = CustomDragShadowBuilder(v)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            v.startDragAndDrop(dragData, myShadow, null, 0)
        } else {
            v.startDrag(dragData, myShadow, null, 0)
        }
        true
    }

    private val dragListener = View.OnDragListener { v, event ->

        val receiverView: ImageView = v as ImageView

        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                binding?.comment?.text = "Тяни"
                true
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> {
                true
            }
            DragEvent.ACTION_DRAG_EXITED -> {
                true
            }
            DragEvent.ACTION_DROP -> {
                if (receiverView.tag as String == event.clipDescription.label) {
                    binding?.comment?.text = "Фигура на месте"
                    receiverView.setColorFilter(Color.GREEN)
                } else {
                    binding?.comment?.text = "Ошибка"
                    receiverView.setColorFilter(Color.RED)
                }
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                true
            }
            else -> {
                false
            }
        }
    }

    private class CustomDragShadowBuilder(val v: View) : View.DragShadowBuilder(v) {
        override fun onProvideShadowMetrics(size: Point, touch: Point) {
            size.set(view.width, view.height)
            touch.set(view.width / 2, view.height / 2)
        }

        override fun onDrawShadow(canvas: Canvas) {
            v.draw(canvas)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }


}