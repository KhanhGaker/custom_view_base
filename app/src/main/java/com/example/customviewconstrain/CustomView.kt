package com.example.customviewconstrain

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.customviewconstrain.databinding.CustomViewBinding

class CustomView(context: Context, attrs: AttributeSet): ConstraintLayout(context, attrs) {

    private var binding = CustomViewBinding.inflate(LayoutInflater.from(context),this,true)
    private var imageDrawable: Drawable? = null
    private var title: String? = null
    private var subtitle: String? = null

    init {
        val typedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView,0,0)

        try {
            imageDrawable = typedArray.getDrawable(R.styleable.CustomView_setImageDrawable)
            title = typedArray.getString(R.styleable.CustomView_setTitle)
            subtitle = typedArray.getString(R.styleable.CustomView_setSubTitle)

            binding.imageView.setImageDrawable(imageDrawable)
            binding.titleTextView.text = title
            binding.subtitleTextView.text = subtitle
        }finally {
            typedArray.recycle()
        }

    }

    fun setImageDrawable(drawable: Drawable?){
        binding.imageView.setImageDrawable(drawable)
    }

    fun getImageDrawable(): Drawable? {
        return imageDrawable
    }

    fun setTitle(title: String){
        binding.titleTextView.text = title
    }

    fun getTitle(): String? {
        return title
    }

    fun setSubTitle(subTitle: String?){
        binding.subtitleTextView.text = subTitle
    }

    fun getSubTitle(): String? {
        return subtitle
    }
}