package com.example.baladeyti.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.baladeyti.R
import com.example.baladeyti.activities.EditProfileActivity
import com.google.android.material.imageview.ShapeableImageView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var mSharedPref: SharedPreferences
    lateinit var idfullname: TextView
    lateinit var idUrlImg: ShapeableImageView
    lateinit var idEmail: TextView
    lateinit var idphone: TextView
    lateinit var idcin: TextView
    lateinit var ic_profileSettings: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_user_profile, container, false)

        mSharedPref = activity?.getSharedPreferences("UserPref", Context.MODE_PRIVATE)!!

        idfullname = root.findViewById(R.id.idfullname)

        idUrlImg = root.findViewById(R.id.idUrlImg)

        idEmail = root.findViewById(R.id.idEmail)

        idphone = root.findViewById(R.id.idphone)

        idcin = root.findViewById(R.id.idcin)

        ic_profileSettings = root.findViewById(R.id.ic_profileSettings)

        val email: String = mSharedPref.getString("emailAddress", "Ghazi@gmail.com").toString()
        val firstName: String = mSharedPref.getString("firstName", "Ghazi").toString()
        val phone: String = mSharedPref.getString("phoneNumber", "phone").toString()
        val cin: String = mSharedPref.getString("cin", "cin").toString()

        val picStr: String = mSharedPref.getString("photos", "my photos").toString()
        println(picStr)
        if (picStr != null) {

            val picStrr = "http://192.168.1.7:3000/upload/" + picStr.split("/")[4]
            Glide.with(this).load(Uri.parse(picStrr)).into(idUrlImg)
        } else {

        }

        idfullname.text = firstName
        idEmail.text = email
        idphone.text = phone
        idcin.text = cin

        ic_profileSettings.setOnClickListener {
            Intent(activity, EditProfileActivity::class.java).also {
                startActivity(it)
            }
        }

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}