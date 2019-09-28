package com.example.myslideshow


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image.*

/**
 * A simple [Fragment] subclass.
 */

val IMG_RES_ID = "IMG_RES_ID"

class ImageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    //companion == staticなメソッド
    companion object {
        fun newInstance(imageResouceId:Int):ImageFragment{
            val bundle = Bundle() //bundle == 束
            bundle.putInt(IMG_RES_ID,imageResouceId) //キー：イメージIDをbundleに格納
            val imageFragment = ImageFragment()
            imageFragment.arguments = bundle
            return imageFragment
        }
    }

    private var imgResId : Int? = null
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        arguments?.let{
            imgResId=it.getInt(IMG_RES_ID)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        imgResId?.let{
            imageView.setImageResource(it)
        }
    }
}