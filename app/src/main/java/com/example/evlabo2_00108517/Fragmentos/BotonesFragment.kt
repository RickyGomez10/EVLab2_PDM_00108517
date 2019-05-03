package com.example.evlabo2_00108517.Fragmentos

import android.app.Activity
import android.content.Context
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.evlabo2_00108517.Fragmentos.Interface.IComunicaFragments
import com.example.evlabo2_00108517.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BotonesFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BotonesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class BotonesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    var btnAtras : Button?= null
    var btnAdelante : Button?= null

    var actividad  = Activity()
    var iCOmunica = object : IComunicaFragments{
        override fun enviarImagen(img: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

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
        val vista : View = inflater.inflate(R.layout.fragment_botones, container, false)

        btnAtras = vista.findViewById(R.id.btn_atras)
        btnAtras?.text = "<"

        btnAdelante = vista.findViewById(R.id.btn_adelante)
        btnAdelante?.text = ">"
        btnAtras?.setOnClickListener{
            iCOmunica.enviarImagen(R.drawable.img1)
        }
        btnAdelante?.setOnClickListener{
            iCOmunica.enviarImagen(R.drawable.img2)

        }

        return vista
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is Activity){
            this.actividad = context
            iCOmunica = this.actividad as IComunicaFragments
        }

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BotonesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BotonesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
